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
<script src="<%=path%>/script/validate.js"></script>
</head>

	<body>
		<div class="page_title">
			权限管理 > 权限管理 > 添加权限
		</div>
		<form action="/sysRight" method="post">
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="back();">
					返回
				</button>
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						编号
					</th>
					<td>
						1
					</td>
					<th>
						权限类型
					</th>
					<td>
						根节点
					</td>
					<th>
						父节点
					</th>
					<td>
						12
					</td>
				</tr>
				<tr>
					<th>
						权限文本
					</th>
					<td>
						123
					</td>
					<th>
						权限URL
					</th>
					<td>
						2343
					</td>
					<th>权限描述</th>
					<td>
						23432
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>