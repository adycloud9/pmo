<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<html:html>
<head>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>

<script type="text/javascript">

function editValidation(myform)
{
var sowName=document.getElementById('sowName');
if((notEmpty(sowName,"Please enter sow name")) && (isAlphabet(sowName,"Please enter only Alphabets in sow name"))){
       return true;
 }
 return false;
}
function validate(myform)
{

    
	var wonNo = document.getElementById('wonNo');
	var sowName = document.getElementById('sowName');	
	
	
	if(notEmpty(sowName,"Please enter sow name")){
		if(isAlphabet(sowName,"Please enter sow name")){
			if(isNumeric(wonNo,"Enter proper won No")){
				if(lengthRestriction(wonNo,7,7)){
					return true;
				}
			}
		}
	}
	
	return false;
	
}

function notEmpty(elem, helperMsg){
	if(elem.value.length == 0){
		alert(helperMsg);
		elem.focus(); // set the focus to this input
		return false;
	}
	return true;
}

function isNumeric(elem, helperMsg){
	var numericExpression = /^[0-9]+$/;
	if(elem.value.match(numericExpression)){
		return true;
	}else{
		alert(helperMsg);
		elem.focus();
		return false;
	}
}

function isAlphabet(elem, helperMsg){
	var alphaExp = /^[a-zA-Z]+$/;
	if(elem.value.match(alphaExp)){
		return true;
	}else{
		alert(helperMsg);
		elem.focus();
		return false;
	}
}

function lengthRestriction(elem, min, max){
	var uInput = elem.value;
	if(uInput.length >= min && uInput.length <= max){
		return true;
	}else{
		alert("Please enter proper won No");
		elem.focus();
		return false;
	}
}

</script>
</head>
<body>

<br></br>
<html:form action="wonadd.do?method=addWon">
	<html:hidden property="method" />
	<center>
	<table width=86% CELLPADDING="0" CELLSPACING="0" border="0"
		align="center">

		<tr class="thead">
			<td colspan="6" align=center><b><font size="2">ADD
			WON</font></b></td>
		</tr>

		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">

			<td colspan="1">&nbsp;&nbsp;SOW Name :</td>
			<td colspan="1"><html:text property="sowName" size="15"
				maxlength="6" /></td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class="trow">

			<td colspan="1">&nbsp;&nbsp;WON NO :</td>
			<td colspan="1"><html:text property="wonNo" size="15"
				maxlength="7" /></td>
		</tr>
		<tr class="trow">
			<td colspan="6" class="trow">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr class=thead>
			<td colspan="6" align=center><html:submit value="ADD"
				styleClass="sbttn" onclick="return validate(this)" /> <html:button
				property="Edit" value="EDIT" styleClass="sbttn"
				onclick="return editValidation(this) && window.open('wonEdit.jsp?','mywindow','width=500,height=350,toolbar=no,resizable=yes,menubar=yes')" />
			<html:reset styleClass="sbttn">RESET </html:reset></td>
		</tr>

	</table>
	</center>

</html:form>

<logic:equal name="wonAddForm" property="result" value="false">
No matching Sow name
</logic:equal>

</body>
</html:html>
