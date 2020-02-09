package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.AdminList;
import com.github.pagehelper.PageInfo;

public interface AdminListService {
	
	void addUserList(String userName,String type,String imageUrl,String mobile,String name);
	
	void deleteAdminList(int id);
	
	PageInfo<AdminList> queryAllAdminList(String userName,String type,String mobile,String name,int current, int pageSize);
	
	AdminList queryAdminList(String userName);
	
	void updateAdminList(String userName,String type,String imageUrl,String mobile,String name);
}
