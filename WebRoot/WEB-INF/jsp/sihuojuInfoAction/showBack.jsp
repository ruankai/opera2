<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/gridtable.css" />
<html>
<body>	
<script type="text/javascript">
function show()
{
alert("参加成功!")
}
</script>	

<div id="wraper">
	<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
	<div id="main">
	<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
	<div id="main-right">
	<center>
	
	<!-- 填充内容 -->
	<table class="gridtable" border="0" cellpadding="0" cellspacing="1" width="100%">
<tr>
<th>活动内容</th><th></th>
</tr>		
<s:iterator value="#info">
<tr>
	<td align="center">活动名称</td>
	<td align="center">${name}</td>
</tr>
<tr>
	<td align="center">活动详情</td>
	<td align="center">${description}</td>
</tr>
<tr>
	<td align="center">活动地点</td>
	<td align="center">${place}</td>
</tr>
<tr>
	<td align="center">活动时间</td>
	<td align="center"><s:date name="firstTime" format="yyyy-MM-dd HH:mm"/></td>
</tr>
<tr>
	<td align="center">活动人数</td>
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
