package com.lin.cxf;

import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * CxfSpringService in lin project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2019/5/16
 */

@Service
@Path("/cxf-spring")
public class CxfSpringService {

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/processCustomer")
    public Response processCustomer(String body, @HeaderParam("requestHeader01") String requestHeader01, @HeaderParam("Accept") String accept){
        System.out.println("The request header 'requestHeader01' value: " + requestHeader01);
        System.out.println("The request header 'Accept' value: " + accept);
        System.out.println(body);
        String json ="{\"resultCode\":\"000\", \"resultMsg\":\"Hello World\", \"age\":"+12+"}";
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }


    @GET
    @Path("/reply/{input}")
    @Produces("text/html")
    public String reply(@PathParam("input") String input){
        return "<html> <body>Hello, I got your word <font color='red'>"+ input +"</font> </body> </html>";
    }


    @GET
    @Path("download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(){

        final File f = new File(CxfSpringService.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        File file = new File(f.getAbsolutePath()+"/IntegrationIntroduction_Forxxx.pdf");
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                .build();
    }
}
