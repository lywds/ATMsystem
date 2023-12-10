package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TransactionMapper {
    @Select("select * from transaction where account_id = #{id}")
    public Transaction findByTransactionId(Integer id);
    @Insert("INSERT INTO transaction (transaction_id, account_id, transaction_type, transaction_amount, timestamp) VALUES (#{transaction.transaId}, #{transaction.accountId}, #{transaction.transactionType}, #{transaction.transactionAmount}, #{transaction.timestamp})")
    public int insertTransaction(Transaction transaction);
}
