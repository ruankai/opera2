<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head> 
    <title>文档详细信息</title>
  </head>
  <body>
  <div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
		<div id="main">
			<div id="main-right">
	<center>
	<table>
		<tr>
		<td>标题:&nbsp;&nbsp;</td>
		<td align="center">${title}</td>
		</tr>
		<tr>
		<td>作者:&nbsp;</td>
		<td align="center">${author}</td>
	</tr>
	</table>
	<br>
	<br>
	<table width="650px" heigth="200px" >
   		<tr>
   		<td align="center">文本内容</td>
   		</tr>
   		<!-- 文章内容 -->
   		<tr>
						<td align="center">
							<div class="Content">${content}</div>
						</td>
					</tr>
   	</table>
	</center>
	</div>
	</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
