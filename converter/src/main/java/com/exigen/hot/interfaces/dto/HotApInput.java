package com.exigen.hot.interfaces.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Data model for sending Account Payable Request
 *
 * @since 0.16
 */
public class HotApInput implements Serializable {
    /**
     * This information is not required by Account Payable(AP) API.
     * It is used when creating a task or calling billing Api to update the suspend state after sending request successfully or failed.
     */
    private HotApAdditionalInfo hotApAdditionalInfo;
    /**
     * This data is required for sending Account Payable(AP) request.
     */
    private List<HotApRequest> hotApRequestList;

    public HotApAdditionalInfo getHotApAdditionalInfo() {
        return hotApAdditionalInfo;
    }

    public void setHotApAdditionalInfo(HotApAdditionalInfo hotApAdditionalInfo) {
        this.hotApAdditionalInfo = hotApAdditionalInfo;
    }

    public List<HotApRequest> getHotApRequestList() {
        return hotApRequestList;
    }

    public void setHotApRequestList(List<HotApRequest> hotApRequestList) {
        this.hotApRequestList = hotApRequestList;
    }
}
