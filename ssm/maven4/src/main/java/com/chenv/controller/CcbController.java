package com.chenv.controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.Student;
import com.chenv.service.CcbService;



@Controller
@RequestMapping("/ccb")
public class CcbController {
  @Resource
  private CcbService ccbService;
  
  @RequestMapping("/login")
  public String toLogin(HttpServletRequest request,Model model){
    String cardnum = request.getParameter("cardnum");
    String pwd = request.getParameter("pwd");
    if (this.ccbService.login(cardnum, pwd)) {
    	 return "main";
	} else {
		request.setAttribute("errorMeg", "账号或者密码错误！！！");
		return "login";
	}
//    model.addAttribute("account", account);
   
  }
  
  @RequestMapping("/todo")
  public String toDo(HttpServletRequest request,Model model){
	  String aService = request.getParameter("service");
	  if(aService!=null) return aService;
	  if(request.getParameter("cancel")!=null) return "main";
	  if(request.getParameter("sure")!=null) return "success";
	  return "main";
  }
  
  @RequestMapping("/balance")
  public String balance(HttpServletRequest request,Model model){
	  model.addAttribute("account", this.ccbService.queryBalance());
	  return "balance";
  }
  
  @RequestMapping("/fetch")
  public String fetch(HttpServletRequest request,Model model){
	  if(request.getParameter("cancel")!=null) return "main";
	  if(request.getParameter("sure")!=null) {
		  this.ccbService.fetch(Double.parseDouble(request.getParameter("money")));
		  model.addAttribute("message", "请取钞！！！");
		  return "success";
	  }
	  return "main";
  }
  
  
  @RequestMapping("/deposit")
  public String deposit(HttpServletRequest request,Model model){
	  if(request.getParameter("cancel")!=null) return "main";
	  if(request.getParameter("sure")!=null) {
		  this.ccbService.deposit(Double.parseDouble(request.getParameter("money")));
		  model.addAttribute("message", "存款成功！！！");
		  return "success";
	  }
	  return "main";
  }
  
  
  @RequestMapping("/changePwd")
  public String changePwd(HttpServletRequest request,Model model){
	  if(request.getParameter("cancel")!=null) return "main";
	  if(request.getParameter("sure")!=null) {
		  
		  String pwd = request.getParameter("pwd");
		  String newPwd1 = request.getParameter("newPwd1");
		  String newPwd2 = request.getParameter("newPwd2");
		  if (newPwd1.equals(newPwd2)) {
			  if (this.ccbService.changePwd(pwd,newPwd1)) {
				  model.addAttribute("message", "修改密码成功！！！");
				  return "success";
			} else {
				model.addAttribute("errorMeg", "原密码错误，请重新输入");
				model.addAttribute("redirect", "./changePwd");
				return "error";
			}
		} else {
			model.addAttribute("errorMeg", "新密码输入不一致，请重新输入");
			model.addAttribute("redirect", "./changePwd");
			return "error";
		}
		  
		  
	  }
	  return "main";
  }
  
  
  @RequestMapping("/exit")
  public String exit(HttpServletRequest request,Model model) throws ServletException{
	  if (this.ccbService.exit()) {
		  model.addAttribute("message", "安全退出！！！");
		  return "exitsuccess";
	}
	  model.addAttribute("errorMeg", "退出失败！！！");
	  return "error";
  }
}