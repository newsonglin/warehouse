package com.lin.cxf;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * CxfSpringService in tower project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2019/5/16
 */

@Service
@Path("/cxf-spring")
public class CxfSpringService {

    @GET
    @Path("/{input}")
    @Produces("text/html")
    public String reply(@PathParam("input") String input){
        return "<html> <body>Hello, I got your word <font color='red'>"+ input +"</font> </body> </html>";
    }
}
