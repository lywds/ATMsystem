package com.cumt.atmsystem.service.impl;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.mapper.TransactionMapper;
import com.cumt.atmsystem.service.TransactionService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public Transaction findByTransactionId(String id) {
        return transactionMapper.findByTransactionId(id);
    }

    @Override
    public List<Transaction> findByAccountId(String id) {
        return transactionMapper.findByAccountId(id);
    }

    @Override
    public int insertTransaction(Transaction transaction) {
        return transactionMapper.insertTransaction(transaction);
    }


}
