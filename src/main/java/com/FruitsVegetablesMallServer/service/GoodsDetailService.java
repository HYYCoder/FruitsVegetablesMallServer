package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.GoodsDetail;
import com.github.pagehelper.PageInfo;

public interface GoodsDetailService {
	
	void addGoodsDetail(String imageUrls,int categoryId,String name,double price,double stock,String specification
			,double reducedPrice,double minimunOrderQuantity,double maximumOrderQuantity,double minimumIncrementQuantity,String detail);
	
	void deleteGoodsDetail(int id);
	
	PageInfo<GoodsDetail> queryAllGoodsDetail(int categoryId,String name,double price,
			double stock,double reducedPrice,int current, int pageSize);
	
	GoodsDetail queryGoodsDetail(int id);
	
	void updateGoodsDetail(int id,String imageUrls,int categoryId,String name,double price,double stock,String specification
			,double reducedPrice,double minimunOrderQuantity,double maximumOrderQuantity,double minimumIncrementQuantity,String detail);
}
