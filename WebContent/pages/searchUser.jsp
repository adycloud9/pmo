
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
	var children =new Array() ;
	
	function deleteUser(count)
	{

	if(confirm('Are you sure to remove this record?'))
     {
      document.forms(0).action = '<%=request.getContextPath()%>/pmoscr.do?method=deleteUser&count='+count;
  	  document.forms(0).submit();
  	 }
  	else
  	 return false;
  
	}
   function getlastNamePopup(val)
{   
    val = trimVal(val);
    
   var qid = "getLastName";						
   var paramsList =val;
   var targetFields =  'empId,firstName,lastName';
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
   var targetFields =  'empId,firstName,lastName';
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
   
function getEmailPopup(val)
{
   val = trimVal(val);
   var qid = "getemail";						
   var paramsList =val;
   var targetFields = 'email';
   var postFunc = null;
  if(val == "%"){
    alert("Please enter Email ID");
    document.getElementById('email').focus();
    return false;
   }
   else{
  var window= openPopup("<%=request.getContextPath()%>",qid,paramsList,targetFields,postFunc);	
     children.push(window);
	}
}
  function getEmpIdPopup(val)
{
   val = trimVal(val);
   var qid = "getEmployeeID";						
   var paramsList =val;
   var targetFields = 'empId,firstName,lastName';
   var postFunc = null;
  if(val == "%"){
    alert("Please enter Employee ID");
    document.getElementById('empId').focus();
    return false;
   }
   else{
     var window= openPopup("<%=request.getContextPath()%>",qid,paramsList,targetFields,postFunc);	
     children.push(window);
	}
}
	




function searchUser()
{
	    
var fieldList='firstName,lastName,empId,email,role';
	var fieldArray=fieldList.split(',');
	var flag=false;
	for(var i=0;i<fieldArray.length;i++)
	{          
	     var obj = eval('document.pmoScrForm.elements[\''+fieldArray[i]+'\']');  
	     if(obj.value!='')
	      {
	      	flag=true;
	       closeAllchildren() ;
	      var email= document.getElementById('email');
	       if(isValidEmail(email)==true){
	       
	      	document.forms(0).action = '<%=request.getContextPath()%>/pmoscr.do?method=searchUser';
  	        document.forms(0).submit();
  	        }
  	        else
  	        {
  	        return false;
  	        }
	      }
	}
	if(flag==false)
	{
		alert('Atleast one input is required for search');
		return false;
		
	}
}

	function FnCancel()
	{   
	
     document.pmoScrForm.mode.value='';
	 document.forms(0).action = '<%=request.getContextPath()%>/pmoscr.do?method=showsearchUser';
  	 document.forms(0).submit();
	    
	
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
function disableAllFields()
    {
        var value="true";
    	document.pmoScrForm.role.disabled=value;	   
     	document.pmoScrForm.firstName.disabled=value;
     	document.pmoScrForm.lastName.disabled=value;
     	document.pmoScrForm.empId.disabled=value;
     	document.pmoScrForm.email.disabled=value;
     	document.getElementById('firstImg').disabled=value;
     	document.getElementById('lastImg').disabled=value;
     	document.getElementById('empImg').disabled=value;
     	document.getElementById('emailImg').disabled=value;
    }

function enableAllFields()
    {
    	var value="false";
    	document.pmoScrForm.role.disabled=value;	   
     	document.pmoScrForm.firstName.disabled=value;
     	document.pmoScrForm.lastName.disabled=value;
     	document.pmoScrForm.empId.disabled=value;
     	document.pmoScrForm.email.disabled=value;
     	document.getElementById('firstImg').disabled=value;
     	document.getElementById('lastImg').disabled=value;
     	document.getElementById('empImg').disabled=value;
     	document.getElementById('emailImg').disabled=value;
     	
         
    }
    function closeAllchildren() 
{ 
	for(var n=0;n<children.length;n++) 
	{
	 children[n].close(); 
	} 		
}  
</script>

</head>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="5" bottommargin="20">
<%try{ %>
<html:form action="pmoscr.do" method="post">
<input type="image"   src="" height="0px" width="0px"   onclick="return searchUser();" > 
	<html:hidden name="pmoScrForm" property="method" />
	<html:hidden name="pmoScrForm" property="mode" />
     <html:hidden name="pmoScrForm" property="pageMode" />
     <html:hidden property="deleteFlag" />
      <input type="image" src="" height="" width="" onclick="return false;"/>
		<table width="80%" CELLPADDING="2" CELLSPACING="0" border="0" align="center">
			<tr class="thead">
                <td class="thead" colspan="9" align="center"><font size="2">
					<bean:message key = "search.heading" />
		 		</td>	
	       </tr>	
			<tr class="trow" >
					<td colspan="6" align="center" >
					
					<logic:notEmpty
						name="pmoScrForm" property="returnFlag">
		
						<logic:equal value="T" name="pmoScrForm" property="returnFlag">
							<tr>
								<td colspan="6" align=center class=trow><b><font size="2"
									color="green"> <strong> 
									<bean:write name="pmoScrForm" property="returnMsg" /> 
									</strong> </font> </b></td>
							</tr>
		
						</logic:equal>
						<logic:equal value="F" name="pmoScrForm" property="returnFlag">
							<tr>
								<td colspan="6" align=center class=trow><b><font size="2"
									color="red"> <strong> <bean:write
									name="pmoScrForm" property="returnMsg" /> 
									</strong> </font> </b></td>
							</tr>
						</logic:equal>
						</logic:notEmpty>
						</td>
			</tr>
			
			<tr class="trow" >
					<td colspan="6" align="center" >
					<logic:notEmpty
						name="pmoScrForm" property="deleteFlag">
		
						<logic:equal value="T" name="pmoScrForm" property="deleteFlag">
							<tr>
								<td colspan="6" align=center class=trow><b><font size="2"
									color="green"> <strong> 
									<bean:write name="pmoScrForm" property="deleteMsg" /> 
									</strong> </font> </b></td>
							</tr>
		
						</logic:equal>
						<logic:equal value="F" name="pmoScrForm" property="deleteFlag">
							<tr>
								<td colspan="6" align=center class=trow><b><font size="2"
									color="red"> <strong> <bean:write
									name="pmoScrForm" property="deleteMsg" /> 
									</strong> </font> </b></td>
							</tr>
						</logic:equal>
						</logic:notEmpty>
						</td>
			</tr>
			<tr class="trow">
				<td colspan="6" class="trow" height="20"></td>
			</tr>
			
			
				<tr class="trow" >
		
					<td colspan="1" height="20" align="left">&nbsp;&nbsp;<bean:message key ="pmo.firstName" /></td>
					<td colspan="2" align="left"><html:text property="firstName" size="15"
						name="pmoScrForm"  maxlength="20" onchange="getPopup(this.value+'%');return false;"/>
					<input type="image" id="firstImg" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For First Name" name="searchFirstName" onClick="getPopup(firstName.value+'%');return false;">
						</td>
					<td colspan="1"align="left"><bean:message key="pmo.lastName" /></td>
					<td colspan="2"><html:text property="lastName" size="15"
						name="pmoScrForm"  maxlength="20" onchange="getlastNamePopup(this.value+'%');return false;"/>
				  <input type="image" id="lastImg" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For Last Name" name="searchFirstName" onClick="getlastNamePopup(lastName.value+'%');return false;">
						</td>
				</tr>
		
			<tr class="trow">
				<td colspan="1" align="left">&nbsp;&nbsp;<bean:message key ="pmo.employeeId" /></td>
				<td colspan="2"><html:text property="empId" size="15"
					name="pmoScrForm"  maxlength="10" onchange="getEmpIdPopup(this.value+'%');checkNumeric(this);return false;"/>
					<input type="image" id="empImg" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For Employee ID" name="searchFirstName" onClick="getEmpIdPopup(empId.value+'%');return false;">
					</td>
				<td colspan="1" align="left"><bean:message key="pmo.roleList" /></td>
				<td colspan="2">
					<html:select name="pmoScrForm" property="role">
					   <html:option value="">----Select----</html:option>
					   <logic:notEmpty name="pmoScrForm" property="roleList">
					   <html:optionsCollection name="pmoScrForm" property="roleList" label="label" value="value"/>
					   </logic:notEmpty>
					</html:select>
				</td>
			</tr>
			
			
			<tr class="trow">
				<td colspan="1"align="left">&nbsp;&nbsp;<bean:message key="pmo.email"/></td>
				<td colspan="5"><html:text property="email" size="15"
					name="pmoScrForm"  maxlength="80" onchange="getEmailPopup(this.value+'%');return false;"/>
				<input type="image" id="emailImg" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For Email Id" name="searchFirstName" onClick="getEmailPopup(email.value+'%');return false;">	
					</td>
			</tr>
			
			<tr class="trow">
				<td colspan="6" class="trow" height="20"></td>
			</tr>
	        <tr>
				<td colspan="6" align=center class="thead" >
				<input type="button" class="sbttn" name="Search" id="btnSrch" value="Search" onclick="searchUser();"> 
				<input type="button" class="sbttn" name="cancel" id="btnSrch" value="Reset" onclick="enableAllFields();return FnCancel();"> 
				</td>
			</tr>
			<tr >
			<td colspan="6">&nbsp;</td>
		</tr>
		<tr>
		
			<td colspan="6" align="center" valign="bottom" >
			<logic:equal value="Display" name="pmoScrForm" property="pageMode">
		   <logic:notEmpty	name="pmoScrForm" property="empList">
				<script>disableAllFields();</script>
				<table border="0" width="100%" cellspacing="0" cellpadding="0" >
					<tr class="thead">
						<td colspan="6" align="center"><font size="2"><bean:message key="search.screenHeading" /></td>
					</tr>
					
					<tr class="trow">
						<td colspan="6">&nbsp;</td>
					</tr>
		
		<tr>
					<td colspan="6">
					<logic:greaterThan value="5" name="pmoScrForm" property="listSize">
							<div id="List"
							style="width: 100%;height:180px;overflow:scroll;">
						</logic:greaterThan>
						<logic:lessEqual value="5" name="pmoScrForm" property="listSize">							
							<div id="List"
							style="width: 100%;overflow:auto; border: 4px;">
						</logic:lessEqual>
						<table width="100%" cellspacing="1" cellpadding="2" >
						<tr class=" fixedThead">
								<td class=" fixedThead" align="center" ><bean:message key="pmo.firstName" /></td>
								<td class=" fixedThead" align="center"><bean:message key="pmo.lastName" /></td>
								<td class=" fixedThead"  align="center"><bean:message key="pmo.employeeId" /></td>
								<td class=" fixedThead" align="center"><bean:message key="pmo.roleList" /></td>
								<td class=" fixedThead" align="center"><bean:message key="pmo.email" /></td>
								<td class=" fixedThead"  align="center" colspan="2"><bean:message key="search.action" /></td>
							</tr>
						<logic:iterate name="pmoScrForm" property="empList" id="empList" indexId="count">								
								<tr class="trow">
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="empList" property="firstName" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write	name="empList" property="lastName" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write	name="empList" property="empId" /></td>	
									<td class="trow" nowrap="nowrap" align="center"><bean:write	name="empList" property="role" /></td>	
									<td class="trow" nowrap="nowrap" align="center"><bean:write	name="empList" property="email" /></td>	
								    <td class="trow" nowrap="nowrap" align="center"> <a href="<%=request.getContextPath()%>/pmoscr.do?method=editUser&count=<%=count%>"><font face="Verdana" size="1">
								    <bean:message key="search.edit" /></font></a></td>
								    <td class="trow" nowrap="nowrap" align="center" onclick="<%="return deleteUser("+count+");"%>"> <a href="#"><font face="Verdana" size="1">
								    <bean:message key="search.delete" /></font></a></td>
								</tr>
						</logic:iterate>
						<tr class="thead">
						<td colspan="7" align="center" class="thead"><input
							type="button" class="sbttn" name="Validate" value="Cancel"
							onclick="enableAllFields();return FnCancel();">
						</td>
					</tr>
				</table>	
			</div>
			</td>
			</tr>
			</table>
			</logic:notEmpty>
			<logic:empty name="pmoScrForm" property="empList" >
				<script>disableAllFields();</script>
				<table border="0" width="100%" cellspacing="0">
					<tr class="thead">
						<td  colspan="6" align="center"><bean:message key="search.screenHeading" /></td>
					</tr>
					<tr>
						<td colspan="6" align="center" class="trow"><bean:message
							key="search.dataNotAvailable" /></td>
					</tr>
					<tr class="trow">
						<td colspan="8">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="6" align="center" class="thead"><input
							type="button" class="sbttn" name="Validate" value="Cancel"
							onclick="enableAllFields();return FnCancel();">
						</td>
					</tr>
					
				</table>
			</logic:empty>
			</logic:equal>
			
			</td>
			</tr>
		</table>
		
	
</html:form>
<%}catch(Exception e){
	e.printStackTrace();
	}%>

</body>


</html:html>


