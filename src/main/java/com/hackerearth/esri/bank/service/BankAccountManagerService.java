package com.hackerearth.esri.bank.service;

import com.hackerearth.esri.bank.dao.BankAccountManagerDao;
import com.hackerearth.esri.bank.model.BankTransactionDetailsResponse;
import com.hackerearth.esri.bank.model.Data;
import com.hackerearth.esri.bank.model.RepositoryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountManagerService {

    private Logger logger = LoggerFactory.getLogger(BankAccountManagerService.class);

    @Autowired
    private BankAccountManagerDao dao;

    public BankTransactionDetailsResponse getBankTransactionDetails(int start_param, int size_param){

         if(size_param == 0){
            size_param = Integer.MAX_VALUE;
          } else {
             start_param = start_param - 1;
         }

            Data data = new Data();
            data.setBankTransactionDetails(dao.getBankTransactionDetails(start_param, size_param));
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
}
