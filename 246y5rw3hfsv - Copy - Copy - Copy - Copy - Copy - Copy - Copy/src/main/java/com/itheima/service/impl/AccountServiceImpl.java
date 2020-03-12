package com.itheima.service.impl;

import com.itheima.domain.Account;
import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/*
业务层账户的实现类
事务控制应该在业务层
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class AccountServiceImpl implements IAccountService {
	@Resource(name = "accountDao")
	private IAccountDao accountDao;

	public List<Account> findAllAccount() throws SQLException {
		return accountDao.findAllAccount();
	}

	public Account findAccountById(Integer accountId) throws SQLException {
		return accountDao.findAccountById(accountId);
	}

	public void saveAccount(Account account) throws SQLException {
		accountDao.saveAccount(account);
	}

	public void updateAccount(Account account) throws SQLException {
		accountDao.updateAccount(account);
	}

	public void deleteAccount(Integer accountId) throws SQLException {
		accountDao.deleteAccount(accountId);
	}

//	我们需要的是读写型配置，因此需要在这些方法中单独配置一下，如果这样的方法很多，用注解配置起来就不如xml方便了
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)//读写型事务的配置
	public void transfer(String sourceName, String tragetName, float money) throws SQLException {
		//根据名称查询转出账户
		Account source = accountDao.findAccountByName(sourceName);
		//根据名称查询转入账户
		Account target = accountDao.findAccountByName(tragetName);
		//转出账户减钱
		source.setMoney(source.getMoney() - money);
		//转入账户加钱
		target.setMoney(target.getMoney() + money);
		//更新转出账户
		accountDao.updateAccount(source);

//        int i = 1/0;
		//更新转入账户
		accountDao.updateAccount(target);
	}
}