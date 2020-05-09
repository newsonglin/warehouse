package com.lin.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = SOAPBinding.Use.LITERAL) //optional
public interface LinSOAPService {

    @WebMethod
    String getHelloWorldAsString(String name);

}