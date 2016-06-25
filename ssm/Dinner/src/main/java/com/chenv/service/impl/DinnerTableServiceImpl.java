package com.chenv.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.DinnerTableMapper;
import com.chenv.pojo.DinnerTable;
import com.chenv.pojo.FoodType;
import com.chenv.service.DinnerTableService;

@Service("dinnerTableService")
public class DinnerTableServiceImpl implements DinnerTableService {

	@Autowired
	private DinnerTableMapper dinnerTableMapper;
	
	@Override
	public void add(DinnerTable dinnerTable) {
		this.dinnerTableMapper.insert(dinnerTable);
	}

	@Override
	public void delete(int id) {
		this.dinnerTableMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteAll() {
		this.dinnerTableMapper.deleteAll();
		
	}

	@Override
	public void update(DinnerTable dinnerTable) {
		this.dinnerTableMapper.updateById(dinnerTable);

	}

	@Override
	public List<DinnerTable> listAll() {
		return this.dinnerTableMapper.listAll();
	}

	@Override
	public List<DinnerTable> listAll(String tableName) {
		DinnerTable dinnerTable = new DinnerTable();
		dinnerTable.setTableName(tableName);
		return this.dinnerTableMapper.listAllByTypeName(dinnerTable);
	}

	@Override
	public DinnerTable findById(int id) {
		return null;
	}

	@Override
	public void reserve(int id) {
		Date date = new Date(new java.util.Date().getTime());
		DinnerTable dinnerTable = new DinnerTable();
		dinnerTable.setOrderDate(date);
		dinnerTable.setTableStatus(1);
		dinnerTable.setId(id);
		
		this.dinnerTableMapper.updateById(dinnerTable);
	}

	@Override
	public void returnTable(int id) {
		DinnerTable dinnerTable = new DinnerTable();
		dinnerTable.setOrderDate(null);
		dinnerTable.setTableStatus(0);
		dinnerTable.setId(id);
		
		this.dinnerTableMapper.updateById(dinnerTable);
	}

	@Override
	public boolean isExist(String tableName) {
		DinnerTable dinnerTable = new DinnerTable();
		dinnerTable.setTableName(tableName);
		
		return !this.dinnerTableMapper.listAllByTypeName(dinnerTable).isEmpty();
	}
	
	

	
}
