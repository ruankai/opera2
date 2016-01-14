<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<html>
<head>
<title>微课程</title>

<!-- 这里用来限制字数-->
 <style> 
div.test
{
white-space:nowrap;
width:144px; 
overflow:hidden; 
}

div.test:hover
{
text-overflow:inherit;
}
</style>
<!-- 这里用来限制字数-->

<link href="style/course_style/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="style/course_style/js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="style/course_style/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--start-menu-->
<script src="style/course_style/js/simpleCart.min.js"> </script>
<link href="style/course_style/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="style/course_style/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="style/course_style/js/jquery.easydropdown.js"></script>			
</head>
<body> 
	<!--top-header-->
	<div class="top-header">
		<div class="container">
			<div class="top-header-main">
				<div class="col-md-6 top-header-left">
					<div class="drop">
						
						
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-6 top-header-left">
					
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--top-header-->
	<!--start-logo-->
	<div class="logo">
		<a href="style/course_style/index.html"><h1>微&nbsp;课&nbsp;程</h1></a>
	</div>
	<!--start-logo-->
	<!--bottom-header-->
	<div class="header-bottom">
		<div class="container">
			<div class="header">
				<div class="col-md-9 header-left">
				<div class="top-nav">
					<ul class="memenu skyblue">
					<li class="grid" ><s:a action="course_list" ><h4>主页</h4></s:a></li>
					<li class="grid" ><s:a action="course_listMy" ><h4>我的课程</h4></s:a></li>
					<li class="grid" ><s:a action="course_addCourse" ><h4>新建课程</h4></s:a></li>
					<li class="grid" ><s:a action="course_random" ><h4>随便看看</h4></s:a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-3 header-right"> 
				<div class="search-bar">
				<s:form action="course_search">
				<s:textfield name="name" value="搜索"  ></s:textfield> 
				<s:submit  value=""></s:submit>
				</s:form>
				</div>
			</div>
			<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--bottom-header-->
	
	<!--contact-start-->
	<div class="contact">
		<div class="container">
					<s:iterator value="#auditUI">
				<div class="contact-text">
				<div class="col-md-3 contact-left">
						<div class="address">
							<h5>作者：</h5>
							<p>${user.name}</p>
						</div>
						<div class="address">
							<h5>时间</h5>
							<p><s:date name="time" format="yyyy-MM-dd"/></p>
						</div>
					</div>
					<div class="col-md-9 contact-right">
					
						<s:form action="course_audit">
							<s:textfield name="name" placeholder="课程名字（字数限制为12字）" />
							<s:textarea name="description" placeholder="课程简介（字数限制为50字）" required=""/>
							<div class="submit-btn">
								<input type="submit" value="+添加封面图片">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="submit" value="+添加视频">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="submit" value="+添加资料"></br></br>
								<input type="submit" value="提交修改" style="background:#C5FFFF">
							</div>
						</s:form>
					</s:iterator>
					</div>	
					<div class="clearfix"></div>
				</div>
		</div>
	</div>
	<!--contact-end-->
	
</body>
</html>
