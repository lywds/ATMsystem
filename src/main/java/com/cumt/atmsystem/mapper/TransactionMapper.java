package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TransactionMapper {
    @Select("select * from transaction where account_id = #{id}")
    public Transaction findByTransactionId(Integer id);
}
