package com.cumt.atmsystem.service;

import com.cumt.atmsystem.domain.Transaction;
import org.apache.ibatis.cache.decorators.TransactionalCache;

import java.util.List;

public interface TransactionService {
    public Transaction findByTransactionId(String id);

    public List<Transaction>findByAccountId(String id);
    public int insertTransaction(Transaction transaction);
}
