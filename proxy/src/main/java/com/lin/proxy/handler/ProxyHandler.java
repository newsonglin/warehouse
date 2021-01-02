package com.lin.proxy.handler;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProxyHandler extends Thread {
    public static final Pattern CONNECT_PATTERN = Pattern.compile("CONNECT (.+):(.+) HTTP/(1\\.[01])", Pattern.CASE_INSENSITIVE);
    private final Socket clientSocket;
    private boolean previousWasR = false;

    public ProxyHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            String request = readLine(clientSocket);
            System.out.println("========================="+request);
            Matcher matcher = CONNECT_PATTERN.matcher(request);
            if (matcher.matches()) {
                String header;
                do {
                    header = readLine(clientSocket);
                } while (!"".equals(header));
                OutputStreamWriter clientOutputStreamWriter = new OutputStreamWriter(clientSocket.getOutputStream(), "ISO-8859-1");

                final Socket forwardSocket;
                try {
                    //This is target web socket
                    forwardSocket = new Socket(matcher.group(1), Integer.parseInt(matcher.group(2)));

                    System.out.println("forwardSocket==========server======" + matcher.group(1));
                    System.out.println("forwardSocket==========port======" + matcher.group(2));
                    System.out.println("forwardSocket================" + forwardSocket);
                } catch (IOException | NumberFormatException e) {
                    e.printStackTrace();  // TODO: implement catch

                    //If error occurs, write error back to client and show to the end user
                    clientOutputStreamWriter.write("HTTP/" + matcher.group(3) + " 502 Bad Gateway\r\n");
                    clientOutputStreamWriter.write("Proxy-agent: Simple/0.1\r\n");
                    clientOutputStreamWriter.write("\r\n");
                    clientOutputStreamWriter.flush();
                    return;
                }

                try {
                    //If open target socket successfully, send a connection established message to client, this is applied for https only
                    clientOutputStreamWriter.write("HTTP/" + matcher.group(3) + " 200 Connection established\r\n");
                    clientOutputStreamWriter.write("Proxy-agent: Simple/0.1\r\n");
                    clientOutputStreamWriter.write("\r\n");
                    clientOutputStreamWriter.flush();

                    //Start another thread, transfer target web server response to client
                    Thread remoteToClient = new Thread() {
                        @Override
                        public void run() {
                            forwardData(forwardSocket, clientSocket);
                        }
                    };
                    remoteToClient.start();


                    //Current main thread, transfer client request to target web server
                    try {
                        if (previousWasR) {
                            int read = clientSocket.getInputStream().read();
                            if (read != -1) {
                                if (read != '\n') {
                                    forwardSocket.getOutputStream().write(read);
                                }
                                forwardData(clientSocket, forwardSocket);
                            } else {
                                if (!forwardSocket.isOutputShutdown()) {
                                    forwardSocket.shutdownOutput();
                                }
                                if (!clientSocket.isInputShutdown()) {
                                    clientSocket.shutdownInput();
                                }
                            }
                        } else {
                            forwardData(clientSocket, forwardSocket);
                        }
                    } finally {
                        try {
                            remoteToClient.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();  // TODO: implement catch
                        }
                    }
                } finally {
                    forwardSocket.close();
                }
            } else {
                processHttp(request);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * proxy http request from client side.
     */
    private void processHttp(String requestLine) throws Exception {

        this.clientSocket.setSoTimeout(2000);

        // retrieve the host and port info from the status-line
        InetSocketAddress serverAddr = getConnectInfo(requestLine);
        Socket serverSocket = new Socket(serverAddr.getAddress(),  serverAddr.getPort());

        Forwarder clientFW = new Forwarder(clientSocket.getInputStream(),
                serverSocket.getOutputStream());
        Thread clientForwarderThread = new Thread(clientFW, "ClientForwarder");
        clientForwarderThread.start();
        send200(clientSocket);
        Forwarder serverFW = new Forwarder(serverSocket.getInputStream(),
                clientSocket.getOutputStream());
        serverFW.run();
        clientForwarderThread.join();

    }
    private void send200(Socket clientSocket) throws IOException {
        OutputStream out = clientSocket.getOutputStream();
        PrintWriter pout = new PrintWriter(out);

        pout.println("HTTP/1.1 200 OK");
        pout.println();
        pout.flush();
    }


    /* Reads from the given InputStream and writes to the given OutputStream */
    static class Forwarder implements Runnable
    {
        private final InputStream in;
        private final OutputStream os;

        Forwarder(InputStream in, OutputStream os) {
            this.in = in;
            this.os = os;
        }

        @Override
        public void run() {
            try {
                byte[] ba = new byte[1024];
                int count;
                while ((count = in.read(ba)) != -1) {
                    os.write(ba, 0, count);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
     * This method retrieves the hostname and port of the tunnel destination
     * from the request line.
     * @param connectStr
     *        of the form: <i>CONNECT server-name:server-port HTTP/1.x
     */
    static InetSocketAddress getConnectInfo(String connectStr)    throws Exception
    {
        try {
            int starti = connectStr.indexOf(' ');
            int endi = connectStr.lastIndexOf(' ');
            String urlStr = connectStr.substring(starti+1, endi).trim();
            URL url = new URL(urlStr);
            String host = url.getHost();
            int port = url.getPort();
            System.out.println("name=="+host);
            System.out.println("port=="+port);
            return new InetSocketAddress(host, port);
        } catch (Exception e) {
            System.out.println("Proxy received a request: " + connectStr);
            throw e;
        }
    }

    /**
     * Forward data from socket to socket
     *
     * @param inputSocket  the from socket
     * @param outputSocket the to socket
     */
    private static void forwardData(Socket inputSocket, Socket outputSocket) {
        try {
            InputStream inputStream = inputSocket.getInputStream();
            try {
                OutputStream outputStream = outputSocket.getOutputStream();
                try {
                    byte[] buffer = new byte[4096];
                    int read;
                    do {
                        read = inputStream.read(buffer);
                        if (read > 0) {
                            outputStream.write(buffer, 0, read);
                            if (inputStream.available() < 1) {
                                outputStream.flush();
                            }
                        }
                    } while (read >= 0);
                } finally {
                    if (!outputSocket.isOutputShutdown()) {
                        outputSocket.shutdownOutput();
                    }
                }
            } finally {
                if (!inputSocket.isInputShutdown()) {
                    inputSocket.shutdownInput();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read a line message from the target socket
     *
     * @param socket the target socket to read message from
     * @return a string format of one line message
     * @throws IOException if read error occurs
     */
    private String readLine(Socket socket) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int next;
        readerLoop:
        while ((next = socket.getInputStream().read()) != -1) {
            if (previousWasR && next == '\n') {
                previousWasR = false;
                continue;
            }
            previousWasR = false;
            switch (next) {
                case '\r':
                    previousWasR = true;
                    break readerLoop;
                case '\n':
                    break readerLoop;
                default:
                    byteArrayOutputStream.write(next);
                    break;
            }
        }
        return byteArrayOutputStream.toString("ISO-8859-1");
    }
}
