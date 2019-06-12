package com.lin.camel;


import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * MainApp in tower project.
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

            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
