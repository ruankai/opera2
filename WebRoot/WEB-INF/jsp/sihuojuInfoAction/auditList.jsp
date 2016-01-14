<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/gridtable.css" />
<html>
<head>
<style> 
div.test
{
width:12em; 
height:1.2em;
overflow:hidden; 
}

div.test:hover
{
text-overflow:inherit;
}
</style>
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
<th>活动名称</th><th>详情</th><th>地点</th><th>时间</th><th>发起人</th><th>参加人数</th>		
</tr>
<s:iterator value="#auditList">
	<tr>
	<td align="center"><s:a action="info_auditShow?infoId=%{id}">${name}</s:a></td>
	<td align="center"><div class="test" style="text-overflow:ellipsis;">${description}</div></td>
	<td align="center">${place}</td>
	<td align="center"><s:date name="firstTime" format="yyyy-MM-dd HH:mm"/></td>
	<td align="center">${user.name}</td>
	<td align="center">${count}</td> 
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
