package com.FruitsVegetablesMallServer.service;

import java.util.List;

import com.FruitsVegetablesMallServer.pojo.CategoryBean;
import com.FruitsVegetablesMallServer.pojo.SubCategoriesBean;
import com.github.pagehelper.PageInfo;

public interface CategoryListService {

	void addCategoryList(int orders,String name,String imageUrl);
	
	void deleteCategoryList(int id);
	
	PageInfo<CategoryBean> queryCategoryList(int orders,String name,String imageUrl,int current, int pageSize);
	
	List<CategoryBean> queryAllCategoryList();
	
	void updateCategoryList(int id,int orders,String name,String imageUrl);
	
	void addSubCategoryList(int pid,int orders,String name);
	
	void deleteSubCategoryList(int id);
	
	PageInfo<SubCategoriesBean> querySubCategoriesList(int pid,int orders,String name,int current, int pageSize);
	
	List<SubCategoriesBean> queryAllSubCategoriesList();
	
	void updateSubCategoryList(int id,int pid,int orders,String name);
}
