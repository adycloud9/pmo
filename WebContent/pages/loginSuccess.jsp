<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html:form method="post" action="Sow.do">
	<table width="400" border="1" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td>
			<table border="0" cellspacing="2" cellpadding="1" width="100%">
				<tr bgcolor="#eaeac8">
					<td align="left" colspan="2"><font size="5">Enter
					Details</font></td>
				</tr>

				<tr>
					<td colspan="2">
					<p>&nbsp;</p>
					</td>
				</tr>

				<tr align="center">
					<td align="right">Sow Name:</td>
					<td><input type="text" size="30" maxlength="30" onclick /></td>
					<td><bean:write name="loginForm" property="empId" /></td>
				</tr>

				<tr align="center">
					<td align="right">Date:</td>
					<html:select property="date">

					</html:select>
				</tr>
				<tr align="center">
					<td align="right">Prepared By:</td>
					<td><input type="password" size="30" /></td>
				</tr>
				<tr align="center">
					<td align="right">Program Manager:</td>
					<td><
				</tr>
				<tr align="center">
					<td align="right">PASSWORD:</td>
					<td><input type="password" size="30" /></td>
				</tr>
			</table>

			<center></center>
			</td>
		</tr>
		<tr>
			<td></td>
		</tr>

		<td align="center"><input type="RESET" size="20" VALUE="RESET" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="SUBMIT" size="20" VALUE="SUBMIT" onclick="validate()" /></td>
		</html:form>
</body>
</html>
