package com.lin.cxf.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponse {
    @JsonProperty("resultCode")
    private String resultCode;
    @JsonProperty("resultMsg")
    private String resultMsg;
    @JsonProperty("age")
    private int age;

    public CustomerResponse() {
    }

    public CustomerResponse(String resultCode, String resultMsg, int age) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.age = age;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return resultCode + " " + resultMsg + " " + age;
    }
}
