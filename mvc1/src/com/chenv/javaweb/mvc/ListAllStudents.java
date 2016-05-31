package com.chenv.javaweb.mvc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listAllStudents")
public class ListAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("student", Arrays.asList("AA"+"BB"+"CC"));
//		request.getRequestDispatcher("/student.jsp").forward(request, response);
	
		StudentDao studentDao = new StudentDao();
		List<Students> students = studentDao.getAll();
		request.setAttribute("student", students);
		request.getRequestDispatcher("/student.jsp").forward(request, response);
	
	}

}
