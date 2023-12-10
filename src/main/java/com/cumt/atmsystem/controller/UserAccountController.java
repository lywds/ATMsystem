package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.service.TransactionService;
import com.cumt.atmsystem.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;
    @RequestMapping("/finda")
    public UserAccount findByUserAccountId(Integer id){
        //System.out.println(transactionService.findByTransactionId(id).toString());
        return userAccountService.findByUserAccountId(id);
    }

}
