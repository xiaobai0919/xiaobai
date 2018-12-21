<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true"
		style="height: 50px; padding: 5px">
		名称：<input class="tttip"
			data-bind="value:queryForm.ccName,validationElement:queryForm.ccName"
			type="text"> <a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" data-bind="click:doQuery"
			style="margin-left: 10px">搜索</a> <a href="#"
			class="easyui-linkbutton" data-options="" data-bind="click:doClear"
			style="margin-left: 10px">清空</a>
	</div>

	<div id="tb">
		<a id="editBtn" href="#" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:doEdit"
			data-options="iconCls:'icon-edit',plain:true">编辑</a> <a id="delBtn"
			href="#" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:dodel"
			data-options="iconCls:'icon-remove',plain:true">删除</a> <a
			id="editBtn" href="#" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:doLinkman"
			data-options="iconCls:'icon-man',plain:true">联系人</a> <a id="editBtn"
			href="activities.jsp" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:doActivities"
			data-options="iconCls:'icon-reload',plain:true">交往记录</a> <a
			id="editBtn" href="orders.jsp" class="easyui-linkbutton"
			data-bind="LinkButton:enableButton,click:doOrders"
			data-options="iconCls:'icon-tip',plain:true">历史订单</a>
	</div>

	<div data-options="region:'center'">
		<table id="dg" data-bind="datagrid:options">
			<thead>
				<tr>
					<th
						data-options="field:'ccNo',title:'客户编号',width:'20%',align:'center'">客户编号</th>
					<th
						data-options="field:'ccName',title:'名称',width:'20%',align:'center'">名称</th>
					<th
						data-options="field:'ccRegion',title:'地区',width:'20%',align:'center'">地区</th>
					<th
						data-options="field:'ccManageName',title:'客户经理',width:'20%',align:'center'">客户经理</th>
					<th
						data-options="field:'ccLevelLabel',title:'客户等级',width:'18%',align:'center'">客户等级</th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="bb">
		<a href="#" class="easyui-linkbutton" data-bind="click:doSubmit">保存</a>
		<a href="#" class="easyui-linkbutton" data-bind="click:doClose">关闭</a>
	</div>

	<div id="dd" class="easyui-dialog from" title="信息编辑"
		style="width: 1000px; height: 440px;"
		data-options="iconCls:'icon-save',modal:true,closable:true,closed:true,buttons:'#bb'">
		<form action="" id="dform">
			<table class="query_form_table">
				<tr>
					<th>客户编号</th>
					<td><input data-bind="value:form.ccNo" /></td>
					<th>名称</th>
					<td><input data-bind="value:form.ccName" /><span
						class="red_star">*</span></td>
				</tr>
				<tr>
					<th>地区</th>
					<td><select id="ccRegion" data-bind="value:form.ccRegion">
					</select></td>
					<th>客户经理</th>
					<td><select id="ccManageName" data-bind="value:form.ccManageName"></select></td>
				</tr>
				<tr>
					<th>客户等级</th>
					<td><select id="ccLevelLabel"
						data-bind="value:form.ccLevelLabel">
					</select></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>客户满意度</th>
					<td><select id="ccSatisfy" data-bind="value:form.ccSatisfy"></select></td>
					<th>客户信用度</th>
					<td><select id="ccCredit" data-bind="value:form.ccCredit"></select></td>
				</tr>
				<tr>
					<th>地址</th>
					<td><input data-bind="value:form.ccAddress" /><span
						class="red_star">*</span></td>
					<th>邮政编码</th>
					<td><input data-bind="value:form.ccZip" size="20" /><span
						class="red_star">*</span></td>
				</tr>
				<tr>
					<th>电话</th>
					<td><input data-bind="value:form.ccTel" size="20" /><span
						class="red_star">*</span></td>
					<th>传真</th>
					<td><input data-bind="value:form.ccFax" size="20" /><span
						class="red_star">*</span></td>
				</tr>
				<tr>
					<th>网址</th>
					<td><input data-bind="value:form.ccWebsite" size="20" /><span
						class="red_star">*</span></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>营业执照注册号</th>
					<td><input data-bind="value:form.ccLicenceNo" size="20" /></td>
					<th>法人</th>
					<td><input data-bind="value:form.ccChieftain" size="20" /><span
						class="red_star">*</span></td>
				</tr>
				<tr>
					<th>注册资金（万元）</th>
					<td><input data-bind="value:form.ccBankroll" size="20" /></td>
					<th>年营业额</th>
					<td><input data-bind="value:form.ccTurnover" size="20" /></td>
				</tr>
				<tr>
					<th>开户银行</th>
					<td><input data-bind="value:form.ccBank" size="20" /><span
						class="red_star">*</span></td>
					<th>银行帐号</th>
					<td><input data-bind="value:form.ccBankAccount" size="20" /><span
						class="red_star">*</span></td>
				</tr>
				<tr>
					<th>地税登记号</th>
					<td><input data-bind="value:form.ccLocalTaxNo" size="20" /></td>
					<th>国税登记号</th>
					<td><input data-bind="value:form.ccNationalTaxNo" size="20" /></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- 联系人 -->

	<%@include file="/common/foot.jsp"%>
	<script
		src="${pageContext.request.contextPath}/ViewModel/cust/listCustCustomer.js"></script>
	<script type="text/javascript">
		var vm = new ViewModel();
		ko.applyBindings(vm);
	</script>
</body>
</html>