<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>

<html:html locale="true">
<head>
<script type="text/javascript">
function makeCheck(thisForm)
{
for (i = 0; i < thisForm.option.length; i++)
	{
	thisForm.option[i].checked=true;
	}
}

function makeUncheck(thisForm)
{
for (i = 0; i < thisForm.option.length; i++)
	{
	thisForm.option[i].checked=false;
	}
}
</script>
</head>
<html:form action="changePassword.do" method="post"
	onsubmit="return validate(this);">
	<table border="2">
		<tr>
			<td><input type="checkbox" value="Select All"
				onclick="makeCheck(this.form)">Select All</td>
			<td>Sr. No.</td>
			<td>Name*</td>
			<td>Ammount*</td>
		</tr>
		<tr>
			<td colspan="4"><input type="checkbox" name="option"></td>
		</tr>
		<tr>
			<td colspan="4"><input type="checkbox" name="option"></td>
		</tr>
		<tr>
			<td colspan="4"><input type="checkbox" name="option"></td>
		</tr>
		<tr>
			<td colspan="4"><input type="checkbox" name="option"></td>
		</tr>

	</table>


</html:form>
</html:html>
