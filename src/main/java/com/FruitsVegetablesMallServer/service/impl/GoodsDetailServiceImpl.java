package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.GoodsDetailMapper;
import com.FruitsVegetablesMallServer.pojo.GoodsDetail;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class GoodsDetailServiceImpl implements GoodsDetailService{

	@Autowired
	GoodsDetailMapper goodsDetailMapper;
	
	@Override
	public void addGoodsDetail(String imageUrls, String type, String name, double price, double stock,
			String specification, double reducedPrice, String detail) {
		goodsDetailMapper.addGoodsDetail(imageUrls,type,name,price,stock,specification,reducedPrice,detail);
	}

	@Override
	public void deleteGoodsDetail(int key) {
		goodsDetailMapper.deleteGoodsDetail(key);
	}

	@Override
	public PageInfo<GoodsDetail> queryAllGoodsDetail(String type,String name,double price,
			double stock,double reducedPrice,int current, int pageSize) {
		PageHelper.startPage(current,pageSize);
		List<GoodsDetail> list=goodsDetailMapper.queryAllGoodsDetail(type,name,price,
				stock,reducedPrice);
		PageInfo<GoodsDetail> page = new PageInfo<GoodsDetail>(list);
		return page;
	}

	@Override
	public GoodsDetail queryGoodsDetail(int goodsId) {
		return goodsDetailMapper.queryGoodsDetail(goodsId);
	}

	@Override
	public void updateGoodsDetail(int key,String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail) {
		goodsDetailMapper.updateGoodsDetail(key,imageUrls,type,name,price,
				stock,specification,reducedPrice,detail);
	}

}
