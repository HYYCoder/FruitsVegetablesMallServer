package com.FruitsVegetablesMallServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FruitsVegetablesMallServer.pojo.JsonMessage;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;

@RestController
public class ManageController {
	
	private JsonMessage jsonMessage;
	@Autowired
	private GoodsDetailService goodsDetailService;
	
	@RequestMapping(value = "/add/goods",method = RequestMethod.POST)
	public JsonMessage addGoodsDetail(String type,String name,String imageUrls,double price,
			double stock,String specification,double reducedPrice,String detail) {
		goodsDetailService.addGoodsDetail(type, name, imageUrls, price, stock, specification, reducedPrice, detail);
		jsonMessage.setCode(200);
		jsonMessage.setMessage("OK");
		jsonMessage.setData("");
		return jsonMessage;
	}	
}
