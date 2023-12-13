package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.service.TransactionService;
import com.cumt.atmsystem.service.UserAccountService;
import com.cumt.atmsystem.service.impl.UserAccountServiceImpl;
import com.cumt.atmsystem.tools.TransactionProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private UserAccountServiceImpl userAccountServiceImpl;
    @RequestMapping("/findByTransactionId")
    public Transaction findByTransactionId(Integer id){
        return transactionService.findByTransactionId(id);
    }
    @PostMapping("/addTransaction")
    public ResponseEntity<String> insertTransaction(@RequestBody Transaction transaction) {
        int rowsInserted = transactionService.insertTransaction(transaction);
        if (rowsInserted > 0) {
            return ResponseEntity.ok("Transaction inserted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to insert transaction");
        }
    }
    @PostMapping("/processTransaction")
    public ResponseEntity<String> processTransaction(@RequestBody Transaction transaction) {
        //转账操作两个id不相等
        if(Objects.equals(transaction.getAccountId(), transaction.getTargetAccountId())) {
            switch (transaction.getTransactionType()){
                case "save":
                    return userAccountServiceImpl.saveMoney(transaction) ?  ResponseEntity.badRequest().body("Succeed to save money transaction") : ResponseEntity.badRequest().body("Failed to save money transaction");
                default:
                    return ResponseEntity.badRequest().body("Failed to find this transaction");
            }
        }
        else{
            System.out.println(2);
            return ResponseEntity.badRequest().body("Failed to find this transaction");
        }
    }
}
