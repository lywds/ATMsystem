package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.BillRecord;
import com.cumt.atmsystem.domain.CreditCard;
import com.cumt.atmsystem.domain.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CreditCardMapper {
    @Select("SELECT * FROM credit_card WHERE account_id = #{accountId}")
    public List<CreditCard> findByAccountId(String accountId);

}
