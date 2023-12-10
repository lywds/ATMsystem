package com.cumt.atmsystem.service.impl;

import com.cumt.atmsystem.domain.User;
import com.cumt.atmsystem.mapper.UserMapper;
import com.cumt.atmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
