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
<p>更新菜系

</p>
<form name="form1" method="post" action="${pageContext.request.contextPath}/foodtype/update">
	<table width="310" border="0">
	  <tr>
	    <td width="120">菜系名称</td>
	    <td width="174">
	    	<input type="hidden" name="id" value="${foodtype.id }">
	    	<input type="text" name="foodtypename" value="${foodtype.typeName }">
	    </td>
	  </tr>
	  <tr>
	    <td align="center" valign="middle">
	      <input type="submit" name="update"  value="更新">
	    </td>
	    <td align="center" valign="middle">
	    	<a href="javascript:history.go(-1)"><input type="button" value="取消"></a>
	    </td>
	  </tr>
	</table>
</form>
<p>&nbsp;</p>
</body>
</html>
