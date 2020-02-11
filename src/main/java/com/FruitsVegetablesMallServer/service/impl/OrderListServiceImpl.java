package com.FruitsVegetablesMallServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FruitsVegetablesMallServer.mapper.OrderListMapper;
import com.FruitsVegetablesMallServer.pojo.OrderList;
import com.FruitsVegetablesMallServer.service.OrderListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderListServiceImpl implements OrderListService{

	@Autowired
	private OrderListMapper orderListMapper;
	
	@Override
	public void addOrderList(String code, String date, String details, double amount, double discountAmount,
			double paidAmount, String receiver, String address, String mobile, String note, int userId, String status) {
		orderListMapper.addOrderList(code, date, details, amount, discountAmount, paidAmount, receiver, address, mobile
				, note, userId, status);
	}

	@Override
	public void deleteOrderList(int id) {
		orderListMapper.deleteOrderList(id);
	}

	@Override
	public PageInfo<OrderList> queryAllOrderList(String code, String date, String details, double amount,
			double discountAmount, double paidAmount, String receiver, String address, String mobile, String note,
			int userId, String status, int current, int pageSize) {
		PageHelper.startPage(current,pageSize);
		List<OrderList> list = orderListMapper.queryAllOrderList(code, date, details, amount, discountAmount, paidAmount, receiver
				, address, mobile, note, userId, status);
		PageInfo<OrderList> page = new PageInfo<OrderList>(list);
		return page;
	}

	@Override
	public OrderList queryCodeOrderList(String code) {
		return orderListMapper.queryCodeOrderList(code);
	}
	
	@Override
	public OrderList queryOrderList(int id) {
		return orderListMapper.queryOrderList(id);
	}

	@Override
	public void updateOrderList(int id, String code, String date, String details, double amount, double discountAmount,
			double paidAmount, String receiver, String address, String mobile, String note, int userId, String status) {
		orderListMapper.updateOrderList(id, code, date, details, amount, discountAmount, paidAmount, receiver, address, mobile
				, note, userId, status);
	}

}
