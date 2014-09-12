package com.vsnl.struts.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sun.util.logging.resources.logging;



import com.vsnl.util.Constants;
import com.vsnl.exception.AppException;
import com.vsnl.manager.CommonManager;
import com.vsnl.manager.ExcelManager;
import com.vsnl.manager.ReportManager;
import com.vsnl.model.ReportEntity;
import com.vsnl.struts.forms.ReportsForm;
public class ReportsAction extends CorpPOSAction {

	Logger logger = Logger.getLogger(ReportsAction.class);   
	protected Map getKeyMethodMap() {
		Map map = new HashMap();
		map.put("showPage","showPage");
		map.put("showReportDetails","showReportDetails");
		map.put("exportToExcel","exportToExcel");
		
		return map;
	}
	
	public ActionForward showPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, IOException {
		ActionForward forward = new ActionForward();
		//HttpSession session = request.getSession();
		//String user=(String)session.getAttribute("empId");
		ReportsForm rForm =(ReportsForm)form;
		rForm.reset();
		CommonManager commonManager=new CommonManager();
		String queryId="getReportType";
		String inParams[]={"Report Type"};
		rForm.setReportTypeList(commonManager.getDropdownValuesByQuery(queryId, inParams));
	     // rForm.setMode("won");
	    //String mode= rForm.getMode();
		forward = mapping.findForward("success");
		return forward;
	}
	public ActionForward showReportDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, IOException {
		logger.info("ReportsAction::showReportDetails method starts");
		ActionForward forward = new ActionForward();
		/*HttpSession session = request.getSession();
		String user=(String)session.getAttribute("empId");*/
		ReportsForm rForm= (ReportsForm)form;
		String mode= rForm.getMode();
		rForm.setDataList(null);
		String query="";
		List  searchList=new ArrayList();

		ReportManager reportManager= new ReportManager();
		
		try{
			if(mode.equalsIgnoreCase("SOW without PO"))
			{
				query="reports.getPODetails";	
			}
		   
			if(mode.equalsIgnoreCase("Milestones without WCR"))
			{
				query="reports.getwithoutWCR";
			}
			if(mode.equalsIgnoreCase("SOW without WON"))
			{
				query="reports.getWONDetails";
			}
		   if(mode.equalsIgnoreCase("Milestones with WCR which are unbilled"))
		   {
			   query="reports.getwithWCR_unBilled";  
		   }
			searchList = reportManager.getSearchList(query,null,mode);
			rForm.setDataList(searchList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		System.out.println("Mode-->"+rForm.getMode());
		forward = mapping.findForward("success");
		logger.info("ReportsAction::showReportDetails method ends");
		return forward;
		
	}
	public ActionForward exportToExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, IOException {
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		List excelList = null;
		ReportsForm rForm= (ReportsForm)form;
		String mode= rForm.getMode();
		try {
 			if (mode.equalsIgnoreCase("won")) {
				excelList = rForm.getDataList();
			} 
 			if(mode.equalsIgnoreCase("po"))
 			{
				excelList = rForm.getDetailsList();
			}
 			if(mode.equalsIgnoreCase("withoutWCR"))
			{
 				excelList = rForm.getWithoutWCRList();
			}
 			if(mode.equalsIgnoreCase("withWCR"))
			{
 				excelList = rForm.getWithWCRList();	
			}

			List toExcel = new ArrayList();
			
			if (mode.equalsIgnoreCase("won")||(mode.equalsIgnoreCase("po"))) {
			for (int i = 0; i < excelList.size(); i++) {
				ReportEntity reportEntity = (ReportEntity) excelList.get(i);
				String temp[] = { reportEntity.getSowName(),
						reportEntity.getPreparedBy(),
						};
				toExcel.add(temp);
				}
			}
				if (mode.equalsIgnoreCase("withoutWCR")) {
					for (int i = 0; i < excelList.size(); i++) {
				ReportEntity reportEntity = (ReportEntity) excelList.get(i);
					String temp[] = { reportEntity.getSowName(),
							reportEntity.getSowCreationDate(),
							reportEntity.getPreparedBy(),
							reportEntity.getMileStoneName(),
							reportEntity.getMileStoneDate(),
							reportEntity.getMileStoneAmt(),
							};
					
					toExcel.add(temp);
					}
				}
				if (mode.equalsIgnoreCase("withWCR")) {
					for (int i = 0; i < excelList.size(); i++) {
					ReportEntity reportEntity = (ReportEntity) excelList.get(i);
					String temp[] = { reportEntity.getSowName(),
							reportEntity.getSowCreationDate(),
							reportEntity.getWonNum(),
							reportEntity.getPoNum(),
							reportEntity.getMileStoneName(),
							reportEntity.getMileStoneAmt(),
							reportEntity.getPreparedBy(),
							reportEntity.getWcr_ref()
							};
					
					toExcel.add(temp);
					}
			}
			
			
			ExcelManager excelManager= new ExcelManager();
			CommonManager commonManager=new CommonManager();
			String contextPath = this.getServlet().getServletContext().getRealPath("/");
			contextPath = (contextPath.indexOf(".war") != -1 ? contextPath.concat("/") : contextPath);
			String filePath = contextPath+ Constants.EXPORT_FILES_RELATIVE_PATH;
			File excelFile = new File(filePath, "reports"+ Constants.EXPORT_FILE_NAME_EXTN);
			File templateFile = excelManager.getBlankTemplate(contextPath,"templates", "reports",".xls");
			commonManager.copyFile(templateFile, excelFile);
			excelManager.setContentStartIndex(1);
			excelManager.setColumnCount(3);
			String[] cellTypes =new String[0];
			String[] headers=new String[0];
			if (mode.equalsIgnoreCase("won")||(mode.equalsIgnoreCase("po"))) {
			 cellTypes = new String[] { "String", "String"};
		     headers = new String[] { "SOW Name",
					"Prepared By" };
			}
			if (mode.equalsIgnoreCase("withWCR")) {
		      cellTypes = new String[] { "String", "String","String","String","String","String","String","String"};
			  headers = new String[] { "SOW Name",
						"Prepared By","WON Number","PO Number","Milestone Name","Milestone Amount","Prepared By","WCR Ref Number" };
				}
			if (mode.equalsIgnoreCase("withoutWCR")) {
		  cellTypes = new String[] { "String", "String","String","String","String","String","String","String"};
	     headers = new String[] { "SOW Name",
			"SOW Creation Date","Prepared By","Milestone Name","Milestone Date","Milestone Amount" };
					}
				
			
	
			excelManager.setCellTypes(cellTypes);
			excelManager.setHeaders(headers);
			excelManager.arrayToFile(toExcel, excelFile);
			request.setAttribute("fileToDownload", excelFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

		forward = mapping.findForward("getDownloadOption");
		return forward;
	}

	

}