package com.FruitsVegetablesMallServer.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.FruitsVegetablesMallServer.pojo.AccountLogin;
import com.FruitsVegetablesMallServer.pojo.AdminList;
import com.FruitsVegetablesMallServer.pojo.BannerList;
import com.FruitsVegetablesMallServer.pojo.GoodsDetail;
import com.FruitsVegetablesMallServer.service.AccountLoginService;
import com.FruitsVegetablesMallServer.service.AdminListService;
import com.FruitsVegetablesMallServer.service.BannerListService;
import com.FruitsVegetablesMallServer.service.GoodsDetailService;
import com.FruitsVegetablesMallServer.util.TokenRequired;
import com.FruitsVegetablesMallServer.util.TokenUtil;
import com.github.pagehelper.PageInfo;


@RestController
public class ManageController {
	
	@Autowired
	private AccountLoginService accountLoginService;
	@Autowired
	private AdminListService adminListService;
	@Autowired
	private BannerListService bannerListService;
	@Autowired
	private GoodsDetailService goodsDetailService;
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@RequestMapping(value = "/admin/login",method = RequestMethod.POST)
	public Map<String, String> accountLogin(@RequestBody AccountLogin accountLogin) {
		AccountLogin isAccountLogin = accountLoginService.queryAccountLogin(accountLogin.getUserName(), accountLogin.getPassword());
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
	@RequestMapping(value = "/manage",method = RequestMethod.GET)
	public AdminList getAdmin() {
		return adminListService.queryAdmin(TokenUtil.parseJWT(httpServletRequest.getHeader("Authorization")).getId());
	}

	// 添加图片
	@RequestMapping(value = "/manage/upload/image", method = RequestMethod.POST)
	@TokenRequired
	@ResponseBody
	public String uploadImage(@RequestParam("image") MultipartFile file)
			throws IOException {

		// 如果文件内容不为空，则写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/images/goods/";
			System.out.println("文件名称" + file.getOriginalFilename());
			// 上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);

			// 判断路径是否存在，没有就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}

			// 将上传文件保存到一个目标文档中
			File file1 = new File(path + File.separator + filename);
			file.transferTo(file1);
			return filename;
		} else {
			return null;
		}
	}
	
	@TokenRequired
	@RequestMapping(value = "/manage/add/banner",method = RequestMethod.POST)
	public String addBannerList(@RequestBody Map<String,String> data) {
		bannerListService.addBannerList(Integer.parseInt(data.get("orders")),data.get("imageUrl"),data.get("detail"));
		return "OK";
	}
	
	@TokenRequired
	@RequestMapping(value = "/manage/delete/banner/{id}",method = RequestMethod.DELETE)
	public String deleteBannerList(@PathVariable(value="id") Integer id) {
		bannerListService.deleteBannerList(id);
		return "OK";
	}
	
	
	@TokenRequired
	@RequestMapping(value = "/manage/banner",method = RequestMethod.GET)
	public Map<String,Object> queryAllBannerList(@RequestParam(value="current") int current
			,@RequestParam(value="pageSize") int pageSize) {
		PageInfo<BannerList> pageInfo = bannerListService.queryAllBannerList(current,pageSize);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("data", pageInfo.getList());
		data.put("total", pageInfo.getTotal());
		data.put("success", true);
		data.put("pageSize", pageInfo.getPageSize());
		data.put("current", pageInfo.getPageNum());
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/manage/update/banner",method = RequestMethod.PUT)
	public String updateBannerList(@RequestBody Map<String,String> data) {
		bannerListService.updateBannerList(Integer.parseInt(data.get("id")),Integer.parseInt(data.get("orders")),data.get("imageUrl")
				,data.get("detail"));
		return "OK";
	}
	
	@TokenRequired
	@RequestMapping(value = "/manage/add/goods",method = RequestMethod.POST)
	public String addGoodsDetail(@RequestBody Map<String,String> data) {
		goodsDetailService.addGoodsDetail(data.get("imageUrls"), Integer.parseInt(data.get("categoryId")), data.get("name")
				, Double.parseDouble(data.get("price")), Double.parseDouble(data.get("stock"))
				, data.get("specification"), Double.parseDouble(data.get("reducedPrice")), data.get("detail"));
		return "OK";
	}
	
	@TokenRequired
	@RequestMapping(value = "/manage/delete/goods/{id}",method = RequestMethod.DELETE)
	public String deleteGoodsDetail(@PathVariable(value="id") Integer id) {
		goodsDetailService.deleteGoodsDetail(id);
		return "OK";
	}
	
	
	@TokenRequired
	@RequestMapping(value = "/manage/goods",method = RequestMethod.GET)
	public Map<String,Object> queryAllGoodsDetail(@RequestParam(value="categoryId") int categoryId,@RequestParam(value="name") String name
			,@RequestParam(value="price") Double price,@RequestParam(value="stock") Double stock
			,@RequestParam(value="reducedPrice") Double reducedPrice,@RequestParam(value="current") int current
			,@RequestParam(value="pageSize") int pageSize) {
		PageInfo<GoodsDetail> pageInfo= goodsDetailService.queryAllGoodsDetail(categoryId,name,price==null?-1:price,
				stock==null?-1:stock,reducedPrice==null?-1:reducedPrice,current,pageSize);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("data", pageInfo.getList());
		data.put("total", pageInfo.getTotal());
		data.put("success", true);
		data.put("pageSize", pageInfo.getPageSize());
		data.put("current", pageInfo.getPageNum());
		return data;
	}
	
	@TokenRequired
	@RequestMapping(value = "/manage/update/goods",method = RequestMethod.PUT)
	public String updateGoodsDetail(@RequestBody GoodsDetail goodsDetail) {
		goodsDetailService.updateGoodsDetail(goodsDetail.getId(), goodsDetail.getImageUrls(), goodsDetail.getCategoryId()
				, goodsDetail.getName(), goodsDetail.getPrice(), goodsDetail.getStock(), goodsDetail.getSpecification()
				, goodsDetail.getReducedPrice(), goodsDetail.getDetail());
		return "OK";
	}
}
