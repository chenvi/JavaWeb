<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<h1><div align="center">ATM自动柜员机</div></h1>
<hr>
	<form action="./ccb/login" method="post">
	  <div align="center">
	  卡号：<input name="cardnum" type="text" style="width: 154px; "/><br>
	  <br>
	 密码：<input name="pwd" type="password" style="width: 154px; "/><br>
	<input type="submit" value="提交">
	<br/>
      </div>
	</form>
</body>
</html>