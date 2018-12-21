<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div class="page_title">权限管理 > 用户管理 > 指派用户角色</div>
    <form action="/right" method="post">
			<input type="hidden" name="o" value="dispatchSysRole"/>
    	<div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
			<button class="common_button" onclick="add();">保存</button>
	   	</div>
	   	<table class="query_form_table">
	   		<tr>
	   			<th>编号</th>
	   			<td>
					<input type="text" name="sysUser.usrId" readonly="readonly" size="20" value="${user.usrId}"/>   			
	   			</td>
	   			<th>用户名</th>
	   			<td>
	   				<input type="text" name="sysUser.usrName" readonly="readonly" size="20" value="${user.usrName}"/>   			
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>
	   				角色
	   			</th>
	   			<td>
	   				<select name="roleId">
	   					<option value="0">未指派</option>
	   					<option value="">少一个遍历</option>
<!-- 	   					<html:optionsCollection name="roles" label="roleName" value="roleId"/> -->
	   				</select>
	   			</td>
	   			<th>
	   				状态
	   			</th>
	   			<td>
	   				<c:if test="${user.usrFlag==1}">
	   					正常
	   				</c:if>
	   				<c:if test="${user.usrFlag==2}">
	   					禁用
	   				</c:if>
	   			</td>
	   		</tr>
	   	</table>
    </form>
  </body>
</html>