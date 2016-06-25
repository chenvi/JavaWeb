package com.chenv.service;

import java.util.List;

import com.chenv.pojo.Food;
import com.chenv.pojo.OrderDetail;
import com.chenv.pojo.Orders;



public interface OrderDetailService {
	
	void add(OrderDetail orderDetail);
	
	void delete(int id);
	
	void deleteOrderId(int orderId);
	
	void deleteAll();
	
	void update(OrderDetail orderDetail);
	
	List<OrderDetail> listAll();
	
	List<OrderDetail> listAll(int orderId);
	
	OrderDetail findById(int id);
}
