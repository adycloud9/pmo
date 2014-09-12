
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
<frameset id="frsetLayoutOne" name="frsetLayoutOne" rows="20,90,*,40"
	framespacing="0" frameborder="0" noresize="noresize" scrolling="no">
	
	<frame id="frPageTitle1" name="frPageTitle1" style="width: 100%;vertical-align: top;" 
				src="<%=request.getContextPath()%>/pages/helpLink.jsp" target="frWorkspace"
				scrolling="no" noresize="noresize">
	<frame id="frPageTitle" name="frPageTitle"
		src="<%=request.getContextPath()%>/pages/top.jsp" target="frWorkspace"
		scrolling="no" noresize="noresize">
	
	<frameset id="frsetLayoutTwo" name="frsetLayoutTwo" cols="180,*"
		framespacing="0" frameborder="1">
		<frame id="frNavbar" name="frNavbar" frameborder="0"
			src="<%=request.getContextPath()%>/pages/menu.jsp"
			target="frWorkspace" scrolling="auto">
		<frameset id="frsetLayoutThree" name="frsetLayouThree" rows="*,2"
			framespacing="0" frameborder="0">
			<frame id="frWorkspace"
				src="<%=request.getContextPath()%>/pages/main.jsp"
				name="frWorkspace" target="frWorkspace" scrolling="auto"
				noresize="noresize">
		</frameset>
	</frameset>

	<frame id="frAppTitle" name="frAppTitle"
		src="<%=request.getContextPath()%>/pages/footer.jsp"
		target="frWorkspace" scrolling="no" noresize="noresize">

	<noframes>
	<body>
	<p><span
		style="font-family: Tahoma, Arial, Sans-Serif; font-size: 8pt;">This
	page uses frames, but your browser doesn't support them.</span></p>
	</body>
	</noframes>
</frameset>


</html:html>
