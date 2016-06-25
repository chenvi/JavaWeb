<%@page import="com.chenv.pojo.FoodType"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品管理</title>
<style type="text/css">
body,td,th {
	font-size: 18px;
}
</style>
</head>

<body>
<table width="764" border="0">
  <tr>
    <th width="377" align="left" scope="col">订单详情</th>
  </tr>
</table>


  <table width="752" border="1" cellpadding="5" cellspacing="0">
    <tr>
      <td width="215" align="center">菜名 </td>
      <td width="215" align="center">数量</td>
      <td width="215" align="center">单价</td>      
    </tr>
<c:forEach items="${map}" var="map">
	<tr>
	  <td width="215" height="20" align="center">${map.value.foodName}</td>
	  <td width="215" align="center">${map.key.foodCount}</td>
	  <td width="215" align="center">${map.value.price}</td>	  
	</tr>
</c:forEach>
</table>
<a href="javascript:history.go(-1)">
	<input type="button" name="cancel" value="返回">
</a>
</body>
</html>
