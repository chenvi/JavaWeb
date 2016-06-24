<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>系统管理</title>
<style type="text/css">
body,td,th {
	font-size: 24px;
}
</style>
</head>

<body>
<h1 align="center">酒店后台点菜管理系统</h1>
<table width="210" border="1" align="center" cellpadding="3" cellspacing="0">
  <tbody>
    <tr>
      <th scope="col"><a href="${pageContext.request.contextPath}/dinnertable/list">餐桌管理</a></th>
    </tr>
    <tr>
      <th scope="col"><a href="${pageContext.request.contextPath}/foodtype/list">菜系管理</a></th>
    </tr>
    <tr>
      <th scope="col"><a href="${pageContext.request.contextPath}/food/list">菜品管理</a></th>
    </tr>
    <tr> 
	<th scope="col" width="200"><a href="${pageContext.request.contextPath}/order/list">餐厅订单</a></th> 
	</tr>
  </tbody>
</table>
</body>
</html>
