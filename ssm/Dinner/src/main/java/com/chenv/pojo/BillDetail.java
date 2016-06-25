package com.chenv.pojo;

import java.util.Date;

public class BillDetail {
	private String foodName;
	
	private double foodValue;
	
	private int foodCount;

	private double foodSum;

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodValue() {
		return foodValue;
	}

	public void setFoodValue(double foodValue) {
		this.foodValue = foodValue;
	}

	public int getFoodCount() {
		return foodCount;
	}

	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}

	public double getFoodSum() {
		return foodSum;
	}

	public void setFoodSum() {
		this.foodSum = foodCount*foodValue;
	}
	
}
