package com.FruitsVegetablesMallServer.service;

import java.util.List;

import com.FruitsVegetablesMallServer.pojo.ShoppingCar;
import com.github.pagehelper.PageInfo;

public interface ShoppingCarService {
	
	void addShoppingCar(int userId, int goodsId, Double quantity);
	
	void deleteShoppingCar(int id);
	
	PageInfo<ShoppingCar> queryAllShoppingCar(int userId, int goodsId, Double quantity,int current, int pageSize);
	
	List<ShoppingCar> queryUserShoppingCar(int userId);
	
	ShoppingCar queryShoppingCar(int id);
	
	void updateShoppingCar(int id, int userId, int goodsId, Double quantity);
}
