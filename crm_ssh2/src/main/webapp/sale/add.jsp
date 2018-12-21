<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<%@include file="/common/head.jsp"%>
</head>
<body class="easyui-layout">
	<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" data-bind="click:doAdd">保存</button>  
	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td><input id="scId" value="${maxScId+1 }" readonly="readonly" data-bind="value:form.scId"/></td>
			<th>机会来源</th>
			<td><input data-bind="value:form.scSource" /></td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td><input data-bind="value:form.scCustName" /><span class="red_star">*</span></td>
			<th>成功机率</th>
			<td><input data-bind="value:form.scRate" /><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3"><input data-bind="value:form.scTitle" size="100"/><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>联系人</th>
			<td><input data-bind="value:form.scLinkman" /></td>
			<th>联系人电话</th>
			<td><input data-bind="value:form.scTel" /></td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3"><textarea data-bind="value:form.scDesc" rows="6" cols="50" name="S1"></textarea><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>创建人</th>
			<td><label data-bind="value:form.scCreateBy" >${login.ruName }</label><span class="red_star">*</span></td>
			<th>创建时间</th>
			<td><label><%=new SimpleDateFormat("yyyy/MM/dd").format(new Date()) %></label><span class="red_star">*</span></td>
		</tr>
	</table>
	<br />
	<%@include file="/common/foot.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ViewModel/sale/add.js"></script>
	<script type="text/javascript">
		var vm = new ViewModelAdd();
		ko.applyBindings(vm);
	</script>
</body>
</html>