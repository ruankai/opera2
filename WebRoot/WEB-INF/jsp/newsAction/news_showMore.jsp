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
    
    <title>news_showMore.jsp</title>
    
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
					<br>
					<table border="0" cellpadding="6" cellspacing="6">
						<s:iterator value="#listNews" status="st">
							<tr <s:if test="#st.odd">style="background-color:#FFF1EE"</s:if>>
								<td><s:a action="news_show?id=%{id}">&nbsp;&nbsp;<span style="color: #007DFD;">${title}</span></s:a></td>
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
