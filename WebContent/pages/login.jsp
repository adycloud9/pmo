<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<html:html>
<head>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/common.js"></SCRIPT>

<script type="text/javascript">
//This function is used to validate the form
function validate()
{
	var empID = document.loginForm.empId;
	empID.value=trimVal(empID.value);
	var password = document.loginForm.password;
	if(empID.value=='')
	{
		alert('Please enter Employee ID');
		empID.focus();
		return false;		
	}
	if(password.value=='')
	{
		alert('Please enter password');
		password.focus();
		return false;		
	}
	if(!checkNumericValues(empID))
	{
		return false;
	}
	document.forms(0).action='<%=request.getContextPath()%>/login.do?method=login';
	document.forms(0).submit();
	return true;
}

//This function is used to reset the form
function resetForm()
{
   document.loginForm.action='<%=request.getContextPath()%>/login.do?method=reset';
   document.loginForm.submit();
}
</script>
<title>Login PMO</title>
</head>
<body bottommargin="10">

<html:form action="login.do" method="post">
	<html:hidden property="method" />

	<%@include file="top.jsp"%>
	<br>
	<br>
	<br>
	<table width="45%" CELLPADDING="2" CELLSPACING="0" border="1" rules="none" bordercolor="black"	align="center">
		<tr class="thead">
			<td colspan="2" align="center" style="padding:5px;">
			<b><font face="Verdana" size="3"><bean:message key="label.login"/> </font></b>
			</td>
		</tr>
		
			
		<tr>
			<td align="center"><br>
			<b><font face="verdana" size="2"><bean:message key="label.empID"/></font></b></td>
			<td><br>
			<html:text property="empId" name="loginForm" size="20" maxlength="6"/></td>
		</tr>
		<tr>
			<td align="center"><br>&nbsp;&nbsp;&nbsp;&nbsp;
			<b><font face="verdana" size="2" ><bean:message key="lable.password"/></font></b></td>
			<td><br>
			<html:password property="password" name="loginForm" size="20" /></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" colspan="2" >
				<font face="Verdana" size="1"><b>Please contact PMO to create new user</b></font>
			</td>
		</tr>
	<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr class="thead">
			<td colspan="2" align="center" style="padding:5px;">
			<html:submit value="Login" 	styleClass="sbttn" onclick="return validate();" /> 
			<html:reset value="Reset" styleClass="sbttn" onclick="resetForm();"></html:reset>
			</td>
		</tr>
		
	</table>
	
	
		<logic:equal name="loginForm" property="flag" value="false">
			<table width="45%" CELLPADDING="2" CELLSPACING="0" 	align="center">
			<tr >
				<td colspan="2" align="right">
						<font face="Verdana" size="2" color="red">
						<bean:message key="label.loginErrorMessage1"/><br>
						<bean:message key="label.loginErrorMessage2"/>
						</font>
				</td>
			</tr>
		</table>	
	</logic:equal>

	


</html:form>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</body>
<%@include file="footer.jsp"%>


</html:html>
