package com.exigen.hot.interfaces.domian;

/**
 * Created by gtang on 2020/1/7.
 */
public enum PersonType {
    INDIVIDUAL("1"),
    NON_INDIVIDUAL("0");
    private String type;
    private PersonType(String type) {
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
