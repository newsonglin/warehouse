package com.exigen.hot.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @since 0.16
 */
public class HotSuspenseWriteOff implements Serializable {
    private String suspenseNumber;
    private String paymentMethod;
    private BigDecimal money;
    private Date checkDate;
    private String checkNo;
    private String policyNo;
    private BigDecimal policyMoney;
    private BigDecimal revAmount;

    public String getSuspenseNumber() {
        return suspenseNumber;
    }

    public void setSuspenseNumber(String suspenseNumber) {
        this.suspenseNumber = suspenseNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public BigDecimal getPolicyMoney() {
        return policyMoney;
    }

    public void setPolicyMoney(BigDecimal policyMoney) {
        this.policyMoney = policyMoney;
    }

    public BigDecimal getRevAmount() {
        return revAmount;
    }

    public void setRevAmount(BigDecimal revAmount) {
        this.revAmount = revAmount;
    }
}
