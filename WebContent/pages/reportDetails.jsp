   <!--
 * JSP
 *
 *  Name        :reportDetails.jsp
 * Action Class :ReportAction.java  
 * Form Class   :ReportForm.java 
 *
 * <p>
 * <b>Revision History:</b><pre>
 * ===========================================================================================================================
 *                            Prior
 * Date       By              Version  	Description
 * ---------- --------------- -------  ---------------------------------------------------------------------------------------
 * 
 * ===========================================================================================================================
 * </pre>
 *
 
 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%try{%>
<html:html locale="true">
<head>
<title>Report page</title>
<link rel='stylesheet' href='<%=request.getContextPath()%>/style/global.css'>
<LINK rel='stylesheet' href='<%=request.getContextPath()%>/style/displaytag.css'>

<style type="text/css">

.displayTable  th.order1 a {
	background: url(images/down.GIF) no-repeat right center ;
}
.displayTable  th.order2 a {
	background: url(images/up.GIF) no-repeat right center ;
}

</style>

<script type='text/javascript'>

function getReport()
{
	var reportType=document.reportForm.mode.value;
	if(reportType=='')
	{
		alert('Please select a report type');
		return false;
	}
	document.forms(0).action='<%=request.getContextPath()%>/report.do?method=showReportDetails';
	document.forms(0).submit();
}
</script>

</head>
<body marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="20" bottommargin="20">
<html:form action="report.do" method="post">
	<table width=100% CELLPADDING="2" CELLSPACING="0" border="1" bordercolor="black" rules="none">
		<tr>
			<td colspan="4" align="center" class="thead">
				<font size="2">Reports</font>
				<!-- img src="images/paginationImages/arrow_down.gif"-->
			</td>
		</tr>
		<tr class="trow">
			<td colspan="4">&nbsp;
			</td>
		</tr>
		<logic:notEmpty name="reportForm" property="mode">
		<logic:empty name="reportForm" property="dataList">
		<tr class="trow">
			<td align="center" colspan="4">
				<font  color="red">
					<strong>
   					<bean:message key="label.noRecords"/>
   					</strong>
				</font>
			</td>
		</tr>
		</logic:empty>
		</logic:notEmpty>
		<tr class="trow">
			<td>&nbsp;
			</td>
			<td colspan="3">
				<html:select name="reportForm" property="mode" title="Report Type" >
					<html:option value="" >--Select a Report Type--</html:option>
					<logic:notEmpty name="reportForm" property="reportTypeList">
						<html:optionsCollection name="reportForm" property="reportTypeList" value="value" label="label"/>
					</logic:notEmpty>	
				</html:select>
				<input type="button" name="search" id="srh" value="search" onclick="return getReport();">
			</td>
		</tr>
		<tr class="trow">
			<td colspan="4">&nbsp;
			</td>
		</tr>
		<logic:notEmpty name="reportForm" property="mode">
		<logic:notEmpty name="reportForm" property="dataList">
				<tr>
				<td colspan="4" align="center">
						<table width=100% CELLPADDING="2" CELLSPACING="0" rules="none" border="1" bordercolor="black">
						<bean:define id="res" name="reportForm" property="dataList" type="java.util.List"/>
						<tr>
							<td colspan="4" >
								<display:table id="data" class="displayTable  th" export="true"  style="width=100%" name="sessionScope.reportForm.dataList" requestURI="/report.do" pagesize="10" decorator="com.vsnl.struts.actions.ReortDecorator">
									<%
					               	if(res.size()<=10)
									{%>
										<display:setProperty name="paging.banner.page.selected" value="" />
									<%}
					               	else
					               	{%>
					               		<display:setProperty name="paging.banner.page.selected">
					               			<strong>
					               			<font size="4">{0}</font>
					               			</strong>
					               		</display:setProperty>
					               	<%}%>

									<display:setProperty name="paging.banner.page.separator" value="&nbsp; &nbsp;" />
									<display:setProperty name="paging.banner.full">
										<div class="pagelinks" align="center">
											<!-- <a href={1}><img src="images/paginationImages/first.gif"></a>-->
											<a href={2} style="text-decoration: none; color: blue"><!-- img src="images/paginationImages/prev.gif"-->Previous</a>&nbsp; &nbsp;{0}&nbsp; &nbsp; 
											<a href={3} style="text-decoration: none; color: blue"><!-- img src="images/paginationImages/next.gif"-->Next&nbsp;</a>
											<!-- <a href={4}><img src="images/paginationImages/last.gif"></a>-->
										</div> 
									</display:setProperty>
									<display:setProperty name="paging.banner.first">
										<div class="pagelinks" align="center">
										<!-- <a href={1}><img src="images/paginationImages/first.gif"></a>-->
											<a href={2} style="text-decoration: none; color:#9F9F9F" onclick="return false;"><!-- img src="images/paginationImages/prev.gif"--></a>&nbsp; &nbsp;{0}&nbsp; &nbsp; 
											<a href={3} style="text-decoration: none;color: blue"><!-- img src="images/paginationImages/next.gif"-->Next&nbsp;</a>
										<!-- <a href={4}><img src="images/paginationImages/last.gif"></a>-->
										</div>
									</display:setProperty>
									<display:setProperty name="paging.banner.last">
										<div class="pagelinks" align="center">
										<!-- <a href={1}><img src="images/paginationImages/first.gif"></a>-->
											<a href={2} style="text-decoration: none;color: blue"><!-- img src="images/paginationImages/prev.gif"-->Previous</a>&nbsp; &nbsp;{0}&nbsp; &nbsp; 
											<a href={3} style="text-decoration: none; color:#9F9F9F" onclick="return false;"><!-- img src="images/paginationImages/next.gif"-->&nbsp;</a>
										<!-- <a href={4}><img src="images/paginationImages/last.gif"></a>-->
										</div>
									</display:setProperty>
									<display:setProperty name="export.banner">
										<div class="exportlinks"  align="left"  style="background-color:#565656" >
											<img src="images/paginationImages/ico_file_excel.png">{0}
										</div>
									</display:setProperty>
									
									<display:setProperty name="export.excel.label">
										<span class="export excel">
											<font color="white">Export to Excel Sheet </font>
										</span>
									</display:setProperty>
									<display:setProperty name="paging.banner.page.link">
										<a href="{1}" title="Go to page {0}" style=" text-decoration: none;color: blue">{0}</a>
									</display:setProperty>
													
									<display:setProperty name="export.csv" value="false" />
									
									<logic:equal value="SOW without WON" property="mode" name="reportForm">
										<display:column   property="sowName" sortable="true"  title="SowName"/>
										<display:column  property="preparedBy" sortable="true"  title="PreparedBy"/>
									</logic:equal>
									
									<logic:equal value="SOW without PO" property="mode" name="reportForm">
										<display:column   property="sowName" sortable="true"   title="SowName"/>
										<display:column  property="preparedBy" sortable="true"  title="PreparedBy"/>
									</logic:equal>
									
									<logic:equal value="Milestones without WCR" property="mode" name="reportForm">
										<display:column  property="sowName"  sortable="true" title="SowName"/>
										<display:column   property="sowCreationDate" sortable="true" title="SowCreationDate" />
										<display:column  property="preparedBy" sortable="true" title="PreparedBy"/>
										<display:column  property="mileStoneName" sortable="true" title="MileStoneName" />
										<display:column  property="mileStoneDate" sortable="true" title="MileStoneDate" />
										<display:column  style="text-align:right" property="mileStoneAmt"  title="MileStoneAmount" />
									</logic:equal>
									
									<logic:equal value="Milestones with WCR which are unbilled" property="mode" name="reportForm">
										<display:column style="width:100px;"  property="sowName" sortable="true"  title="SowName"/>
										<display:column style="width:150px;"  property="sowCreationDate" sortable="true" title="SowCreationDate" />
										<display:column style="width:120px;" property="wonNum" sortable="true" title="WonNumber"/>
										<display:column style="width:100px;" property="poNum" sortable="true" title="PoNumber"/>
										<display:column style="width:150px;" property="mileStoneName" sortable="true" title="MileStoneName" />
										<display:column style="width:100px;" style="text-align:right"  property="mileStoneAmt" title="MileStoneAmt" />
										<display:column style="width:120px;"  property="preparedBy" sortable="true" title="PreparedBy"/>
										<display:column style="width:120px;" property="wcr_ref" sortable="true" title="Wcr_RefID"/>
									</logic:equal>
								</display:table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</logic:notEmpty>
		</logic:notEmpty>
		
	
	</table>
	
</html:form>
	
</body>
</html:html>
<%}catch(Exception e)
{
	e.printStackTrace();
}
%>