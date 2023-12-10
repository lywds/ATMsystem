package com.cumt.atmsystem.service.impl;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.mapper.TransactionMapper;
import com.cumt.atmsystem.service.TransactionService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public Transaction findByTransactionId(Integer id) {
        return transactionMapper.findByTransactionId(id);
    }
    @Override
    public void addTransaction(Transaction transaction) {
        transactionMapper.insertTransaction(transaction);
    }
}
