
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");
%>

<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>


<!--
 * JSP
 *
 *
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *						    Prior
 * Date       	By              	    Version  	     Description
 * ---------- 	--------------- 	    -------      -----------------------------------------------
 
 * ========================================================================================
 * </pre>
 *
 
 
-->

<html:html>
<head>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/common.js"></SCRIPT>
<SCRIPT src="<%=request.getContextPath()%>/jscripts/ajaxCalls.js"></SCRIPT>
<SCRIPT src="<%=request.getContextPath()%>/jscripts/commonAjaxFunctions.js"></SCRIPT>
<script type="text/javascript">

var calFlag= 0;
function resetAll()
{
      document.forms(0).action = '<%=request.getContextPath()%>/pmoscr.do?method=showPage';
	   	document.forms(0).submit(); 
}
function editUser()
{

document.forms(0).action = '<%=request.getContextPath()%>/pmoscr.do?method=editUser';
	   	document.forms(0).submit();
}
	
	// this function is used to check that email already exist or not	
function checkEmail(email)
{
	   var empId=document.pmoScrForm.empId.value;
	   var qid='getEmpidFromEmail';
	   var inParams=email;
	   var targetFields = null;  
	   getDetails_ajax(qid,inParams,null);	
	   var count =  ajaxResponse.split("!");
	   var cnt=count[0].split("~");	
	   var ct=cnt[0].split(",");	
	   if(!(ct==empId || ct==''))
	   {
	    alert('Email Address already exist.Please enter new Email Address');
	    document.getElementById('email').value='';
	    document.getElementById('email').focus();
	    return false;
	   }
	   return true;
}


function addUser(myform)
{
     
     	 var emailVal=document.pmoScrForm.email.value;
	    var fieldList='firstName,lastName,empId,role,email';
	    var fieldArray=fieldList.split(',');
	    var formname= 'pmoScrForm';
	    
	    if(validate(formname,fieldArray)==true && isValidEmail(emailVal)==true)
	    { 
	      if(checkEmail(emailVal)==true)
		    {
		 	document.forms(0).action ='<%=request.getContextPath()%>/pmoscr.do?method=addUser';
		   	document.forms(0).submit();
		    }
		 }
		else
		{
     return false;
		}
}
	
function chkSpecialChar(obj)
	{
		var iChars = "!@#$%^&*()+=.[]\\\;,/{}|\":<>?0123456789~-";
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
function BackScreen()
{
    document.forms(0).action = '<%=request.getContextPath()%>/pmoscr.do?method=showsearchUser';
	document.forms(0).submit();

}
function updateUser()
{   
		var flag=false;
		var emailVal=document.pmoScrForm.email.value;
		if(calFlag==1)
		{
		    var fieldList='firstName,lastName,empId,role,email';
		    var fieldArray=fieldList.split(',');
		    var formname= 'pmoScrForm';
		    if(validate(formname,fieldArray)==true && isValidEmail(emailVal)==true )
		    {
		   
			    if(checkEmail(emailVal)==true)
			    {
			 	 flag=true;
			 	 document.forms(0).action = '<%=request.getContextPath()%>/pmoscr.do?method=updateUser';
			     document.forms(0).submit();
				}
			}
		}
		else
		{
			alert('Please update atleast one field to continue');
			calFlag=0;
		}
return flag;
}



function disableAllFields()
    {
        var value="true";
     	document.pmoScrForm.empId.disabled=value;
     	
    }

 function flagSet()
 {
 calFlag=1;
 
 }
 
 
  function isValidEmail(email) 
         {
		    
			if(email!='')
			  {
					//var myRegExp = /^([\w]+)(\.[\w]+)*@([\w\-]+)(\.[\w]{2,7})(\.[a-z]{2})?$/i;//ver 2.28 commented
					var myRegExp = /^([a-zA-Z0-9]+)([\.|_]?[a-zA-Z0-9]*)@([a-zA-Z0-9\-]+)(\.[a-zA-Z0-9]{2,7})(\.[a-z]{2})?$/i;// ver 2.28 added
					if((trimVal(email)!='')&&(myRegExp.test(email)))
					   {
					       // ver 2.28 starts here
					       var val =  email;
						   if(val.search(/([@]{1}[-]{1})|([-]{1}[.]{1})|([-]{2})/)!=-1)
						     {
						       alert('Please enter proper Email Address');
							   email='';
							   //email.focus();
							   document.pmoScrForm.email.value='';
							   return false;
						     }
						    // ver 2.28 ends here 
						   return true;
					   }
					   else
					   {
						   alert('Please enter proper Email Address');
						   email='';
						   document.pmoScrForm.email.value='';
					    // email.focus();
						   return false;
						   
					   }	
				}
				else
				{
				
					return true;
				}
		
		}

</script>


</head>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="20" bottommargin="20">



<%try{ %>
<html:form action="pmoscr.do" method="post">
	<html:hidden name="pmoScrForm" property="method" />
	<html:hidden property="returnFlag" />
	<html:hidden property="flag" />
 	
		<table width="80%" CELLPADDING="2" CELLSPACING="0" border="0" 
			align="center" >
			<tr class="thead">
	                   <td class="thead" colspan="9" align="center"><font size="2">
						<bean:message key = "pmo.heading" />
				 		 </td>	
	             </tr>	
			
			<tr class="trow">
				<td colspan="6" class="trow" height="20"></td>
			</tr>
			
			 <tr class="trow" >
					<td colspan="6" align="center" >
					
					<logic:notEmpty
						name="pmoScrForm" property="flag">
		
						<logic:equal value="T" name="pmoScrForm" property="flag">
							<tr>
								<td colspan="6" align=center class=trow><b><font size="2"
									color="green"><strong> 
									<bean:write name="pmoScrForm" property="errorMsg" /> 
									</strong> </font> </b></td>
							</tr>
		
						</logic:equal>
						<logic:equal value="F" name="pmoScrForm" property="flag">
							<tr>
								<td colspan="6" align=center class=trow><b><font size="2"
									color="red"> <strong> <bean:write
									name="pmoScrForm" property="errorMsg" /> 
									</strong> </font> </b></td>
							</tr>
						</logic:equal>
						</logic:notEmpty>
						
						</td>
			</tr>
			
				<tr class="trow">
		       
					<td colspan="1" align="left">&nbsp;&nbsp;<bean:message key ="pmo.firstName" /><font color="red">*</font></td>
					<td colspan="2" align="left"><html:text property="firstName" title="First Name" size="15"
						name="pmoScrForm"  maxlength="20" onblur="chkSpecialChar(this); return false;" onchange="flagSet();"/>
						</td>
						
					<td colspan="1"align="left"><bean:message key="pmo.lastName" /><font color="red">*</font></td>
					<td colspan="2"><html:text property="lastName" title="Last Name" size="15"
						name="pmoScrForm"  maxlength="20" onblur="chkSpecialChar(this);return false;"onchange="flagSet();"/>
						
				</td>
				</tr>
		
			<tr class="trow">
				<td colspan="1" align="left">&nbsp;&nbsp;<bean:message key ="pmo.employeeId" /><font color="red">*</font></td>
				<td colspan="2"><html:text property="empId" title="Employee ID" size="15"
					name="pmoScrForm"  maxlength="10" onblur="checkNumeric(this);return false;"/>
					</td>
					<td colspan="1" align="left"><bean:message key="pmo.roleList" /><font color="red">*</font></td>
				   <td colspan="2">
					<html:select name="pmoScrForm" property="role"  title="Role "onchange="flagSet();">
					   <html:option value="">----Select----</html:option>
					   <logic:notEmpty name="pmoScrForm" property="roleList">
					   <html:optionsCollection name="pmoScrForm" property="roleList" label="label" value="value"/>
					   </logic:notEmpty>
					</html:select>
				</td>
			</tr>
			
			
			<tr class="trow">
				<td colspan="1"align="left">&nbsp;&nbsp;<bean:message key="pmo.email"/><font color="red">*</font></td>
				<td colspan="5"><html:text property="email" title="Email ID" size="25"
					name="pmoScrForm"  maxlength="80" onchange="flagSet();"/>
					</td>
			</tr>
			<tr class="trow">
				<td class="trow" colspan="6" align="left" >
				<font color="red"><bean:message key="label.starSign"/>
				<bean:message key="label.areMandatory"/></font></td>
			</tr>
			<tr class="trow">
				<td colspan="6" class="trow" height="20"></td>
			</tr>
			<logic:notEqual value="edit" name="pmoScrForm" property="mode">
	        <tr>
				<td colspan="6" align="center" class="thead" >
				<input type="button" class="sbttn" name="add" id="btnSrch" value="Add" onclick="return addUser(this)"> 
				
				<input type="button"class="sbttn" name="reset" value="Reset" onclick="resetAll();">
				</td>
			</tr>
			</logic:notEqual>
			<logic:equal value="edit" name="pmoScrForm" property="mode">
	     
	       <tr>
	            <script>disableAllFields();</script>
	            
				<td colspan="6" align=center class="thead" >
				<input type="button" class="sbttn" name="Update" id="btnSrch" value="Update" onclick="updateUser();"> 
				
				<input type="button"class="sbttn" name="reset" value="Back" onclick="BackScreen();">
				</td>
			</tr>
			</logic:equal>
			
		</table>
</html:form>

</body>
<%}catch(Exception e){
	e.printStackTrace();
	}%>

</html:html>
