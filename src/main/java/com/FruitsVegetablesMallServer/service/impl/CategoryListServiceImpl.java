package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.CategoryListMapper;
import com.FruitsVegetablesMallServer.pojo.CategoryBean;
import com.FruitsVegetablesMallServer.pojo.SubCategoriesBean;
import com.FruitsVegetablesMallServer.service.CategoryListService;

@Service
public class CategoryListServiceImpl implements CategoryListService{

	@Autowired
	private CategoryListMapper categoryListMapper;

	@Override
	public List<CategoryBean> queryAllCategoryList() {
		return categoryListMapper.queryAllCategoryList();
	}

	@Override
	public List<SubCategoriesBean> queryAllSubCategoriesList() {
		return categoryListMapper.queryAllSubCategoriesList();
	}
	
}
