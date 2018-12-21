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
			<td colspan="3">${cs.csDealBy }<span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>处理人</th>
			<td>${cs.csDeal }<span class="red_star">*</span></td>
			<th>处理时间</th>
			<td><label>${cs.csDealDate }</label><span class="red_star">*</span></td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table2">
		<tr>
			<th>处理结果</th>
			<td><input id="csResult" name="T10" size="20" /><span class="red_star">*</span></td>
			<th>满意度</th>
			<td>
				<select id="csSatisfy">
					<option value="-1">--请选择--</option>
					<c:forEach items="${myd }" var="m">
						<option value="${m.bdValue }">${m.bdItem }</option>
					</c:forEach>
				</select><span class="red_star">*</span></td>
		</tr>
	</table>
<script>
function doEdit(csId){
	$.ajax({
		type : 'post',
		data : {
			csId : csId,
			csResult : $("#csResult").val(),
			csSatisfy : $("#csSatisfy").val(),
		},
		url : contextPath+"/cust/custServiceAction_editMyd.action",
		dataType : 'json',
		success : function(str){
			//弹出提示框
			$.messager.alert('消息',str.message,'info',function(){
				location.href = contextPath+"/cust/service/feedback.jsp";
			});
		}
	});	
}
</script>
</body>
</html>