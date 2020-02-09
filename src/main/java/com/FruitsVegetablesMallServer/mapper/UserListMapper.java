package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.UserList;

@Mapper
public interface UserListMapper {
	
	void addUserList(String name,String mobile,String address,String userName,String receivingPhone);
	
	void deleteUserList(int id);
	
	List<UserList> queryAllUserList(String name,String mobile,String address,String userName,String receivingPhone);
	
	UserList queryUserList(String userName);
	
	void updateUserList(String userName,String name,String mobile,String address,String receivingPhone);
}
