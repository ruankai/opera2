<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
  
  </head>
  
  <body>
  	<div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include> 	
		<div id="main">
    		<br>
			<div id="main-left"></div>
			<div id="main-middle">
				<div id="bigtitle">用户登录</div>
				<br/>
				<hr></hr>
				<div id="loginbox">
					<form style="margin: 0px; padding: 0px;" action="${pageContext.request.contextPath}/manager-login.action" method="post">
						<s:actionerror/>
						<div id="username">
							<div class="logintitle">用户名:</div>
							<input name="name" id="usernametext" type="text" />
						</div>
						<div id="password">
							<div class="logintitle">用户密码:</div>
							<input name="password" id="passwordtext" type="password" />
						</div>
						<div id="login">
							<input id="loginbtn" type="submit" value="登录" name="submit"/>
							<input type="reset" value="重置"/>
						</div>
					</form>
				</div>
			</div>
			<div id="main-right"></div>
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
  	</div>
  </body>
</html>
