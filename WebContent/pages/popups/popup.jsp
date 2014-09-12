<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0);
response.setHeader("Pragma","no-cache");
%>



<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/displaytag" prefix="display"%>


 
 
 
 <!--
 * JSP
 *
 * Name: popup.jsp
 * Action Class : .java  
 * Form Class   : .java 
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *                            			Prior
 * Date       	By              	    Version  	     Description
 * ---------- 	--------------- 	    -------      -----------------------------------------------
 * 06-Sept-10   Soumya Singhai 			1.0	 		Created the page.
  * ========================================================================================
 * </pre>
 *
 
 
-->

<html:html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<title>Search Pop Up</title>  
<LINK rel='stylesheet' href='<%=request.getContextPath()%>/style/global.css'>
<LINK rel='stylesheet' href='<%=request.getContextPath()%>/style/displaytag.css'>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/datetimepicker.js"></SCRIPT>
<script src='<%=request.getContextPath()%>/jscripts/jscommon.js'></script>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/calendar.js"></SCRIPT>
<script language="JavaScript" src="<%=request.getContextPath()%>/jscripts/validation.js"></script>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/common.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/jscripts/form.js"></SCRIPT>
<SCRIPT>

 	function sendValue(str)
 	{
		targetFields = document.getElementById('targetFields').value;
		//split target fields on , 
			targetArr = targetFields.split(',');
		//split string on ~
			resultArr = str.split('~');
		
		
		var tableValue=document.getElementById('tableValue').value;		
		var rowValue=document.getElementById('rowValue').value;		
		var cellValue=document.getElementById('cellValue').value;
		var tableFlag =document.getElementById('tableFlag').value;				
		
		if(tableFlag=='T')
		{
			cellArr= cellValue.split(',');
			for( ctr = 0 ; ctr < cellArr.length; ctr++)
			{
				var cell=cellArr[ctr];				
				window.opener.document.getElementById(tableValue).rows[rowValue].cells[cell].childNodes[0].value=resultArr[ctr];				
			}		
		}
		else
		{
	
			// run loop on the array...
			for( ctr = 0 ; ctr < targetArr.length; ctr++)
			{
				window.opener.document.getElementById(targetArr[ctr]).value = resultArr[ctr];
			}		
		} 
		
		// run post-selection function if there is any...
		var functionName = document.getElementById('postSelFunc').value;

		if(functionName != null && functionName != "")
			eval('window.opener.' + functionName + '()');
		
		//close popup window
		window.close();
 	}
		
 </SCRIPT>
</HEAD>
<%try{  %>
<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="0" bottommargin="20">

<html:form action="getPopup.do" method="post" enctype="multipart/form-data">
	<html:hidden property="targetFields" name = "popupForm"/>
	<html:hidden property="tableValue" name = "popupForm"/> 
	<html:hidden property="rowValue" name = "popupForm"/>
	<html:hidden property="cellValue" name = "popupForm"/>
	<html:hidden property="tableFlag" name = "popupForm"/>
	
<%int headersize=0; %>
<bean:define id="headerArray" name="popupForm" property="headerList" type="java.lang.String[]" />
<%headersize=headerArray.length;%>
    <html:hidden property="postSelFunc" name = "popupForm"/> 
	<table CELLPADDING="1" CELLSPACING="1" align="center"   width="100%" >
		<%-- 	<tr class=thead align="center">	<!-- Ver 1.3  added align='center'-->
				<!-- add headers dynamically -->
				<% String[] header=null; %>
				<logic:notEmpty name="popupForm" property="headerList">
					<%int i=0;%>
				<%System.out.println("1"); %>
			
				<logic:iterate id="headerList" name="popupForm" property="headerList" indexId="count">
						<td>
						 	<% header=headerArray;
						 	System.out.println("headerArray"+header[i]); %>
						    <%headersize++; %>
							<bean:write name="headerList" />
						</td>					
					</logic:iterate>	
							
				</logic:notEmpty>
			</tr>--%>
	
	<!-- if search does not yield any results -->
		<logic:empty  name="popupForm" property="resultList">
			<tr class=thead>&nbsp;&nbsp;  
			</tr>	
			<tr>
				<td align="center">
					<font face="Arial" size=2>No Records found!!!!</font>
				</td>
			</tr>				
		</logic:empty>

	<!-- if search is having results -->
		<logic:notEmpty name="popupForm" property="resultList">
		<bean:define id="res" name="popupForm" property="resultList" type="java.util.List"/>
		<%int listSize=res.size();%>
			
			<tr>
			<td colspan="4">
				<bean:define id="headerArray" name="popupForm" property="headerList" type="java.lang.String[]" />
               <display:table  class="displayTable  th" style="width=100%;border=1" id="data" name="sessionScope.popupForm.resultList" requestURI="/getPopup.do" pagesize="10">
               <%
               	if(listSize<=10)
				{%>
				<display:setProperty name="paging.banner.page.selected" value="" />
				<%}%>	
               
				<% String details[]=(String [])data;
				String temp="";
				for(int i=0; i<headersize;i++)
				{  temp+=details[i]+ "~";
				}
				System.out.print("============>1"+headersize);
				for(int i=0; i<headersize;i++)
					{  
					System.out.println("details"+headerArray[i]);
					%>	
					
					<display:column class="displayTable  td" title="<%=headerArray[i]%>">
					
	                <a href="javascript:sendValue('<%=temp%>')"><%=details[i]%></a>				
				    
					</display:column>
					
					<%--<display:column headerClass="thead" class="trow" title="<%=headerArray[i]%>">
				    <a href="#" onclick="sendValue('<%=t%>')"><%=details[i]%></a>
					</display:column>--%>
					<%}%>
				</display:table>
			</td>
		</tr>
		</logic:notEmpty>
		
			<tr class=thead align=center>
	                     <td colspan=4 >
					<input type="Button" class="sbttn" value="Close" onclick="self.close();">
				</td>
			</tr>
	</table>	

</html:form>
</body>
<%}	catch(Exception e)
{
	System.out.println("e...->" + e.getMessage());
	e.printStackTrace();
	
}%>
</html:html>
