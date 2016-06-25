package com.chenv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.Role;
import com.chenv.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, Model model){
		 //从request获取session
		  HttpSession session = request.getSession();
		  
		  //利用业务层进行登录验证，如果登录成功则返回用户信息
		  Role loginAccount =  this.roleService.login(request);
		  
		  //将用户信息放进session中
	    if (loginAccount != null) {
	    	session.setAttribute("loginAccount", loginAccount);
	    	 return "index";
		} else {
			model.addAttribute("msg","密码或用户名错误");
			return "error";
		}
	}
}
