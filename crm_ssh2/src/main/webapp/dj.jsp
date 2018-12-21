<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/head.jsp"  %>
<title>Insert title here</title>
</head>
<script type="text/javascript">
function dj(n){
	if(n==1){
		alert("这才是乖孩子嘛！");
		alert("挺有眼光的！");
		alert("要多加表扬！");
		alert("给你小心心！");
		location.href = "a.jsp";
	}else{
		alert("what？");
		alert("我们的小宝贝洁洁不可爱吗？");
		alert("这么说假话你的良心不会痛吗？");
		alert("你再这么说小可爱洁洁可就会生气了哦？");
		alert("我们的小可爱生气可是会很严重的哦，");
		alert("请夸小可爱洁洁，");
		alert("so");
		alert("再给你一次重新选择的机会。");
	}
}
</script>
<body>
	<div id="dj">
		<span id="sa" style="color: red;column-rule-color: orange;">小宝贝洁洁可爱吗？</span><br/>
		<input type="button" value="可爱" onclick="dj(1)"/>
		<input type="button" value="不可爱" onclick="dj(2)"/>
	</div>
</body>
</html>