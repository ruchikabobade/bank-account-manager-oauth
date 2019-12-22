package com.hackerearth.esri.bank.model;

import com.hackerearth.esri.bank.entity.BankTransactionDetails;

public class RepositoryResponse {
    private int code = 0;
    private String message = "";
    private BankTransactionDetails transactionRecord = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BankTransactionDetails getTransactionRecord() {
        return transactionRecord;
    }

    public void setTransactionRecord(BankTransactionDetails transactionRecord) {
        this.transactionRecord = transactionRecord;
    }
}
