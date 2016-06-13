<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fetch</title>
</head>
<body>
<form   action="./fetch" method="post">
  <table width="356" border="1" align="center">
    <tr>
      <td width="346" height="29"><label>
          <div align="center">取款金额：
            <input type="text" name="money">
          </div>
        </label></td>
    </tr>
    <tr>
      <td height="34"><div align="center">
        <input type="submit" name="cancel" value="取消">
        <input type="submit" name="sure" value="确定">
      </div></td>
    </tr>
  </table>
</form>
</body>
</html>