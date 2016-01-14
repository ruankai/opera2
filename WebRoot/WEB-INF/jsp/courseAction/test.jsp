<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传演示</title>
</head>

<body>
	<div align="center">
		<s:form action="course_add" enctype="multipart/form-data">
			
			<s:textfield name="name" placeholder="课程名字（字数限制为12字）"/>
			<s:textarea name="description" placeholder="课程简介（字数限制为50字）" required=""/>
			</br>
			【封面图片】：
			<input type="file" name="img">
			<br><br>
			【mov】：
			<input type="file" name="mov">
			<br><br>
			【res】：
			<input type="file" name="res">
			<br><br>
			<input type="submit" value="确认上传">
		</s:form>
		

	</div>
</body>
</html>

<!-- 
【学习视频】：
<input type="file" name="mov">${mov}
<br><br>
【学习资料】：
<input type="file" name="res">${res}
<br><br>
 -->