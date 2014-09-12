<!--
 * JSP
 *
 * Name: wcrPreview.jsp
 * Action Class : WcrCreateAction.java  
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

<%
		try {
		String cDate = "";
%>
<html:html>
<head>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
<style type="text/css" media="print">  
.NonPrintable
    {
      display: none;
    }  
    
    
</style>
<style type="text/css">
 .boxed {
  border: 1px solid black ;
  width:100px;
  height:60px;
  padding-bottom:30px;
  margin: 15px;
  border-spacing:10px;
  padding-top: 30px;
  border-color: black;
}
.boxedTitle{
  border: 1px solid black ;
  width:100px;
  height:50px;
  padding-bottom:25px;
  padding-top: 25px;
}
li {
     line-height: 10px;
     letter-spacing: 1px;
     word-spacing: 4px;
     
   }

</style>
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

function getCurrdate()
{
var currDate=getCurrentDate();

document.getElementById('current').innerHTML='Date:'+currDate;

}

function goBack()
{
if(document.getElementById('status').value=='save&Preview')
{
 document.forms(0).action = "<%=request.getContextPath()%>/wcr.do?method=showWcr";
}
else if(document.getElementById('status').value=='onlyPreview')
{
 document.forms(0).action = '<%=request.getContextPath()%>/wcr.do?method=getMilestoneDetailsTemp&delIndex=-1';
} 
else if(document.getElementById('status').value=='onlyPreviewDuringUpdate')
{
 document.forms(0).action = '<%=request.getContextPath()%>/wcr.do?method=getMilestoneDetailsForEditTemp&delIndex=-1';
}
 else if(document.getElementById('status').value=='update&Preview')
{
 document.forms(0).action = "<%=request.getContextPath()%>/wcr.do?method=showEditWcr";
}
document.forms(0).submit();
} 

function amountWithComma()
{
var amntTotal=0;

amntTotal=document.wcrForm.totalAmt.value;
var total =amntTotal;

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
	
		total = total.replace(/[.]+[0]+$/g,'.00');
		total=total+' (INR)';
	
	}
	document.getElementById('totalAmount').innerHTML=total;
	
	return true;
	
}


</script>
</head>
<body onload="getCurrdate();amountWithComma();">
<br />
<br />
<html:form action="wcr.do" method="post">
	<html:hidden property="method" name="wcrForm" />
	<html:hidden property="status" name="wcrForm" />
	<html:hidden property="totalAmt" name="wcrForm" />
	<input type="hidden" id="cdate" />
	<table width=95% CELLPADDING="0" CELLSPACING="0" border="0"
		align="center" valign="top">
		<tr>
			<td colspan="6" align="center"><u> <b><font size="6"><bean:message key="label.wcrTitle"/> </font></b></u></td>
		</tr>
		
		<tr>
		<td colspan="6">
		<br>
		<br>&nbsp;
		</td>
		</tr>
		<tr>
			<!-- td align="left"><font face="Comic Sans MS" size="1">
			<bean:message key="label.wcrReference"/>:</font>
			<b><font face="Comic Sans MS" size="1">&nbsp;
			<bean:write property="wcrRefId" name="wcrForm" />
			</font>
			</td -->
			
			<td colspan="5">&nbsp;</td>
			<td align="right" nowrap="nowrap"><font face="Comic Sans MS" size="1">
			<div id="current"></div>
			</font></td>
		</tr>


	</table>
	<br>
	<table width=70% CELLPADDING="0" CELLSPACING="0" align="center" border="0"
		valign="top">


		<tr>

			<td align="left" colspan="2"><b><font face="Comic Sans MS"
				size="1"><bean:message key="label.forPeriod"/> &nbsp;:</font></b></td>
			<td><font face="Comic Sans MS" size="1"><bean:message key="label.from"/> </font></td>
			<td bgcolor="#CCCCCC"><font face="Comic Sans MS" size="1"><B><bean:write
				property="fromDate" name="wcrForm" /></B></font></td>
			<td><font face="Comic Sans MS" size="1"><bean:message key="label.to"/> </FONT></td>
			<td bgcolor="#CCCCCC"><font face="Comic Sans MS" size="1"><B><bean:write
				property="toDate" name="wcrForm" /></B></font></td>
		</tr>


	</table>
	<br>
	<table width=80% CELLPADDING="0" CELLSPACING="0" align="center" border="0"
		valign="top">

		<br>
		<tr>

			<td width="18%" align="left"><font face="Comic Sans MS"
				size="1"><bean:message key="label.project"/></font></td>
			<td width="2%" align="center" nowrap>:</td>
			<td width=80% align="left" bgcolor="#CCCCCC"><b>&nbsp;<font
				face="Comic Sans MS" size="1"><bean:write property="sowName"
				name="wcrForm" /></font></b></td>
		</tr>
	</table>
	<table width=80% CELLPADDING="0" CELLSPACING="0" align="center" border="0"
		valign="top">

		<br>
		<tr>

			<td width="18%" align="left"><font face="Comic Sans MS"
				size="1"><bean:message key="label.businessUnit"/></font></td>
			<td width="2%" align="center" nowrap>:</td>
			<td width="80%" align="left" bgcolor="#CCCCCC">&nbsp;<font
				face="Comic Sans MS" size="1"><b><bean:write
				property="businessUnit" name="wcrForm" /></b></font></td>
		</tr>


	</table>
	<table width=80% CELLPADDING="0" CELLSPACING="0" align="center" border="0"
		valign="top">

		<br>
		<tr>

			<td align="left" width="18%"><font face="Comic Sans MS"
				size="1"><bean:message key="label.sopoNumber"/></font></td>
			<td width="2%" align="center" nowrap>:</td>
			<td width=80% align="left" bgcolor="#CCCCCC">&nbsp;<font
				face="Comic Sans MS" size="1"><b><bean:write
				property="poNo" name="wcrForm" /></b></font></td>
		</tr>


	</table>
	<table width=80% CELLPADDING="0" CELLSPACING="0" align="center" border="0"
		valign="top">

		<br>
		<tr>

			<td align="left" width="18%"
				rowspan="<bean:write name="wcrForm" property="listSize" />"><font
				face="Comic Sans MS" size="1"><bean:message key="label.milestoneName"/></font></td>
			<td width="2%" align="center" nowrap>:</td>

			<td width="80%" bgcolor="#CCCCCC"><logic:notEmpty
				property="milestoneDtlsList" name="wcrForm">
				<bean:define property="milestoneDtlsList" name="wcrForm" id="mList" type="java.util.ArrayList"/>
				
				<logic:iterate property="milestoneDtlsList" name="wcrForm" id="milestoneDtlsList" indexId="count">
					<%System.out.print("milestoneDtlsList=======>"+((com.vsnl.model.WcrAdd)mList.get(count.intValue())).getMilestoneName());%>
					<%System.out.println("") ;%>
					<%System.out.print("milestoneDtlsList BillingCheck=======>"+((com.vsnl.model.WcrAdd)mList.get(count.intValue())).getBillingCheck()); %>
					<logic:equal property="billingCheck" name="milestoneDtlsList"
					value="true">
						<font face="Comic Sans MS" size="1">
						 <b>
						<logic:greaterThan name="wcrForm" property="listSize" value="1">  
						<br>
						<UL>
							<LI style="align:left;"><bean:write property="milestoneName"
								name="milestoneDtlsList" />&nbsp;(INR <bean:write
								property="milestoneAmtFormatted" name="milestoneDtlsList" />)</LI>
						</UL>
						</logic:greaterThan>
						<logic:equal name="wcrForm" property="listSize" value="1"> 
						<bean:write property="milestoneName" name="milestoneDtlsList" /> 
						</logic:equal>
						
						</b> </logic:equal></font>
				</logic:iterate>
			</logic:notEmpty></td>
		</tr>
	</TABLE>
	<table width=80% CELLPADDING="0" CELLSPACING="0" align="center"
		valign="top">

		<br>
		<tr>

			<td align="left" width="18%" nowrap><font face="Comic Sans MS"
				size="1"><bean:message key="label.milestoneAmount"/></font></td>
			<td width="2%" align="center" nowrap>:</td>


			<td align="left" width="80%" bgcolor="#CCCCCC"><b><font
				face="Comic Sans MS" size="1">
			<b><div id='totalAmount'></div></b>
			</font></b></td>
		</tr>

	</table>
	<table width=80% CELLPADDING="0" CELLSPACING="0" align="center"
		valign="top">

		<br>
		<tr>

			<td width="18%" align="left"><font face="Comic Sans MS"
				size="1"><bean:message key="label.won"/></font></td>
			<td width="2%" align="center" nowrap>:</td>
			<td width=80% align="left" bgcolor="#CCCCCC"><font
				face="Comic Sans MS" size="1"><b>&nbsp;<bean:write
				property="wonNo" name="wcrForm" /></b></font></td>
		</tr>


	</table>


	<table width=80% CELLPADDING="0" CELLSPACING="0" border="1"
		align="center" valign="top">

		<br>
		<tr bgcolor="#CCCCCC">

			<td align="left" width="5%" nowrap><font face="Comic Sans MS"
				size="1">&nbsp;<bean:message key="label.itemId"/></font></td>
			<td align="center" width="50%"><font face="Comic Sans MS"
				size="1"><bean:message key="label.itemDescription"/></font></td>
			<td align="center" width="40%"><font face="Comic Sans MS"
				size="1"><bean:message key="label.invoiceandDate"/></font></td>
		</tr>
		<%
		int i = 0;
		%>
		<logic:notEmpty property="milestoneDtlsList" name="wcrForm">
			<logic:iterate property="milestoneDtlsList" name="wcrForm"
				id="milestoneDtlsList" indexId="count">

				<html:hidden property="billingCheck" name="milestoneDtlsList"
					indexed="true" />
				<html:hidden property="milestoneName" name="milestoneDtlsList"
					indexed="true" />

				<logic:equal property="billingCheck" name="milestoneDtlsList"
					value="true">
					<%
					i++;
					%>
					<tr>
						<td align="left" width="5%"><font face="Comic Sans MS"
							size="1">&nbsp;<%=String.valueOf(i)%></font></td>
						<td align="left" width="55%"><font face="Comic Sans MS"
							size="1"><bean:write property="milestoneName"
							name="milestoneDtlsList" /></font></td>
						<td align="left" width="40%">&nbsp;</td>
					</tr>
				</logic:equal>
			</logic:iterate>
		</logic:notEmpty>





	</table>
	<br>
	<table width=70% CELLPADDING="0" CELLSPACING="0" border="0"
		align="center" valign="top">
		<logic:greaterThan name="wcrForm" property="listSize" value="3">
			<div style="page-break-after:always">
		</logic:greaterThan>
		<tr>
			<td align="center"><b><font size="1">&nbsp;</font></b></td>
			<td align="center" valign="center">
			<div class="boxedTitle"><font face="Comic Sans MS" size="1"><b><bean:message key="label.name"/></b>
			</font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxedTitle"><font face="Comic Sans MS" size="1"><b><bean:message key="label.designation"/></b></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxedTitle"><font face="Comic Sans MS" size="1"><b><bean:message key="label.signature"/></b></font></div>
			</td>
		</tr>
		<tr></tr>
		<tr></tr>

		<tr>
			<td align="center" nowrap valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1"><b><bean:message key="label.preparedBy"/></b></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1"><bean:write
				property="preparedBy" name="wcrForm" /></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1"><bean:write
				property="prepByDesig" name="wcrForm" /></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1">&nbsp;</font></div>
			</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
			<td align="center" nowrap valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1"><b><bean:message key="label.approvedBy"/></b></font>
			</td>
			<td align="center" valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1"><bean:write
				property="approvedBy" name="wcrForm" /></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxed" align="center"><font face="Comic Sans MS"
				size="1"><bean:write
				property="appByDesig" name="wcrForm" /></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1">&nbsp;</font></div>
			</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>

			<td align="center" nowrap valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1"><b><bean:message key="label.authorisedBy"/></b></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1"><bean:write
				property="authorisedBy" name="wcrForm" /></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1"><bean:write
				property="authByDesig" name="wcrForm" /></font></div>
			</td>
			<td align="center" valign="center">
			<div class="boxed"><font face="Comic Sans MS" size="1">&nbsp;</font></div>
			</td>
		</tr>
		<logic:greaterThan name="wcrForm" property="listSize" value="3">

			</div>
		</logic:greaterThan>
	</table>

	<br>
	<br>
	<table width=80% CELLPADDING="0" CELLSPACING="0" class="NonPrintable"
		align="center" valign="top">
		<tr>
			<td align="center" class="thead">
				<logic:equal name="wcrForm" property="visibility" value="False">
					<html:button value="Print"	styleClass="sbttn" property="submitForm" onclick="javascript:window.print()" /> 
					<html:button value="Close" styleClass="sbttn" property="close_bttn" onclick="javascript:window.close()" />  
				</logic:equal>
				<logic:notEqual name="wcrForm" property="visibility" value="False">	
					<html:button value="Print"	styleClass="sbttn" property="submitForm" onclick="javascript:window.print()" /> 
					<html:button value="Back" styleClass="sbttn" property="backForm" onclick="goBack();" />
			    </logic:notEqual>
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
