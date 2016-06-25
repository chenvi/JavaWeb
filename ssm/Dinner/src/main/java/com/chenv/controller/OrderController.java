package com.chenv.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.BillDetail;
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

@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	private OrdersService ordersService;
	@Resource
	private OrderDetailService orderDetailService;
	@Resource
	private FoodService foodService;
	@Resource
	private DinnerTableService dinnerTableService;
	
	@RequestMapping("to")
	public String to(HttpServletRequest request){
		
		String page = request.getParameter("page");
		if("foodtypeUpdate".equals(page)){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("foodtype", this.ordersService.findById(id));
			return page;
		} 
		return page;
	}		
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model){
		List<Orders> ordersList = this.ordersService.listAll();
		model.addAttribute("orders", ordersList);
		return "orders";
	}
	
	@RequestMapping("detail")
	public String detail(HttpServletRequest request, Model model){
		//根据订单号获取订单的菜单
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		List<OrderDetail> orderDetails = this.orderDetailService.listAll(orderId);
		
		List<Food> foodList = this.foodService.listAll();
		Map<OrderDetail, Food> map = new LinkedHashMap<OrderDetail, Food>();
		
		Iterator<OrderDetail> iterator = orderDetails.iterator();
		while (iterator.hasNext()) {
			OrderDetail orderDetail = (OrderDetail) iterator.next();
			map.put(orderDetail, this.foodService.findById(orderDetail.getFoodId()));
		}
		
		model.addAttribute("map", map);
		return "orderDetail";
	}
	
	@RequestMapping("dinner")
	public String dinner(HttpServletRequest request, Model model){
		List<Food> foods = this.foodService.listAll();
		List<DinnerTable> dinnerTables = this.dinnerTableService.listAll();
		model.addAttribute("foods",foods);
		model.addAttribute("dinnerTables",dinnerTables);
		return "account";
	}
	
	@RequestMapping("bill")
	public String bill(HttpServletRequest request, Model model){
		List<Food> foods = this.foodService.listAll();
		List<DinnerTable> dinnerTables = this.dinnerTableService.listAll();
		String tableId = request.getParameter("tableId");
		
		//添加订单
		if (tableId!=null) {
			Orders orders = new Orders();
			Date date = new Date(new java.util.Date().getTime());
			orders.setOrderDate(date);
			orders.setTableId(Integer.parseInt(tableId));
			orders.setTableStatus(1);
			
			DinnerTable dinnerTable = new DinnerTable();
			dinnerTable.setId(Integer.parseInt(tableId));
			dinnerTable.setTableStatus(1);
			dinnerTable.setOrderDate(date);
			this.dinnerTableService.update(dinnerTable);
			
			this.ordersService.add(orders);
		};
		
		//根据订单号添加菜
		Orders orders = this.ordersService.findByTableId(Integer.parseInt(tableId));		
		Iterator<Food> iterator = foods.iterator();
		while (iterator.hasNext()) {
			Food food = (Food) iterator.next();
			if (request.getParameter("foodId"+food.getId())!=null) {
				
				int num = Integer.parseInt(request.getParameter(food.getId()+":num"));
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setFoodId(food.getId());
				orderDetail.setFoodCount(num);
				orderDetail.setOrderId(orders.getId());
			    
				this.orderDetailService.add(orderDetail);
			}
		}
		
		model.addAttribute("msg","下单成功！！！");
		return "success";
	}
	
	//结账
	@RequestMapping("check")
	public String check(HttpServletRequest request, Model model){
		//根据订单id结账 利用tableId进行退桌
		int id = Integer.parseInt(request.getParameter("id"));
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		List<OrderDetail> orderDetails = this.orderDetailService.listAll(id);
		
		//利用List存放账单
		List<BillDetail> bills = new ArrayList<BillDetail>();
		
		Iterator<OrderDetail> iterator = orderDetails.iterator();
		while (iterator.hasNext()) {
			OrderDetail orderDetail = (OrderDetail) iterator.next();
			
			BillDetail bill = new BillDetail();
			
			bill.setFoodName(this.foodService.findById(orderDetail.getFoodId()).getFoodName());
			bill.setFoodValue(this.foodService.findById(orderDetail.getFoodId()).getPrice());
			bill.setFoodCount(orderDetail.getFoodCount());
			bill.setFoodSum();
			
			bills.add(bill);
		}
		
		Date orderDate = this.ordersService.findById(id).getOrderDate();
		this.orderDetailService.deleteOrderId(id);
		this.ordersService.delete(id);
		this.dinnerTableService.returnTable(tableId);
		
		model.addAttribute("orderDate",orderDate);
		model.addAttribute("bills",bills);
		model.addAttribute("msg","结账成功！");
		return "bills";		
	}
//	@RequestMapping("add")
//	public String add(HttpServletRequest request, Model model){
//		String foodTypeName = request.getParameter("foodtypename");
//		if (this.ordersService.isExist(foodTypeName)) {
//			model.addAttribute("msg","菜系已经存在！！！");
//			return "error";
//		}
//		
//		else {
//			FoodType foodType = new FoodType();
//			foodType.setTypeName(foodTypeName);
//			
//			this.ordersService.add(foodType);
//			
//			List<Orders> ordersList= this.ordersService.listAll();
//			
//			model.addAttribute("orders", ordersList);
//			return "orders";
//		}
//		
//		
//	}
	
//	@RequestMapping("delete")
//	public String delete(HttpServletRequest request, Model model){
//		int id = Integer.parseInt(request.getParameter("id"));
//		this.ordersService.delete(id);
//		
//		List<Orders> ordersList =this.ordersService.listAll();
//		
//		model.addAttribute("orders", ordersList);
//		return "orders";
//	}
//	
//	@RequestMapping("update")
//	public String update(HttpServletRequest request, Model model){
//		FoodType foodType = new FoodType();
//		int id = Integer.parseInt(request.getParameter("id"));
//		String foodtype = request.getParameter("foodtypename");
//		
//		foodType.setId(id);
//		foodType.setTypeName(foodtype);
//		
//		this.ordersService.update(foodType);
//		List<Orders> ordersList=this.ordersService.listAll();
//		
//		model.addAttribute("orders", ordersList);
//		return "orders";
//	}
//	
//	@RequestMapping("search")
//	public String search(HttpServletRequest request, Model model){
//		String serachName = (String) request.getParameter("foodtypename");
//		List<Orders> ordersList = null;
//		if(!serachName.isEmpty())
//			ordersList =this.ordersService.listAll(serachName);
//		else {
//			ordersList = this.ordersService.listAll();
//		}
//		model.addAttribute("orders", ordersList);
//		return "orders";
//	}
}
