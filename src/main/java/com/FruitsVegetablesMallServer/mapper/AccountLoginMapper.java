package com.FruitsVegetablesMallServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;

@Mapper
public interface AccountLoginMapper {
	
	@Select("select * from accountlogin where userName=#{userName} and password=#{password}")
	AccountLogin getAccountLogin(String userName,String password);
	
	@Update("Update accountlogin set token = #{token} where id = #{id} and token")
	void updateToken(int id,String token);
}
