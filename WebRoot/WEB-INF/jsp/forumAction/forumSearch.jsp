<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/gridtable.css" />
<html>
	<head>
		<title>My JSP 'index.jsp' starting page</title>
	</head>
	<body>
	
	<div id="wraper">
	<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
	<div id="main">
	<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
	<div id="main-right">
	<center>
	
	<!-- 填充内容 -->
	<table class="gridtable" border="0" cellpadding="0" cellspacing="1" width="100%">
		<tr>
			<th>主题</th><th>回复数</th><th>最后回复</th>
		</tr>
		<s:iterator value="#searchList">
			
			<tr >
			<!--作者名称-->
				<td align="center" >
					<s:a action="topic_show?id=%{id}" target="_blank">${title}</s:a>
				</td>

			<!-- 回复数 -->
				<td align="center">
					${replyCount}
				</td>
			
			<!-- 最后回复 -->
				<td align="center">
					${lastUpdateTime}
				</td>
			</tr>
			
			</s:iterator>
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
