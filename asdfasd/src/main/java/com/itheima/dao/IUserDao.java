package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    //查询用户列表
    @Select("select * from user")
    public List<User> findAll();

    //根据ID查询
    @Select("select * from user where id = #{userId}")
    public User findById(Integer userId);

    //更新用户
    @Select("update user set username=#{username}, password=#{password}, age=#{age}, email=#{email}, sex=#{sex} where id=#{id}")
    public void updateUser(User user);

}