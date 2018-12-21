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
<script type="text/javascript">
	function allch(code){
		var temp = document.getElementById(code);
		var rs = document.getElementsByName("sysRight");
		if(temp.checked){
			for(var i=0;i<rs.length;i++){
				if(rs[i].id.substring(0,3)==code){	
					rs[i].checked=true;
				}
			}			
		}else{
			for(var i=0;i<rs.length;i++){
				if(rs[i].id.substring(0,3)==code){
					rs[i].checked=false;
				}
			}
		}		
	}
	function selSup(code){
		var temps = document.getElementById(code);
		if(temps.checked){
			var sup = document.getElementById(code.substring(0,3));
			sup.checked=true;
		}else{
			var rs = roleForm["sysRight"];
			var currRightId =code.substring(0,3);
			var flag = true;
			for(var i=0;i<rs.length;i++){
				if(rs[i].id!=currRightId &&rs[i].id.substring(0,3)==currRightId){
					if(rs[i].checked==true){
						flag=false;//其中有子节点被选中
					}
				}
			} 
			if(flag){
				document.getElementById(currRightId).checked=false;
			}
		}
	}
</script>
</head>

	<body>
    <div class="page_title">
			权限管理 > 用户管理 > 系统角色管理 > 权限分配
	</div>
	<form action="/role" method="post">
		<input type="hidden" name="o" value="doAssignRights" />
			<table class="query_form_table">
				<tr>
					<th>角色名</th>
					<td>${sessionScope.roleForm.sysRole.roleName }</td>
					<th>角色描述</th>
					<td>${sessionScope.roleForm.sysRole.roleDesc }</td>
					<th>状态</th>
					<td>${sessionScope.roleForm.sysRole.roleFlag }</td>
				</tr>
				<tr>
					<th>权限</th>
					<td colspan="5" align="center">
						<input type="reset" style="common_button" value="取消">
						<input type="reset" style="common_button" value="保存">
					</td>
				</tr>
			</table>
			<br/>
			<%-- <table class="query_form_table">
				
					<tr><td>
					<logic:iterate id="right" name="all_right_list" type="com.crm.entity.SysRight">
					<%
						for(int i=0;i<right.getRightCode().length();++i){
							out.print("&nbsp;&nbsp;&nbsp;");
						}
						if(right.getRightType().equals("Folder")){
					 %>
						 <hr>
						 <div style="background-color:#CCCCCC;">
						  &nbsp;&nbsp;&nbsp;${right.rightText }
					 <input type="checkbox" name="sysRight" ${right.isSelected } value="${right.rightCode}" onclick="allch('${right.rightCode }')" id="${right.rightCode }">
					</div><br>
					 <%
					 } else if(right.getRightType().equals("Document")){
					 %>
					
					  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${right.rightText }
					 <input type="checkbox" name="sysRight" ${right.isSelected } value="${right.rightCode}" onclick="selSup('${right.rightCode }')" id="${right.rightCode }">
					 <%
					 }					 
					 %>	
					 </logic:iterate>
					 </td>	
					 </tr>			
				
			</table> --%>
	</form>
  </body>
</html>