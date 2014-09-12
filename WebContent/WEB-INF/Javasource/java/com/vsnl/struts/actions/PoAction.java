/** 
 * 
 * Name: PoAction.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ===============================================================================================================
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
 * 
 * ======================================================================================== 
 * </pre> 
 * 
  

 **/
package com.vsnl.struts.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vsnl.model.PoAdd;
import com.vsnl.struts.forms.PoAddForm;
import com.vsnl.util.Constants;
import com.vsnl.dao.CommonDao;
import com.vsnl.exception.AppException;
import com.vsnl.manager.CommonManager;
import com.vsnl.manager.PoManager;


public class PoAction extends CorpPOSAction {

	   
	protected Map getKeyMethodMap() 
	{
		Map map = new HashMap();
		map.put("showPage","showPage");// added by soumya 
		map.put("addPo","addPo");
	    map.put("editPo","editPo");
	    map.put("deletePo","deletePo");
	    map.put("showEditPage","showEditPage");
	    map.put("getUploadedFile","getUploadedFile");
		return map;
	
   }
 

	public ActionForward showPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {

			ActionForward forward=null;
			PoAddForm poForm=(PoAddForm)form;	
					
			poForm.reset();
			
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter= 
			new SimpleDateFormat("dd-MMM-yyyy");
			String dateNow = formatter.format(currentDate.getTime());
			System.out.println("Date ====> "+dateNow);
			
			poForm.setPoDate(dateNow);
			
			forward=mapping.findForward("showPoPageJsp");
		    return forward; 
		}
    //Changes by Soumya Ends
	
	public ActionForward addPo(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws AppException {
	
		ActionForward forward=null;
		PoManager poMgr=new PoManager();
		PoAdd po=new PoAdd();
		PoAddForm poForm=(PoAddForm)form;
		String returnMsg = null;
		HttpSession session = request.getSession();
		CommonManager manager=new CommonManager();
		String user=(String)session.getAttribute("empId");
		
		try 
		{
	    	List returnList=new ArrayList();
	    	if(!poForm.getBrowse_File().getFileName().equals(""))
	    	{
	    		returnList=manager.uploadFileinServer(poForm.getBrowse_File(),poForm.getSowName(),"PO");
	    		if(returnList.get(0).equals("true"))
		    	{
		    		po.setFilePath((String)returnList.get(1));
		    		
		    	}
	    	}
		
			po.setSowName(poForm.getSowName());
			po.setWonNo(poForm.getWonNo());
			po.setPoNo(poForm.getPoNo());
			po.setUser(user);
		
			po.setPoStartDate(poForm.getPoStartDate());
			po.setPoEndDate(poForm.getPoEndDate());
			po.setPoDate(poForm.getPoDate());
			po.setAddEditFlag("C");
			returnMsg = poMgr.addEditPo(po);
			System.out.println("returnMsg-->" + returnMsg);
		}catch (Exception e) {
			e.printStackTrace();
			poForm.setMsg("msg");
			poForm.setErrorFlag(Constants.falseFlag);
			poForm.setErrorMessage(Constants.genErrorMessage);
		}
		poForm.reset();
		
		if(!"Success".equalsIgnoreCase(returnMsg)){
			poForm.setMsg(returnMsg);	
		}else {
			poForm.setMsg("PO Attached Successfully");	
		}
		//logger.debug("JSP MSG is :" +poForm.getMsg());
		forward=mapping.findForward("showPoPageJsp");
	    return forward; 
	
	}
	public ActionForward editPo(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException {
	
		ActionForward forward=null;
		PoManager poMgr=new PoManager();
		PoAdd po=new PoAdd();
		PoAddForm poForm=(PoAddForm)form;
		HttpSession session = request.getSession();
		String returnMsg = null;
		CommonManager manager=new CommonManager();
		String user=(String)session.getAttribute("empId");
	   
	    	po.setSowName(poForm.getSowName());
			po.setWonNo(poForm.getWonNo());
			po.setPoNo(poForm.getPoNo());
			po.setUser(user);
			po.setPoStartDate(poForm.getPoStartDate());
			po.setPoEndDate(poForm.getPoEndDate());
			po.setPoDate(poForm.getPoDate());
			List returnList=new ArrayList();
	    	if(!poForm.getBrowse_File().getFileName().equals(""))
	    	{
	    		returnList=manager.uploadFileinServer(poForm.getBrowse_File(),poForm.getSowName(),"PO");
	    		if(returnList.get(0).equals("true"))
		    	{
		    		po.setFilePath((String)returnList.get(1));
		    		
		    	}
	    	}
			po.setAddEditFlag("E");
			returnMsg=poMgr.addEditPo(po);
			System.out.println("returnMsg-->" + returnMsg);
			poForm.reset();
				
		if(!"Success".equalsIgnoreCase(returnMsg)){
			poForm.setMsg(returnMsg);	
		}else {
			poForm.setMsg("PO Updated Successfully");	
		}
	
		forward=mapping.findForward("showEditJsp");
	    return forward; 

	}

	public ActionForward showEditPage(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException {

		ActionForward forward=null;
		PoAddForm poForm=(PoAddForm)form;	
		poForm.reset();
		forward=mapping.findForward("showEditJsp");
	    return forward; 
	}

	public ActionForward getUploadedFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException
	{	
		System.out.println("inside uploaded action");
		ActionForward forward=null;
		HttpSession session=request.getSession();
		CommonManager commonManager=new CommonManager();
		CommonDao commonDao=new CommonDao();
		PoAddForm poForm=(PoAddForm)form;
		String []inParams={request.getParameter("sowName"),request.getParameter("poNo")};
		String queryId="Po.getDownloadFile";
		try {
			List returnList=commonDao.getDatafromDbByQuery(queryId, inParams);
			String filePath[]=null;
			if(returnList.get(0)!=null)
			{
				filePath=(String[])returnList.get(0);
			}
			session.setAttribute("fileType", Constants.CONTENT_TYPE_TEXT);
			File uplodedFile=commonManager.getFile(filePath[0]);
			if((uplodedFile!=null) && (uplodedFile.exists()))
			{
				request.setAttribute("fileToDownload", uplodedFile);
				forward = mapping.findForward("getDownloadOption");
			}
			else
			{
				forward=mapping.findForward("showEditJsp"); 
				poForm.setErrorFlag("F");
				poForm.setErrorMessage("File Not Found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			poForm.setErrorFlag("F");
			poForm.setErrorMessage("File Not Found");
			forward=mapping.findForward("showEditJsp"); 
		}
		return forward;
	
	}
	public ActionForward deletePo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
		
			ActionForward forward=null;
			PoManager poMgr=new PoManager();
			PoAdd po=new PoAdd();
			PoAddForm poForm=(PoAddForm)form;
			HttpSession session = request.getSession();
			String returnMsg = null;
			String user=(String)session.getAttribute("empId");
	    	po.setSowName(poForm.getSowName());
			po.setWonNo(poForm.getWonNo());
			po.setPoNo(poForm.getPoNo());
			po.setUser(user);
			po.setPoStartDate(poForm.getPoStartDate());
			po.setPoEndDate(poForm.getPoEndDate());
			po.setPoDate(poForm.getPoDate());
			po.setAddEditFlag("D");
			returnMsg=poMgr.addEditPo(po);
				
				System.out.println("returnMsg-->" + returnMsg);
			poForm.reset();
					
			if(!"Success".equalsIgnoreCase(returnMsg)){
				poForm.setMsg(returnMsg);	
			}else 
			{
				poForm.setMsg("PO Deleted Successfully");	
			}
		
			forward=mapping.findForward("showEditJsp");
		    return forward; 

		}


}