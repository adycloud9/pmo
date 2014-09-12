<!--
 * JSP
 *
 * Name: poAddEdit.jsp
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


function validate_form(form)
{
   var list = new Array('sowName','wonNo','poNo','poStartDate','poEndDate','poDate','browse_File'); 
   if(validate('poAddForm',list))
   {
  	     var poNum=document.getElementById('poNo');
    	 var poStDate=document.getElementById('poStartDate').value;
		 var poEdDate=document.getElementById('poEndDate').value; 
		 var rtrn = isDateLessThanEqualTo(poStDate,poEdDate);
		if(rtrn == false){
		 alert("End date should be greater than Start Date");
	     return false;
	    }
	} else {
	return false;
	}
	document.forms(0).action = "<%=request.getContextPath()%>/poadd.do?method=addPo";
	document.forms(0).submit();
}


function resetField()
	 {
		 document.forms(0).action = "<%=request.getContextPath()%>/poadd.do?method=showPage";
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
	  popDropDown('wonNo', ajaxResponse);
} 	   	
</script>
</head>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="5" bottommargin="20">


<html:form action="poadd.do" method= "post" enctype="multipart/form-data">
	<html:hidden property="method" name="poAddForm"/>
		<input type="image" scr="" height="0px" width="0px" onclick="return validate_form('poAddForm') ;"/>
	<table width=80% CELLPADDING="0" CELLSPACING="0" border="0"	align="center" valign="top">
         <tr class="thead">
		   <td colspan="6" align="center">
     			<b><font size="2"><bean:message key="label.addPO"/></font></b>
		   </td>
		</tr>
	 	
	 	<tr class="trow">
	 		<logic:notEmpty name = "poAddForm" property = "msg">
	 		 
	 		  <logic:notEqual name = "poAddForm" property = "msg" value ="PO Attached Successfully">
		 		  <td colspan="6" align= "center"><br>&nbsp;
		 			  <b>
		 	  			 <font color="red"   />
			  			 	<bean:write  name = "poAddForm" property = "msg"  /></b>
			 	  	</td>
			 </logic:notEqual>
			 <logic:equal name = "poAddForm" property = "msg" value ="PO Attached Successfully">	
				 <td colspan="6" align= "center"><br>&nbsp;
			 	   <b>
		 			   <font color="green" />
						   	<bean:write  name = "poAddForm" property = "msg"  /></b>
				 </td>
				</logic:equal>	   	
			</logic:notEmpty>	
		</tr>	
		
	
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
		 
			<td colspan="1"  >&nbsp;&nbsp;<bean:message key="label.sowName"/> <span style="color: red">*</span></td>
			<td colspan="5"><html:text property="sowName" title="SOW Name" size= "25" maxlength ="25"	onchange="getSOWPopUp(this.value+'%');return false;"/>
           	    <input type="image" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For SOW Name" name="searchSOWName" onClick="getSOWPopUp(sowName.value+'%');return false;">
            </td>		
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1"  align="left" >&nbsp;&nbsp;<bean:message key="label.wonNo"/><span style="color: red">*</span></td>
			<td colspan="5">
			<html:select property="wonNo"  title="WON NO" name ="poAddForm"   >
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
			<td colspan="1"  >&nbsp;&nbsp;<bean:message key="label.poNo"/><span style="color: red">*</span></td>
			<td colspan="5"><html:text onchange="isNumeric(this);"  property="poNo" title="PO NO" size="15" maxlength ="8" /></td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1"  >&nbsp;&nbsp;<bean:message key="label.poStartDate"/><span style="color: red">*</span></td>
			<td colspan="5"><html:text property="poStartDate" title="PO Start Date" size= "15" readonly="true" styleClass="disabledformtext" />
				<input type="image"	id=""
				src="<%=request.getContextPath()%>/images/calendar.jpg"
				alt="Pick a date"
				onclick="javascript:NewCal('poStartDate','ddmmmyyyy',false,12);return false;" />
			
			</td>
		
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.poEndDate"/> <span style="color: red">*</span></td>
			<td colspan="5"><html:text property="poEndDate" title="PO End Date" size= "15"	readonly="true" styleClass="disabledformtext" />
				<input type="image"	id=""
				src="<%=request.getContextPath()%>/images/calendar.jpg"
				alt="Pick a date"
				onclick="javascript:NewCal('poEndDate','ddmmmyyyy',false,12);return false;" />
			</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.poDate"/><span style="color: red">*</span></td>
		<td colspan="5"><html:text property="poDate" title="PO Date" size= "15"	 readonly="true" styleClass="disabledformtext" />
				<input type="image"	id=""
				src="<%=request.getContextPath()%>/images/calendar.jpg"
				alt="Pick a date"
				onclick="javascript:NewCal('poDate','ddmmmyyyy',false,12);return false;" />
			</td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
			<td >&nbsp;&nbsp;<bean:message key="label.browseFile"/>
				<font  color="red"><bean:message key="label.starSign"/></font>
				</td>
				<td>
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
			<html:button value="Add" onclick="validate_form('poAddForm');" styleClass="sbttn" property="submit_bttn"/> 
			<input type="button"class="sbttn" name="Reset" value="Reset" onclick="resetField();"/>
		</tr>
	</table>

</html:form>
</body>
</html:html>
<%} catch (Exception e) { e.printStackTrace();} %>