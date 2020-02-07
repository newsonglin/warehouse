package com.lin.camel;


import com.google.common.collect.LinkedListMultimap;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.CamelContextHelper;

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

            ctx.start();


/*            Exchange exchange = CamelContextHelper.getMandatoryEndpoint(ctx, "direct:liSonglin").createExchange(ExchangePattern.InOut);
            Exchange out = ctx.createProducerTemplate().send("direct:liSonglin", exchange);
            out.getException().printStackTrace();

            ctx.createProducerTemplate().sendBody("direct:liSonglin", null);

            ctx.createProducerTemplate().sendBodyAndProperty("direct:liSonglin", ExchangePattern.InOut,
                    "", "SEPOWER_PARAMETER", LinkedListMultimap.create());*/

            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
