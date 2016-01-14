<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>manager-listall.jsp</title>
    
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
			  		<h3>显示管理员的所有信息</h3>
			  		<br>
			  		<hr>
			  		<br>
			  		<br>
					<table border="0" cellpadding="5" cellspacing="3">
						<s:iterator value="#request.managerall">
							<tr>
								<th>账号</th>
								<td>${id }</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<th>密码</th>
								<td>${password }</td>
							</tr>
							<tr>
								<th>用户名</th>
								<td>${name }</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<th>真实姓名</th>
								<td>${trueName }</td>
							</tr>
							<tr>
								<th>性别</th>
								<td>${gender }</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<th>出身日期</th>
								<td>
									<s:date name="birthday" format="yyyy-MM-dd"/>
								</td>
							</tr>
							<tr>
								<th>地址</th>
								<td>${place }</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<th>手机</th>
								<td>${tel }</td>
							</tr>
							<tr>
								<th>邮箱</th>
								<td>${email }</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<th>微信</th>
								<td>${wechat }</td>
							</tr>
							<tr>
								<th>等级</th>
								<td>${level }</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><a href="${pageContext.request.contextPath }/manager-listpart.action?pageNow=<s:property value='#request.pageNow'/>">返回</a></td>
							</tr>
						</s:iterator>
					</table>
			  	</center>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
