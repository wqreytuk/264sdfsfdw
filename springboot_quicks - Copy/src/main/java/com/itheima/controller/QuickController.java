package com.itheima.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//该注解表明当前类为SpringBoot引导类
@Controller
public class QuickController {
    @RequestMapping("/quick")
    @ResponseBody
    public String quick() {
        return "hello springboot";
    }
}
