package com.lin.io;

import java.util.Date;

/**
 * Header in lin project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2018/9/21
 */
public class Header {
    String recordType;
    Date fileDate;

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }
}
