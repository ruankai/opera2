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
    
    <title>news_query.jsp</title>
    
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
			<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			<div id="main-right">
			<center>
				<br>
				<h4>新闻信息查询</h4>
				<br>
				<s:form action="news_query">
					新闻标题：
					<s:textfield name="title"></s:textfield>
					<s:submit value="确定"></s:submit>
				</s:form>
				<hr>
				<br>
				<table border="0" cellpadding="5" cellspacing="1">
					<tr>
						<th>标题</th>
						<th>内容</th>
					</tr>
					<s:if test="#listNews == null || #listNews.size() == 0">
			  			没有该条新闻
			  		</s:if>
			  		<s:else>
						<s:iterator value="#listNews">
							<tr>
								<td>${title }</td>
								<td>${text }</td>
							</tr>
						</s:iterator>
					</s:else>
				</table>
			</center>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
