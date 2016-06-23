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
<p>更新菜品

</p>
<table width="310" border="0">
  <tr>
    <td width="120">菜名</td>
    <form name="form1" method="post" action="${pageContext.request.contextPath}/food/food?method=update">
    <td width="174"><input type="text" name="foodName" value="${food.foodName }"></td>
  </tr>
  <tr>
    <td width="120">菜系</td>
    <td width="174"><input type="text" name="foodTypeId" value="${food.foodTypeId }"></td>
  </tr>
   <tr>
  	 <td width="120">价格</td>
  	  <td width="174"><input type="text" name="price" value="${food.price }"></td>
  </tr>
   <tr>
  	 <td width="120">会员价</td>
  	  <td width="174"><input type="text" name="mprice" value="${food.mprice }"></td>
  </tr>
  <tr>
  	 <td width="120">描述</td>
  	  <td width="174"><input type="text" name="mark" value="${food.remark }"></td>
  </tr>
  <tr>
  	 <td width="120">图片</td>
  	  <td width="174"><input type="text" name="img" value="${food.img }"></td>
  </tr>
  <tr>
    <td align="center" valign="middle">
      <input type="hidden" name="id" value="${food.id}">
      <input type="submit" name="update"  value="更新">
    </form></td>
    <td align="center" valign="middle"><form method="post" action="${pageContext.request.contextPath}/food/food?method=index">
      <input type="submit" name="cancel"  value="取消">
    </form></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>
