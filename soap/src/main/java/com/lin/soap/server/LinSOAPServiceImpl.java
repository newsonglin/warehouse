package com.lin.soap.server;


import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import java.util.Map;

//Service Implementation
@WebService(endpointInterface = "com.lin.soap.server.LinSOAPService")
public class LinSOAPServiceImpl implements LinSOAPService{
    @Resource
    private WebServiceContext ctx;


    @Override
    public String getHelloWorldAsString(String name) {
        Map<String, Object> map = ctx.getMessageContext();



        for (Object obj : map.entrySet()) {
            System.out.println(obj);
        }
        return "Hello World JAX-WS " + name;
    }

}