package com.FruitsVegetablesMallServer.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;

@Mapper
public interface AccountLoginMapper {
	
	AccountLogin queryAccountLogin(String userName,String password);
	
}
