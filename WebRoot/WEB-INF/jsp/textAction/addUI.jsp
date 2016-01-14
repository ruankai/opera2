<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>添加新的文档</title>
   </head>
   
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css"></link>
   
   <script charset="utf-8" src="kindeditor-4.1.10/kindeditor-min.js"></script>
	<script charset="utf-8" src="kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script>
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content"]', {

				uploadJson : 'kindeditor-4.1.10/jsp/upload_json.jsp',
                fileManagerJson : 'kindeditor-4.1.10/jsp/file_manager_json.jsp',
                allowFileManager : true,
                allowImageUpload : true, 
				autoHeightMode : true,

				afterCreate : function() {this.loadPlugin('autoheight');},

				afterBlur : function(){ this.sync(); }  //Kindeditor下获取文本框信息

			});
		});
	</script>
   <body>
   <div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
		<div id="main">
			<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			<div id="main-right">
	<center>
					<h4><SPAN style="color: #144040">添加文档</SPAN></h4>
					<br>
					<hr>
					<br>
					<font color="red"><s:fielderror/></font>
   	<s:form action="text_add" method="post" >
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
   	<a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
    </div>
   	</s:form>
   	</center>
   		</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"/>
	</div>
   </body>
</html>