package com.chenv.javaweb.session.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/process1")
public class Process1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] books = request.getParameterValues("book");
		
		request.getSession().setAttribute("books", books);
		
		response.sendRedirect("step-2.jsp");
	}

}
