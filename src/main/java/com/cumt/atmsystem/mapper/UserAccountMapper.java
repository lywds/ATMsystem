package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserAccountMapper {
    @Select("select * from user where id = #{id}")
    public UserAccount findByUserAccountId(Integer id);
}
