package com.cumt.atmsystem.service.impl;

import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.mapper.UserAccountMapper;
import com.cumt.atmsystem.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Override
    public UserAccount findByUserAccountId(Integer id) {
        return userAccountMapper.findByUserAccountId(id);
    }
}
