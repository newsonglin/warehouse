package com.lin.cxf.client;

import com.lin.cxf.vo.Customer;
import com.lin.cxf.vo.CustomerResponse;
import com.lin.cxf.vo.Headers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface CustomerClientService {
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/processCustomer")
    CustomerResponse processCustomer(String  body, @BeanParam Headers headers);
}
