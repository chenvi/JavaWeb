package com.chenv.dao;

import java.util.List;

import com.chenv.pojo.Food;
import com.chenv.pojo.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteAll();
    
    List<Orders> listAll();
    
    List<Orders> listAllByTableId(Orders record);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}