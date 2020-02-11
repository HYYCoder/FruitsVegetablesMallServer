package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.ShoppingCarMapper;
import com.FruitsVegetablesMallServer.pojo.ShoppingCar;
import com.FruitsVegetablesMallServer.service.ShoppingCarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService{

	@Autowired
	private ShoppingCarMapper shoppingCarMapper;
	
	@Override
	public void addShoppingCar(int userId, int goodsId, Double quantity) {
		shoppingCarMapper.addShoppingCar(userId, goodsId, quantity);
	}

	@Override
	public void deleteShoppingCar(int id) {
		shoppingCarMapper.deleteShoppingCar(id);
	}

	@Override
	public PageInfo<ShoppingCar> queryAllShoppingCar(int userId, int goodsId, Double quantity, int current, int pageSize) {
		PageHelper.startPage(current,pageSize);
		List<ShoppingCar> list = shoppingCarMapper.queryAllShoppingCar(userId, goodsId, quantity);
		PageInfo<ShoppingCar> page = new PageInfo<ShoppingCar>(list);
		return page;
	}

	@Override
	public List<ShoppingCar> queryUserShoppingCar(int userId) {
		return shoppingCarMapper.queryUserShoppingCar(userId);
	}

	@Override
	public List<ShoppingCar> queryGoodsShoppingCar(int goodsId) {
		return shoppingCarMapper.queryGoodsShoppingCar(goodsId);
	}
	
	@Override
	public ShoppingCar queryShoppingCar(int id) {
		return shoppingCarMapper.queryShoppingCar(id);
	}

	@Override
	public void updateShoppingCar(int id, int userId, int goodsId, Double quantity) {
		shoppingCarMapper.updateShoppingCar(id, userId, goodsId, quantity);
	}

}
