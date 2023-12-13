package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

@Mapper
public interface UserAccountMapper {
    @Select("select * from user_account where account_id = #{id}")
    public UserAccount findByUserAccountId(String id);
    @Update("update user_account set account_balance = #{balance} where account_id = #{id}")
    public void updateBalanceById(@Param("balance") BigDecimal balance, @Param("id") String id);
}
