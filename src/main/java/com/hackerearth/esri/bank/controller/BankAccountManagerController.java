package com.hackerearth.esri.bank.controller;

import com.hackerearth.esri.bank.entity.BankTransactionDetails;
import com.hackerearth.esri.bank.model.BankTransactionDetailsResponse;
import com.hackerearth.esri.bank.service.BankAccountManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankAccountManagerController {
    private Logger logger = LoggerFactory.getLogger(BankAccountManagerController.class);

    @Autowired
    private BankAccountManagerService service;

    @RequestMapping(value = "/api/createTransactions", method = RequestMethod.POST)
    public BankTransactionDetailsResponse createBankTransactionDetailsRecord(
            @RequestBody BankTransactionDetails transactionRecord
    ) {

        return service.updateBankTransactionDetails(transactionRecord);
    }

    @RequestMapping(value = "/api/getTransactions", method = RequestMethod.GET)
    public BankTransactionDetailsResponse getBankTransactionDetails(
            @RequestParam(required = false, value = "start", defaultValue = "0") Integer start ,
            @RequestParam(required = false, value = "size", defaultValue = "0") Integer page
            ) {

        return service.getBankTransactionDetails(start, page);
    }

    @RequestMapping(value = "/api/getTransactionsByAccountNumber", method = RequestMethod.GET)
    public BankTransactionDetailsResponse getBankTransactionDetailsByName(
            @RequestParam(required = false, value = "start", defaultValue = "0") Integer start ,
            @RequestParam(required = false, value = "size", defaultValue = "0") Integer page,
            @RequestParam(required = false, value = "accountNumber", defaultValue = "0") String accountNumber
    ) {

        return service.getBankTransactionDetailsByAccountNumber(start, page, accountNumber);
    }

    @RequestMapping(value = "/api/updateTransactions", method = RequestMethod.PUT)
    public BankTransactionDetailsResponse updateBankTransactionDetails(
            @RequestBody BankTransactionDetails transactionRecord
            ) {
        return service.updateBankTransactionDetails(transactionRecord);
    }

    @RequestMapping(value = "/api/deleteTransaction/{id}", method = RequestMethod.DELETE)
    public BankTransactionDetailsResponse deleteTransactionRecord(
            @PathVariable(value = "id") int id
    ) {
        return service.deleteBankTransactionDetails(id);
    }

}
