package com.exigen.hot.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @since 0.16
 */
public class HotSuspenseAllocation implements Serializable {
    private String writeOffNo;
    private Date logDate;
    private String revCurr;
    private BigDecimal amount;
    private List<HotSuspenseWriteOff> writeOffList;

    public HotSuspenseAllocation() {
    }

    public HotSuspenseAllocation(String writeOffNo, Date logDate, String revCurr, BigDecimal amount, List<HotSuspenseWriteOff> writeOffList) {
        this.writeOffNo = writeOffNo;
        this.logDate = logDate;
        this.revCurr = revCurr;
        this.amount = amount;
        this.writeOffList = writeOffList;
    }

    public String getWriteOffNo() {
        return writeOffNo;
    }

    public void setWriteOffNo(String writeOffNo) {
        this.writeOffNo = writeOffNo;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getRevCurr() {
        return revCurr;
    }

    public void setRevCurr(String revCurr) {
        this.revCurr = revCurr;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<HotSuspenseWriteOff> getWriteOffList() {
        return writeOffList;
    }

    public void setWriteOffList(List<HotSuspenseWriteOff> writeOffList) {
        this.writeOffList = writeOffList;
    }
}
