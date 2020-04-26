package com.itheima.controller;


import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//该注解表明当前类为SpringBoot引导类
@RestController
public class Quick2Controller {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/quick2")
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }
}
