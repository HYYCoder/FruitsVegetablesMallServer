package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.GoodsDetail;

@Mapper
public interface GoodsDetailMapper {
	
	void addGoodsDetail(String imageUrls,int categoryId,String name,double price,double stock,String specification
			,double reducedPrice,double minimunOrderQuantity,double maximumOrderQuantity,double minimumIncrementQuantity,String detail
			,String hotGoods);
	
	void deleteGoodsDetail(int id);
	
	List<GoodsDetail> queryAllGoodsDetail(int categoryId,String name,double price,
			double stock,double reducedPrice,String hotGoods);
	
	GoodsDetail queryGoodsDetail(int id);
	
	void updateGoodsDetail(int id,String imageUrls,int categoryId,String name,double price,double stock,String specification
			,double reducedPrice,double minimunOrderQuantity,double maximumOrderQuantity,double minimumIncrementQuantity,String detail
			,String hotGoods);
}
