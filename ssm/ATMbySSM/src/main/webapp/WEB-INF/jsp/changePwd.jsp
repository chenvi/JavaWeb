<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>changePwd</title>
</head>
<body>
	<form name="form1" method="post" action="./changePwd">
	  <table width="405" border="1" align="center">
        <tr>
          <td width="395" height="36"><label>旧密码：
              <input type="text" name="pwd">
          </label></td>
        </tr>
        <tr>
          <td height="44"><label>新密码：
              <input type="text" name="newPwd1">
          </label></td>
        </tr>
        <tr>
          <td height="38"><label>新密码确认：
              <input type="text" name="newPwd2">
          </label></td>
        </tr>
        <tr>
          <td height="40"><label>
            <div align="center">
              <input type="submit" name="cancel" value="取消">
              <input type="submit" name="sure" value="确定">
              </div>
          </label></td>
        </tr>
      </table>
	</form>
	<h1>&nbsp;</h1>
</body>
</html>