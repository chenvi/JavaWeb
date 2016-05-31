<%@page import="com.chenv.javaweb.session.servlet.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Customer customer = (Customer)request.getSession().getAttribute("customer");
	String[] books = (String[])session.getAttribute("books");
%>
<h4>Step3:确认订单信息</h4>
<form action="confirm" method="post">
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>姓名</td>
			<td><%= customer.getName() %></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><%= customer.getAddress() %></td>
		</tr>
		<tr>
			<td>信用卡类型</td>
			<td><%= customer.getStlye() %></td>
		</tr>
		<tr>
			<td>信用卡卡号</td>
			<td><%= customer.getCard() %></td>
		</tr>
	
		
	
		<tr>
			<td>books:</td>
			<td>
			
			<%
			for(String book: books){
				out.print(book);
				out.print("<br>");
			}
			%>
			</td>
		</tr>
		
		<tr>
			<td><input type="submit" name="submit" value="submit"></td>
		</tr>
	</table>


</form>
	


</body>
</html>