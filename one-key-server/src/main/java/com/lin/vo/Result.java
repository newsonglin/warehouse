package com.lin.vo;

import com.lin.constants.Status;

/**
 * This file was created by Songlin Li on 2015/11/03.
 * It is used for command execution result record
 */
public class Result {
    private Status status;
    private String message;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
