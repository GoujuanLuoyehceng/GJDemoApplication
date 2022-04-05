package com.luobo.model;

import java.io.Serializable;

public class SaleResult implements Serializable {
    private String message;

    private boolean isSuccess;

    private int code;

    public SaleResult(String message, boolean isSuccess, int code) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.code = code;
    }

    public SaleResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SaleResult{" +
                "message='" + message + '\'' +
                ", isSuccess=" + isSuccess +
                ", code=" + code +
                '}';
    }
}
