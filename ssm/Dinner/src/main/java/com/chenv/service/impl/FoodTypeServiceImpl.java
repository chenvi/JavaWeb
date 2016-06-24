package com.chenv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.FoodTypeMapper;
import com.chenv.pojo.FoodType;
import com.chenv.service.FoodTypeService;

@Service("foodTypeService")
public class FoodTypeServiceImpl implements FoodTypeService {

	@Autowired
	private FoodTypeMapper foodTypeMapper;
	
	@Override
	public void add(FoodType foodType) {
		this.foodTypeMapper.insert(foodType);
	}

	@Override
	public void delete(int id) {
		this.foodTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(FoodType foodType) {
		this.foodTypeMapper.updateByPrimaryKey(foodType);
	}

	@Override
	public List<FoodType> listAll() {
		return this.foodTypeMapper.listAll();
	}

	@Override
	public List<FoodType> listAll(String typeName) {
		FoodType foodType = new FoodType();
		foodType.setTypeName(typeName);
		return this.foodTypeMapper.listAllByTypeName(foodType);
	}

	@Override
	public FoodType findById(int id) {
		return this.foodTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean isExist(String typeName) {
		FoodType foodType = new FoodType();
		foodType.setTypeName(typeName);
		return !this.foodTypeMapper.listAllByTypeName(foodType).isEmpty();
	}

}
