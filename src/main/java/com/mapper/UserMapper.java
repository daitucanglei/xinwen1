package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user")
    User select(@Param("username")String username, @Param("password")String password);
}
