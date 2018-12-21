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

<div class="page_title">客户流失管理 &gt; 确认流失</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	
	<a href="list.jsp"><button class="common_button" onclick="back();">返回</button></a>
	<a href="confirm.jsp"><button class="common_button">确认流失</button></a>
	<a href="list.jsp"><button class="common_button" >保存</button></a>
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>1</td>
		<th>客户</th>
		<td>阳光实业</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>
			球球</td>
		<th>上次下单时间</th>
		<td>
			2005年12月07日</td>
	</tr>	
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">
			打电话给客户了解不再购买本公司产品的原因。<br>
			发送新产品目录给客户。</td>
	</tr>
	<tr>
		<th>追加暂缓措施</th>
		<td colspan="3">
			<textarea rows="6" cols="50"></textarea><span class="red_star">*</span></td>
	</tr>
</table>
<br />
</body>
</html>