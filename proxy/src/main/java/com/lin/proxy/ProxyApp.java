package com.lin.proxy;

/**
 * This is an application to support https proxy.
 */
public class ProxyApp {
    public static void main(String[] args) {
        (new ProxyServer()).run();
    }
}
