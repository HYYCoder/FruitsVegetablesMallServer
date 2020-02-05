package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.BannerListMapper;
import com.FruitsVegetablesMallServer.pojo.BannerList;
import com.FruitsVegetablesMallServer.service.BannerListService;

@Service
public class BannerListServiceImpl implements BannerListService{

	@Autowired
	private BannerListMapper bannerListMapper;

	@Override
	public void addBannerList(String imageUrl) {
		bannerListMapper.addBannerList(imageUrl);
	}

	@Override
	public void deleteBannerList(int id) {
		bannerListMapper.deleteBannerList(id);
	}

	@Override
	public List<BannerList> queryAllBannerList() {
		return bannerListMapper.queryAllBannerList();
	}

	@Override
	public BannerList queryBannerList(int id) {
		return bannerListMapper.queryBannerList(id);
	}

	@Override
	public void updateBannerList(int id, String imageUrl) {
		bannerListMapper.updateBannerList(id, imageUrl);
	}
	

}
