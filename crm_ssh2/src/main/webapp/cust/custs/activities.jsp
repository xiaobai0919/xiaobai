<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
</head>
<body class="easyui-layout">

	<div id="tb">
	<a id="addBtn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-back',plain:true" onclick="javascript:window.history.back(-1);">上一级</a>
	
		<a id="addBtn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" data-bind="click:doAdd">新增</a>

		<a id="editBtn" href="#" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:doEdit"
			data-options="iconCls:'icon-edit',plain:true">编辑</a> <a id="delBtn"
			href="#" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:dodel"
			data-options="iconCls:'icon-remove',plain:true">删除</a>
	</div>

	<div data-options="region:'center'">
		<table id="dg" data-bind="datagrid:options">
			<thead>
				<tr>
					<th
						data-options="field:'caID',title:'ID',width:'2%',align:'center'">ID</th>
					<th
						data-options="field:'caDate',title:'时间',width:'16%',align:'center'">时间</th>
					<th
						data-options="field:'caPlace',title:'地点',width:'17%',align:'center'">地点</th>
					<th
						data-options="field:'caTitle',title:'概要',width:'20%',align:'center'">概要</th>
					<th
						data-options="field:'caDesc',title:'详情',width:'20%',align:'center'">详情</th>
					<th
						data-options="field:'caRemark',title:'备注',width:'22%',align:'center'">备注</th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="bb">
		<a href="#" class="easyui-linkbutton" data-bind="click:doSubmit">保存</a>
		<a href="#" class="easyui-linkbutton" data-bind="click:doClose">关闭</a>
	</div>


	<div id="dd" class="easyui-dialog from" title="交往记录"
		style="width: 1000px; height: 440px;"
		data-options="iconCls:'icon-save',modal:true,closable:true,closed:true,buttons:'#bb'">
		<table class="query_form_table" id="table1">
			<tr>
				<th>时间</th>
				<td><input data-bind="value:form.caDate" size="20" /><span
					class="red_star">*</span></td>
				<th>地点</th>
				<td><input data-bind="value:form.caPlace" size="20" /><span
					class="red_star">*</span></td>
			</tr>
			<tr>
				<th>概要</th>
				<td><input data-bind="value:form.caTitle" size="20" /><span
					class="red_star">*</span></td>
				<th>备注</th>
				<td><input data-bind="value:form.caRemark" size="20" /></td>
			</tr>
			<tr>
				<th>详细信息</th>
				<td colspan="3"><textarea cols="50" rows="6" data-bind="value:form.caDesc"></textarea>
				</td>
			</tr>
		</table>
	</div>

		<s:iterator var="v" value="result">
			<input id="ccno" hidden value="<s:property value="#v.caCustNo" />">
			<input id="ccname" hidden value="<s:property value="#v.clkCustName" />">
		</s:iterator>
		<%@include file="/common/foot.jsp"%>
		<script
			src="${pageContext.request.contextPath}/ViewModel/cust/listActivity.js"></script>
		<script type="text/javascript">
			var vm = new ViewModel();
			ko.applyBindings(vm);
		</script>
</body>
</html>