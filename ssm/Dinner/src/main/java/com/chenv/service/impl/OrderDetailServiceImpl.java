package com.chenv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.OrderDetailMapper;
import com.chenv.pojo.OrderDetail;
import com.chenv.service.OrderDetailService;

@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Override
	public void add(OrderDetail orderDetail) {
		this.orderDetailMapper.insert(orderDetail);
	}

	@Override
	public void delete(int id) {
		this.orderDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteAll() {
		this.orderDetailMapper.deleteAll();
	}

	@Override
	public void update(OrderDetail orderDetail) {
		this.orderDetailMapper.updateByPrimaryKey(orderDetail);
	}

	@Override
	public List<OrderDetail> listAll() {
		return this.orderDetailMapper.listAll();
	}

	@Override
	public OrderDetail findById(int id) {
		return this.orderDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<OrderDetail> listAll(int orderId) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderId(orderId);
		return this.orderDetailMapper.listAllByOrderId(orderDetail);
	}

	@Override
	public void deleteOrderId(int orderId) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderId(orderId);
		this.orderDetailMapper.deleteByOrderId(orderDetail);
	}

}
