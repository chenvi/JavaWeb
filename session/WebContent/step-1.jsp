<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Step1:选择要购买的图书</h4>
	<form  action="process1" method="post">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>书名</td>
				<td>购买</td>
			</tr>
			
			<tr>
				<td>Java</td>
				<td><input type="checkbox" name="book" value="Java"></td>
			</tr>
			<tr>
				<td>C</td>
				<td><input type="checkbox" name="book" value="C"></td>
			</tr>
			<tr>
				<td>SQL</td>
				<td><input type="checkbox" name="book" value="SQL"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>