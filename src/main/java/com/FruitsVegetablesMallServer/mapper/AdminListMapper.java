package com.FruitsVegetablesMallServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.FruitsVegetablesMallServer.pojo.AdminList;

@Mapper
public interface AdminListMapper {
	
	AdminList queryAdmin(String userName);
}
