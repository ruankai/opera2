<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>vip-querypage.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css"></link>
  
  </head>
  
  <body>
	<div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include> 
		<div id="main">
			<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			<div id="main-right">
				<center>
			  		<h3>查询高级用户信息</h3>
			  		<hr>
			  		<br>
			  		<form action="${pageContext.request.contextPath }/vip-query.action" method="post">
			  			普通用户真实姓名：
			  			<input type="text" name="trueName"/>
			  			<input type="submit" value="提交"/>
			  		</form>
			  	</center>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>  
  </body>
</html>
