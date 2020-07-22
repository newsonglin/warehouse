package com.lin.soap.endpoint;


import com.lin.soap.server.LinSOAPServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * the Enpoint.publish API doesn't use your existing Tomcat install.
 * It uses its own server and allows you to deploy your web service without having to package and deploy your app.
 * It is especially useful during development (as it speeds up things). Actually, it's extremely handy.
 */
public class LinSOAPPublisher {

    public static void main(String[] args) {

        System.out.println("Start deploying soap server...");
        Endpoint.publish("http://localhost:9999/ws/soap", new LinSOAPServiceImpl());
        System.out.println("Soap server deployed successfully");

    }

}