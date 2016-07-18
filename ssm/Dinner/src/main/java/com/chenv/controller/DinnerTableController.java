package com.chenv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.DinnerTable;
import com.chenv.service.DinnerTableService;

@Controller
@RequestMapping("/dinnertable")
public class DinnerTableController {
	@Resource
	private DinnerTableService dinnerTableService;
	
	@RequestMapping("to")
	public String to(HttpServletRequest request){
		//获取页面跳转
		String page = request.getParameter("page");
		if("foodtypeUpdate".equals(page)){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("foodtype", this.dinnerTableService.findById(id));
			return page;
		} 
		return page;
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model){
		List<DinnerTable> dinnerTableList = this.dinnerTableService.listAll();
		model.addAttribute("dinnertables", dinnerTableList);
		return "dinnertable";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request, Model model){
		String tableName = request.getParameter("tablename");
		
		if (this.dinnerTableService.isExist(tableName)) {
			model.addAttribute("msg","餐桌已经存在！！！");
			return "error";
		}
		
		else {
			DinnerTable dinnerTable = new DinnerTable();
			dinnerTable.setTableName(tableName);
			dinnerTable.setTableStatus(0);
			
			this.dinnerTableService.add(dinnerTable);
			
			List<DinnerTable> dinnerTableList = this.dinnerTableService.listAll();
			
			model.addAttribute("dinnertables", dinnerTableList);
			return "dinnertable";
		}
		
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		this.dinnerTableService.delete(id);
		
		List<DinnerTable> dinnerTableList =this.dinnerTableService.listAll();
		
		model.addAttribute("dinnertables", dinnerTableList);
		return "dinnertable";
	}
	
	@RequestMapping("reserve")
	public String reserve(HttpServletRequest request, Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		List<DinnerTable> dinnerTableList = null;
		
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
	
	@RequestMapping("clean")
	public String clean(HttpServletRequest request, Model model){
		DinnerTable dinnerTable = new DinnerTable();
		int id = Integer.parseInt(request.getParameter("id"));
		
		//dinnerTable.setId(id);
		
		this.dinnerTableService.returnTable(id);
		
		List<DinnerTable> dinnerTableList =this.dinnerTableService.listAll();
		
		model.addAttribute("dinnertables", dinnerTableList);
		return "dinnertable";
	}
	
	@RequestMapping("search")
	public String search(HttpServletRequest request, Model model){
		String serachName = (String) request.getParameter("tableName");
		List<DinnerTable> dinnerTableList = null;
		
		if(!serachName.isEmpty())
			dinnerTableList =this.dinnerTableService.listAll(serachName);
		else {
			dinnerTableList = this.dinnerTableService.listAll();
		}
		model.addAttribute("dinnertables", dinnerTableList);
		return "dinnertable";
	}
}
