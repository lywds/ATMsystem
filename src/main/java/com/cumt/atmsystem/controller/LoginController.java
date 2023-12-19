package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.domain.UserInfo;
import com.cumt.atmsystem.mapper.UserAccountMapper;
import com.cumt.atmsystem.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;
import java.util.Map;
import java.util.Objects;


@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserAccountService userAccountService;
    @PostMapping("/login")
    public ResponseEntity<String> createAccount(@RequestBody UserAccount userAccount) {
        //UserAccount userAccount = objectMapper.convertValue(data.get("userAccount"), UserAccount.class);
        //UserInfo userInfo = objectMapper.convertValue(data.get("userInfo"), UserInfo.class);
        UserAccount userAccountOperation = userAccountService.findByUserAccountId(userAccount.getAccountId());
        if (userAccountOperation==null) {
            return ResponseEntity.badRequest().body("银行卡不支持或账户不存在");
        } else {
            if(Objects.equals(userAccountOperation.getAccountPassword(), userAccount.getAccountPassword()))
                return ResponseEntity.ok("Login success");
            return ResponseEntity.badRequest().body("密码错误");
        }
    }
}
