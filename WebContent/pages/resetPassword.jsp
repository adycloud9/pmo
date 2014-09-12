<!--
 * JSP
 * Name: resetPassword.jsp
 * Action Class : LoginAction.java  
 * Form Class   :loginForm.java 
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *                            Prior
 * Date       By              Version  	Description
 * ---------- --------------- -------  ----------------------------------------------------
  
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
  
  var children =new Array() ;
 function getlastNamePopup(val)
{   
    val = trimVal(val);
    
   var qid = "getLastName";						
   var paramsList =val;
   var targetFields =  'emp_Id,firstName,lastName';
   var postFunc = null;
   if(val == "%"){
    alert("Please enter Last Name");
    document.getElementById('lastName').focus();
    return false;
   }
   else{
   var window= openPopup("<%=request.getContextPath()%>",qid,paramsList,targetFields,postFunc);	
     children.push(window);
	}
}
function getPopup(val)
{
   val = trimVal(val);
   var qid = "getFirstName";						
   var paramsList =val;
   var targetFields =  'emp_Id,firstName,lastName';
   var postFunc = null;
    if(val == "%"){
    alert("Please enter First Name");
    document.getElementById('firstName').focus();
    return false;
   
   }
   else{
     var window = openPopup("<%=request.getContextPath()%>",qid,paramsList,targetFields,postFunc);	
     children.push(window);
   }
   }
   
   
   
 function getEmpIdPopup(val)
{
   val = trimVal(val);
   var qid = "getEmployeeID";						
   var paramsList =val;
   var targetFields = 'emp_Id,firstName,lastName';
   var postFunc = null;
  if(val == "%"){
    alert("Please enter Employee ID");
    document.getElementById('emp_Id').focus();
    return false;
   }
   else{
     var window= openPopup("<%=request.getContextPath()%>",qid,paramsList,targetFields,postFunc);	
     children.push(window);
	}
}
  function closeAllchildren() 
{ 
	for(var n=0;n<children.length;n++) 
	{
	 children[n].close(); 
	} 		
}  



function chkSpecialChar(obj)
	{
		var iChars = "!@#$%^&*()+=.[]\\\;,/{}|\":<>?0123456789";
			for (var i = 0; i < obj.value.length; i++)
			{
		  		if (iChars.indexOf(obj.value.charAt(i)) != -1)
		  		{
		  			alert ("Specials Characters and numbers are not allowed");
					obj.focus();
					obj.value="";

  				
		  			return false;
	  			}
	  			
	  		}
	  	return true;	
	}
	
	function checkNumeric(numberFeild)
{
	var amt = numberFeild.value;
	var iChars = "0123456789";
		for (var i = 0; i < amt.length; i++)
		{
	  		if (iChars.indexOf(amt.charAt(i)) == -1)
	  		{
  			alert ("Please enter a valid number");
  			numberFeild.value="";
  			numberFeild.focus();
  			return false;
  			}
  		}
}
 
 function resetPassword()
 {
 if(confirm('Are you sure to reset the password ?'))
     {
    
      document.forms(0).action = '<%=request.getContextPath()%>/login.do?method=resetPassword';
  	  document.forms(0).submit();
  	 }
  	else
  	{
  	 return false;
  
	}
 }
 function FnCancel()
 {
 document.forms(0).action = "<%=request.getContextPath()%>/login.do?method=showResetPassword";
 document.forms(0).submit();
 }

</script>
</head>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="20" bottommargin="20">
<html:form action="login.do" method="post">
	<html:hidden property="method" name="loginForm" />
	
	<table width="70%" CELLPADDING="2" CELLSPACING="0" border="0"
		align="center">
		<tr class="thead">
			<td colspan="6" align=center>
			<b><font size="2">Reset Password </font></b></td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
	 		<logic:notEmpty name="loginForm" property ="msg">
	 		 <tr class="trow">
	 		   
				
				<logic:notEqual name = "loginForm" property = "errorMsg" value ="F">
		 		  <td colspan="6" align= "center">
		 			  <b>
		 	  			 <font color="green" />
			  			 	<bean:write  name = "loginForm" property ="errorMsg"  /></b>
			 	  	</td>
			 	</logic:notEqual>
			 	
			 	<logic:equal name = "loginForm" property ="errorMsg" value ="F">	
		      	<td colspan="6" align= "center">
		 		   <b><font color="red" />
			  	 	<bean:write  name = "loginForm" property = "errorMsg"  /></b>
			   	</td>
		      </logic:equal>
		       
		     </tr> 	
		    </logic:notEmpty>	
		 <tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>	
		<tr class ="trow">	
		<td  class ="trow" colspan="1" align="left">&nbsp;&nbsp;<bean:message key ="pmo.employeeId" /></td>
		<td class ="trow"colspan="5"><html:text property="emp_Id" size="15"
			name="loginForm"  maxlength="10" onchange="getEmpIdPopup(this.value+'%');checkNumeric(this);return false;"/>
		<input type="image" id="empImg" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For Employee ID" name="searchFirstName" onClick="getEmpIdPopup(emp_Id.value+'%');return false;">
		</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow" >
		
					<td colspan="1" height="20" align="left">&nbsp;&nbsp;<bean:message key ="pmo.firstName" /></td>
					<td colspan="2" align="left"><html:text property="firstName" size="15"
						name="loginForm"  maxlength="20" disabled="true"/>
					

						</td>
					<td colspan="1"align="left"><bean:message key="pmo.lastName" /></td>
					<td colspan="2"><html:text property="lastName" size="15"
						name="loginForm"  maxlength="20" disabled="true"/>
				  
						</td>
				</tr>

		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>

		<tr class="trow">
			<td colspan="6" class="trow"><font color="red" />&nbsp;&nbsp;* Fields are mandatory</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		 <tr>
				<td colspan="6" align=center class="thead" >
				<input type="button" class="sbttn" name="Reset" id="btnSrch" value="Reset" onclick="resetPassword();"> 
				<input type="button" class="sbttn" name="cancel" id="btnSrch" value="Cancel" onclick="FnCancel();" > 
				</td>
			</tr>

	</table>



</html:form>


</body>
</html>




















