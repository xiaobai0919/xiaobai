<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/script/common.js"></script>
<%@include file="/common/head.jsp" %>
</head>

<body>
	<div class="page_title">客户开发计划 &gt; 查看</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td>${sc.scId }</td>
			<th>机会来源</th>
			<td>${sc.scSource }</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td>${sc.scCustName }</td>
			<th>成功机率（%）</th>
			<td>${sc.scRate }</td>
		</tr>	
		<tr>
			<th>概要</th>
			<td>${sc.scTitle }</td>
			<th>状态</th>
			<td>
				<c:if test="${sc.scStatus==3 }"><span style="color: red;">开发成功</span></c:if>
				<c:if test="${sc.scStatus==4 }"><span style="color: red;">开发失败</span></c:if>
			</td>
		</tr>
		<tr>
			<th>联系人</th>
			<td>${sc.scLinkman }</td>
			<th>联系人电话</th>
			<td>${sc.scTel }</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3">${sc.scDesc }</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${sc.scCreateBy }</td>
			<th>创建时间</th>
			<td>${sc.scCreateDate }</td>
		</tr>
		<tr>
			<th>指派给</th>
			<td>${sc.scDueTo }</td>
			<th>指派时间</th>
			<td>${sc.scDueDate }</td>
		</tr>
	</table>
	<br />
	<table class="data_list_table" id="table1">
		<tr>
			<th>日期</th>
			<th>计划</th>
			<th>执行效果</th>
		</tr>
		<c:forEach items="${spList }" var="sp">
			<tr>
				<td class="list_data_text">${sp.spDate }</td>
				<td class="list_data_ltext">${sp.spTodo }</td>
				<td class="list_data_ltext">${sp.spResult }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>