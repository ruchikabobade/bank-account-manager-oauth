package com.hackerearth.esri.bank.service;

import com.hackerearth.esri.bank.dao.BankAccountManagerDao;
import com.hackerearth.esri.bank.entity.BankTransactionDetails;
import com.hackerearth.esri.bank.model.BankTransactionDetailsResponse;
import com.hackerearth.esri.bank.model.Data;
import com.hackerearth.esri.bank.model.RepositoryResponse;
import com.hackerearth.esri.bank.model.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountManagerService {

    private Logger logger = LoggerFactory.getLogger(BankAccountManagerService.class);

    @Autowired
    private BankAccountManagerDao dao;

    public BankTransactionDetailsResponse getBankTransactionDetails(int start_param, int size_param){
        RequestParams requestParams = getRequestParams(start_param, size_param);

        Data data = new Data();
        data.setBankTransactionDetails(dao.getBankTransactionDetails(requestParams));
        BankTransactionDetailsResponse response = new BankTransactionDetailsResponse();
        response.setCode(200);
        response.setMessage("Success");
        response.setData(data);
        return response;
    }

    public BankTransactionDetailsResponse deleteBankTransactionDetails(int id){
        Data data = new Data();
        BankTransactionDetailsResponse response = new BankTransactionDetailsResponse();
        RepositoryResponse repositoryResponse = dao.deleteTransactionDetails(id);
        response.setCode(repositoryResponse.getCode());
        response.setMessage(repositoryResponse.getMessage());
        response.setData(data);
        return response;
    }

    public BankTransactionDetailsResponse updateBankTransactionDetails(BankTransactionDetails bankTransactionDetails){
        Data data = new Data();
        BankTransactionDetailsResponse response = new BankTransactionDetailsResponse();
        List<BankTransactionDetails> transactionRecords = new ArrayList<>();
        RepositoryResponse repositoryResponse = dao.createTransactionDetails(bankTransactionDetails);
        response.setCode(repositoryResponse.getCode());
        response.setMessage(repositoryResponse.getMessage());
        transactionRecords.add(repositoryResponse.getTransactionRecord());
        data.setBankTransactionDetails(transactionRecords);
        response.setData(data);
        return response;

    }


    public BankTransactionDetailsResponse getBankTransactionDetailsByAccountNumber(int start_param, int size_param, String accountNumber){


        RequestParams requestParams = getRequestParams(start_param, size_param);
        Data data = new Data();
        data.setBankTransactionDetails(dao.getBankTransactionDetailsByName(requestParams, accountNumber));
        BankTransactionDetailsResponse response = new BankTransactionDetailsResponse();
        response.setCode(200);
        response.setMessage("Success");
        response.setData(data);
        return response;
    }


    public RequestParams getRequestParams(int start, int size){
        RequestParams request = new RequestParams();

        if(size == 0){
            size = Integer.MAX_VALUE;
        } else {
            start = start - 1;
        }

        request.setSize(size);
        request.setStart(start);
        return request;
    }
}
