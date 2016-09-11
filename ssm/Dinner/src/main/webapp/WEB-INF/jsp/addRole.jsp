<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>changePwd</title>
</head>
<body>
	<form name="form1" method="post" onsubmit="return validate(this);"
		action="${pageContext.request.contextPath}/role/addRole">
	  <table border="1" align="center" cellpadding="5" cellspacing="0">
        <tr>
          <td>用户名：</td>
          <td >
              <input style ="width:180px;height:20px;" type="text" name="name">
          </td>
        </tr>
        <tr>
          <td>新密码：</td>
          <td >
              <input style ="width:180px;height:20px;" type="text" name="newPwd1">
          </td>
        </tr>
        <tr>
          <td>新密码确认：</td>
          <td>
              <input style ="width:180px;height:20px;" type="text" name="newPwd2">
          </td>
        </tr>       
      </table>
      <div align="center">
      	<a style="text-decoration: none" href="javascript:history.go(-1)">
			<input type="button" name="cancel" value="取消">
	  	</a>
          	<input type="submit" name="sure" value="确定">
      </div>            

	</form>
<script type="text/javascript">
		function validate(form1)
		{
			if(form1.name.value=="")
			{
				alert("用户名不能为空");
				return false;
			}
			else if(form1.newPwd1.value=="")
			{
				alert("新密码不能为空");
				return false;
			}
			else if(form1.newPwd2.value=="")
			{
				alert("新密码不能为空");
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