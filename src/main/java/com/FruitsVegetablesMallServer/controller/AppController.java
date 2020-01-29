package com.FruitsVegetablesMallServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FruitsVegetablesMallServer.pojo.GoodsDetail;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;
import com.github.pagehelper.PageInfo;

@RestController
public class AppController {

	@Autowired
	private GoodsDetailService goodsDetailService;
	
	@RequestMapping(value = "/goods",method = RequestMethod.GET)
	public PageInfo<GoodsDetail> queryAllGoodsDetail(String type,String name,double price,
			double stock,String specification,double reducedPrice,@RequestParam(value="currentPage",defaultValue="1")int currentPage, @RequestParam(value="pageSize",defaultValue="16")int pageSize) {
		return goodsDetailService.queryAllGoodsDetail(type,name,price,
				stock,reducedPrice,currentPage,pageSize);
	}
	
	@RequestMapping(value = "/goods/{id}",method = RequestMethod.GET)
	public GoodsDetail queryGoodsDetail(@PathVariable(value="id") Integer id) {
		return goodsDetailService.queryGoodsDetail(id);
	}
	
}
