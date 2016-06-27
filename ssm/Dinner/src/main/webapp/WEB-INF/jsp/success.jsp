<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success page</title>
</head>
<body>
<!-- 禁止页面返回 --> 
<script language="JavaScript"> 
  javascript:window.history.forward(1);  
</script> 
	<h3> <font color="red"><c:if test="${param.msg == 1}">退出成功！！！</c:if>	</font> </h3>
	<h3><font color="red">${msg }</font></h3>
	<br>
	<a href="${pageContext.request.contextPath}">
			<input type="button" name="cancel" value="返回">
	</a>
</body>
</html>