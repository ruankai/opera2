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
    
    <title>vip-update.jsp</title>
    
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
			  		<h3>修改高级用户信息</h3>
			  		<hr>
			  		<br>
			  		<s:form action="vip-save.action" method="post">
			  			<s:if test="id != null">
			  				<s:textfield name="name" label="用户名" disabled="true"></s:textfield>
			  				<s:textfield name="password" label="密码" disabled="true"></s:textfield>
			  				<s:hidden name="id"></s:hidden>
			  			</s:if>
			  			<s:else>
			  				<s:textfield name="name" label="用户名"></s:textfield>
			  				<s:textfield name="password" label="密码"></s:textfield>
			  			</s:else>
			  			<s:textfield name="trueName" label="真实姓名"></s:textfield>
			  			<s:textfield name="gender" label="性别"></s:textfield>
			  			<s:textfield name="birthday" label="出生日期"></s:textfield>
			  			<s:textfield name="place" label="地址"></s:textfield>
			  			<s:textfield name="tel" label="手机"></s:textfield>
			  			<s:textfield name="email" label="邮箱"></s:textfield>
			  			<s:textfield name="wechat" label="微信"></s:textfield>
			  			<s:textfield name="qq" label="QQ"></s:textfield>
			  			<s:textfield name="organizationId" label="(曾)任职机构"></s:textfield>
			  			<s:textfield name="companyTel" label="单位电话"></s:textfield>
			  			<s:textfield name="companyPlace" label="单位地址"></s:textfield>
			  			<s:textfield name="duty" label="职务"></s:textfield>
			  			<s:textfield name="rank" label="职称"></s:textfield>
			  			<s:textfield name="school" label="毕业院校"></s:textfield>
			  			<s:textfield name="tenureClock" label="任职时间"></s:textfield>
			  			<s:textfield name="education" label="学历"></s:textfield>
			  			<s:textfield name="degree" label="学位"></s:textfield>
			  			<s:textfield name="pose" label="擅长角色"></s:textfield>
			  			<s:textfield name="remark" label="备注"></s:textfield>
			  			<s:textfield name="type" label="用户类型"></s:textfield>
			  			<s:submit value="确定"></s:submit>
			  		</s:form>
			  	</center>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>  
  </body>
</html>
