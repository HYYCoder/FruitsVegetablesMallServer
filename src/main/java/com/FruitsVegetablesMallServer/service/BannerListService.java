package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.BannerList;
import com.github.pagehelper.PageInfo;

public interface BannerListService {

	void addBannerList(int orders,String imageUrl,String detail);
	
	void deleteBannerList(int id);
	
	PageInfo<BannerList> queryAllBannerList(int current, int pageSize);
	
	BannerList queryBannerList(int id);
	
	void updateBannerList(int id,int orders,String imageUrl,String detail);
}
