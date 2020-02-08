package com.FruitsVegetablesMallServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.AccountLoginMapper;
import com.FruitsVegetablesMallServer.pojo.AccountLogin;
import com.FruitsVegetablesMallServer.service.AccountLoginService;

@Service
public class AccountLoginServiceImpl implements AccountLoginService{

	@Autowired
	private AccountLoginMapper accountLoginMapper;
	
	@Override
	public AccountLogin queryAccountLogin(String userName, String password,String type) {
		return accountLoginMapper.queryAccountLogin(userName, password,type);
	}

	
}
