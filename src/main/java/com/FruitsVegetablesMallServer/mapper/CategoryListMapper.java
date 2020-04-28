package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.CategoryBean;
import com.FruitsVegetablesMallServer.pojo.SubCategoriesBean;

@Mapper
public interface CategoryListMapper {
	
	void addCategoryList(int orders,String name,String imageUrl);
	
	void deleteCategoryList(int id);
	
	List<CategoryBean> queryCategoryList(int orders,String name,String imageUrl);
	
	List<CategoryBean> queryAllCategoryList();
	
	void updateCategoryList(int id,int orders,String name,String imageUrl);
	
	void addSubCategoryList(int pid,int orders,String name);
	
	void deleteSubCategoryList(int id);
	
	List<SubCategoriesBean> querySubCategoriesList(int pid,int orders,String name);
	
	List<SubCategoriesBean> queryAllSubCategoriesList();
	
	void updateSubCategoryList(int id,int pid,int orders,String name);
	
}
