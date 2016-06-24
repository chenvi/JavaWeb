<%@page import="com.chenv.pojo.DinnerTable"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>餐桌管理</title>
<style type="text/css">
body,td,th {
	font-size: 18px;
}
</style>
</head>

<body>
<table width="764" border="0">
  <tr>
    <th width="377" align="left" scope="col">餐桌列表</th>
    <th width="377" align="right" scope="col"><a href="${pageContext.request.contextPath}/dinnertable/to?page=index">系统菜单</a></th>
  </tr>
</table>

<form name="form1" method="post" action="${pageContext.request.contextPath}/dinnertable/search">
  <p>
  <input type="text" name="tableName" id="textfield">
  <input type="submit" name="search"  value="搜索">
</p>
</form>

  <table width="750" border="1" cellpadding="5" cellspacing="0">
    <tr height="10">
      <td width="100" align="center">编号</td>
      <td width="100" align="center">桌名</td>
      <td width="100" align="center">状态</td>
      <td width="500" align="center">预定时间</td>
      <td width="100" align="center">操作</td>
    </tr>

<c:forEach items="${dinnertables}" var="dinnertable">

<tr height="10">
	<td width="100" align="center">${dinnertable.id}</td>
	<td width="100" align="center">${dinnertable.tableName}</td>
	<td width="100" align="center">
		<c:if test="${dinnertable.tableStatus == '1' }" >预定</c:if>
		<c:if test="${dinnertable.tableStatus == '0' }" >空闲</c:if>
	</td>
	<td width="500" align="center">${dinnertable.orderDate}</td>
	<td width="100" height="20" align="center">
	<c:if test="${dinnertable.tableStatus == '0' }" >
	  <form method="post" action="${pageContext.request.contextPath}/dinnertable/reserve">
	     <input type="hidden" name="id" value="${dinnertable.id}">
	     <input type="submit" name="reserve" value="预定">
	  </form>
	</c:if>
	<c:if test="${dinnertable.tableStatus == '1' }" >
	  <form method="post" action="${pageContext.request.contextPath}/dinnertable/clean">
	     <input type="hidden" name="id" value="${dinnertable.id}">
	     <input type="submit" name="return" value="退桌">
	  </form>
	</c:if>
	  <form method="post" action="${pageContext.request.contextPath}/dinnertable/delete">
	    <input type="hidden" name="id" value="${dinnertable.id}">
	  	<input type="submit" name="delete"  value="删除">
	  </form>
	 </td>
<tr>
</c:forEach>
</table>
<a href="./to?page=dinnertableAdd">添加</a>
</body>
</html>
