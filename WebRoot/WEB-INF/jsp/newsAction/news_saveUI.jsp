<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>news_saveUI.jsp</title>
    
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
  	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
  	<link rel="stylesheet" href="tools/kindeditor/themes/default/default.css" />

	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".issue").click(function(){
				alert("发布成功！");
			});
			
			$(".edit").click(function(){
				alert("修改成功！");
			});
		})
	</script>
    
    <script charset="utf-8" src="kindeditor-4.1.10/kindeditor-min.js"></script>
	<script charset="utf-8" src="kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script>
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="text"]', {

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

  </head>
  
  <body>
    <div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
		<div id="main">
			<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			<div id="main-right">
				<br><br>
				<s:form action="news_%{id == null ? 'add' : 'edit'}">
    				<s:hidden name="id"></s:hidden>
    				<s:hidden name="pageNow"></s:hidden>
    				<s:if test="id == null">
    					<h4>发布新闻</h4>
    					<hr>
	   					<br>
	   					<center>
	    					<table border="0" cellpadding="0" cellspacing="15">
		    					<tr>
		    						<td>标题：　</td>
		    						<td><s:textfield label="标题" name="title"></s:textfield></td>
		    					</tr>
		    					<tr>
		    						<td>内容：　</td>
		    						<td><s:textarea label="内容" name="text" cssStyle="width:650px;height:200px;"></s:textarea></td>
		    					</tr>
		    					<tr>
		    						<td></td>
		    						<td><s:submit value="确定" cssClass="issue"></s:submit></td>
		    					</tr>
	    					</table>
	   					</center>
    				</s:if>
    				<s:else>
    					<h4>修改新闻</h4>
	   					<hr>
	   					<br>
	   					<center>
	    					<table border="0" cellpadding="0" cellspacing="15">
		    					<tr>
		    						<td>标题：　</td>
		    						<td><s:textfield label="标题" name="title"></s:textfield></td>
		    					</tr>
		    					<tr>
		    						<td>内容：　</td>
		    						<td><s:textarea label="内容" name="text"></s:textarea></td>
		    					</tr>
		    					<tr>
		    						<td></td>
		    						<td><s:submit value="确定" cssClass="edit"></s:submit></td>
		    					</tr>
	    					</table>
	   					</center>
   					</s:else>
    			</s:form>　　　　　　　　　
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
