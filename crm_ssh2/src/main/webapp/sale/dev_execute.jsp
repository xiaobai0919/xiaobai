<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/script/common.js"></script>
<%@include file="/common/head.jsp" %>
</head>

<body>

	<div class="page_title">客户开发计划 &gt; 执行计划</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="toWin(${sc.scId },'4')">终止开发</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="toZD(${sc.scId })">制定计划</button>
		<button class="common_button" onclick="toWin(${sc.scId },'3')">开发成功</button>

	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td>${sc.scId }</td>
			<th>机会来源</th>
			<td>${sc.scSource }</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td>${sc.scCustName }</td>
			<th>成功机率（%）</th>
			<td>${sc.scRate }</td>
		</tr>	
		<tr>
			<th>概要</th>
			<td colspan="3">${sc.scTitle }</td>
		</tr>
		<tr>
			<th>联系人</th>
			<td>${sc.scLinkman }</td>
			<th>联系人电话</th>
			<td>${sc.scTel }</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3">${sc.scDesc }</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${sc.scCreateBy }</td>
			<th>创建时间</th>
			<td>${sc.scCreateDate }</td>
		</tr>
		<tr>
			<th>指派给</th>
			<td>${sc.scDueTo }</td>
			<th>指派时间</th>
			<td>${sc.scDueDate }</td>
		</tr>
	</table>
	<br />
	<table class="data_list_table" id="table1">
		<tr>
			<th>日期</th>
			<th>计划</th>
			<th>执行效果</th>
		</tr>
		<c:forEach items="${spList }" var="sp">
			<tr>
				<td class="list_data_text">${sp.spDate }</td>
				<td class="list_data_ltext">${sp.spTodo }</td>
				<td class="list_data_ltext">
					<input id="${sp.spId }" value="${sp.spResult }"/>
					<button class="common_button" onclick="doEdit(${sp.spId},${sc.scId },'${sp.spDate }','${sp.spTodo }')">保存</button>
				</td>
			</tr>
		</c:forEach>
	</table>
<script type="text/javascript">
//修改
function doEdit(spId,scId,spDate,spTodo){
	var spResult = $("#"+spId).val();
	$.ajax({
		type : 'post',
		data : {
			spId : spId,
			spTodo : spTodo,
			spDate : spDate,
			scId : scId,
			spResult : spResult
		},
		url : contextPath+"/sale/salePlanAction_edit.action",
		dataType : 'json',
		success : function(str){
			//弹出提示框
			$.messager.alert('消息',str.message,'info',function(){
				location.href = contextPath+"/sale/saleChanceAction_loadZX.action?scId="+str.scId;
			});
		}
	});
}

function toZD(scId){
	location.href = contextPath+"/sale/saleChanceAction_loadZD.action?scId="+scId;
}

function toWin(scId,str){
	$.ajax({
		type:'post',
		url:contextPath+"/sale/saleChanceAction_editStatus.action?scId="+scId+"&str="+str,
		dataType:'json',
		success : function(str){
			//判断是否删除成功 code等于0证明删除成功，否则相反
			if(str&&str.code==0){
				$.messager.alert('消息',str.message,'info',function(){
					location.href = contextPath+"/sale/dev.jsp";
				});
			}
		}
	});
}
</script>	
</body>
</html>