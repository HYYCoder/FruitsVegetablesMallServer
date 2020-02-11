package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.ShoppingCar;

@Mapper
public interface ShoppingCarMapper {

	void addShoppingCar(int userId, int goodsId, Double quantity);
	
	void deleteShoppingCar(int id);
	
	List<ShoppingCar> queryAllShoppingCar(int userId, int goodsId, Double quantity);
	
	List<ShoppingCar> queryUserShoppingCar(int userId);
	
	List<ShoppingCar> queryGoodsShoppingCar(int goodsId);
	
	ShoppingCar queryShoppingCar(int id);
	
	void updateShoppingCar(int id, int userId, int goodsId, Double quantity);
}
