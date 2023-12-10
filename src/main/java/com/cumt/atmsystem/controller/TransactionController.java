package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @RequestMapping("/findByTransactionId")
    public String findByTransactionId(Integer id){
        return transactionService.findByTransactionId(id).toString();
    }
}
