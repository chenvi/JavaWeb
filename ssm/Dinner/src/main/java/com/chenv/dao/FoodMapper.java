package com.chenv.dao;

import java.util.List;

import com.chenv.pojo.Food;
import com.chenv.pojo.FoodType;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteAll();

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Integer id);

    List<Food> listAll();
    
    List<Food> listAllByTypeName(Food record);
    
    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}