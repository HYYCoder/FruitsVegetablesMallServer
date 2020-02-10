package com.FruitsVegetablesMallServer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;
import com.FruitsVegetablesMallServer.pojo.CategoryBean;
import com.FruitsVegetablesMallServer.pojo.GoodsDetail;
import com.FruitsVegetablesMallServer.pojo.ShoppingCar;
import com.FruitsVegetablesMallServer.pojo.SubCategoriesBean;
import com.FruitsVegetablesMallServer.pojo.UserList;
import com.FruitsVegetablesMallServer.service.AccountLoginService;
import com.FruitsVegetablesMallServer.service.BannerListService;
import com.FruitsVegetablesMallServer.service.CategoryListService;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;
import com.FruitsVegetablesMallServer.service.ShoppingCarService;
import com.FruitsVegetablesMallServer.service.UserListService;
import com.FruitsVegetablesMallServer.util.TokenRequired;
import com.FruitsVegetablesMallServer.util.TokenUtil;

@RestController
public class AppController {

	@Autowired
	private HttpServletRequest httpServletRequest;
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
	@Autowired
	private ShoppingCarService shoppingCarService;
	
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
	@RequestMapping(value = "/cart/items",method = RequestMethod.POST)
	public Map<String,Object> addShoppingCar(@RequestBody Map<String,String> requestBody) {
		shoppingCarService.addShoppingCar(Integer.parseInt(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId())
				, Integer.parseInt(requestBody.get("goodsId")), Double.parseDouble(requestBody.get("quantity")));
		Map<String,Object> count = new HashMap<String,Object>();
		count.put("count", shoppingCarService.queryUserShoppingCar(Integer.parseInt(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId())).size());
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", count);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/item/{id}",method = RequestMethod.DELETE)
	public String deleteShoppingCarItem(@PathVariable(value="id") Integer id) {
		shoppingCarService.deleteShoppingCar(id);
		return "OK";
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/items/bacthdel",method = RequestMethod.POST)
	public String deleteShoppingCarItems(@RequestBody Map<String,String> requestBody) {
		char[] ids = requestBody.get("ids").toCharArray();
		for(char id : ids){
			shoppingCarService.deleteShoppingCar(id);
		}
		return "OK";
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart",method = RequestMethod.GET)
	public Map<String,Object> queryAllShoppingCarList(@RequestParam(value="userId") int userId
			,@RequestParam(value="goodsId") int goodsId,@RequestParam(value="quantity") Double quantity
			,@RequestParam(value="current") int current,@RequestParam(value="pageSize") int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", shoppingCarService.queryAllShoppingCar(userId, goodsId, quantity, current, pageSize));
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/items",method = RequestMethod.GET)
	public Map<String,Object> queryUserShoppingCarList() {
		List<Object> list = new ArrayList<Object>();
		List<ShoppingCar> shoppingCarList = shoppingCarService.queryUserShoppingCar(Integer.parseInt(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId()));
		for(ShoppingCar item:shoppingCarList) {
			GoodsDetail goodsDetail = goodsDetailService.queryGoodsDetail(item.getGoodsId());
			Map<String,Object> itemData = new HashMap<String,Object>();
			itemData.put("id", goodsDetail.getId());
			itemData.put("imageUrls", goodsDetail.getImageUrls());
			itemData.put("name", goodsDetail.getName());
			itemData.put("price", goodsDetail.getPrice());
			itemData.put("stock", goodsDetail.getStock());
			itemData.put("specification", goodsDetail.getSpecification());
			itemData.put("minimunOrderQuantity", goodsDetail.getMinimunOrderQuantity());
			itemData.put("maximumOrderQuantity", goodsDetail.getMaximumOrderQuantity());
			itemData.put("minimumIncrementQuantity", goodsDetail.getMinimumIncrementQuantity());
			itemData.put("quantitys", item.getQuantity());
			itemData.put("isCheckeds", true);
			list.add(itemData);
		}
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", list);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/items/count",method = RequestMethod.GET)
	public Map<String,Object> queryShoppingCarCount() {
		Map<String,Object> count = new HashMap<String,Object>();
		count.put("count", shoppingCarService.queryUserShoppingCar(Integer.parseInt(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId())).size());
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", count);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/item/{id}",method = RequestMethod.PUT)
	public Map<String,Object> updateShoppingCarCount(@PathVariable(value="id") Integer id, @RequestBody Map<String,String> requestBody) {
		shoppingCarService.updateShoppingCar(id, Integer.parseInt(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId())
				, shoppingCarService.queryShoppingCar(id).getGoodsId(), Double.parseDouble(requestBody.get("quantity")));
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", shoppingCarService.queryUserShoppingCar(Integer.parseInt(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId())));
		return data;
	}
}
