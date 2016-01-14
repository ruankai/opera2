<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/gridtable.css" />
<html>
<body>

<style> 
div.test
{
white-space:nowrap;
width:12em; 
height:1.2em;
overflow:hidden; 
}

div.test:hover
{
text-overflow:inherit;
}
</style>


<div id="wraper">
	<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
	<div id="main">
	<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
	<div id="main-right">
	<center>
	
	<!-- 填充内容 -->
	<s:iterator value="#minren">
	<table class="gridtable" border="0" cellpadding="0" cellspacing="1" width="100%">
	<tr>
	<th>人物</th>
	<td align="center">${name}</td>
	</tr>
	
	<tr>
	<th>简介</th>
	<td align="center">${content}</td>
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
