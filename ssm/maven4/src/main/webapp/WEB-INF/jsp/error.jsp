<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
</head>
<body>
	<form name="form1" method="post" action=${redirect}>
	  <table width="269" border="1" align="center">
        <tr>
          <th width="239" height="36" align="center" bordercolor="#F0F0F0" scope="col"><label>
             ${errorMeg}
          </label></th>
        </tr>
        <tr>
          <td height="26"><label>
            <div align="center">
              <input type="submit" name="Submit" value="返回">
              </div>
          </label></td>
        </tr>
      </table>
</form>
</body>
</html>