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
<p>添加菜系

</p>
<form name="form1" method="post" 
	onsubmit="return validate(this);"
	action="${pageContext.request.contextPath}/foodtype/add">
<table width="310" border="0">
  <tr>
    <td width="120">菜系名称</td>    
    <td width="174">
    	<input type="text" name="foodtypename" value="">
    </td>
  </tr>
  <tr>
    <td align="center" valign="middle">
      <input type="submit" name="add"  value="添加">
    </td>
    <td align="center" valign="middle">
      <a href="javascript:history.go(-1)">
      	<input type="button" name="cancel"  value="取消">
      </a>
    </td>
  </tr>
</table>
</form>

<script type="text/javascript">
		function validate(form1)
		{
			if(form1.foodtypename.value=="")
			{
				alert("菜系不能为空");
				return false;
			}
			else if(form1.price.value=="")
			{
				alert("价格不能为空");
				return false;
			}
			else if(form1.mprice.value=="")
			{
				alert("会员价不能为空");
				return false;
			}
			return true;
		} 
		
		function isNumber(str)          // 判断是否为非负整数
		{
			var rx = /^[0-9]+$/;
			return rx.test(str);
		}					
 </script>
</body>
</html>
