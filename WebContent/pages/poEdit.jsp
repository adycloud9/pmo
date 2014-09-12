<!--
 * JSP
 *
 * Name: poEdit.jsp
 * Action Class : PoAction.java  
 * Form Class   :PoAddForm.java 
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
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>

<% try{ %>
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

function editValidate(myform)
{
var sowName=document.getElementById('sowName');
if((notEmpty(sowName,"Please enter sow name")) && (isAlphabet(sowName,"Please enter only Alphabets in sow name"))){
       return true;
 }
 return false;
//document.forms(0).action = "<%=request.getContextPath()%>/searchCollectionDetails.do?method=searchCollectionDetails";
}
function validate_form(form)
{
	 if(validateFields(form))
	 {
	 	document.forms(0).action = "<%=request.getContextPath()%>/poadd.do?method=editPo";
    	 document.forms(0).submit();
	 }
	 
	
}

function validateFields(form)
{
	var list = new Array('sowName','wonNo','poNo','poStartDate','poEndDate','poDate'); 
	if(validate('poAddForm',list)){
		 var poStDate=document.getElementById('poStartDate').value;
	     var poEdDate=document.getElementById('poEndDate').value; 
		 var rtrn = isDateLessThan(poStDate,poEdDate);
		  
		  if(rtrn == false){
			 	 alert("End date should be greater than Start Date");
			 	  return false;
	  	      }
		}
		else 
		{
	   		return false;
	    }
	    return true;
}
	
	function getSOWPopup(val)
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
	
	
function resetField()
	 {
		
		 document.forms(0).action = "<%=request.getContextPath()%>/poadd.do?method=showEditPage";
		 document.forms(0).submit();
	 }
	 
function getWONList(){
	  var sow = document.getElementById('sowName').value;	
	  var  query  = 'PO.getWONList';	
	  var inParams = sow;
	  getDetails_ajax(query, inParams, null);
	  removeAllOptions(document.getElementById('poNo'),1);
      popDropDown('wonNo', ajaxResponse);
} 	 
	 
function getPOList(val){
	   var won =val;	
	    var  query  = 'PO.getPOList';	
	      var sow = document.getElementById('sowName').value;	
	   var inParams = won+','+sow;
	   getDetails_ajax(query, inParams, null,',');	
	   removeAllOptions(document.getElementById('poNo'),1);
	   popDropDown('poNo', ajaxResponse);
} 	 	 
function popDropDown(targetFld, value, noDefFlag)  // ver 1.2
		{
			  temp = value.split('!');// output has to be ! and ~ delimited
			  //temp has one row...split on ~ to get value and display
			  obj = document.getElementById(targetFld);
		  	 if( noDefFlag == null )                            // ver 1.2
			  {													// ver 1.2
			    obj.options[0] = new Option("----Select----",""); 					  
			  }													// ver 1.2
			  
			  for(i = 0 ; i < temp.length ; i++)					  
			  {
				  if(temp[i] != "")
				  {
					  rowValue = temp[i].split('~');
					  for(j = 0 ; j < rowValue.length ; j++)
					  {
					  	  if( noDefFlag == null )        //ver 1.1
					  	  {								// ver 1.1
					  	  
							obj.options[i+1] = new Option(rowValue[1],rowValue[0]); 
						 }			// ver 1.1
						 else        // ver 1.2
						 {			// ver 1.2
						 	obj.options[i] = new Option(rowValue[1],rowValue[0]); // ver 1.2
						 }			// ver 1.2
					  }
				  }
			  }				  
		}	
		
		
 function getPODetails (val) {
 var po = val;
 var query = 'PO.getPODetails';
 var inParams = po;
 
  getDetails_ajax(query, inParams, null);
 
 
  popTextBox('poStartDate',ajaxResponse);
 
  var temp = new Array ();
  temp = ajaxResponse.split("~");
  popTextBox('poStartDate',temp[0]);
  popTextBox('poEndDate',temp[1]);
  popTextBox('poDate',temp[2]);
 
 }

function getUploadedFile()
{
	var sowName=document.poAddForm.sowName.value;
	var poNo=document.poAddForm.poNo.value;
	if(sowName!='' && poNo!='')
	{
		document.forms(0).action='<%=request.getContextPath()%>/poadd.do?method=getUploadedFile&sowName'+sowName+'&poNo'+poNo;
		document.forms(0).submit();
	}
	else
	{
		alert('Please enter Sow Name and Po Number');
		document.poAddForm.sowName.focus();
	}
	
} 
function deletePo()
{
	  var qid='po.BilledPONumbers';
	  if(validateFields('poAddForm'))
	  {
	  	   var inParams=document.poAddForm.poNo.value;
		   var targetFields = null;  
		   getDetails_ajax(qid,inParams,null);	
		   var count =  ajaxResponse.split("!");
		   var cnt=count[0].split("~");	
		   var ct=cnt[0].split(",");;
		   if(ct>0)
		   {
		    alert('Milestones are already billed for this PO.PO cannot be deleted');
		    document.getElementById('deleteButtn').disabled=false;
		    return false;
		   }
		   else
		   {
		   		document.forms(0).action='<%=request.getContextPath()%>/poadd.do?method=deletePo';
				document.forms(0).submit();
		   }
	  }
	  
	  
}


</script>
</head>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="0" bottommargin="20">
<html:form action="poadd.do" method="post" enctype="multipart/form-data">
	<html:hidden property="method" name="poAddForm" />
	<input type="image"   src="" height="0px" width="0px"   onclick="return validate_form('poAddForm');" > 
	<table width=86% CELLPADDING="0" CELLSPACING="0" border="0"
		align="center">
	  	<tr class="thead">
			<td colspan="6" align="center">
     			<b><font size="2"><bean:message key="label.editPO"/></font></b>
		   </td>
		</tr>

		<tr class="trow">
			<logic:notEmpty name="poAddForm" property="msg">
				<td colspan="6" align="center"><br>&nbsp;
					<logic:equal name="poAddForm" property="msg" value="PO Deleted Successfully">
						<font color="green" /> <b><bean:write	name="poAddForm" property="msg" /></b>
					</logic:equal>
					<logic:notEqual name="poAddForm" property="msg" value="PO Deleted Successfully">
						<logic:notEqual name="poAddForm" property= "msg"	value="PO Updated Successfully">
							<font color="red" /><b><bean:write name="poAddForm" property="msg" /></b>
						</logic:notEqual>
					</logic:notEqual>
					<logic:equal name="poAddForm" property="msg" value="PO Updated Successfully">
						<font color="green" /> <b><bean:write	name="poAddForm" property="msg" /></b>
					</logic:equal>
				</td>
			</logic:notEmpty>
		</tr>


		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">

			<td colspan="1"  >&nbsp;&nbsp;<bean:message key="label.sowName"/>  <span style="color: red">*</span></td>
			<td colspan="4"><html:text property="sowName" title="SOW Name" size= "25" maxlength="25" onchange="getSOWPopup(sowName.value+'%');return false;"/> <!-- onchange="getWONList(this.value);"  -->
             <input type="image"  src="<%=request.getContextPath()%>/images/glass.png" alt="Search For SOW Name" name="searchSOWName" onClick="getSOWPopup(sowName.value+'%');return false;">
			</td>
			<td align="right">
				<a  href="javascript:getUploadedFile()"><b><font color="blue">Download File</font></b></a>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>

		<tr class="trow">
			<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.wonNo"/>  <span style="color: red">*</span></td>
			<td colspan="5">
			<html:select property="wonNo"  title="WON NO" name ="poAddForm" onchange ="getPOList(this.value);"  >
				<html:option value="">----Select----</html:option>						
				<logic:notEmpty name="poAddForm" property="wonList">
					<html:optionsCollection name="poAddForm" property="wonList" label="label" value="value" />
				</logic:notEmpty>
			 </html:select>
			 </td>
		</tr>
       

		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
			<tr class="trow">
			<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.poNo"/><span style="color: red">*</span></td>
			<td colspan="5">
			<html:select property="poNo" title="PO NO" name ="poAddForm" onchange ="getPODetails(this.value);" >
				<html:option value="">----Select----</html:option>						
				<logic:notEmpty name="poAddForm" property="poList">
					<html:optionsCollection name="poAddForm" property="poList" label="label" value="value"/>
				</logic:notEmpty>
			 </html:select>
			</td>
		</tr>
		
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.poStartDate"/> <span style="color: red">*</span></td>
			<td colspan="5"><html:text property="poStartDate" title="PO Start Date" size="15" readonly="true" styleClass="disabledformtext" />
			<input type="image" id=""
				src="<%=request.getContextPath()%>/images/calendar.jpg"
				alt="Pick a date"
				onclick="javascript:NewCal('poStartDate','ddmmmyyyy',false,12);return false;" />

			</td>

		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.poEndDate"/><span style="color: red">*</span></td>
			<td colspan="5"><html:text property="poEndDate" title="PO End Date" size="15" readonly="true" styleClass="disabledformtext" />
				 <input type="image" id=""	src="<%=request.getContextPath()%>/images/calendar.jpg"	alt="Pick a date"
				onclick="javascript:NewCal('poEndDate','ddmmmyyyy',false,12);return false;" />
			</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.poDate"/> <span style="color: red">*</span></td>
			<td colspan="5"><html:text property="poDate" title="PO Date" size="15" readonly="true" styleClass="disabledformtext"/>
			 <input type="image" id=""	src="<%=request.getContextPath()%>/images/calendar.jpg" alt="Pick a date"
				onclick="javascript:NewCal('poDate','ddmmmyyyy',false,12);return false;" />
			</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1">&nbsp;&nbsp;<bean:message key="label.browseFile"/>
				</td>
				<td colspan="5">
				<html:file  property="browse_File" title="file" name="poAddForm" alt="Browse" styleClass="disabledformtext"  onkeydown="return enableKey();"/>
				</td>
				
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
			 <html:button value="Update" onclick="validate_form('poAddForm');" styleClass="sbttn" property="update_bttn" /> 
			 <input type="button" value="Delete" onclick="deletePo();" class="sbttn"  id="deleteButtn"/>
			 <input type="button" value="Reset" onclick="resetField();" class="sbttn"  />
			 
			 </td>
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
