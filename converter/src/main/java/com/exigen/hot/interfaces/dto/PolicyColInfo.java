package com.exigen.hot.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PolicyColInfo implements Serializable {
    private String policyNo;
    private BigDecimal policyMon;
    private String remark;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public BigDecimal getPolicyMon() {
        return policyMon;
    }

    public void setPolicyMon(BigDecimal policyMon) {
        this.policyMon = policyMon;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
