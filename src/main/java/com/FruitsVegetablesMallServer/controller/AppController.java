package com.FruitsVegetablesMallServer.controller;

import java.util.HashMap;
import java.util.Map;

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
	public Map<String,Object> queryAllGoodsDetail() {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", 200);
		data.put("message", "OK");
		data.put("data", goodsDetailService.queryAllGoodsDetail("","",-1,-1,-1,0,10));
		return data;
	}
	
	@RequestMapping(value = "/goods/{id}",method = RequestMethod.GET)
	public GoodsDetail queryGoodsDetail(@PathVariable(value="id") Integer id) {
		return goodsDetailService.queryGoodsDetail(id);
	}
	
}
