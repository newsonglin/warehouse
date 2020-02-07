package com.lin.camel;

/**
 * MyTransformer in lin project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2019/6/12
 */
public class MyTransformer {
    public String convert(String body){
        return body.toUpperCase();
    }
}
