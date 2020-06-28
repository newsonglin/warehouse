package com.lin.proxy;

import com.lin.proxy.handler.ProxyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProxyServer extends Thread {
    public ProxyServer() {
        super("ProxyServer Thread");
    }

    @Override
    public void run() {
        System.out.println("Start proxy server at port 9999.......");
        ServerSocket serverSocket;
        Socket clientSocket;
        try {
            serverSocket = new ServerSocket(9999);
            while ((clientSocket = serverSocket.accept()) != null) {
                (new ProxyHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
