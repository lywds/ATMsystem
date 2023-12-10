package com.cumt.atmsystem.controller;


import com.cumt.atmsystem.domain.User;
import com.cumt.atmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findb")
    public User findById(Integer id) {
        return userService.findById(id);
    }
}
