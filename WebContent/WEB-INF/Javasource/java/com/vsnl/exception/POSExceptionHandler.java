package com.vsnl.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;



public class POSExceptionHandler extends ExceptionHandler {
	
	   public ActionForward execute(
		        Exception ex,
		        ExceptionConfig ae,
		        ActionMapping mapping,
		        ActionForm formInstance,
		        HttpServletRequest request,
		        HttpServletResponse response)
		        throws ServletException {
	        ActionForward forward =
	            super.execute(ex, ae, mapping, formInstance, request, response);
	        
	        request.setAttribute("POSERROR", ex);
	        return forward;
	   }

	    protected void storeException(HttpServletRequest request, String property, ActionMessage message, ActionForward forward) {
			
			System.out.println("Error="+message);
			ActionMessages messages = new ActionMessages();
			
	        // Object[] arr1 = error.getValues();
			
			messages.add("log.error.detail", message);

	        request.setAttribute(Globals.ERROR_KEY, messages);

	    }
}