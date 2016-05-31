<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.chenv.javaweb.domain.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.chenv.javaweb.servlet.CustomerServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var content = $(this).parent().parent().find("td:eq(1)").text();
			var flag = confirm("确定要删除"+content+"的信息吗？")
			return flag;
		})
	})
</script>
</head>
<body>
<% 
	Object msg = request.getAttribute("message");
if(msg != null){
%>
<br>
<font color="red"><%=msg %></font>
<br>	
<br>
 <%	 
}
%>
<%
String id = null;
String name = null;
String oldName = null;
String address = null;
String phone = null;

Customer customer =(Customer)request.getAttribute("customer");

if(customer != null){
	id = customer.getId()+"";
	name = customer.getName();
	oldName = customer.getName();
	address = customer.getAddress();
	phone = customer.getPhone();
}else{
	id = request.getParameter("id");
	name = request.getParameter("oldName");
	oldName = request.getParameter("oldName");
	address = request.getParameter("address");
	phone = request.getParameter("phone");
	
}
%>	

	<form action="update.do" method="post">
	<input type="hidden" name="id" value=<%= id %>>
	<input type="hidden" name="oldName" value=<%= oldName %>>
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" 
				value="<%= name%>"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
				value="<%= address%>"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"
				value="<%= phone%>"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>		
</body>
</html>