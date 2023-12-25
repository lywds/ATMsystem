package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.BillRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface BillRecordMapper {
    @Select("SELECT * FROM bill_record WHERE credit_card_id = #{creditCardId} AND if_paid = 0")
    public List<BillRecord> findPaidRecordsByCreditCardId(String creditCardId);
    @Update("update bill_record set if_paid = 1 where bill_id = #{id}")
    public void updateBalanceById(@Param("id") Integer id);
}
