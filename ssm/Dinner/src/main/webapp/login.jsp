<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<h1 align="center">后台系统登录</h1>
<h3 align="center"><font color="red">${msg }</font></h3>
 <form name="form1" onsubmit="return validate(this);" 
 action="${pageContext.request.contextPath}/role/login" method="post">
 <table align="center" border="0">
 	<tr>
 		<td>卡号：</td>
 		<td><input  style ="width:180px;height:20px;" name="userName" type="text"/></td>
 	</tr>
 	<tr>
 		<td>密码：</td>
 		<td><input  style ="width:180px;height:20px;" name="password" type="password"/></td>
 	</tr>
 </table>
	<div align="center">
	<input type="reset" value="重置">
	<input type="submit" value="提交">	
    </div>
  </form>
  
  <script type="text/javascript">
		function validate(form1)
		{
			if(form1.userName.value=="")
			{
				alert("用户名不能为空");
				return false;
			}
			else if(form1.password.value=="")
			{
				alert("密码不能为空");
				return false;
			}
			else if(form1.mprice.value=="")
			{
				alert("会员价不能为空");
				return false;
			}
			return true;
		} 
		
		function isNumber(str)          // 判断是否为非负整数
		{
			var rx = /^[0-9]+$/;
			return rx.test(str);
		}					
 </script>
</body>
</html>