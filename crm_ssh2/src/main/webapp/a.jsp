<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int n = 10;
	int i, j;
	for (i = 1 - (n >> 1); i <= n; i++)
    if (i > 0) {
        for (j = 0; j < i; j++)
        	%><%="&nbsp;&nbsp;&nbsp;&nbsp;"
            
        	%><%
        for (j = 1; j <= 2 * (n - i) + 1; j++)
            if (j == 1 || j == 2 * (n - i) + 1)
            	%><%="&nbsp;&nbsp;*"
            	%><%
            else
            	%><%="&nbsp;&nbsp;&nbsp;&nbsp;"
            	%><%="<br/>"
            	%><%
    } else if (i == 0) {
    	%><%="&nbsp;&nbsp;*"
        %><%
        for (j = 1; j < n; j++)
        	%><%="&nbsp;&nbsp;&nbsp;&nbsp;"
            %><%="&nbsp;&nbsp;*"
        	%><%
        for (j = 1; j < n; j++)
        	%><%="&nbsp;&nbsp;&nbsp;&nbsp;"
            %><%="&nbsp;&nbsp;*<br/>"
        	%><%
    } else {
        for (j = i; j < 0; j++)
        	%><%="&nbsp;&nbsp;&nbsp;&nbsp;"
        	%><%
        for (j = 1; j <= n + 2 * i + 1; j++)
            if (i == 1 - (n >> 1))
            	%><%="&nbsp;&nbsp;*"
            	%><%
            else if (j == 1 || j == n + 2 * i + 1)
            	%><%="&nbsp;&nbsp;*"
            	%><%
            else
            	%><%="&nbsp;&nbsp;&nbsp;&nbsp;"
            	%><%
        for (j = 1; j <= -1 - 2 * i; j++)
        	%><%="&nbsp;&nbsp;&nbsp;&nbsp;"
        	%><%
        for (j = 1; j <= n + 2 * i + 1; j++)
            if (i == 1 - (n >> 1))
            	%><%="&nbsp;&nbsp;&nbsp;&nbsp;*"
            	%><%
            else if (j == 1 || j == n + 2 * i + 1)
            	%><%="&nbsp;&nbsp;&nbsp;&nbsp;*"
            	%><%
            else
            	%><%="&nbsp;&nbsp;&nbsp;&nbsp;"
            	%><%
        %>
        <% 
        %><%=" <br/>"
    	%><%
    }
%>

</body>
</html>