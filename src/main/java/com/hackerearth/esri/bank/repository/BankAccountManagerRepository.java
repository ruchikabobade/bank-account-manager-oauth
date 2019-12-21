package com.hackerearth.esri.bank.repository;

import com.hackerearth.esri.bank.entity.BankTransactionDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountManagerRepository extends PagingAndSortingRepository<BankTransactionDetails, Integer> {

    public List<BankTransactionDetails> findByIdGreaterThanOrderById(@Param("id") int id, Pageable pageable);

}
