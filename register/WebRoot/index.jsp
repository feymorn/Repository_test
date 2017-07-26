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
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript">
	function pwdIdent(){
	   var pwd1=document.getElementById("password").value;
	   var pwd2=document.getElementById("repassword").value;
	  
	   if(pwd1==""){
	   alert("please input a valid password");
	   signupForm.password.focus();
	   return false;
	   }else if(pwd1!=pwd2){
	    alert("Your password and confirmed password do not match.")
	  signupForm.repassword.focus();
	    return false;
	    
	    
	   } else if(pwd1==pwd2){
		   return true;
	     
	   }
	}
	
	</script>
  </head>
  
  <body>
  <h1>请输入注册信息</h1>
    <form name="signupForm" action="register" method="post" >
       <table>
         <tr>
             <td>用户名</td>
             <td> <input type="text" name ="username" id="username" required="true" missingMessage="The username can not be empty"> 
             </td>
         </tr>
         <tr>
             <td>密码</td>
             <td><input type="password" name="password" id="password"> </td>
         </tr>
        <tr>
             <td>再次输入密码</td>
             <td><input type="password" name="repassword" id="repassword"> </td>
         </tr>
       </table>
      <button type="submit" onclick="return pwdIdent() ">登陆</button>
    </form>
    
    <a href="login.jsp">已有账户，直接登陆</a>
    <a href="seacher.html">查询</a>
  </body>
</html>
