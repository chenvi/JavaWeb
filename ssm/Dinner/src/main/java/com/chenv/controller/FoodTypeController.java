package com.chenv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
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
	
	@RequestMapping("todo")
	public String toDo(HttpServletRequest request){
		//获取页面跳转
		String toDoService = request.getParameter("service");
		if(toDoService.equals("foodtypeUpdate")){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("foodtype", this.foodTypeService.findById(id));
			return toDoService;
		} 
		return toDoService;
	}
	
	@RequestMapping("foodtype")
	public String foodtype(HttpServletRequest request, Model model){
		List<FoodType> foodTypeList = null;
		
		//到菜系列表的页面
		if(request.getParameter("method").equals("index")){
			foodTypeList = this.foodTypeService.listAll();
			model.addAttribute("foodtypes", foodTypeList);
			return "foodtype";
		}
		
		//处理搜索
		if(request.getParameter("method").equals("search")){
			String serachName = (String) request.getParameter("foodtypename");

			if(!serachName.isEmpty())
				foodTypeList =this.foodTypeService.listAll(serachName);
			else {
				foodTypeList = this.foodTypeService.listAll();
			}
			model.addAttribute("foodtypes", foodTypeList);
			return "foodtype";
		}
		
		//处理更新
		if (request.getParameter("update") != null) {
			FoodType foodType = new FoodType();
			int id = Integer.parseInt(request.getParameter("id"));
			String foodtype = request.getParameter("foodtypename");
			
			foodType.setId(id);
			foodType.setTypeName(foodtype);
			
			this.foodTypeService.update(foodType);
			foodTypeList =this.foodTypeService.listAll();
			
			model.addAttribute("foodtypes", foodTypeList);
			return "foodtype";
		}
		
		//处理删除
		if (request.getParameter("method").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			this.foodTypeService.delete(id);
			
			foodTypeList =this.foodTypeService.listAll();
			
			model.addAttribute("foodtypes", foodTypeList);
			return "foodtype";
		}
		
		//添加
		if (request.getParameter("method").equals("add")) {
			String foodTypeName = request.getParameter("foodtypename");
			FoodType foodType = new FoodType();
			foodType.setTypeName(foodTypeName);
			
			this.foodTypeService.add(foodType);
			
			foodTypeList = this.foodTypeService.listAll();
			
			model.addAttribute("foodtypes", foodTypeList);
			return "foodtype";
		}
		return null;
	}
	
}
