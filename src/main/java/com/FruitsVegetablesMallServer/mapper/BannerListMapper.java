package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.BannerList;

@Mapper
public interface BannerListMapper {
	
	void addBannerList(String imageUrl);
	
	void deleteBannerList(int id);
	
	List<BannerList> queryAllBannerList();
	
	BannerList queryBannerList(int id);
	
	void updateBannerList(int id,String imageUrl);
}
