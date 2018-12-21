<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<!-- 重点，必加该class -->
<body class="easyui-layout">
	<!--  -->
	<div data-options="region:'north',split:true" style="height: 65px; padding: 5px;">
		<div class="page_title">销售机会管理</div>
		客户名称：<input data-bind="value:form.scCustName,validationElement:form.scCustName" class="ttip" /> 
		概要：<input data-bind="value:form.scTitle,validationElement:form.scTitle" class="ttip" /> 
		联系人：<input data-bind="value:form.scLinkman,validationElement:form.scLinkman" class="ttip" /> 
		<a class="easyui-linkbutton"data-bind="click:doQuery" data-options="iconCls:'icon-search'"style="margin-left: 10px;">查询</a> 
		<a class="easyui-linkbutton"data-bind="click:doClear" data-options="" style="margin-left: 10px;">清空</a>
	</div>
	<!-- 功能按钮，必须加在表格的上面 -->
	<div id="tb">
		<a id="addBtn" href="#" class="" data-bind="LinkButton:disableButton,click:doAdd" data-options="iconCls:'icon-add',plain:true">新建</a> 
		<a id="zpBtn" href="#" class="" data-bind="LinkButton:enableButton,click:doZp" data-options="iconCls:'icon-edit',plain:true">指派</a> 
		<a id="editBtn" href="#" class="" data-bind="LinkButton:enableButton,click:doEdit" data-options="iconCls:'icon-edit',plain:true">修改</a> 
		<a id="delBtn"href="#" class="" data-bind="LinkButton:enableButton,click:doDel" data-options="iconCls:'icon-remove',plain:true">删除</a>
	</div>
	<div data-options="region:'center'">
		<table id="tab" data-bind="datagrid:listOptions" class="data_list_table">
			<thead>
				<tr>
					<!-- 必须要用th，否则显示不出数据 -->
					<th data-options="field:'scId',title:'编号',width:'10%',align:'center'">编号</th>
					<th data-options="field:'scCustName',title:'客户名称',width:'15%',align:'center'">客户名称</th>
					<th data-options="field:'scTitle',title:'概要',width:'20%',align:'center'">概要</th>
					<th data-options="field:'scLinkman',title:'联系人',width:'10%',align:'center'">联系人</th>
					<th data-options="field:'scTel',title:'联系人电话',width:'15%',align:'center'">联系人电话</th>
					<th data-options="field:'scCreateDate',title:'创建时间',width:'17%',align:'center'">创建时间</th>
					<th data-options="field:'scStatus',title:'状态',width:'10%',align:'center'">状态</th>
				</tr>
			</thead>
		</table>
	</div>
	<%@include file="/common/foot.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ViewModel/sale/list.js"></script>
	<script type="text/javascript">
		var vm = new ViewModelSaleChance();
		ko.applyBindings(vm);
	</script>

</body>
</html>