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
	public void addAccountLogin(String userName, String password, String type) {
		accountLoginMapper.addAccountLogin(userName, password, type);
	}

	@Override
	public void deleteAccountLogin(int id) {
		accountLoginMapper.deleteAccountLogin(id);
	}

	@Override
	public AccountLogin queryAccountLogin(String userName, String password, String type) {
		return accountLoginMapper.queryAccountLogin(userName, password,type);
	}

	@Override
	public AccountLogin queryUpdateAccountLogin(String userName) {
		return accountLoginMapper.queryUpdateAccountLogin(userName);
	}
	
	@Override
	public void updateAccountLogin(String userName, String password, String type) {
		accountLoginMapper.updateAccountLogin(userName, password, type);
	}

}
