package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;

public interface AccountLoginService {

	void addAccountLogin(String userName,String password,String type);
	
	void deleteAccountLogin(int id);
	
	AccountLogin queryAccountLogin(String userName,String password,String type);
	
	AccountLogin queryUpdateAccountLogin(String userName);
	
	void updateAccountLogin(String userName,String password,String type);
}
