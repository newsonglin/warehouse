package com.lin.proxy.client;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;

/**
 * The web socket client class. It is responsible for send message to remote server and get response from there
 */


@ClientEndpoint
public class WSClient {

    @OnOpen
    public void onOpen(Session p) {
        System.out.println("on open..................");
        try {
            p.getBasicRemote().sendText("Hello!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received msg: " + message);
    }
}