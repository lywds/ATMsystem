package com.cumt.atmsystem.service;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.mapper.UserAccountMapper;

public interface UserAccountService {
    public UserAccount findByUserAccountId(Integer id);
}
