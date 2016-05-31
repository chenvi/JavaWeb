package com.chenv.javaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class HelloServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destory...");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo...");
		return null;
	}

	private ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init...");
		this.servletConfig = servletConfig;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		//请求方式GET POST
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.getMethod();
		
		//获取请求参数:user password
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		//获取当前web应用的初始化参数,需要使用servletcontext
		ServletContext servletContext = servletConfig.getServletContext();
		String initUser = servletContext.getInitParameter("user");
		String initPassword = servletContext.getInitParameter("password");
		
		PrintWriter out = response.getWriter();
		//比对
		if (initUser.equals(user) && initPassword.equals(password)) {
			out.print("hello");
		}else {
			out.print("sorry");
		}
		//打印响应
	}
	
	public HelloServlet() {
		System.out.println("HelloServlet`s constructor...");
	}
}
