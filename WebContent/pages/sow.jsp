<!--
 * JSP
 *
 *  Name        :sow.jsp
 * Action Class :SowAction.java  
 * Form Class   :SowForm.java 
 * This function will be used to 
 *
 * <p>
 * <b>Revision History:</b><pre>
 * ===========================================================================================================================
 *                            Prior
 * Date       By              Version  	Description
 * ---------- --------------- -------  ---------------------------------------------------------------------------------------
 * 
 * ===========================================================================================================================
 * </pre>
 *
 
-->
<%@page import="com.vsnl.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>

<html:html locale="true">
<head>
<title>Create Statement of work page</title>
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
//This function is used to add a row to the milestone list
function addMilestone(mode)
{
	
	var maxCount = document.getElementById('rowCount').value;
	var delCount = 0;
	var index = 0;
	var strAppend='';
	var prevStrAppend='';
	var rowClass='thead';
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
	strAppend+='<td  align=\"center\">Milestone Remark</td>';
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
			if(document.getElementById('chk'+i).checked==true)
			 {
				strAppend+='<input type=\"checkbox\" id=\"chk'+index+'\" checked=\"checked\" onclick=\"return uncheckedSelectAll();\"/></td>';
			 }
			else
			 {
			    strAppend+='<input type=\"checkbox\" id=\"chk'+index+'\" onclick=\"return uncheckedSelectAll();\"/></td>';
			 } 
			strAppend+='<td align=\"center\">';
			strAppend+='<input type=\"text\" title=\"Milestone Name\" maxlength=\"100\" id=\"milestoneList['+index+'].milestoneName\" value=\"'+mName+'\"  name=\"milestoneList['+index+'].milestoneName\" value=\"'+mName+'\" onchange=\"return chkSemicolonChar(this);\">';
			strAppend+='</td>';
			strAppend+='<td align=\"center\">';
			strAppend+='<input type=\"text\" title=\"Milestone Amount\" maxlength=\"10\" id=\"milestoneList['+index+'].milestoneAmount\" value=\"'+mAmount+'\" name=\"milestoneList['+index+'].milestoneAmount\" value=\"'+mAmount+'\" onchange=\"return milestoneAmountChk(this);\">';
			strAppend+='</td>';
			strAppend+='<td align=\"center\">';
			strAppend+='<input type=\"text\" title=\"Milestone Remark\" maxlength=\"50\" id=\"milestoneList['+index+'].milestoneRemark\" value=\"'+mRemark+'\" name=\"milestoneList['+index+'].milestoneRemark\" value=\"'+mRemark+'\" onchange=\"return chkSemicolonChar(this);\">';
			strAppend+='</td>';
			strAppend+='<td align=\"center\">';
			strAppend+='<input type=\"text\" class="disabledformtext" title=\"Milestone Date\"  size="12" readonly="true" id=\"milestoneList['+index+'].milestoneDate\" value=\"'+mDate+'\"  name=\"milestoneList['+index+'].milestoneDate\" value=\"'+mDate+'\" >';
			strAppend+='<input type=\"image\" id=\"creationDateTimePicker\"	src=\"'+path+'/images/calendar.jpg\" alt=\"Pick a date\" onclick=\"javascript:NewCal(\'milestoneList['+index+'].mileStoneDate\',\'ddmmmyyyy\',false,12);return false;\" />';
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
	 if((mode!='remove' && maxCount<parseInt('<%=Constants.maxRecordLimit%>'))|((mode=='remove')&&(maxCount==0)))
	 {
		 strAppend+='<tr>';
		 strAppend+='<td>';
		 strAppend+='<input type=\"checkbox\" id=\"chk'+maxCount+'\" onclick=\"return uncheckedSelectAll();\"/></td>';
		 strAppend+='<td align=\"center\">';
		 strAppend+='<input type=\"text\" title=\"Milestone Name\" maxlength=\"100\" id=\"milestoneList['+maxCount+'].milestoneName\"  name=\"milestoneList['+maxCount+'].milestoneName\" onchange=\"return chkSemicolonChar(this);\">';
		 strAppend+='</td>';
		 strAppend+='<td align=\"center\">';
		 strAppend+='<input type=\"text\" title=\"Milestone Amount\" maxlength=\"10\" id=\"milestoneList['+maxCount+'].milestoneAmount\"  name=\"milestoneList['+maxCount+'].milestoneAmount\" onchange=\"return milestoneAmountChk(this);\">';
		 strAppend+='</td>';
		 strAppend+='<td align=\"center\">';
		 strAppend+='<input type=\"text\" title=\"Milestone Remark\" maxlength=\"50\" id=\"milestoneList['+maxCount+'].milestoneRemark\"  name=\"milestoneList['+maxCount+'].milestoneRemark\"  onchange=\"return chkSemicolonChar(this);\">';
		 strAppend+='</td>';
		 strAppend+='<td align=\"center\">';
		 strAppend+='<input type=\"text\" class="disabledformtext" title=\"Milestone Date\"   size="12" readonly="true" id=\"milestoneList['+maxCount+'].milestoneDate\" name=\"milestoneList['+maxCount+'].milestoneDate\">';
		 strAppend+='<input type=\"image\" id=\"creationDateTimePicker\" src=\"'+path+'/images/calendar.jpg\" alt=\"Pick a date\" onclick=\"javascript:NewCal(\'milestoneList['+maxCount+'].mileStoneDate\',\'ddmmmyyyy\',false,12);return false;\" />';
		 strAppend+='</td>';
		 strAppend+='</tr>';
		 strAppend+='</table>';
		 strAppend+='</div>';
		 document.getElementById('rowCount').value = ++maxCount;
	 }
	 else
	 {
	 	document.getElementById('rowCount').value = maxCount;
	 	if(mode!='remove')
	 	{
	 		alert('You cannot add beyond'+' <%=Constants.maxRecordLimit%>'+' records');
			document.getElementById('addBttn').disabled=true;	
			document.getElementById('addBttn').style.cursor='not-allowed';
	 	}
	 	else
	 	{
	 		document.getElementById('addBttn').disabled=false;	
	 		document.getElementById('addBttn').style.cursor='';
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
	document.getElementById('totalValue').style.display='block';
	document.sowForm.amount.value=amntTotal.toFixed(2);
	var total=amntTotal.toFixed(2).toString();
	if(total.match(/[.]/))
	{
	    total=total.split('.');
	  	var digitCount=0;
		var temp='';
		var k=3;
		for(var i=total[0].length-1;i>=0;i--)
		{
			if(digitCount==k)
			{
			temp=','+temp;
			k=digitCount+2;
			}
			temp=total[0].charAt(i)+temp;
			digitCount=digitCount+1;
		}
		total=temp+'.'+total[1];
	}
	document.getElementById('totalAmount').innerHTML=total;
	return true;
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
			document.getElementById('chk'+i).checked=true;
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

//This function is used to enable the tab key.
function enableKey()
{
	if(event.keyCode==9)
	{
		return true;
	}
	else
	{
		return false;
	}
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

//This function is used to set the SOW name
var intialValue='';
function setSowName()
{
	
	var sowType=document.sowForm.sowType.value;
	var sowName=document.sowForm.sowName.value;
	if(sowName=='')
	{
		alert('Please enter SowName');
		document.sowForm.sowType.value='';
		document.sowForm.sowName.focus();
		return false;
	}
	else
	{
		if(intialValue=='')
		{
			intialValue=document.sowForm.sowName.value;
		}
		if(sowType=='PCR')
		{ intialValue=document.sowForm.sowName.value
			var qid='getSowName';
			var inParams=intialValue+'_PCR'+'%';
			var targetFields = null;  
			getDetails_ajax(qid,inParams,null);	
			var count =  ajaxResponse.split("!");
			var cnt=count[0].split("~");	
			var ct=cnt[0].split(",");
			   if(ct>0)
			   {
			   	 var nextVal=parseInt(ct)+1;
			   	 document.sowForm.sowName.value=sowName+'_PCR'+nextVal;
			   }
			   else
			   {
			   	document.sowForm.sowName.value=sowName+'_PCR'+1;
			   }
			   	   
		}
		else
		{
			document.sowForm.sowName.value=intialValue;
		}
	}
	return true;
}
 
//This function is used to submit the form and create the sow
function submitForm()
{
	var fieldList='sowName,preparedBy,version,programMgr,sowType,sowCreationDate,browseFile,approving,itpm,authoriser,';
	var count = document.getElementById('rowCount').value;
	var mstoneName='';
	var mstoneAmount='';
	var mstoneRemark='';
	var mstoneDate='';
	var mileStoneList='';
	for(i=0;i<count;i++)
	{
		mileStoneList+='milestoneList['+i+'].milestoneName,';
		mileStoneList+='milestoneList['+i+'].milestoneAmount,';
		//mileStoneList+='milestoneList['+i+'].milestoneRemark,';
		mileStoneList+='milestoneList['+i+'].milestoneDate,';
			
	}
	fieldList+=mileStoneList;
	var fieldArray=fieldList.split(',');
	fieldArray.splice(fieldArray.length-1,1);
	if(addMileListLength==0)
	{
		addMileListLength=document.getElementById('rowCount').value;
	}
	if(!validate('sowForm',fieldArray))
	{
		return false;
	}
	document.sowForm.source.value='C';
	document.forms(0).action='<%=request.getContextPath()%>/sow.do?method=createSOW&maxLength='+addMileListLength;
	document.forms(0).submit();
	return true;
}

//This function is used to reset the form
function resetField()
{
	document.forms(0).action='<%=request.getContextPath()%>/sow.do?method=showCreateSOWPage';
	document.forms(0).submit();
}

</script>

</head>
<%try{%>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="20" bottommargin="20">
	<html:form action="sow.do" method="post" enctype="multipart/form-data">
	
	<html:hidden name="sowForm" property="amount"/>	
	<html:hidden name="sowForm" property="source"/>	
		<table width=90% CELLPADDING="2" CELLSPACING="0" border="0"  >
			<tr class="thead">
				<td colspan="4" align=center>
				<b><font size="2"><bean:message key="label.createSowHeading"/></font></b>
				</td>
			</tr>
	
		    <logic:notEmpty name="sowForm" property="errorFlag">
			<tr class="trow">
				<td colspan="4" align="center"><br>&nbsp;
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
				<td colspan="4" align="right"><br>&nbsp;
				<font  color="red"><bean:message key="label.starSign"/>
				<bean:message key="label.areMandatory"/>
				</font>&nbsp;&nbsp;&nbsp;<br>&nbsp;
				</td>
	 		</tr>
			
		    <tr class="trow">
				<td >&nbsp;&nbsp;<bean:message key="label.sowName"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
				</td>
				<td><html:text property="sowName" size="20"	maxlength="200" title="SOW Name"/></td>
				<td ><bean:message key="label.preparedBy"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
				</td>
				<td><html:text property="preparedBy" size="20" maxlength="20" title="Prepared By" onchange="return chkSpecialCharandNo(this);"/>
				</td>
			</tr>
	
			 <tr class="trow">
				<td >&nbsp;&nbsp;<bean:message key="label.version"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
				</td>
				<td>
					<html:text property="version" size="14" title="Version" maxlength="10" onchange="return isValidNumber(this,3,2,'');"/>
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
				<td >&nbsp;&nbsp;<bean:message key="label.sowType"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
				</td>
				<td>
					<html:select property="sowType" name="sowForm" title="SOW Type" onchange="setSowName();return false;">
						<html:option value="">--Select--</html:option>
						<logic:notEmpty name="sowForm" property="sowTypeList">
							<html:optionsCollection name="sowForm" property="sowTypeList" value="value" label="label"/>
						</logic:notEmpty>	
					</html:select>
				</td>
				<td ><bean:message key="label.dateofSow"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
				</td>
				<td>
				<html:text property="sowCreationDate"	name="sowForm" size="11" readonly="true" styleClass="disabledformtext" title="Date of Sow"/> 
				<input type="image"	id="creationDateTimePicker"	src="<%=request.getContextPath()%>/images/calendar.jpg"	alt="Pick a date" onclick="javascript:NewCal('sowCreationDate','ddmmmyyyy',false,12);return false;" />
				</td>
			</tr>
			<tr class="trow">
				<td >&nbsp;&nbsp;<bean:message key="label.browseFile"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
				</td>
				<td>
				<html:file name="sowForm" property="browseFile" title="file" alt="Browse" styleClass="disabledformtext"  onkeydown="return enableKey();"/>
				</td>
				<td ><bean:message key="label.approvingAuthority"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
				</td>
				<td>
			        <html:select property="approving" name="sowForm" title=" Approving authority">
						<html:option value="">--Select--</html:option>
						<logic:notEmpty property="approvingList" name="sowForm">
							<html:optionsCollection name="sowForm" property="approvingList" value="value" label="label"/>
						</logic:notEmpty>
					</html:select>
				</td>		
			</tr>
			
			<tr class="trow">
			    	<td >&nbsp;&nbsp;<bean:message key="label.iTPM"/>
			    	<font  color="red"><bean:message key="label.starSign"/></font>
			    	</td> 
					<td>						
						<html:select property="itpm" name="sowForm" title="IT PM ">
							<html:option value="">--Select--</html:option>
							<logic:notEmpty property="itpmList" name="sowForm">
								<html:optionsCollection name="sowForm" property="itpmList" value="value" label="label"/>
							</logic:notEmpty>
						</html:select>
					</td>
					<td ><bean:message key="label.authoriser"/>
					<font  color="red"><bean:message key="label.starSign"/></font>
					</td> 
					<td >
						<html:select property="authoriser" name="sowForm" title=" Authoriser ">
							<html:option value="">--Select--</html:option>
							<logic:notEmpty property="authoriserList" name="sowForm">
								<html:optionsCollection name="sowForm" property="authoriserList" value="value" label="label"/>
							</logic:notEmpty>
						</html:select>
					</td>
			</tr>
	
			<tr align="left" class="trow">
				<td align="left" colspan="4">&nbsp;</td>
			</tr>
			<%int listSize=0;%>
		    <tr class="trow">
				<td colspan="4">
				 	<div id='cloneTable'>
				 	<logic:notEmpty name="sowForm" property="milestoneDetailsList">
				 		<bean:define name="sowForm" property="milestoneDetailsList" id="mileList" type="java.util.ArrayList"/>
							<%listSize=mileList.size(); %>
				 		<%--if(listSize>2) {%>
				 			<div id="uploadStatusList" style="width: 100%;height:120;overflow: auto; border: 4px">;
				 		<%}
				 		else
				 		{%>
				 			<div id="uploadStatusList" style="width: 100%;height:0;overflow: auto; border: 4px">';
				 		<%}--%>
				 		
							<table width=100% CELLPADDING="2" CELLSPACING="0" border="0" id="mileTable">
							<tr align="left" class="thead">
								<td  >&nbsp;</td>
								<td align="center"><bean:message key="label.milestoneName"/>
								<font  color="red"><bean:message key="label.starSign"/></font>
								</td>
								<td align="center"><bean:message key="label.milestoneAmount"/>
								<font  color="red"><bean:message key="label.starSign"/></font>
								</td>
								<td align="center"><bean:message key="label.milestoneRemark"/>
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
							<logic:iterate id="milestoneDetails" name="sowForm" property="milestoneDetailsList" indexId="count">
								<tr class="trow">
								<td>
								<input type="checkbox" id="chk<%=count%>" onclick="return uncheckedSelectAll();">
								</td>
								<td align="center">								
								<input type="text" title="Milestone Name" maxlength="100" id="milestoneList[<%=count%>].milestoneName" name="milestoneList[<%=count%>].milestoneName"  value="<bean:write name="milestoneDetails" property="milestoneName"/>" onchange="return chkSemicolonChar(this);">
								</td>
								<td align="center">
								<input type="text" title="Milestone Amount" id="milestoneList[<%=count%>].milestoneAmount" maxlength="10" name="milestoneList[<%=count%>].milestoneAmount"  value="<bean:write name="milestoneDetails" property="milestoneAmount"/>" onchange="return milestoneAmountChk(this);">
								</td>
								<td align="center">
								<input type="text" title="Milestone Remark" maxlength="50" id="milestoneList[<%=count%>].milestoneRemark"  name="milestoneList[<%=count%>].milestoneRemark"  value="<bean:write name="milestoneDetails" property="milestoneRemark"/>" onchange="return chkSemicolonChar(this);">
								</td>
								
								<td align="center">
								<input type="text" class="disabledformtext" title="Milestone Date" size="12" readonly="true" id="milestoneList[<%=count%>].milestoneDate" name="milestoneList[<%=count%>].milestoneDate" value="<bean:write name="milestoneDetails" property="milestoneDate"/>">
								<input type="image"	id="creationDateTimePicker"	src="<%=request.getContextPath()%>/images/calendar.jpg"	alt="Pick a date" onclick="javascript:NewCal('milestoneList[<%=count%>].milestoneDate','ddmmmyyyy',false,12);return false;" />
								</td>
								</tr>
							</logic:iterate>
							</table>
							</logic:notEmpty>
						</div>
				</td>
			</tr>
			<tr id="totalValue" style="display: none;" class="trow">
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
			</tr>
			<tr class="trow">
				<td colspan="4">
				<input type="hidden" name="rowCount" id='rowCount' value="<%=listSize%>"/>
				<input type="button" class="sbttn" id="addBttn" value="Add Row" onclick="addMilestone('')"/>
				<input type="button" class="sbttn" value="Delete Row" onclick="addMilestone('remove')"/>
				<br>&nbsp;
				</td>
			</tr>
			<tr class="trow" >
				<td align="right"  width="20%"><bean:message key="label.remark"/>
				</td>
				<td colspan="3" align="center">
				<html:textarea rows="5" cols="60"   name="sowForm"  property="remarks" title="Remark " 
				onkeypress="if (event.keyCode == 13) return chkent();" onkeyup="return textLimit(this,500);"/>
				</td>
			</tr>
			

			<tr class="trow">
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr class=thead>
				<td colspan="4" align="center">&nbsp;&nbsp;
				<input type="button" class="sbttn"  value="Submit" onclick="submitForm();">
				<input type="button" class="sbttn"  value="Reset" onclick="return resetField();">
			</tr>
		</table>
	</html:form>
	</body>
<%}catch(Exception e)
{
	e.printStackTrace();	
}%>
</html:html>

