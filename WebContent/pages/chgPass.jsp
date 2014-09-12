<!--
 * JSP
 * Name: chgPass.jsp
 * Action Class : LoginAction.java  
 * Form Class   :loginForm.java 
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *                            Prior
 * Date       By              Version  	Description
 * ---------- --------------- -------  ----------------------------------------------------
 *
 * ========================================================================================
 * </pre>
 *
 
 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
	
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/ajaxCalls.js" type="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/commonAjaxFunctions.js" type="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/common.js" type="text/javascript"></SCRIPT>		
<title>Change Password</title>
<script type="text/javascript">

function validate_form(form)
	{
	 var list = new Array('empId','password','newPassword1','newPassword2'); 
	 if(validate('loginForm',list)){
     	if(document.getElementById('password').value!=document.getElementById('hiddenPwd').value)
     	{
     	  alert("Old Password is Incorrect");
     	  document.getElementById('password').value='';
     	  document.getElementById('password').focus();
     	  return false
     	}
     	var newpass1 = document.getElementById('newPassword1').value;
     	var newpass2 = document.getElementById('newPassword2').value;
        if(!(newpass1 == newpass2)){
        	alert(" New password does not match with Confirm Password");
        	document.getElementById('newPassword1').value="";
        	document.getElementById('newPassword2').value="";
        	document.getElementById('newPassword1').focus();
        	
        	return false;
        } 
     if(document.getElementById('hiddenPwd').value==newpass2)
	{
	alert('Old Password and New password is same.Please enter again.');
	document.getElementById('newPassword1').value="";
    document.getElementById('newPassword2').value="";
    return false;
	}
	 } else {
		return false;
	}
	
	 document.loginForm.hiddenPwd.value=document.getElementById('newPassword1').value;
	
	 document.forms(0).action = "<%=request.getContextPath()%>/login.do?method=changePassword";
	 document.forms(0).submit();
	
	}

function resetForm()
	{
     document.forms(0).action = "<%=request.getContextPath()%>/login.do?method=showChangePassword";
     document.forms(0).submit();
	}

</script>
</head>
<body marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="20" bottommargin="20">
<html:form action="login.do" method="post">
	<html:hidden property="method" name="loginForm" />
	<input type="image" scr="" height="0px" width="0px" onclick="return validate_form('loginForm');"/>
	<table width="50%" CELLPADDING="0" CELLSPACING="0" border="0"
		align="center">
		<tr class="thead">
			<td align="center" colspan="2">
			<b><font size="2"><bean:message key="label.changePass"/></font></b>
			</td>
			
		</tr>
		<tr class="trow">
			<td colspan="2" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		
	 		<logic:notEmpty name = "loginForm" property = "msg">
	 		 <tr class="trow">
	 		    <logic:notEqual name = "loginForm" property = "msg" value ="Password Changed Successfully">
		 		  <td colspan="6" align= "center">
		 		  <b><font color="red"  />
			  	 <bean:write  name = "loginForm" property = "msg"  /></b>
			     </td>
		 	    </logic:notEqual>
		        <logic:equal name = "loginForm" property = "msg" value ="Password Changed Successfully">	
		      	<td colspan="6" align= "center">
		 		   <b><font color="green" />
			  	 	<bean:write  name = "loginForm" property = "msg"  /></b>
			   	</td>
		      </logic:equal>	  
		     </tr> 	
		    </logic:notEmpty>	
		 <tr class="trow">
			<td colspan="2" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>		
		<tr class="trow">
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.empId"/></td>
			<td><html:text property="empId" title = "Emp ID" maxlength="6" readonly="true"></html:text></td>
		</tr>
		<tr class="trow">
			<td colspan="2" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.oldPass"/><span style ="color:  red">*</span> </td>
			<td><html:password property="password" title= "Old Password" /><html:hidden property="hiddenPwd"/></td>
		</tr>
		<tr class="trow">
			<td colspan="2" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.newPass"/> <span style ="color:  red">*</span></td>
			<td><html:password property="newPassword1" title="New Password" /></td>
		</tr>
		<tr class="trow">
			<td colspan="2" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.confirmPass"/> <span style ="color:  red">*</span></td>
			<td><html:password property="newPassword2" title="New Password again to confirm "/></td>
		</tr>

		<tr class="trow">
			<td colspan="2" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>

		<tr class="trow">
			<td colspan="2" class="trow"><font color="red" />&nbsp;&nbsp;* Fields are mandatory</td>
		</tr>
		<tr class="trow">
			<td colspan="2" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class=thead>
			<td colspan="2" align="center">
		    <html:button value="Submit" onclick="validate_form('loginForm')" styleClass="sbttn" property="reset_bttn" />
			<html:button value="Reset" onclick="resetForm();" styleClass="sbttn" property="reset_bttn" />

		</tr>


	</table>



</html:form>

<logic:equal name="loginForm" property="flag" value="false">
	<h4><font color="red"><b>Note:</b>Please enter correct old password</font></h4>
</logic:equal>
</body>
</html>
