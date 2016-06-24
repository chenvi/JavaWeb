package com.chenv.service;

import java.util.List;

import com.chenv.pojo.Food;



public interface FoodService {
	
	void add(Food food);
	
	void delete(int id);
	
	void deleteAll();
	
	void update(Food food);
	
	List<Food> listAll();
	
	List<Food> listAll(String typeName);

	Food findById(int id);
	
	boolean isExist(String typeName);
}
