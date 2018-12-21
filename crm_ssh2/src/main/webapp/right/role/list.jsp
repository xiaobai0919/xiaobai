<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/head.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<title>用户管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/rightcom/head.jsp"%>
</head>
<body class="easyui-layout" >
	<div data-options="region:'north',split:true" style="height: 100px; padding: 5px;">
		<table class="query_form_table">
			<tr>
				<th>角色名</th>
				<td><input type="text" data-bind="value:formcx.rrName" size="20" /></td>
				<th>角色描述</th>
				<td><input type="text" data-bind="value:formcx.rrDesc" name="sysRole.roleDesc" size="20" /></td>
				<th>是否禁用</th>
				<td><select data-bind="value:formcx.rrFlag">
						<option value="3">全部</option>
						<option value="1">正常</option>
						<option value="2">禁用</option>
				</select></td>
			</tr>
		</table>
	        <a style="margin-left:10px;" href="#" class="easyui-linkbutton" data-bind="click:doClear"  data-options="" >清空</a> 
			<a style="margin-left:10px;" id="listBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" data-bind="click:doQuery" >
			查询</a>
	</div>
	<div id="tb">
		<a id="editBtn" href="#" class="" data-options="iconCls:'icon-edit',plain:true" data-bind="LinkButton:enableButton,click:doEdit">编辑</a>
		<a id="delBtn" href="#" class="" data-options="iconCls:'icon-remove',plain:true" data-bind="LinkButton:enableButton,click:dodel">删除</a>
		<a id="delBtn" href="#" class="" data-options="iconCls:'icon-remove',plain:true" data-bind="LinkButton:enableButton,click:dock">查看</a>
	</div> 
	<div data-options="region:'center'">
		<table id="dg" data-bind="datagrid:options">
			<thead>
				<tr>
					<th data-options="field:'rrId',title:'编号',width:'20%',align:'center'">编号</th>
					<th data-options="field:'rrName',title:'角色名',width:'20%',align:'center'">角色名</th>
					<th data-options="field:'rrDesc',title:'角色描述',width:'20%',align:'center'">角色描述</th>
					<th data-options="field:'flagState',title:'状态',width:'40%',align:'center'">状态</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="bb">
		<a href="#" class="easyui-linkbutton" data-bind="click:doSubmit">保存</a>
		<a href="#" class="easyui-linkbutton" data-bind="click:doClose">关闭</a>
	</div>
	<div id="bc">
		<a href="#" class="easyui-linkbutton" data-bind="click:doCloses">关闭</a>
	</div>
	<div id="dd" class="easyui-dialog form" style="width: 500px; height: 300px;"
	data-options="iconCls:'icon-save',modal:true,closable:true,closed:true,buttons:'#bb'">
			<table class="query_form_table">
	   		<tr>
	   			<th>
	   				编号
	   			</th>
	   			<td>
	   				<input type="text" disabled="disabled" data-bind="value:form.rrId">
	   			</td>
	   			<th>
	   				角色名
	   			</th>
	   			<td><input data-bind="value:form.rrName"></td>
	   		</tr>
	   		<tr>
	   			<th>
	   				角色描述
	   			</th>
	   			<td>
	   				<input  data-bind="value:form.rrDesc">
	   			</td>
	   			<th>状态</th>
	   			<td>
	   				<select  data-bind="value:form.rrFlag">
						<option value="1">正常</option>
						<option value="2">禁用</option>
				</select> 
	   			</td>
	   		</tr>
	   	</table>
	</div>
	
	<div id="cc" class="easyui-dialog form" style="width: 500px; height: 300px;"
	data-options="iconCls:'icon-save',modal:true,closable:true,closed:true,buttons:'#bc'">
			<table class="query_form_table">
	   		<tr>
	   			<th>
	   				编号
	   			</th>
	   			<td>
	   				<input type="text" disabled="disabled" data-bind="value:form.rrId">
	   			</td>
	   			<th>
	   				角色名
	   			</th>
	   			<td><input disabled="disabled" data-bind="value:form.rrName"></td>
	   		</tr>
	   		<tr>
	   			<th>
	   				角色描述
	   			</th>
	   			<td>
	   				<input disabled="disabled" data-bind="value:form.rrDesc">
	   			</td>
	   			<th>状态</th>
	   			<td>
	   				<select  disabled="disabled" data-bind="value:form.rrFlag">
						<option value="1">正常</option>
						<option value="2">禁用</option>
				</select> 
	   			</td>
	   		</tr>
	   	</table>
	</div>
	<%@include file="/common/foot.jsp" %>
	<script type="text/javascript"  src="${pageContext.request.contextPath }/ViewModel/right/role/list.js"></script>
	<script type="text/javascript">
		var vm = new ViewModel();
		ko.applyBindings(vm);
	</script>
</body>
</html>