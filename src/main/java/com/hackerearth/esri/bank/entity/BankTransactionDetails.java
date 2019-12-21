package com.hackerearth.esri.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "BANK_TRANSACTION_DETAILS")
public class BankTransactionDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber = "";

    @Column(name = "ACCOUNT_DATE")
    private String date = "";

    @Column(name = "TRANSACTION_DETAILS")
    private String transactionDetails = "";

    @Column(name = "VALUE_DATE")
    private String valueDate = "";

    @Column(name = "WITHDRAWAL_AMOUNT")
    private String withdrawalAmount = "";

    @Column(name = "DEPOSIT_AMOUNT")
    private String depositAmount = "";

    @Column(name = "BALANCE_AMOUNT")
    private String balanceAmount = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBalanceAmount() {
        return balanceAmount;
    }

    public String getDate() {
        return date;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public String getTransactionDetails() {
        return transactionDetails;
    }

    public String getValueDate() {
        return valueDate;
    }

    public String getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalanceAmount(String balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public void setWithdrawalAmount(String withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }
}

