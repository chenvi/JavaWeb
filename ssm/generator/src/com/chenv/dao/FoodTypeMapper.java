package com.chenv.dao;

import com.chenv.pojo.FoodType;

public interface FoodTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FoodType record);

    int insertSelective(FoodType record);

    FoodType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoodType record);

    int updateByPrimaryKey(FoodType record);
}