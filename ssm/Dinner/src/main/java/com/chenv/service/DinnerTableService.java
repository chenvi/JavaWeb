package com.chenv.service;

import java.util.List;

import com.chenv.pojo.DinnerTable;
import com.chenv.pojo.FoodType;

public interface DinnerTableService {
	
	void add(DinnerTable dinnerTable);
	
	void delete(int id);
	
	void deleteAll();
	
	void update(DinnerTable dinnerTable);
	
	List<DinnerTable> listAll();
	
	List<DinnerTable> listAll(String tableName);

	DinnerTable findById(int id);
	
	void reserve(int id);
	
	void returnTable(int id);
}