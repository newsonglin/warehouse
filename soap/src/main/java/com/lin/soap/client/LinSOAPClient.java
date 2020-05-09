package com.lin.soap.client;

import com.lin.soap.server.LinSOAPService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;


public class LinSOAPClient {

    private static final String WS_URL = "http://localhost:9999/ws/soap?wsdl";

    public static void main(String[] args) throws Exception {

        URL url = new URL(WS_URL);
        QName qname = new QName("http://server.soap.lin.com/", "LinSOAPServiceImplService");

        Service service = Service.create(url, qname);

        //Set SOAP header here
        HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        service.setHandlerResolver(handlerResolver);

        LinSOAPService hello = service.getPort(LinSOAPService.class);

        System.out.println(hello.getHelloWorldAsString("Li SongLin"));

    }
}