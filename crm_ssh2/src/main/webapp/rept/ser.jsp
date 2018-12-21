<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/head.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>用户管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/rightcom/head.jsp"%>
</head>
<body>

<div class="page_title">客户服务分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reload();">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>年份</th>
		<td>
			<select>
				<option>全部</option>
				<option>2005</option>
				<option>2006</option>
				<option>2007</option>
				<option>2008</option>
				<option>2009</option>
				<option>2010</option>
			</select>
		</td>
		<th>&nbsp;</th>
		<td>
			&nbsp;
		</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>条目</th>
		<th>服务数量</th>
	</tr>
	<tr>
		<td class="list_data_number">1</td>
		<td class="list_data_text">建议</td>
		<td class="list_data_number">12</td>
	</tr>
	<tr>
		<td class="list_data_number">2</td>
		<td class="list_data_text">咨询</td>
		<td class="list_data_number">26</td> 
	</tr>
	<tr>
		<td class="list_data_number">3</td>
		<td class="list_data_text">投诉</td>
		<td class="list_data_number">38</td> 
	</tr>
	</table>
</body>
</html>