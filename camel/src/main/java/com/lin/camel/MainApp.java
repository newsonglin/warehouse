package com.lin.camel;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.CamelContextHelper;

import java.util.concurrent.atomic.AtomicReference;

/**
 * MainApp in lin project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2019/6/12
 */
public class MainApp {


    public static void main(String[] args) {

        MyRouteBuilder routeBuilder = new MyRouteBuilder();
        CamelContext ctx = new DefaultCamelContext();

        try {
//            ctx.addRoutes(routeBuilder);

            AtomicReference<String> size = new AtomicReference<>("");
            ctx.addRoutes(new RouteBuilder() {
                public void configure() {
                    from("direct:liSonglin").log("start").
                    from("file://d:/tmp/in/?noop=true")
                            .process(exchange -> {
                                System.out.println("size is #" + exchange.getProperty("CamelBatchSize"));
                                size.set(String.valueOf(exchange.getProperty("CamelBatchSize")));

                            }).log("aaa");
                }
            });

            ctx.start();
//            triggerRoute(ctx);
            System.out.print("=====================" + size.get());
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void triggerRoute(CamelContext ctx) {
        Exchange exchange = CamelContextHelper.getMandatoryEndpoint(ctx, "direct:liSonglin").createExchange(ExchangePattern.InOut);
        Exchange out = ctx.createProducerTemplate().send("direct:liSonglin", exchange);
        System.out.println(out.getProperty("CamelBatchSize"));
        out.getException().printStackTrace();

//        ctx.createProducerTemplate().sendBody("direct:liSonglin", null);

//        ctx.createProducerTemplate().sendBodyAndProperty("direct:liSonglin", ExchangePattern.InOut, "", "SEPOWER_PARAMETER", LinkedListMultimap.create());
    }


}
