<!--
 * JSP
 *
 * Name: editwcr.jsp
 * Action Class : WcrAction.java  
 * Form Class   :WcrForm.java 
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
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%int i=0,recCount=0,totalRadio=0,displayFlag=0;
try{ %>
<%@page import="com.vsnl.model.WcrAdd"%>
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
 	//var list = new Array('sowName','wonNo','poNo','wcrRefId'); 
 	var list = new Array('sowName','wonNo','poNo'); 
	if(!validate('wcrForm',list))
	{
		 return false;
	}
	 document.wcrForm.method.value="getMilestoneDetailsForEdit";
	 document.wcrForm.flowFlag.value="E";
	 document.wcrForm.submit();
	
}

function resetWCR()
	 {
		
		 document.forms(0).action = "<%=request.getContextPath()%>/wcr.do?method=showEditWcr";
		 document.forms(0).submit();
	 }
	 
	 
function getSOWPopUp(val)
{
   
   var qid = "getSowName";		
   var paramsList =val;
   var targetFields = 'sowName';
   var postFunc = "getWONList";
   removeAllOptions(document.getElementById('wonNo'),1);
   removeAllOptions(document.getElementById('poNo'),1);
   //removeAllOptions(document.getElementById('wcrRefId'),1);
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
	  //removeAllOptions(document.getElementById('wcrRefId'),1);
	  popDropDown('wonNo', ajaxResponse);
	  document.getElementById('wonNo').focus();
} 	 

function getPOList(val){
	   var won =val;	
	   var  query  = 'PO.getPOList';	
	   var sow = document.getElementById('sowName').value;		
	   var inParams = won+','+sow;
	   getDetails_ajax(query, inParams, null,',');	
	   //removeAllOptions(document.getElementById('wcrRefId'),1);
	   popDropDown('poNo', ajaxResponse);
	   document.getElementById('poNo').focus();
}  
function checkUncheckAll(selAllObj)
{
	var totalSize=document.getElementById('totalRecords').value;
	for(var i=0;i<totalSize;i++)
	{
	
	if(selAllObj.checked==true)
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
   
/*function submitWCR(){

	var totalSize=document.getElementById('totalRecords').value;
	if(totalSize>0)
	{
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
			
		
		//ver 1.1 starts here
		    for(var i=0;i<totalSize;i++)
				{
			      
					if(document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].checked==true)
					{
					 document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='true';
		            }else
		            {
		            document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='false';
		            }
		    }
		    
		    var list = new Array('sowName','wonNo','poNo','wcrRefId','preparedBy','approvedBy','authorisedBy'); 
			if(validate('wcrForm',list)){
				 document.wcrForm.status.value='update&Preview';
			//ver 1.1 ends here
			document.wcrForm.selectedIndex.value=selectedValue;
				 //document.wcrForm.method.value ="submitWcr";commented for ver 1.1
			document.forms(0).action = '<%=request.getContextPath()%>/wcr.do?method=submitWcr&delIndex=-1';//ver 1.1
			document.wcrForm.submit();
				}
				else {
			return false;
			}
	}
	else
	{
		alert('No record to update');
	}
}*/



function submitWCR()
{
	var totalRecord=document.getElementById('recordCount').value;
	var selectedValue=',';
	var fromDate=document.getElementById('fromDate').value;
	var toDate=document.getElementById('toDate').value; 
	var rtrn = isDateLessThanEqualTo(fromDate,toDate);
	var radioObj=document.getElementsByName('wcrSelected');
	var radioChkFlag=false;
	if(rtrn == false)
	{
	  alert("To date should be greater than From Date");
	  return false;
    }
	for(var i=0;i<radioObj.length;i++)
	{
		if(document.getElementsByName('wcrSelected')[i].checked==true)
		{
			radioChkFlag=true;
			document.wcrForm.wcrRefId.value=document.getElementsByName('wcrSelected')[i].value;
			for(var j=0;j<totalRecord;j++)
			{
				var tdata=document.wcrForm.elements['milestoneDtlsList['+i+']['+j+'].billStatuschk'];
				if(tdata!=null)
				{
				
					if(tdata.checked==true)
					{
						selectedValue += j+',';
						document.wcrForm.elements['milestoneDtlsList['+j+'].billStatus'].value='on';
						document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value='true';
					}
					else
					{
						document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value='false';
					}
				}
			}
			break;
		}
	}
	
	for(var j=0;j<totalRecord;j++)
	{
		var tdata=document.wcrForm.elements['milestoneDtlsList['+radioObj.length+']['+j+'].billStatuschk'];
		if(tdata!=null)
		{
			if(tdata.checked==true)
			{
				selectedValue += j+',';
				document.wcrForm.elements['milestoneDtlsList['+j+'].billStatus'].value='on';
				document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value='true';
			}
			else
			{
				document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value='false';
			}
		}
	}

	if(selectedValue!=',' && radioChkFlag==false)
	{
		alert('select a WCR ReferenceId');
		return false;
	}
	if(radioChkFlag==false)
	{
		alert('Please select a WCR ReferenceId');
		return false;
	}
	document.wcrForm.selectedIndex.value=selectedValue;
	var list = new Array('sowName','wonNo','poNo','preparedBy','approvedBy','authorisedBy'); 
	if(validate('wcrForm',list))
	{
	 	document.wcrForm.status.value='update&Preview';
		document.wcrForm.selectedIndex.value=selectedValue;
	}
	else
	{
		return false;
	}
	document.forms(0).action = '<%=request.getContextPath()%>/wcr.do?method=submitWcr&delIndex=-1';
	document.wcrForm.submit();
}


function enableCheckBox()
{
	var totalRecord=document.getElementById('recordCount').value;
	for(var i=0;i<document.getElementsByName('wcrSelected').length;i++)
	{
		if(document.getElementsByName('wcrSelected')[i].checked==true)
		{
			for(var j=0;j<totalRecord;j++)
			{
				var tdata=document.wcrForm.elements['milestoneDtlsList['+i+']['+j+'].billStatuschk'];
				if(tdata!=null)
				{
					tdata.disabled=false;
				}
			}
			break;
		}
	}
	for(var i=0;i<document.getElementsByName('wcrSelected').length;i++)
	{
		if(document.getElementsByName('wcrSelected')[i].checked==false)
		{
			for(var j=0;j<totalRecord;j++)
			{
				var tdata=document.wcrForm.elements['milestoneDtlsList['+i+']['+j+'].billStatuschk'];
				if(tdata!=null)
				{
					tdata.disabled=true;
				}
			}
		}
	}
}




function getApproverDesig()
{
	var approver =document.getElementById('approvedBy').value;
	var  query  = 'WCR.getApproverDesig';	
	var inParams = approver;
	getDetails_ajax(query, inParams, null);	
	var splitAjaxResponse = ajaxResponse.split("~");  
	document.wcrForm.appByDesig.value=splitAjaxResponse[0];
	document.wcrForm.approvedBy.value=approver;
}

function getAuthoriserDesig()
{
	var authoriser =document.getElementById('authorisedBy').value;
	var  query  = 'WCR.getAuthoriserDesig';	
	var inParams = authoriser;
	getDetails_ajax(query, inParams, null);	
	var splitAjaxResponse = ajaxResponse.split("~");  
	document.wcrForm.authByDesig.value=splitAjaxResponse[0];
	document.wcrForm.authorisedBy.value=authoriser;
} 	
function setPreparedBy()
{
	var authority =document.getElementById('preparedBy').value;
	document.wcrForm.preparedBy.value=authority;
} 	
function getWcrRefList(val){
	   var po =val;	
	   var sowName= document.getElementById('sowName').value;	
	   var  query  = 'WCR.getWcrRefIds';	
	   var inParams = sowName + ',' + po ;
	   getDetails_ajax(query, inParams, null);	
	   popDropDown('wcrRefId', ajaxResponse);
	   document.getElementById('wcrRefId').focus();
}
//ver 1.1 starts here
function  priviewData(obj)
{
	var totalRecord=document.getElementById('recordCount').value;
	if(totalRecord>0)
	{
		obj.disabled=true;
		var radioObj=document.getElementsByName('wcrSelected');
		for(var i=0;i<radioObj.length;i++)
		{
			if(document.getElementsByName('wcrSelected')[i].checked==true)
			{
			   document.wcrForm.wcrRefId.value=document.getElementsByName('wcrSelected')[i].value;
			    for(var j=0;j<totalRecord;j++)
				{
					var tdata=document.wcrForm.elements['milestoneDtlsList['+i+']['+j+'].billStatuschk'];
					if(tdata!=null)
					{
						if(tdata.checked==true)
						{
							document.wcrForm.elements['milestoneDtlsList['+j+'].billStatus'].value='on';
							document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value='true';
						}
						else
						{
							document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value='false';
							document.wcrForm.elements['milestoneDtlsList['+j+'].billStatus'].value='';
						}
					}
				}
				break;
			}
		}
		
		
		for(var j=0;j<totalRecord;j++)
		{
			var tdata=document.wcrForm.elements['milestoneDtlsList['+radioObj.length+']['+j+'].billStatuschk'];
			if(tdata!=null)
			{
				if(tdata.checked==true)
				{
					document.wcrForm.elements['milestoneDtlsList['+j+'].billStatus'].value='on';
					document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value='true';
				}
				else
				{
					document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value='false';
				}
			}
		}
	    
	   /* for(var i=0;i<totalSize;i++)
			{
			
				if(document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].checked==true)
				{
					 document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='true';
	            }
	            else
	            {
	           		 document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='';
	            }
	    	}
	    */
	    var list = new Array('sowName','wonNo','poNo','wcrRefId','preparedBy','approvedBy','authorisedBy'); 
		if(validate('wcrForm',list))
		{
		    document.wcrForm.status.value='onlyPreviewDuringUpdate';
		    //document.forms(0).action ="<%=request.getContextPath()%>/pdfreport.do?method=getWcr";
		    document.forms(0).action = "<%=request.getContextPath()%>/wcr.do?method=showPriviewData";
			document.forms(0).submit();
		}
		else
		{
			obj.disabled=false;
			return false;
		}
	}
	else
	{
		alert('No record to perview');
		return false;
	}
    
} 
//ver 1.1 ends here

</script>
</head>
<body onload="setRadioChecked();"><!--ver 1.1 added onload="setRadioChecked();"-->
<html:form action="wcr.do" method= "post" onsubmit="return false;" >
<html:hidden property="method" name="wcrForm"/>
<html:hidden property="selectedIndex" name="wcrForm"/>
<html:hidden property="flowFlag" name="wcrForm"/>
<html:hidden property="prepByDesig" name="wcrForm"/>
<html:hidden property="appByDesig" name="wcrForm"/>
<html:hidden property="authByDesig" name="wcrForm"/>
<html:hidden property="wcrRefId" name="wcrForm"/>

<!--ver 1.1 starts here-->
<html:hidden property="status" name="wcrForm"/>
<html:hidden property="listSize" name="wcrForm"/>
	<!--ver 1.1 ends here -->
	<table width=95% CELLPADDING="0" CELLSPACING="0" border="0"	align="center" valign="top">
         <tr class="thead">
		  	 <td colspan="6" align="center">
     			<b><font size="2"><bean:message key="label.editWcr"/></font></b>
		  	 </td>
		</tr>
	 	<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>

	 		<logic:notEmpty name = "wcrForm" property = "msg">
	 		<tr class="trow">
	 		  <logic:notEqual name = "wcrForm" property = "msg" value ="WCR Edited Successfully">
		 		  <td colspan="6" align= "center">
		 			  <b>
		 	  			 <font color="red"   />
			  			 	<bean:write  name = "wcrForm" property = "msg"  /></b>
			 	  	</td>
			 </logic:notEqual>
			 <logic:equal name = "wcrForm" property = "msg" value ="WCR Edited Successfully">	
				 <td colspan="6" align= "center">
			 	   <b>
		 			   <font color="green" />
						   	<bean:write  name = "wcrForm" property = "msg"  /></b>
				 </td>
				</logic:equal>	
				</tr>   	
			</logic:notEmpty>
			
			
			
				
			<logic:equal name="wcrForm" property="visibility" value="True">
			
			<logic:empty name="wcrForm" property="wcrDetailsList">
				<tr class="trow">
      				<td align="center" colspan="6">
      				<strong>
      				 <font color="red"/>
      					All the Milestones are billed for this SOW
     					</font>
     					</strong>
      				</td>
    			</tr>	
			</logic:empty>
				<logic:equal value="1" name="wcrForm" property="wcrListSize">
				 <logic:iterate id="wcrdtlsList" name="wcrForm" property="wcrDetailsList" indexId="mainCount">
				 	<bean:define id="wcRef" name="wcrdtlsList" property="wcrRefId" type="java.lang.Integer" />
						<logic:equal name="wcrdtlsList" property="wcrRefId"  value="0" >
							<% displayFlag=1;%>
							<tr class="trow">
			      				<td align="center" colspan="6">
			      				<strong>
			      				 <font color="red"/>
			      					No WCR created yet.
		      					</font>
		      					</strong>
			      				</td>
	      					</tr>	
						</logic:equal>
				 </logic:iterate>
				</logic:equal>
			</logic:equal>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;</td>
		</tr>
		<tr class="trow">
		 	 <td colspan="1"  >&nbsp;&nbsp;<bean:message key="label.sowName"/> <span style="color: red">*</span></td>
			  <td colspan="2">
          	 	   <logic:notEmpty name="wcrForm" property="visibility">
					<html:text property="sowName" title="SOW Name" size= "25" maxlength ="25" disabled="true"/>
					 <input type="image" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For SOW Name" name="searchSOWName" >
				  </logic:notEmpty>
          	 	  <logic:empty name="wcrForm" property="visibility">
          	 	 	<html:text property="sowName" title="SOW Name" size= "25" maxlength ="25" onchange="getSOWPopUp(this.value+'%');return false;"/>
          	 	 	<input type="image" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For SOW Name" name="searchSOWName" onClick="getSOWPopUp(sowName.value+'%');return false;">
          	 	  </logic:empty>
          	 	    
            	</td>
            	<td   align="left" >&nbsp;&nbsp;<bean:message key="label.wonNo"/><span style="color: red">*</span></td>
				<td colspan="2">
					<logic:notEmpty name="wcrForm" property="visibility">
					<html:select property="wonNo"  title="WON NO" name ="wcrForm"  disabled="true" >
						<html:option value="">----Select----</html:option>						
							<logic:notEmpty name="wcrForm" property="wonList">
								<html:optionsCollection name="wcrForm" property="wonList" label="label" value="value" />
							</logic:notEmpty>
					</html:select>
					</logic:notEmpty>
					<logic:empty name="wcrForm" property="visibility">
					<html:select property="wonNo"  title="WON NO" name ="wcrForm" onchange ="getPOList(this.value);"  >
						<html:option value="">----Select----</html:option>						
							<logic:notEmpty name="wcrForm" property="wonList">
								<html:optionsCollection name="wcrForm" property="wonList" label="label" value="value" />
							</logic:notEmpty>
					</html:select>
					</logic:empty>
				 </td>
		</tr>
		<tr class="trow">
			<td colspan="6">&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.poNo"/><span style="color: red">*</span></td>
				<td colspan="5">
					<logic:notEmpty name="wcrForm" property="visibility">
					<html:select property="poNo" title="PO NO" name ="wcrForm" disabled="true" >
						<html:option value="">----Select----</html:option>						
							<logic:notEmpty name="wcrForm" property="poList">
								<html:optionsCollection name="wcrForm" property="poList" label="label" value="value"/>
							</logic:notEmpty>
					 </html:select>
					 </logic:notEmpty>
					 <logic:empty name="wcrForm" property="visibility">
					  <html:select property="poNo" title="PO NO" name ="wcrForm"  onchange ="">
						<html:option value="">----Select----</html:option>						
							<logic:notEmpty name="wcrForm" property="poList">
								<html:optionsCollection name="wcrForm" property="poList" label="label" value="value"/>
							</logic:notEmpty>
					 </html:select>
					 </logic:empty>
				</td>
				<%--
				 <td colspan="1">&nbsp;&nbsp;<bean:message key="label.wcrRefId"/> <span style="color: red">*</span></td>
			  	 <td colspan="2">
          	 	   <logic:notEmpty name="wcrForm" property="visibility">
					<html:select property="wcrRefId"  title="WCR REF. ID" name ="wcrForm" disabled="true" >
						<html:option value="">----Select----</html:option>						
							<logic:notEmpty name="wcrForm" property="wcrRefIdList">
								<html:optionsCollection name="wcrForm" property="wcrRefIdList" label="label" value="value" />
							</logic:notEmpty>
					</html:select>
				  </logic:notEmpty>
          	 	  <logic:empty name="wcrForm" property="visibility">
          	 	  <html:select property="wcrRefId"  title="WCR REF. ID" name ="wcrForm"   >
						<html:option value="">----Select----</html:option>						
							<logic:notEmpty name="wcrForm" property="wcrRefIdList">
								<html:optionsCollection name="wcrForm" property="wcrRefIdList" label="label" value="value" />
							</logic:notEmpty>
					</html:select>
          	 	  </logic:empty>
            	</td>	
            	--%>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
    	<tr class="trow">
			<td colspan="6" class="trow"><font color="red" />&nbsp;&nbsp;* Fields are Mandatory</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class=thead>
			<td colspan="6" align=center>&nbsp;&nbsp;
				  <logic:notEmpty name="wcrForm" property="visibility">
					  <html:button value="Populate" onclick="validate_form('wcrForm');" styleClass="sbttn" property="submit_bttn" disabled="true"/> 
				  </logic:notEmpty>
				  <logic:empty name="wcrForm" property="visibility">
					  <html:button value="Populate" onclick="validate_form('wcrForm');" styleClass="sbttn" property="submit_bttn"/> 
				  </logic:empty>
				  	  <html:button value="Reset" onclick="resetWCR();" styleClass="sbttn" property="reset_bttn" />
 		</td>
 		</tr>
	   
    	
	     <!-- logic:notEmpty name="wcrForm" property="visibility"-->
	     <%if(displayFlag==0)
	      {%>
	      <tr>
		      <td colspan="6">
	      		
		      	<logic:notEmpty property="milestoneDtlsList" name="wcrForm" >	
		      	<tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
	        	</tr>
		     	<tr class=trow>
			     	<td colspan="1"  align="left" >&nbsp;&nbsp;<bean:message key="label.businessUnit"/></td>
					<td colspan="1">
						<bean:write name="wcrForm" property="businessUnit"/>
					 </td>
				 	 <td colspan="1" ><bean:message key="label.fromDate"/> <span style="color: red">*</span></td>
						<td colspan="1"><html:text property="fromDate" title="From Date" size="15" readonly="true" styleClass="disabledformtext" />
							<input type="image" id="" src="<%=request.getContextPath()%>/images/calendar.jpg" alt="Pick a date" onclick="javascript:NewCal('fromDate','ddmmmyyyy',false,12);return false;" />
			             </td>	
			        <td colspan="1" ><bean:message key="label.toDate"/> <span style="color: red">*</span></td>
						<td colspan="1"><html:text property="toDate" title="To Date" size="15" readonly="true" styleClass="disabledformtext" />
							<input type="image" id="" src="<%=request.getContextPath()%>/images/calendar.jpg" alt="Pick a date" onclick="javascript:NewCal('toDate','ddmmmyyyy',false,12);return false;" />
			        	</td>
			     </tr>
			     <tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				 </tr>
		         <tr class="thead">
		          	<td colspan="6" >
		           		<tr class="trow">
							<td colspan="6">
									<logic:lessEqual property="totalSize" name="wcrForm" value="2">
										<div id='cloneTable' style="width: 100%;height:0;overflow: auto; border: 4px">
									</logic:lessEqual>
									<logic:greaterThan property="totalSize" name="wcrForm" value="2">
										<div id='cloneTable'style="width: 100%;height:200;overflow: auto; border: 4px">
									</logic:greaterThan>
									<table width=100% CELLPADDING="2" CELLSPACING="0" border="1" id="mileTable">
										<tr align="left" class="fixedThead">
											<td>&nbsp;</td>
											<td align="center";>WCR Ref Id</td>
											<td>&nbsp;</td>
											<td align="center"><bean:message key="label.milestoneName"/></td>
											<td align="center"><bean:message key="label.milestoneAmount"/></td>
											<td align="center"><bean:message key="label.milestoneRemark"/></td>
											<td align="center"><bean:message key="label.milestoneDate"/></td>
										</tr>
										<%--<bean:define id="wcrdtlsList" name="wcrForm" property="wcrDetailsList" type="java.util.List" />
										 <bean:define id="milestonedtlsList" name="wcrForm" property="milestoneDtlsList" type="java.util.List" />
										 --%>
										 <logic:iterate id="wcrdtlsList" name="wcrForm" property="wcrDetailsList" indexId="mainCount">
										 	<logic:iterate id="milestoneDtlsList" name="wcrForm" property="milestoneDtlsList" indexId="count">
										 		<bean:define id="wRef" name="wcrdtlsList" property="wcrRefId" type="java.lang.Integer" />
										 		<logic:equal name="milestoneDtlsList" property="wcrRefId"  value="<%=wRef.toString()%>" >
										 			<tr class="trow">
												 		 <%if(i==0)
											 		 	{%>
											 		 	<logic:equal value="0" name="milestoneDtlsList" property="wcrRefId">
											 		 		<td align="center" rowspan="<bean:write name="wcrdtlsList" property="wcrRefCount" />">
											 		 			&nbsp;
												 		 	</td>
												 		 	<td align="center" rowspan="<bean:write name="wcrdtlsList" property="wcrRefCount" />">
												 		 		&nbsp;
												 		 	</td>
											 		 	</logic:equal>
											 		 	<logic:notEqual value="0" name="milestoneDtlsList" property="wcrRefId">
											 		 		<td align="center" rowspan="<bean:write name="wcrdtlsList" property="wcrRefCount" />">
											 		 			<html:radio name="milestoneDtlsList" property="wcrSelected" value="<%=wRef.toString()%>" onclick="enableCheckBox();"/>
											 		 		</td>
											 		 		<td align="center" rowspan="<bean:write name="wcrdtlsList" property="wcrRefCount" />">
											 		 			<bean:write property="wcrRefId" name="milestoneDtlsList" />
											 		 		</td>
											 		 	</logic:notEqual>
											 		 	<%
											 		 		totalRadio=totalRadio+1;
											 		 		i=1;
											 		 	}%>
											 		 	 <html:hidden property="milestoneName" name="milestoneDtlsList" indexed="true" />
							                   		     <html:hidden property="milestoneAmnt" name="milestoneDtlsList" indexed="true" />
							                   		     <html:hidden property="milestoneRemark" name="milestoneDtlsList" indexed="true" /> 
							                   		     <html:hidden property="mileStoneDate" name="milestoneDtlsList" indexed="true" />       
							                   		     <html:hidden name="milestoneDtlsList" property="billingCheck" indexed="true"/>
							                   		     <html:hidden name="milestoneDtlsList" property="billStatus" indexed="true"/>
											 		 	<td>
											 		 	<logic:equal value="0" name="milestoneDtlsList" property="wcrRefId">
											 		 		<logic:equal name="milestoneDtlsList" property="billFlag" value="U">
							                   			     <input type="checkbox" name="milestoneDtlsList[<%=mainCount%>][<%=recCount%>].billStatuschk" id="milestoneDtlsList[<%=mainCount%>][<%=recCount%>].billStatuschk"   />
							                   			 	</logic:equal>
								                   			<logic:equal name="milestoneDtlsList" property="billFlag" value="WIP">
								                   			     <input type="checkbox" name="milestoneDtlsList[<%=mainCount%>][<%=recCount%>].billStatuschk" id="milestoneDtlsList[<%=mainCount%>][<%=recCount%>].billStatuschk" checked="checked" />
								                   			</logic:equal>
											 		 	</logic:equal>
											 		 	<logic:notEqual  value="0" name="milestoneDtlsList" property="wcrRefId">
											 		 		<logic:equal name="milestoneDtlsList" property="billFlag" value="U">
							                   			     <input type="checkbox" name="milestoneDtlsList[<%=mainCount%>][<%=recCount%>].billStatuschk" id="milestoneDtlsList[<%=mainCount%>][<%=recCount%>].billStatuschk"  disabled="disabled" />
							                   			 	</logic:equal>
								                   			<logic:equal name="milestoneDtlsList" property="billFlag" value="WIP">
								                   			     <input type="checkbox" name="milestoneDtlsList[<%=mainCount%>][<%=recCount%>].billStatuschk" id="milestoneDtlsList[<%=mainCount%>][<%=recCount%>].billStatuschk" checked="checked" disabled="disabled"/>
								                   			</logic:equal>
											 		 	</logic:notEqual>
											 		 		
														</td>
												 		 <td align="left">									
															<bean:write property="milestoneName" name="milestoneDtlsList"  />								
											   		     </td>	
											   		     <td align="right">									
													 		<bean:write property="displayAmount" name="milestoneDtlsList" />								
											   			 </td>	
											   			 <td align="center">									
													 		<bean:write property="milestoneRemark" name="milestoneDtlsList" />&nbsp;								
											   			 </td>	
											   		 	 <td align="center">									
													 		<bean:write property="mileStoneDate" name="milestoneDtlsList" />								
												   		 </td>
												   		 <%recCount=recCount+1;%>
										 			</tr>
										 		</logic:equal>
										 	</logic:iterate>
										 	<%i=0; %>
										</logic:iterate>
										 <tr style="display: none">
										 	<td><input type="hidden" name="recordCount" id='recordCount' value="<%=recCount%>"/>
										 	</td>
										 </tr>
										 		<%--
										 		<%  int listSize = 0; %>
													 <tr class="trow">
														<td>
															<input type="checkbox" name="selectAllChk" id="selectAllChk" onclick="checkUncheckAll(this);"/>
														</td>
														<td colspan="4">
															<bean:message key="label.unSelectAll"/>
														</td>
													</tr>
												    <bean:define property="milestoneDtlsList" name="wcrForm" id="milestoneList" type="java.util.ArrayList"/>
										    		<%listSize = milestoneList.size();%>
										    	<logic:iterate property="milestoneDtlsList" name="wcrForm" id="milestoneDtlsList" indexId="count">
							                   		<tr class=trow>
							                   		  <td>
							                   		  <html:hidden name="milestoneDtlsList" property="billingCheck" indexed="true"/><!--ver 1.1 -->
							                   			  <logic:equal name="milestoneDtlsList" property="billFlag" value="U">
							                   			     <input type="checkbox" name="milestoneDtlsList[<%=count%>].billStatus" id="milestoneDtlsList[<%=count%>].billStatus"   onclick="trackSelectAllChk(this.checked);"/>
							                   			  </logic:equal>
							                   			  <logic:equal name="milestoneDtlsList" property="billFlag" value="WIP">
							                   			      <input type="checkbox" name="milestoneDtlsList[<%=count%>].billStatus" id="milestoneDtlsList[<%=count%>].billStatus" checked="checked" onclick="trackSelectAllChk(this.checked);" />
							                   			  </logic:equal>			                   													   		  
												   	  </td>												   		   
							                   		      <html:hidden property="milestoneName" name="milestoneDtlsList" indexed="true" />
							                   		      <html:hidden property="milestoneAmnt" name="milestoneDtlsList" indexed="true" />
							                   		      <html:hidden property="milestoneRemark" name="milestoneDtlsList" indexed="true" /> 
							                   		      <html:hidden property="mileStoneDate" name="milestoneDtlsList" indexed="true" />                   		 
							                   		  <td align="left">									
														<bean:write property="milestoneName" name="milestoneDtlsList"  />								
										   		      </td>	
										   		      <td align="right">									
												 		<bean:write property="milestoneAmnt" name="milestoneDtlsList" />								
										   			  </td>	
										   			  <td align="center">									
												 		<bean:write property="milestoneRemark" name="milestoneDtlsList" />&nbsp;								
										   			  </td>	
										   		 	  <td align="center">									
												 		<bean:write property="mileStoneDate" name="milestoneDtlsList" />								
										   			  </td>
										   	 </tr>
										   			 <input type="hidden" name="rowCount" id='rowCount' value='1'/>
							              	</logic:iterate>
							              <!-- /logic:notEmpty-->
							              <input type="hidden" value='<%=listSize%>' name="listSize" />
							              <input type="hidden" value='<%=String.valueOf(listSize)%>' name="totalRecords" /><!--ver 1.1-->
							              --%>
							              
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
			     	<td colspan="1"  align="left" >&nbsp;&nbsp;<bean:message key="label.preparedBy"/> <span style="color: red">*</span></td>
					<td colspan="1" align="left">
					 <html:select property="preparedBy" title="Prepared By" name ="wcrForm" >
						<html:option value="">--select--</html:option>						
							<logic:notEmpty name="wcrForm" property="preparedByList">
								<html:optionsCollection name="wcrForm" property="preparedByList" label="label" value="value"/>
							</logic:notEmpty>
					 </html:select>
					 </td>
					 <td colspan="1"  align="left" >&nbsp;&nbsp;<bean:message key="label.approvedBy"/> <span style="color: red">*</span></td>
				     <td colspan="1" align="left">
						 <html:select property="approvedBy" title="Approved By" name ="wcrForm" onchange="getApproverDesig();return false;" >
							<html:option value="">--select--</html:option>						
								<logic:notEmpty name="wcrForm" property="approvedByList">
									<html:optionsCollection name="wcrForm" property="approvedByList" label="label" value="value"/>
								</logic:notEmpty>
						 </html:select>
					 </td>
					 <td colspan="1"  align="left" >&nbsp;&nbsp;<bean:message key="label.authorisedBy" /> <span style="color: red">*</span></td>
				     <td colspan="1" align="left">
						<html:select property="authorisedBy" title="Authorised By" name ="wcrForm" onchange="getAuthoriserDesig();return false;">
							<html:option value="">--select--</html:option>						
								<logic:notEmpty name="wcrForm" property="authorisedByList">
									<html:optionsCollection name="wcrForm" property="authorisedByList" label="label" value="value"/>
								</logic:notEmpty>
					 	</html:select>	
					 </td>		       
			        </tr>
					 <tr class="trow">
						<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		 		    </tr>
					<tr class="trow">
						<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		 		    </tr>
		 		   <tr class=thead>
						<td colspan="6" align=center>&nbsp;&nbsp;
						<html:button value="Preview" onclick="priviewData(this);" styleClass="sbttn" property="onlypreview_bttn" /> <!--ver 1.1-->
							  <html:button value="Update & Preview" onclick="return submitWCR();" styleClass="sbttn" property="preview_bttn" /> 
	 		         	      <html:button value="Cancel" onclick="resetWCR();" styleClass="sbttn" property="preview_bttn" /> 
	 		         	</td>
	               </tr>
		      	</logic:notEmpty>	
		      </td>
	      </tr>
		 <%}%>
	       
	</table>

</html:form>
</body>
</html:html>
<script type="text/javascript">
	function setRadioChecked()
	{
		 var status=document.wcrForm.status.value;
		 if(status!=null && status=='onlyPreviewDuringUpdate')
		 {
		 	 var radCheckedValue='';
			 var radioObj=document.getElementsByName('wcrSelected');
			 var totalRecord=document.getElementById('recordCount').value;
			 var radCheckedValue=document.wcrForm.wcrRefId.value;
			 if(radCheckedValue!=0 && radCheckedValue!='')
			 {
			 	for(var i=0;i<radioObj.length;i++)
				{
					if(document.getElementsByName('wcrSelected')[i].value==radCheckedValue)
					{
						for(var j=0;j<totalRecord;j++)
						{
							if(document.wcrForm.elements['milestoneDtlsList['+j+'].billingCheck'].value=='true')
							{
								var tdata=document.wcrForm.elements['milestoneDtlsList['+i+']['+j+'].billStatuschk'];
					      		if(tdata!=null)
					      		{
					      			tdata.disabled=false;
					      			tdata.checked=true;
					      		}
							}
						}
						document.getElementsByName('wcrSelected')[i].checked=true;
						break;
					}
				}
				
			 }
			 
			for(var i=0;i<totalRecord;i++)
		  	{  
		   		if(document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value=='true')
		     	{
		      		var tdata=document.wcrForm.elements['milestoneDtlsList['+radioObj.length+']['+i+'].billStatuschk'];
		      		if(tdata!=null)
		      		{
		      			tdata.checked=true;
		      		}
		    	}
		    }
		    
		    for(var i=0;i<totalRecord;i++)
		  	{  
		   		document.wcrForm.elements['milestoneDtlsList['+i+'].billingCheck'].value='false';
		   		document.wcrForm.elements['milestoneDtlsList['+i+'].billStatus'].value='';
		    }
		 }
		 document.wcrForm.status.value='';
		 
	}	
</script>

<%} catch (Exception e) { e.printStackTrace();} %>