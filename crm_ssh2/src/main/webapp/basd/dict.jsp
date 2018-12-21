<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
<%@include file="/common/head.jsp" %>
</head>
<body  class="easyui-layout">
	<div class="page_title">数据字典管理</div>
	<div data-options="region:'north',split:true" style="height: 65px; padding: 5px;">
		<div class="page_title">数据字典管理</div>
		类别：<input data-bind="value:form.bdType,validationElement:form.bdType" class="ttip" /> 
		条目：<input data-bind="value:form.bdItem,validationElement:form.bdItem" class="ttip" /> 
		值：<input data-bind="value:form.bdValue,validationElement:form.bdValue" class="ttip" /> 
		<a class="easyui-linkbutton"data-bind="click:doQuery" data-options="iconCls:'icon-search'"style="margin-left: 10px;">查询</a> 
		<a class="easyui-linkbutton"data-bind="click:doClear" data-options="" style="margin-left: 10px;">清空</a>
	</div>
	<div id="tb">
		<a id="addBtn" href="#" class="" data-bind="LinkButton:disableButton,click:doAdd" data-options="iconCls:'icon-add',plain:true">新建</a> 
		<a id="zpBtn" href="#" class="" data-bind="LinkButton:enableButton,click:doEdit" data-options="iconCls:'icon-edit',plain:true">编辑</a> 
		<a id="editBtn" href="#" class="" data-bind="LinkButton:enableButton,click:doDel" data-options="iconCls:'icon-edit',plain:true">删除</a> 
	</div>
	<div data-options="region:'center'">
		<table id="tab" data-bind="datagrid:listOptions" class="data_list_table">
			<thead>
				<tr>
					<!-- 必须要用th，否则显示不出数据 -->
					<th data-options="field:'bdId',title:'编号',width:'10%',align:'center'">编号</th>
					<th data-options="field:'bdType',title:'类别',width:'30%',align:'center'">类别</th>
					<th data-options="field:'bdItem',title:'条目',width:'30%',align:'center'">条目</th>
					<th data-options="field:'bdValue',title:'值',width:'18%',align:'center'">值</th>
					<th data-options="field:'bdIsEditable',title:'是否可编辑',width:'10%',align:'center'">是否可编辑</th>
				</tr>
			</thead>
		</table>
	</div>
	<%@include file="/common/foot.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ViewModel/basd/dict.js"></script>
	<script type="text/javascript">
		var vm = new ViewModelBasdDict();
		ko.applyBindings(vm);
	</script>
</body>
</html>