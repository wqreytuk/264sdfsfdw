package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
账户的持久层实现类
 */
//集成spring提供的JdbcDaoSupport可以减少冗余，在xml中直接注入dataSource即可，这样就不必再注入jdbcTemplate了
//如果想使用注解的话，只能自己定义JdbcTemplate类了，因为代码在JdbcDaoSupport，我们改不了，只能自己实现
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired()
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAllAccount() throws SQLException {
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }


    public Account findAccountById(Integer acountId) throws SQLException {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), acountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public void saveAccount(Account account) throws SQLException {
        jdbcTemplate.update("insert into account (name, money) values(?, ?)", account.getName(), account.getMoney());
    }

    public void updateAccount(Account account) throws SQLException {
        jdbcTemplate.update("update account set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }

    public void deleteAccount(Integer accountId) throws SQLException {
        jdbcTemplate.update("delete from account where id=?",accountId);
    }

    public Account findAccountByName(String accountName) throws SQLException {
        try {
            List<Account> accounts = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
            if(accounts == null || accounts.size() == 0) {
                return null;
            }
            if(accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一");
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}