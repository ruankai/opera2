<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>manager-updatepwd.jsp</title>
    
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

	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(":submit[name=submit]").click(function(){
				var $newPwdOne = $(":password[name=newPwdOne]").val();
				var $newPwdTwo = $(":password[name=newPwdTwo]").val();
				if($newPwdOne == "" || $newPwdTwo == "") {
					alert("输入的新密码不能为空!");
				}
				if($newPwdOne != $newPwdTwo && $newPwdOne != "" && $newPwdTwo != "") {
					alert("两次输入的密码不同!");
				}
				if($newPwdOne == $newPwdTwo && $newPwdOne != "" && $newPwdTwo != "") {
					alert("修改密码成功!");
				}
			});
		})
	</script>

  </head>
  
  <body>
  	<div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>  
		<div id="main">
			<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			<div id="main-right">
				<center>
			  		<h3>修改密码</h3>
			  		<br>
			  		<hr>
			  		<br>
			  		<br>
			  		<br>
					<form action="${pageContext.request.contextPath }/manager-savepwd.action" method="post">
						<s:hidden name="name"></s:hidden>
			  			<s:hidden name="password"></s:hidden>
						<s:actionerror/>
						<table>
							<tr>
								<td>当前用户名：</td>
								<td><s:textfield name="name" disabled="true"></s:textfield></td>
							</tr>
							<tr>
								<td>请输入新密码：</td>
								<td><input type="password" name="newPwdOne"/></td>
							</tr>
							<tr>
								<td>请确认新密码：</td>
								<td><input type="password" name="newPwdTwo"/></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="确定" name="submit"/></td>
							</tr>
						</table>
					</form>
			  	</center>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
