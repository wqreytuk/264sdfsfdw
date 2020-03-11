package com.itheima.service;

import com.itheima.domain.Account;

/*
业务层的接口
 */
public interface IAccountService {
	//以下方法均为模拟方法
	void  saveAccount();
	
	void updateAccount(int i);
	
	int deleteAccount();
}
