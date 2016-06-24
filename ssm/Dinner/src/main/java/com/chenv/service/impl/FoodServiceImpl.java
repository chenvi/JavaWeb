package com.chenv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.FoodMapper;
import com.chenv.pojo.Food;
import com.chenv.pojo.FoodType;
import com.chenv.service.FoodService;

@Service("foodService")
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodMapper foodMapper;
	
	@Override
	public void add(Food food) {
		this.foodMapper.insert(food);
	}

	@Override
	public void delete(int id) {
		this.foodMapper.deleteByPrimaryKey(id);

	}

	
	
	@Override
	public void deleteAll() {
		this.foodMapper.deleteAll();
	}

	@Override
	public void update(Food food) {
		this.foodMapper.updateByPrimaryKey(food);
	}

	@Override
	public List<Food> listAll() {
		return this.foodMapper.listAll();
	}

	@Override
	public List<Food> listAll(String typeName) {
		Food food = new Food();
		food.setFoodName(typeName);
		return this.foodMapper.listAllByTypeName(food);
	}

	@Override
	public Food findById(int id) {
		return this.foodMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean isExist(String typeName) {
		Food food = new Food();
		food.setFoodName(typeName);
		return !this.foodMapper.listAllByTypeName(food).isEmpty();
	}

}
