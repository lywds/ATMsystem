package com.cumt.atmsystem.mapper;

import com.cumt.atmsystem.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where id_id = #{id}")
    public User findById(Integer id);
}
