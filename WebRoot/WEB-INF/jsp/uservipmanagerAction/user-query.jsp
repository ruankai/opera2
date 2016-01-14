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
    
    <title>user-query.jsp</title>
    
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
			  		<h3>查询普通用户信息</h3>
			  		<hr>
			  		<br>
			  		<form action="${pageContext.request.contextPath }/user-query.action" method="post">
			  			普通用户真实姓名：
			  			<input type="text" name="trueName"/>
			  			<input type="submit" value="提交"/>
			  		</form>
			  		<br>
			  		<hr>
			  		<br>
			  		<s:if test="#request.userByTrueName == null || #request.userByTrueName.size() == 0">
			  			没有该用户
			  		</s:if>
			  		<s:else>
			  			<table border="0" cellpadding="5" cellspacing="1">
			  				<tr>
			  					<th>账号</th>
								<th>密码</th>
								<th>用户名</th>
								<th>真实姓名</th>
								<th>性别</th>
								<th>出生日期</th>
								<th>地址</th>
								<th>手机</th>
								<th>邮箱</th>
								<th>微信</th>
								<th>QQ</th>
			  				</tr>
			  				<s:iterator value="#request.userByTrueName">
			  					<tr>
			  						<td>${id }</td>
									<td>${password }</td>
									<td>${name }</td>
									<td>${trueName }</td>
									<td>${gender }</td>
									<td><s:date name="birthday" format="yyyy-MM-dd"/></td>
									<td>${place }</td>
									<td>${tel }</td>
									<td>${email }</td>
									<td>${wechat }</td>
									<td>${qq }</td>
			  					</tr>
			  				</s:iterator>
			  			</table>
			  		</s:else>
			  	</center>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>  
  </body>
</html>
