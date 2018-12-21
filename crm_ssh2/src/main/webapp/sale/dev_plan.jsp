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

	<div class="page_title">客户开发计划 &gt; 制定计划</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="toZX(${sc.scId })">执行计划</button>
		<button class="common_button" onclick="back();">返回</button>
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
			<th width="150px">日期</th>
			<th height="31">计划项</th>
		</tr>
		<c:forEach items="${spList }" var="sp">
			<tr>
				<td class="list_data_text" height="24">${sp.spDate }</td>
				<td class="list_data_ltext" height="24"><input id="${sp.spId}" size="50" value="${sp.spTodo }" />
					<button class="common_button" onclick="doEdit(${sp.spId},${sc.scId },'${sp.spDate }')">保存</button>
					<button class="common_button" onclick="doDel(${sp.spId},${scId})">删除</button>
					<input id="${sp.spId+sc.scId }" type="hidden" value="${sp.spResult }">
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="button_bar">
		
		</div>
	<table class="query_form_table" id="table2">
		<tr>
			<th>日期</th>
			<td><input id="spDate"/><span class="red_star">*</span></td>
			<th>计划项</th>
			<td>
				<input id="spTodo" size="50" name="T2" /><span class="red_star">*</span>
			</td>
			<td><button class="common_button" onclick="doAdd(${sc.scId })">保存</button></td>
		</tr>
	</table>
	
<script type="text/javascript">
//修改
function doEdit(spId,scId,spDate){
	var spTodo = $("#"+spId).val();
	var s = spId+scId;
	var spResult = $("#"+s).val();
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
				location.href = contextPath+"/sale/saleChanceAction_loadZD.action?scId="+str.scId;
			});
		}
	});
}

//删除
function doDel(spId,scId){
	//弹出提示框
	$.messager.confirm('确定','你确定要删除该计划吗？',function(r){
		//如果确定，则进行删除操作
		if(r){
			$.ajax({
				type : 'post',
				url : contextPath+"/sale/salePlanAction_del.action?spId="+spId+"&scId="+scId,
				dataType : 'json',
				success : function(str){
					//弹出提示框
					$.messager.alert('消息',str.message,'info',function(){
						location.href = contextPath+"/sale/saleChanceAction_loadZD.action?scId="+str.scId;
					});
				}
			});
		}
	});
}

//增加
function doAdd(scId){
	var spDate = $("#spDate").val();
	var spTodo = $("#spTodo").val();
	$.ajax({
		type : 'post',
		data : {
			spDate : spDate,
			spTodo : spTodo,
			scId : scId
		},
		url : contextPath+"/sale/salePlanAction_add.action",
		dataType : 'json',
		success : function(str){
			//弹出提示框
			$.messager.alert('消息',str.message,'info',function(){
				location.href = contextPath+"/sale/saleChanceAction_loadZD.action?scId="+scId;
			});
		}
	});
}

function toZX(scId){
	location.href = contextPath+"/sale/saleChanceAction_loadZX.action?scId="+scId;
}

</script>
</body>
</html>