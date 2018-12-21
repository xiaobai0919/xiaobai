<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<%@include file="/common/head.jsp"%>
<style type="text/css">
.form input, .from select, .from textarea {
	width: 240px;
}
</style>
<title>Insert title here</title>
</head>
<body class="easyui-layout">

	<div id="tb">
		<a id="addBtn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-back',plain:true"
			onclick="javascript:window.history.back(-1);">上一级</a> <a id="addBtn"
			href="#" class="easyui-linkbutton"
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
						data-options="field:'clkID',title:'ID',width:'2%',align:'center'">ID</th>
					<th
						data-options="field:'clkName',title:'姓名',width:'14%',align:'center'">姓名</th>
					<th
						data-options="field:'clkSex',title:'性别',width:'10%',align:'center'">性别</th>
					<th
						data-options="field:'clkPostion',title:'职位',width:'17%',align:'center'">职位</th>
					<th
						data-options="field:'clkTel',title:'办公电话',width:'20%',align:'center'">办公电话</th>
					<th
						data-options="field:'clkMobile',title:'手机',width:'16%',align:'center'">手机</th>
					<th
						data-options="field:'clkMenu',title:'备注',width:'18%',align:'center'">备注</th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="bb">
		<a href="#" class="easyui-linkbutton" data-bind="click:doSubmit">保存</a>
		<a href="#" class="easyui-linkbutton" data-bind="click:doClose">关闭</a>
	</div>


	<div id="dd" class="easyui-dialog from" title="联系人信息"
		class="query_form_table" style="width: 1000px; height: 440px;"
		data-options="iconCls:'icon-save',modal:true,closable:true,closed:true,buttons:'#bb'">
		<table class="query_form_table" id="table1">
			<tr>
				<th>姓名</th>
				<td><input data-bind="value:form.clkName" size="20" /><span
					class="red_star">*</span></td>
				<th>性别</th>
				<td><input name="sex" type="radio" value="男" />男 <input
					name="sex" type="radio" value="女" />女</td>
			</tr>
			<tr>
				<th>职位</th>
				<td><input data-bind="value:form.clkPostion" size="20" /><span
					class="red_star">*</span></td>
				<th>办公电话</th>
				<td><input data-bind="value:form.clkTel" size="20" /><span
					class="red_star">*</span></td>
			</tr>
			<tr>
				<th>手机</th>
				<td><input data-bind="value:form.clkMobile" size="20" /></td>
				<th>备注</th>
				<td><input data-bind="value:form.clkMenu" size="20" /></td>
			</tr>
		</table>
	</div>

	<s:iterator var="v" value="result">
		<input id="ccno" hidden value="<s:property value="#v.clkCustNo" />">
		<input id="ccname" hidden
			value="<s:property value="#v.clkCustName" />">
	</s:iterator>
	<%@include file="/common/foot.jsp"%>
	<script
		src="${pageContext.request.contextPath}/ViewModel/cust/listLinkman.js"></script>
	<script type="text/javascript">
		var vm = new ViewModel();
		ko.applyBindings(vm);
	</script>
</body>
</html>