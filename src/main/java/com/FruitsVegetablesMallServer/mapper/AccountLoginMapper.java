package com.FruitsVegetablesMallServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;

@Mapper
public interface AccountLoginMapper {
	
	AccountLogin queryAccountLogin(String userName,String password);
	
}
