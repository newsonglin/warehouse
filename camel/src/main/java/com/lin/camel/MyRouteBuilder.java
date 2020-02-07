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
        from("file://d:/tmp/in/?move=./worked/${file:onlyname}_${date:now:yyyyMMddHHmmssSSS}")
                .process(new MyLogProcessor())
                .bean(new MyTransformer(), "convert")
                .to("file://d:/tmp/out");



/*        //route for SFTP setting， you can verify with this
        from("direct:liSonglin")
                .pollEnrich("sftp://dev2gliftp01-sftp.eqxdev.exigengroup.com:22/upload/cluster/DHMO/filedrop?username=glic&password=XXXXXXXXXXXXXX&include=^CRJ[C,M]06\\.\\d{8}.TXT", 5000)
                .process(new MyLogProcessor());*/

    }
}
