package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.service.TransactionService;
import com.cumt.atmsystem.service.UserAccountService;
import com.cumt.atmsystem.service.impl.UserAccountServiceImpl;
import com.cumt.atmsystem.tools.TransactionProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private UserAccountServiceImpl userAccountServiceImpl;
    @RequestMapping("/findByTransactionId")
    public Transaction findByTransactionId(String id){
        return transactionService.findByTransactionId(id);
    }
    @RequestMapping("/findByAccountId")
    public List<Transaction> findByAccountId(String id){
        return transactionService.findByAccountId(id);
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
                case "saveCurrency":
                case "save":
                    return userAccountServiceImpl.saveMoney(transaction) ?  ResponseEntity.ok("Succeed to save money transaction") : ResponseEntity.badRequest().body("Failed to save money transaction");
                case "withdrawCurrency":
                case "withdraw":
                case "payBill":
                    return userAccountServiceImpl.withdrawMoney(transaction) ?  ResponseEntity.ok("Succeed to withdraw money transaction") : ResponseEntity.badRequest().body("Failed to withdraw money transaction");
                    //return userAccountServiceImpl.payBill(transaction) ?  ResponseEntity.ok("Succeed to pay transaction") : ResponseEntity.badRequest().body("Failed to pay bill transaction");
                default:{
                    return ResponseEntity.badRequest().body("Failed to find this transaction");
                }
            }
        }
        else{
            switch (transaction.getTransactionType()){
                case "transfer":
                    return userAccountServiceImpl.transferMoney(transaction) ?  ResponseEntity.ok("Succeed to transfer money transaction") : ResponseEntity.badRequest().body("Failed to transfer money transaction");
                default:
                    return ResponseEntity.badRequest().body("Failed to find this transaction");
            }
        }
    }
}
