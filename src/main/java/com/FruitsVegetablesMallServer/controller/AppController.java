package com.FruitsVegetablesMallServer.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.FruitsVegetablesMallServer.service.OrderListService;
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
	@Autowired
	private OrderListService orderListService;
	
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
	public Map<String,Object> queryAllGoodsDetail(@RequestParam(value="categoryId") String categoryId
			, @RequestParam(value="name") String name, @RequestParam(value="price") Double price
			, @RequestParam(value="stock") Double stock, @RequestParam(value="reducedPrice") Double reducedPrice
			, @RequestParam(value="current") int current, @RequestParam(value="pageSize") int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", goodsDetailService.queryAllGoodsDetail(categoryId==""?-1:Integer.parseInt(categoryId), name
				, price==null?-1:price, stock==null?-1:stock, reducedPrice==null?-1:reducedPrice, current, pageSize).getList());
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
		UserList userList = userListService.queryUserList(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId());
		ShoppingCar shoppingCar = shoppingCarService.queryGoodsShoppingCar(Integer.parseInt(requestBody.get("goodsId")));
		if(shoppingCar == null) {
			shoppingCarService.addShoppingCar(
					userList.getId(), Integer.parseInt(requestBody.get("goodsId")), Double.parseDouble(requestBody.get("quantity")));
		}else {
			
			shoppingCarService.updateShoppingCar(shoppingCar.getId(), shoppingCar.getUserId()
					, shoppingCar.getGoodsId()
					, shoppingCar.getQuantity()+Double.parseDouble(requestBody.get("quantity")));
		}
		Map<String,Object> count = new HashMap<String,Object>();
		count.put("count", shoppingCarService.queryUserShoppingCar(
				Integer.parseInt(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId())).size());
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", count);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/item/{id}",method = RequestMethod.DELETE)
	public Map<String,Object> deleteShoppingCarItem(@PathVariable(value="id") Integer id) {
		shoppingCarService.deleteShoppingCar(id);
		Map<String,Object> list = new HashMap<String,Object>();
		list.put("result", "ok");
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", list);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/items/bacthdel",method = RequestMethod.POST)
	public Map<String,Object> deleteShoppingCarItems(@RequestBody Map<String,List<Integer>> requestBody) {
		for(int id : requestBody.get("ids")){
			shoppingCarService.deleteShoppingCar(id);
		}
		Map<String,Object> list = new HashMap<String,Object>();
		list.put("result", "ok");
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", list);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart",method = RequestMethod.GET)
	public Map<String,Object> queryAllShoppingCarList(@RequestParam(value="userId") int userId
			, @RequestParam(value="goodsId") int goodsId, @RequestParam(value="quantity") Double quantity
			, @RequestParam(value="current") int current, @RequestParam(value="pageSize") int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", shoppingCarService.queryAllShoppingCar(userId, goodsId, quantity, current, pageSize));
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/items",method = RequestMethod.GET)
	public Map<String,Object> queryUserShoppingCarList() {
		List<Object> normalItems = new ArrayList<Object>();
		List<Object> abnormalItems = new ArrayList<Object>();
		UserList userList = userListService.queryUserList(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId());
		List<ShoppingCar> shoppingCarList = shoppingCarService.queryUserShoppingCar(userList.getId());
		for(ShoppingCar item : shoppingCarList) {
			GoodsDetail goodsDetail = goodsDetailService.queryGoodsDetail(item.getGoodsId());
			Map<String,Object> normalItemsData = new HashMap<String,Object>();
			normalItemsData.put("id", goodsDetail.getId());
			normalItemsData.put("shoppingCarId", item.getId());
			normalItemsData.put("imageUrls", goodsDetail.getImageUrls());
			normalItemsData.put("name", goodsDetail.getName());
			normalItemsData.put("price", goodsDetail.getPrice());
			normalItemsData.put("stock", goodsDetail.getStock());
			normalItemsData.put("specification", goodsDetail.getSpecification());
			normalItemsData.put("minimunOrderQuantity", goodsDetail.getMinimunOrderQuantity());
			normalItemsData.put("maximumOrderQuantity", goodsDetail.getMaximumOrderQuantity());
			normalItemsData.put("minimumIncrementQuantity", goodsDetail.getMinimumIncrementQuantity());
			normalItemsData.put("quantity", item.getQuantity());
			normalItemsData.put("isChecked", true);
			normalItems.add(normalItemsData);
		}
		Map<String,Object> list = new HashMap<String,Object>();
		list.put("normalItems", normalItems);
		list.put("abnormalItems", abnormalItems);
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
		count.put("count", shoppingCarService.queryUserShoppingCar(
				Integer.parseInt(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId())).size());
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", count);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/item/{id}",method = RequestMethod.PUT)
	public Map<String,Object> updateShoppingCarCount(@PathVariable(value="id") Integer id
			, @RequestBody Map<String,String> requestBody) {
		UserList userList = userListService.queryUserList(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId());
		shoppingCarService.updateShoppingCar(id, userList.getId(), shoppingCarService.queryShoppingCar(id).getGoodsId()
				, Double.parseDouble(requestBody.get("quantity")));
		Map<String,Object> list = new HashMap<String,Object>();
		list.put("result", "ok");
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", list);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/cart/settle",method = RequestMethod.POST)
	public Map<String,Object> updateConfirmOrder(@RequestBody Map<String,List<Integer>> requestBody) {
		double discountAmount = 0;
		double amount = 0;
		double paidAmount = 0;
		List<Object> cartItems = new ArrayList<Object>();
		UserList userList = userListService.queryUserList(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId());
		for(int item : requestBody.get("ids")) {
			ShoppingCar shoppingCarList = shoppingCarService.queryShoppingCar(item);
			GoodsDetail goodsDetail = goodsDetailService.queryGoodsDetail(shoppingCarList.getGoodsId());
			Map<String,Object> cartItemsData = new HashMap<String,Object>();
			cartItemsData.put("id", goodsDetail.getId());
			cartItemsData.put("imageUrls", goodsDetail.getImageUrls());
			cartItemsData.put("name", goodsDetail.getName());
			cartItemsData.put("price", goodsDetail.getPrice());
			cartItemsData.put("specification", goodsDetail.getSpecification());
			cartItemsData.put("quantity", shoppingCarList.getQuantity());
			cartItems.add(cartItemsData);
			discountAmount += goodsDetail.getReducedPrice()*shoppingCarList.getQuantity();
			amount += goodsDetail.getPrice()*shoppingCarList.getQuantity();
		}
		paidAmount = amount - discountAmount;
		Map<String,Object> list = new HashMap<String,Object>();
		list.put("mobile", userList.getMobile());
		list.put("address", userList.getAddress());
		list.put("discountAmount", discountAmount);
		list.put("amount", amount);
		list.put("paidAmount", paidAmount);
		list.put("cartItems", cartItems);
		list.put("gifts", new ArrayList<>());
		list.put("coupons", new ArrayList<>());
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", list);
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/orders",method = RequestMethod.PUT)
	public Map<String,Object> addOrdersList(@RequestBody Map<String,List<String>> requestBody) {
		double discountAmount = 0;
		double amount = 0;
		double paidAmount = 0;
		String details = "";
		UserList userList = userListService.queryUserList(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId());
		for(String item : requestBody.get("ids")) {
			ShoppingCar shoppingCarList = shoppingCarService.queryShoppingCar(Integer.parseInt(item));
			GoodsDetail goodsDetail = goodsDetailService.queryGoodsDetail(shoppingCarList.getGoodsId());
			details += ",";
			details += shoppingCarList.getGoodsId();
			discountAmount += goodsDetail.getReducedPrice()*shoppingCarList.getQuantity();
			amount += goodsDetail.getPrice()*shoppingCarList.getQuantity();
		}
		paidAmount = amount - discountAmount;
		orderListService.addOrderList(userList.getId()+new Date().toString(), new Date().toString()
				, details, amount, discountAmount, paidAmount, userList.getReceivingPhone(), userList.getAddress()
				, userList.getMobile(), requestBody.get("note").get(0), userList.getId());
		for(String item : requestBody.get("ids")) {
			shoppingCarService.deleteShoppingCar(Integer.parseInt(item));
		}
		Map<String,Object> list = new HashMap<String,Object>();
		list.put("id", orderListService.queryCodeOrderList(userList.getId()+new Date().toString()).getId());
		list.put("code", userList.getId()+new Date().toString());
		list.put("receiver", userList.getReceivingPhone());
		list.put("address", userList.getAddress());
		list.put("amount", amount);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", "0");
		data.put("message", "OK");
		data.put("data", list);
		return data;
	}
}
