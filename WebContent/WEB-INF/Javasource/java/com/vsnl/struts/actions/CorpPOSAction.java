package com.vsnl.struts.actions;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

public abstract class CorpPOSAction extends LookupDispatchAction{
	abstract protected Map getKeyMethodMap();
	
	 public ActionForward execute(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String methodName=null;
	        try{
	        //Identify the request parameter containing the method name
	        String parameter = mapping.getParameter();
	        
	        //System.out.println("@@ Token: "+isTokenValid(request));
	        if (parameter == null) {
	            String message = messages.getMessage("dispatch.handler", mapping.getPath());          
	            throw new ServletException(message);
	        }

	        // Identify the string to lookup
	        String name = request.getParameter(parameter);
	        System.out.println("The parameter value is:" + name );
	        /*if (name == null) {
	            String message = messages.getMessage("dispatch.parameter", mapping.getPath(), parameter);
	            throw new ServletException(message);
	        }*/
	        this.keyMethodMap = this.getKeyMethodMap();
	        System.out.println("this.keyMethodMap " + this.keyMethodMap);
	         methodName = (String) keyMethodMap.get(name);
	        }catch(Exception e){
	        	System.out.println("Exception: "+e);
	        }
	        return dispatchMethod(mapping, form, request, response, methodName);
	    }
}
