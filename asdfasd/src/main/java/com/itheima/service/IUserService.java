package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

//用户的业务层接口
public interface IUserService {
    //查询用户列表
    public List<User> findAll();

    //根据ID查询
    public User findById(Integer userId);

    //更新用户
    public  void updateUser(User user);

}