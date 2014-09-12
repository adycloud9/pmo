
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
 * FileName:won_Po_Report.jsp
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *						    Prior
 * Date       	By              	    Version  	     Description
 * ---------- 	--------------- 	    -------      -----------------------------------------------
 * 
 * ========================================================================================
 * </pre>
 *
 
 
-->

<html:html>
<head>
<title>WonReportPage</title>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/common.js"></SCRIPT>
<SCRIPT src="<%=request.getContextPath()%>/jscripts/ajaxCalls.js"></SCRIPT>
<SCRIPT src="<%=request.getContextPath()%>/jscripts/commonAjaxFunctions.js"></SCRIPT>
<script type="text/javascript">
 var calFlag=0;
 function modeFunction(mode)
 {

  document.reportForm.mode.value=mode;
  document.forms(0).action = '<%=request.getContextPath()%>/report.do?method=showReportDetails';
  document.forms(0).submit();
 
 
 }
 
 
function flagset()
{ 
	  var mode=document.reportForm.mode.value;
	  if(mode=='won')
	  {
	  	document.getElementById('won').checked=true;
	  }
	 if(mode=='po')
	  {
	  	document.getElementById('po').checked=true;
  	  }
   if(mode=='withoutWCR')
	  {
	  	document.getElementById('withoutWCR').checked=true;
  	  }  
  	  if(mode=='withWCR')
	  {
	  	document.getElementById('withWCR').checked=true;
  	  }  
}

function exportToExcel()
{

document.forms(0).action = '<%=request.getContextPath()%>/report.do?method=exportToExcel';
 document.forms(0).submit();
}


	</script>


</head>
<BODY marginwidth="0" marginheight="0" leftmargin="4" rightmargin="0"
	topmargin="20" bottommargin="20" onload="flagset();" >



<%try{ %>
<html:form action="report.do" method="post" enctype="multipart/form-data">
	<html:hidden name="reportForm" property="method" />
	<html:hidden name="reportForm" property="mode" />
	
			<table width="80%" CELLPADDING="0" CELLSPACING="0" border="1" align="center" >
				<tr class="thead">
		           <td class="thead" colspan="12" align="center"><font size="2"><bean:message key="label.reports"/></font>
				  </td>	
		       </tr>
		        <tr>
		        
					<td class=trow align="center" >
					<input type="radio" name="reportForm" property="reportLevel" id="won" onclick="modeFunction('won');return false;"  /><bean:message key="label.won"/>
					</td>
					<td colspan="3" class=trow align="left">
					<input type="radio" name="reportForm" property="reportLevel" id="po" onclick="modeFunction('po');"/><bean:message key="label.po"/>
					</td>
					 <td colspan="3" class=trow align="left">
					<input type="radio" name="reportForm" property="reportLevel" id="withWCR" onclick="modeFunction('withWCR');"/><bean:message key="label.wcrUnbilled"/>
					</td>
					<td colspan="3" class=trow align="left">
					<input type="radio" name="reportForm" property="reportLevel" id="withoutWCR" onclick="modeFunction('withoutWCR');"/><bean:message key="label.milestonesWithoutWCR"/>
					</td>
				
				</tr>
				
				
				<logic:notEmpty name="reportForm" property="dataList"  >
				<logic:equal value="won" property="mode" name="reportForm">
				
				<table width="80%" cellspacing="1" cellpadding="1" align="center">
						<tr>
						<td>	
						<b><a href='javascript:exportToExcel()'><font face="verdana"
							size="2"><bean:message key="label.exportexcelsheet" /></font></a></b>	
							
						</td>
						</tr>	
							<tr>
								<td class="thead" align="center"><bean:message key="label.sowName"/></td>
								<td class="thead" align="center"><bean:message key="label.preparedBy" /></td>
								
							</tr>
							<tr>&nbsp;
							</tr>
							
							
	              	
			           
			           
			         <logic:iterate name="reportForm" property="dataList" id="dataList" >
		    		 <tr class="trow">
						<td class="trow" nowrap="nowrap" align="center"><bean:write name="dataList" property="sowName" /></td>
						<td class="trow" nowrap="nowrap" align="center"><bean:write	name="dataList" property="preparedBy" /></td>
					</tr>
					</logic:iterate>
								
						
						<tr class="thead">
						<td class="thead" colspan="9" align="center">&nbsp;
				  </td>	
							</tr>
					</table>
				</logic:equal>
				</logic:notEmpty>
				
				 <logic:notEmpty name="reportForm" property="detailsList"  >
		         <logic:equal value="po" property="mode" name="reportForm">
			    <table width="80%" cellspacing="1" cellpadding="1" align="center">
							<tr>
						<td>	
						<b><a href='javascript:exportToExcel()'><font face="verdana"
							size="2"><bean:message key="label.exportexcelsheet" /></font></a></b>	
							
						</td>
						</tr>
							<tr>
								<td class="thead" align="center"><bean:message key="label.sowName"/></td>
								<td class="thead" align="center"><bean:message key="label.preparedBy" /></td>
								
							</tr>
							<tr>&nbsp;
							</tr>
							<logic:iterate name="reportForm" property="detailsList" id="detailsList" >								
								<tr class="trow">
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="detailsList" property="sowName" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write	name="detailsList" property="preparedBy" /></td>
								</tr>
						</logic:iterate>
						<tr class="thead">
						<td class="thead" colspan="9" align="center">&nbsp;
				  </td>	
							</tr>
					</table>
				</logic:equal>
				</logic:notEmpty>
				
				 <logic:notEmpty name="reportForm" property="withoutWCRList">
				
				<logic:equal value="withoutWCR" property="mode" name="reportForm">
				 
				 <table  border="0"  width="80%" cellspacing="1" cellpadding="1" align="center">
							
							<tr>
						<td colspan="3">	
						<b><a href='javascript:exportToExcel()'><font face="verdana"
							size="2"><bean:message key="label.exportexcelsheet" /></font></a></b>	
							
						</td>
						</tr>
							<tr>
								<td class="thead" align="center"><bean:message key="label.sowName"/></td>
								<td class="thead" align="center"><bean:message key="label.preparedBy" /></td>
								<td class="thead" align="center"><bean:message key="label.sowCreationDate" /></td>
								
								<td class="thead" align="center"><bean:message key="label.milestoneName" /></td>
								<td class="thead" align="center"><bean:message key="label.milestoneDate" /></td>
								<td class="thead" align="center"><bean:message key="label.milestoneAmount" /></td>
							</tr>
		                
		                </tr>
							<tr>&nbsp;
							</tr>
							<logic:iterate name="reportForm" property="withoutWCRList" id="wcrList">								
								<tr class="trow">
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="sowName" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="sowCreationDate" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="preparedBy" /></td>
									<td class="trow" nowrap="nowrap" align="left"><bean:write name="wcrList" property="mileStoneName" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="mileStoneDate" /></td>
									<td class="trow" nowrap="nowrap" align="right"><bean:write	name="wcrList" property="mileStoneAmt" /></td>
								</tr>
						</logic:iterate>
						<tr class="thead">
						<td class="thead" colspan="9" align="center">&nbsp;
				 		 </td>	
							</tr>
					</table>
					
				</logic:equal>  
				</logic:notEmpty>   
				  
		         <logic:notEmpty name="reportForm" property="withWCRList">
				<logic:equal value="withWCR" property="mode" name="reportForm">
				 <table  border="0"  width="80%" cellspacing="1" cellpadding="1" align="center">
				 <tr>
						<td colspan="3">	
						<b><a href='javascript:exportToExcel()'><font face="verdana"
							size="2"><bean:message key="label.exportexcelsheet" /></font></a></b>	
							
						</td>
						</tr>
							<tr>
								<td class="thead" align="center"><bean:message key="label.sowName"/></td>
								<td class="thead" align="center"><bean:message key="label.sowCreationDate" /></td>
								<td class="thead" align="center"><bean:message key="label.wonNo" /></td>
								<td class="thead" align="center"><bean:message key="label.poNo" /></td>
								<td class="thead" align="center"><bean:message key="label.milestoneName" /></td>
								<td class="thead" align="center"><bean:message key="label.milestoneAmount" /></td>
								<td class="thead" align="center"><bean:message key="label.preparedBy" /></td>
						    	<td class="thead" align="center"><bean:message key="label.wcrRefId" /></td>
							</tr>
		                
		                </tr>
							<tr>&nbsp;
							</tr>
							<logic:iterate name="reportForm" property="withWCRList" id="wcrList">								
								<tr class="trow">
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="sowName" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="sowCreationDate" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="wonNum" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="poNum" /></td>
									<td class="trow" nowrap="nowrap" align="left"><bean:write name="wcrList" property="mileStoneName" /></td>
									<td class="trow" nowrap="nowrap" align="right"><bean:write	name="wcrList" property="mileStoneAmt" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="preparedBy" /></td>
									<td class="trow" nowrap="nowrap" align="center"><bean:write name="wcrList" property="wcr_ref" /></td>
								</tr>
						</logic:iterate>
						<tr class="thead">
						<td class="thead" colspan="9" align="center">&nbsp;
				 		 </td>	
							</tr>
					</table>
				</logic:equal>  
				</logic:notEmpty>   	
				
				
			</table>
</html:form>

</body>
<%}catch(Exception e){
	e.printStackTrace();
	}%>

</html:html>
