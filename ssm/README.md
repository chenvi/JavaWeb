# 更新说明
## ATMbySSm 
1. 出现问题：密码输入错误，重新登录，密码正确，出现空指针异常
解决办法：登录验证在Mapper中完成，不在Sercvice中完成，遗留问题，如果出现重名用户返回，多个结果证明处理

2. 禁止页面返回：
利用js语句
<!-- 禁止页面返回 --> 
<script language="JavaScript"> 
  javascript:window.history.forward(1);  
</script> 

3. 传值到session中：
Controller中传值
session.setAttribute("arg0, arg1);
jsp中调用：
${sessionScope.属性}



