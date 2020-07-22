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
            ctx.addRoutes(routeBuilder);
//addRoutes(ctx);
            ctx.start();
            System.out.println("camel context will be started");
            triggerRoute(ctx);
            Thread.sleep( 60 * 1000);
            System.out.println("camel context will be stopped after period of time");
            ctx.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Add a route to camel context dynamically
     * @param ctx the camel runtime context
     * @throws Exception if error occurs
     */

    private static void addRoutes(CamelContext ctx) throws Exception {
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
    }

    /**
     * Send message to route start(from) point to start route
     * @param ctx the camel runtime context
     */
    private static void triggerRoute(CamelContext ctx) {
        Exchange exchange = CamelContextHelper.getMandatoryEndpoint(ctx, "direct:liSonglin").createExchange(ExchangePattern.InOut);
        System.out.println("Try to start router from point direct:liSonglin");
        Exchange out = ctx.createProducerTemplate().send("direct:liSonglin", exchange);
        System.out.println(out.getProperty("CamelBatchSize"));
//        out.getException().printStackTrace();

//        ctx.createProducerTemplate().sendBody("direct:liSonglin", null);

//        ctx.createProducerTemplate().sendBodyAndProperty("direct:liSonglin", ExchangePattern.InOut, "", "SEPOWER_PARAMETER", LinkedListMultimap.create());
    }


}
