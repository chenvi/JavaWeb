<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Step2:请输入姓名、寄送地址和信用卡信息</h4>
	<form  action="process2" method="post">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td colspan="2">基本信息</td>
			</tr>
			
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>寄送地址</td>
				<td><input type="text" name="address"></td>
			</tr>
			
			<tr>
				<td colspan="2">信用卡信息</td>	
			</tr>
			
			<tr>
				<td>种类</td>
				<td>
					<input type="radio" name="stlye" value="a" >a<br><br>
					<input type="radio" name="stlye" value="b" >b
				</td>
			</tr>
			
			<tr>
				<td>卡号</td>
				<td><input type="text" name="card"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>