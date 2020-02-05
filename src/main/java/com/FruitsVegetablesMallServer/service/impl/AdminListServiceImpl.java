package com.FruitsVegetablesMallServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.AdminListMapper;
import com.FruitsVegetablesMallServer.pojo.AdminList;
import com.FruitsVegetablesMallServer.service.AdminListService;

@Service
public class AdminListServiceImpl implements AdminListService{

	@Autowired
	private AdminListMapper adminListMapper;

	@Override
	public AdminList queryAdmin(String userName) {
		return adminListMapper.queryAdmin(userName);
	}

}
