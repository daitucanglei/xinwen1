package com.mapper;

import com.pojo.xiewen;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface xiewenMapper {
    @Select("select * from xiewen")
    List<xiewen> selectall();
@Insert("insert into xiewen values(#{xinwen},#{lanmu})")
  void add(xiewen xiewen1);
@Delete("delete  from xiewen where xinwen = #{xinwen}")
void deleteById(@Param("xinwen")String xinwen);
@Update("update xiewen set xinwen=#{xinwen}where lanmu=#{lanmu}")
void updateById(xiewen xiewen);
List<xiewen> tiaocha(xiewen xiewen1);

}
