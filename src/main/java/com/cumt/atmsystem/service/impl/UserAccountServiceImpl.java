package com.cumt.atmsystem.service.impl;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.mapper.TransactionMapper;
import com.cumt.atmsystem.mapper.UserAccountMapper;
import com.cumt.atmsystem.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    public boolean saveMoney(Transaction transaction) {
        String targetAccountId = transaction.getTargetAccountId();
        // 根据目标账户ID查询账户信息
        UserAccount account =  userAccountMapper.findByUserAccountId(targetAccountId);
        if (account == null) {
            // 目标账户不存在
            return false;
        }
        // 获取原始余额
        BigDecimal originalBalance = account.getAccountBalance();
        // 计算新的余额
        BigDecimal newBalance = originalBalance.add(transaction.getTransactionAmount());
        // 更新账户余额
        userAccountMapper.updateBalanceById(newBalance,targetAccountId);

        long currentTimeMillis = System.currentTimeMillis();
        //设置交易完成时间
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        transaction.setTimeStamp(timestamp);
        transactionMapper.insertTransaction(transaction);
//        account.setAccountBalance(newBalance);
//        userAccountRepository.save(account);
        return true;
    }

    @Override
    public UserAccount findByUserAccountId(String id) {
        return userAccountMapper.findByUserAccountId(id);
    }
}
