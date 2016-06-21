<%@page import="com.chenv.pojo.FoodType"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*"  errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜系管理</title>
<style type="text/css">
body,td,th {
	font-size: 18px;
}
</style>
</head>

<body>
<p>添加餐桌
  <%
	FoodType foodType = (FoodType)request.getAttribute("foodtype");
%>
</p>
<table width="310" border="0">
  <tr>
    <td width="120">餐桌名称</td>
    <form name="form1" method="post" action="${pageContext.request.contextPath}/dinnertable/dinnertable?method=add">
    <td width="174"><input type="text" name="tablename" value=""></td>
  </tr>
  <tr>
    <td align="center" valign="middle">
      <input type="submit" name="add"  value="添加">
    </form></td>
    <td align="center" valign="middle"><form method="post" action="${pageContext.request.contextPath}/foodtype/foodtype?method=index">
      <input type="submit" name="cancel"  value="取消">
    </form></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>
