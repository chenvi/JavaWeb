package com.chenv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.DinnerTable;
import com.chenv.pojo.FoodType;
import com.chenv.service.DinnerTableService;

@Controller
@RequestMapping("/dinnertable")
public class DinnerTableController {
	@Resource
	private DinnerTableService dinnerTableService;
	
	@RequestMapping("todo")
	public String toDo(HttpServletRequest request){
		//获取页面跳转
		String toDoService = request.getParameter("service");
		if(toDoService.equals("foodtypeUpdate")){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("foodtype", this.dinnerTableService.findById(id));
			return toDoService;
		} 
		return toDoService;
	}
	
	@RequestMapping("dinnertable")
	public String dinnertable(HttpServletRequest request,Model model){
		List<DinnerTable> dinnerTableList = null;
		
		//到菜系列表的页面
		if(request.getParameter("method").equals("index")){
			dinnerTableList = this.dinnerTableService.listAll();
			model.addAttribute("dinnertables", dinnerTableList);
			return "dinnertable";
		}
		
		//处理搜索
		if(request.getParameter("method").equals("search")){
			String serachName = (String) request.getParameter("tableName");

			if(!serachName.isEmpty())
				dinnerTableList =this.dinnerTableService.listAll(serachName);
			else {
				dinnerTableList = this.dinnerTableService.listAll();
			}
			model.addAttribute("dinnertables", dinnerTableList);
			return "dinnertable";
		}
		
		//预定
		if(request.getParameter("method").equals("reserve")){
			int id = Integer.parseInt(request.getParameter("id"));

			if(id != 0){
				this.dinnerTableService.reserve(id);
				dinnerTableList = this.dinnerTableService.listAll();
			}				
			else {
				dinnerTableList = this.dinnerTableService.listAll();
			}
			model.addAttribute("dinnertables", dinnerTableList);
			return "dinnertable";
		}
		
		//处理更新
		if (request.getParameter("method").equals("return")) {
			DinnerTable dinnerTable = new DinnerTable();
			int id = Integer.parseInt(request.getParameter("id"));
			
			dinnerTable.setId(id);
			
			this.dinnerTableService.returnTable(id);
			
			dinnerTableList =this.dinnerTableService.listAll();
			
			model.addAttribute("dinnertables", dinnerTableList);
			return "dinnertable";
		}
		
		//处理删除
		if (request.getParameter("method").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			this.dinnerTableService.delete(id);
			
			dinnerTableList =this.dinnerTableService.listAll();
			
			model.addAttribute("dinnertables", dinnerTableList);
			return "dinnertable";
		}
		
		//添加
		if (request.getParameter("method").equals("add")) {
			String tableName = request.getParameter("tablename");
			DinnerTable dinnerTable = new DinnerTable();
			dinnerTable.setTableName(tableName);
			dinnerTable.setTableStatus(0);
			
			this.dinnerTableService.add(dinnerTable);;
			
			dinnerTableList = this.dinnerTableService.listAll();
			
			model.addAttribute("dinnertables", dinnerTableList);
			return "dinnertable";
		}
		return null;
	}
	
}
