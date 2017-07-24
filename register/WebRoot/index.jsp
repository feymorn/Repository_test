<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1>请输入注册信息</h1>
    <form action="register" method="post">
       <table>
         <tr>
             <td>用户名</td>
             <td> <input type="text" name ="username" id="username"> 
             </td>
         </tr>
         <tr>
             <td>密码</td>
             <td><input type="password" name="password" id="password"> </td>
         </tr>
       
       </table>
        <input type="submit" value="注册" >
    </form>
    
    <a href="seacher.html">查询用户</a>
  </body>
</html>
