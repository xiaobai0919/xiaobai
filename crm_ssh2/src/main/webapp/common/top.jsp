<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/common/contextPath.jsp"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户关系管理系统</title>
</head>
<body style="border-bottom: solid 1px #666;">
	<table style="width: 100%;">
		<tr>
			<td><img src="${pageContext.request.contextPath }/images/logo.gif"></td>
			<td style="font-family: 黑体; font-size: 33px; font-weight: bold;">客户关系管理系统</td>
			<td width="25%" align="right" style="font-size: 12px;" valign="bottom">当前用户：${login.ruName }（${login.ruRoleName }）&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/login.jsp">退出系统</a></td>
		</tr>
	</table>
</body>
</html>