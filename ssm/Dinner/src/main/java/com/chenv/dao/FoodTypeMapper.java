package com.chenv.dao;

import java.util.List;

import com.chenv.pojo.FoodType;

public interface FoodTypeMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteAll();

    int insert(FoodType record);

    int insertSelective(FoodType record);

    FoodType selectByPrimaryKey(Integer id);
    
    List<FoodType> listAll();
    
    List<FoodType> listAllByTypeName(FoodType record);

    int updateByPrimaryKeySelective(FoodType record);

    int updateByPrimaryKey(FoodType record);
    
}