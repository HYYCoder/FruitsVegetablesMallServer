package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;

public interface AccountLoginService {

	AccountLogin queryAccountLogin(String userName,String password);
}
