package com.itheima.web.controller;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
//@ResponseBody注解可以将返回结果转换成json格式
@ResponseBody
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/findById")
    public User findById(Integer userId) {
        return userService.findById(userId);
    }

    @RequestMapping("/updateUser")
    public void update(User user) {
        userService.updateUser(user);
    }
}