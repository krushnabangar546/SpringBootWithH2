package com.springboot.h2.KrushnaProjectTask.controller;

import com.springboot.h2.KrushnaProjectTask.model.Transaction;
import com.springboot.h2.KrushnaProjectTask.service.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sort")
public class SortController {
    @Autowired
    private TransactionServices transactionServices;


    //    GET request to /sort/amount:
    //    returns a collection of all txns sorted by their amount
    //    The response code is 200 and the response body is an array of the txns sorted in ascending order of amount.

    @GetMapping("/amount")
    public ResponseEntity<List<Transaction>> getAllTransactionSortedByAmount(){
        List<Transaction> tnxSortedAmt = transactionServices.getAllTransactionSortByAmount();
        return ResponseEntity.ok(tnxSortedAmt);
    }

}
