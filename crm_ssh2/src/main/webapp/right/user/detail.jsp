<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html >
<html>
<head>
<head>
 <base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/script/common.js"></script>
<script src="<%=path %>/script/validate.js"></script>
</head>
<title>Insert title here</title>
</head>
<body>
	<div class="page_title">权限管理 > 用户管理 > 查看用户</div>
    <form action="/right" method="post">
			<input type="hidden" name="o" value="toDetail"/>
    	<div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
	   	</div>
	   	<table class="query_form_table">
	   		<tr>
	   			<th>编号</th>
	   			<td>asdg</td>
	   			<th>用户名</th>
	   			<td>213 </td>
	   		</tr>
	   		<tr>
	   			<th>角色</th>
	   			<td>
	   					未指派
	   			</td>
	   			<th>
	   				状态
	   			</th>
	   			<td>
	   					禁用
	   			</td>
	   		</tr>
	   	</table>
    </form>
</body>
</html>