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
			data-options="iconCls:'icon-back',plain:true"
			onclick="javascript:window.history.back(-1);">上一级</a>
	</div>
	<div data-options="region:'center'">
		<table id="dg" data-bind="datagrid:options">
			<thead>
				<tr>
					<th
						data-options="field:'boId',title:'订单编号',width:'5%',align:'center'">订单编号</th>
					<th
						data-options="field:'boDate',title:'日期',width:'15%',align:'center'">日期</th>
					<th
						data-options="field:'boAddress',title:'送货地址',width:'25%',align:'center'">送货地址</th>
					<th
						data-options="field:'bolPrice',title:'总金额(￥)',width:'10%',align:'center'">总金额(￥)</th>
					<th
						data-options="field:'boStatus',title:'状态',width:'5%',align:'center'">状态</th>
					<th
						data-options="field:'bpName',title:'商品名称',width:'10%',align:'center'">商品名称</th>
					<th
						data-options="field:'bolCount',title:'数量',width:'5%',align:'center'">数量</th>
					<th
						data-options="field:'bolUnit',title:'单位',width:'5%',align:'center'">单位</th>
					<th
						data-options="field:'bpPrice',title:'单价',width:'5%',align:'center'">单价</th>
					<th
						data-options="field:'bolPrice',title:'金额',width:'10%',align:'center'">金额</th>
				</tr>
			</thead>
		</table>
	</div>

	<s:iterator var="v" value="result">
		<input hidden id="boID" value="<s:property value="#v.boId" />">
	</s:iterator>
	<%@include file="/common/foot.jsp"%>
	<script
		src="${pageContext.request.contextPath}/ViewModel/basd/listOrdersDetail.js"></script>
	<script type="text/javascript">
		var vm = new ViewModel();
		ko.applyBindings(vm);
	</script>
</body>
</html>