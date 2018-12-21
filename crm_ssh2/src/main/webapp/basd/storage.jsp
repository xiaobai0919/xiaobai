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
	<div class="page_title">产品查询</div>
	<div data-options="region:'north',split:true" style="height: 65px; padding: 5px;">
		<div class="page_title">数据字典管理</div>
		产品：<input data-bind="value:form.bpName,validationElement:form.bpName" class="ttip" />
		仓库：<input data-bind="value:form.bsWarehouse,validationElement:form.bsWarehouse" class="ttip" /> 
		<a class="easyui-linkbutton" data-bind="click:doQuery" data-options="iconCls:'icon-search'"style="margin-left: 10px;">查询</a> 
		<a class="easyui-linkbutton" data-bind="click:doClear" data-options="" style="margin-left: 10px;">清空</a>
	</div>
	<div data-options="region:'center'">
		<table id="tab" data-bind="datagrid:listOptions" class="data_list_table">
			<thead>
				<tr>
					<!-- 必须要用th，否则显示不出数据 -->
					<th data-options="field:'bsId',title:'编号',width:'10%',align:'center'">序号</th>
					<th data-options="field:'bpName',title:'产品',width:'30%',align:'center'">产品</th>
					<th data-options="field:'bsWarehouse',title:'仓库',width:'30%',align:'center'">仓库</th>
					<th data-options="field:'bsWare',title:'货位',width:'18%',align:'center'">货位</th>
					<th data-options="field:'bsCount',title:'件数',width:'18%',align:'center'">件数</th>
					<th data-options="field:'bsMenu',title:'备注',width:'18%',align:'center'">备注</th>
				</tr>
			</thead>
		</table>
	</div>
	<%@include file="/common/foot.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ViewModel/basd/storage.js"></script>
	<script type="text/javascript">
		var vm = new ViewModelBasdStorage();
		ko.applyBindings(vm);
	</script>
</body>
</html>