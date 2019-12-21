package com.hackerearth.esri.bank.controller;

import com.hackerearth.esri.bank.model.BankTransactionDetailsResponse;
import com.hackerearth.esri.bank.service.BankAccountManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountManagerController {
    private Logger logger = LoggerFactory.getLogger(BankAccountManagerController.class);

    @Autowired
    private BankAccountManagerService service;

    @RequestMapping(value = "/api/getTransactions", method = RequestMethod.GET)
    public BankTransactionDetailsResponse getBankTransactionDetails(
            @RequestParam(required = false, value = "start", defaultValue = "0") Integer start ,
            @RequestParam(required = false, value = "size", defaultValue = "0") Integer page
            ) {

        return service.getBankTransactionDetails(start, page);
    }


}
