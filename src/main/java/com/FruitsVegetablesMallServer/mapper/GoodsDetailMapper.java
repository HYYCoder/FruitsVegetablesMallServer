package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.GoodsDetail;

@Mapper
public interface GoodsDetailMapper {
	
	void addGoodsDetail(String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
	
	void deleteGoodsDetail(int id);
	
	List<GoodsDetail> queryAllGoodsDetail(String type,String name,double price,
			double stock,double reducedPrice);
	
	GoodsDetail queryGoodsDetail(int id);
	
	void updateGoodsDetail(int id,String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
}
