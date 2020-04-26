package com.itheima.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//该注解表明当前类为SpringBoot引导类
@RestController
public class QuickController {
    @RequestMapping("/quick")
    public String quick() {
        return "中文";
    }
}
