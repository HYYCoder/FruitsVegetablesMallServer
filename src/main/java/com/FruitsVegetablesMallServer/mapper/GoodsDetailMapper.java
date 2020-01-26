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
	
	@Insert("insert into goodsdetail (imageUrls,type,name,price,stock,specification,reducedPrice,detail) values(#{imageUrls},#{type},#{name},#{price},#{stock},#{specification},#{reducedPrice},#{detail})")
	void addGoodsDetail(String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
	
	@Delete("delete from goodsdetail where id=#{id}")
	String deleteGoodsDetail(int id);
	
	@Select("select * from goodsdetail where 1=1")
	List<GoodsDetail> getAllGoodsDetail();
	
	@Select("select * from goodsdetail where type=#{type}")
	List<GoodsDetail> getTypeGoodsDetail(String type);
	
	@Select("select * from goodsdetail where name like'%${name}%'")
	List<GoodsDetail> getNameGoodsDetail(@Param(value = "name")String name);
	
	@Select("select * from goodsdetail where id=#{goodsId}")
	GoodsDetail getGoodsDetail(int goodsId);
	
	@Update("Update goodsdetail set imageUrls = #{imageUrls},type = #{type},name = #{name},price = #{price},stock = #{stock},specification = #{specification},reducedPrice = #{reducedPrice},detail = #{detail} where id = #{id}")
	void updateGoodsDetail(int id,String imageUrls,String type,String name,double price,
			double stock,String specification,double reducedPrice,String detail);
}
