package com.FruitsVegetablesMallServer.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;
import com.FruitsVegetablesMallServer.pojo.AdminList;
import com.FruitsVegetablesMallServer.service.AccountLoginService;
import com.FruitsVegetablesMallServer.service.AdminListService;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;
import com.FruitsVegetablesMallServer.util.TokenRequired;
import com.FruitsVegetablesMallServer.util.TokenUtil;


@RestController
public class ManageController {
	
	@Autowired
	private AccountLoginService accountLoginService;
	@Autowired
	private AdminListService adminListService;
	@Autowired
	private GoodsDetailService goodsDetailService;
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@RequestMapping(value = "/admin/login",method = RequestMethod.POST)
	public Map<String, String> accountLogin(@RequestBody AccountLogin accountLogin) {
		AccountLogin isAccountLogin = accountLoginService.getAccountLogin(accountLogin.getUserName(), accountLogin.getPassword());
		if(isAccountLogin.getUserName() !=null 
				&& isAccountLogin.getPassword() !=null) {
			Map<String, String> token = new HashMap<String,String>();
			token.put("id",isAccountLogin.getId()+"");
			token.put("token",TokenUtil.createJwtToken(accountLogin.getUserName(),"FruitsVegetablesMall"));
			return token;
		}
		return null;
	}
	
	@TokenRequired
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public AdminList getAdmin() {
		return adminListService.getAdmin(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId());
	}
	
	@TokenRequired
	@RequestMapping(value = "/add/goods",method = RequestMethod.POST)
	public String addGoodsDetail(String imageUrls,String type,String name,double price,double stock,String specification,double reducedPrice,String detail) {
		goodsDetailService.addGoodsDetail(imageUrls, type, name, price, stock, specification, reducedPrice, detail);
		return "OK";
	}
}
