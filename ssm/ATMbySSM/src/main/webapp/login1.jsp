<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>用户登录</title>
<script type="text/javascript" >
//捕获键盘回车事件
document.onkeydown=keyListener;    
function keyListener(e){   
    e = e ? e : event;   
    if(e.keyCode == 13){
        Login();    
    }
}
function Login(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
 	if(userName == null || "" == userName){
 	    alert("用户名不能为空！");
 		return;
 	}
	if(password == null || "" == password){
		alert("密码不能为空");
 		return;
 	}
 	document.forms[0].submit();
 	//return true;
 	}
</script>
<style type="text/css">
<!--
.STYLE4 {font-size: 24px; }
body,td,th {
	font-size: 24px;
}
.STYLE5 {font-size: 18px}
-->
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body>
    <form action="./ccb/login" method="post">
<table border="0" align="center" cellpadding="0" cellspacing="0" style=" width:100%; height:85%; background-repeat:no-repeat; position:50px,50px,0px,0px;">
    <tr>      
	<td align="center" valign="middle" width="100%">
        <table width="300" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td align="left"></td>
          </tr>
          <tr>
            <td height="130" align="center" >			
			<table width="260" border="0" cellspacing="0"
			 cellpadding="0">
                <tr>
                  <td height="29" colspan="2"><div align="center"><span class="STYLE5">账号：</span>
                      <input name="cardnum" type="text" id="userName" style="width: 125px;"/>
                  </div></td>
                </tr>
               <tr>
                  <td height="50" colspan="2"> <div align="center"><span class="STYLE5">密码：</span>
                      <input name="pwd" type="password" id="password" style="width: 125px;"/> 
                  </div></td>
                </tr>
              <tr>
                <td>
                  
                  <div align="center" class="STYLE4">
                    <input name="button" type="button" class="STYLE5"  onClick="window.close()" value="退出" />
                  </div></td>
                <td><div align="center" class="STYLE4">
                    <input name="button2" type="button" class="STYLE5"  onClick="Login();" value="登录" />
                </div></td>
              </tr>
            </table>
	    </td>
          </tr>
        </table>
     </td>
    </tr>
  </table>
</form>
</body>
</html>
