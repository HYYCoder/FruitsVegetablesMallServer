package com.FruitsVegetablesMallServer.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;

@Mapper
public interface AccountLoginMapper {
	
	void addAccountLogin(String userName,String password,String type);
	
	void deleteAccountLogin(int id);
	
	AccountLogin queryAccountLogin(String userName,String password,String type);
	
	AccountLogin queryUpdateAccountLogin(String userName);
	
	void updateAccountLogin(String userName,String password,String type);
}
