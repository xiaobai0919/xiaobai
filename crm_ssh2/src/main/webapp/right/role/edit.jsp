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
	<div class="page_title">权限管理 > 用户管理 > 系统角色管理 > 编辑角色</div>
	<form action="/role" method="post">
		<input type="hidden" name="o" value="editRole" />
		<div class="button_bar">
			<button class="common_button" onclick="help('');">帮助</button>
			<button class="common_button" onclick="back();">返回</button>
			<button class="common_button" onclick="add();">保存</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input type="text" name="sysRole.roleId" size="20"
					value="${46546}" readonly="readonly" /></td>
				<th>角色名</th>
				<td><input type="text" name="sysRole.roleName" size="20"
					value="${ls}" /></td>
			</tr>
			<tr>
				<th>角色描述</th>
				<td><textarea name="sysRole.roleDesc" rows="3" cols="22">${sasdc}</textarea>
				</td>
				<th>状态</th>
				<td><select name="sysRole.roleFlag">
						<option value="1">正常</option>
						<option value="2">禁用</option>
				</select></td>
			</tr>
		</table>
		<script>
			build_validate("sysRole.roleName", "角色名不能为空", "Limit", "1", "50");
			build_validate("sysRole.roleDesc", "角色描述不能为空", "Limit", "1", "50");
		</script>
	</form>
</body>
</html>