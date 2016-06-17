package com.chenv.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenv.dao.FoodMapper;
import com.chenv.dao.FoodTypeMapper;
import com.chenv.pojo.Food;
import com.chenv.pojo.FoodType;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestDinner {
	
	@Autowired
	private FoodMapper foodMapper;
	@Autowired
	private FoodTypeMapper foodTypeMapper;
	
	@Test
	public void testFood(){
		FoodType foodType = new FoodType();
//		foodType.setId(5);
		foodType.setTypeName("好");
		foodTypeMapper.insert(foodType);
		
//		Food food = new Food();
//		food.setId(1);
//		food.setFoodName("番茄炒蛋");
//		foodMapper.insert(food);
		System.out.println(foodMapper.selectByPrimaryKey(1).getFoodName());
		
		
	}
}
