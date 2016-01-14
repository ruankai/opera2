<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/gridtable.css" />

<html>
<head> 
    <title>微课程管理</title>
  </head>
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
	<table class="gridtable" border="0" cellpadding="0" cellspacing="1" width="100%">
	<tr>
	<th>课程</th><th>简介</th><th>时间</th><th>作者</th><th>操作</th>	
	</tr>
	<s:iterator value="#listBack">
	<tr>
	<td align="center"><div class="test" style="text-overflow:ellipsis;">${name}</div> </td>
	<td align="center"><div class="test" style="text-overflow:ellipsis;">${description}</div></td>
	<td align="center"><s:date name="time" format="yyyy-MM-dd HH:mm:ss"/></td> 
	<td align="center">${user.name}</td> 
	<td align="center"><s:a action="course_show?courseId=%{id}">查看</s:a>&nbsp;<s:a action="course_deleteBack?courseId=%{id}">删除</s:a></td> 
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
