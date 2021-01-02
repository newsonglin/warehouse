package com.exigen.hot.interfaces.domian;

import java.io.Serializable;

public enum PaymentMethod implements Serializable {
    CASH("01"),
    CHEQUE("02");
    private String type;
    private PaymentMethod(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString(){
        return getType();
    }
}
