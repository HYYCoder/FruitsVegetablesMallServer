package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.FruitsVegetablesMallServer.pojo.GoodsDetail;

@Mapper
public interface GoodsDetailMapper {
	
	void addGoodsDetail(String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
	
	String deleteGoodsDetail(int key);
	
	List<GoodsDetail> queryAllGoodsDetail(String type,String name,double price,
			double stock,double reducedPrice);
	
	GoodsDetail queryGoodsDetail(int key);
	
	void updateGoodsDetail(int key,String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
}
