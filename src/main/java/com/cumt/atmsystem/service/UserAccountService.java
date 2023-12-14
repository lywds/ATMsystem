package com.cumt.atmsystem.service;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.domain.UserInfo;
import org.apache.catalina.User;

public interface UserAccountService {
    public UserAccount findByUserAccountId(String id);
    public boolean saveMoney(Transaction transaction);
    public boolean withdrawMoney(Transaction transaction);

    public boolean transferMoney(Transaction transaction);
    public int insertUserAccount(UserAccount userAccount);

    public boolean createAccount(UserAccount userAccount, UserInfo userInfo);
}
