package com.cumt.atmsystem.service.impl;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import com.cumt.atmsystem.domain.UserInfo;
import com.cumt.atmsystem.mapper.BillRecordMapper;
import com.cumt.atmsystem.mapper.TransactionMapper;
import com.cumt.atmsystem.mapper.UserAccountMapper;
import com.cumt.atmsystem.mapper.UserInfoMapper;
import com.cumt.atmsystem.service.UserAccountService;
import com.cumt.atmsystem.tools.GenerateAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BillRecordMapper billRecordMapper;
    @Override
    public boolean saveMoney(Transaction transaction) {
        return changeMoney(transaction);
    }
    @Override
    public boolean withdrawMoney(Transaction transaction) {
        transaction.setTransactionAmount(transaction.getTransactionAmount().multiply(new BigDecimal(-1)));
        return changeMoney(transaction);
    }
    @Override
    public int insertUserAccount(UserAccount userAccount) {
        return userAccountMapper.insertUserAccount(userAccount);
    }

    @Override
    public String createAccount(UserAccount userAccount, UserInfo userInfo) {
        String newAccount = GenerateAccount.generateBankCardNumber();
        while(userAccountMapper.findByUserAccountId(newAccount)!=null){
            newAccount = GenerateAccount.generateBankCardNumber();
        }
        userAccount.setAccountId(newAccount);
        userAccountMapper.insertUserAccount(userAccount);
        if(userInfoMapper.findByUserId(userInfo.getUserId())==null)
            userInfoMapper.insertUserInfo(userInfo);
        return newAccount;
    }

    @Override
    public boolean transferMoney(Transaction transaction) {
        changeTargetValue(transaction);
        boolean flag1=changeMoney(transaction);
        if(!flag1)return flag1;
        changeTargetValue(transaction);
        return changeMoney(transaction);
    }

    @Override
    public boolean exchangeMoney(Transaction transaction) {
        return changeMoney(transaction);
    }

    @Override
    public boolean payBill(Transaction transaction) {
        billRecordMapper.updateBalanceById(transaction.getBillId());
        transaction.setTransactionAmount(transaction.getTransactionAmount().multiply(new BigDecimal(-1)));
        return changeMoney(transaction);
    }

    public boolean changeMoney(Transaction transaction) {
        String targetAccountId = transaction.getTargetAccountId();
        // 根据目标账户ID查询账户信息
        UserAccount account =  userAccountMapper.findByUserAccountId(targetAccountId);

        // 获取交易额
        BigDecimal amount = transaction.getTransactionAmount();
        // 计算新的余额
        BigDecimal newBalance;
//        = originalBalance.add(transaction.getTransactionAmount());
//        if (account == null||newBalance.compareTo(BigDecimal.ZERO)<0) {
//            return false;
//        }
       // System.out.println(1);
        // 更新账户余额
//        userAccountMapper.updateBalanceById(newBalance,targetAccountId);
        switch (transaction.getCurrencyType()) {
            case "USD":
                newBalance = account.getUsdBalance().add(amount);
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) return false;
                account.setUsdBalance(newBalance);
                userAccountMapper.updateUsdBalanceById(newBalance,targetAccountId);
                break;
            case "EUR":
                newBalance = account.getEurBalance().add(amount);
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) return false;
                account.setEurBalance(newBalance);
                userAccountMapper.updateEurBalanceById(newBalance,targetAccountId);
                break;
            case "GBP":
                newBalance = account.getGbpBalance().add(amount);
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) return false;
                account.setGbpBalance(newBalance);
                userAccountMapper.updateGbpBalanceById(newBalance,targetAccountId);
                break;
            case "HKD":
                newBalance = account.getHkdBalance().add(amount);
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) return false;
                account.setHkdBalance(newBalance);
                userAccountMapper.updateHkdBalanceById(newBalance,targetAccountId);
                break;
            default:
                newBalance = account.getAccountBalance().add(amount);
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) return false;
                account.setAccountBalance(newBalance);
                userAccountMapper.updateBalanceById(newBalance,targetAccountId);
                billRecordMapper.updateBalanceById(transaction.getBillId());
                break;
        }
        long currentTimeMillis = System.currentTimeMillis();
        //设置交易完成时间
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        transaction.setTimeStamp(timestamp);
        if (Objects.equals(transaction.getTransactionType(), "transfer"))changeTarget(transaction);
        transactionMapper.insertTransaction(transaction);
        if (Objects.equals(transaction.getTransactionType(), "transfer"))changeTarget(transaction);
        return true;
    }
    public void changeTargetValue(Transaction transaction){
        changeTarget(transaction);
        transaction.setTransactionAmount(transaction.getTransactionAmount().multiply(new BigDecimal(-1)));
    }
    public void changeTarget(Transaction transaction){
        String targetAccountId = transaction.getAccountId();
        String accountId = transaction.getTargetAccountId();
        transaction.setAccountId(accountId);
        transaction.setTargetAccountId(targetAccountId);
    }
    @Override
    public UserAccount findByUserAccountId(String id) {
        return userAccountMapper.findByUserAccountId(id);
    }


}
