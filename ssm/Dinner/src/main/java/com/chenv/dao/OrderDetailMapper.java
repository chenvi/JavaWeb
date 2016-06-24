package com.chenv.dao;

import java.util.List;

import com.chenv.pojo.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteAll();
    
    List<OrderDetail> listAll();
    
    List<OrderDetail> listAllByOrderId(OrderDetail record);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}