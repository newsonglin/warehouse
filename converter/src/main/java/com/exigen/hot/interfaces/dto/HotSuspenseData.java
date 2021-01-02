package com.exigen.hot.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class HotSuspenseData implements Serializable {
    private String recPreNo;
    private Date logDate;
    private Date payDate;
    private String PayCurr;
    private BigDecimal amount;
    private BigDecimal recAmount;
    private String payerName;
    private List<ColMoneyInfo> colMoneyInfo;
    private List<PolicyColInfo> policyColInfo;

    public String getRecPreNo() {
        return recPreNo;
    }

    public void setRecPreNo(String recPreNo) {
        this.recPreNo = recPreNo;
    }

    public String getPayCurr() {
        return PayCurr;
    }

    public void setPayCurr(String payCurr) {
        PayCurr = payCurr;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(BigDecimal recAmount) {
        this.recAmount = recAmount;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public List<ColMoneyInfo> getColMoneyInfo() {
        return colMoneyInfo;
    }

    public void setColMoneyInfo(List<ColMoneyInfo> colMoneyInfo) {
        this.colMoneyInfo = colMoneyInfo;
    }

    public List<PolicyColInfo> getPolicyColInfo() {
        return policyColInfo;
    }

    public void setPolicyColInfo(List<PolicyColInfo> policyColInfo) {
        this.policyColInfo = policyColInfo;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}
