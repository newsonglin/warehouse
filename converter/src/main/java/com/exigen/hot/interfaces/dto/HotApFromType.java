package com.exigen.hot.interfaces.dto;

/**
 * Sponsor of AP request
 *
 * @since 0.16
 */
public enum HotApFromType {
    billingRefund("BILLING_REFUND"),
    billingSuspendRefund("BILLING_SUSPENSE_REFUND"),
    claim("CLAIM"),
    commission("COMMISSION"),
    policyEndorsementRp("POLICY_ENDORSEMENT_RP"),
    policyCancel("POLICY_CANCEL");

    private String type;

    HotApFromType(String type) {
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    @Override
    public String toString(){
        return getType();
    }
}
