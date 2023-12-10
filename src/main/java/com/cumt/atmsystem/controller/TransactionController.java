package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @RequestMapping("/findByTransactionId")
    public Transaction findByTransactionId(Integer id){
        return transactionService.findByTransactionId(id);
    }
    @PostMapping("/addTransaction")
    public String addTransaction(@RequestBody Transaction transaction){
        try {
            transactionService.addTransaction(transaction);
            return "Transaction added successfully.";
        } catch (Exception e) {
            return "Failed to add transaction.";
        }
    }
}
