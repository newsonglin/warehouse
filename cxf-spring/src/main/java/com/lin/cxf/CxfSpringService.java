package com.lin.cxf;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

        File file = new File(f.getAbsolutePath()+"/IntegrationIntroduction_ForHotai.pdf");
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                .build();
    }
}
