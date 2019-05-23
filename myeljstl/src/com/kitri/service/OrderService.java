package com.kitri.service;

import java.util.List;

import com.kitri.dao.OrderDao;
import com.kitri.dto.OrderInfo;
import com.kitri.exception.AddException;

public class OrderService {
	
	private OrderDao dao;
	
	public OrderService() {
		dao = new OrderDao();
	}
	
	public void addOrder(OrderInfo info) throws AddException {
		dao.insert(info);
		
	}
	
	public List<OrderInfo> findById(String id){
		
		return dao.selectById(id);
	}
	
}
