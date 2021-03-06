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
<form name="form1" method="post" onsubmit="return validate(this);"
	action="${pageContext.request.contextPath}/food/update">
	<table width="310" border="0">
	  <tr>
	    <td width="120">菜名</td>
	   	<td width="174">
	   		<input type="text" name="foodName" value="${food.foodName }">
	   	</td>
	  </tr>
	  <tr>
	    <td width="120">菜系</td>
	    <td width="174">
			<select name="foodTypeId" id="select">
					<option value="">-请选择菜系-</option>
					<c:forEach items="${foodType }" var="foodType">
					<!-- 注意回显的处理 -->
					<option <c:if test="${food.foodTypeId == foodType.id }">selected</c:if> value="${foodType.id }">	
						${ foodType.typeName}
					</option>
					</c:forEach>
			</select>
		</td>	
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
	    </td>
	    <td align="center" valign="middle">
		    <a href="javascript:history.go(-1)">
				<input type="button" name="cancel" value="取消">
			</a>
		</td>
	  </tr>
	</table>
</form>
<script type="text/javascript">
		function validate(form1)
		{
			if(form1.foodTypeId.value=="")
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
