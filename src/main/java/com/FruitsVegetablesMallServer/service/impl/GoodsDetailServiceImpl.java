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
	public void addGoodsDetail(String type, String name, String imageUrls, double price, double stock,
			String specification, double reducedPrice, String detail) {
		goodsDetailMapper.addGoodsDetail(type,name,imageUrls,price,stock,specification,reducedPrice,detail);
	}

	@Override
	public void deleteGoodsDetail(int id) {
		goodsDetailMapper.deleteGoodsDetail(id);
	}

	@Override
	public PageInfo<GoodsDetail> getAllGoodsDetail(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<GoodsDetail> list=goodsDetailMapper.getAllGoodsDetail();
		PageInfo<GoodsDetail> page = new PageInfo<GoodsDetail>(list);
		return page;
	}

	@Override
	public PageInfo<GoodsDetail> getTypeGoodsDetail(int pageNo, int pageSize, String type) {
		PageHelper.startPage(pageNo,pageSize);
		List<GoodsDetail> list=goodsDetailMapper.getTypeGoodsDetail(type);
		PageInfo<GoodsDetail> page = new PageInfo<GoodsDetail>(list);
		return page;
	}

	@Override
	public PageInfo<GoodsDetail> getNameGoodsDetail(int pageNo, int pageSize, String name) {
		PageHelper.startPage(pageNo,pageSize);
		List<GoodsDetail> list=goodsDetailMapper.getNameGoodsDetail(name);
		PageInfo<GoodsDetail> page = new PageInfo<GoodsDetail>(list);
		return page;
	}

	@Override
	public GoodsDetail getGoodsDetail(int goodsId) {
		return goodsDetailMapper.getGoodsDetail(goodsId);
	}

	@Override
	public void updateGoodsDetail(int id, String type, String name, String imageUrls, double price, double stock,
			String specification, double reducedPrice, String detail) {
		goodsDetailMapper.updateGoodsDetail(id,type,name,imageUrls,price,stock,specification,reducedPrice,detail);
	}

}
