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
    <th width="377" align="left" scope="col">订单列表</th>
    <th width="377" align="right" scope="col">
    	<a style="text-decoration: none" href="${pageContext.request.contextPath}/order/to?page=index">系统菜单</a>
    </th>
  </tr>
</table>


  <table width="752" border="1" cellpadding="5" cellspacing="0">
    <tr>
      <td width="215" align="center">订单编号 </td>
      <td width="215" align="center">餐桌名</td>
      <td width="215" align="center">下单日期</td>
      <td width="215" align="center">总金额</td>
      <td width="215" align="center">状态</td>
      <td width="215" align="center">操作</td>
    </tr>
<c:forEach items="${orders}" var="orders">
	<tr>
	  <td width="215" height="20" align="center">${orders.id}</td>
	  <td width="215" align="center">${orders.tableId}</td>
	  <td width="215" align="center">${orders.orderDate}</td>
	  <td width="215" align="center">${orders.orderDate}</td>
	  <td width="215" align="center">${orders.tableStatus}</td>
	  <td width="215" height="20" align="center">
	  <form method="post" action="${pageContext.request.contextPath}/order/detail">
	  <input type="hidden" name="orderId" value="${orders.id}">
      <input type="submit" name="detail" value="详情">
	  </form>	  
      <form method="post" action="${pageContext.request.contextPath}/order/check">
      <input type="hidden" name="tableId" value="${orders.tableId}">
      <input type="hidden" name="id" value="${orders.id}">
	  <input type="submit" name="check"  value="结账">
	  </form>
	  </td>
	</tr>
</c:forEach>
</table>

</body>
</html>
