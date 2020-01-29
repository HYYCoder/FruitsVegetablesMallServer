package com.FruitsVegetablesMallServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.FruitsVegetablesMallServer.pojo.AdminList;

@Mapper
public interface AdminListMapper {
	
	AdminList queryAdmin(String userName);
}
