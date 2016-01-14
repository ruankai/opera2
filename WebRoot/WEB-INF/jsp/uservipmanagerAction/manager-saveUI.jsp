<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>manager-update.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="/opera1/css/common.css" type="text/css"></link>
  	<link rel="stylesheet" href="/opera1/css/main.css" type="text/css"></link>
  
  <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".issue").click(function(){
				alert("发布成功！");
			});
			
			$(".edit").click(function(){
				alert("修改成功！");
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
		  		<s:form action="manager-%{id == null ? 'add' : 'edit'}">
		  			<s:hidden name="id"></s:hidden>
		  			<s:hidden name="pageNow"></s:hidden>
		  			<s:if test="id == null">
		  				<h3>添加管理员用户</h3>
		  				<hr>
		  				<br>
		  				<center>
		  					<table border="0" cellpadding="5" cellspacing="3">
		  						<tr>
		  							<td>真实姓名：</td>
		  							<td><s:textfield label="真实姓名：" name="trueName"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>用户名：</td>
		  							<td><s:textfield label="用户名：" name="name"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>密码：</td>
		  							<td><s:textfield label="密码：" name="password"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>性别：</td>
		  							<td><s:textfield label="性别：" name="gender"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>出生日期：</td>
		  							<td><s:textfield label="出生日期：" name="birthday"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>地址：</td>
		  							<td><s:textfield label="地址：" name="place"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>手机号码：</td>
		  							<td><s:textfield label="手机号码：" name="tel"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>邮箱：</td>
		  							<td><s:textfield label="邮箱：" name="email"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>微信：</td>
		  							<td><s:textfield label="微信：" name="wechat"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>等级：</td>
		  							<td><s:textfield label="等级：" name="level"></s:textfield></td>
		  						</tr>
		  						<tr>
		    						<td></td>
		    						<td><s:submit value="确定" cssClass="issue"></s:submit></td>
		    					</tr>
		  					</table>
		  				</center>
		  			</s:if>
		  			<s:else>
		  				<h3>添加管理员用户</h3>
		  				<hr>
		  				<br>
		  				<center>
		  					<table border="0" cellpadding="5" cellspacing="3">
		  						<tr>
		  							<td>真实姓名：</td>
		  							<td><s:textfield label="真实姓名：" name="trueName"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>用户名：</td>
		  							<td><s:textfield label="用户名：" name="name"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>密码：</td>
		  							<td><s:textfield label="密码：" name="password"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>性别：</td>
		  							<td><s:textfield label="性别：" name="gender"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>出生日期：</td>
		  							<td><s:textfield label="出生日期：" name="birthday"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>地址：</td>
		  							<td><s:textfield label="地址：" name="place"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>手机号码：</td>
		  							<td><s:textfield label="手机号码：" name="tel"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>邮箱：</td>
		  							<td><s:textfield label="邮箱：" name="email"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>微信：</td>
		  							<td><s:textfield label="微信：" name="wechat"></s:textfield></td>
		  						</tr>
		  						<tr>
		  							<td>等级：</td>
		  							<td><s:textfield label="等级：" name="level"></s:textfield></td>
		  						</tr>
		  						<tr>
		    						<td></td>
		    						<td><s:submit value="确定" cssClass="edit"></s:submit></td>
		    					</tr>
		  					</table>
		  				</center>
		  			</s:else>
		  		</s:form>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>  
  </body>
</html>
