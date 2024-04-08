package com.springboot.h2.KrushnaProjectTask.service;

import com.springboot.h2.KrushnaProjectTask.model.Transaction;
import com.springboot.h2.KrushnaProjectTask.repositories.TnxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServices {
    @Autowired
    private TnxRepository tnxRepository;


    public void addTransaction(Transaction tnx) {
        if (tnx.getAmount()<0){
            throw new IllegalArgumentException("Amount cannot be less than 0");
        }
        tnxRepository.save(tnx);
    }

    public List<Transaction> getTransactionByAmountRange(double initialRange, double finalRange){
        return tnxRepository.findByAmountBetween(initialRange, finalRange);
    }

    public List<Transaction> getAllTransactionSortByAmount(){
        return tnxRepository.findAllByOrderByAmountAsc();
    }

}
