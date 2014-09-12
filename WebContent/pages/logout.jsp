
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0);
response.setHeader("Pragma","no-cache");
%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<form target=""></form>
<%
out.println("<script language='javascript'>");	
out.println("top.document.location ='"+request.getContextPath()+"/login.do';");
out.println("</script>");
session.invalidate();
%>
