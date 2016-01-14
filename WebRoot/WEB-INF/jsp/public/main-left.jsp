<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>main-left.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css"></link>
  
  </head>
  
  <body>
  	<div id="main-left">
		<ul id="functionmenu">
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/user-uservipmanager.action">用户管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/news_listNewsBack.action">新闻管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/video_list.action">粤剧管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/song_list.action">粤曲管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/photo_list.action">照片管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/text_list.action">文档管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/minren_list.action">名人堂</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/minren_listBack.action">名人堂管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/forumManage_list.action">论坛板块</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/forum_list.action">论坛管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/info_list.action">私伙局</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/info_listBack.action">私伙局管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/course_listBack.action">微课程管理</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/manager-updatepwd.action">修改密码</a>
				</div>
			</li>
			<li>
				<div>
					<a href="${pageContext.request.contextPath }/manager-logout.action">注销</a>
				</div>
			</li>
		</ul>
	</div>
  </body>
</html>
