<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
<%@include file="/common/head.jsp" %>
</head>
<body class="easyui-layout">
	<div class="page_title">客户服务管理 > 服务分配</div>
	<div data-options="region:'north',split:true" style="height: 90px; padding: 5px;">
		<div class="page_title">服务分配</div>
		客户：<input data-bind="value:form.csCustName,validationElement:form.csCustName" class="ttip" /> 
		概要：<input data-bind="value:form.csTitle,validationElement:form.csTitle" class="ttip" /> 
		服务类型：<select id="csType">
			<option value="-1">--请选择--</option>
			<c:forEach items="${basdDictList }" var="bd">
				<option value="${bd.bdItem }">${bd.bdItem }</option>
			</c:forEach>
		</select> 
		<a class="easyui-linkbutton"data-bind="click:doQuery" data-options="iconCls:'icon-search'"style="margin-left: 10px;">查询</a><br/> 
		创建日期：<input data-bind="value:form.csCreateDate,validationElement:form.csCreateDate" class="ttip" /> -
		<input data-bind="value:form.csDealDate,validationElement:form.csDealDate" class="ttip" /> 
		<a class="easyui-linkbutton"data-bind="click:doClear" data-options="" style="margin-left: 10px;">清空</a>
	</div>
	<div id="tb">
		分配给：<select id="csDueId">
					<option value="-1">--请选择--</option>
					<c:forEach items="${rightUserList }" var="ru">
						<option value="${ru.ruId }">${ru.ruName }</option>
					</c:forEach>
				</select> 
		<a id="fpBtn" href="#" class="" data-bind="LinkButton:enableButton,click:doFP" data-options="iconCls:'icon-edit',plain:true">分配</a>
		<a id="delBtn" href="#" class="" data-bind="LinkButton:enableButton,click:doDel" data-options="iconCls:'icon-remove',plain:true">删除</a>
	</div>
	<div data-options="region:'center'">
		<table id="tab" data-bind="datagrid:listOptions" class="data_list_table">
			<thead>
				<tr>
					<!-- 必须要用th，否则显示不出数据 -->
					<th data-options="field:'csId',title:'编号',width:'10%',align:'center'">编号</th>
					<th data-options="field:'csCustName',title:'客户',width:'20%',align:'center'">客户</th>
					<th data-options="field:'csTitle',title:'概要',width:'25%',align:'center'">概要</th>
					<th data-options="field:'csType',title:'服务类型',width:'10%',align:'center'">服务类型</th>
					<th data-options="field:'csCreateBy',title:'创建人',width:'15%',align:'center'">创建人</th>
					<th data-options="field:'csCreateDate',title:'创建时间',width:'17%',align:'center'">创建时间</th>
				</tr>
			</thead>
		</table>
	</div>
	<%@include file="/common/foot.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ViewModel/cust/service/dispatch.js"></script>
	<script type="text/javascript">
		var vm = new ViewModelDispatch();
		ko.applyBindings(vm);	
	</script>
	
</body>
</html>