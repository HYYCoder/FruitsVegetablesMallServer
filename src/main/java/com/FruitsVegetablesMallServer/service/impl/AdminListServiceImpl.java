package com.FruitsVegetablesMallServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.AdminListMapper;
import com.FruitsVegetablesMallServer.pojo.AdminList;
import com.FruitsVegetablesMallServer.service.AdminListService;

@Service
public class AdminListServiceImpl implements AdminListService{

	@Autowired
	AdminListMapper adminListMapper;

	@Override
	public AdminList getAdmin(String userName) {
		return adminListMapper.getAdmin(userName);
	}
	
}
