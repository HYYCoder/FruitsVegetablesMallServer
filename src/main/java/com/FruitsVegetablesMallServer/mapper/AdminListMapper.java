package com.FruitsVegetablesMallServer.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.FruitsVegetablesMallServer.pojo.AdminList;

@Mapper
public interface AdminListMapper {
	
	
	void addAdminList(String userName,String type,String imageUrl,String mobile,String name);
	
	void deleteAdminList(int id);
	
	List<AdminList> queryAllAdminList(String userName,String type,String mobile,String name);
	
	AdminList queryAdminList(String userName);
	
	void updateAdminList(String userName,String type,String imageUrl,String mobile,String name);
}
