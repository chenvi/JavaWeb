package com.chenv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.dao.UserMapper;
import com.chenv.pojo.User;
import com.chenv.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper usermapper;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("login");
		User user_login = usermapper.login(name, password);
		System.out.println(user_login);
		if (user_login == null) {
			System.out.println("Error login!");
			return "fail";
		} else {
			model.addAttribute("user", user_login);
			return "success";
		}
	}
}