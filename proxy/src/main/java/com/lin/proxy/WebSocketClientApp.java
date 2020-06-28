package com.lin.proxy;

import com.lin.proxy.client.WSClient;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;

/**
 * The web socket client application. It is responsible for send message to remote server and get response from there
 */
public class WebSocketClientApp {
    private static Object waitLock = new Object();
    //    private static final String WEB_SOCKET_URI="ws://miao-bi-sheng-hua.herokuapp.com";
    private static final String WEB_SOCKET_URI="ws://localhost:3000";

    private static void wait4TerminateSignal() {
        synchronized (waitLock) {
            try {
                waitLock.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        WebSocketContainer container;
        Session session = null;
        try {
            container = ContainerProvider.getWebSocketContainer();
            session = container.connectToServer(WSClient.class, URI.create(WEB_SOCKET_URI));

            session.getBasicRemote().sendText("what's this????????????????????");

            wait4TerminateSignal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
