package com.vsnl.struts.actions;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;
import com.vsnl.util.CheckString;
import com.vsnl.util.Constants;


public class FileDownloadAction extends DownloadAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception
    {
		ActionForward forward = null;	   
    	File fileExported=null;	    	
		fileExported = (File)request.getAttribute("fileToDownload");
		System.out.println("fileExported-->" + fileExported);
	   	request.setAttribute(Constants.EXPORT_FILE_ATTR_NAME,fileExported.getAbsolutePath());
    	super.execute(mapping, form, request, response);
    	return forward;    	
    		
    }
    
    protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		HttpSession session = request.getSession(true);
		String fileType=(String)session.getAttribute("fileType"); 
		String contentType=null;
		if(CheckString.CheckNotNull(fileType))
			contentType = Constants.CONTENT_TYPE_TEXT;
		else
			contentType = Constants.CONTENT_TYPE_MS_EXCEL;		
        File file = new File((String)request.getAttribute(Constants.EXPORT_FILE_ATTR_NAME));
        response.setHeader(Constants.HEADER_CNT_DESP, Constants.HEADER_CNT_DESP_VAL_PREFIX + file.getName());
        return new FileStreamInfo(contentType, file);
     }
}
