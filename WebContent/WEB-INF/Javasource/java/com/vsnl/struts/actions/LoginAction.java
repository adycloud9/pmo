/** 
 * 
 * 
 * Name: LoginAction.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ===================================================================================================== 
 *                            Prior 
 * Date        By              Version      Description 
 * ---------- --------------- -------  ------------------------------------------------------------------ 
 *      
 * 
 * =========================================================================================================== 
 * </pre> 
 * 
  

 **/
package com.vsnl.struts.actions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vsnl.struts.forms.LoginForm;
import com.vsnl.util.Constants;

import com.vsnl.dao.CommonDao;
import com.vsnl.dao.LoginDao;
import com.vsnl.dao.LoginDataPopulator;
import com.vsnl.exception.AppException;

import com.vsnl.manager.ExcelManager;
import com.vsnl.manager.LoginManager;
import com.vsnl.model.Login;
import javax.servlet.http.HttpSession;
public class LoginAction extends CorpPOSAction {
	
	Logger logger = Logger.getLogger(LoginAction.class);

	   
		protected Map getKeyMethodMap() {
			Map map = new HashMap();
		    map.put("showChangePassword","showChangePassword");
			map.put("login", "login");
			map.put(null, "logout");
			map.put("reset", "reset");
			map.put("checkChangePassword","checkChangePassword");
			map.put("changePassword","changePassword");
			map.put("resetPassword","resetPassword");
			map.put("showResetPassword","showResetPassword");
			map.put("downloadHelp","downloadHelp");
			
			return map;
		
	}
	
public ActionForward showChangePassword(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
	ActionForward forward=null;
	logger.info("inside method showChangrPassword::LoginAction starts ");
	LoginForm loginForm =(LoginForm)form;
	loginForm.reset();
	loginForm.setEmpId((String)request.getSession().getAttribute("empId"));
	loginForm.setHiddenPwd((String)request.getSession().getAttribute("password"));
	forward=mapping.findForward("chgPass");
	logger.info("inside method showChangrPassword::LoginAction ends");
	return forward; 
	
}
public ActionForward logout(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
	ActionForward forward=null;
	LoginForm loginForm =(LoginForm)form;
	loginForm.reset();
	forward=mapping.findForward("Login");
	return forward; 
	
}
public ActionForward reset(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
	ActionForward forward=null;
	LoginForm loginForm =(LoginForm)form;
	loginForm.reset();
	forward=mapping.findForward("Login");
	return forward; 
	
}

public ActionForward login(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException
     {
	     ActionForward forward=null;
		 LoginManager userValidator=new LoginManager();
		 LoginForm loginForm=(LoginForm)form;
		 Login model=new Login();
		 HttpSession session = request.getSession();
		 LoginDataPopulator dataPopulator = new LoginDataPopulator();
		 model.setEmpId(loginForm.getEmpId());
		 model.setPassword(loginForm.getPassword());
		 
		 
		 int check=0;
		 
			try{
				 check=userValidator.checkPassword(model);
				 if(check==1)
				 {
					 String userRole = dataPopulator.getUserRole(loginForm.getEmpId());
					 List menuList = dataPopulator.getMenu(userRole);
					 session.setAttribute("empId", loginForm.getEmpId());
					 session.setAttribute("UserName", getNameFromEmpId(loginForm.getEmpId()));
					 session.setAttribute("USER_ROLE",userRole);
					 session.setAttribute("menu",menuList);
					 session.setAttribute("password",loginForm.getPassword());
					 forward=mapping.findForward("success");
				 }
				 else
				 {
					 loginForm.reset(mapping, request);
					 loginForm.setFlag(false);
					 forward=mapping.findForward("Login");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			 return forward;
}


//ver 1.1 Starts
public ActionForward changePassword(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException, SQLException {
	 
	ActionForward forward=null;
	HttpSession session = request.getSession();
	
	LoginForm loginForm=(LoginForm)form;
	LoginManager loginMgr=new LoginManager();
	Login model=new Login();
	String returnMsg = Constants.successIndicator;
	String empId = loginForm.getEmpId();
	String hiddenPwd = loginForm.getHiddenPwd();
	
	session.setAttribute("password",hiddenPwd);
	model.setEmpId(loginForm.getEmpId());
	model.setPassword(loginForm.getPassword());
	model.setNewPassword1(loginForm.getNewPassword1());
	model.setNewPassword2(loginForm.getNewPassword2());
	
	
	returnMsg = loginMgr.changePassword(model);
	loginForm.reset();
	loginForm.setEmpId(empId);
	loginForm.setHiddenPwd(hiddenPwd);
	loginForm.setMsg(returnMsg);
	forward=mapping.findForward("Logout");
	//forward=mapping.findForward("chgPass");
	
	return forward;
}
//ver 1.1 Ends	
public ActionForward showResetPassword(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
	ActionForward forward=null;
	
	LoginForm loginForm =(LoginForm)form;

	loginForm.reset();
	loginForm.setEmpId((String)request.getSession().getAttribute("empId"));
	
	
	forward=mapping.findForward("showReset");
	return forward; 
	
}

public ActionForward resetPassword(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
	ActionForward forward=null;
	
	LoginForm loginForm =(LoginForm)form;
	LoginDao loginDao=new LoginDao();
	try{
	loginForm.setEmpId((String)request.getSession().getAttribute("empId"));
	 String key="login.resetPassword";
	 String empId= loginForm.getEmp_Id();
	 String inParams=empId;
	 int rows=loginDao.getDataByQuery(key, inParams);
	 if(rows>0)
	 {
		 loginForm.setErrorMsg("Password is reseted successfully");
	 }
	 else
	 {
		 loginForm.setErrorMsg("Not able to reset");
	 }
	 loginForm.setMsg(" ");
		loginForm.setErrorFlag(Constants.trueFlag);
		loginForm.setErrorMsg("Password is reseted successfully");
		loginForm.setEmp_Id("");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	
		loginForm.setMsg(" ");
		loginForm.setErrorFlag(Constants.falseFlag);
		loginForm.setErrorMsg("Not able to reset");
	}
     
	/*String inparam[]={empId};
	CommonDao commonDao=new CommonDao();
	commonDao.getDatafromDbByQuery(query, inparam);*/
	forward=mapping.findForward("showReset");
	return forward; 
	
}
public ActionForward downloadHelp(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException
	{	
		ExcelManager manager = new ExcelManager();
		ActionForward forward = new ActionForward();
		String contextPath = this.getServlet().getServletContext().getRealPath("/");
		/*try {
			File excelFile = manager.getBlankTemplate(contextPath, "templates","wcr", ".pdf");
			FileInputStream fileInputStream = new FileInputStream(excelFile);
			String inputStream=fileInputStream.toString();
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			baos=inputStream.getBytes();
			response.setHeader("Content-Disposition","attachment; filename=\"WCR.pdf\"");
			response.setContentType("application/pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		File excelFile = manager.getBlankTemplate(contextPath, "templates","PMO User Manual", ".doc");
		request.setAttribute("fileToDownload", excelFile);
		forward = mapping.findForward("getDownloadOption");
		return forward;
	}
	public String getNameFromEmpId(String empId)
	{
		String key="getNameFromEmpId";
		CommonDao commonDao=new CommonDao();
		String inParams[]={empId};
		String empName="";
		try {
			List empNameList=commonDao.getDatafromDbByQuery(key, inParams);
			if (empNameList!=null && empNameList.size()!=0) {
				String emp[]=(String [])empNameList.get(0);
				empName= emp[0];
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return empName;
	}

}