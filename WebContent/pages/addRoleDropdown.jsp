
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


	
function chkSpecialChar(obj)
	{
		var iChars = "!@#$%^&*()+=[]\\\;/{}|\":<>?0123456789";
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
	
	
	

 
 function addRoleList()
 {
  
	    var fieldList='name,designation,role';
	    var fieldArray=fieldList.split(',');
	    var formname= 'pmoScrForm';
	    
	    if(validate(formname,fieldArray)==true )
	    { 
	      
		 	document.forms(0).action ='<%=request.getContextPath()%>/pmoscr.do?method=addLUser';
		   	document.forms(0).submit();
		   
		 }
		else
		{
     return false;
		}
}
 
 
 
 function resetData()
 {
     
      document.forms(0).action = '<%=request.getContextPath()%>/pmoscr.do?method=RolePage';
	   	document.forms(0).submit(); 
 
 }

	</script>


</head>
<BODY marginwidth="0" marginheight="0" leftmargin="4" rightmargin="0"
	topmargin="20" bottommargin="20">



<%try{ %>
<html:form action="pmoscr.do" method="post">
	<html:hidden name="pmoScrForm" property="method" />
	<html:hidden property="returnFlag" />
	<html:hidden property="flag" />
 	
		<table width="50%" CELLPADDING="2" CELLSPACING="0" border="0" height="150px"
			align="center" >
			<tr class="thead">
	                   <td class="thead" colspan="9" align="center"><font size="2">
						Add  Personal
				 		 </td>	
	             </tr>	
			
			<tr class="trow">
				<td colspan="5" class="trow" height="20"></td>
			</tr>
			
			 <tr class="trow" >
					<td colspan="5" align="center" >
					
					<logic:notEmpty
						name="pmoScrForm" property="flag">
		
						<logic:equal value="T" name="pmoScrForm" property="flag">
							<tr>
								<td colspan="5" align=center class=trow><b><font size="2"
									color="green"><strong> 
									<bean:write name="pmoScrForm" property="errorMsg" /> 
									</strong> </font> </b></td>
							</tr>
		
						</logic:equal>
						<logic:equal value="F" name="pmoScrForm" property="flag">
							<tr>
								<td colspan="5" align=center class=trow><b><font size="2"
									color="red"> <strong> <bean:write
									name="pmoScrForm" property="errorMsg" /> 
									</strong> </font> </b></td>
							</tr>
						</logic:equal>
						</logic:notEmpty>
						
						</td>
			</tr>
			
				<tr class="trow">
		       
					<td colspan="1" align="left">&nbsp;&nbsp;<bean:message key ="label.name" /><font color="red">*</font></td>
					<td colspan="4" align="left"><html:text property="name" title="Name" size="20"
						name="pmoScrForm"  maxlength="50" onblur="chkSpecialChar(this); return false;" />
						</td>
					
					
		</tr>
		<tr class="trow">
		<td colspan="1" align="left">&nbsp;&nbsp;<bean:message key ="label.designation" /><font color="red">*</font></td>
					<td colspan="4" align="left"><html:text property="designation" title="designation" size="20"
						name="pmoScrForm"  maxlength="50" onblur="chkSpecialChar(this); return false;" />
						</td>	
		</tr>
			<tr class="trow">
				
					<td colspan="1" align="left">&nbsp;&nbsp;<bean:message key="pmo.roleList" /><font color="red">*</font></td>
				   <td colspan="4">
					<html:select name="pmoScrForm" property="role"  title="Role ">
					   <html:option value="">----Select----</html:option>
					   <logic:notEmpty name="pmoScrForm" property="roleList">
					   <html:optionsCollection name="pmoScrForm" property="roleList" label="label" value="value"/>
					   </logic:notEmpty>
					</html:select>
				</td>
			</tr>
			
			
			<tr class="trow">
				<td colspan="5" class="trow" ></td>
			</tr>
			<tr class="trow">
				<td class="trow" colspan="5" align="left" >
				<font color="red"><bean:message key="label.starSign"/>
				<bean:message key="label.areMandatory"/></font></td>
			</tr>
			<tr class="trow">
				<td colspan="5" class="trow" height="20"></td>
			</tr>
			
	        <tr>
				<td colspan="5" align="center" class="thead" >
				<input type="button" class="sbttn" name="add" id="btnSrch" value="Add" onclick="return addRoleList(this)"> 
				
				<input type="button"class="sbttn" name="reset" value="Reset" onclick="resetData();">
				</td>
			</tr>
		
			
			
		</table>
</html:form>

</body>
<%}catch(Exception e){
	e.printStackTrace();
	}%>

</html:html>
