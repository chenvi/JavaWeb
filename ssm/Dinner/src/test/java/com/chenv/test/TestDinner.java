package com.chenv.test;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenv.dao.FoodMapper;
import com.chenv.dao.FoodTypeMapper;
import com.chenv.pojo.DinnerTable;
import com.chenv.pojo.Food;
import com.chenv.pojo.FoodType;
import com.chenv.pojo.OrderDetail;
import com.chenv.pojo.Orders;
import com.chenv.service.DinnerTableService;
import com.chenv.service.FoodService;
import com.chenv.service.FoodTypeService;
import com.chenv.service.OrderDetailService;
import com.chenv.service.OrdersService;
import com.mysql.fabric.xmlrpc.base.Data;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestDinner {
	
	@Autowired
	private FoodMapper foodMapper;
	@Autowired
	private FoodTypeMapper foodTypeMapper;
	@Autowired
	private FoodTypeService foodTypeService;
	@Autowired
	private DinnerTableService dinnerTableService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private OrdersService ordersService;
	
	@Test
	public void testFood(){
		foodTypeMapper.deleteAll();
		String foodtypeString = "鲁菜、川菜、粤菜、苏菜、闽菜、浙菜、湘菜、徽菜 ";
		String[] foodtypeStrings = foodtypeString.split("、");
		
		int i = 0;
		for (String string : foodtypeStrings) {
			FoodType foodType = new FoodType();
			foodType.setId(++i);
			foodType.setTypeName(string);
			foodTypeMapper.insert(foodType);
		}
		
//		List<FoodType> foodTypeList = foodTypeMapper.listAll();
//		Iterator<FoodType> iterator = foodTypeList.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next().getTypeName());
//		}
//		Food food = new Food();
//		food.setId(1);
//		food.setFoodName("番茄炒蛋");
//		foodMapper.insert(food);
//		System.out.println(foodMapper.selectByPrimaryKey(1).getFoodName());
				
	}
	
	@Test
	public void testFoodTypeService(){
//		this.foodTypeMapper.deleteAll();
		FoodType foodType = new FoodType();
		
		/**
		 * 测试添加
		 */
//		foodType.setId(1);
//		foodType.setTypeName("川菜");
//		this.foodTypeService.add(foodType);
		
		/**
		 * 测试更新 查找全部
		 */
//		foodType.setId(1);
//		foodType.setTypeName("川菜");
//		this.foodTypeService.update(foodType);
//		List<FoodType> foodTypes = this.foodTypeService.listAll();
//		Iterator<FoodType> iterator = foodTypes.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next().getTypeName());
//		}
		
		/**
		 * 测试根据菜名查找
		 */
		List<FoodType> foodTypes2 = this.foodTypeService.listAll("川菜");
		Iterator<FoodType> iterator2 = foodTypes2.iterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next().getTypeName());
		}
		
		/**
		 * 测试按照id查找
		 */
		System.out.println(this.foodTypeService.findById(1).getTypeName());
	}
	
	@Test
	public void testDinnerTableService(){
//		this.dinnerTableService.deleteAll();
//		Date date = new Date(new java.util.Date().getTime());
//		DinnerTable dinnerTable = new DinnerTable();
//		dinnerTable.setTableName("dongbeo1");
//		dinnerTable.setOrderDate(date);
//		dinnerTable.setTableStatus(1);
//		this.dinnerTableService.add(dinnerTable);
//		
//		List<DinnerTable> dinnerTables = this.dinnerTableService.listAll();
//		Iterator<DinnerTable> iterator = dinnerTables.iterator();
//		while (iterator.hasNext()) {
//			DinnerTable dinnerTable2 = (DinnerTable) iterator.next();
//			System.out.println(dinnerTable2.getTableName());
//		}
		
//		this.dinnerTableService.reserve(3);
		
		System.out.println(this.dinnerTableService.isExist("滕阁"));
	}
	
	@Test
	public void testFoodService(){
		this.foodService.deleteAll();
		Food food = new Food();
		food.setFoodName("西红柿炒蛋");
		food.setMprice(12.0);
		food.setPrice(15.0);
		
		this.foodService.add(food);
		
		List<Food> foods = this.foodService.listAll();
		Iterator iterator = foods.iterator();
		while (iterator.hasNext()) {
			Food food1 = (Food) iterator.next();
			System.out.println(food1.getFoodName());
			
		}
	}
	
	@Test
	public void testOrders(){
		Orders orders = new Orders();
		Date date = new Date(new java.util.Date().getTime());
		
		orders.setOrderDate(date);
		orders.setTableId(15);
		orders.setTableStatus(1);
		
		this.ordersService.add(orders);
		
		this.ordersService.listAll();
	}
}
