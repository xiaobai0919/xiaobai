<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
<%@include file="/common/head.jsp" %>
</head>
<body>
	<div class="page_title">客户服务管理 > 服务创建</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="doAdd(${maxCsId })">保存</button>  
	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td><label>${maxCsId }</label></td>
			<th>服务类型</th>
			<td>
				<select id="csType">
					<option value="-1">--请选择--</option>
					<c:forEach items="${basdDictList }" var="bd">
						<option value="${bd.bdItem }">${bd.bdItem }</option>
					</c:forEach>
				</select><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3"><input id="csTitle" size="53" /><span class="red_star">*</span></td>
		</tr>	
		<tr>
			<th>客户</th>
			<td><input id="csCustName" name="T20" size="20" /><span class="red_star">*</span></td>
			<th>状态</th>
			<td>新创建</td>
		</tr>	
		<tr>
			<th>服务请求</th>
			<td colspan="3"><textarea id="csRequest" rows="6" cols="50"></textarea><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${login.ruName }<span class="red_star">*</span></td>
			<th>创建时间</th>
			<td><label><%=new SimpleDateFormat("yyyy/MM/dd").format(new Date()) %></label><span class="red_star">*</span></td>
		</tr>
	</table>
<script>
function doAdd(csId){
	$.ajax({
		type : 'post',
		data : {
			csId : csId,
			csType : $("#csType").val(),
			csTitle : $("#csTitle").val(),
			csCustName : $("#csCustName").val(),
			csRequest : $("#csRequest").val()
		},
		url : contextPath+"/cust/custServiceAction_add.action",
		dataType : 'json',
		success : function(str){
			//弹出提示框
			$.messager.alert('消息',str.message,'info',function(){
				location.href = contextPath+"/cust/custServiceAction_toAdd.action";
			});
		}
	});	
}
</script>
</body>
</html>