<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>vip-input.jsp</title>
    
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
			$(":text[name=name]").change(function(){
				var val = $(this).val();
				val = $.trim(val);
				var $this = $(this);
				if(val != "") {
					//把当前节点后面的所有兄弟节点删除
					$this.nextAll("font").remove();
					var url = "vip-validateUserName";
					var args = {"name":val, "time":new Date()};
					$.post(url, args, function(data){
						//表示可用
						if(data == 1) {
							$this.after("<font color='green'>这个用户名可用</font>");
						}
						//表示不可用
						else  {
							$this.after("<font color='red'>这个用户名已经注册了</font>");
						}
						/*//表示服务器错误
						else {
							alert("服务器错误！");
						}*/
					});
				}
				else {
					alert("用户名不能为空");
					$(this).val("");					
				}
			});
		});
		
		$(function(){
			$(":submit[name=click]").click(function(){
				alert("添加成功");
			});
		});
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
			 		<br>
			 		<h3>添加高级用户信息</h3>
			 		<hr>
			 		<br>
			 		<form action="${pageContext.request.contextPath }/manager-save.action" method="post">
			 			<table border="0" cellpadding="5" cellspacing="0">
			 				<tr>
			 					<td>用户名：</td>
			 					<td>
			 						<input type="text" name="name"/>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>密码：</td>
			 					<td>
			 						<input type="password" name="password" />
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*由数字和字母组成，至少6位</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>真实姓名：</td>
			 					<td>
			 						<input type="text" name="trueName"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*填写自己真实姓名</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>性别：</td>
			 					<td>
			 						<input type="text" name="gender"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*男/女</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>出生日期：</td>
			 					<td>
			 						<input type="text" name="birthday"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*格式：yyyy-MM-dd</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>地址：</td>
			 					<td>
			 						<input type="text" name="place"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*居住地址</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>手机：</td>
			 					<td>
			 						<input type="text" name="tel"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*现使用的手机号</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>邮箱：</td>
			 					<td>
			 						<input type="text" name="email"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*常用的邮箱</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>微信：</td>
			 					<td><input type="text" name="wechat"/></td>
			 				</tr>
			 				<tr>
			 					<td>QQ：</td>
			 					<td><input type="text" name="qq"/></td>
			 				</tr>
			 				
			 				<tr>
			 					<td>(曾)任职机构：</td>
			 					<td>
			 						<input type="text" name="organizationId"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*必填</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>单位电话：</td>
			 					<td>
			 						<input type="text" name="companyTel"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*必填</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>单位地址：</td>
			 					<td>
			 					 	<input type="text" name="companyPlace"/>
			 					 	&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*必填</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>职务：</td>
			 					<td>
			 						<input type="text" name="duty"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*必填</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>职称：</td>
			 					<td>
			 						<input type="text" name="rank"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*必填</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>毕业院校：</td>
			 					<td><input type="text" name="school"/></td>
			 				</tr>
			 				<tr>
			 					<td>任职时间：</td>
			 					<td>
			 						<input type="text" name="tenureClock"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*必填：格式 yyyy-MM-dd</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>学历：</td>
			 					<td><input type="text" name="education"/></td>
			 				</tr>
			 				<tr>
			 					<td>学位：</td>
			 					<td><input type="text" name="degree"/></td>
			 				</tr>
			 				<tr>
			 					<td>擅长角色：</td>
			 					<td>
			 						<input type="text" name="pose"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*必填</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>备注：</td>
			 					<td>
			 						<input type="text" name="remark"/>
			 						&nbsp;&nbsp;&nbsp;&nbsp;
			 						<span style="color: #FF6D7C">*必填：对粤剧的了解</span>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td>用户类型：</td>
			 					<td><input type="text" name="type"/></td>
			 				</tr>
			 				<tr>
			 					<td></td>
			 					<td>
			 						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 						<input type="submit" value="确定" name="click"/>
			 					</td>
			 				</tr>
			 			</table>
			 		</form>
			 	</center>
			</div>		
		</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
