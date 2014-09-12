<!--
 * JSP
 *
 * Name: wcr.jsp
 * Action Class : WcrCreateAction.java  
 * Form Class   :WcrForm.java 
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *                            Prior
 * Date       By              Version  	Description
 * ---------- --------------- -------  ----------------------------------------------------
 *
 *
 * ========================================================================================
 * </pre>
 *
 
 
-->
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>

<%
try {
%>
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
<SCRIPT LANGUAGE="JavaScript"
	SRC="<%=request.getContextPath()%>/jscripts/common.js"
	type="text/javascript"></SCRIPT>
<script type="text/javascript">	

function validate_form(form)
{
  var list = new Array('sowName','wonNo','poNo'); 
	if(validate('wcrForm',list)){
		 
		}else {
	return false;
	}
	 document.wcrForm.method.value="getMilestoneDetails";
	 document.wcrForm.flowFlag.value="C";
     document.wcrForm.submit();
	
}

function resetWCR()
	 {
		
		 document.forms(0).action = "<%=request.getContextPath()%>/wcr.do?method=showWcr";
		 document.forms(0).submit();
	 }
	 
	 
function getSOWPopUp(val)
     {
	    
	   var qid = "getSowName";	
	   val=trimVal(val);	
	   var paramsList =val;
	   var targetFields = 'sowName';
	   var postFunc = "getWONList";
	   removeAllOptions(document.getElementById('wonNo'),1);
	   removeAllOptions(document.getElementById('poNo'),1);
	   if(val == "%"){
	   alert("Please enter SOW Name");
	   document.getElementById('sowName').focus();
	   return false;
	   }   
	   openPopup("<%=request.getContextPath()%>",qid,paramsList,targetFields,postFunc);	
	 
  	}
  
   	
 function getWONList(){
	  var sow = document.getElementById('sowName').value;	
	  var  query  = 'PO.getWONList';	
	  var inParams = sow;
	  getDetails_ajax(query, inParams, null);	
	  removeAllOptions(document.getElementById('poNo'),1);
	  popDropDown('wonNo', ajaxResponse);
	  document.getElementById('wonNo').focus();
} 	 

function getPOList(val){
	   var won =val;
	    var sow = document.getElementById('sowName').value;		
	 
	   var  query  = 'PO.getPOList';	
	   var inParams = won+','+sow;
	  
	   getDetails_ajax(query, inParams, null,',');	
	   removeAllOptions(document.getElementById('poNo'),1);
	   popDropDown('poNo', ajaxResponse);
	   document.getElementById('poNo').focus();
}  
function checkUncheckAll(selAllObj)
{
var totalSize=document.getElementById('totalRecords').value;
for(var i=0;i<totalSize;i++)
{

if(selAllObj.checked==true && document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].disabled==false)
document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].checked=true;

else
document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].checked=false;

}
}
function trackSelectAllChk(boolean)
   {
     if(boolean==false)
       {
        document.getElementById('selectAllChk').checked = false;
       }
     else
      {
        return false;
      }  
      
   } 
   
function submitWCR(){
	var totalSize=document.getElementById('totalRecords').value;
	var ind=0;
	var countVar=0;
	var selectedValue=',';
    var fromDate=document.getElementById('fromDate').value;
	var toDate=document.getElementById('toDate').value; 
		 var rtrn = isDateLessThanEqualTo(fromDate,toDate);
		if(rtrn == false){
		 alert("To date should be greater than From Date");
	     return false;
	    }
	while(ind<totalSize)
	{
		if(document.wcrForm.elements['milestoneDtlsList['+ind+'].billStatus'].disabled==false && document.wcrForm.elements['milestoneDtlsList['+ind+'].billStatus'].checked==true)
		{
		 	selectedValue += ind+',';
		}
		else
		{
			countVar++;
		}	
	   ind++
	}
	
	if(countVar==totalSize)
	{
		alert("Select atleast one request");  
		return false;
	}
	//ver 1.1 starts here
    for(var i=0;i<totalSize;i++)
	{
	      
			if(document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].checked==true)
			{
				 document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='true';
            }
            else
            {
            document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='false';
            }
    }
    document.wcrForm.status.value='save&Preview';
    	//ver 1.1 ends here
	document.wcrForm.selectedIndex.value=selectedValue;
	//document.wcrForm.method.value ="submitWcr";commented for ver 1.1
    document.forms(0).action = '<%=request.getContextPath()%>/wcr.do?method=submitWcr&delIndex=-1';//ver 1.1
	document.wcrForm.submit();
}
//ver 1.1 ends here
function  priviewData(obj)
{
var totalSize=document.getElementById('totalRecords').value;
    obj.disabled=true;
    for(var i=0;i<totalSize;i++)
		{
		
			if(document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].checked==true)
			{
			 document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='true';
            }else
            {
            document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='';
            }
            
    }
    document.wcrForm.status.value='onlyPreview';
    document.forms(0).action = "<%=request.getContextPath()%>/wcr.do?method=showPriviewData";
	document.forms(0).submit();
} 	
function setRadioChecked()
{
 if(document.getElementById('listSize').value>0)
 {
  var totalSize=document.getElementById('totalRecords').value;

    for(var i=0;i<totalSize;i++)
  {  
   if(document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value=='true')
     {
      document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].checked=true;
     }
   }
 }
}
//ver 1.1 ends here
</script>
</head>
<body onload="setRadioChecked();">
<!--ver 1.1 added onload="setRadioChecked();" -->
<html:form action="wcr.do" method="post" onsubmit="return false;" >
	<html:hidden property="method" name="wcrForm" />
	<html:hidden property="selectedIndex" name="wcrForm" />
	<html:hidden property="flowFlag" name="wcrForm" />
	<html:hidden property="prepByDesig" name="wcrForm" />
	<html:hidden property="appByDesig" name="wcrForm" />
	<html:hidden property="authByDesig" name="wcrForm" />
	<html:hidden property="wcrRefId" name="wcrForm" />
	<!--ver 1.1 starts here-->
	<html:hidden property="status" name="wcrForm" />
	<html:hidden property="listSize" name="wcrForm" />
	<!--ver 1.1 ends here-->
	<table width=95% CELLPADDING="0" CELLSPACING="0" border="0"
		align="center" valign="top">
		<tr class="thead">
			<td colspan="6" align="center"><b><font size="2"><bean:message
				key="label.createWcr" /></font></b></td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>

		<logic:notEmpty name="wcrForm" property="msg">
			<tr class="trow">
				<logic:notEqual name="wcrForm" property="msg"
					value="WCR Created Successfully">
					<td colspan="6" align="center"><b> <font color="red" />
					<bean:write name="wcrForm" property="msg" /></b></td>
				</logic:notEqual>
				<logic:equal name="wcrForm" property="msg"
					value="WCR Created Successfully">
					<td colspan="6" align="center"><b> <font color="green" />
					<bean:write name="wcrForm" property="msg" /></b></td>
				</logic:equal>
			</tr>
		</logic:notEmpty>

		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1">&nbsp;&nbsp;<bean:message key="label.sowName" />
			<span style="color: red">*</span></td>
			<td colspan="1"><logic:notEmpty name="wcrForm"
				property="visibility">
				<html:text property="sowName" title="SOW Name" size="25"
					maxlength="25" disabled="true" />
				<input type="image"
					src="<%=request.getContextPath()%>/images/glass.png"
					alt="Search For SOW Name" name="searchSOWName">
			</logic:notEmpty> <logic:empty name="wcrForm" property="visibility">
				<html:text property="sowName" title="SOW Name" size="25"
					maxlength="25" onchange="getSOWPopUp(this.value+'%');return false;" />
				<input type="image"
					src="<%=request.getContextPath()%>/images/glass.png"
					alt="Search For SOW Name" name="searchSOWName"
					onClick="getSOWPopUp(sowName.value+'%');return false;">
			</logic:empty></td>
			<td colspan="1" align="left">&nbsp;&nbsp;<bean:message
				key="label.wonNo" /><span style="color: red">*</span></td>
			<td colspan="1"><logic:notEmpty name="wcrForm"
				property="visibility">
				<html:select property="wonNo" title="WON NO" name="wcrForm"
					onchange="getPOList(this.value);" disabled="true">
					<html:option value="">----Select----</html:option>
					<logic:notEmpty name="wcrForm" property="wonList">
						<html:optionsCollection name="wcrForm" property="wonList"
							label="label" value="value" />
					</logic:notEmpty>
				</html:select>
			</logic:notEmpty> <logic:empty name="wcrForm" property="visibility">
				<html:select property="wonNo" title="WON NO" name="wcrForm"
					onchange="getPOList(this.value);">
					<html:option value="">----Select----</html:option>
					<logic:notEmpty name="wcrForm" property="wonList">
						<html:optionsCollection name="wcrForm" property="wonList"
							label="label" value="value" />
					</logic:notEmpty>
				</html:select>
			</logic:empty></td>
			<td colspan="1">&nbsp;&nbsp;<bean:message key="label.poNo" /><span
				style="color: red">*</span></td>
			<td colspan="1"><logic:notEmpty name="wcrForm"
				property="visibility">
				<html:select property="poNo" title="PO NO" name="wcrForm"
					disabled="true">
					<html:option value="">----Select----</html:option>
					<logic:notEmpty name="wcrForm" property="poList">
						<html:optionsCollection name="wcrForm" property="poList"
							label="label" value="value" />
					</logic:notEmpty>
				</html:select>
			</logic:notEmpty> <logic:empty name="wcrForm" property="visibility">
				<html:select property="poNo" title="PO NO" name="wcrForm">
					<html:option value="">----Select----</html:option>
					<logic:notEmpty name="wcrForm" property="poList">
						<html:optionsCollection name="wcrForm" property="poList"
							label="label" value="value" />
					</logic:notEmpty>
				</html:select>
			</logic:empty></td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow"><font color="red" />&nbsp;&nbsp;*
			Fields are Mandatory</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class=thead>
			<td colspan="6" align=center>&nbsp;&nbsp; <logic:notEmpty
				name="wcrForm" property="visibility">
				<html:button value="Populate" onclick="validate_form('wcrForm');"
					styleClass="sbttn" property="submit_bttn" disabled="true" />
				<html:button value="Reset" onclick="resetWCR();" styleClass="sbttn"
					property="reset_bttn" disabled="true" />
			</logic:notEmpty> <logic:empty name="wcrForm" property="visibility">
				<html:button value="Populate" onclick="validate_form('wcrForm');"
					styleClass="sbttn" property="submit_bttn" />
				<html:button value="Reset" onclick="resetWCR();" styleClass="sbttn"
					property="reset_bttn" />
			</logic:empty>
		</tr>
		<tr class=trow>
			<logic:notEmpty name="wcrForm" property="visibility">
				<tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr class=trow>
					<td colspan="1" align="left">&nbsp;&nbsp;<bean:message
						key="label.businessUnit" /></td>
					<td colspan=""><bean:write name="wcrForm"
						property="businessUnit" /></td>
					<td colspan="1"><bean:message key="label.fromDate" /> <span
						style="color: red">*</span></td>
					<td colspan="1"><html:text property="fromDate"
						title="From Date" size="15" readonly="true"
						styleClass="disabledformtext" /> <input type="image" id=""
						src="<%=request.getContextPath()%>/images/calendar.jpg"
						alt="Pick a date"
						onclick="javascript:NewCal('fromDate','ddmmmyyyy',false,12);return false;" />
					</td>
					<td colspan="1"><bean:message key="label.toDate" /> <span
						style="color: red">*</span></td>
					<td colspan="1"><html:text property="toDate" title="To Date"
						size="15" readonly="true" styleClass="disabledformtext" /> <input
						type="image" id=""
						src="<%=request.getContextPath()%>/images/calendar.jpg"
						alt="Pick a date"
						onclick="javascript:NewCal('toDate','ddmmmyyyy',false,12);return false;" />
					</td>
				</tr>
				<tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr class="thead">
					<td colspan="6">
				<tr class="trow">
					<td colspan="6"><logic:lessEqual property="totalSize"
						name="wcrForm" value="2">
						<div id='cloneTable'
							style="width: 100%;height:0;overflow: auto; border: 4px">
					</logic:lessEqual> <logic:greaterThan property="totalSize" name="wcrForm" value="2">
						<div id='cloneTable'
							style="width: 100%;height:200;overflow: auto; border: 4px">
					</logic:greaterThan>

					<table width=100% CELLPADDING="2" CELLSPACING="0" border="1"
						id="mileTable">
						<tr align="left" class="fixedThead">
							<td>&nbsp;</td>
							<td align="center"><bean:message key="label.milestoneName" /></td>
							<td align="center"><bean:message key="label.milestoneAmount" /></td>
							<td align="center"><bean:message key="label.milestoneRemark" /></td>
							<td align="center"><bean:message key="label.milestoneDate" /></td>
							<td align="center"><bean:message key="label.invoiceNumber" /></td>
						</tr>
						<tr class="trow">
							<td><input type="checkbox" name="selectAllChk"
								id="selectAllChk" onclick="checkUncheckAll(this);" /></td>
							<td colspan="5"><bean:message key="label.unSelectAll" /></td>
						</tr>
						<tr>

							<logic:notEmpty property="milestoneDtlsList" name="wcrForm">
								<!-- ver 1.1 starts here-->
								<%
								int totalValue = 0;
								%>
								<!-- ver 1.1 ends here-->
								<logic:iterate property="milestoneDtlsList" name="wcrForm"
									id="milestoneDtlsList" indexId="count">
									<!-- ver 1.1 starts here-->
									<%
									totalValue++;
									%>
									<!-- ver 1.1 ends here-->
									<tr class=trow>
										<td><html:hidden name="milestoneDtlsList"
											property="billingCheck" indexed="true" /> <logic:equal
											name="milestoneDtlsList" property="billFlag" value="U">
											<html:checkbox name="milestoneDtlsList" property="billStatus"
												indexed="true" onclick="trackSelectAllChk(this.checked);" />
										</logic:equal> <logic:notEqual name="milestoneDtlsList" property="billFlag"
											value="U">
											<html:checkbox name="milestoneDtlsList" property="billStatus"
												indexed="true" disabled="true"
												onclick="trackSelectAllChk(this.checked);" />
										</logic:notEqual></td>
										<html:hidden property="milestoneName" name="milestoneDtlsList"
											indexed="true" />
										<html:hidden property="milestoneAmnt" name="milestoneDtlsList"
											indexed="true" />
										<html:hidden property="milestoneRemark"
											name="milestoneDtlsList" indexed="true" />
										<html:hidden property="mileStoneDate" name="milestoneDtlsList"
											indexed="true" />
										<td><bean:write property="milestoneName"
											name="milestoneDtlsList" /></td>
										<td align="right"><bean:write property="displayAmount"
											name="milestoneDtlsList" /></td>
										<td align="center"><bean:write property="milestoneRemark"
											name="milestoneDtlsList" />&nbsp;</td>
										<td align="center"><bean:write property="mileStoneDate"
											name="milestoneDtlsList" /></td>
										<td align="center"><bean:write property="invoiceNumber"
											name="milestoneDtlsList" />
											&nbsp;</td>
									</tr>
									<input type="hidden" name="rowCount" id='rowCount' value='1' />
								</logic:iterate>
								<input type="hidden" value='<%=String.valueOf(totalValue)%>'
									name="totalRecords" />
								<!--ver 1.1-->
							</logic:notEmpty>
						</tr>
					</table>
					</div>
					</td>
				<tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr class=trow>
					<td colspan="1" align="left">&nbsp;&nbsp;<bean:message
						key="label.preparedBy" /></td>
					<td colspan="" align="left"><bean:write property="preparedBy"
						name="wcrForm" /></td>
					<td colspan="1" align="left">&nbsp;&nbsp;<bean:message
						key="label.approvedBy" /></td>
					<td colspan="" align="left"><bean:write property="approvedBy"
						name="wcrForm" /></td>
					<td colspan="1" align="left">&nbsp;&nbsp;<bean:message
						key="label.authorisedBy" /></td>
					<td colspan="" align="left"><bean:write
						property="authorisedBy" name="wcrForm" /></td>
				</tr>




				<tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr class=thead>
					<td colspan="6" align=center>&nbsp;&nbsp; <html:button
						value="Preview" onclick="priviewData(this);" styleClass="sbttn"
						property="onlypreview_bttn" /> <html:button
						value="Save & Preview" onclick="submitWCR()" styleClass="sbttn"
						property="preview_bttn" /> <html:button value="Cancel"
						onclick="resetWCR()" styleClass="sbttn" property="reset_bttn" />
					</td>
				</tr>


			</logic:notEmpty>
		</tr>


	</table>

</html:form>
</body>
</html:html>
<%
		} catch (Exception e) {
		e.printStackTrace();
	}
%>
