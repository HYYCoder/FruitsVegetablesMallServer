package com.FruitsVegetablesMallServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.FruitsVegetablesMallServer.pojo.AdminList;

@Mapper
public interface AdminListMapper {
	
	@Select("select * from adminlist where userName=#{userName}")
	AdminList getAdmin(String userName);
}
