<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>主页</title>
    <jsp:forward page="/WEB-INF/jsp/login.jsp"></jsp:forward>
<body>
  <form action="./user/showUser" method="post">
	姓名：<input name="name" type="text" /><br/>
	密码：<input name="password" type="password" /><br/> 
	<input type="submit" value="提交"><br/>
  </form>
</body>
</html>
