<%@page import="com.crm.ssh2.right.dao.IRightUserDao"%>
<%@page import="com.crm.ssh2.right.biz.IRightUserBiz"%>
<%@page import="com.crm.ssh2.right.dao.IRightDao"%>
<%@page import="com.crm.ssh2.right.biz.IRightBiz"%>
<%@page import="com.crm.ssh2.right.entity.RightUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/head.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/adminIndex.js"></script>
<title>客户关系管理系统</title>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'客户关系管理系统',split:true" style="height:130px;">
    	<%@include file="/common/top.jsp" %>
    </div>   
    <div data-options="region:'south',split:true" style="height:20px;"></div>   
    <div data-options="region:'west',title:'功能',split:true" style="width:15%;">
    	<ul id="gn">
    	</ul>
	</div>   
    <div data-options="region:'center'" style="background:#eee;">
		<div id="tab">
		</div>
    </div>   
    
</body>

</html>