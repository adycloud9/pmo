<%try{ %>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>


<!--
 * JSP
 *name:addWon.jsp
 *
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *						                Prior
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
<SCRIPT LANGUAGE="JavaScript"
	SRC="<%=request.getContextPath()%>/jscripts/calendar.js"
	type="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript"
	SRC="<%=request.getContextPath()%>/jscripts/datetimepicker.js"
	type="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript"
	SRC="<%=request.getContextPath()%>/jscripts/ajaxCalls.js"
	type="text/javascript"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript"
	SRC="<%=request.getContextPath()%>/jscripts/commonAjaxFunctions.js"
	type="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/common.js"></SCRIPT>
<script type="text/javascript">

function getSOWPopUp(val)
     {
   var qid = "getSowName";						
   var paramsList =val;
   var targetFields = 'sowName';
   var postFunc = "getFocus";
   if(val == "%"){
    alert("Please enter SOW Name");
    document.getElementById('sowName').focus();
    return false;
   }
   else
   {
   
   		openPopup("<%=request.getContextPath()%>",qid,paramsList,targetFields,postFunc);	
   	}
}	
function validateWON(obj)
{
	var WonNo=obj.value;
	var iChars = "0123456789";
	
	for (var i = 0; i < WonNo.length; i++)
	{
  		if (iChars.indexOf(WonNo.charAt(i)) == -1)
  		{
  			alert ("Please enter a valid integer.");
  			obj.value="";
  			obj.focus();
  			return false;
 		}
  	}
}

function addWON()
{
	var mandatoryList= new Array('sowName','wonNo');
	if(validate('wonAddForm',mandatoryList)==false)
	{
		return false;
	}
	document.wonAddForm.action = "<%=request.getContextPath()%>/wonadd.do?method=addWon" ;
	document.wonAddForm.submit();
}

function fnCancel()
{
	document.wonAddForm.method.value="showPage";
	document.wonAddForm.submit(); 
}

function getFocus()
{
	document.getElementById('sowName').focus();
	getWonNo();
}

function getWonNo()
{
	var sowName= document.getElementById('sowName').value; 
	setContextPath('<%=request.getContextPath()%>');
	var query  = 'PO.getWONList';
	var inParams = sowName;
	
	getDetails_ajax(query, inParams, null);
	<%if(!((String)request.getParameter("source")).equalsIgnoreCase("Add")){%>
	removeAllOptions(document.getElementById('wonNo'),1);
	if(ajaxResponse=='')
	{
		alert('No WON nO is available for this SOW.Please first add a won through Add WON link.');
	}
	popDropDown('wonNo',ajaxResponse);
	<%}%>
	
	
}



function editWon()
{
	var mandatoryList= new Array('sowName','wonNo','newWonNo');
	if(validate('wonAddForm',mandatoryList)==false)
	{
		return false;
	}
	if(confirm("Sure to edit WON No?"))
	{
		document.wonAddForm.action = "<%=request.getContextPath()%>/wonadd.do?method=editWon" ;
		document.wonAddForm.submit();
	}
}

function deleteWon()
{
  var mandatoryList= new Array('sowName','wonNo');
  var value="true";
	if(validate('wonAddForm',mandatoryList)==false)
	{
		return false;
	}
	
    document.wonAddForm.newWonNo.disabled=value;
	document.wonAddForm.action = "<%=request.getContextPath()%>/wonadd.do?method=deleteWon" ;
	document.wonAddForm.submit();
}

function enableNewWon()
{
	
	document.wonAddForm.newWonNo.disabled=false;
}


</script>
</head>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="20" bottommargin="20">



<html:form action="wonadd.do" method="post">
	<html:hidden property="method" />
	<html:hidden property="errorFlag" />
	<html:hidden property="source" />
	
<center>
	<table width="80%" CELLPADDING="2" CELLSPACING="0" border="0" align=center>
		<tr class="thead">
			<logic:equal value="Add" name="wonAddForm" property="source">
				<td colspan="8" align=center><b><font size="2"><bean:message key="label.addWon" /></font></b></td>
			</logic:equal>
			<logic:equal value="Edit" name="wonAddForm" property="source">
				<td colspan="8" align=center><b><font size="2"><bean:message key="label.editDeleteWon" /></font></b></td>
			</logic:equal>	
		</tr>

		<logic:notEmpty name="wonAddForm" property="errorFlag">
			<tr class = "trow">
				<td colspan = "8" ALIGN="CENTER"><br>
					<logic:equal value="T" name="wonAddForm" property="errorFlag">
						<font color = "green">
							<strong><center>
								<bean:write name="wonAddForm" property="errorMessage"/>
							</center></strong>
						</font>	
					</logic:equal>
					<logic:equal value="F" name="wonAddForm" property="errorFlag">
						<font color = "red">
							<strong><center>
								 <bean:write name="wonAddForm" property="errorMessage"/>
							</center></strong>
						</font>
					</logic:equal>
				</td>
			</tr>
	    </logic:notEmpty>
	    
	    <tr class="trow" height="5px"><td colspan="8">&nbsp;</td></tr>
		
		<tr class="trow">
			<td colspan="1">&nbsp;&nbsp;<bean:message key="label.sowName" /><font color="red">*</font></td>
			<logic:equal value="Edit" name="wonAddForm" property="source">
			<td colspan="2" >
				<html:text property="sowName" name="wonAddForm" size="15" styleClass="formtext" title="SOW Name" onchange="return getSOWPopUp(sowName.value+'%');" /> 
				<input type="image" id="sowNameImg" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For SOW Name" name="searchSowName" onClick="getSOWPopUp(sowName.value+'%');return false;" />
			</td>
			</logic:equal>
			<logic:equal value="Add" name="wonAddForm" property="source">
			<td colspan="2" >
				<html:text property="sowName" name="wonAddForm" styleClass="formtext" size="15" title="SOW Name" /> 
				<input type="image" id="sowNameImg" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For SOW Name" name="searchSowName" onClick="getSOWPopUp(sowName.value+'%');return false;" />
			</td>
			</logic:equal>
			
			
			<td colspan="1"><bean:message key="label.wonNo" /><font color="red">*</font></td>
			<logic:equal value="Add" name="wonAddForm" property="source">
				<td colspan="1">
					<html:text name="wonAddForm" property="wonNo" size="15" styleClass="formtext" maxlength="7" title="WON No." onchange="return validateWON(this);" />
				</td>
			</logic:equal>
			
			<logic:equal value="Edit" name="wonAddForm" property="source">
				<td colspan="1">
					<html:select property="wonNo" name="wonAddForm" title="WON No." onchange="enableNewWon();">
						<html:option value="">----Select----</html:option>
						<logic:notEmpty name="wonAddForm" property="wonList">
							<html:optionsCollection name="wonAddForm" property="wonList" label="label" value= "value" />
						</logic:notEmpty>
					</html:select>
				</td>
			</logic:equal>
			
			<logic:equal value="Edit" name="wonAddForm" property="source">
				<td colspan="1"><bean:message key="label.newWonNo" /></td>
				<td colspan="1">
					<html:text name="wonAddForm" property="newWonNo" size="15"  disabled="true" styleClass="formtext" maxlength="7" title="New WON No." onchange="return validateWON(this);" />
				</td>
			
			</logic:equal>
		</tr>
		
		
		<tr class="trow">
			<td colspan="8" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
				<td class="trow" colspan="8" align="left" >&nbsp;
				<font color="red"><bean:message key="label.starSign"/>
				<bean:message key="label.areMandatory"/></font></td>
			</tr>
			
		<tr class="thead">
			<td colspan="8" align=center>
				<logic:equal value="Add" name="wonAddForm" property="source">
					<input type="button" class="sbttn" name="formAdd" value="Add" onclick="return addWON();" /> 
				</logic:equal>
				
				<logic:equal value="Edit" name="wonAddForm" property="source">
					<input type="button" class="sbttn" name="formEdit" value="Save" onclick="return editWon();" />
					<input type="button" class="sbttn" name="formEdit" value="Delete" onclick=" return deleteWon();" />
				</logic:equal> 
				<input type="button" class="sbttn" name="formCancel" value="Reset" onclick="return fnCancel();" /> 
			</td>
		</tr>

	</table>
	<logic:notEmpty name="wonAddForm" property="wonList">	
		<div id="divSearchDetails" style="width: 85%;height:auto;overflow: scroll; border: 4px" >
			<table width="85%" CELLPADDING="3" CELLSPACING="1" border="0" align=center>
				<tr>
					<td colspan=2 class="thead" align="center">								
						<bean:message key="label.sowName"/>
					</td>
					<td colspan=2 class="thead" align="center">								
						<bean:message key="label.wonNo"/>
					</td>
				</tr>
				
				<logic:iterate property="wonList" name="wonAddForm" id="wonaddEntity" indexId="count" >									
					<tr>
						<td colspan=2 class="trow" align="center">	
							<bean:write name="wonaddEntity" property="sowName"/>
						</td>
						<td colspan=2 class="trow" align="center">	
							<bean:write name="wonaddEntity" property="wonNo"/>
						</td>
					</tr>
				</logic:iterate>
				
				<tr class="thead">
					<td colspan="8" align=center></td>
				</tr>
			</table>
		</div>
	</logic:notEmpty>
	</center>

</html:form>
</body>
</html:html>
<%}
catch(Exception e)
{
	System.out.println("e--->" + e.getMessage());	
	e.printStackTrace();
}
%>
