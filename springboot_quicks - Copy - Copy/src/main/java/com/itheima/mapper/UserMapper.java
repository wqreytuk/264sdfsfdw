package com.itheima.mapper;


import com.itheima.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
