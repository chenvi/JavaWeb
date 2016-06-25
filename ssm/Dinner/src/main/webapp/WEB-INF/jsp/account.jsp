<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body,td,th {
	font-size: 18px;
}
</style>
</head>
<body>

<table border="0">
	<tr>
		<th>菜单</th>
	</tr>
</table>

<h5>餐桌选择：</h5>
<form method="post" action="${pageContext.request.contextPath}/order/bill">
	<c:choose>
		<c:when test="${not empty dinnerTables }">
			<table border="1" cellpadding="5" cellspacing="0">
				<tr>
					<!-- <td>餐桌编号</td> -->
					<td>餐桌名</td>
					<td>状态</td>
					
					<td>选择</td>
				</tr>
				<c:forEach items="${dinnerTables}" var="dinnerTables">
					<tr>
						<%-- <td>${dinnerTables.id }</td> --%>
						<td>${dinnerTables.tableName }</td>
						<td> 
						<c:if test="${dinnerTables.tableStatus == '1' }" >
							<font color="red">预定</font>
						</c:if>
						<c:if test="${dinnerTables.tableStatus == '0' }" >
							<font color="green">空闲</font>
						</c:if>
						</td>
						
						<td>
						<c:if test="${dinnerTables.tableStatus == '0' }" >
							<input type="checkbox" value="${dinnerTables.id  }" name="tableId">
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>暂时没有多余的餐桌供你选择！！！</h3>
			<a href="${pageContext.request.contextPath}/order/dinner">刷新</a>
		</c:otherwise>
	</c:choose>

<h5>菜单选择：</h5>
	<c:choose>
		<c:when test="${not empty foods }">
			<table border="1" cellpadding="5" cellspacing="0">
				<tr>
				<!-- 	<td>菜编号</td> -->
					<td>菜名</td>
					<td>价格</td>
					<td>会员价</td>
					<td>数量</td>
					<td>选择</td>
				</tr>
				<c:forEach items="${foods}" var="foods">
					<tr>
						<%-- <td>${foods.id }</td> --%>
						<td>${foods.foodName }</td>
						<td>${foods.price }</td>
						<td>${foods.mprice }</td>
						<td><input type="text" name="${foods.id }:num"></td>
						<td><input type="checkbox" value="${foods.id }" name="foodId${foods.id }"></td>
					</tr>
				</c:forEach>
			</table>
		<input type="submit" value="提交">	
		</c:when>
		<%-- <c:otherwise>
			<a href="${pageContext.request.contextPath}/order/dinner">刷新</a>
		</c:otherwise> --%>
	</c:choose>
	
</form>	
</body>
</html>