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

<!-- 播放器 -->
<link rel="stylesheet" type="text/css" href="style/CuPlayer/common.css">
<link rel="stylesheet" type="text/css" href="style/CuPlayer/style.css">
<style type="text/css">
<!--
/* myplayer */
div#myplayer { width:950px;border:1px #cccccc solid; clear:both;  background:#ffffff; clear:both; height:390px;}

ul.mylist { width:100%; text-align:left;font-size:12px; }
ul.mylist li { padding:1px 0; line-height:24px;height:24px; border-top:1px #efefef solid; }
ul.mylist li.on { background:#efefef;}
ul.mylist li a,ul.mylist li a:link,ul.myllist li a:visited{ padding:0px 6px 0px 30px; overflow:hidden; line-height:24px;height:24px;display:block;  background:url(style/CuPlayer/images/Vico.jpg) no-repeat 6px 6px; text-decoration:none; color:#666666;}
ul.mylist li a:hover{ color:#cc0000; background:#efefef url(style/CuPlayer/images/Vico.jpg) no-repeat 6px 6px; }

div#CuPlayer { width:625px;float:left;margin-left:5px;margin-top:10px;}
div.list { width:310px;float:left;margin-top:10px;}

div.list dl img{ width:70px;height:70px; float:left;}
div.list dl strong { display:block; width:190px;float:left; padding-left:8px;}
div.list dl span { display:block; width:190px;float:left; padding-left:8px;}

div.list dl dt { width:290px;float:left; }
div.list dl dt a { display:block; line-height:18px;padding-top:10px;  border-bottom:1px #cccccc solid; 
 height:85px; padding-top:10px; color:#333; font-size:12px; text-decoration:none; }
div.list dl dt a:hover{  height:85px; padding-top:10px;  text-decoration:none; background:#efefef; }
-->
</style>
<script type="text/javascript"  src="style/CuPlayer/images/jquery-1.4.3.min.js"></script>
<!-- 播放器 -->

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
	<!--top-header-->
	<!--start-logo-->
	<div class="logo">
		<a href="${pageContext.request.contextPath}/style/course_style/index.html"><h1>微&nbsp;课&nbsp;程</h1></a>
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
					<li class="grid" ><s:a action="course_addUI" ><h4>新建课程</h4></s:a></li>
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
	
	
	<!--maincontent/begin-->
	<s:iterator value="#course">
	<div class="maincontent" style="margin-top:30px;">
	<!--myplayer/begin-->
	<div id="myplayer">
  <!--酷播迷你 CuPlayerMiniV4.0 代码开始-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/style/CuPlayer/images/swfobject.js"></script>
  <div id="CuPlayer" > <strong>提示：您的Flash Player版本过低</a></strong> </div>
  <div class="list" style="height:367px;width:310px;overflow-x:hidden;overflow-y:auto" >
  <dl>
  <strong >推荐观看以下课程:</strong>
  </dl>
  <dl>
  <dt><a href="#" onclick="changeStream(0);"><img src="${pageContext.request.contextPath}/${imgUrl}" /><strong>${name}</strong><span>作者：${user.name}</br>时间：<s:date name="time" format="yyyy-MM-dd"/></span></a></dt>
  </dl>
  <!-- 
  <dl>
  <dt><a href="#" onclick="changeStream(1);"><img src="${pageContext.request.contextPath}/style/CuPlayer/images/p2.jpg" /><strong>22达利园青梅绿茶宣传广告</strong><span>作者：超级管理员爸爸</br>时间：2015-08-03</span></a></dt>
  </dl>
  <dl>
  <dt><a href="#" onclick="changeStream(2);"><img src="${pageContext.request.contextPath}/style/CuPlayer/images/p3.jpg" /><strong>33达利园青梅绿茶宣传广告</strong><span>作者：超级管理员爸爸</br>时间：2015-08-03</span></a></dt>
  </dl>
  <dl>
  <dt><a href="#" onclick="changeStream(3);"><img src="${pageContext.request.contextPath}/style/CuPlayer/images/p4.jpg" /><strong>44达利园青梅绿茶宣传广告</strong><span>作者：超级管理员爸爸</br>时间：2015-08-03</span></a></dt>
  </dl>
  <dl>
  <dt><a href="#" onclick="changeStream(4);"><img src="${pageContext.request.contextPath}/style/CuPlayer/images/p2.jpg" /><strong>55达利园青梅绿茶宣传广告</strong><span>作者：超级管理员爸爸</br>时间：2015-08-03</span></a></dt>
  </dl>
   -->
  </div>
  
<script type=text/javascript>

//酷播迷你V4：官方连播代码示例20140611//
var CuPlayerList ="${pageContext.request.contextPath}/${movUrl}|${pageContext.request.contextPath}/style/CuPlayer/test.mp4|${pageContext.request.contextPath}/style/CuPlayer/test.mp4|${pageContext.request.contextPath}/style/CuPlayer/test.mp4|${pageContext.request.contextPath}/style/CuPlayer/test.mp4";
var sp =CuPlayerList.split("|");
var num = sp.length;
var video_index = 0;
function getNext(pars)
{	
  if(video_index < num-1)
	{ 
		video_index++;
		so.addVariable("CuPlayerFile",sp[video_index]);
		so.addVariable("CuPlayerAutoPlay","yes"); //是否自动播放
		so.write("CuPlayer");	
	}
	else
	{
	video_index = 0;
	so.addVariable("CuPlayerFile",sp[video_index]);
	so.addVariable("CuPlayerAutoPlay","yes"); //是否自动播放
	so.write("CuPlayer");	
	}
	$(".list dl dt a").css("background","#ffffff").css("color","#333");
	$(".list dl dt a").eq(video_index).css("background","#efefef").css("color","red");
	LeftScr(video_index);
}
function changeStream(CuPlayerFile){
$(".list dl dt a").css("background","#ffffff").css("color","#333");
$(".list dl dt a:hover").css("background","#efefef").css("color","red");
LeftScr(CuPlayerFile);
video_index = CuPlayerFile;
so.addVariable("CuPlayerFile",sp[CuPlayerFile]);
so.addVariable("CuPlayerAutoPlay","yes"); //是否自动播放
so.write("CuPlayer");	
return false;
}
CuPlayerFile =sp[video_index];
$(".list dl dt a").css("background","#ffffff").css("color","#333");
$(".list dl dt a").eq(video_index).css("background","#efefef").css("color","red");
var so = new SWFObject("${pageContext.request.contextPath}/style/CuPlayer/CuPlayerMiniV4.swf","ply","620","367","9","#000000");
so.addParam("allowfullscreen","true");
so.addParam("allowscriptaccess","always");
so.addParam("wmode","opaque");
so.addParam("quality","high");
so.addParam("salign","lt");
so.addVariable("CuPlayerFile",CuPlayerFile);
so.addVariable("CuPlayerSetFile","${pageContext.request.contextPath}/style/CuPlayer/CuPlayerSetFile.xml"); //* 必须存在/播放器配置文件地址
so.addVariable("CuPlayerImage","${pageContext.request.contextPath}/style/CuPlayer/images/start.jpg");//* 必须存在/视频略缩图,本图片文件必须正确
so.addVariable("CuPlayerWidth","620"); //视频宽度
so.addVariable("CuPlayerHeight","367"); //视频高度
so.addVariable("CuPlayerAutoPlay","yes"); //是否自动播放
so.addVariable("CuPlayerLogo","logo.png"); //Logo文件地址
so.addVariable("CuPlayerPosition","bottom-right"); //Logo显示的位置
so.write("CuPlayer");	

function LeftScr(m){
	var scrtop;
	if(m>1){
	scrtop=55*(m-1);
	}else{
		scrtop=0;
		}
	$(".list").animate({
		scrollTop:scrtop
		},130);
	}

</script>
  <!--酷播迷你 CuPlayerMiniV4.0 代码结束-->
</div>
<!--myplayer/end-->
</div>

<div class="distracted">
 <h3 class="ghj">&nbsp;&nbsp;&nbsp;课程简介：</h3>
 	<div class="well">
	${description}
  	</div>
</div>
<div class="submit-btn">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${movUrl}"><input type="submit" value="下载视频" ></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${resUrl}"><input type="submit" value="下载资料" ></a>
</div>
</br>
	
	
</s:iterator>
</body>
</html>