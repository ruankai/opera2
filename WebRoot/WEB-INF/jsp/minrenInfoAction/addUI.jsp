<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<html>
<head>
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
</head>
<body>	

<div id="wraper">
	<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
	<div id="main">
	<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
	<div id="main-right">
	<center>
	
	<!-- 填充内容 -->
	<s:form action="minren_add">
	名人：<s:textfield name="name"/></br>
	简介：<s:textarea name="content" /></br>
	<input type="submit"/>
</s:form>	
	
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
