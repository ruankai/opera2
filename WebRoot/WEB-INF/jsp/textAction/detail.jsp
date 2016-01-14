<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head> 
    <title>文档详细信息</title>
  </head>
  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css"></link>
  
  <body>
  <div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
		<div id="main">
			<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			<div id="main-right">
	<center>
		<table border="0" cellpadding="0" cellspacing="8">
   	<tr>
		  <td>标题:</td>
		  <td>${title}</td>
	</tr>
		<tr>
		  <td>作者:</td>
		  <td>${author}</td>
	</tr>
		<tr>
		  <td>主题:</td>
		  <td>${theme}</td>
	</tr>
		<tr>
		  <td>网址:</td>
		  <td>${url}</td>
	</tr>
		<tr>
		  <td>报刊号:</td>
		  <td>${ISSN}</td>
	</tr>
		<tr>
		  <td>文档内容:</td>
		  <td rowspan="5">${content}</td>
	</tr>
   	</table>
   	<div>
   	<a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
    </div>
	</center>
	</div>
	</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
