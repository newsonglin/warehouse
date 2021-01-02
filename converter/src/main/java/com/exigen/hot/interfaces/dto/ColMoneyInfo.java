package com.exigen.hot.interfaces.dto;

import com.exigen.hot.interfaces.domian.PaymentMethod;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ColMoneyInfo implements Serializable {
    private PaymentMethod paymentMet;
    private BigDecimal money;
    private Date checkDate;
    private String checkNo;
    private String micrNo;
    private String checkBank;
    private String checkName;
    private Boolean nonChkSts;
    private String nonChkSou;
    private Boolean spePerSts;

    public PaymentMethod getPaymentMet() {
        return paymentMet;
    }

    public void setPaymentMet(PaymentMethod paymentMet) {
        this.paymentMet = paymentMet;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getMicrNo() {
        return micrNo;
    }

    public void setMicrNo(String micrNo) {
        this.micrNo = micrNo;
    }

    public String getCheckBank() {
        return checkBank;
    }

    public void setCheckBank(String checkBank) {
        this.checkBank = checkBank;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public Boolean getNonChkSts() {
        return nonChkSts;
    }

    public void setNonChkSts(Boolean nonChkSts) {
        this.nonChkSts = nonChkSts;
    }

    public String getNonChkSou() {
        return nonChkSou;
    }

    public void setNonChkSou(String nonChkSou) {
        this.nonChkSou = nonChkSou;
    }

    public Boolean getSpePerSts() {
        return spePerSts;
    }

    public void setSpePerSts(Boolean spePerSts) {
        this.spePerSts = spePerSts;
    }
}
