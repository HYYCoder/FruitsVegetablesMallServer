package com.FruitsVegetablesMallServer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FruitsVegetablesMallServer.pojo.OrderList;

@Mapper
public interface OrderListMapper {

	void addOrderList(String code, String date, String details, double amount, double discountAmount, double paidAmount
			, String receiver, String address, String mobile,String note, int userId, String status);
	
	void deleteOrderList(int id);
	
	List<OrderList> queryAllOrderList(String code, String date, String details, double amount, double discountAmount
			, double paidAmount, String receiver, String address, String mobile,String note, int userId, String status);
	
	OrderList queryCodeOrderList(String code);
	
	OrderList queryOrderList(int id);
	
	void updateOrderList(int id, String code, String date, String details, double amount, double discountAmount, double paidAmount
			, String receiver, String address, String mobile,String note, int userId, String status);
}
