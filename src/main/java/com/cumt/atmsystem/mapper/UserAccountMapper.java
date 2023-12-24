package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface UserAccountMapper {
    @Select("select * from user_account where account_id = #{id}")
    public UserAccount findByUserAccountId(String id);
    @Update("update user_account set account_balance = #{balance} where account_id = #{id}")
    public void updateBalanceById(@Param("balance") BigDecimal balance, @Param("id") String id);
    @Update("update user_account set usd_balance = #{usdBalance} where account_id = #{id}")
    public void updateUsdBalanceById(@Param("usdBalance") BigDecimal usdBalance, @Param("id") String id);

    @Update("update user_account set eur_balance = #{eurBalance} where account_id = #{id}")
    public void updateEurBalanceById(@Param("eurBalance") BigDecimal eurBalance, @Param("id") String id);

    @Update("update user_account set gbp_balance = #{gbpBalance} where account_id = #{id}")
    public void updateGbpBalanceById(@Param("gbpBalance") BigDecimal gbpBalance, @Param("id") String id);

    @Update("update user_account set hkd_balance = #{hkdBalance} where account_id = #{id}")
    public void updateHkdBalanceById(@Param("hkdBalance") BigDecimal hkdBalance, @Param("id") String id);
    @Insert("INSERT INTO user_account (account_id, user_id, account_password, account_balance, phone_number, bank_name) " +
            "VALUES (#{accountId}, #{userId}, #{accountPassword}, #{accountBalance}, #{phoneNumber}, #{bankName})")
    public int insertUserAccount(UserAccount userAccount);
}
