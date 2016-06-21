package com.chenv.dao;

import com.chenv.pojo.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteAll();

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}