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

<div class="page_title">数据字典管理 > 编辑数据字典条目</div>
<div class="button_bar">
	<button class="common_button" onclick="return alert('欢迎使用')">帮助</button>
	<a href="dict.jsp"><button class="common_button" >返回</button></a>
	<button class="common_button" onclick="doEdit()">保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><span id="bdId">${bd.bdId }</span></td>
		<th>类别</th>
		<td><input id="bdType" value="${bd.bdType }" />
	</tr>
	<tr>
		<th>条目</th>
		<td><input id="bdItem" value="${bd.bdItem }" /><span class="red_star">*</span></td>
		<th>值</th>
		<td><input id="bdValue" value="${bd.bdValue }" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>是否可编辑</th>
		<td>
			<select id="bdIsEditable">
				<option value="1">是</option>
				<option value="0">否</option>
			</select> 
		</td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
<script type="text/javascript">
function doEdit(){
	$.ajax({
		type : 'post',
		data : {
			bdId : $("#bdId").html(),
			bdType : $("#bdType").val(),
			bdItem : $("#bdItem").val(),
			bdValue : $("#bdValue").val(),
			bdIsEditable : $("#bdIsEditable").val()
		},
		url : contextPath+"/basd/basdDictAction_edit.action",
		dataType : 'json',
		success : function(str){
			//弹出提示框
			$.messager.alert('消息',str.message,'info',function(){
				location.href = contextPath+"/basd/dict.jsp";
			});
		}
	});	
}
</script>
</body>
</html>