package com.FruitsVegetablesMallServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FruitsVegetablesMallServer.pojo.AdminList;
import com.FruitsVegetablesMallServer.service.AdminListService;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;

@RestController
public class ManageController {
	
	@Autowired
	private AdminListService adminListService;
	@Autowired
	private GoodsDetailService goodsDetailService;
	
	@RequestMapping(value = "/admin/login",method = RequestMethod.POST)
	public AdminList adminLogin(@RequestBody AdminList adminList) {
		System.out.println(adminList.getUserName());
		System.out.println(adminList.getPassword());
		return adminListService.getAdminList(adminList.getUserName(), adminList.getPassword());
	}
	
	@RequestMapping(value = "/add/goods",method = RequestMethod.POST)
	public String addGoodsDetail(String imageUrls,String type,String name,double price,double stock,String specification,double reducedPrice,String detail) {
		goodsDetailService.addGoodsDetail(imageUrls, type, name, price, stock, specification, reducedPrice, detail);
		return "OK";
	}
}
