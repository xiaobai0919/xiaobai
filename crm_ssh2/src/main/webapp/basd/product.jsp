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
<body class="easyui-layout">
	
	<div class="page_title">产品查询</div>
	<div data-options="region:'north',split:true" style="height: 65px; padding: 5px;">
		<div class="page_title">数据字典管理</div>
		名称：<input data-bind="value:form.bpName,validationElement:form.bpName" class="ttip" /> 
		型号：<input data-bind="value:form.bpType,validationElement:form.bpType" class="ttip" /> 
		批次：<input data-bind="value:form.bpBatch,validationElement:form.bpBatch" class="ttip" /> 
		<a class="easyui-linkbutton"data-bind="click:doQuery" data-options="iconCls:'icon-search'"style="margin-left: 10px;">查询</a> 
		<a class="easyui-linkbutton"data-bind="click:doClear" data-options="" style="margin-left: 10px;">清空</a>
	</div>
	<div data-options="region:'center'">
		<table id="tab" data-bind="datagrid:listOptions" class="data_list_table">
			<thead>
				<tr>
					<!-- 必须要用th，否则显示不出数据 -->
					<th data-options="field:'bpId',title:'编号',width:'10%',align:'center'">编号</th>
					<th data-options="field:'bpName',title:'名称',width:'25%',align:'center'">名称</th>
					<th data-options="field:'bpType',title:'型号',width:'15%',align:'center'">型号</th>
					<th data-options="field:'bpBatch',title:'等级/批次',width:'17%',align:'center'">等级/批次</th>
					<th data-options="field:'bpUnit',title:'单位',width:'10%',align:'center'">单位</th>
					<th data-options="field:'bpPrice',title:'单价（元）',width:'10%',align:'center'">单价（元）</th>
					<th data-options="field:'bpMenu',title:'备注',width:'10%',align:'center'">备注</th>
				</tr>
			</thead>
		</table>
	</div>
	<%@include file="/common/foot.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ViewModel/basd/product.js"></script>
	<script type="text/javascript">
		var vm = new ViewModelBasdProduct();
		ko.applyBindings(vm);
	</script>
		
</body>
</html>