package com.springboot.h2.KrushnaProjectTask.controller;

import com.springboot.h2.KrushnaProjectTask.model.Transaction;
import com.springboot.h2.KrushnaProjectTask.service.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tnx")
public class TransactionController {

    @Autowired
    private TransactionServices transactionServices;


    //    POST request to /txn/add
    //    withn the above request body
    //    which stores the data and return 200 response code.
    //    do all validation for amount fields as it must not be less than 0.

    @PostMapping("/add")
    public ResponseEntity<Void> addTransaction (@RequestBody Transaction transaction){
        try {
            transactionServices.addTransaction(transaction);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }

    //    GET request to /txn/amount/{initial_range}/{final_range}:
    //    returns a collection of all txns whose ampunt is between the initial and the final range supplied
    //    The response code is 200, and the response body is an array of txns in the amount range provided.
    //    In case there are no txns txns return status code 400.

    @GetMapping("/amount/{initialRange}/{finalRange}")
    public ResponseEntity<List<Transaction>> getTransactionByAmountRange(@PathVariable double initialRange, @PathVariable double finalRange){
        List<Transaction> tnxByAmount = transactionServices.getTransactionByAmountRange(initialRange,finalRange);

        if (tnxByAmount.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(tnxByAmount);
    }

}
