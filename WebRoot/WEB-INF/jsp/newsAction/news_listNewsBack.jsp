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
    
    <title>news_listNewsBack.jsp</title>
    
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

	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//点击delete按钮，使用Ajax确定是否要删除该条记录
			$(".delete").click(function(){
				var title = $(this).next(":hidden").val();
				var flag = confirm("确定要删除的" + title + "信息吗？");
				if(flag){
					var $tr = $(this).parent().parent();
					//使用Ajax方式
					var url = this.href;
					var args = {"time":new Date()};
					$.post(url, args, function(data){
						//若data的返回值为1，提示删除成功且删除当前行；若data的返回值为0，提示删除失败
						if(data == 1){
							alert("删除成功！");
							$tr.remove();
						}
						else{
							alert("删除失败！");
						}
					});
				}
				return false;
			});
		})
	</script>

  </head>
  
  <body>
    <div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
		<div id="main">
			<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			<div id="main-right">
				<h3>新闻信息</h3>
				<s:a action="news_queryUI"><span style="color: #007DFD;">根据新闻标题查询</span></s:a>　　　　　　　　　　
				<s:a action="news_addUI"><span style="color: #007DFD;">添加新闻</span></s:a>
				<hr>
				<br>
				<center>
					<table border="0" cellpadding="10" cellspacing="1">
						<tr>
							<th>标题</th>
							<th>相关操作</th>
						</tr>
						<s:iterator value="#listNews" status="st">
							<tr <s:if test="#st.odd">style="background-color:#FFDFFF"</s:if>>
								<td>${title }</td>
								<td>
									<s:a action="news_allUI?id=%{id}&pageNow=%{pageNow}"><span style="color: #007DFD;">详细信息</span></s:a>
									<s:a action="news_editUI?id=%{id}&pageNow=%{pageNow}"><span style="color: #007DFD;">修改</span></s:a>
									<s:a action="news_delete?id=%{id}&pageNow=%{pageNow}" cssClass="delete"><span style="color: #007DFD;">删除</span></s:a>
									<input type="hidden" value="${title}"/>
								</td>
							</tr>
						</s:iterator>
					</table>
				</center>
				<br>
				<s:if test="#pageNow == 1">
					[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;&nbsp;&nbsp;&nbsp;
				</s:if>
				<s:else>
					<a href="${pageContext.request.contextPath }/news_listNewsBack.action?pageNow=1">[<span style="color: #007DFD;">首页</span>]</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath }/news_listNewsBack.action?pageNow=<s:property value='#pageNow - 1'/>">[<span style="color: #007DFD;">上一页</span>]</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</s:else>
				<s:if test="#pageNow != #pageCount">
					<a href="${pageContext.request.contextPath }/news_listNewsBack.action?pageNow=<s:property value='#pageNow + 1'/>">[<span style="color: #007DFD;">下一页</span>]</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath }/news_listNewsBack.action?pageNow=<s:property value='#pageCount'/>">[<span style="color: #007DFD;">尾页</span>]</a>
				</s:if>
				<s:else>
					[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]
				</s:else>
				<br>
				<hr width="500px">
				当前页为第 <s:text name="#pageNow"></s:text> 页，总页数为 <s:text name="#pageCount"></s:text> 页
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
