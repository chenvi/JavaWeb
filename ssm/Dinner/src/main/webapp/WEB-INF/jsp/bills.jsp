<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bills page</title>
</head>
<body>
	<h3><font color="red">${msg }</font></h3>
	<br>
	
<table width="764" border="0">
  <tr>
    <th width="377" align="left" scope="col">账单详情</th>
  </tr>
  <tr>
  
  
  <tr>
  <td>
  	下单时间：<fmt:formatDate value="${orderDate }" type="both" dateStyle="full" />
  </td>
  <tr>
  
  <td>
  	结账时间：<fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="full" />
  </td>
  <tr>
</table>


  <table width="752" border="1" cellpadding="5" cellspacing="0">
    <tr>
      <td width="215" align="center">菜名 </td>
      <td width="215" align="center">单价</td>
      <td width="215" align="center">数量</td>
      <td width="215" align="center">总价</td>        
    </tr>
<c:forEach items="${bills}" var="bills">
	<tr>
	  <td width="215" height="20" align="center">${bills.foodName}</td>
	  <td width="215" align="center">${bills.foodValue}</td>
	  <td width="215" align="center">${bills.foodCount}</td>
	  <td width="215" align="center">${bills.foodSum}</td>	  
	</tr>
	
	<c:set var="sum" value="${sum + bills.foodSum}"></c:set>
</c:forEach>

<tr><td colspan="4" align="right">总计：<c:out value="${sum }"></c:out> </td></tr>
</table>
<a style="text-decoration: none" href="${pageContext.request.contextPath}/order/list">
	<input type="button" name="cancel" value="返回">
</a>

</body>
</html>