package com.chenv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.FoodType;
import com.chenv.service.FoodTypeService;

@Controller
@RequestMapping("/foodtype")
public class FoodTypeController {
	@Resource
	private FoodTypeService foodTypeService;
	
	@RequestMapping("to")
	public String to(HttpServletRequest request){
		
		String page = request.getParameter("page");
		if("foodtypeUpdate".equals(page)){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("foodtype", this.foodTypeService.findById(id));
			return page;
		} 
		return page;
	}		
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model){
		List<FoodType> foodTypeList = this.foodTypeService.listAll();
		model.addAttribute("foodtypes", foodTypeList);
		return "foodtype";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request, Model model){
		String foodTypeName = request.getParameter("foodtypename");
		if (this.foodTypeService.isExist(foodTypeName)) {
			model.addAttribute("msg","菜系已经存在！！！");
			return "error";
		}
		
		else {
			FoodType foodType = new FoodType();
			foodType.setTypeName(foodTypeName);
			
			this.foodTypeService.add(foodType);
			
			List<FoodType> foodTypeList = this.foodTypeService.listAll();
			
			model.addAttribute("foodtypes", foodTypeList);
			return "foodtype";
		}
		
		
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		this.foodTypeService.delete(id);
		
		List<FoodType> foodTypeList =this.foodTypeService.listAll();
		
		model.addAttribute("foodtypes", foodTypeList);
		return "foodtype";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model){
		FoodType foodType = new FoodType();
		int id = Integer.parseInt(request.getParameter("id"));
		String foodtype = request.getParameter("foodtypename");
		
		foodType.setId(id);
		foodType.setTypeName(foodtype);
		
		this.foodTypeService.update(foodType);
		List<FoodType> foodTypeList =this.foodTypeService.listAll();
		
		model.addAttribute("foodtypes", foodTypeList);
		return "foodtype";
	}
	
	@RequestMapping("search")
	public String search(HttpServletRequest request, Model model){
		String serachName = (String) request.getParameter("foodtypename");
		List<FoodType> foodTypeList = null;
		if(!serachName.isEmpty())
			foodTypeList =this.foodTypeService.listAll(serachName);
		else {
			foodTypeList = this.foodTypeService.listAll();
		}
		model.addAttribute("foodtypes", foodTypeList);
		return "foodtype";
	}
}
