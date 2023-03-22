package cn.tedu.cs_mall.mapper;

import cn.tedu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface UserMapper {


    @Select("select password from user where name = #{name}")
    public String selectByName(String name);


    @Insert("insert into user values(null,#{name},#{password},#{phone})")
    void adduser(User user);

    @Update("update user set password=#{password} where name=#{name} ")
    void updatePwd(String name, String password);
    @Select("select*from user")
    List<User> selectAll();
}

