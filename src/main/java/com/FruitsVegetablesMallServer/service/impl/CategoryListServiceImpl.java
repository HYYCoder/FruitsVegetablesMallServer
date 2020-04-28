package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.CategoryListMapper;
import com.FruitsVegetablesMallServer.pojo.CategoryBean;
import com.FruitsVegetablesMallServer.pojo.SubCategoriesBean;
import com.FruitsVegetablesMallServer.service.CategoryListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CategoryListServiceImpl implements CategoryListService{

	@Autowired
	private CategoryListMapper categoryListMapper;

	@Override
	public void addCategoryList(int orders, String name, String imageUrl) {
		categoryListMapper.addCategoryList(orders, name, imageUrl);
	}

	@Override
	public void deleteCategoryList(int id) {
		categoryListMapper.deleteCategoryList(id);
	}

	@Override
	public PageInfo<CategoryBean> queryCategoryList(int orders, String name, String imageUrl,int current, int pageSize) {
		PageHelper.startPage(current, pageSize);
		List<CategoryBean> list = categoryListMapper.queryCategoryList(orders, name, imageUrl);
		PageInfo<CategoryBean> page = new PageInfo<CategoryBean>(list);
		return page;
	}
	
	@Override
	public List<CategoryBean> queryAllCategoryList() {
		return categoryListMapper.queryAllCategoryList();
	}

	@Override
	public void updateCategoryList(int id, int orders, String name, String imageUrl) {
		categoryListMapper.updateCategoryList(id, orders, name, imageUrl);
	}

	@Override
	public void addSubCategoryList(int pid, int orders, String name) {
		categoryListMapper.addSubCategoryList(pid, orders, name);
	}

	@Override
	public void deleteSubCategoryList(int id) {
		categoryListMapper.deleteSubCategoryList(id);
	}

	@Override
	public PageInfo<SubCategoriesBean> querySubCategoriesList(int pid, int orders, String name,int current, int pageSize) {
		PageHelper.startPage(current, pageSize);
		List<SubCategoriesBean> list = categoryListMapper.querySubCategoriesList(pid, orders, name);
		PageInfo<SubCategoriesBean> page = new PageInfo<SubCategoriesBean>(list);
		return page;
	}

	@Override
	public List<SubCategoriesBean> queryAllSubCategoriesList() {
		return categoryListMapper.queryAllSubCategoriesList();
	}
	
	@Override
	public void updateSubCategoryList(int id, int pid, int orders, String name) {
		categoryListMapper.updateSubCategoryList(id, pid, orders, name);
	}
	
}
