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

<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 新建联系人</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<a href="linkman.jsp"><button class="common_button">返回</button></a>
	<a href="linkman.jsp"><button class="common_button">保存</button></a>
</div>
<table class="query_form_table">
	<tr>
		<th>姓名</th>
		<td><input /><span class="red_star">*</span></td>
		<th>性别</th>
		<td>
			<input type="radio" name="gander" checked />男
			<input type="radio" name="gander" />女
		</td>
	</tr>
	<tr>
		<th>职位</th>
		<td><input /><span class="red_star">*</span></td>
		<th>办公电话</th>
		<td><input /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>手机</th>
		<td><input name="T1" size="20" /></td>
		<th>备注</th>
		<td><input name="T2" size="20" /></td>
	</tr>
</table>
</body>
</html>