<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/head.jsp"%>
<%@include file="/rightcom/head.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true"
		style="height: 100px; padding: 5px;">
		<table class="query_form_table">
			<tr>
				<th>权限文本</th>
				<td><input type="text" data-bind="value:formcx.rText,validationElement:formcx.rText" /></td>
				<th>权限描述</th>
				<td><input type="text" data-bind="value:formcx.rTip,validationElement:formcx.rTip" /></td>
				<th>权限类型</th>
				<td><select name="sysRight.rightParentCode">
						<option value="">--请选择父节点--</option>
						<option value="节点值遍历">父节点</option>
				</select></td>
			</tr>
		</table>
	        <a style="margin-left:10px;" href="#" class="easyui-linkbutton" data-bind="click:doClear"  data-options="" >清空</a> 
			<a style="margin-left:10px;" id="listBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" data-bind="click:doQuery" >
			查询</a>
	</div>
	<div id="tb">
		<a id="addBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-bind="click:doAdd">新增</a>
		<a id="editBtn" href="#" class="" data-options="iconCls:'icon-edit',plain:true" data-bind="LinkButton:enableButton,click:doEdit">修改</a>
		<a id="delBtn" href="#" class="" data-options="iconCls:'icon-remove',plain:true" data-bind="LinkButton:enableButton,click:dodel">删除</a>
	</div> 
	<div data-options="region:'center'">
		<table id="dg" data-bind="datagrid:options">
			<thead>
				<tr>
					<th data-options="field:'rCode',title:'权限编号',width:'20%',align:'center'">权限编号</th>
					<th data-options="field:'rText',title:'权限文本',width:'20%',align:'center'">权限文本</th>
					<th data-options="field:'rParentCode',title:'权限父节点',width:'20%',align:'center'">权限父节点</th>
					<th data-options="field:'rType',title:'权限类型',width:'40%',align:'center'">权限类型</th>
					<th data-options="field:'rTip',title:'权限描述',width:'40%',align:'center'">权限描述</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="bb">
		<a href="#" class="easyui-linkbutton" data-bind="click:doSubmit">保存</a>
		<a href="#" class="easyui-linkbutton" data-bind="click:doClose">关闭</a>
	</div>
	<div id="dd" class="easyui-dialog form"
		style="width: 500px; height: 300px;"
		data-options="iconCls:'icon-save',modal:true,closable:true,closed:true,buttons:'#bb'">
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td>
				<input type="hidden" data-bind="value:form.methodName"/>
				<input id="rCode" type="text" data-bind="value:form.rCode"/>
				</td>
				<th>权限类型</th>
				<td>
					<select data-bind="value:form.rType">
						<option value="Folder">根结点</option>
						<option value="Folder">父节点</option>
						<option value="Document">子节点</option>
					</select>
					</td>
				<th>父节点</th>
				<td>
					<select data-bind="value:form.rParentCode">
						<option value="">--请选择父节点--</option>
						<option value="节点值遍历">父节点</option>
					</select>
					</td>
			</tr>
			<tr>
				<th>权限文本</th>
				<td><input type="text" data-bind="value:form.rText"/>
				</td>
				<th>权限URL</th>
				<td><input type="text" data-bind="value:form.rUrl"/>
				</td>
				<th>权限描述</th>
				<td><textarea data-bind="value:form.rTip"></textarea>
				</td>
			</tr>
		</table>
		
	</div>
	<%@include file="/common/foot.jsp" %>
	<script type="text/javascript"  src="${pageContext.request.contextPath }/ViewModel/right/right/list.js"></script>
	<script type="text/javascript">
		var vm = new ViewModel();
		ko.applyBindings(vm);
	</script>
</body>
</html>