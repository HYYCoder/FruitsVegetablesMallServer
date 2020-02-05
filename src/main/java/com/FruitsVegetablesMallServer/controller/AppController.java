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
import com.FruitsVegetablesMallServer.service.BannerListService;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;

@RestController
public class AppController {

	@Autowired
	private GoodsDetailService goodsDetailService;
	@Autowired
	private BannerListService bannerListService;
	
	@RequestMapping(value = "/specialoffers",method = RequestMethod.GET)
	public Map<String,Object> queryBannerList(@RequestParam(value="current") int current
			,@RequestParam(value="pageSize") int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", bannerListService.queryAllBannerList(current,pageSize).getList());
		return data;
	}
	
	@RequestMapping(value = "/goods",method = RequestMethod.GET)
	public Map<String,Object> queryAllGoodsDetail(@RequestParam(value="type") String type,@RequestParam(value="name") String name
			,@RequestParam(value="price") Double price,@RequestParam(value="stock") Double stock
			,@RequestParam(value="reducedPrice") Double reducedPrice,@RequestParam(value="current") int current
			,@RequestParam(value="pageSize") int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", goodsDetailService.queryAllGoodsDetail(type,name,price==null?-1:price,
				stock==null?-1:stock,reducedPrice==null?-1:reducedPrice,current,pageSize).getList());
		return data;
	}
	
	@RequestMapping(value = "/goods/{id}",method = RequestMethod.GET)
	public GoodsDetail queryGoodsDetail(@PathVariable(value="id") Integer id) {
		return goodsDetailService.queryGoodsDetail(id);
	}
	
}
