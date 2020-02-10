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
	private GoodsDetailMapper goodsDetailMapper;
	
	@Override
	public void addGoodsDetail(String imageUrls, int categoryId, String name, double price, double stock, String specification
			, double reducedPrice, double minimunOrderQuantity, double maximumOrderQuantity, double minimumIncrementQuantity
			, String detail) {
		goodsDetailMapper.addGoodsDetail(imageUrls, categoryId, name, price, stock, specification, reducedPrice, minimunOrderQuantity
				, maximumOrderQuantity, minimumIncrementQuantity, detail);
	}

	@Override
	public void deleteGoodsDetail(int id) {
		goodsDetailMapper.deleteGoodsDetail(id);
	}

	@Override
	public PageInfo<GoodsDetail> queryAllGoodsDetail(int categoryId, String name, double price
			, double stock, double reducedPrice, int current, int pageSize) {
		PageHelper.startPage(current,pageSize);
		List<GoodsDetail> list = goodsDetailMapper.queryAllGoodsDetail(categoryId, name, price
				, stock, reducedPrice);
		PageInfo<GoodsDetail> page = new PageInfo<GoodsDetail>(list);
		return page;
	}

	@Override
	public GoodsDetail queryGoodsDetail(int goodsId) {
		return goodsDetailMapper.queryGoodsDetail(goodsId);
	}

	@Override
	public void updateGoodsDetail(int id, String imageUrls, int categoryId, String name, double price, double stock
			, String specification, double reducedPrice, double minimunOrderQuantity, double maximumOrderQuantity
			, double minimumIncrementQuantity, String detail) {
		goodsDetailMapper.updateGoodsDetail(id, imageUrls, categoryId, name, price, stock, specification, reducedPrice
				, minimunOrderQuantity, maximumOrderQuantity, minimumIncrementQuantity, detail);
	}

}
