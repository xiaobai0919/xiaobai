<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>添加权限</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/rightcom/head.jsp" %>
</head>
<body>
	<div class="page_title">权限管理 > 权限管理 > 添加权限</div>
	<form action="/sysRight" method="post">
		<input type="hidden" name="o" value="addSysRight"/>
		<div class="button_bar">
			<button class="common_button" onclick="help('');">帮助</button>
			<button class="common_button" onclick="back();">返回</button>
			<button class="common_button" onclick="add();">保存</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input type="text" name="sysRight.rightCode" />
				</td>
				<th>权限类型</th>
				<td>
					<select name="sysRight.rightType">
						<option value="Folder">根结点</option>
						<option value="Folder">父节点</option>
						<option value="Document">子节点</option>
					</select>
					</td>
				<th>父节点</th>
				<td>
					<select name="sysRight.rightParentCode">
						<option value="">--请选择父节点--</option>
						<option value="节点值遍历">父节点</option>
					</select>
					</td>
			</tr>
			<tr>
				<th>权限文本</th>
				<td><input type="text" name="sysRight.rightText" />
				</td>
				<th>权限URL</th>
				<td><input type="text" name="sysRight.rightUrl" />
				</td>
				<th>权限描述</th>
				<td><textarea name="sysRight.rightTip"></textarea>
				</td>
			</tr>
		</table>
		<script>
			build_validate("sysRight.rightCode", "编号不能为空", "Limit", "1", "50");
			build_validate("sysRight.rightParentCode", "父节点不能为空", "Limit", "1",
					"50");
			build_validate("sysRight.rightText", "权限文本不能为空", "Limit", "1", "50");
		</script>
	</form>
</body>
</html>