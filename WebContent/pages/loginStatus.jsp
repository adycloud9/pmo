
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0);
response.setHeader("Pragma","no-cache");
%>

<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/pagination" prefix="pagination"%>
<%@ taglib uri="/tags/jstl" prefix="c"%>

<!--
 * JSP
 *
 * Name: loginStatus.jsp
 * Action Class :UserCreationAction.java 
 * Form Class   : UserCreateForm.java
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
<html:html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<%if(((String)session.getAttribute("PROVIDER")).equalsIgnoreCase("Neotel")){ %>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/Neotel.css'>
<%}else{%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
<%}%>
<script src='<%=request.getContextPath()%>/jscripts/jscommon.js'></script>
<script src='<%=request.getContextPath()%>/jscripts/common.js'></script>
<script src="<%=request.getContextPath() %>/jscripts/jscommon.js"></script>
<SCRIPT LANGUAGE="JavaScript">
var alter_menu='';

function setValues(rowId){
if(alter_menu == ''){

 alter_menu=getFldobj('custNameRefList['+rowId+'].access').value+ ';' ;
 }
else{
 alter_menu=alter_menu+getFldobj('custNameRefList['+rowId+'].access').value+ ';' ;
}

document.userCreateForm.user_id_details.value=alter_menu;

}


function validate()
{
if(alter_menu=="")
alert("Please select at least one user");

else
alert("Do you really want to Activate this user");
	document.userCreateForm.method.value="updateUserStatus";
		document.userCreateForm.submit();
			
}



	
</script>
</head>

<BODY marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0"
	topmargin="0" bottommargin="20">
<html:form action="usercreate.do" method="post">

	<html:hidden property="method" />
	<html:hidden property="user_id_details" />

	<BR>
	<BR>
	<BR>
	<BASEFONT face="Arial Narrow" size="1">
	<center><BASEFONT face="Arial Narrow">
	<table CELLPADDING="1" CELLSPACING="1" width="90%" align="center">

		<tr>
			<td class=thead colspan="2" align="center"><b>List of In
			Active Users</b></td>
		</tr>


		<logic:iterate name="userCreateForm" property="custNameRefList"
			id="custNameRefList" indexId="count">

			<tr class=trow>

				<td width="50%"><bean:write name="custNameRefList"
					property="menu_id" /> <html:hidden name="custNameRefList"
					property="title" indexed="true" /></td>
				<html:hidden name="custNameRefList" property="access" indexed="true" />
				</td>

				<td width="50%"><html:checkbox name="custNameRefList"
					property="title" indexed="true"
					onclick='<%="javascript: setValues("+count+")"%>'></html:checkbox>

				</td>

			</tr>
		</logic:iterate>


		<tr>

			<td align="right" class=thead colspan=5>
			<center><input type="button" value="ACTIVE" class="sbttn"
				onClick="return validate(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</center>
			</td>
		</tr>
	</table>
	</center>
</html:form>

</BODY>
</html:html>

