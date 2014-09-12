/** 
 * This class is a part of code for Generic Popup. Queries for the popup's maybe in a 
 * properties file OR maybe be passed as a request attribute from other beans. 
 *  
 * 
 * Name: PopupAction.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
 * 
 * ======================================================================================== 
 * </pre> 
 * 
  

 **/

package com.vsnl.struts.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vsnl.manager.PopupManager;
import com.vsnl.struts.forms.PopupForm;
import com.vsnl.exception.AppException;

public class PopupAction extends CorpPOSAction
{
	private Logger logger = Logger.getLogger(PopupAction.class);
	
	protected Map getKeyMethodMap() {
		Map map = new HashMap();
		map.put("getDetails","getDetails");
		
		return map;
	}
	

	
	   public ActionForward getDetails(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	    throws AppException, IOException {
		   //collect variables into form attributes...
		   
		   //
		   System.out.println("in popupaction..");
//		   System.out.println("mode==>" + request.getAttribute("mode"));
//		   System.out.println("query==>" + request.getAttribute("query"));
		   
		   String mode = "default";
		   mode = (String)request.getAttribute("mode")==null?mode:(String)request.getAttribute("mode");
		   logger.debug("mode==>" + mode);
		   PopupForm popupForm = (PopupForm)form;
		   // ver 1.5 starts here				   
		   String delimiterVal = (String)request.getParameter("delimiterVal");
		   logger.debug("delimiter===>" + delimiterVal);
		   PopupManager popupManager = new PopupManager(delimiterVal);
		   // ver 1.5 ends here
		   Object resultList  = null;
		   
		   
		   //if(! mode.equals("fullQuery"))
		   if(mode.equals("default"))
		   {
			   setParams(request, popupForm, mode);
			   
			   //call manager and execute query...
			   resultList = popupManager.executeQuery(popupForm.getQid(), popupForm.getParamList());
			   
			   //set header list
			   popupForm.setHeaderList((String[])popupManager.getHeaderList(popupForm.getQid()));
		   }
//		   else if(mode.equals("fullQuery"))
//		   {
//			   resultList = popupManager.executeQuery((String)request.getAttribute("query"));
//			   String headerList = (String)request.getAttribute("query");
//			   popupForm.setHeaderList(headerList.split(","));
//		   }
		   //set result list in form object
		   popupForm.setResultList((List)resultList);
		   logger.debug("list size while getting popup details...===>" + popupForm.getResultList().size());

		   //forwarding to page...
			ActionForward forward = new ActionForward();		
			forward = mapping.findForward("showPopupPage");
			return forward;
	   }
	   
	   
	   public void setParams(HttpServletRequest request, PopupForm popupForm, String mode )
	   {
		   String qid = "";
		   String paramList = "";
		   String targetFields = "";
		   String postSelFunc = "";
		   
		   if(! mode.equals("fullQuery"))
		   {
			   qid = (String)request.getParameter("qid");
			   paramList = (String)request.getParameter("paramList");
			   targetFields = (String)request.getParameter("targetFields");
			   postSelFunc  = (String)request.getParameter("postSelFunction");
			   logger.debug("in else...postSelFunc-->" + postSelFunc);
		   }
		   else
		   {
			   qid = (String)request.getAttribute("query");
			   targetFields = (String)request.getAttribute("targetFields");
		   }

		   popupForm.setQid(qid);
		   popupForm.setParamList(paramList);
		   popupForm.setTargetFields(targetFields);
		   popupForm.setPostSelFunc(postSelFunc);
		   logger.debug("postSelFunc--->" + popupForm.getPostSelFunc());

	   }
	
	  
	   
}	   
