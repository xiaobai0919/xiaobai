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
		权限管理 > 角色管理 > 分配权限 
	</div>
		<form action="role.do" method="post">
			<input type="hidden" name="o" value="toDispatchRightList"/>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="back();">
					返回
				</button>
				<button class="common_button" onclick="add();">
					查询
				</button>
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						角色名
					</th>
					<td>
						<input type="text" name="sysRole.roleName" size="20" />
					</td>
					<th>角色描述</th>
					<td>
						<input type="text" name="sysRole.roleDesc" size="20" />
					</td>
					<th>
						是否禁用
					</th>
					<td>
						<select name="sysRole.roleFlag">
						<option value="0">全部</option>
						<option value="1">正常</option>
						<option value="2">禁用</option>
						</select>
					</td>
				</tr>
			</table>
			<br />
			<table class="data_list_table">
				<tr>
					<th>
						编号
					</th>
					<th>
						角色名
					</th>
					<th>
						角色描述
					</th>
					<th>
						状态
					</th>
					<th>
						操作
					</th>
				</tr>
				<%-- <logic:iterate id="role" name="roles">
					<tr>
						<td class="list_data_text">
							${role.roleId}
						</td>
						<td class="list_data_text">
							${role.roleName}
						</td>
						<td>
							${role.roleDesc }
						</td>
						<td class="list_data_text">
							<c:if test="${role.roleFlag==1}">
	   					正常
	   				</c:if>
							<c:if test="${role.roleFlag==2}">
	   					禁用
	   				</c:if>
						</td>
						<td class="list_data_op">
							<button onclick="to('role.do?o=toDispatchRight&roleId=${role.roleId }')">分配权限</button>
						</td>
					</tr>
				</logic:iterate> --%>
				<tr>
					<th colspan="7" class="pager">
						<div class="pager">
							共${sessionScope.roleForm.page.allRecord}条记录 每页
							<input type="text" name="page.maxRecord" size="2"/>
							条
							第${sessionScope.roleForm.page.currPage}页/共${sessionScope.roleForm.page.allPage}页
							<a href="role.do?o=toRoleList&param=firstPage">第一页</a>
							<a href="role.do?o=toRoleList&param=prePage">上一页</a>
							<a href="role.do?o=toRoleList&param=nextPage">下一页</a>
							<a href="role.do?o=toRoleList&param=lastPage">最后一页</a> 转到
							<input type="text" name="page.currPage" size="2"/>
							页
							<button style="width: 20" onclick="add();">
								GO
							</button>
						</div>
					</th>
				</tr>
			</table>
	</form>
  </body>
</html>