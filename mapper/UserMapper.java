package cn.tedu.cs_mall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select password from user where username = #{username}")
    public String selectByName(String username);
}
