package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import org.springframework.stereotype.Service;

/*
业务层账户的实现类

事务控制应该在业务层
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
		System.out.println("保存账户");
		
	}

	public void updateAccount(int i) {
		System.out.println("更新保存账户");
	}

	public int deleteAccount() {
		System.out.println("删除账户");
		return 0;
	}
}
