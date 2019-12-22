package com.hackerearth.esri.bank.dao;

import com.hackerearth.esri.bank.entity.BankTransactionDetails;
import com.hackerearth.esri.bank.model.RepositoryResponse;
import com.hackerearth.esri.bank.model.RequestParams;
import com.hackerearth.esri.bank.repository.BankAccountManagerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankAccountManagerDao {

    private Logger logger = LoggerFactory.getLogger(BankAccountManagerDao.class);

    @Autowired
    private BankAccountManagerRepository repository;

    public RepositoryResponse createTransactionDetails(BankTransactionDetails bankTransactionDetails){
        RepositoryResponse response = new RepositoryResponse();

        try {
            BankTransactionDetails transactionRecord = repository.save(bankTransactionDetails);
            response.setCode(200);
            response.setMessage("Success");
            response.setTransactionRecord(transactionRecord);
        } catch(Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public List<BankTransactionDetails> getBankTransactionDetails(RequestParams requestParams){
        Pageable page = PageRequest.of(0, requestParams.getSize());
        return repository.findByIdGreaterThanOrderById(requestParams.getStart(), page);
    }

    public RepositoryResponse deleteTransactionDetails(int id){
        RepositoryResponse response = new RepositoryResponse();

        try {
            repository.deleteById(id);
            response.setCode(200);
            response.setMessage("Success");
        } catch(Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }


    public List<BankTransactionDetails> getBankTransactionDetailsByName(RequestParams requestParams, String name){
        Pageable page = PageRequest.of(0, requestParams.getSize());
        return repository.getByAccountNumber(name, requestParams.getStart(), page);
    }
}
