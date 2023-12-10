package com.cumt.atmsystem.service;

import com.cumt.atmsystem.domain.Transaction;
import org.apache.ibatis.cache.decorators.TransactionalCache;

public interface TransactionService {
    public Transaction findByTransactionId(Integer id);
    public void addTransaction(Transaction transaction);
}
