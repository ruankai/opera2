<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<html>
<head>
<title>更改主题板块</title>
</head>
<body>

<div id="wraper">
	<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
	<div id="main">
	<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
	<div id="main-right">
	<center>
	
	<!-- 填充内容 -->
	<br />
	<p>主题原本的板块：</p><h1><strong style=color:#FF0000 >${topic.forum.name}</strong></h1>
	</br>
	<p>请更改板块：</p>
	
	<s:form action="forum_move?topicId=%{#topic.id}">
	
	<s:iterator value="#forumList">
	<label><input name="forumId" type="radio" value="${id}" />${name}</label>
	</s:iterator>
	</br>
	</br>
	</br>
	<s:submit value="确定"></s:submit>
	
	</s:form>
	
   	<div>
   	</br>
   	<a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
    </div>
	</center>
	</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>





</body>
</html>
