<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	th{
		font-size:12px;
		text-align:right;
		font-weight:normal;
	}
	td{
		font-size:12px;
		text-align:left;
	}
	input{
		width:100px;
		font-size:12px;
		border:solid 1px lightblue;
	}
</style>
<title>Insert title here</title>
</head>
<body bgcolor=#ffffff leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 style="text-align:center;padding-top:20px;">
<table width=800 border=0 cellpadding=0 cellspacing=0>
  <tr>
		<td colspan=7>
			<img src="${pageContext.request.contextPath }/images/login/login_01.jpg" width=800 height=71 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=71 alt=""></td>
	</tr>
	<tr>
		<td colspan=7>&nbsp;
		
		</td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=66 alt=""></td>
	</tr>
	<tr>
		<td colspan=7>
			<img src="${pageContext.request.contextPath }/images/login/login_03.jpg" width=800 height=6 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=6 alt=""></td>
	</tr>
	<tr>
		
    <td colspan=3>&nbsp; </td>
		<td colspan=3 rowspan=2>
			<img src="${pageContext.request.contextPath }/images/login/login_05.jpg" width=426 height=83 alt=""></td>
		
    <td rowspan=3>&nbsp;</td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=44 alt=""></td>
	</tr>
	<tr>
		
    <td rowspan=4>&nbsp; </td>
		<td colspan=2>
			<img src="${pageContext.request.contextPath }/images/login/login_08.jpg" width=94 height=39 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=39 alt=""></td>
	</tr>
	<tr>
		<td rowspan=3>
			<img src="${pageContext.request.contextPath }/images/login/login_09.jpg" width=15 height=141 alt=""></td>
		
    <td colspan=2 rowspan=2 background="${pageContext.request.contextPath }/images/login/login_10.jpg" >
    <script type="text/javascript">
    	function aa(){
    		var f = document.getElementById('aform');
    		f.submit();
    	}
    </script>
    <form id="aform" action="${pageContext.request.contextPath }/right/rightUserAction_login.action" method="post">
	  <table width="100%">
        <tr> 
          <th>用户名</th>
          <td><input size="10" maxlength="20" name="ruName"/></td>
        </tr>
        <tr> 
          <th>密码</th>
          <td><input type="password" size="10" maxlength="20" name="ruPassword"/></td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td><img onclick="aa()" src="${pageContext.request.contextPath }/images/login/login_button.jpg" width="73" height="25">
          </td>
        </tr>
      </table>
	</form>
	
    </td>
		<td colspan=2>
			<img src="${pageContext.request.contextPath }/images/login/login_11.jpg" width=304 height=86 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=86 alt=""></td>
	</tr>
	<tr>
		<td rowspan=2>
			<img src="${pageContext.request.contextPath }/images/login/login_12.jpg" width=19 height=55 alt=""></td>
		
    <td colspan=2 rowspan=3>&nbsp; </td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=28 alt=""></td>
	</tr>
	<tr>
		<td colspan=2>
			<img src="${pageContext.request.contextPath }/images/login/login_14.jpg" width=201 height=27 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=27 alt=""></td>
	</tr>
	<tr>
		
    <td colspan=5>&nbsp; </td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=67 alt=""></td>
	</tr>
	<tr>
		
    <td colspan=7 background="${pageContext.request.contextPath }/images/login/login_16.jpg" style="text-align:right;padding-right:25px;"> 
			&copy; 2018 长沙卓景京信息36计技术有限公司
    </td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=1 height=55 alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=150 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=15 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=79 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=122 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=19 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=285 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login/spacer.gif" width=130 height=1 alt=""></td>
		<td></td>
	</tr>
</table>
</body>
</html>