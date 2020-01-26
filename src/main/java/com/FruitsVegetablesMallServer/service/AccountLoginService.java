package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;

public interface AccountLoginService {

	AccountLogin getAccountLogin(String userName,String password);
}
