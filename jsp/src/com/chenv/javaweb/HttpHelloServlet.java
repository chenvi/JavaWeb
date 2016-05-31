package com.chenv.javaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class HttpHelloServlet extends HttpServlet{

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
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//请求方式GET POST
		String method = request.getMethod();
		
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
			out.print("hello"+method);
		}else {
			out.print("sorry"+method);
		}
		//打印响应
	}
	
	public HttpHelloServlet() {
		System.out.println("HelloServlet`s constructor...");
	}
}
