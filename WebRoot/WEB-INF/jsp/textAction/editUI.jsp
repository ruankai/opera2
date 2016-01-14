<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>更改文档信息</title>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/common.css"
			type="text/css"></link>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/main.css"
			type="text/css"></link>
		<script src="fckeditor/fckeditor.js">
</script>
		<script>
window.onload = function() {
	var oFCKeditor = new FCKeditor('content');
	oFCKeditor.BasePath = "fckeditor/";//一定要以"/"结尾。test为项目名，也可设为fckeditor/
	oFCKeditor.ToolbarSet = "bbs";
	/*  oFCKeditor.Height = "300";
	oFCKeditor.Width = "600";  */
	/* 		 oFCKeditor.ToolbarSet = "itcastForum"; */
	oFCKeditor.ReplaceTextarea();
};
</script>
	</head>

	<body>
		<div id="wraper">
			<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
			<div id="main">
				<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
				<div id="main-right">
	<center>
					<h4><SPAN style="color: #144040">修改文档</SPAN></h4>
					<br>
					<hr>
					<br>
					<font color="red"><s:fielderror/></font>
   	<s:form action="text_edit" method="post" >
   		<table border="0" cellpadding="0" cellspacing="8">
   	<tr>
		  <td>标题:</td>
		  <td><s:textfield name="title"/></td>
	</tr>
		<tr>
		  <td>作者:</td>
		  <td><s:textfield name="author"/></td>
	</tr>
		<tr>
		  <td>主题:</td>
		  <td><s:textfield name="themes"/></td>
	</tr>
		<tr>
		  <td>网址:</td>
		  <td><s:textfield name="url"/></td>
	</tr>
		<tr>
		  <td>报刊号:</td>
		  <td><s:textfield name="ISSN"/></td>
	</tr>
		<tr>
		  <td>文档内容:</td>
		  <td> 
		  <s:textarea name="content" cssStyle="width:650px;height:200px;">
		  &nbsp;
		  </s:textarea>
		  </td>
	</tr>
	</table>
	<input type="submit" value="确定">&nbsp;&nbsp;<input type="reset" value="重置">	
   	<br>
   	<br>
	 <div>
   	<a href="javascript:history.go(-1);">
   	<img src="${pageContext.request.contextPath}/style/images/goBack.png"/>
   	</a>
    </div>
							<input type="hidden" name="textId" value="${textId}">
							<input type="hidden" name="currentPage" value="${currentPage}">
	</s:form>
	</center>
   		</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"/>
	</div>
   </body>
</html>