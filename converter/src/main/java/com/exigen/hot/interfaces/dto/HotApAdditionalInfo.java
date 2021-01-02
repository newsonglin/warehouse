package com.exigen.hot.interfaces.dto;

import java.io.Serializable;

/**
 *
 * @since 0.16
 */
public class HotApAdditionalInfo implements Serializable {
    private HotApFromType from;
    /**
     *Refund transaction ID
     */
    private Long refundId;
    /**
     *  Type of refund( BILLING_ACCOUNT_REFUND,SUSPENSE_REFUND)
     */
    private String refundType;

    public HotApFromType getFrom() {
        return from;
    }

    public void setFrom(HotApFromType from) {
        this.from = from;
    }

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }
}
