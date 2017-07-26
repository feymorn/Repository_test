<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功！！！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <p>来到success.jsp</p>
 
 
 java_request scop:<%=request.getAttribute("password") %><br>
  java_session scop:<%=session.getAttribute("abc")%><br>
  
  <%= this.getServletContext().getAttribute("app") %><br>
  
  EL \${sessionScope.abc}: ${sessionScope.abc}<br>
  EL \${pageScope.a}: ${pageScope.a}<br>
  EL \${requestScope.username}: ${requestScope.username}<br>
  EL \${pageContext.request.serverPort}: ${pageContext.request.serverPort}<br>
  EL \${header["host"]}:  ${header["host"]}<br />
  EL \${header["user-agent"]}:  ${header["user-agent"]}<br />
  EL \${pageContext.request.contextPath}:  ${pageContext.request.contextPath}<br>
  EL \${request.contextPath}:  ${request.contextPath}<br>
  EL \${applicationScope.app}:  ${applicationScope.app}<br>
  遍历<br>
  
  <c:forEach var="a" items="${session}" varStatus="status">
    <tr>
     <c:out value="${session.abc}" default="空  "/>
    </tr>
  
  </c:forEach>
  

     
  <body>
   
  </body>
</html>
