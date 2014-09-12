<!--
 * JSP
 *
 *  Name        :editSow.jsp
 * Action Class :SowAction.java  
 * Form Class   :SowForm.java 
 * 
 * <p>
 * <b>Revision History:</b><pre>
 * ===========================================================================================================================
 *                            Prior
 * Date       By              Version  	Description
 * ---------- --------------- -------  ---------------------------------------------------------------------------------------
 
 * ===========================================================================================================================
 * </pre>
 *
 
 
-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%try{ %>
<%@page import="com.vsnl.util.Constants"%>

<html:html locale="true">
<title>Edit SOW Details</title>
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
	SRC="<%=request.getContextPath()%>/jscripts/common.js"
	type="text/javascript"></SCRIPT>
	
<SCRIPT LANGUAGE="JavaScript"
	SRC="<%=request.getContextPath()%>/jscripts/ajaxCalls.js"
	type="text/javascript"></SCRIPT>
	
<SCRIPT LANGUAGE="JavaScript"
	SRC="<%=request.getContextPath()%>/jscripts/commonAjaxCalls.js"
	type="text/javascript"></SCRIPT>

<script type='text/javascript'>

var addMileListLength=0;
var callFlag=0;
var sowPopupobj=null;
function getSOWVersionPopUp(val)
{
	var qid = 'getSowNameVersion';
	val=trimVal(val);
	if(val=='')
	{
		alert('Please enter SOW Name');
		return false;
	}						
	var paramsList =val+'%';
	var targetFields = 'sowName,version';
	sowPopupobj=openPopup("<%=request.getContextPath()%>",qid,paramsList,targetFields,null);
	return true;
			
}	

//This function is used to add a row to the milestone list
function addMilestone(mode)
{
	var maxCount = document.getElementById('rowCount').value;
	var delCount = 0;
	var index = 0;
	var strAppend='';
	var prevStrAppend='';
	var rowClass='thead';
	var disbleValue='';
	var cls='';
	var chkboxDisable='';
	var textColor='';
	/*if(maxCount>2 && mode!='remove')
	{
		strAppend='<div id="uploadStatusList" style="width: 100%;height:120;overflow: auto; border: 4px">';
	}
	else if(mode!='remove')
	{
		strAppend='<div id="uploadStatusList" style="width: 100%;height:0;overflow: auto; border: 4px">';
	}*/
	strAppend+='<table width=100% CELLPADDING=\"2\" CELLSPACING=\"0\" border=\"0\" id=\"mileTable\">';
	var path = '<%=request.getContextPath()%>';
	strAppend+='<tr class=\"'+rowClass+'\">';
	strAppend+='<td colspan=\"\" align=\"center\">&nbsp;</td>';
	strAppend+='<td align=\"center\">Milestone Name <font color="red"><bean:message key="label.starSign"/></font></td>';
	strAppend+='<td  align=\"center\">Milestone Amount <font  color="red"><bean:message key="label.starSign"/></font></td>';
	strAppend+='<td  align=\"center\">Milestone Remark <font  color="red"><bean:message key="label.starSign"/></font></td>';
	strAppend+='<td  align=\"center\">Milestone Date <font  color="red"><bean:message key="label.starSign"/></font></td>';
	strAppend+='</tr>';	
	strAppend+='<tr class=\"trow\">';
	strAppend+='<td>';
	strAppend+='<input type=\"checkbox\"  id=\"chkAll\" value=\"\"   onclick=\"unSelectAll();\">';	
	strAppend+='</td>'
	strAppend+='<td colspan=\"4\">';	
	strAppend+='<bean:message key="label.unSelectAll"/>';
	strAppend+='</td>'
	strAppend+='</tr>';
	for(var i=0;i<maxCount;i++)
	 {  
	    var mName = document.getElementById('milestoneList['+i+'].milestoneName').value;
	    var mAmount = document.getElementById('milestoneList['+i+'].milestoneAmount').value;
	    var mRemark = document.getElementById('milestoneList['+i+'].milestoneRemark').value;
	    var mDate = document.getElementById('milestoneList['+i+'].milestoneDate').value;
	    if(mode=='remove' && document.getElementById('chk'+i).checked==true)
	    {
		    delCount++;		   
		}
		else
		{
		    
		    strAppend+='<tr>';
			strAppend+='<td>';
			 if(document.getElementById('chk'+i).disabled==true)
			 {
			 	chkboxDisable='disabled=\"disabled\"';
			 	disbleValue='readonly=\"readonly\"';
			 	cls='class=\"disabledformtextField\"';
			 }
			 else
			 {
			 	chkboxDisable='';
			 	disbleValue='';
			 	cls='';
			 }
			if(document.getElementById('chk'+i).checked==true)
			 {
				strAppend+='<input type=\"checkbox\" '+chkboxDisable+'  id=\"chk'+index+'\" checked=\"checked\" onclick=\"return uncheckedSelectAll();\"/></td>';
			 }
			else
			 {
			    strAppend+='<input type=\"checkbox\" '+chkboxDisable+'  id=\"chk'+index+'\" onclick=\"return uncheckedSelectAll();\"/></td>';
			 }
			strAppend+='<td align=\"center\">';
			strAppend+='<input type=\"text\" '+disbleValue+' '+cls+' title=\"Milestone Name\" maxlength=\"100\" id=\"milestoneList['+index+'].milestoneName\" value=\"'+mName+'\"  name=\"milestoneList['+index+'].milestoneName\" onchange="\enableUpdate();return chkSemicolonChar(this);\">';
			strAppend+='</td>';
			strAppend+='<td align=\"center\">';
			strAppend+='<input type=\"text\" '+disbleValue+' '+cls+' title=\"Milestone Amount\" maxlength=\"10\" id=\"milestoneList['+index+'].milestoneAmount\" value=\"'+mAmount+'\" name=\"milestoneList['+index+'].milestoneAmount\"  onchange=\"enableUpdate();return milestoneAmountChk(this);\">';
			strAppend+='</td>';
			strAppend+='<td align=\"center\">';
			strAppend+='<input type=\"text\" '+disbleValue+' '+cls+' title=\"Milestone Remark\" maxlength=\"50\" id=\"milestoneList['+index+'].milestoneRemark\" value=\"'+mRemark+'\" name=\"milestoneList['+index+'].milestoneRemark\"  onchange="\enableUpdate();return chkSemicolonChar(this);\">';
			strAppend+='</td>';
			strAppend+='<td align=\"center\">';
			strAppend+='<input type=\"text\" class="disabledformtext" title=\"Milestone Date\"  size="12" readonly="true" id=\"milestoneList['+index+'].milestoneDate\" value=\"'+mDate+'\"  name=\"milestoneList['+index+'].milestoneDate\" value=\"'+mDate+'\" onchange=\"enableUpdate();\" >';
			strAppend+='<input type=\"image\"  '+disbleValue+' id=\"creationDateTimePicker\"	src=\"'+path+'/images/calendar.jpg\" alt=\"Pick a date\" onclick=\"javascript:NewCal(\'milestoneList['+index+'].milestoneDate\',\'ddmmmyyyy\',false,12);enableUpdate();return false;\" />';
			strAppend+='</td>';
			strAppend+='</tr>';
			index++;
		}	
	 }
	 if(mode=='remove' && delCount==0)
	 {
	 	alert('Please select a record to delete');
	 	return false;
	 } 
	 else if(mode=='remove' && delCount>0)
	 {
	    if(!confirm('Are you sure to delete the selected records?'))
	    {
	       return false;
	    }
	 }	 
	 maxCount = maxCount-delCount;
	 if((mode!='remove' && maxCount< parseInt('<%=Constants.maxRecordLimit%>'))|((mode=='remove')&&(maxCount==0)))
	 {
		var mileStoneName='';
		var mileStoneAmount='';
		var mileStoneRemark='';
		var mileStoneDate='';		
		 if((mode=='remove')&&(maxCount==0))
		 {
		 		 mileStoneName = 'Enter milestone';
		 		 mileStoneAmount = '0';
		 		 mileStoneRemark = 'Enter remark';
		 		 mileStoneDate = '11-May-2010';
		 		 //textColor='STYLE="color: #A9D0F5;"';
		 }
		 
 		 strAppend+='<tr>';
		 strAppend+='<td>';
		 strAppend+='<input type=\"checkbox\" id=\"chk'+maxCount+'\" onclick=\"return uncheckedSelectAll();\"/></td>';
		 strAppend+='<td align=\"center\">';
		 strAppend+='<input type=\"text\" value=\"'+mileStoneName+'\" '+textColor+' title=\"Milestone Name\" maxlength=\"100\" id=\"milestoneList['+maxCount+'].milestoneName\"  name=\"milestoneList['+maxCount+'].milestoneName\" onchange=\"enableUpdate();return chkSemicolonChar(this);\">';
		 strAppend+='</td>';
		 strAppend+='<td align=\"center\">';
		 strAppend+='<input type=\"text\" value=\"'+mileStoneAmount+'\" '+textColor+' title=\"Milestone Amount\" maxlength=\"10\" id=\"milestoneList['+maxCount+'].milestoneAmount\"  name=\"milestoneList['+maxCount+'].milestoneAmount\" onchange=\"enableUpdate();return milestoneAmountChk(this);\">';
		 strAppend+='</td>';
		 strAppend+='<td align=\"center\">';
		 strAppend+='<input type=\"text\" value=\"'+mileStoneRemark+'\" '+textColor+' title=\"Milestone Remark\" maxlength=\"50\" id=\"milestoneList['+maxCount+'].milestoneRemark\"  name=\"milestoneList['+maxCount+'].milestoneRemark\" onchange=\"enableUpdate();return chkSemicolonChar(this);\">';
		 strAppend+='</td>';
		 strAppend+='<td align=\"center\">';
		 strAppend+='<input type=\"text\" value=\"'+mileStoneDate+'\" '+textColor+' class="disabledformtext" title=\"Milestone Date\"   size="12" readonly="true" id=\"milestoneList['+maxCount+'].milestoneDate\" name=\"milestoneList['+maxCount+'].milestoneDate\" onchange=\"enableUpdate();\">';
		 strAppend+='<input type=\"image\" id=\"creationDateTimePicker\" src=\"'+path+'/images/calendar.jpg\" alt=\"Pick a date\" onclick=\"javascript:NewCal(\'milestoneList['+maxCount+'].milestoneDate\',\'ddmmmyyyy\',false,12);enableUpdate();return false;\" />';
		 strAppend+='</td>';
		 strAppend+='</tr>';
		 strAppend+='</table>';
		 
	
		 document.getElementById('rowCount').value = ++maxCount;
	 }
	 else
	 {
	 	document.getElementById('rowCount').value = maxCount;
	 	if(mode!='remove')
	 	{
	 		alert('You cannot add beyond'+' <%=Constants.maxRecordLimit%>'+' records');
			document.getElementById('addBttn').disabled=true;	
	 	}
	 	else
	 	{
	 		document.getElementById('addBttn').disabled=false;	
	 	}
	 }
	/*if(maxCount<4 && mode=='remove')
	{
		prevStrAppend='<div id="uploadStatusList" style="width: 100%;height:0;overflow: auto; border: 4px">';
	}
	else if(maxCount>3 && mode=='remove')
	{
		prevStrAppend='<div id="uploadStatusList" style="width: 100%;height:120;overflow: auto; border: 4px">';
	}*/
	prevStrAppend+=strAppend;
	document.getElementById('cloneTable').innerHTML=prevStrAppend;
	calculateTotalAmount();
	addMileListLength=maxCount;
	 
}

//This function is used tocheck the milestone amount
function milestoneAmountChk(obj)
{
	if(isValidNumber(obj,7,2,''))
	{
		calculateTotalAmount();
	}
	else
	{
		calculateTotalAmount();
		return false;
	}
	return true;
}

//This function is used calculate the total milestone amount
function calculateTotalAmount()
{
	var count = document.getElementById('rowCount').value;
	var amntTotal=0;
	for(var i=0;i<count;i++)
	{          
	     var amntVal=document.getElementById('milestoneList['+i+'].milestoneAmount').value;
	     if(amntVal=='')
	     {
	     	amntVal=0;
	     }
	     amntTotal=parseFloat(amntTotal)+parseFloat(amntVal);
	}
	document.getElementById('intialAmount').style.display='none';
	document.getElementById('calculatedAmount').style.display='block';
	document.getElementById('totalAmount').innerHTML=amntTotal.toFixed(2);
	document.sowForm.amount.value=amntTotal.toFixed(2);
	var total=amntTotal.toFixed(2).toString();
	total=appendCommaInAmount(total);
	document.getElementById('totalAmount').innerHTML=total;
	return true;
}
//This function is used to append the comma to the amount
function appendCommaInAmount(amount)
{
	if(amount.match(/[.]/))
	{
	    amount=amount.split('.');
	  	var digitCount=0;
		var temp='';
		var k=3;
		for(var i=amount[0].length-1;i>=0;i--)
		{
			if(digitCount==k)
			{
			temp=','+temp;
			k=digitCount+2;
			}
			temp=amount[0].charAt(i)+temp;
			digitCount=digitCount+1;
		}
		amount=temp+'.'+amount[1];
	}
	return amount;
}

//This function is used to checked all the text boxes
function uncheckedSelectAll()
{
	var count = document.getElementById('rowCount').value;
	var chkAllBox=document.getElementById('chkAll');
	if(chkAllBox.checked==true)
	{
		for(i=0;i<count;i++)
		{
			var chkBoxObj=document.getElementById('chk'+i);
			if(chkBoxObj.checked==false)
			{
				chkAllBox.checked=false;
				break;
			}
		}
	}
	return true;
}


//This function is used to unchecked all the selectAll text boxes
function unSelectAll()
{
	var chkAllBox=document.getElementById('chkAll');
	var count = document.getElementById('rowCount').value;
	if(chkAllBox.checked==true)
	{
		for(i=0;i<count;i++)
		{
			if(document.getElementById('chk'+i).disabled==false)
			{
				document.getElementById('chk'+i).checked=true;
			}
			
		}
	}
	else
	{
		for(i=0;i<count;i++)
		{
			document.getElementById('chk'+i).checked=false;
		}
	}
}

//This function is used to check the specialChar and No in the textField
function chkSpecialCharandNo(obj)
{
	var iChars = "!@#$%^&*()+=[]\\\;,./{}|\":<>0123456789";
		for (var i = 0; i < obj.value.length; i++)
		{
	  		if (iChars.indexOf(obj.value.charAt(i)) != -1)
	  		{
	  			alert ("Specials Characters and numbers are not allowed.");
				obj.value='';
				obj.focus();
	  			return false;
  			}
  			
  		}
  	return true;	
}


//This function is used to check the semicolon in the textField
function chkSemicolonChar(obj)
{
	obj.value=trimVal(obj.value);
	var iChars = ";";
		for (var i = 0; i < obj.value.length; i++)
		{
	  		if (iChars.indexOf(obj.value.charAt(i)) != -1)
	  		{
	  			alert ("Semicolon is not allowed.");
				obj.value='';
				obj.focus();
	  			return false;
  			}
  			
  		}
  	return true;	
}

//This function is used to restrict the enter key.
function chkent(){
	alert("Enter key not allowed.");
	return false;
}
//This function is used to restrict the textlimit of textArea.
function textLimit(field, maxlen) 
{
	if (field.value.length > maxlen + 1)
	{
		alert('your input has been truncated!');
	}
	if (field.value.length > maxlen)
	{
		field.value = field.value.substring(0, maxlen);
	}
} 
//This function is used to enable the Update button
function enableUpdate()
{
	if(document.getElementById('update')!=null)
	{
		document.getElementById('update').disabled=false;
	}
	
}

//This function is used to disable the fields
function disableAll()
{
	callFlag=1;
	document.sowForm.sowName.disabled=true;
	//document.sowForm.version.disabled=true;
	document.getElementById('populateButton').disabled=true;
	document.getElementById('resetButton').disabled=true;
}

//This function is used to  get Sow Details
function getSowDetails()
{
	var flag=true;
	var sowName=document.sowForm.sowName.value;
	var sowVersion=document.sowForm.version.value;
	if(sowPopupobj!=null)
	{
		sowPopupobj.close();
	}
	if(sowName=='')
	{
		alert('Please enter Sow Name');
		document.sowForm.sowName.focus();
		flag=false;
		document.getElementById('populateButton').disabled=false;
		return flag;
	}
	if(sowVersion=='')
	{
		alert('Please enter Version');
		document.sowForm.version.focus();
		flag=false;
		document.getElementById('populateButton').disabled=false;
		return flag;
	}
	if(flag)
	{
		document.forms(0).action='<%=request.getContextPath()%>/sow.do?method=getSOWDetails';
		document.forms(0).submit();
	}
	return true;
}

//This function is used to  edit Sow Details
function editSowDetails()
{
	var count = document.getElementById('rowCount').value;
	var fieldList='preparedBy,programMgr,sowType,sowCreationDate,approving,itpm,authoriser,';
	var mstoneName='';
	var mstoneAmount='';
	var mstoneRemark='';
	var mstoneDate='';
	var mileStoneList='';
	for(i=0;i<count;i++)
	{
		if(document.getElementById('chk'+i).disabled==false)
		{
			mileStoneList+='milestoneList['+i+'].milestoneName,';
			mileStoneList+='milestoneList['+i+'].milestoneAmount,';
			mileStoneList+='milestoneList['+i+'].milestoneRemark,';
			mileStoneList+='milestoneList['+i+'].milestoneDate,';
		}
	}
	fieldList+=mileStoneList;
	fieldList+='remarks';
	var fieldArray=fieldList.split(',');
	if(addMileListLength==0)
	{
		addMileListLength=document.getElementById('rowCount').value;
	}
	if(!validate('sowForm',fieldArray))
	{
		document.getElementById('update').disabled=false;	
		return false;
	}
	document.sowForm.source.value='E';
	document.forms(0).action='<%=request.getContextPath()%>/sow.do?method=createSOW&maxLength='+addMileListLength;
	document.forms(0).submit();
	return true;
}
//This function is called on click of enter
function toCall()
{
	if(document.getElementById('populateButton').disabled==false)
	{
			return getSowDetails();	
	}
	else
	{
		return editSowDetails();
	}
}

//This function is used to reset the form
function resetField()
{
	document.forms(0).action='<%=request.getContextPath()%>/sow.do?method=showEditSowPage';
	document.forms(0).submit();
}


</SCRIPT>

</head>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="5" bottommargin="20">
<html:form action="sow.do" method="post" enctype="multipart/form-data">
	<input type="image"   src="" height="0px" width="0px"   onclick="return toCall();" > 
	<html:hidden name="sowForm" property="source"/>
	<html:hidden name="sowForm" property="amount"/>	
	<table width="90%" cellpadding="2" cellspacing="0" border="0">
		<tr class="thead">
			<td colspan="4" align=center>
			<b><font size="2"><bean:message key="label.editStatementOfWork"/></font></b>
			</td>
		</tr>
		<tr class="trow">
			<td colspan="4">&nbsp;</td>
		</tr>
		<logic:notEmpty name="sowForm" property="errorFlag">
			<tr class="trow">
				<td colspan="5" align="center">
					<logic:equal value="T" name="sowForm" property="errorFlag">
						<font  color="green">
							<strong>
								<bean:write name="sowForm" property="errorMessage"/>
							</strong>
						</font>
					</logic:equal>
					<logic:equal value="F" name="sowForm" property="errorFlag">
						<font  color="red">
							<strong>
								<bean:write name="sowForm" property="errorMessage"/>
							</strong>
						</font>
					</logic:equal>
				</td>
			</tr>
		</logic:notEmpty>
		
		<tr class="trow">
				<td colspan="4" align="right">
				<font  color="red"><bean:message key="label.starSign"/>
				<bean:message key="label.areMandatory"/>
				</font>&nbsp;&nbsp;&nbsp;<br>&nbsp;
				</td>
	 		</tr>
			
			<!-- <tr class="trow">
				<td class="trow" rowspan="7">&nbsp;</td>
			</tr>-->
		
		<tr class="trow">
			<td align="center">
				<bean:message key="label.sowName"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
			</td>
			<td>
				<html:text name="sowForm" property="sowName" size="30" maxlength="200" onchange="getSOWVersionPopUp(this.value);return false;"/> 
				<input type="image"	src="<%=request.getContextPath()%>/images/glass.png" alt="Search SOW" onclick="if(callFlag==0)getSOWVersionPopUp(sowName.value);return false;"/>
			</td>
			<td ><bean:message key="label.version"/>
			<font  color="red"><bean:message key="label.starSign"/></font>
			</td>
			<td>
				<html:text name="sowForm" property="version" size="20"	maxlength="5" onchange="enableUpdate();return isValidNumber(this,3,2,'');"/>
			</td>
		</tr>
		<tr class="trow">
			<td colspan="4">&nbsp;
			</td>
		</tr>
		<tr class="thead">
			<td colspan="4" align="center">
				<input type="button" class="sbttn"  id="populateButton" value="Populate" onclick="this.disabled=true;return getSowDetails();">
				<input type="button" class="sbttn" id="resetButton" value="Reset" onclick="resetField();">
			</td>
		</tr>
		
		<tr>
			<td colspan="5">
				<logic:notEmpty name="sowForm" property="status">
				<script>disableAll();</script>
				<table width="100%" cellpadding="2" cellspacing="0" border="0">
							<logic:equal value="success" name="sowForm" property="status">
								<tr class="trow">
									<td colspan="4" align="right">
									<a href="<%=request.getContextPath()%>/sow.do?method=getUploadedFile"><b><font color="blue">Download File</font></b></a>
									&nbsp;&nbsp;&nbsp;&nbsp;</td>
								</tr>
								<tr class="trow">
									<td >
									<bean:message key="label.preparedBy"/><font  color="red"><bean:message key="label.starSign"/></font>
									</td>
									<td nowrap="nowrap">
										<html:text property="preparedBy" size="20" maxlength="20" title="Prepared By" onchange="enableUpdate();return chkSpecialCharandNo(this);"/>
									</td>
									<td ><bean:message key="label.programManager"/>
									<font  color="red"><bean:message key="label.starSign"/></font>
									</td>
									<td>
									<html:select property="programMgr" name="sowForm" title="Program Manager">
										<html:option value="">--Select--</html:option>
										 <logic:notEmpty name="sowForm" property="programMgrList">
										   <html:optionsCollection  name="sowForm" property="programMgrList" value="value" label="label"/>		 
										</logic:notEmpty>
									</html:select>
									</td>
								</tr>
								
								<tr class="trow">
									<td >
										<bean:message key="label.sowType"/><font  color="red"><bean:message key="label.starSign"/></font>
									</td>
									<td>
										<html:select property="sowType" name="sowForm" title="SOW Type" onchange="enableUpdate();">
											<html:option value="">--Select--</html:option>
											<logic:notEmpty name="sowForm" property="sowTypeList">
												<html:optionsCollection name="sowForm" property="sowTypeList" value="value" label="label"/>
											</logic:notEmpty>	
										</html:select>
									</td>
									<td>
										<bean:message key="label.dateofSow"/><font  color="red"><bean:message key="label.starSign"/></font>
									</td>
									<td>
										<html:text property="sowCreationDate"	name="sowForm" size="11" readonly="true" styleClass="disabledformtext" title="Date of Sow" onchange="enableUpdate();"/> 
										<input type="image"	id="creationDateTimePicker"	src="<%=request.getContextPath()%>/images/calendar.jpg"	alt="Pick a date" onclick="javascript:NewCal('sowCreationDate','ddmmmyyyy',false,12);enableUpdate();return false;" />
									</td>
								</tr>
								
								<tr class="trow">
									<td>
										<bean:message key="label.browseFile"/>
									</td>
									<td>
										<html:file name="sowForm" property="browseFile" title="file" alt="Browse" styleClass="disabledformtext"  onkeydown="return enableKey();" onchange="enableUpdate();"/>
									</td>
									<td>
										<bean:message key="label.approvingAuthority"/><font  color="red"><bean:message key="label.starSign"/></font>
									</td>
									<td>
										 <html:select property="approving" name="sowForm" title=" Approving authority" onchange="enableUpdate();">
											<html:option value="">--Select--</html:option>
											<logic:notEmpty property="approvingList" name="sowForm">
												<html:optionsCollection name="sowForm" property="approvingList" value="value" label="label"/>
											</logic:notEmpty>
										</html:select>
									</td>
								</tr>
								<tr class="trow">
									
									<td>
										<bean:message key="label.iTPM"/><font  color="red"><bean:message key="label.starSign"/></font>
									</td>
									<td>
										<html:select property="itpm" name="sowForm" title=" IT PM " onchange="enableUpdate();">
											<html:option value="">--Select--</html:option>
											<logic:notEmpty property="itpmList" name="sowForm">
												<html:optionsCollection name="sowForm" property="itpmList" value="value" label="label"/>
											</logic:notEmpty>
										</html:select>
									</td>
									<td>
										<bean:message key="label.authoriser"/><font  color="red"><bean:message key="label.starSign"/></font>
									</td>
									<td>
										<html:select property="authoriser" name="sowForm" title=" Authoriser" onchange="enableUpdate();">
											<html:option value="">--Select--</html:option>
											<logic:notEmpty property="authoriserList" name="sowForm">
												<html:optionsCollection name="sowForm" property="authoriserList" value="value" label="label"/>
											</logic:notEmpty>
										</html:select>
									</td>
								</tr>
									<tr class="trow">
										<td colspan="4">
										<%int listSize=0;%>
										<div id='cloneTable'>
										<logic:notEmpty name="sowForm" property="milestoneDetailsList">
										<%-- <logic:greaterThan value="2" property="listSize" name="sowForm">
										 	<div id="uploadStatusList" style="width: 100%;height:120;overflow: auto; border: 4px">
										 </logic:greaterThan>
										<logic:lessEqual value="2" property="listSize" name="sowForm">
											<div id="uploadStatusList" style="width: 100%;height:0;overflow: auto; border: 4px">
										</logic:lessEqual>--%>
											<table width="100%" cellpadding="2" cellspacing="0" border="0">
												<tr align="left" class="thead">
													<td  >&nbsp;</td>
													<td align="center"><bean:message key="label.milestoneName"/>
													<font  color="red"><bean:message key="label.starSign"/></font>
													</td>
													<td align="center"><bean:message key="label.milestoneAmount"/>
													<font  color="red"><bean:message key="label.starSign"/></font>
													</td>
													<td align="center"><bean:message key="label.milestoneRemark"/>
													<font  color="red"><bean:message key="label.starSign"/></font>
													</td>
													<td align="center"><bean:message key="label.milestoneDate"/>
													<font  color="red"><bean:message key="label.starSign"/></font>
													</td>
												</tr>					
												<tr class="trow">
													<td><input type="checkbox" id="chkAll" onclick="unSelectAll();"/></td>
													<td colspan="4">
														<bean:message key="label.unSelectAll"/>
													</td>
												</tr>
												<bean:define name="sowForm" property="milestoneDetailsList" id="mileList" type="java.util.ArrayList"/>
												<%listSize=mileList.size(); %>
												<logic:iterate id="milestoneDetails" name="sowForm" property="milestoneDetailsList" indexId="count">
													<logic:equal value="U" name="milestoneDetails" property="billStatus">
														<tr class="trow">
														<td>
														<input type="checkbox" id="chk<%=count%>" onclick="return uncheckedSelectAll();">
														</td>
														<td align="center">								
														<input type="text" title="Milestone Name" maxlength="100" id="milestoneList[<%=count%>].milestoneName" name="milestoneList[<%=count%>].milestoneName"  value="<bean:write name="milestoneDetails" property="milestoneName"/>" onchange="enableUpdate();return chkSemicolonChar(this);">
														</td>
														<td align="center">
														<input type="text" title="Milestone Amount" id="milestoneList[<%=count%>].milestoneAmount" maxlength="10" name="milestoneList[<%=count%>].milestoneAmount"  value="<bean:write name="milestoneDetails" property="milestoneAmount"/>" onchange="enableUpdate();return milestoneAmountChk(this);">
														</td>
														<td align="center">
														<input type="text" title="Milestone Remark" maxlength="50" id="milestoneList[<%=count%>].milestoneRemark"  name="milestoneList[<%=count%>].milestoneRemark"  value="<bean:write name="milestoneDetails" property="milestoneRemark"/>" onchange="enableUpdate();return chkSemicolonChar(this);">
														</td>
														<td align="center">
														<input type="text" class="disabledformtext" title="Milestone Date" size="12" readonly="true" id="milestoneList[<%=count%>].milestoneDate" onchange="enableUpdate();" name="milestoneList[<%=count%>].milestoneDate" value="<bean:write name="milestoneDetails" property="milestoneDate"/>">
														<input type="image"	id="creationDateTimePicker"	src="<%=request.getContextPath()%>/images/calendar.jpg"	alt="Pick a date" onclick="avascript:NewCal('milestoneList[<%=count%>].milestoneDate','ddmmmyyyy',false,12);enableUpdate();return false;" />
														</td>
														</tr>
													</logic:equal>
													
													<logic:equal value="WIP" name="milestoneDetails" property="billStatus">
														<tr class="trow">
														<td>
														<input type="checkbox" disabled="disabled"  id="chk<%=count%>" onclick="return uncheckedSelectAll();">
														</td>
														<td align="center">								
														<input type="text" readonly="readonly" class="disabledformtextField" title="Milestone Name" maxlength="100" id="milestoneList[<%=count%>].milestoneName" name="milestoneList[<%=count%>].milestoneName"  value="<bean:write name="milestoneDetails" property="milestoneName"/>" onchange="enableUpdate();return chkSemicolonChar(this);">
														</td>
														<td align="center">
														<input type="text" readonly="readonly" class="disabledformtextField" title="Milestone Amount" id="milestoneList[<%=count%>].milestoneAmount" maxlength="10" name="milestoneList[<%=count%>].milestoneAmount"  value="<bean:write name="milestoneDetails" property="milestoneAmount"/>" onchange="enableUpdate();return milestoneAmountChk(this);">
														</td>
														<td align="center">
														<input type="text" readonly="readonly" class="disabledformtextField" title="Milestone Remark" maxlength="50" id="milestoneList[<%=count%>].milestoneRemark"  name="milestoneList[<%=count%>].milestoneRemark"  value="<bean:write name="milestoneDetails" property="milestoneRemark"/>" onchange="enableUpdate();return chkSemicolonChar(this);">
														</td>
														<td align="center">
														<input type="text" class="disabledformtext" title="Milestone Date" size="12" readonly="true" id="milestoneList[<%=count%>].milestoneDate" onchange="enableUpdate();" name="milestoneList[<%=count%>].milestoneDate" value="<bean:write name="milestoneDetails" property="milestoneDate"/>">
														<input type="image" disabled="disabled"	id="creationDateTimePicker"	src="<%=request.getContextPath()%>/images/calendar.jpg"	alt="Pick a date" onclick="avascript:NewCal('milestoneList[<%=count%>].milestoneDate','ddmmmyyyy',false,12);enableUpdate();return false;" />
														</td>
														</tr>
													</logic:equal>
													
													
													
												</logic:iterate>
											</table>
										</logic:notEmpty>
										</div>
											<tr id="totalValue" class="trow">
											<td colspan="5">
												<table width="100%"  CELLPADDING="2" CELLSPACING="0" border="0">
													<tr class="trow">
														<td width="9%">&nbsp;
														</td>
														<td width="25%">
															<b><bean:message key="label.totalAmount"/></b>
														</td>
														<td id="intialAmount">
															<b><div id='intialTotalAmount'></div></b>
															<%--<b><bean:write name="sowForm" property="amount"/></b>--%>
														</td>
														<td id="calculatedAmount" style="display: none;">
															<b><div id='totalAmount'></div></b>
														</td>
														<td>&nbsp;
														</td>
													</tr>
												</table>
											</td>
											</tr>
											<tr class="trow">
												<td colspan="4"><input type="hidden" name="rowCount" id='rowCount' value="<%=listSize%>"/>
												<input type="button" class="sbttn" id="addBttn" value="Add Row" onclick="enableUpdate(); addMilestone('');"/>
												<input type="button" class="sbttn" value="Delete Row" onclick="enableUpdate();addMilestone('remove');"/>
												<br>&nbsp;
												</td>
											</tr>
										</td>
									</tr>
									
								<%--<tr id="totalValue" style="display: none;" class="trow">
								<td colspan="4">
									<table width="100%"  CELLPADDING="2" CELLSPACING="0" border="0">
										<tr class="trow">
											<td width="9%">&nbsp;
											</td>
											<td width="25%">
												<b><bean:message key="label.totalAmount"/></b>
											</td>
											<td>
												<b><div id='totalAmount'></div></b>
											</td>
											<td>&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>--%>
							
							<tr class="trow">
								<td align="right" width="20%"><bean:message key="label.remark"/><font  color="red"><bean:message key="label.starSign"/></font>
								</td>
								<td colspan="3" align="center">
								<html:textarea rows="5" cols="60"   name="sowForm"  property="remarks" title="Remark" 
								onkeypress="if (event.keyCode == 13) return chkent();" onkeyup="return textLimit(this,1000);" onchange="enableUpdate();"/>
								</td>
							</tr>
							<tr class="trow">
								<td colspan="4">&nbsp;</td>
							</tr>
							 </logic:equal>
							 
							 <logic:equal value="failure" name="sowForm" property="status">
							 	<tr class="trow">
							 		<td colspan="4" align="center"><br>&nbsp;
							 		<font size=2><bean:write name="sowForm" property="errorMessage"/></font><br>&nbsp;
							 		</td>
							 	</tr>
							 </logic:equal>
							
							<tr class=thead>
								<td colspan="4" align="center">&nbsp;&nbsp;
								<input type="button" class="sbttn"  id="update" disabled="disabled" value="Update" onclick="this.disabled=true;editSowDetails();">
								<input type="button" class="sbttn"  value="Cancel" onclick="return resetField();">
								</td>
							</tr>
						    </table>
					</logic:notEmpty>
			</td>
		</tr>
		
	</table>
	
	
</html:form>
</body>
</html:html>
<!-- scripted added to append comma in Amount -->
<script type="text/javascript">
	var amntTotal=0;
    var initTotalAmnt=document.sowForm.amount.value;
	amntTotal=parseFloat(initTotalAmnt)+parseFloat(amntTotal);
	var total=amntTotal.toFixed(2).toString();
	total=appendCommaInAmount(total);
	if(document.getElementById('intialTotalAmount')!=null){
	
	document.getElementById('intialTotalAmount').innerHTML=total;
	}
</script>


<%}catch(Exception e)
{
		e.printStackTrace();
}
%>

		
	