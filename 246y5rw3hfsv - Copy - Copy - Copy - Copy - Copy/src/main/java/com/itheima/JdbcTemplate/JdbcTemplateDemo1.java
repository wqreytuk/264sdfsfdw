package com.itheima.JdbcTemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/*
账户的实体类
 */


public class JdbcTemplateDemo1 {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        List<Account> accounts = accountDao.findAllAccount();
        for (Account account:accounts
             ) {
            System.out.println(account.getName());
        }
    }
}
