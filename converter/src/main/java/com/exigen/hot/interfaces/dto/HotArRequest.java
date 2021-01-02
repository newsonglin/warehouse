package com.exigen.hot.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @since 0.16
 */
public class HotArRequest implements Serializable {
    private String sequenceNo;
    private String policyNumber;
    private String receiverId;
    private String receiverName;
    private String receiverTel;
    private String authCode;
    private String receivableSource;
    private String receivableDepartment;
    private String receivableCategory;
    private String receivableType;
    private Date scheduleReceiveDate;
    private String currency;
    private BigDecimal orignalAmount;
    private BigDecimal amountOfNTD;
    private String coverage;
    private String coverageType;
    private String transaction;
    private Date accountPayDate;
    private String moduleCode;
    private String debitT0;
    private String debitT1;
    private String debitT2;
    private String debitDescription;
    private String createUser;
    private String updateUser;
    private String conversionRate;
    private String policySequentialNo;
    private BigDecimal totalPremium;

    public HotArRequest() {
    }

    public HotArRequest(String sequenceNo, String policyNumber, String receiverId, String receiverName, String receiverTel, String authCode, String receivableSource, String receivableDepartment, String receivableCategory, String receivableType, Date scheduleReceiveDate, String currency, BigDecimal orignalAmount, BigDecimal amountOfNTD, String coverage, String coverageType, String transaction, Date accountPayDate, String moduleCode, String debitT0, String debitT1, String debitT2, String debitDescription, String createUser, String updateUser, String conversionRate, String policySequentialNo, BigDecimal totalPremium) {
        this.sequenceNo = sequenceNo;
        this.policyNumber = policyNumber;
        this.receiverId = receiverId;
        this.receiverName = receiverName;
        this.receiverTel = receiverTel;
        this.authCode = authCode;
        this.receivableSource = receivableSource;
        this.receivableDepartment = receivableDepartment;
        this.receivableCategory = receivableCategory;
        this.receivableType = receivableType;
        this.scheduleReceiveDate = scheduleReceiveDate;
        this.currency = currency;
        this.orignalAmount = orignalAmount;
        this.amountOfNTD = amountOfNTD;
        this.coverage = coverage;
        this.coverageType = coverageType;
        this.transaction = transaction;
        this.accountPayDate = accountPayDate;
        this.moduleCode = moduleCode;
        this.debitT0 = debitT0;
        this.debitT1 = debitT1;
        this.debitT2 = debitT2;
        this.debitDescription = debitDescription;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.conversionRate = conversionRate;
        this.policySequentialNo = policySequentialNo;
        this.totalPremium = totalPremium;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getReceivableSource() {
        return receivableSource;
    }

    public void setReceivableSource(String receivableSource) {
        this.receivableSource = receivableSource;
    }

    public String getReceivableDepartment() {
        return receivableDepartment;
    }

    public void setReceivableDepartment(String receivableDepartment) {
        this.receivableDepartment = receivableDepartment;
    }

    public String getReceivableCategory() {
        return receivableCategory;
    }

    public void setReceivableCategory(String receivableCategory) {
        this.receivableCategory = receivableCategory;
    }

    public String getReceivableType() {
        return receivableType;
    }

    public void setReceivableType(String receivableType) {
        this.receivableType = receivableType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getDebitT0() {
        return debitT0;
    }

    public void setDebitT0(String debitT0) {
        this.debitT0 = debitT0;
    }

    public String getDebitT1() {
        return debitT1;
    }

    public void setDebitT1(String debitT1) {
        this.debitT1 = debitT1;
    }

    public String getDebitT2() {
        return debitT2;
    }

    public void setDebitT2(String debitT2) {
        this.debitT2 = debitT2;
    }

    public String getDebitDescription() {
        return debitDescription;
    }

    public void setDebitDescription(String debitDescription) {
        this.debitDescription = debitDescription;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(String conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getPolicySequentialNo() {
        return policySequentialNo;
    }

    public void setPolicySequentialNo(String policySequentialNo) {
        this.policySequentialNo = policySequentialNo;
    }

    public Date getScheduleReceiveDate() {
        return scheduleReceiveDate;
    }

    public void setScheduleReceiveDate(Date scheduleReceiveDate) {
        this.scheduleReceiveDate = scheduleReceiveDate;
    }

    public BigDecimal getOrignalAmount() {
        return orignalAmount;
    }

    public void setOrignalAmount(BigDecimal orignalAmount) {
        this.orignalAmount = orignalAmount;
    }

    public BigDecimal getAmountOfNTD() {
        return amountOfNTD;
    }

    public void setAmountOfNTD(BigDecimal amountOfNTD) {
        this.amountOfNTD = amountOfNTD;
    }

    public Date getAccountPayDate() {
        return accountPayDate;
    }

    public void setAccountPayDate(Date accountPayDate) {
        this.accountPayDate = accountPayDate;
    }

    public BigDecimal getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(BigDecimal totalPremium) {
        this.totalPremium = totalPremium;
    }
}
