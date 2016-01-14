<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改图片信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
  	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>

  </head>
  
  <body>
    <div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
		<div id="main">
			<div id="main-left">
				<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			</div>
			<div id="main-right">
				<center>
					<br><br><br>
					<h4><SPAN style="color: #144040">修改图片信息</SPAN></h4>
					<br>
					<hr>
					<br>
					<font color="red"><s:fielderror/></font>
					<s:form enctype="multipart/form-data" action="photo_edit" method="post">
	  					<table border="0" cellpadding="0" cellspacing="8">
		  					<tr>
		  						<td>上传照片</td>
		  						<td><s:file cssClass="myfile" name="upload"></s:file></td>
		  					</tr>
		  					<tr>
		  						<td>拍摄者:</td>
		  						<td><s:textfield name="photographer"/></td>
		  					</tr>
		  					<tr>	  						
		  						<td>版权所属:</td>
		  						<td><s:textfield name="copyright"/></td>
		  					</tr>
							<tr>	  						
		  						<td>描述:</td>
		  						<td><s:textarea rows="5" cols="30" name="description"/></td>
		  					</tr>
		  					<tr>	  						
		  						<td>关键字:</td>
		  						<td><s:textfield name="keyword"/></td>
		  					</tr>
		  					<tr>
		  						<td><s:submit value="提交" cssClass="imgSubmit"></s:submit></td>
		  						<td><s:reset value="重置"></s:reset></td>
		  					</tr>
		  					<tr>
		  						<td colspan="2" align="center"><s:a action="photo_list"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></s:a></td>
		  					</tr>
	  					</table>
	  					<!-- photoId作为隐藏值 -->
	  					<s:hidden name="photoId"/>
	  				</s:form>
	  				<s:actionerror/>
  				</center>
    		</div>
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
</html>
