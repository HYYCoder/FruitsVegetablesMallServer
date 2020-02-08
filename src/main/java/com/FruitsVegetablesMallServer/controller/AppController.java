package com.FruitsVegetablesMallServer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;
import com.FruitsVegetablesMallServer.pojo.CategoryBean;
import com.FruitsVegetablesMallServer.pojo.SubCategoriesBean;
import com.FruitsVegetablesMallServer.pojo.UserList;
import com.FruitsVegetablesMallServer.service.AccountLoginService;
import com.FruitsVegetablesMallServer.service.BannerListService;
import com.FruitsVegetablesMallServer.service.CategoryListService;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;
import com.FruitsVegetablesMallServer.service.UserListService;
import com.FruitsVegetablesMallServer.util.TokenRequired;
import com.FruitsVegetablesMallServer.util.TokenUtil;

@RestController
public class AppController {

	@Autowired
	private AccountLoginService accountLoginService;
	@Autowired
	private UserListService userListService;
	@Autowired
	private GoodsDetailService goodsDetailService;
	@Autowired
	private BannerListService bannerListService;
	@Autowired
	private CategoryListService categoryListService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Map<String, Object> userLogin(@RequestBody Map<String,String> requestBody) {
		AccountLogin isAccountLogin = accountLoginService.queryAccountLogin(requestBody.get("userName")
				, requestBody.get("password"),"user");
		if(isAccountLogin.getUserName() !=null && isAccountLogin.getPassword() !=null && isAccountLogin.getType() != "user") {
			UserList userList = userListService.queryUserList(isAccountLogin.getUserName());
			Map<String, Object> user = new HashMap<String,Object>();
			user.put("id",userList.getId());
			user.put("name",userList.getName());
			user.put("mobile",userList.getMobile());
			user.put("address",userList.getAddress());
			user.put("clientType","0");
			user.put("token",TokenUtil.createJwtToken(userList.getUserName(),"FruitsVegetablesMall"));
			user.put("isBoundMobile","true");
			user.put("clientCode","0");
			user.put("clientId","0");
			user.put("userName",userList.getUserName());
			user.put("receivingPhone",userList.getReceivingPhone());
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("code", "0");
			data.put("message", "OK");
			data.put("data", user);
			return data;
		}
		return null;
	}
	
	@TokenRequired
	@RequestMapping(value = "/specialoffers",method = RequestMethod.GET)
	public Map<String,Object> queryAllBannerList(@RequestParam(value="current") int current
			,@RequestParam(value="pageSize") int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", bannerListService.queryAllBannerList(current,pageSize).getList());
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/categories",method = RequestMethod.GET)
	public Map<String,Object> queryAllCategoryList() {
		List<CategoryBean> categoryBean = categoryListService.queryAllCategoryList();
		List<SubCategoriesBean> subCategoriesBean = categoryListService.queryAllSubCategoriesList();
		List<Object> categoryList = new ArrayList<Object>();
		for (CategoryBean categoryBeans : categoryBean) {
			Map<String,Object> categoryBeanList = new HashMap<String,Object>();
			List<SubCategoriesBean> subCategoriesBeans = new ArrayList<SubCategoriesBean>();
			for (SubCategoriesBean subCategoriesBeanlist : subCategoriesBean) {   
		         if(categoryBeans.getId()==subCategoriesBeanlist.getPid()) {
		        	 subCategoriesBeans.add(subCategoriesBeanlist);
		         }
		     }
			categoryBeanList.put("category",categoryBeans);
			categoryBeanList.put("subCategories",subCategoriesBeans);
			
			categoryList.add(categoryBeanList);
	     }
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", categoryList);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/goods",method = RequestMethod.GET)
	public Map<String,Object> queryAllGoodsDetail(@RequestParam(value="categoryId") String categoryId,@RequestParam(value="name") String name
			,@RequestParam(value="price") Double price,@RequestParam(value="stock") Double stock
			,@RequestParam(value="reducedPrice") Double reducedPrice,@RequestParam(value="current") int current
			,@RequestParam(value="pageSize") int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", goodsDetailService.queryAllGoodsDetail(categoryId==""?-1:Integer.parseInt(categoryId),name,price==null?-1:price,
				stock==null?-1:stock,reducedPrice==null?-1:reducedPrice,current,pageSize).getList());
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/goods/{id}",method = RequestMethod.GET)
	public Map<String,Object> queryGoodsDetail(@PathVariable(value="id") Integer id) {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", goodsDetailService.queryGoodsDetail(id));
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/items/count",method = RequestMethod.GET)
	public Map<String,Object> queryShoppingCarCount() {
		Map<String,Object> count = new HashMap<String,Object>();
		count.put("count", 0);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", count);
		return data;
	}
}
