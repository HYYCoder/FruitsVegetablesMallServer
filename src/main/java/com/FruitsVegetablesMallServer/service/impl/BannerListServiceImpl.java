package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.BannerListMapper;
import com.FruitsVegetablesMallServer.pojo.BannerList;
import com.FruitsVegetablesMallServer.service.BannerListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	public PageInfo<BannerList> queryAllBannerList(int current, int pageSize) {
		PageHelper.startPage(current,pageSize);
		List<BannerList> list = bannerListMapper.queryAllBannerList();
		PageInfo<BannerList> page = new PageInfo<BannerList>(list);
		return page;
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
