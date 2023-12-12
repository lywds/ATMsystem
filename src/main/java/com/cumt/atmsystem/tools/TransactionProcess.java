package com.cumt.atmsystem.tools;

import com.cumt.atmsystem.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionProcess {

//    public boolean saveMoney(Transaction transaction) {
//        String targetAccountId = transaction.getTargetAccountId();
//        // 根据目标账户ID查询账户信息
//        UserAccount account =  userAccountRepository.findByAccountId(targetAccountId);
//        if (account == null) {
//            // 目标账户不存在
//            return false;
//        }
//        // 获取原始余额
//        BigDecimal originalBalance = account.getAccountBalance();
//        // 计算新的余额
//        BigDecimal newBalance = originalBalance.add(transaction.getTransactionAmount());
//        // 更新账户余额
//        account.setAccountBalance(newBalance);
//        userAccountRepository.save(account);
//        return true;

    }
}
