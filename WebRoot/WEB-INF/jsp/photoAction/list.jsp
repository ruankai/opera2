<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图片列表</title>
    
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


  </head>
  
  <body>
    <div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
		<div id="main">
			<div id="main-left">
				<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			</div>
			<div id="main-right">
				<center>
					<br><br>
					<h4><SPAN style="color: #144040">照片列表</SPAN></h4>
					<s:a action="photo_addUI"><span style="color: #007DFD;">上传照片</span></s:a>
					<hr>
					<br>
				<%-- 	<s:form enctype="multipart/form-data" action="img_upload" method="post"> --%>
	  					<table border="0" cellpadding="5" cellspacing="5">
  							<tr>
	  							<th>路径</th>
	  							<th>相关操作</th>
	  						</tr>
	  						
		  					<s:iterator value="recordList" status="st">
		  						<tr <s:if test="#st.odd">style="background-color:#FFDFFF"</s:if>>
		  							<td>${initiateName}</td>
		  							<td>
		  								<s:a action="photo_show?photoId=%{photoId}">
		  									<span style="color: #007DFD;">查看</span>
		  									</s:a>
		  								<s:a action="photo_editUI?photoId=%{photoId}">
		  									<span style="color: #007DFD;">修改</span>
		  									</s:a>　
										<s:a action="photo_delete?photoId=%{photoId}&photo=%{photo}" cssClass="delete" 
											onclick="return confirm('确定要删除吗？')">
											<span style="color: #007DFD;">删除</span>
										</s:a>
										</td>
		  						</tr>	
		  					</s:iterator>
	  					</table>
	  				<%-- </s:form> --%>
	  				<s:actionerror/>
  				</center>
  				<br>
  			<s:if test="rowNumber==0">
	  						暂时没有图片！	
	  		</s:if>
	  		<s:else>
				<s:if test="currentPage <= 1">
					[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;&nbsp;&nbsp;&nbsp;
				</s:if>
				<s:else>
					<s:a href="photo_list.action?currentPage=1">[<span style="color: #007DFD;">首页</span>]</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
					<s:a href="photo_list.action?currentPage=%{currentPage-1}">[<span style="color: #007DFD;">上一页</span>]</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
				</s:else>
				<s:if test="currentPage<totalPage">
					<s:a href="photo_list.action?currentPage=%{currentPage+1}">[<span style="color: #007DFD;">下一页</span>]</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
					<s:a href="photo_list.action?currentPage=%{totalPage}">[<span style="color: #007DFD;">尾页</span>]</s:a>
				</s:if>
				<s:else>
					[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]
				</s:else>
				<br>
				<hr width="500px">
	<div>
		页次：${currentPage}/${totalPage}页 &nbsp;
		每页显示：${pageSize }条 &nbsp;
		总记录数：${rowNumber}条
	</div>
    		</s:else>
    		</div>
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
</html>
