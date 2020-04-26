package com.itheima.domain;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//该注解表明当前类为SpringBoot引导类
@RestController
public class User {

    @Override
    public String toString() {
        return "User{" +
                "usernmae='" + usernmae + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    private String usernmae;
    private int id;
    private String password;

    public String getUsernmae() {
        return usernmae;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
