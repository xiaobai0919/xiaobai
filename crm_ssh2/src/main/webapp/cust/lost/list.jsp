<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/head.jsp"%>
<style type="text/css">
.form input, .from select, .from textarea {
	width: 240px;
}
</style>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body class="easyui-layout">

	<div data-options="region:'north',split:true"
		style="height: 50px; padding: 5px">
		客户名称：<input class="tttip"
			data-bind="value:queryForm.clCustName,validationElement:queryForm.clCustName"
			type="text"> <a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" data-bind="click:doQuery"
			style="margin-left: 10px">搜索</a> <a href="#"
			class="easyui-linkbutton" data-options="" data-bind="click:doClear"
			style="margin-left: 10px">清空</a>
	</div>

	<div id="tb">
		<a id="editBtn" href="#" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:doSure"
			data-options="iconCls:'icon-edit',plain:true">确认流失</a> <a id="delBtn"
			href="#" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:doLow"
			data-options="iconCls:'icon-remove',plain:true">暂缓流失</a>
	</div>


	<div data-options="region:'center'">
		<table id="dg" data-bind="datagrid:options">
			<thead>
				<tr>
					<th
						data-options="field:'clId',title:'编号',width:'10%',align:'center'">编号</th>
					<th
						data-options="field:'clCustName',title:'客户',width:'15%',align:'center'">客户</th>
					<th
						data-options="field:'clCustManagerName',title:'客户经理',width:'20%',align:'center'">客户经理</th>
					<th
						data-options="field:'clLastOrderDate',title:'上次下单时间',width:'23%',align:'center'">上次下单时间</th>
					<th
						data-options="field:'clLostDate',title:'确认流失时间',width:'23%',align:'center'">确认流失时间</th>
					<th
						data-options="field:'clStatus',title:'状态',width:'7%',align:'center'" >状态</th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="bb">
		<a href="#" class="easyui-linkbutton" data-bind="click:doSubmit">保存</a>
		<a href="#" class="easyui-linkbutton" data-bind="click:doClose">关闭</a>
	</div>

	<div id="dd" class="easyui-dialog from"
		style="width: 800px; height: 270px;"
		data-options="iconCls:'icon-save',modal:true,closable:true,closed:true,buttons:'#bb'">
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input disabled="disabled" data-bind="value:form.clId"></td>
				<th>客户</th>
				<td><input disabled="disabled"
					data-bind="value:form.clCustName"></td>
			</tr>
			<tr>
				<th>客户经理</th>
				<td><input disabled="disabled"
					data-bind="value:form.clCustManagerName"></td>
				<th>上次下单时间</th>
				<td><input disabled="disabled"
					data-bind="value:form.clLastOrderDate"></td>
			</tr>
			<tr>
				<th>暂缓措施</th>
				<td><input disabled="disabled" data-bind="value:form.clDelay"></td>
			</tr>
			<tr>
				<th>流失原因</th>
				<td colspan="3"><textarea rows="6" cols="50"
						data-bind="value:form.clReason"></textarea><span class="red_star">*</span></td>
			</tr>
		</table>
	</div>

	<%@include file="/common/foot.jsp"%>
	<script
		src="${pageContext.request.contextPath}/ViewModel/cust/listLost.js"></script>
	<script type="text/javascript">
		var vm = new ViewModel();
		ko.applyBindings(vm);
	</script>
</body>
</html>