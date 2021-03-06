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
    
    <title>修改粤曲信息</title>
    
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
					<h4><SPAN style="color: #144040">修改粤曲信息</SPAN></h4>
					<br>
					<hr>
					<br>
					<font color="red"><s:fielderror/></font>
					<s:form enctype="multipart/form-data" action="song_edit" method="post">
	  					<table border="0" cellpadding="0" cellspacing="8">
		  					<tr>
		  						<td>上传粤曲</td>
		  						<td><s:file cssClass="myfile" name="upload"></s:file></td>
		  					</tr>
		  					<tr>
		  						<td>录制者:</td>
		  						<td><s:textfield name="recorder"/></td>
		  					</tr>
		  					<tr>
		  						<td>演唱者:</td>
		  						<td><s:textfield name="singer"/></td>
		  					</tr>
		  					<tr>	  						
		  						<td>版权所属:</td>
		  						<td><s:textfield name="copyright"/></td>
		  					</tr>
		  					<tr>	  						
		  						<td>描述:</td>
		  						<td><s:textarea cols="30" rows="5" name="description"/></td>
		  					</tr>
		  					<tr>	  						
		  						<td>关键字:</td>
		  						<td><s:textfield name="keyword"/></td>
		  					</tr>
		  					<tr>
		  						<td colspan="2">
		  						<input type="submit" value="提交">
		  						<input type="reset" value="重置">
		  					</td>
		  					</tr>
		  					<tr>
		  						<td colspan="2" align="center"><s:a action="song_list"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></s:a></td>
		  					</tr>
	  					</table>
	  					<!-- songId作为隐藏值 -->
	  					<s:hidden name="songId"/>
	  				</s:form>
	  				<s:actionerror/>
  				</center>
    		</div>
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
</html>
