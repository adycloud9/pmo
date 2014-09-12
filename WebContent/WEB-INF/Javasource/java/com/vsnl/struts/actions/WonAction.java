package com.vsnl.struts.actions;

import java.util.HashMap;
import java.util.List;//added by Anindita
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.log4j.Logger;//added by Anindita

import com.vsnl.model.PmoEntity;
import com.vsnl.model.WonAdd;
import com.vsnl.struts.forms.PmoScrForm;
import com.vsnl.struts.forms.WonAddForm;
import com.vsnl.util.Constants;//added by Anindita
import com.vsnl.exception.AppException;
import com.vsnl.manager.PmoScrManager;
import com.vsnl.manager.WonManager;

public class WonAction extends CorpPOSAction {

	   
	protected Map getKeyMethodMap() {
		Map map = new HashMap();
		map.put("showPage", "showPage");//added by Anindita
	    map.put("addWon","addWon");
	    map.put("editWon","editWon");
	    map.put("deleteWon","deleteWon");
		return map;
	
}

//ver Anindita starts here	
public ActionForward showPage(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws Exception 
		{
			ActionForward forward = new ActionForward();
			HttpSession session = request.getSession();
			String user=(String)session.getAttribute("empId");
			if ((session == null) || (user == null)){
				return new ActionForward("/pages/logout.jsp");
			}
			String source=(String)request.getParameter("source");
			System.out.println("source-->"+source);
			WonAddForm wonForm=(WonAddForm)form;
			wonForm.reset(); 
			forward = mapping.findForward("showPage");
			return forward;
			
		}	
//ver Anindita ends here

public ActionForward addWon(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)throws AppException {

	ActionForward forward=null;
	WonManager wonMgr=new WonManager();
	
	HttpSession session = request.getSession();
	
	String user=(String)session.getAttribute("empId");
	
	WonAddForm wonForm=(WonAddForm)form;
	wonForm.setSowName(wonForm.getSowName());
	wonForm.setWonNo(wonForm.getWonNo());
	wonForm.setUser((String)session.getAttribute("empId"));
	
	try{
		List returnList=wonMgr.addWon(wonForm);
		if(returnList!=null && returnList.size()!=0)
		{
			wonForm.reset();
			wonForm.setErrorFlag((String)returnList.get(1));
			System.out.println("eflag-->"+ (String)returnList.get(1));
			wonForm.setErrorMessage((String)returnList.get(0));
			System.out.println("emesg-->"+ (String)returnList.get(0));
		}
		else
		{
			wonForm.reset();
			wonForm.setErrorFlag(Constants.falseFlag);
			wonForm.setErrorMessage(Constants.genErrorMessage);
		}
		}
	catch(Exception e){
		e.printStackTrace();
	}
    forward=mapping.findForward("showPage");
    
    return forward; 

}

public ActionForward editWon(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException {

		ActionForward forward=null;
		WonManager wonMgr=new WonManager();
		
		HttpSession session = request.getSession();
		
		String user=(String)session.getAttribute("empId");
		
		WonAddForm wonForm=(WonAddForm)form;
		wonForm.setSowName(wonForm.getSowName());
		//ver Anindita starts here
		wonForm.setWonNo(wonForm.getWonNo());
		wonForm.setNewWonNo(wonForm.getNewWonNo());
		wonForm.setUser(user);
		System.out.println("sow name-->"+wonForm.getSowName());
		System.out.println("won no-->"+wonForm.getWonNo());
		System.out.println("new won no-->"+wonForm.getNewWonNo());
		System.out.println("user-->"+wonForm.getUser());
		try{
			List returnList=wonMgr.editWon(wonForm);
			if(returnList!=null && returnList.size()!=0)
			{
				wonForm.reset();
				wonForm.setErrorFlag((String)returnList.get(1));
				System.out.println("eflag-->"+ (String)returnList.get(1));
				wonForm.setErrorMessage((String)returnList.get(0));
				System.out.println("emesg-->"+ (String)returnList.get(0));
			}
			else
			{
				wonForm.reset();
				wonForm.setErrorFlag(Constants.falseFlag);
				wonForm.setErrorMessage(Constants.genErrorMessage);
			}
			}
		catch(Exception e){
			e.printStackTrace();
		}
	    forward=mapping.findForward("showPage");
	    return forward; 

	}
public ActionForward deleteWon(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws Exception 
		{
	
	HttpSession session = request.getSession();
	String user=(String)session.getAttribute("empId");
	ActionForward forward=null;
	WonAddForm wonForm=(WonAddForm)form;
	WonManager wonMgr=new WonManager();
     String sowName= wonForm.getSowName();
     String wonNo= wonForm.getWonNo();
     wonForm.setNewWonNo("");
	
	try{
		List returnList=wonMgr.deleteWon(sowName,wonNo,user);
		if(returnList!=null && returnList.size()!=0)
		{
			
			wonForm.setErrorFlag((String)returnList.get(1));
			System.out.println("eflag-->"+ (String)returnList.get(1));
			wonForm.setErrorMessage((String)returnList.get(0));
			System.out.println("emesg-->"+ (String)returnList.get(0));
		}
		else
		{
			wonForm.reset();
			wonForm.setErrorFlag(Constants.falseFlag);
			wonForm.setErrorMessage(Constants.genErrorMessage);
		}
		}
	catch(Exception e){
		e.printStackTrace();
	}
    forward=mapping.findForward("showPage");
    return forward; 
}
}
