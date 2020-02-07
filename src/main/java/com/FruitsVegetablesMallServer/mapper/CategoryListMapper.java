package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.CategoryBean;
import com.FruitsVegetablesMallServer.pojo.SubCategoriesBean;

@Mapper
public interface CategoryListMapper {
	
	List<CategoryBean> queryAllCategoryList();
	
	List<SubCategoriesBean> queryAllSubCategoriesList();
	
}
