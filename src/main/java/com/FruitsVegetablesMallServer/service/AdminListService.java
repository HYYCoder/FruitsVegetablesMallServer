package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.AdminList;

public interface AdminListService {
	
	AdminList getAdminList(String userName,String password);
}
