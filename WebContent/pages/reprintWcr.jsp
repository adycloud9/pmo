<!--
 * JSP
 *
 * Name: reprintWcr.jsp
 * Action Class : WcrCreateAction.java  
 * Form Class   :WcrForm.java 
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
  var list = new Array('sowName'); 
	if(validate('wcrForm',list)){
		 
		}else {
	return false;
	}
     
	 document.wcrForm.method.value="getWcrDetails";
     document.wcrForm.submit();
	
}

function resetWCR()
	 {
		
		 document.forms(0).action = "<%=request.getContextPath()%>/wcr.do?method=showReprintWcr";
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

   

function  previewWcrForReprint(count)
{
    var sowName = document.wcrForm.elements['wcrDetailsList['+count+'].sowName'].value;
    var wonNo = document.wcrForm.elements['wcrDetailsList['+count+'].wonNo'].value;
    var poNo = document.wcrForm.elements['wcrDetailsList['+count+'].poNo'].value;
    var refId =document.wcrForm.elements['wcrDetailsList['+count+'].wcrRefId'].value;
    strURL = "<%=request.getContextPath()%>/wcr.do?method=previewWcr&sowName="+sowName+"&wonNo="+wonNo+"&poNo="+poNo+"&refId="+refId;
	window.open(strURL,"Preview","toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=100,top=20,width=800,height=500");
} 	

</script>
</head>
<html:form action="wcr.do" method= "post" onsubmit="return false;" >
<html:hidden property="method" name="wcrForm"/>
<html:hidden property="selectedIndex" name="wcrForm"/>
<html:hidden property="prepByDesig" name="wcrForm"/>
<html:hidden property="appByDesig" name="wcrForm"/>
<html:hidden property="authByDesig" name="wcrForm"/>

<html:hidden property="status" name="wcrForm"/>
<html:hidden property="listSize" name="wcrForm"/>

	<table width=95% CELLPADDING="0" CELLSPACING="0" border="0"	align="center" valign="top">
         <tr class="thead">
		  	 <td colspan="6" align="center">
     				<b><font size="2"><bean:message key="label.ReprintWcr"/></font></b>
		  	 </td>
		</tr>
	 	<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>

		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">
		 	 <td colspan="1"  >&nbsp;&nbsp;<bean:message key="label.sowName"/> <span style="color: red">*</span></td>
			  <td colspan="1">
					   
          	 	   <logic:notEmpty name="wcrForm" property="visibility">
					<html:text property="sowName" title="SOW Name" size= "25" maxlength ="25"	onchange="getSOWPopUp(this.value+'%');return false;" disabled="true"/>
					 <input type="image" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For SOW Name" name="searchSOWName">
				  </logic:notEmpty>
          	 	  <logic:empty name="wcrForm" property="visibility">
          	 	 	<html:text property="sowName" title="SOW Name" size= "25" maxlength ="25"	onchange="getSOWPopUp(this.value+'%');return false;"/>
          	 	 	<input type="image" src="<%=request.getContextPath()%>/images/glass.png" alt="Search For SOW Name" name="searchSOWName" onClick="getSOWPopUp(sowName.value+'%');return false;">
          	 	  </logic:empty>
          	 	    
            	</td>
            	<td colspan="1"  align="left" >&nbsp;&nbsp;<bean:message key="label.wonNo"/></td>
				<td colspan="1">
					<logic:notEmpty name="wcrForm" property="visibility">
					<html:select property="wonNo"  title="WON NO" name ="wcrForm" onchange ="getPOList(this.value);" disabled="true" >
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
            	<td colspan="1" >&nbsp;&nbsp;<bean:message key="label.poNo"/></td>
				<td colspan="1">
					<logic:notEmpty name="wcrForm" property="visibility">
					<html:select property="poNo" title="PO NO" name ="wcrForm" disabled="true" >
						<html:option value="">----Select----</html:option>						
							<logic:notEmpty name="wcrForm" property="poList">
								<html:optionsCollection name="wcrForm" property="poList" label="label" value="value"/>
							</logic:notEmpty>
					 </html:select>
					 </logic:notEmpty>
					 <logic:empty name="wcrForm" property="visibility">
					 <html:select property="poNo" title="PO NO" name ="wcrForm" >
						<html:option value="">----Select----</html:option>						
							<logic:notEmpty name="wcrForm" property="poList">
								<html:optionsCollection name="wcrForm" property="poList" label="label" value="value"/>
							</logic:notEmpty>
					 </html:select>
					 </logic:empty>
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
				  <logic:notEmpty name="wcrForm" property="visibility">
					    <html:button value="Populate" onclick="validate_form('wcrForm');" styleClass="sbttn" property="submit_bttn" disabled="true"/> 
					    <html:button value="Reset" onclick="resetWCR();" styleClass="sbttn" property="reset_bttn"  disabled="true"/> 
				  </logic:notEmpty>
				  <logic:empty name="wcrForm" property="visibility">
					  <html:button value="Populate" onclick="validate_form('wcrForm');" styleClass="sbttn" property="submit_bttn"/> 
					  <html:button value="Reset" onclick="resetWCR();" styleClass="sbttn" property="reset_bttn" />
				  </logic:empty>
				
		 </tr>
	      <tr class=trow>
  		  	<logic:notEmpty name="wcrForm" property="visibility">
		     	 <logic:empty property="wcrDetailsList" name="wcrForm" >
		     	  	<tr class="trow">
						<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
	        	    </tr>
		     	    <tr class="trow">
						<td colspan="6" class="trow" align="center"><b><bean:message key="label.noRecords" /></b></td>
				    </tr>
				    <tr class="trow">
						<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
	        	    </tr>
	        	    <tr class=thead>
						<td colspan="6" align=center>&nbsp;&nbsp;
	 		         	<html:button value="Cancel" onclick="resetWCR()" styleClass="sbttn" property="reset_bttn" /> 
	 		         	</td>
	               </tr>
		     	 </logic:empty>
		     	 <logic:notEmpty property="wcrDetailsList" name="wcrForm" >
		     	 <tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
	        	</tr>
			     <tr class="trow">
					<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				 </tr>
				 
		         <tr class="thead">
		          	<td colspan="6" >
		           		<tr class="trow">
							<td colspan="6">
								<logic:lessEqual property="totalSize" name="wcrForm" value="4">
										<div id='cloneTable' style="width: 100%;height:0;overflow: auto; border: 4px">
								</logic:lessEqual>
								<logic:greaterThan property="totalSize" name="wcrForm" value="4">
									<div id='cloneTable'style="width: 100%;height:150;overflow: auto; border: 4px">
								</logic:greaterThan>
								<table width=100% CELLPADDING="2" CELLSPACING="0" border="1" id="mileTable">
										<tr align="left" class="fixedThead">
												<td align="left"><bean:message key="label.sowName"/></td>
												<td align="left"><bean:message key="label.wonNo"/></td>
												<td align="left"><bean:message key="label.poNo"/></td>
												<td align="left"><bean:message key="label.wcrRef"/></td>
												<td align="left"><bean:message key="search.action"/></td>
											</tr>
										 	<tr>
										 		
												<logic:notEmpty property="wcrDetailsList" name="wcrForm" >
										    		<%
													  int totalValue = 0; 
													 %>
										    		<logic:iterate property="wcrDetailsList" name="wcrForm" id="wcrDetailsList" indexId="count">
							                   			 <%
														  totalValue++;
														 %>
							                   			<tr class=trow>
							                   		      <html:hidden property="sowName" name="wcrDetailsList" indexed="true" />
							                   		      <html:hidden property="wonNo" name="wcrDetailsList" indexed="true" />
							                   		      <html:hidden property="poNo" name="wcrDetailsList" indexed="true" /> 
							                   		      <html:hidden property="wcrRefId" name="wcrDetailsList" indexed="true" />                   		 
							                   		      <td align="left">									
														 	<bean:write property="sowName" name="wcrDetailsList"  />								
										   				  </td>	
										   		    	  <td align="left">									
												 			<bean:write property="wonNo" name="wcrDetailsList" />								
										   				  </td>	
										   				  <td align="left">									
												 			<bean:write property="poNo" name="wcrDetailsList" />								
										   			      </td>	
										   		 		  <td align="left">									
												 			<bean:write property="wcrRefId" name="wcrDetailsList" />								
										   				  </td>
										   				  <td align="left">									
												 			<a href="#" onclick="previewWcrForReprint(<%=count%>);return false;"><bean:message key="label.preview"/> 							
										   				  </td>
										   			  </tr>
										   			 <input type="hidden" name="rowCount" id='rowCount' value='1'/>
							              		 	</logic:iterate>
							              		 	<input type="hidden" value='<%=String.valueOf(totalValue)%>' name="totalRecords" /><!--ver 1.1-->
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
		 		   <tr class=thead>
						<td colspan="6" align=center>&nbsp;&nbsp;
	 		         	<html:button value="Cancel" onclick="resetWCR()" styleClass="sbttn" property="reset_bttn" /> 
	 		         	</td>
	               </tr>
		
				 </logic:notEmpty>
		     	
			
		    </logic:notEmpty>
		  </tr>
	      
	       
	</table>

</html:form>
</body>
</html:html>
<%} catch (Exception e) { e.printStackTrace();} %>