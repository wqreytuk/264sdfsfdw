package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//用户的业务层接口
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    //根据ID查询
    public User findById(Integer userId){
        return userDao.findById(userId);
    }

    //更新用户
    public  void updateUser(User user){
        userDao.updateUser(user);
    }
}