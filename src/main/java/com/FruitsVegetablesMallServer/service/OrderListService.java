package com.FruitsVegetablesMallServer.service;

import com.FruitsVegetablesMallServer.pojo.OrderList;
import com.github.pagehelper.PageInfo;

public interface OrderListService {

	void addOrderList(String code, String date, String details, double amount, double discountAmount, double paidAmount
			, String receiver, String address, String mobile,String note, int userId, String status);
	
	void deleteOrderList(int id);
	
	PageInfo<OrderList> queryAllOrderList(String code, String date, String details, double amount, double discountAmount
			, double paidAmount, String receiver, String address, String mobile,String note, int userId, String status
			, int current, int pageSize);
	
	
	OrderList queryCodeOrderList(String code);
	
	OrderList queryOrderList(int id);
	
	void updateOrderList(int id, String code, String date, String details, double amount, double discountAmount, double paidAmount
			, String receiver, String address, String mobile,String note, int userId, String status);
}
