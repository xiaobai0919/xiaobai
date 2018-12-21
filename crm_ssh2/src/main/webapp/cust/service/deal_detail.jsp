<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<body>
	<div class="page_title">客户服务管理 &gt; 服务处理</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="doEdit(${cs.csId})">保存</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td>${cs.csId }</td>
			<th>服务类型</th>
			<td>${cs.csType }</td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3">${cs.csTitle }</td>
		</tr>	
		<tr>
			<th>客户</th>
			<td>${cs.csCustName }</td>
			<th>状态</th>
			<td>${cs.csStatus }</td>
		</tr>	
		<tr>
			<th>服务请求</th>
			<td colspan="3">${cs.csRequest }<br>
	　</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${cs.csCreateBy }</td>
			<th>创建时间</th>
			<td>${cs.csCreateDate }</td>
		</tr>
		</table>
	<br />
	<table class="query_form_table" id="table3">
		<tr>
			<th>分配给</th>
			<td>${cs.csDueTo }</td>
			<th>分配时间</th>
			<td>${cs.csDueDate }</td>
		</tr>
	</table>
	<br />	
	<table class="query_form_table" id="table1">
		<tr>
			<th>服务处理</th>
			<td colspan="3"><textarea id="csDealBy" rows="6" cols="50"></textarea><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>处理人</th>
			<td>${login.ruName }<span class="red_star">*</span></td>
			<th>处理时间</th>
			<td><label><%=new SimpleDateFormat("yyyy/MM/dd").format(new Date()) %></label><span class="red_star">*</span></td>
		</tr>
	</table>
<script>
function doEdit(csId){
	$.ajax({
		type : 'post',
		data : {
			csId : csId,
			csDealBy : $("#csDealBy").val()
		},
		url : contextPath+"/cust/custServiceAction_edit.action",
		dataType : 'json',
		success : function(str){
			//弹出提示框
			$.messager.alert('消息',str.message,'info',function(){
				location.href = contextPath+"/cust/service/deal.jsp";
			});
		}
	});	
}
</script>
</body>
</html>