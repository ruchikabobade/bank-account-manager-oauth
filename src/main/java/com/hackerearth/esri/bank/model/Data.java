package com.hackerearth.esri.bank.model;

import com.hackerearth.esri.bank.entity.BankTransactionDetails;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<BankTransactionDetails> bankTransactionDetails = new ArrayList<>();

    public List<BankTransactionDetails> getBankTransactionDetails() {
        return bankTransactionDetails;
    }

    public void setBankTransactionDetails(List<BankTransactionDetails> bankTransactionDetails) {
        this.bankTransactionDetails = bankTransactionDetails;
    }
}
