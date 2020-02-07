package com.FruitsVegetablesMallServer.service;

import java.util.List;

import com.FruitsVegetablesMallServer.pojo.CategoryBean;
import com.FruitsVegetablesMallServer.pojo.SubCategoriesBean;

public interface CategoryListService {

	List<CategoryBean> queryAllCategoryList();
	
	List<SubCategoriesBean> queryAllSubCategoriesList();
}
