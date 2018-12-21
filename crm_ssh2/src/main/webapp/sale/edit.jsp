<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<%@include file="/common/head.jsp" %>
</head>
<style type="text/css">
#readonly {
 border-left: 0;
 border-right: 0;
 border-top: 0;
 border-bottom: 1px solid #000000;
}
</style>
<body>
<s:push value="result">
		<s:form namespace="/sale" action="saleChanceAction_edit" method="post">
			<div class="page_title">销售机会管理&nbsp; &gt; 编辑销售机会</div>
			<a href="${pageContext.request.contextPath }/sale/list.jsp"><button>返回</button></a>
			<table class="query_form_table">
				<tr>
					<th>编号</th>
					<td><input id="readonly" name="scId" value="<s:property value='scId'/>" readonly="readonly"></td>
					<th>机会来源</th>
					<td><input name="scSource" value="<s:property value='scSource'/>"></td>
				</tr>
				<tr>
					<th>客户名称</th>
					<td><input name="scCustName" value="<s:property value='scCustName'/>"></td>
					<th>成功机率（%）</th>
					<td>&nbsp;<input name="scRate" value="<s:property value='scRate'/>"></td>
				</tr>	
				<tr>
					<th>概要</th>
					<td colspan="3"><input size="137" name="scTitle" value="<s:property value='scTitle'/>"></td>
				</tr>
				<tr>
					<th>联系人</th>
					<td><input name="scLinkman" value="<s:property value='scLinkman'/>"></td>
					<th>联系人电话</th>
					<td><input name="scTel" value="<s:property value='scTel'/>"></td>
				</tr>
				<tr>
					<th>机会描述</th>
					<td colspan="3"><input name="scDesc" value="<s:property value='scDesc'/>"></td>
				</tr>
				<tr>
					<th>创建人</th>
					<td><input id="readonly"  name="scCreateBy" value="<s:property value='scCreateBy'/>" readonly="readonly"></td>
					<th>创建时间</th>
					<td><input id="readonly" name="scCreateDate" value="<s:property value='scCreateDate'/>" readonly="readonly"></td>
				</tr>
			</table>
			<br />
			<!-- 隐藏域 -->
			<input type="hidden" name="scCreateId" value="<s:property value='scCreateId'/>" readonly="readonly">
			<input type="hidden" name="scStatus" value="<s:property value='scStatus'/>" readonly="readonly">
			<input type="hidden" name="scDueId" value="-1" readonly="readonly">
			<s:submit value="保存" ></s:submit>
		</s:form>
	</s:push>
</body>
</html>