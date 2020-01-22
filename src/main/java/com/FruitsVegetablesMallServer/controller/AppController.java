package com.FruitsVegetablesMallServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FruitsVegetablesMallServer.pojo.GoodsDetail;
import com.FruitsVegetablesMallServer.pojo.JsonMessage;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;
import com.github.pagehelper.PageInfo;

@RestController
public class AppController {

	@Autowired
	private GoodsDetailService goodsDetailService;
	
	@RequestMapping(value = "/goods",method = RequestMethod.GET)
	public JsonMessage getAllGoodsDetail(@RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="16")int pageSize) {
		PageInfo<GoodsDetail> page = goodsDetailService.getAllGoodsDetail(pageNum,pageSize);
		JsonMessage jsonMessage = new JsonMessage();
		jsonMessage.setCode(200);
		jsonMessage.setMessage("OK");
		jsonMessage.setData(page.toString());
		return jsonMessage;
	}
	
	@RequestMapping(value = "/goods/type",method = RequestMethod.GET)
	public JsonMessage getTypeGoodsDetail(@RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="16")int pageSize,String type) {
		PageInfo<GoodsDetail> page = goodsDetailService.getTypeGoodsDetail(pageNum,pageSize,type);
		JsonMessage jsonMessage = new JsonMessage();
		jsonMessage.setCode(200);
		jsonMessage.setMessage("OK");
		jsonMessage.setData(page.toString());
		return jsonMessage;
	}
	
	@RequestMapping(value = "/goods/name",method = RequestMethod.GET)
	public JsonMessage getNameGoodsDetail(@RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="16")int pageSize,String name) {
		PageInfo<GoodsDetail> page = goodsDetailService.getNameGoodsDetail(pageNum,pageSize,name);
		JsonMessage jsonMessage = new JsonMessage();
		jsonMessage.setCode(200);
		jsonMessage.setMessage("OK");
		jsonMessage.setData(page.toString());
		return jsonMessage;
	}
	
	@RequestMapping(value = "/goods/{goodsId}",method = RequestMethod.GET)
	public JsonMessage getGoodsDetail(@RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="16")int pageSize,@PathVariable(value="goodsId") Integer goodsId) {
		GoodsDetail goodsDetail = goodsDetailService.getGoodsDetail(goodsId);
		JsonMessage jsonMessage = new JsonMessage();
		if(goodsDetail==null) {
			jsonMessage.setCode(404);
			jsonMessage.setMessage("NO");
			jsonMessage.setData("");
		}else {
			jsonMessage.setCode(200);
			jsonMessage.setMessage("OK");
			jsonMessage.setData(goodsDetail.toString());
		}
		return jsonMessage;
	}
	
}
