<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/gridtable.css" />
<html>
<body>
	
<script type="text/javascript">
function show()
{
alert("确定参加？")
}
</script>

<div id="wraper">
	<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
	<div id="main">
	<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
	<div id="main-right">
	<center>
	
	<!-- 填充内容 -->
	<p>发起的活动：</p>
<table class="gridtable" border="0" cellpadding="0" cellspacing="1" width="100%">
<tr>
<th>活动名称</th><th>活动地点</th><th>活动时间</th>
</tr>
<s:iterator value="#myList2">
<tr>
	<td align="center"><s:a action="info_show?infoId=%{id}">${name}</s:a></td>
	<td align="center">${place}</td>
	<td align="center"><s:date name="firstTime" format="yyyy-MM-dd HH:mm"/></td>
	
</tr>
</s:iterator>	
</table>
</br>


<p>参加的活动：</p>	
<table class="gridtable" border="0" cellpadding="0" cellspacing="1" width="100%">
<tr>
<th>活动名称</th><th>活动地点</th><th>活动时间</th><th>参加状态</th>
</tr>		

<s:iterator value="#myList">
<tr>
	<td align="center"><s:a action="info_show?infoId=%{sihuojuInfoId}">${sihuojuinfo.name}</s:a></td>
	<td align="center">${sihuojuinfo.place}</td>
	<td align="center"><s:date name="sihuojuinfo.firstTime" format="yyyy-MM-dd HH:mm"/></td>
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
