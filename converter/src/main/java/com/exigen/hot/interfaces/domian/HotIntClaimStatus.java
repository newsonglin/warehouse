package com.exigen.hot.interfaces.domian;

/**
 * Created by cqchen on 2020/1/8
 */
public enum HotIntClaimStatus {
    OPEN("B"),
    CLOSE("D"),
    CLEAR("P");
    private final String status;
    private HotIntClaimStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status.toString();
    }
}
