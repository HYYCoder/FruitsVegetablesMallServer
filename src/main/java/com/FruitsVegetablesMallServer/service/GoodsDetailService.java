package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.GoodsDetail;
import com.github.pagehelper.PageInfo;

public interface GoodsDetailService {
	
	void addGoodsDetail(String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
	
	void deleteGoodsDetail(int key);
	
	PageInfo<GoodsDetail> queryAllGoodsDetail(String type,String name,double price,
			double stock,double reducedPrice,int current, int pageSize);
	
	GoodsDetail queryGoodsDetail(int key);
	
	void updateGoodsDetail(int key,String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
}
