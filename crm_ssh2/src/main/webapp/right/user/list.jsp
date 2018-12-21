<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/head.jsp"%>
<%@include file="/rightcom/head.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body class="easyui-layout">
	<div data-options="region:'north',split:true"
		style="height: 100px; padding: 5px;">
		<table class="query_form_table">
			<tr>
				<th>用户名</th>
				<td>
					<input type="text" data-bind="value:formcx.ruName,validationElement:formcx.ruName" size="20"/>
				</td>
				<th>是否禁用</th>
				<td><select data-bind="value:formcx.ruFlag,validationElement:formcx.ruFlag">
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
		<a id="addBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-bind="click:doAdd">新增</a>
		<a id="editBtn" href="#" class="" data-options="iconCls:'icon-edit',plain:true" data-bind="LinkButton:enableButton,click:doEdit">编辑</a>
		<a id="delBtn" href="#" class="" data-options="iconCls:'icon-remove',plain:true" data-bind="LinkButton:enableButton,click:dodel">删除</a>
	</div> 
	<div data-options="region:'center'">
		<table id="dg" data-bind="datagrid:options">
			<thead>
				<tr>
					<th data-options="field:'ruId',title:'编号',width:'20%',align:'center'">编号</th>
					<th data-options="field:'ruName',title:'用户名',width:'20%',align:'center'">用户名</th>
					<th data-options="field:'ruRoleName',title:'角色',width:'20%',align:'center'">角色</th>
					<th data-options="field:'flagState',title:'状态',width:'40%',align:'center'">状态</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="bb">
		<a href="#" class="easyui-linkbutton" data-bind="click:doSubmit">保存</a>
		<a href="#" class="easyui-linkbutton" data-bind="click:doClose">关闭</a>
	</div>
	<div id="dd" class="easyui-dialog form"  title="add"
		style="width: 500px; height: 300px;"
		data-options="iconCls:'icon-save',modal:true,closable:true,closed:true,buttons:'#bb'">
		<table class="query_form_table">
	   		<tr>
	   			<th>用户名</th>
	   			<td>
	   				<input type="hidden" data-bind="value:form.methodName"/>
	   				<input type="text" data-bind="value:form.ruName" size="20">
	   			</td>
	   			<th>密码</th>
	   			<td>
	   				<input type="password" data-bind="value:form.ruPassword" size="20">
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>角色</th>
	   			<td>
	   				<select id="ruRoleId" data-bind="value:form.ruRoleId">
					</select>
	   			</td>
	   			<th>
	   				状态
	   			</th>
	   			<td>
	   				<select data-bind="value:form.ruFlag">
						<option value="1">可用</option>
						<option value="2">不可用</option>
					</select>
	   			</td>
	   		</tr>
	   	</table>
		
	</div>
	<%@include file="/common/foot.jsp" %>
	<script type="text/javascript"  src="${pageContext.request.contextPath }/ViewModel/right/user/list.js"></script>
	<script type="text/javascript">
		var vm = new ViewModel();
		ko.applyBindings(vm);
	</script>
</body>
</html>