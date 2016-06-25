package com.chenv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.OrdersMapper;
import com.chenv.pojo.Food;
import com.chenv.pojo.Orders;
import com.chenv.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public void add(Orders orders) {
		this.ordersMapper.insert(orders);

	}

	@Override
	public void delete(int id) {
		this.ordersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteAll() {
		this.ordersMapper.deleteAll();
	}

	@Override
	public void update(Orders orders) {
		this.ordersMapper.updateByPrimaryKey(orders);
	}

	@Override
	public List<Orders> listAll() {
		return this.ordersMapper.listAll();
	}

	@Override
	public Orders findById(int id) {
		return this.ordersMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Orders> listAll(int tableId) {
		Orders orders = new Orders();
		orders.setTableId(tableId);
		return this.ordersMapper.listAllByTableId(orders);
	}

	@Override
	public Orders findByTableId(int tableId) {
		return this.ordersMapper.selectByTableId(tableId);
	}

}
