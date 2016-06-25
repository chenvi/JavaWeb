package com.chenv.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.Food;
import com.chenv.service.FoodService;
import com.chenv.service.FoodTypeService;

@Controller
@RequestMapping("/food")
public class FoodController {
	@Resource
	private FoodService foodService;
	@Resource
	private FoodTypeService foodTypeService;
	
	@RequestMapping("to")
	public String to(HttpServletRequest request,Model model){
		
		String page = request.getParameter("page");
		
		if("foodUpdate".equals(page)){
			int id = Integer.parseInt(request.getParameter("id"));
			model.addAttribute("foodType",this.foodTypeService.listAll());
			model.addAttribute("food", this.foodService.findById(id));
			return page;
		}
		if("foodAdd".equals(page)){
			model.addAttribute("foodType",this.foodTypeService.listAll());
			return "foodAdd";
		}
		return page;
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model){
		List<Food> foodList = this.foodService.listAll();
		Map<Food, String> map = new LinkedHashMap<Food, String>();
		
		Iterator<Food> iterator = foodList.iterator();
		while (iterator.hasNext()) {
			Food food = (Food) iterator.next();
			map.put(food, this.foodTypeService.findById(food.getFoodTypeId()).getTypeName());
		}
		
		model.addAttribute("map", map);
		return "food";
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request, Model model){
		
		String foodName = request.getParameter("foodname");
		
		if (this.foodService.isExist(foodName)) {
			model.addAttribute("msg","菜名已经存在！！！");
			return "error";
		}
		
		else {
				int foodTypeId = Integer.parseInt(request.getParameter("foodTypeId"));
				double price = Double.parseDouble(request.getParameter("price"));
				double mprice = Double.parseDouble(request.getParameter("mprice"));
				String mark = request.getParameter("mark");
				String img = request.getParameter("img");
				
				Food food = new Food();
				food.setFoodName(foodName);
				food.setFoodTypeId(foodTypeId);
				food.setPrice(price);
				food.setMprice(mprice);
				food.setRemark(mark);
				food.setImg(img);
				
				this.foodService.add(food);
				
				return "foodtmp";
				 
		}
		
		
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		this.foodService.delete(id);
		
		return "foodtmp";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model){
		Food food= new Food();
		int id = Integer.parseInt(request.getParameter("id"));
		String foodName = request.getParameter("foodName");
		int foodTypeId = Integer.parseInt(request.getParameter("foodTypeId"));
		double price = Double.parseDouble(request.getParameter("price"));
		double mprice = Double.parseDouble(request.getParameter("mprice"));
		String mark = request.getParameter("mark");
		String img = request.getParameter("img");
		
		food.setId(id);
		food.setFoodName(foodName);
		food.setFoodTypeId(foodTypeId);
		food.setPrice(price);
		food.setMprice(mprice);
		food.setRemark(mark);
		food.setImg(img);
		
		this.foodService.update(food);
		
		return "foodtmp";
	}

	@RequestMapping("search")
	public String search(HttpServletRequest request, Model model){
		String serachName = (String) request.getParameter("foodname");
		List<Food> foodList = null;
		
		if(!serachName.isEmpty())
			foodList =this.foodService.listAll(serachName);
		else {
			foodList = this.foodService.listAll();
		}
		model.addAttribute("foods", foodList);
		
		Map<Food, String> map = new LinkedHashMap<Food, String>();		
		Iterator<Food> iterator = foodList.iterator();
		while (iterator.hasNext()) {
			Food food = (Food) iterator.next();
			map.put(food, this.foodTypeService.findById(food.getFoodTypeId()).getTypeName());
		}
		
		model.addAttribute("map", map);
		return "food";
	}
	
}
