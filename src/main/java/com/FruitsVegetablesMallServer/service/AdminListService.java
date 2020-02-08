package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.AdminList;

public interface AdminListService {
	
	AdminList queryAdminList(String userName);
}
