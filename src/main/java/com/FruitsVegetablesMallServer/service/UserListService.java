package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.UserList;
import com.github.pagehelper.PageInfo;

public interface UserListService {
	
	void addUserList(String name,String mobile,String address,String userName,String receivingPhone);
	
	void deleteUserList(int id);
	
	PageInfo<UserList> queryAllUserList(String name,String mobile,String address,String userName,String receivingPhone
			,int current, int pageSize);
	
	UserList queryUserList(String userName);
	
	void updateUserList(String userName,String name,String mobile,String address,String receivingPhone);

}
