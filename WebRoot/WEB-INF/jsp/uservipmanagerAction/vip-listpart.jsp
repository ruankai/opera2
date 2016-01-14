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
    
    <title>vip-listpart.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//点击delete按钮，使用Ajax确定是否要删除该条记录
			$(".delete").click(function(){
				var userName = $(this).next(":hidden").val();
				var flag = confirm("确定要删除的" + userName + "信息吗？");
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

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css"></link>
  
  </head>
  
  <body>
  	<div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include> 
		<div id="main">
			<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			<div id="main-right">
				<center>
					<h3>显示高级用户的信息</h3>
					<hr>
					<br>
					<s:if test="#vippart == null || #vippart.size() == 0">
						没有高级用户的信息
					</s:if>
					<s:else>
						<table border="0" cellpadding="5" cellspacing="1">
							<tr>
								<th>账号</th>
								<th>密码</th>
								<th>用户名</th>
								<th>真实姓名</th>
								<th>-详细信息-</th>
								<!-- <th>-修改-</th> -->
								<th>-删除-</th>
							</tr>
							<s:iterator value="#vippart" status="st">
								<tr <s:if test="#st.odd">style="background-color:#FFDFFF"</s:if>>
									<td>${id }</td>
									<td>${password }</td>
									<td>${name }</td>
									<td>${trueName }</td>
									<td><s:a action="vip-listall?id=%{id }&pageNow=%{pageNow}">详细信息</s:a></td>
									<!-- <td><a href="vip-update?vipId=${vipId }">修改</a></td> -->
									<td>
										<s:a action="vip-delete?id=%{id }&pageNow=%{pageNow}" cssClass="delete">删除</s:a>
										<input type="hidden" value="${name}"/>
									</td>
								</tr>
							</s:iterator>
						</table>
					</s:else>
					<br>
					<s:if test="#pageNow == 1">
						[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;&nbsp;&nbsp;&nbsp;
					</s:if>
					<s:else>
						<a href="${pageContext.request.contextPath }/vip-listpart.action?pageNow=1">[首页]</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/vip-listpart.action?pageNow=<s:property value='#pageNow - 1'/>">[上一页]</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</s:else>
					<s:if test="#request.pageNow != #request.pageCount">
						<a href="${pageContext.request.contextPath }/vip-listpart.action?pageNow=<s:property value='#pageNow + 1'/>">[下一页]</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/vip-listpart.action?pageNow=<s:property value='#pageCount'/>">[尾页]</a>
					</s:if>
					<s:else>
						[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]
					</s:else>
					<br>
					<hr width="500px">
					当前页为第 <s:text name="#pageNow"></s:text> 页，总页数为 <s:text name="#pageCount"></s:text> 页
				</center>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  
  </body>
</html>
