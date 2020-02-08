package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.UserListMapper;
import com.FruitsVegetablesMallServer.pojo.UserList;
import com.FruitsVegetablesMallServer.service.UserListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserListServiceImpl implements UserListService{

	@Autowired
	private UserListMapper userListMapper;
	
	@Override
	public void addUserList(String name, String mobile, String address, String userCode, String receivingPhone) {
		userListMapper.addUserList(name, mobile, address, userCode, receivingPhone);
	}

	@Override
	public void deleteUserList(int id) {
		userListMapper.deleteUserList(id);
	}

	@Override
	public PageInfo<UserList> queryAllUserList(String name, String mobile, String address, String userCode,
			String receivingPhone, int current, int pageSize) {
		PageHelper.startPage(current,pageSize);
		List<UserList> list = userListMapper.queryAllUserList(name, mobile, address, userCode, receivingPhone);
		PageInfo<UserList> page = new PageInfo<UserList>(list);
		return page;
	}

	@Override
	public UserList queryUserList(String userName) {
		return userListMapper.queryUserList(userName);
	}

	@Override
	public void updateUserList(int id, String name, String mobile, String address, String userCode,
			String receivingPhone) {
		userListMapper.updateUserList(id, name, mobile, address, userCode, receivingPhone);
	}

}
