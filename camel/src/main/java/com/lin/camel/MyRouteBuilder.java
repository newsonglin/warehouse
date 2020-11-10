package com.lin.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * MyRouteBuilder in lin project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2019/6/12
 */
public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("direct:liSonglin")
//                .log("Start here.......")


//        .from("file://d:/tmp/in/?move=./worked/${file:onlyname}_${date:now:yyyyMMddHHmmssSSS}")
//                .process(new MyLogProcessor());

//                .bean(new MyTransformer(), "convert")
//                .choice()
//                    .when(body().contains("HELLO")).to("file://d:/tmp/out")
//                    .when(body().contains("LIN")).to("file://d:/tmp/in/worked/")
//                    .otherwise().log("Do Nothing!!!, just exist")
//                .end();




        //route for SFTP setting， you can verify with this
        from("direct:liSonglin")
                .pollEnrich("file://d:/tmp/in/?move=./worked/${file:onlyname}_${date:now:yyyyMMddHHmmssSSS}", 0)
                .process(new MyLogProcessor());

    }
}
