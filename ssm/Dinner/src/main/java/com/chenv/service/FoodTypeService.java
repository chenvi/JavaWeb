package com.chenv.service;

import java.util.List;

import com.chenv.pojo.FoodType;

public interface FoodTypeService {
	
	void add(FoodType foodType);
	
	void delete(int id);
	
	void update(FoodType foodType);
	
	List<FoodType> listAll();
	
	List<FoodType> listAll(String typeName);

	FoodType findById(int id);
	
	boolean isExist(String typeName);
}
