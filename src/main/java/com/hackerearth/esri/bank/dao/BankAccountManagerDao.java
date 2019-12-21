package com.hackerearth.esri.bank.dao;

import com.hackerearth.esri.bank.entity.BankTransactionDetails;
import com.hackerearth.esri.bank.model.RepositoryResponse;
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

    public List<BankTransactionDetails> getBankTransactionDetails(int start, int size){

        Pageable page = PageRequest.of(0, size);
        return repository.findByIdGreaterThanOrderById(start, page);
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
}
