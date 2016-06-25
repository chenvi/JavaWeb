package com.chenv.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.FoodMapper;
import com.chenv.dao.OrdersMapper;
import com.chenv.pojo.Food;
import com.chenv.pojo.OrderDetail;
import com.chenv.pojo.Orders;
import com.chenv.service.OrderDetailService;
import com.chenv.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private FoodMapper foodMapper;
	@Resource
	private OrderDetailService orderDetailService;

	
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

	@Override
	public double total(Orders orders) {
		
		List<OrderDetail> orderDetails =  this.orderDetailService.listAll(orders.getId());
		double total = 0.0;
		
		Iterator<OrderDetail> iterator = orderDetails.iterator();
		while (iterator.hasNext()) {
			OrderDetail orderDetail = (OrderDetail) iterator.next();
			Food food = this.foodMapper.selectByPrimaryKey(orderDetail.getFoodId());
			total += orderDetail.getFoodCount()*food.getPrice();
		}
		return total;
	}

}
