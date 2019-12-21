package com.hackerearth.esri.bank.controller;

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

    @RequestMapping(value = "/api/createTransactions", method = RequestMethod.GET)
    public BankTransactionDetailsResponse createBankTransactionDetailsRecord(
            @RequestParam(required = false, value = "start", defaultValue = "0") Integer start ,
            @RequestParam(required = false, value = "size", defaultValue = "0") Integer page
    ) {

        return service.getBankTransactionDetails(start, page);
    }

    @RequestMapping(value = "/api/getTransactions", method = RequestMethod.GET)
    public BankTransactionDetailsResponse getBankTransactionDetails(
            @RequestParam(required = false, value = "start", defaultValue = "0") Integer start ,
            @RequestParam(required = false, value = "size", defaultValue = "0") Integer page
            ) {

        return service.getBankTransactionDetails(start, page);
    }

    @RequestMapping(value = "/api/getTransactionsByName", method = RequestMethod.GET)
    public BankTransactionDetailsResponse getBankTransactionDetailsByName(
            @RequestParam(required = false, value = "start", defaultValue = "0") Integer start ,
            @RequestParam(required = false, value = "size", defaultValue = "0") Integer page
    ) {

        return service.getBankTransactionDetails(start, page);
    }

    @RequestMapping(value = "/api/updateTransactions", method = RequestMethod.GET)
    public BankTransactionDetailsResponse updateBankTransactionDetails(
            @RequestParam(required = false, value = "start", defaultValue = "0") Integer start ,
            @RequestParam(required = false, value = "size", defaultValue = "0") Integer page
    ) {

        return service.getBankTransactionDetails(start, page);
    }

    @RequestMapping(value = "/api/deleteTransaction/{id}", method = RequestMethod.DELETE)
    public BankTransactionDetailsResponse deleteTransactionRecord(
            @PathVariable(value = "id") int id
    ) {
        return service.deleteBankTransactionDetails(id);
    }

}
