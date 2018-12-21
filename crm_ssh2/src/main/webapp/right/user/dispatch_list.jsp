<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="page_title">权限管理 > 用户管理 > 分配角色</div>
	<form action="/right.do" method="post">
		<input type="hidden" name="o" value="dispatchList" />
		<div class="button_bar">
			<button class="common_button" onclick="help('');">帮助</button>
			<button class="common_button" onclick="add();">查询</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>用户名</th>
				<td><input type="text" name="sysUser.usrName" size="20">
				</td>
				<th>是否禁用</th>
				<td><select name="sysUser.usrFlag">
						<option value="1"></option>
				</select></td>
			</tr>
		</table>
		<br />
		<table class="data_list_table">
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>角色</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
			<%-- <logic:iterate id="sysUser" name="sysUsers">
				<tr>
					<td class="list_data_text">${sysUser.usrId}</td>
					<td class="list_data_text">${sysUser.usrName}</td>
					<td class="list_data_text">${sysUser.sysRole.roleName}</td>
					<td class="list_data_text"><c:if test="${sysUser.usrFlag==1}">
	   					正常
	   				</c:if> <c:if test="${sysUser.usrFlag==2}">
	   					禁用
	   				</c:if></td>
					<td class="list_data_op"><img
						onclick="to('right.do?o=toDispatch&userId=${sysUser.usrId}');"
						title="指派" src="html/images/bt_linkman.gif" class="op_button" />
					</td>
				</tr>
			</logic:iterate> --%>
			<tr>
				<th colspan="7" class="pager">
					<div class="pager">
						共${sessionScope.roleForm.page.allRecord}条记录 每页 <input type="text"
							name="page.maxRecord" size="2" /> 条
						第${sessionScope.roleForm.page.currPage}页/共${sessionScope.roleForm.page.allPage}页
						<a href="role.do?o=toRoleList&param=firstPage">第一页</a> <a
							href="role.do?o=toRoleList&param=prePage">上一页</a> <a
							href="role.do?o=toRoleList&param=nextPage">下一页</a> <a
							href="role.do?o=toRoleList&param=lastPage">最后一页</a> 转到 <input
							type="text" name="page.currPage" size="2" /> 页
						<button style="width: 20" onclick="add();">GO</button>
					</div>

				</th>
			</tr>
		</table>
	</form>
</body>
</html>