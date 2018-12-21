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
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body class="easyui-layout">

	<div id="tb">
	<a id="addBtn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-back',plain:true" onclick="javascript:window.history.back(-1);">上一级</a>
	
		<a id="editBtn" href="#" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:doDetail"
			data-options="iconCls:'icon-search',plain:true">订单详情</a>
	</div>

	<div data-options="region:'center'">
		<table id="dg" data-bind="datagrid:options">
			<thead>
				<tr>
					<th
						data-options="field:'boId',title:'订单编号',width:'20%',align:'center'">订单编号</th>
					<th
						data-options="field:'boDate',title:'日期',width:'30%',align:'center'">日期</th>
					<th
						data-options="field:'boAddress',title:'送货地址',width:'30%',align:'center'">送货地址</th>
					<th
						data-options="field:'boStatus',title:'状态',width:'20%',align:'center'">状态</th>
				</tr>
			</thead>
		</table>
	</div>

	<s:iterator var="v" value="result">
		<input id="bbname" value="<s:property value="#v.boCustomer" />">
	</s:iterator>
	<%@include file="/common/foot.jsp"%>
	<script
		src="${pageContext.request.contextPath}/ViewModel/basd/listOrders.js"></script>
	<script type="text/javascript">
		var vm = new ViewModel();
		ko.applyBindings(vm);
	</script>
</body>
</html>