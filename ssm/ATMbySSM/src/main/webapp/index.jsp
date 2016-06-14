<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>主页</title>
     <jsp:forward page="/WEB-INF/jsp/login.jsp"></jsp:forward>
<body>
  <form action="./ccb/login" method="post">
  <center>${map.error }</center>
	<div align="center">
	
	卡号：<input name="cardnum" type="text" /><br/>
	密码：<input name="pwd" type="password" /><br/>
	<input type="reset" value="重置">
	<input type="submit" value="提交">
	
    </div>
  </form>
</body>
</html>
