/*
 *  Created on August 05, 2010
 ** Name: SowAction.java
 * <p> 
 * 	
 * This class is the Action class for following functionalities of SyncBillPeriod
 * 						1-Create Sow
 * 						2-Edit Sow
 * 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                          	       Prior 
 * Date       		   By          	  Version  				Description
 * [dd/mm/yyyy] 
 * ------------  -------------------- -------  ---------------------------------------------------- 
 * 05/08/2010      Siba Sahoo     		1.0    Created the file for PMO
 * ======================================================================================== 
 * </pre> 
 * 
  
 **/
package com.vsnl.struts.actions;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
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

import com.vsnl.struts.actions.CorpPOSAction;


import com.vsnl.model.Sow;
import com.vsnl.struts.forms.SowForm;
import com.vsnl.util.Constants;


import com.vsnl.dao.CommonDao;
import com.vsnl.exception.AppException;
import com.vsnl.manager.CommonManager;
import com.vsnl.manager.SowManager;

public class SowAction extends CorpPOSAction {
	
	Logger logger= Logger.getLogger(SowAction.class);
	
	protected Map getKeyMethodMap() 
	{
		Map map = new HashMap();
		map.put("getSOWDetails","getSOWDetails");
		map.put("getUploadedFile","getUploadedFile");
		map.put("showEditSowPage", "showEditSowPage");
		map.put("showCreateSOWPage", "showCreateSOWPage");
		map.put("createSOW", "createSOW");
		return map;
    }
	
	
	public ActionForward getSOWDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException
	{
		logger.info("SowAction::getSOWDetails::starts");
		 ActionForward forward=null;
		 SowForm sowForm=(SowForm)form; 
		 sowForm.setErrorFlag("");
		 sowForm.setErrorMessage("");
		 CommonDao commonDao=new CommonDao();
		 String sowInParams[]={sowForm.getSowName(),sowForm.getVersion()};
		 String sowDetailsQuery="getSowDetails";
		 String milestoneInParams[]={sowForm.getSowName(),sowForm.getSowName(),sowForm.getSowName(),sowForm.getSowName(),sowForm.getSowName(),sowForm.getSowName()};
		 //String milestoneDetailsQuery="getMilestoneDetails";
		 String milestoneDetailsQuery="getMilestoneBilledDetails";
		 List entityList=new ArrayList();
		 try {
			 List sowList=commonDao.getDatafromDbByQuery(sowDetailsQuery, sowInParams);
			// List milestoneList=commonDao.getDatafromDbByQuery(milestoneDetailsQuery, milestoneInParams);
			 List milestoneList=commonDao.getDatafromDbByQuery(milestoneDetailsQuery, milestoneInParams);
			 if (sowList!=null && sowList.size()!=0) 
			 {
				int listSize=sowList.size();
				for (int i = 0; i < listSize; i++) {
					String[] sowDetails=(String [])sowList.get(i);	
					sowForm.setPreparedBy(sowDetails[0]);
					sowForm.setProgramMgr(sowDetails[1]);
					sowForm.setSowType(sowDetails[2]);
					sowForm.setSowCreationDate(sowDetails[3]);
					sowForm.setFilePath(sowDetails[4]);
					sowForm.setAuthoriser(sowDetails[7]);
					sowForm.setApproving(sowDetails[5]);
					sowForm.setItpm(sowDetails[6]);
					sowForm.setRemarks(sowDetails[8]);
					sowForm.setAmount(sowDetails[9]);

				}
				sowForm.setStatus("success");
			}
			 else
			 {
				sowForm.setStatus("failure");
		    	sowForm.setErrorMessage(Constants.nodetailsfound);
			 }
			
			 if (milestoneList!=null && milestoneList.size()!=0) 
			 {
				 int listSize=milestoneList.size();
				for (int i = 0; i < listSize; i++) {
					Sow sow=new Sow();
					String[] milestoneDetails=(String[])milestoneList.get(i);	
					sow.setMilestoneName(milestoneDetails[0]);
					sow.setMilestoneAmount(milestoneDetails[1]);
					sow.setMilestoneRemark(milestoneDetails[2]);
					Date tDate=CommonManager.getSQLFormatDate(milestoneDetails[3],"yyyy-MM-dd");
					if(tDate!=null)
					  {
						  SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
					   sow.setMilestoneDate(sf.format(tDate).toString());
					  }
					else sow.setMilestoneDate(null);
					sow.setBillStatus(milestoneDetails[4]);
					entityList.add(sow);
				}
				if (entityList.size()==0) {
					entityList.add(new Sow());
				}
				sowForm.setStatus("success");
			}
			 else
			 {
				 entityList.add(new Sow());				 
			 }
			 sowForm.setListSize(entityList.size());
			 sowForm.setMilestoneDetailsList(entityList);
		}catch (Exception e) 
		{
			e.printStackTrace();
			logger.error(e.getMessage());
			sowForm.setErrorFlag(Constants.falseFlag);
    		sowForm.setErrorMessage(Constants.genErrorMessage);
		}
		setDropDownValues(sowForm);
		forward=mapping.findForward("editSowPage");
		logger.info("SowAction::getSOWDetails::ends");
		return forward; 
	}

	public ActionForward showEditSowPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException
	{	
		ActionForward forward=null;
		SowForm sowForm=(SowForm)form;
		sowForm.reset();
		forward=mapping.findForward("editSowPage");
		return forward;
	
	}
	
	
	public ActionForward getUploadedFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException
	{	
		logger.info("SowAction::getUploadedFile::starts");
		ActionForward forward=null;
		HttpSession session=request.getSession();
		CommonManager commonManager=new CommonManager();
		SowForm sowForm=(SowForm)form;
		try {
			String filePath=sowForm.getFilePath();
			session.setAttribute("fileType", Constants.CONTENT_TYPE_TEXT);
			File uplodedFile=commonManager.getFile(filePath);
			if((uplodedFile!=null) && (uplodedFile.exists()))
			{
				request.setAttribute("fileToDownload", uplodedFile);
				forward = mapping.findForward("getDownloadOption");
			}
			else
			{
				forward=mapping.findForward("editSowPage"); 
				sowForm.setErrorFlag("F");
				sowForm.setErrorMessage("File Not Found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			sowForm.setErrorFlag("F");
			sowForm.setErrorMessage("File Not Found");
			forward=mapping.findForward("editSowPage"); 
		}
		logger.info("SowAction::getUploadedFile::ends");
		return forward;
	
	}
	
	   
	public ActionForward showCreateSOWPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException
	{
		     ActionForward forward=null;
		     List mileStoneList=new ArrayList();
		     SowForm sowForm=(SowForm)form;
		     sowForm.reset();
		     setDropDownValues(sowForm);
		     mileStoneList.add(new Sow());
		     sowForm.setMilestoneDetailsList(mileStoneList);
			 forward=mapping.findForward("sow");
			 return forward;
	}
	
	public void setDropDownValues(SowForm sowForm)
	{
		 CommonManager commonManager=new CommonManager();
		 try {
			 String sowTypeInParams[]={"SOW Type"};
		     String sowTypeQuery="getSowType";
		     String programMgrQuery="getProgramMgr";
		     String ApprovingInParams[]={"Approving authority"};
		     String ApprovingAuthorityQuery="getApprovingAuthorityQuery";
		     String ITPMInParams[]={"IT PM"};
		     String ITPMQuery="getITPMQuery";
		     String AuthoriserInParams[]={"Authoriser"};
		     String AuthoriserQuery="getAuthoriserQuery";
		     sowForm.setSowTypeList(commonManager.getDropdownValuesByQuery(sowTypeQuery, sowTypeInParams));
		     sowForm.setProgramMgrList(commonManager.getDropdownValuesByQuery(programMgrQuery, null));
		     sowForm.setApprovingList(commonManager.getDropdownValuesByQuery(ApprovingAuthorityQuery, ApprovingInParams));
		     sowForm.setItpmList(commonManager.getDropdownValuesByQuery(ITPMQuery, ITPMInParams));
		     sowForm.setAuthoriserList(commonManager.getDropdownValuesByQuery(AuthoriserQuery, AuthoriserInParams));
		} catch (Exception e) {
			e.printStackTrace();
			sowForm.setErrorFlag("F");
    		sowForm.setErrorMessage(Constants.genErrorMessage);
		}
		
	}
	
	public ActionForward createSOW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		logger.info("SowAction::createSOW::starts");
		HttpSession session = request.getSession();
		ActionForward forward=null;
	    SowForm sowForm=(SowForm)form;
	    SowManager sowManager=new SowManager();
	    CommonManager manager=new CommonManager();
	    Sow sow=new Sow();
	    try {
	    	List returnList=new ArrayList();
	    	if(!sowForm.getBrowseFile().getFileName().equals(""))
	    	{
	    		returnList=manager.uploadFileinServer(sowForm.getBrowseFile(),sowForm.getSowName(),"SOW");
	    		if(returnList.get(0).equals("true"))
		    	{
		    		sow.setFilePath((String)returnList.get(1));
		    	}
	    	}
	    	formToEntity(sowForm,sow,request,session);
		    List resultList=sowManager.createSOW(sow);
		    if(resultList!=null && resultList.size()!=0)
		    {
		    	if(resultList.get(0).equals("T"))
		    	{
		    		List mileStoneList=new ArrayList();
		    		sowForm.reset();
		    		mileStoneList.add(new Sow());
		    		sowForm.setMilestoneDetailsList(mileStoneList);
		    		sowForm.setErrorFlag((String)resultList.get(0));
			    	sowForm.setErrorMessage((String)resultList.get(1));
		    	}
		    	else
		    	{
		    		manager.removeFileFromServer(sow.getFilePath());
		    		sowForm.setErrorFlag((String)resultList.get(0));
		    		sowForm.setErrorMessage((String)resultList.get(1));
		    	}
		    	
		    }
		    else
		    {
		    	sowForm.setErrorFlag("F");
		    	manager.removeFileFromServer(sow.getFilePath());
		    	sowForm.setErrorMessage(Constants.genErrorMessage);
		    }
		    
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage());
			sowForm.setErrorFlag("F");
			manager.removeFileFromServer(sow.getFilePath());
    		sowForm.setErrorMessage(Constants.genErrorMessage);
		}
		if(sowForm.getSource().equalsIgnoreCase("E"))
		{
			forward=mapping.findForward("editSowPage"); 
		}
		else
		{
			forward=mapping.findForward("sow");
		}
		logger.info("SowAction::createSOW::ends");
		return forward;
	}
	
	public void formToEntity(SowForm sowForm,Sow sow,HttpServletRequest request,HttpSession session)
	{
		
		
		sow.setSowName(sowForm.getSowName());
		sow.setSowCreationDate(sowForm.getSowCreationDate());
		sow.setAmount(sowForm.getAmount());
		sow.setVersion(sowForm.getVersion());
		sow.setSowType(sowForm.getSowType());
		sow.setPreparedBy(sowForm.getPreparedBy());
		sow.setProgramMgr(sowForm.getProgramMgr());
		sow.setUser((String)session.getAttribute("empId"));
		sow.setMilestoneList(retainFormFields(request));
		sowForm.setMilestoneDetailsList(sow.getMilestoneList());
		sow.setRemarks(sowForm.getRemarks());
		sow.setApproving(sowForm.getApproving());
		sow.setITPM(sowForm.getItpm());
		sow.setAuthoriser(sowForm.getAuthoriser());
		sow.setDelimiter(";");
		sow.setActivity(sowForm.getSource());
		
	}
	
	public List retainFormFields(HttpServletRequest request)
	{
		Sow sow=null;
		List dataList=new ArrayList();
		int mileListLimit=Integer.parseInt(request.getParameter("maxLength"));
		for (int i = 0; i < mileListLimit; i++) {
			sow=new Sow();
			sow.setMilestoneName(request.getParameter("milestoneList["+i+"].milestoneName"));
			sow.setMilestoneAmount(request.getParameter("milestoneList["+i+"].milestoneAmount"));
			sow.setMilestoneRemark(request.getParameter("milestoneList["+i+"].milestoneRemark"));
			sow.setMilestoneDate(request.getParameter("milestoneList["+i+"].milestoneDate"));
			dataList.add(sow);
		}
		return dataList;
		
	}


}