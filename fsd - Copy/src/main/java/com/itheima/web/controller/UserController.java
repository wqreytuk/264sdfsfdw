package com.itheima.web.controller;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public User findById(Integer id) {
        return userService.findById(id);
    }

    @RequestMapping("/update")
//    这个RequestBody坑了我半天，因为传过来的是json数据，不加这个注解的话是解析不了的，我之前把它和ResponseBody搞混了
    public void update(@RequestBody User user) {
        System.out.println("controller" + user);
        userService.updateUser(user);
    }
}