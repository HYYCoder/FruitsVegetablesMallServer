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
	public Map<String,Object> getAllGoodsDetail(@RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="16")int pageSize) {
		PageInfo<GoodsDetail> pageInfo= goodsDetailService.getAllGoodsDetail(pageNum,pageSize);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("data", pageInfo.getList());
		data.put("total", pageInfo.getTotal());
		data.put("success", true);
		data.put("pageSize", pageInfo.getPageSize());
		data.put("current", pageInfo.getPageNum());
		return data;
	}
	
	@RequestMapping(value = "/goods/type",method = RequestMethod.GET)
	public PageInfo<GoodsDetail> getTypeGoodsDetail(@RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="16")int pageSize,String type) {
		return goodsDetailService.getTypeGoodsDetail(pageNum,pageSize,type);
	}
	
	@RequestMapping(value = "/goods/name",method = RequestMethod.GET)
	public PageInfo<GoodsDetail> getNameGoodsDetail(@RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="16")int pageSize,String name) {
		return goodsDetailService.getNameGoodsDetail(pageNum,pageSize,name);
	}
	
	@RequestMapping(value = "/goods/{goodsId}",method = RequestMethod.GET)
	public GoodsDetail getGoodsDetail(@RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="16")int pageSize,@PathVariable(value="goodsId") Integer goodsId) {
		return goodsDetailService.getGoodsDetail(goodsId);
	}
	
}
