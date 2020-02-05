package com.FruitsVegetablesMallServer.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.FruitsVegetablesMallServer.pojo.AdminList;

@Mapper
public interface AdminListMapper {
	
	
	//void addAdmin(String imageUrl);
	
	//void deleteAdmin(int id);
	
	//List<BannerList> queryAdmin();
	
	AdminList queryAdmin(String userName);
	
	//void updateAdmin(int id,String imageUrl);
}
