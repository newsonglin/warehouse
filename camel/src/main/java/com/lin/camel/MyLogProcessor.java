package com.lin.camel;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * MyLogProcessor in tower project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2019/6/12
 */
public class MyLogProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Processing message with body"+exchange.getIn().getBody(String.class));
    }
}
