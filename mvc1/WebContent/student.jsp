<%@page import="com.chenv.javaweb.mvc.Students"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List<Students> stus = (List<Students>)request.getAttribute("student"); %>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>sex</th>
		</tr>
		
		<%
			for(Students student : stus){
		%>
		<tr>
			<th><%= student.getId() %></th>
			<th><%= student.getName() %></th>
			<th><%= student.getSex() %></th>
			<th><a href="deleteStudent?id=<%= student.getId()%>">Delete</a></th>
		</tr>
		<% 		
			}
				
		%>
		
	</table>
</body>
</html>