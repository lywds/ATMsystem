package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TransactionMapper {
    @Select("select * from transaction where account_id = #{id}")
    public Transaction findByTransactionId(String id);
    @Select("SELECT * FROM transaction WHERE account_id = #{accountId}")
    public List<Transaction> findByAccountId(String accountId);
    @Insert("INSERT INTO transaction (account_id, transaction_type, transaction_amount, time_stamp,target_account_id,currency_type) VALUES (#{accountId}, #{transactionType}, #{transactionAmount}, #{timeStamp},#{targetAccountId},#{currencyType})")
    public int insertTransaction(Transaction transaction);
}
