package com.exigen.hot.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Data model for send Account Payable(AP) API
 *
 * @since 0.16
 */
public class HotApRequest implements Serializable {
    private String sequenceNo;
    private String claimNo;
    private String paymentNumber;
    private String policyNumber;
    private String claimPerson;
    private String plateNo;
    private String compulsoryType;
    private String payeeCode;
    private String payeeName;
    private Date paymentSetDate;
    private String paymentCategory;
    private String unitNo;
    private String handleUnit;
    private Date confirmDate;
    private String coverage;
    private String coverageType;
    private String claimType;
    private String transaction;
    private BigDecimal taxRate;
    private BigDecimal claimAmountSum;
    private BigDecimal claimAmountOrigSum;
    private String shareMark;
    private BigDecimal paymentAmountSum;
    private BigDecimal paymentAmountOrigSum;
    private BigDecimal withTax;
    private BigDecimal supPremium;
    private Date forceAmountToDate;
    private String receiverId;
    private String receiverName;
    private String receiverAddress;
    private String receiverTel;
    private String contactId;
    private String contactName;
    private String contactCountry;
    private String contactZip;
    private String contactAddress;
    private String contactTel1;
    private String contactTel2;
    private String contactCellPhone;
    private String contactEmail;
    private String billDepartment;
    private String paymentType;
    private String paymentMethod;
    private String mergeFlag;
    private Date schedulePayDate;
    private String currency;
    private BigDecimal originalAmount;
    private BigDecimal amountOfNTD;
    private String isRemittanceDoc;
    private String remittanceType;
    private Date acceptPaymentDate;
    private String isEmergencyPayment;
    private String moduleCode;
    private String debitT0;
    private String debitT1;
    private String debitT2;
    private String debitT4;
    private String debitDescription;
    private String fromDepartment;
    private String confirmUser;
    private String reviewUser;
    private String receiverBankNo;
    private String receiverBankAccount;
    private String createUser;
    private String updateUser;
    private String accountHolderName;
    private String accountDepartment;
    private BigDecimal paymentDiff;
    private BigDecimal paymentRate;
    private String commissionType;
    private String paymentFlag;
    private BigDecimal incomeTax;
    private String saleCode;
    private String saleCompanyCode;
    private String remittanceScript1;
    private BigDecimal payAmountWithTax;
    private BigDecimal commissionPostage;
    private String commissionDiff;
    private BigDecimal commissionDiffAmount;
    private String creditCardNo;
    private String creditCardBank;
    private String creditCardAuthCode;
    private String creditCardAcquireBank;
    private String paymentSequentialNo;
    private BigDecimal totalPaymentAmount;

    public HotApRequest() {
    }

    public HotApRequest(String sequenceNo, String claimNo, String paymentNumber, String policyNumber, String claimPerson, String plateNo, String compulsoryType, String payeeCode, String payeeName, Date paymentSetDate, String paymentCategory, String unitNo, String handleUnit, Date confirmDate, String coverage, String coverageType, String claimType, String transaction, BigDecimal taxRate, BigDecimal claimAmountSum, BigDecimal claimAmountOrigSum, String shareMark, BigDecimal paymentAmountSum, BigDecimal paymentAmountOrigSum, BigDecimal withTax, BigDecimal supPremium, Date forceAmountToDate, String receiverId, String receiverName, String receiverAddress, String receiverTel, String contactId, String contactName, String contactCountry, String contactZip, String contactAddress, String contactTel1, String contactTel2, String contactCellPhone, String contactEmail, String billDepartment, String paymentType, String paymentMethod, String mergeFlag, Date schedulePayDate, String currency, BigDecimal originalAmount, BigDecimal amountOfNTD, String isRemittanceDoc, String remittanceType, Date acceptPaymentDate, String isEmergencyPayment, String moduleCode, String debitT0, String debitT1, String debitT2, String debitT4, String debitDescription, String fromDepartment, String confirmUser, String reviewUser, String receiverBankNo, String receiverBankAccount, String createUser, String updateUser, String accountHolderName, String accountDepartment, BigDecimal paymentDiff, BigDecimal paymentRate, String commissionType, String paymentFlag, BigDecimal incomeTax, String saleCode, String saleCompanyCode, String remittanceScript1, BigDecimal payAmountWithTax, BigDecimal commissionPostage, String commissionDiff, BigDecimal commissionDiffAmount, String creditCardNo, String creditCardBank, String creditCardAuthCode, String creditCardAcquireBank, String paymentSequentialNo, BigDecimal totalPaymentAmount) {
        this.sequenceNo = sequenceNo;
        this.claimNo = claimNo;
        this.paymentNumber = paymentNumber;
        this.policyNumber = policyNumber;
        this.claimPerson = claimPerson;
        this.plateNo = plateNo;
        this.compulsoryType = compulsoryType;
        this.payeeCode = payeeCode;
        this.payeeName = payeeName;
        this.paymentSetDate = paymentSetDate;
        this.paymentCategory = paymentCategory;
        this.unitNo = unitNo;
        this.handleUnit = handleUnit;
        this.confirmDate = confirmDate;
        this.coverage = coverage;
        this.coverageType = coverageType;
        this.claimType = claimType;
        this.transaction = transaction;
        this.taxRate = taxRate;
        this.claimAmountSum = claimAmountSum;
        this.claimAmountOrigSum = claimAmountOrigSum;
        this.shareMark = shareMark;
        this.paymentAmountSum = paymentAmountSum;
        this.paymentAmountOrigSum = paymentAmountOrigSum;
        this.withTax = withTax;
        this.supPremium = supPremium;
        this.forceAmountToDate = forceAmountToDate;
        this.receiverId = receiverId;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverTel = receiverTel;
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactCountry = contactCountry;
        this.contactZip = contactZip;
        this.contactAddress = contactAddress;
        this.contactTel1 = contactTel1;
        this.contactTel2 = contactTel2;
        this.contactCellPhone = contactCellPhone;
        this.contactEmail = contactEmail;
        this.billDepartment = billDepartment;
        this.paymentType = paymentType;
        this.paymentMethod = paymentMethod;
        this.mergeFlag = mergeFlag;
        this.schedulePayDate = schedulePayDate;
        this.currency = currency;
        this.originalAmount = originalAmount;
        this.amountOfNTD = amountOfNTD;
        this.isRemittanceDoc = isRemittanceDoc;
        this.remittanceType = remittanceType;
        this.acceptPaymentDate = acceptPaymentDate;
        this.isEmergencyPayment = isEmergencyPayment;
        this.moduleCode = moduleCode;
        this.debitT0 = debitT0;
        this.debitT1 = debitT1;
        this.debitT2 = debitT2;
        this.debitT4 = debitT4;
        this.debitDescription = debitDescription;
        this.fromDepartment = fromDepartment;
        this.confirmUser = confirmUser;
        this.reviewUser = reviewUser;
        this.receiverBankNo = receiverBankNo;
        this.receiverBankAccount = receiverBankAccount;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.accountHolderName = accountHolderName;
        this.accountDepartment = accountDepartment;
        this.paymentDiff = paymentDiff;
        this.paymentRate = paymentRate;
        this.commissionType = commissionType;
        this.paymentFlag = paymentFlag;
        this.incomeTax = incomeTax;
        this.saleCode = saleCode;
        this.saleCompanyCode = saleCompanyCode;
        this.remittanceScript1 = remittanceScript1;
        this.payAmountWithTax = payAmountWithTax;
        this.commissionPostage = commissionPostage;
        this.commissionDiff = commissionDiff;
        this.commissionDiffAmount = commissionDiffAmount;
        this.creditCardNo = creditCardNo;
        this.creditCardBank = creditCardBank;
        this.creditCardAuthCode = creditCardAuthCode;
        this.creditCardAcquireBank = creditCardAcquireBank;
        this.paymentSequentialNo = paymentSequentialNo;
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getClaimPerson() {
        return claimPerson;
    }

    public void setClaimPerson(String claimPerson) {
        this.claimPerson = claimPerson;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getCompulsoryType() {
        return compulsoryType;
    }

    public void setCompulsoryType(String compulsoryType) {
        this.compulsoryType = compulsoryType;
    }

    public String getPayeeCode() {
        return payeeCode;
    }

    public void setPayeeCode(String payeeCode) {
        this.payeeCode = payeeCode;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public Date getPaymentSetDate() {
        return paymentSetDate;
    }

    public void setPaymentSetDate(Date paymentSetDate) {
        this.paymentSetDate = paymentSetDate;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getHandleUnit() {
        return handleUnit;
    }

    public void setHandleUnit(String handleUnit) {
        this.handleUnit = handleUnit;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
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

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getClaimAmountSum() {
        return claimAmountSum;
    }

    public void setClaimAmountSum(BigDecimal claimAmountSum) {
        this.claimAmountSum = claimAmountSum;
    }

    public BigDecimal getClaimAmountOrigSum() {
        return claimAmountOrigSum;
    }

    public void setClaimAmountOrigSum(BigDecimal claimAmountOrigSum) {
        this.claimAmountOrigSum = claimAmountOrigSum;
    }

    public String getShareMark() {
        return shareMark;
    }

    public void setShareMark(String shareMark) {
        this.shareMark = shareMark;
    }

    public BigDecimal getPaymentAmountSum() {
        return paymentAmountSum;
    }

    public void setPaymentAmountSum(BigDecimal paymentAmountSum) {
        this.paymentAmountSum = paymentAmountSum;
    }

    public BigDecimal getPaymentAmountOrigSum() {
        return paymentAmountOrigSum;
    }

    public void setPaymentAmountOrigSum(BigDecimal paymentAmountOrigSum) {
        this.paymentAmountOrigSum = paymentAmountOrigSum;
    }

    public BigDecimal getWithTax() {
        return withTax;
    }

    public void setWithTax(BigDecimal withTax) {
        this.withTax = withTax;
    }

    public BigDecimal getSupPremium() {
        return supPremium;
    }

    public void setSupPremium(BigDecimal supPremium) {
        this.supPremium = supPremium;
    }

    public Date getForceAmountToDate() {
        return forceAmountToDate;
    }

    public void setForceAmountToDate(Date forceAmountToDate) {
        this.forceAmountToDate = forceAmountToDate;
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

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactCountry() {
        return contactCountry;
    }

    public void setContactCountry(String contactCountry) {
        this.contactCountry = contactCountry;
    }

    public String getContactZip() {
        return contactZip;
    }

    public void setContactZip(String contactZip) {
        this.contactZip = contactZip;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactTel1() {
        return contactTel1;
    }

    public void setContactTel1(String contactTel1) {
        this.contactTel1 = contactTel1;
    }

    public String getContactTel2() {
        return contactTel2;
    }

    public void setContactTel2(String contactTel2) {
        this.contactTel2 = contactTel2;
    }

    public String getContactCellPhone() {
        return contactCellPhone;
    }

    public void setContactCellPhone(String contactCellPhone) {
        this.contactCellPhone = contactCellPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getBillDepartment() {
        return billDepartment;
    }

    public void setBillDepartment(String billDepartment) {
        this.billDepartment = billDepartment;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(String mergeFlag) {
        this.mergeFlag = mergeFlag;
    }

    public Date getSchedulePayDate() {
        return schedulePayDate;
    }

    public void setSchedulePayDate(Date schedulePayDate) {
        this.schedulePayDate = schedulePayDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public BigDecimal getAmountOfNTD() {
        return amountOfNTD;
    }

    public void setAmountOfNTD(BigDecimal amountOfNTD) {
        this.amountOfNTD = amountOfNTD;
    }

    public String getIsRemittanceDoc() {
        return isRemittanceDoc;
    }

    public void setIsRemittanceDoc(String isRemittanceDoc) {
        this.isRemittanceDoc = isRemittanceDoc;
    }

    public String getRemittanceType() {
        return remittanceType;
    }

    public void setRemittanceType(String remittanceType) {
        this.remittanceType = remittanceType;
    }

    public Date getAcceptPaymentDate() {
        return acceptPaymentDate;
    }

    public void setAcceptPaymentDate(Date acceptPaymentDate) {
        this.acceptPaymentDate = acceptPaymentDate;
    }

    public String getIsEmergencyPayment() {
        return isEmergencyPayment;
    }

    public void setIsEmergencyPayment(String isEmergencyPayment) {
        this.isEmergencyPayment = isEmergencyPayment;
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

    public String getDebitT4() {
        return debitT4;
    }

    public void setDebitT4(String debitT4) {
        this.debitT4 = debitT4;
    }

    public String getDebitDescription() {
        return debitDescription;
    }

    public void setDebitDescription(String debitDescription) {
        this.debitDescription = debitDescription;
    }

    public String getFromDepartment() {
        return fromDepartment;
    }

    public void setFromDepartment(String fromDepartment) {
        this.fromDepartment = fromDepartment;
    }

    public String getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser;
    }

    public String getReviewUser() {
        return reviewUser;
    }

    public void setReviewUser(String reviewUser) {
        this.reviewUser = reviewUser;
    }

    public String getReceiverBankNo() {
        return receiverBankNo;
    }

    public void setReceiverBankNo(String receiverBankNo) {
        this.receiverBankNo = receiverBankNo;
    }

    public String getReceiverBankAccount() {
        return receiverBankAccount;
    }

    public void setReceiverBankAccount(String receiverBankAccount) {
        this.receiverBankAccount = receiverBankAccount;
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

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountDepartment() {
        return accountDepartment;
    }

    public void setAccountDepartment(String accountDepartment) {
        this.accountDepartment = accountDepartment;
    }

    public BigDecimal getPaymentDiff() {
        return paymentDiff;
    }

    public void setPaymentDiff(BigDecimal paymentDiff) {
        this.paymentDiff = paymentDiff;
    }

    public BigDecimal getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(BigDecimal paymentRate) {
        this.paymentRate = paymentRate;
    }

    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }

    public String getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(String paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public String getSaleCompanyCode() {
        return saleCompanyCode;
    }

    public void setSaleCompanyCode(String saleCompanyCode) {
        this.saleCompanyCode = saleCompanyCode;
    }

    public String getRemittanceScript1() {
        return remittanceScript1;
    }

    public void setRemittanceScript1(String remittanceScript1) {
        this.remittanceScript1 = remittanceScript1;
    }

    public BigDecimal getPayAmountWithTax() {
        return payAmountWithTax;
    }

    public void setPayAmountWithTax(BigDecimal payAmountWithTax) {
        this.payAmountWithTax = payAmountWithTax;
    }

    public BigDecimal getCommissionPostage() {
        return commissionPostage;
    }

    public void setCommissionPostage(BigDecimal commissionPostage) {
        this.commissionPostage = commissionPostage;
    }

    public String getCommissionDiff() {
        return commissionDiff;
    }

    public void setCommissionDiff(String commissionDiff) {
        this.commissionDiff = commissionDiff;
    }

    public BigDecimal getCommissionDiffAmount() {
        return commissionDiffAmount;
    }

    public void setCommissionDiffAmount(BigDecimal commissionDiffAmount) {
        this.commissionDiffAmount = commissionDiffAmount;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getCreditCardBank() {
        return creditCardBank;
    }

    public void setCreditCardBank(String creditCardBank) {
        this.creditCardBank = creditCardBank;
    }

    public String getCreditCardAuthCode() {
        return creditCardAuthCode;
    }

    public void setCreditCardAuthCode(String creditCardAuthCode) {
        this.creditCardAuthCode = creditCardAuthCode;
    }

    public String getCreditCardAcquireBank() {
        return creditCardAcquireBank;
    }

    public void setCreditCardAcquireBank(String creditCardAcquireBank) {
        this.creditCardAcquireBank = creditCardAcquireBank;
    }

    public String getPaymentSequentialNo() {
        return paymentSequentialNo;
    }

    public void setPaymentSequentialNo(String paymentSequentialNo) {
        this.paymentSequentialNo = paymentSequentialNo;
    }

    public BigDecimal getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }
}
