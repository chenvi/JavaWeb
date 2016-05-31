package com.chenv.javaweb.session.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/process2")
public class Process2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String address= request.getParameter("address");
		String stlye= request.getParameter("stlye");
		String card= request.getParameter("card");
		
		Customer customer = new Customer(name, address, stlye, card);
		
		request.getSession().setAttribute("customer", customer);
		
		response.sendRedirect(request.getContextPath()+"/confirm.jsp");
	}

}
