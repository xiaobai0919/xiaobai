<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<a href="activities.jsp"><button class="common_button">返回</button></a>
	<a href="activities.jsp"><button class="common_button" onclick="add('activities.html');">保存</button> </a>
</div>
<table class="query_form_table">
	<tr>
		<th>时间</th>
		<td><input /><span class="red_star">*</span></td>
		<th>地点</th>
		<td>
			<input name="T1" size="20" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>概要</th>
		<td><input /><span class="red_star">*</span></td>
		<th>备注</th>
		<td><input /></td>
	</tr>	
	<tr>
		<th>详细信息</th>
		<td colspan="3">
			<textarea cols="50" rows="6"> </textarea>
		</td>
	</tr>
</table>
</body>
</html>