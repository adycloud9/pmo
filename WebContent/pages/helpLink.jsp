<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%String userName=(String)session.getAttribute("UserName"); 
%>
<%@page import="java.lang.String;"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Help Desk</title>
</head>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
</head>
	

<body marginwidth="0" marginheight="0" leftmargin=0 rightmargin=0
	topmargin=0>
<table width="100%" CELLPADDING="2" CELLSPACING="0" border="0" >
<tr class="thead">
	<td align="right">
	<font size="2"><b>Welcome <%=userName %></b></font>&nbsp;&nbsp;|&nbsp;
	<a href="<%=request.getContextPath()%>/login.do?method=downloadHelp">
	<b><font  color="white">Help</font></b></a>
	<b>&nbsp; </b><a href="<%=request.getContextPath()%>/pages/logout.jsp">
	<b><font  color="white">Logout</font></b></a>&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	</tr>
</table>
</body>
</html>