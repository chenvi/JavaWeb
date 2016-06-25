<%@page import="com.chenv.pojo.FoodType"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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
<table width="764" border="0">
  <tr>
    <th width="377" align="left" scope="col">菜系列表</th>
    <th width="377" align="right" scope="col">
    	<a style="text-decoration: none" href="${pageContext.request.contextPath}/foodtype/to?page=index">系统菜单</a>
    </th>
  </tr>
</table>

<form name="form1" method="post" action="${pageContext.request.contextPath}/foodtype/search">
  <p>
  <input type="text" name="foodtypename" id="textfield">
  <input type="submit" name="search"  value="搜索">
</p>
</form>

  <table width="752" border="1" cellpadding="5" cellspacing="0">
    <tr>
     <!--  <td width="215" align="center">菜系编号</td> -->
      <td width="231" align="center">菜系名称</td>
      <td width="215" align="center" >操作</td>
    </tr>
<c:forEach items="${foodtypes}" var="foodtype">
	<tr>
	 <!--   <td width="215" height="20" align="center">${foodtype.id}</td> -->
	  <td width="231" align="center">${foodtype.typeName}</td>
	  
	  <td width="100" height="20" align="center">
	  <form method="post" action="${pageContext.request.contextPath}/foodtype/to">
	  	  <input type="hidden" name="page" value="foodtypeUpdate">
		  <input type="hidden" name="id" value="${foodtype.id}">
	      <input type="submit" name="update" value="更新">
	  </form>
	  
      <form method="post" action="${pageContext.request.contextPath}/foodtype/delete">
	      <input type="hidden" name="id" value="${foodtype.id}">
		  <input type="submit" name="delete"  value="删除">
	  </form>
	  </td>
	  
	</tr>
</c:forEach>
</table>
<a style="text-decoration: none" href="${pageContext.request.contextPath}/foodtype/to?page=foodtypeAdd">
	<input type="button" value="添加">
</a>
</body>
</html>
