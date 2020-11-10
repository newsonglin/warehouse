package com.lin.cxf.vo;

import javax.ws.rs.HeaderParam;

public class Headers {

    @HeaderParam("requestHeader01")
    private String header01;

    public Headers() {
    }

    public String getHeader01() {
        return header01;
    }

    public void setHeader01(String header01) {
        this.header01 = header01;
    }
}
