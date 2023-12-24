package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.domain.UserInfo;
import com.cumt.atmsystem.service.UserAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private ObjectMapper objectMapper;
    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody Map<String, Object> data) {
        UserAccount userAccount = objectMapper.convertValue(data.get("userAccount"), UserAccount.class);
        UserInfo userInfo = objectMapper.convertValue(data.get("userInfo"), UserInfo.class);
        String newAccount=userAccountService.createAccount(userAccount, userInfo);
        if (true) {
            return ResponseEntity.ok(newAccount);
        } else {
            return ResponseEntity.badRequest().body("Failed to create account");
        }
    }
    @RequestMapping("/findByUserAccountId")
    public UserAccount findByUserAccountId(String id){
        return userAccountService.findByUserAccountId(id);
    }


}
