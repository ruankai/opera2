<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/gridtable.css" />
<html>
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
<th>参加人员:${count}</th><th>状态</th>	
</tr>
<s:iterator value="#joinList">
	<tr>
	<td align="center">${user.name}</td>
	<td align="center">
	<c:if test="${type == '1'}">
 		<p style="color:green;">通过</p>
    </c:if>
    <c:if test="${type == '2'}">
 		<p style="color:black;">待审核</p>
    </c:if>
    <c:if test="${type == '0'}">
 		<p style="color:red;">拒绝</p>
    </c:if>
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
