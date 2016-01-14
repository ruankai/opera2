<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head> 
    <title>文档列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css"></link>
<script>
	function go(num){
		document.spform.elements['currentPage'].value = num ;
		document.spform.submit() ;	// 表单提交
	}
</script>
  </head>
<body>
<%-- <s:debug/> --%>
   <div id="wraper">
		<jsp:include page="/WEB-INF/jsp/public/head.jsp"></jsp:include>
		<div id="main">
			<div id="main-left">
				<jsp:include page="/WEB-INF/jsp/public/main-left.jsp"></jsp:include>
			</div>
			<div id="main-right">
  <center>
				<br>
					<h4><SPAN style="color: #144040">文档列表</SPAN></h4>	
					<s:a action="text_addUI"><span style="color: #007DFD;">编辑文档上传</span></s:a><hr/><br>
					<s:if test="rowNumber==0">
						暂时没有文档！
					</s:if>
					<s:else>
						<table border="0" cellpadding="5" cellspacing="0">
							<tr>
								<th>标题</th>
								<th>作者</th>
								<th>详细信息</th>
								<th colspan=2>操作</th>
							</tr>
							<s:iterator value="recordList" status="st">
								<tr <s:if test="#st.odd">style="background-color:#FFDFFF"</s:if>>
									<td>${title}</td>
									<td>${author}</td>
									<td><s:a action="text_detail?textId=%{textId}">内容</s:a></td>
									<td><s:a action="text_editUI?textId=%{textId}&currentPage=%{currentPage}
											">修改</s:a></td>
									<td>
										<s:a action="text_delete?textId=%{textId}" onclick="return confirm('确定要删除吗？')">删除</s:a>
									</td>
								</tr>
							</s:iterator>
						</table>
					</s:else>
				
				<br>
				<s:form name="spform" action="text_list.action" method="post">
				关键词：<input type="text" name="keyword" value="${kw}"><input type="submit" value="查询">		
		<table width="60%" border="0" cellpadding="0" cellspacing="0">  
  

        <tr align="center" valign="top" >  
            <td height="20">  
                <p align="center">  
              
            <span class="x2"><s:a href="text_list.action?currentPage=1">首 页</s:a>  
            <s:if test="currentPage<=1">上一页</s:if>  
            <s:else>  
               <s:a href="text_list.action?currentPage=%{currentPage-1}">上一页  </s:a>  
                  
            </s:else>  
                      
            <s:if test="currentPage>=totalPage">  
    			下一页  
            </s:if>  
        <s:else> 
         <s:a href="text_list.action?currentPage=%{currentPage+1}">下一页 </s:a>  
        </s:else>  
                    <s:a href="text_list.action?currentPage=%{totalPage}">最后一页</s:a>  
                    转到：
		<select onchange="go(this.value)" id="_pn">
			<s:iterator begin="1" end="%{totalPage}" var="num">
			<s:if test="#num==currentPage">
			<option value="${num}" selected>${num}</option>
			</s:if>
			<s:else>
				<option value="${num}">${num}</option>
			</s:else>
			</s:iterator>
		</select>
		  <s:hidden name="currentPage"></s:hidden>
            </span>  
                </p>  
            </td>  
        </tr>  
</table>
</s:form>
			<div>
		页次：${currentPage}/${totalPage}页 &nbsp;
		每页显示：${pageSize }条 &nbsp;
		总记录数：${rowNumber}条
	</div>		
	</center>
	</div>
	</div>
		<jsp:include page="/WEB-INF/jsp/public/foot.jsp"></jsp:include>
	</div>
  </body>
</html>
