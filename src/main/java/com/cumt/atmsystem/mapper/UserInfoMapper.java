package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Insert("INSERT INTO user_info (user_id, user_name, user_address, user_email, user_phone) " +
            "VALUES (#{userId}, #{userName}, #{userAddress}, #{userEmail}, #{userPhone})")
    public int insertUserInfo(UserInfo userInfo);

    @Select("SELECT * FROM user_info WHERE user_id = #{userId}")
    public UserInfo findByUserId(String userId);
}
