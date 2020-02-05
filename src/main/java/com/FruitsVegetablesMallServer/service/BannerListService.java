package com.FruitsVegetablesMallServer.service;

import java.util.List;

import com.FruitsVegetablesMallServer.pojo.BannerList;

public interface BannerListService {

	void addBannerList(String imageUrl);
	
	void deleteBannerList(int id);
	
	List<BannerList> queryAllBannerList();
	
	BannerList queryBannerList(int id);
	
	void updateBannerList(int id,String imageUrl);
}
