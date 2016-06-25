<%@page import="com.chenv.pojo.FoodType"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*"  errorPage="" %>
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
<h3>
添加餐桌
</h3>

<form name="form1" method="post" 
	onsubmit="return validate(this);"
	action="${pageContext.request.contextPath}/dinnertable/add">
<table width="310" border="0">
  <tr>
    <td colspan="2" align="center" width="200">        
    	餐桌名称
    	<input type="text" name="tablename" value="">
    </td>
  </tr>
  <tr height="10"></tr>
  <tr>
    <td align="center" valign="middle">
      <input type="submit" name="add"  value="添加">
    </td>
    <td align="center" valign="middle">
      <a style="text-decoration: none" href="javascript:history.go(-1)">
     	 <input type="button" name="cancel"  value="取消">
      </a>
    </td>
  </tr>
</table>
</form>
<script type="text/javascript">
		function validate(form1)
		{
			if(form1.tablename.value=="")
			{
				alert("桌名不能为空");
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
