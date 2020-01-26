package com.FruitsVegetablesMallServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.AccountLoginMapper;
import com.FruitsVegetablesMallServer.pojo.AccountLogin;
import com.FruitsVegetablesMallServer.service.AccountLoginService;

@Service
public class AccountLoginServiceImpl implements AccountLoginService{

	@Autowired
	AccountLoginMapper accountLoginMapper;
	
	@Override
	public AccountLogin getAccountLogin(String userName, String password) {
		return accountLoginMapper.getAccountLogin(userName, password);
	}

	
}
