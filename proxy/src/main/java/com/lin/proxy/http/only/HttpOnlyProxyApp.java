package com.lin.proxy.http.only;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * this one is a simple http proxy application. After execution, it will start a http proxy server in local,
 * it doesn't support https
 */
public class HttpOnlyProxyApp extends Thread {
    static public int CONNECT_RETRIES = 5;
    static public int CONNECT_PAUSE = 5;
    static public int TIMEOUT = 50;
    static public int BUFFER_SIZE = 1024;
    static public boolean logging = false;
    static public OutputStream log = null;
    // inbound
    protected Socket socket;
    // optional parent proxy
    static private String parent = null;
    static private int parentPort = -1;

    static public void setParentProxy(String name, int pport) {
        parent = name;
        parentPort = pport;
    }

    // Create a proxy thread on a given socket
    public HttpOnlyProxyApp(Socket s) {
        socket = s;
        start();
    }

    public void writeLog(int c, boolean browser) throws IOException {
        log.write(c);
    }

    public void writeLog(byte[] bytes, int offset, int len, boolean browser) throws IOException {
        for (int i = 0; i < len; i++) writeLog((int) bytes[offset + i], browser);
    }


    // Subclasses may override
    // By default, just log to stdout
    public String processHostName(String url, String host, int port, Socket sock) {
        java.text.DateFormat cal = java.text.DateFormat.getDateTimeInstance();
        System.out.println(cal.format(new java.util.Date()) + " - " + url + " " + sock.getInetAddress() + "<BR>");
        return host;
    }


    // Here is the thread that does the work
    public void run() {
        String line;
        String host;
        int port = 80;
        Socket outbound = null;
        try {
            socket.setSoTimeout(TIMEOUT);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream;
            try {
                // get request line
                line = "";
                host = "";
                int state = 0;
                boolean isSpace;
                while (true) {
                    int c = inputStream.read();

                    //This is the end of input stream, let's jump out
                    if (c == -1) {
                        break;
                    }

                    if (logging) {
                        writeLog(c, true);
                    }


                    isSpace = Character.isWhitespace((char) c);

                    switch (state) {
                        case 0:
                            if (isSpace) {
                                continue;
                            }
                            state = 1;
                        case 1:
                            if (isSpace) {
                                state = 2;
                                continue;
                            }
                            line = line + (char) c;
                            break;
                        case 2:
                            if (isSpace) {
                                continue;
                            }// skip multiple spaces
                            state = 3;
                        case 3:
                            if (isSpace) {
                                state = 4; // doesn't really matter isolate just host name
                                String host0 = host;
                                int n;
                                n = host.indexOf("//");
                                if (n != -1) host = host.substring(n + 2);
                                n = host.indexOf('/');
                                if (n != -1) host = host.substring(0, n);
                                // need to parse possible port from host
                                n = host.indexOf(":");
                                if (n != -1) {
                                    port = Integer.parseInt(host.substring(n + 1));
                                    host = host.substring(0, n);
                                }
                                host = processHostName(host0, host, port, socket);
                                if (parent != null) {
                                    host = parent;
                                    port = parentPort;
                                }
                                int retry = CONNECT_RETRIES;
                                while (retry-- != 0) {
                                    try {
                                        outbound = new Socket(host, port);
                                        break;
                                    } catch (Exception e) {
                                    }
                                    // wait
                                    Thread.sleep(CONNECT_PAUSE);
                                }
                                if (outbound == null) {
                                    break;
                                }
                                outbound.setSoTimeout(TIMEOUT);
                                outputStream = outbound.getOutputStream();
                                outputStream.write(line.getBytes());
                                outputStream.write(' ');
                                outputStream.write(host0.getBytes());
                                outputStream.write(' ');
                                pipe(inputStream, outbound.getInputStream(), outputStream, socket.getOutputStream());
                                break;
                            }
                            host = host + (char) c;
                            break;
                    }
                }
            } catch (IOException e) {
            }

        } catch (Exception e) {
        } finally {
            try {
                socket.close();
            } catch (Exception e1) {
            }
            try {
                outbound.close();
            } catch (Exception e2) {
            }
        }
    }


    void pipe(InputStream is0, InputStream is1,
              OutputStream os0, OutputStream os1) throws IOException {
        try {
            int ir;
            byte bytes[] = new byte[BUFFER_SIZE];
            while (true) {
                try {
                    if ((ir = is0.read(bytes)) > 0) {
                        os0.write(bytes, 0, ir);
                        if (logging) writeLog(bytes, 0, ir, true);
                    } else if (ir < 0)
                        break;
                } catch (InterruptedIOException e) {
                }
                try {
                    if ((ir = is1.read(bytes)) > 0) {
                        os1.write(bytes, 0, ir);
                        if (logging) writeLog(bytes, 0, ir, false);
                    } else if (ir < 0)
                        break;
                } catch (InterruptedIOException e) {
                }
            }
        } catch (Exception e0) {
            System.out.println("Pipe Exception: " + e0);
        }
    }


    static public void startProxy(int port, Class clobj) {
        ServerSocket serverSocket;
        Socket sock;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Class[] sarg = new Class[1];
                Object[] arg = new Object[1];
                sarg[0] = Socket.class;
                try {
                    java.lang.reflect.Constructor cons = clobj.getDeclaredConstructor(sarg);
                    arg[0] = serverSocket.accept();
                    cons.newInstance(arg); // create new HttpProxy or subclass
                } catch (Exception e) {
                    Socket esock = (Socket) arg[0];
                    try {
                        esock.close();
                    } catch (Exception ec) {
                    }
                }
            }
        } catch (IOException e) {
        }
        // if we return something is wrong!
    }


    // Very simple test main
    static public void main(String args[]) {
        System.out.println("Starting proxy on port 9999<BR>");
        HttpOnlyProxyApp.log = System.out;
        HttpOnlyProxyApp.logging = false;
        HttpOnlyProxyApp.startProxy(9999, HttpOnlyProxyApp.class);
    }
}
