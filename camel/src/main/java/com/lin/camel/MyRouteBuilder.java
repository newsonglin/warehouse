package com.lin.camel;

        import org.apache.camel.builder.RouteBuilder;

/**
 * MyRouteBuilder in tower project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2019/6/12
 */
public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://f:/tmp/in/?move=./worked")
                .process(new MyLogProcessor())
                .bean(new MyTransformer(), "convert")
                .to("file://f:/tmp/out");
    }
}
