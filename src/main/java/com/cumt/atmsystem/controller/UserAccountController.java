package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.domain.UserInfo;
import com.cumt.atmsystem.service.UserAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private ObjectMapper objectMapper;
    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody Map<String, Object> data) {
        UserAccount userAccount = objectMapper.convertValue(data.get("userAccount"), UserAccount.class);
        UserInfo userInfo = objectMapper.convertValue(data.get("userInfo"), UserInfo.class);

        if (userAccountService.createAccount(userAccount, userInfo)) {
            return ResponseEntity.ok("Created account successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to create account");
        }
    }

}
