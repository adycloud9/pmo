
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>

<html:html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<title>TCS Project Management</title>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/style/global.css'>
<script language=javascript>

</script>
<frameset id="indexLayoutOne" name="indexsetLayoutOne" rows="77,*,40"
	framespacing="0" frameborder="0" noresize="noresize" scrolling="no">
	<frame id="indexPageTitle" name="indexPageTitle"
		src="<%=request.getContextPath()%>/pages/top.jsp" target="frWorkspace"
		scrolling="no" noresize="noresize">


	<frameset id="indexsetLayoutThree" name="indexsetLayouThree" rows="*,2"
		framespacing="0" frameborder="0">
		<frame id="indexWorkspace" name="indexWorkspace"
			src="<%=request.getContextPath()%>/pages/login.jsp"
			target="indexWorkspace" scrolling="auto" noresize="noresize">
	</frameset>
	<frame id="frAppTitle" name="frAppTitle"
		src="<%=request.getContextPath()%>/pages/footer.jsp"
		target="indexWorkspace" scrolling="no" noresize="noresize">
</frameset>



<noframes>
<body>
<p><span
	style="font-family: Tahoma, Arial, Sans-Serif; font-size: 8pt;">This
page uses frames, but your browser doesn't support them.</span></p>
</body>
</noframes>



</html:html>
