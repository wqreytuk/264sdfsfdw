package com.example.demo5.dao;

import com.example.demo5.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户信息
     */
    User findUserByName(String name);

    /**
     * 查询所有用户信息
     */
    List<User> findAllUser();

    /**
     * 插入用户信息
     */
    void insertUser(String name, Integer age, Double money);

    /**
     * 根据 id 更新用户信息
     */
    void updateUser(String name, Integer age, Double money, int id);

    /**
     * 根据 id 删除用户信息
     */
    void deleteUser(int id);
}