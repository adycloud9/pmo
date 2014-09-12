<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script type="text/javascript">
function validate()
{
    
	//document.loginForm.method.value="changePassword";
	//document.loginForm.password.value;
	/*try
	{
		throw 'test';
	}
	catch(e)
	{
		if(e=='test')
		{
			alert("Testing");
		}	
	}
*/
if(IsEmpid()=="false")

{
		alert("Please enter valid EmpId.");
		return false;
	}
	
	
	if(login.password.value== "") 
	{
		alert("Please enter Password.");
		return false;
	}
	
return true;
}
function IsEmpid(sText)
{
   var ValidChars = "0123456789.";
   var IsNumber=true;
   var Char;

 
   for (i = 0; i < 6 && IsNumber == true; i++) 
      { 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
      }
   return IsNumber;
   
}
</script>
</head>
<body bgcolor="white">
</body>
<head></head>
<body>
<html:form method="post" action="changePassword.do">
	<html:hidden name="loginForm" property="method" value="changePassword" />
	<center>

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
					<td align="right">EMP ID:</td>
					<td><input type="text" size="30" maxlength="30" onclick /></td>
					<td><bean:write name="loginForm" property="empId" /></td>
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
		<tr>
			<td align="center"><input type="RESET" size="20" VALUE="RESET" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="SUBMIT" size="20" VALUE="SUBMIT" onclick="validate()" /></td>
		</tr>

		<tr></tr>

	</table>
	<br>
	<br>
	<a href="PMO_SCR.jsp " align="center">Change Password</a></center>

</html:form>
</body>
</html>
