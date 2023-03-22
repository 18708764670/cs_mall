package cn.tedu.cs_mall.controller;

import cn.tedu.cs_mall.mapper.UserMapper;
import cn.tedu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //引入数据库
    @Autowired
    UserMapper mapper;

    @RequestMapping("/login")
    public String login(User user){
//        System.out.println(user.getUsername()+","+user.getPassword());
        String pw = mapper.selectByName(user.getUsername());
        System.out.println(pw);
        //判断是否有返回值，没有返回值用户不存在
        if (pw == null){
            return "用户名不存在";
        }else{
            //比对输入的密码和根据用户名到数据库查询的密码是否一致
            if (user.getPassword().equals(pw)){
                return "登录成功";
            }else{
                return "密码错误";
            }
        }
    }
}
