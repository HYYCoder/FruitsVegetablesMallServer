package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.AdminListMapper;
import com.FruitsVegetablesMallServer.pojo.AdminList;
import com.FruitsVegetablesMallServer.service.AdminListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AdminListServiceImpl implements AdminListService{

	@Autowired
	private AdminListMapper adminListMapper;

	@Override
	public void addUserList(String userName, String type, String imageUrl, String mobile, String name) {
		adminListMapper.addAdminList(userName, type, imageUrl, mobile, name);
	}

	@Override
	public void deleteAdminList(int id) {
		adminListMapper.deleteAdminList(id);
	}

	@Override
	public PageInfo<AdminList> queryAllAdminList(String userName, String type, String mobile, String name, int current,
			int pageSize) {
		PageHelper.startPage(current,pageSize);
		List<AdminList> list = adminListMapper.queryAllAdminList(userName, type, mobile, name);
		PageInfo<AdminList> page = new PageInfo<AdminList>(list);
		return page;
	}

	@Override
	public AdminList queryAdminList(String userName) {
		return adminListMapper.queryAdminList(userName);
	}

	
	@Override
	public void updateAdminList(String userName, String type, String imageUrl, String mobile, String name) {
		adminListMapper.updateAdminList(userName, type, imageUrl, mobile, name);
	}

}
