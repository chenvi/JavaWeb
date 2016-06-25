package com.chenv.service;

import java.util.List;

import com.chenv.pojo.Food;
import com.chenv.pojo.Orders;



public interface OrdersService {
	
	void add(Orders orders);
	
	void delete(int id);
	
	void deleteAll();
	
	void update(Orders orders);
	
	List<Orders> listAll();
	
	List<Orders> listAll(int tableId);
	
	Orders findById(int id);
	
	Orders findByTableId(int tableId);
}
