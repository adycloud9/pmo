<!--
 * JSP
 *
 * Name: loginPopup.jsp
 *
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *                            		Prior
 * Date       	By              	Version  	Description
 * ---------- 	--------------- 	-------  ----------------------------------------------------
 * 
 *========================================================================================
 * </pre>
 *
 
 
-->
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ page import="java.util.*"%>
<html:html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">

<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
<script src='<%=request.getContextPath()%>/jscripts/jscommon.js'></script>
<script src='<%=request.getContextPath()%>/jscripts/common.js'></script>

<title>Welcome User</title>

<script>

</script>
</head>

<BODY marginwidth="0" marginheight="0" leftmargin=0 rightmargin=0
	topmargin=0 bottommargin=20>
<br>
<table width=90% cellpadding=2 cellspacing=1 border=0 align=center>
	<tr align="center" class=thead>
		<td colspan="3"><b><font face="Verdana" size="2">Message
		for Sales User</font></b></td>
	</tr>
	<tr>
		<td colspan="3">Please check if you are able to view details of
		all your accounts.</td>
	</tr>
	<tr>
		<td colspan="3">In case of any discrepancy, contact the following
		persons to get it rectified:</td>
	</tr>

	<tr align="center" class=thead>
		<td><bean:message key="page.name" /></td>
		<td><bean:message key="page.telephone" /></td>
		<td><bean:message key="page.email" /></td>
	</tr>

	<tr align="center">
		<td><bean:message key="contact1.name" /></td>
		<td><bean:message key="contact1.telephone" /></td>
		<td><bean:message key="contact1.email" /></td>
	</tr>

	<tr align="center">
		<td><bean:message key="contact2.name" /></td>
		<td><bean:message key="contact2.telephone" /></td>
		<td><bean:message key="contact2.email" /></td>
	</tr>

	<tr align="center">
		<td><bean:message key="contact3.name" /></td>
		<td><bean:message key="contact3.telephone" /></td>
		<td><bean:message key="contact3.email" /></td>
	</tr>



	<!-- 	
		<tr>
			<td align=center height=18>
				<bean:message key="page.name" /> 	<bean:message key="contact1.name" /> 	,  
				<bean:message key="page.telephone" />	<bean:message key="contact1.telephone" />, 
				<bean:message key="page.email" />	<bean:message key="contact1.email" />,     
			</td>
		</tr>
		<tr>
			<td align=center height=18>
				<bean:message key="page.name" /> 	<bean:message key="contact2.name" /> 	,  
				<bean:message key="page.telephone" />	<bean:message key="contact2.telephone" />, 
				<bean:message key="page.email" />	<bean:message key="contact2.email" />,     
			</td>
		</tr>

		<tr>
			<td align=center height=18>
				<bean:message key="page.name" /> 	<bean:message key="contact3.name" /> 	,  
				<bean:message key="page.telephone" />	<bean:message key="contact3.telephone" />, 
				<bean:message key="page.email" />	<bean:message key="contact3.email" />,     
			</td>
		</tr>
		
		<br><br><br><br><br> -->
</table>

<br>
<br>
<table width=90% cellpadding=2 cellspacing=1 border=0 align=center>
	<tr>
		<td align=center height=18><input type="button"
			property="btnClose" value="Close Window" onclick="window.close();" />
		</td>
	</tr>



</table>
<%
session.removeAttribute("popupFlag");
%>

</body>
</html:html>
