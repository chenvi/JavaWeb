package com.chenv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.Food;
import com.chenv.pojo.FoodType;
import com.chenv.service.FoodService;
import com.chenv.service.FoodTypeService;

@Controller
@RequestMapping("/food")
public class FoodController {
	@Resource
	private FoodService foodService;
	@Resource
	private FoodTypeService foodTypeService;
	
	@RequestMapping("todo")
	public String toDo(HttpServletRequest request,Model model){
		//获取页面跳转
		String toDoService = request.getParameter("service");
		if(toDoService.equals("foodUpdate")){
			int id = Integer.parseInt(request.getParameter("id"));
			model.addAttribute("food", this.foodService.findById(id));
			return toDoService;
		}
		if(toDoService.equals("foodAdd")){
			model.addAttribute("foodType",this.foodTypeService.listAll());
			return "foodAdd";
		}
		return toDoService;
	}
	
	
	@RequestMapping("food")
	public String food(HttpServletRequest request, Model model){
		List<Food> foodList = null;
		
		//到菜系列表的页面
		if(request.getParameter("method").equals("index")){
			foodList = this.foodService.listAll();
			model.addAttribute("foods", foodList);
			// TODO 完成菜系显示
			return "food";
		}
		
		//处理搜索
		if(request.getParameter("method").equals("search")){
			String serachName = (String) request.getParameter("foodname");

			if(!serachName.isEmpty())
				foodList =this.foodService.listAll(serachName);
			else {
				foodList = this.foodService.listAll();
			}
			model.addAttribute("foods", foodList);
			return "food";
		}
		
		//处理更新
		if (request.getParameter("update") != null) {
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
			foodList =this.foodService.listAll();
			
			model.addAttribute("foods", foodList);
			return "food";
		}
		
		//处理删除
		if (request.getParameter("method").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			this.foodService.delete(id);
			
			foodList =this.foodService.listAll();
			
			model.addAttribute("foods", foodList);
			return "food";
		}
		
		//添加
		if (request.getParameter("method").equals("add")) {
			String foodName = request.getParameter("foodname");
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
			
			foodList = this.foodService.listAll();
			
			model.addAttribute("foods", foodList);
			return "food";
		}
		return null;
	}
	
}
