package com.vsnl.struts.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.vsnl.model.PmoEntity;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.vsnl.struts.forms.PmoScrForm;
import com.vsnl.util.Constants;


import com.vsnl.exception.AppException;
import com.vsnl.manager.CommonManager;
import com.vsnl.manager.PmoScrManager;


public class PmoScrAction extends CorpPOSAction {

	   
		protected Map getKeyMethodMap() {
			Map map = new HashMap();
			map.put("showPage","showPage");
			map.put("addUser","addUser");
			map.put("searchUser", "searchUser");
			map.put("showsearchUser", "showsearchUser");
			map.put("deleteUser", "deleteUser");
		    map.put("editUser", "editUser");
		    map.put("updateUser", "updateUser");
		    map.put("RolePage","RolePage");
		    map.put("addLUser","addLUser");
		  
			
			
			return map;
		
	}
		
		public ActionForward showPage(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AppException, IOException {
			ActionForward forward = new ActionForward();
			HttpSession session = request.getSession();
			String user=(String)session.getAttribute("empId");
			PmoScrForm pForm=(PmoScrForm)form;
			CommonManager commonManager=new CommonManager();
			pForm.reset();
			try{
				String query= "getDropDownQuery";
				pForm.setRoleList(commonManager.getDropdownValuesByQuery(query, null));
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
				
			 
			forward = mapping.findForward("pmo");
			return forward;
		}

		public ActionForward showsearchUser(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AppException, IOException {
			ActionForward forward = new ActionForward();
			HttpSession session = request.getSession();
			PmoScrForm pForm=(PmoScrForm)form;
			String mode= pForm.getMode();
			System.out.println("mode+>>"+mode);
			CommonManager commonManager=new CommonManager();
			if(!mode.equalsIgnoreCase("edit"))
			{
				pForm.reset();
				
				String query= "getDropDownQuery";
		  pForm.setRoleList(commonManager.getDropdownValuesByQuery(query, null));
		     }
			
			forward = mapping.findForward("search");
			return forward;
		}
		
		public ActionForward searchUser(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AppException, IOException {
			ActionForward forward=null;
			HttpSession session=request.getSession();
			PmoScrForm pmoForm=(PmoScrForm)form;
			PmoScrManager pmoScrMgr=new PmoScrManager();
            pmoForm.setDeleteFlag("");
            pmoForm.setReturnFlag("");
            pmoForm.setDeleteMsg("");
            pmoForm.setReturnMsg("");
			String firstName = CommonManager.replaceWithNull(pmoForm.getFirstName());
			String lastName = CommonManager.replaceWithNull(pmoForm.getLastName());
			String email = CommonManager.replaceWithNull(pmoForm.getEmail());
			String empId = CommonManager.replaceWithNull(pmoForm.getEmpId());
			String role = CommonManager.replaceWithNull( pmoForm.getRole());
			try{
				
				String query="getSearchList";
				String inputs []={ empId,firstName,lastName,email,role};
				List searchList = pmoScrMgr.getSearchList(query,inputs);	
				if((List)searchList!=null || ((List)searchList).size()!=0)
				{
				pmoForm.setEmpList((ArrayList)searchList);
				pmoForm.setListSize(pmoForm.getEmpList().size());
				System.out.println("List Size--->>"+pmoForm.getListSize());
				}
				
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				pmoForm.setPageMode("Display");
				return mapping.findForward("search");
			} 
		
		
		public ActionForward editUser(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			ActionForward forward=null;
			PmoScrForm pForm=(PmoScrForm)form;
			
			int index = Integer.parseInt( request.getParameter("count"));
			PmoEntity entity=(PmoEntity)pForm.getEmpList().get(index);
			pForm.setFirstName(entity.getFirstName());
			pForm.setLastName(entity.getLastName());
			pForm.setEmpId(entity.getEmpId());
			pForm.setEmail(entity.getEmail());
			pForm.setRole(entity.getRole());
			pForm.setMode("edit");
			forward = mapping.findForward("pmo");
			return forward;
		}
	
public ActionForward addUser(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException {
	ActionForward forward=null;
	HttpSession session = request.getSession();
	
	PmoScrForm pForm=(PmoScrForm)form;
	PmoScrManager pmoScrManager=new PmoScrManager();
	List result=null;
	String flag="";
	String msg="";
	pForm.setUser((String)session.getAttribute("empId"));
	try
	{
		result=pmoScrManager.addUser(pForm);
		msg = (String)result.get(0);
		flag = (String)result.get(1);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		pForm.setFlag(flag);
		pForm.setErrorMsg(Constants.genErrorMessage);
	}
	
	
	
	forward=mapping.findForward("pmo");
	if(flag.equalsIgnoreCase(Constants.trueFlag))
	{
	pForm.reset();
	
	pForm.setFlag(flag);
	pForm.setErrorMsg(msg);
	
	}	
	else
	{

		pForm.setFlag(flag);
		pForm.setErrorMsg(msg);
		
	}
	return forward; 
}
public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) throws AppException {
	
	HttpSession session = request.getSession();
	List result=null;
	ActionForward forward=null;
	String flag="";
	String msg="";
	PmoScrForm pForm=(PmoScrForm)form;
	PmoScrManager pmoScrManager=new PmoScrManager();
	System.out.println("index->>"+request.getParameter("count"));
	int index = Integer.parseInt( request.getParameter("count"));
	PmoEntity entity=(PmoEntity)pForm.getEmpList().get(index);
	String empId= (entity.getEmpId());
	String user=(pForm.getUser());
	pForm.reset();
	try
	{
		result=pmoScrManager.deleteUser(empId,user);
		msg = (String)result.get(0);
		flag = (String)result.get(1);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		pForm.setDeleteFlag(Constants.falseFlag);
		pForm.setDeleteMsg(Constants.genErrorMessage);
	}
	forward=mapping.findForward("search");
	if(flag.equalsIgnoreCase(Constants.trueFlag))
	{
	pForm.setDeleteFlag(flag);
	pForm.setDeleteMsg(msg);
	pForm.setMode("");
	
	}	
	else
	{
		pForm.setDeleteFlag(flag);
		pForm.setDeleteMsg(msg);
		pForm.setMode("");
		
	}
	return forward; 
	
}
	
public ActionForward updateUser(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException {

	ActionForward forward=null;
    HttpSession session = request.getSession();
    List result=null;
    String flag="";
	String msg="";
	PmoScrForm pForm=(PmoScrForm)form;
	PmoScrManager pmoScrManager=new PmoScrManager();
	pForm.setEmail(pForm.getEmail());
	pForm.setEmpId(pForm.getEmpId());
	pForm.setFirstName(pForm.getFirstName());
	pForm.setLastName(pForm.getLastName());
	pForm.setRole(pForm.getRole());
	pForm.setUser((String)session.getAttribute("empId"));
	try
	{
		result=pmoScrManager.updateUser(pForm);
		msg = (String)result.get(0);
		flag = (String)result.get(1);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		pForm.setReturnFlag(flag);
		pForm.setReturnMsg(Constants.genErrorMessage);
	}
	pForm.reset();

	if(flag.equalsIgnoreCase(Constants.trueFlag))
	{
	pForm.setReturnFlag(flag);
	pForm.setReturnMsg(msg);
	forward=mapping.findForward("search");
	pForm.setMode("");
	
	}	
	else
	{
		pForm.setReturnFlag(flag);
		pForm.setReturnMsg(msg);
		pForm.setMode("");
		
		forward=mapping.findForward("search");
	}
	return forward;
}

public ActionForward RolePage(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws AppException, IOException
		{
	ActionForward forward = null;
	HttpSession session = request.getSession();
	String user=(String)session.getAttribute("empId");
	PmoScrForm pForm=(PmoScrForm)form;
	CommonManager commonManager=new CommonManager();
	pForm.reset();
	try{
		String inParam[]={"Role"};
		String query= "pmo.getRoleDropDown";
		pForm.setRoleList(commonManager.getDropdownValuesByQuery(query, inParam));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	forward = mapping.findForward("successPage");
	return forward;
}

public ActionForward addLUser(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException {
	ActionForward forward=null;
	HttpSession session = request.getSession();
	
	PmoScrForm pForm=(PmoScrForm)form;
	
	PmoScrManager pmoScrManager=new PmoScrManager();
	List result=null;
	String flag="";
	String msg="";
	
	pForm.setUser((String)session.getAttribute("empId"));
	try
	{
		result=pmoScrManager.addLUser(pForm);
		msg = (String)result.get(0);
		flag = (String)result.get(1);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		pForm.setFlag(flag);
		pForm.setErrorMsg(Constants.genErrorMessage);
	}
	
	
	
	forward=mapping.findForward("successPage");
	if(flag.equalsIgnoreCase(Constants.trueFlag))
	{
	pForm.reset();
	
	pForm.setFlag(flag);
	pForm.setErrorMsg(msg);
	
	}	
	else
	{

		pForm.setFlag(flag);
		pForm.setErrorMsg(msg);
		
	}
	return forward; 
}


}
