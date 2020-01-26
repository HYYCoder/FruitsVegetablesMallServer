package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.GoodsDetail;
import com.github.pagehelper.PageInfo;

public interface GoodsDetailService {
	
	void addGoodsDetail(String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
	
	void deleteGoodsDetail(int id);
	
	PageInfo<GoodsDetail> getAllGoodsDetail(int pageNo, int pageSize);
	
	PageInfo<GoodsDetail> getTypeGoodsDetail(int pageNo, int pageSize,String type);
	
	PageInfo<GoodsDetail> getNameGoodsDetail(int pageNo, int pageSize,String name);
	
	GoodsDetail getGoodsDetail(int id);
	
	void updateGoodsDetail(int id,String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
}
