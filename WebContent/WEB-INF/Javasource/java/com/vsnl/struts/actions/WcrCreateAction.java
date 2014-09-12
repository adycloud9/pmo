/** 
 * 
 * 
 * Name: WcrCreateAction.java
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
import java.text.NumberFormat;//ver 1.1
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;//ver 1.1
import java.util.Locale;//ver 1.1
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vsnl.model.WcrAdd;
import com.vsnl.struts.forms.WcrForm;

import com.vsnl.dao.CommonDao;
import com.vsnl.exception.AppException;
import com.vsnl.manager.CommonManager;
import com.vsnl.manager.WcrManager;



public class WcrCreateAction extends CorpPOSAction {
	
	protected Map getKeyMethodMap() {
		Map map = new HashMap();
		map.put("showWcr","showWcr");
		map.put("getMilestoneDetails","getMilestoneDetails");
		map.put("getMilestoneDetailsTemp","getMilestoneDetailsTemp");//ver 1.1
	    map.put("submitWcr","submitWcr");
	    map.put("getProgramManagerNames","getProgramManagerNames");
		map.put("showEditWcr", "showEditWcr");
		map.put("getMilestoneDetailsForEdit","getMilestoneDetailsForEdit");
		map.put("getMilestoneDetailsForEditTemp","getMilestoneDetailsForEditTemp");//ver 1.1
		map.put("showPriviewData", "showPriviewData");//sanjay	 
		map.put("showReprintWcr","showReprintWcr");
		map.put("getWcrDetails","getWcrDetails");
		map.put("previewWcr","previewWcr");
		map.put("showBilledWcr","showBilledWcr");
		map.put("setBilledWcr","setBilledWcr");
		map.put("getWcrDetailsForInvoice","getWcrDetailsForInvoice");
		return map;
	
}
	public ActionForward showWcr(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		WcrManager wcrManager = new WcrManager();
		
		wcrForm.reset();
		
		try{
			
			wcrForm.setWcrRefId(wcrManager.getWcrId());
		    
			System.out.println("WCR REF ID ==>"+wcrForm.getWcrRefId() );
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		forward=mapping.findForward("WCRjsp");
		return forward; 
		
	}
	
	
	public ActionForward getMilestoneDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
	     
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		WcrManager wcrManager = new WcrManager();
		CommonManager cmgr=new CommonManager();
		WcrAdd wcrAdd = new WcrAdd();
		String Dt[] = new String [3];

		wcrForm.setVisibility("True");
		
		wcrAdd.setSowName(wcrForm.getSowName());
		
		try{
			wcrAdd.setWonNo(wcrForm.getWonNo());
			wcrAdd.setPoNo(wcrForm.getPoNo());
						
			String []inParams={wcrAdd.getSowName()}; 
			System.out.println("array length"+inParams.length);
			wcrForm.setWonList(cmgr.getDropdownValuesByQuery("wonQuery", inParams));
			String []inParamsPo={wcrForm.getWonNo()};
			wcrForm.setPoList(cmgr.getDropdownValuesByQuery("poQuery",inParamsPo ));
			
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter= 
			new SimpleDateFormat("dd-MMM-yyyy");
			String dateNow = formatter.format(currentDate.getTime());
			System.out.println("Date ====> "+dateNow);
			
		    int lastDate = currentDate.getActualMaximum(Calendar.DATE);

		    System.out.println("lastDate ====> "+lastDate);
		     
		    Dt = dateNow.split("-");
			String mnth = Dt[1];
			String year=Dt[2];
			
			wcrForm.setFromDate("1-"+mnth+"-"+year);
			wcrForm.setToDate(lastDate+"-"+mnth+"-"+year);
			wcrAdd.setWcrRefId(wcrForm.getWcrRefId());
			wcrAdd.setFlowFlag(wcrForm.getFlowFlag());
		    wcrForm.setMilestoneDtlsList(wcrManager.getMilestones(wcrAdd,null,null,null));
		    wcrForm.setTotalSize(wcrForm.getMilestoneDtlsList().size());
		    wcrAdd=wcrManager.getPersonDetails(wcrAdd);
		    
		    
			wcrForm.setPreparedBy(wcrAdd.getPreparedBy());
			wcrForm.setApprovedBy(wcrAdd.getApprovedBy());
			wcrForm.setAuthorisedBy(wcrAdd.getAuthorisedBy());
			wcrForm.setAppByDesig(wcrAdd.getAppByDesig());
			wcrForm.setPrepByDesig(wcrAdd.getPrepByDesig());
			wcrForm.setAuthByDesig(wcrAdd.getAuthByDesig());
	     //	wcrForm.setBuList(cmgr.getDropdownValuesByQuery(BuQuery,null));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		forward=mapping.findForward("WCRjsp");
		
		return forward; 
		
	}
	//ver 1.1 starts here
	public ActionForward getMilestoneDetailsTemp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
	     
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		WcrManager wcrManager = new WcrManager();
		CommonManager cmgr=new CommonManager();
		WcrAdd wcrAdd = new WcrAdd();
		String Dt[] = new String [3];

		wcrForm.setVisibility("True");
		
		wcrAdd.setSowName(wcrForm.getSowName());
		
		try{
			
  		 
            retainFormFields(request,wcrForm.getMilestoneDtlsList());
            wcrForm.setTotalSize(wcrForm.getMilestoneDtlsList().size());
			wcrAdd.setWonNo(wcrForm.getWonNo());
			wcrAdd.setPoNo(wcrForm.getPoNo());
						
			String []inParams={wcrAdd.getSowName()}; 
			System.out.println("array length"+inParams.length);
			wcrForm.setWonList(cmgr.getDropdownValuesByQuery("wonQuery", inParams));
			String []inParamsPo={wcrForm.getWonNo()};
			wcrForm.setPoList(cmgr.getDropdownValuesByQuery("poQuery",inParamsPo ));
			
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter= 
			new SimpleDateFormat("dd-MMM-yyyy");
			String dateNow = formatter.format(currentDate.getTime());
			System.out.println("Date ====> "+dateNow);
			
		    int lastDate = currentDate.getActualMaximum(Calendar.DATE);

		    System.out.println("lastDate ====> "+lastDate);
		     
		    Dt = dateNow.split("-");
			String mnth = Dt[1];
			String year=Dt[2];
			
			wcrForm.setFromDate("1-"+mnth+"-"+year);
			wcrForm.setToDate(lastDate+"-"+mnth+"-"+year);
			wcrAdd.setWcrRefId(wcrForm.getWcrRefId());
			wcrAdd.setFlowFlag(wcrForm.getFlowFlag());
		   
		    wcrAdd=wcrManager.getPersonDetails(wcrAdd);
		    
		    
			wcrForm.setPreparedBy(wcrAdd.getPreparedBy());
			wcrForm.setApprovedBy(wcrAdd.getApprovedBy());
			wcrForm.setAuthorisedBy(wcrAdd.getAuthorisedBy());
			wcrForm.setAppByDesig(wcrAdd.getAppByDesig());
			wcrForm.setPrepByDesig(wcrAdd.getPrepByDesig());
			wcrForm.setAuthByDesig(wcrAdd.getAuthByDesig());
	     //	wcrForm.setBuList(cmgr.getDropdownValuesByQuery(BuQuery,null));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		forward=mapping.findForward("WCRjsp");
		
		return forward; 
		
	}
	//ver 1.1 ends here
	public ActionForward submitWcr(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
		CommonManager commonManager=new CommonManager();
		ActionForward forward=null;
		HttpSession session = request.getSession();
		String returnMsg="Success";
		String user=(String)session.getAttribute("empId");
		WcrForm wcrForm=(WcrForm)form;
		WcrManager wcrManager = new WcrManager();
		WcrAdd wcrAdd =new WcrAdd();
		
		wcrAdd.setUser(user);
		retainFormFieldsForSubmit(request,wcrForm.getMilestoneDtlsList());//ver 1.1
		formToEntity(wcrForm,wcrAdd);
		NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);//ver 1.1
		nf.setGroupingUsed(true);//ver 1.1
		
		try{
			returnMsg=wcrManager.submitWCR(wcrAdd);		
			
		    System.out.println("returnMsg in action==>"+returnMsg);
			wcrForm.setMsg(returnMsg);
			
		}catch(Exception ex){
			ex.printStackTrace();
			//ver 1.1 starts here
			if("C".equalsIgnoreCase(wcrAdd.getFlowFlag())){	
				forward=mapping.findForward("WCRjsp");
			} else {
				forward=mapping.findForward("EditWcrJsp");
			}
		// ver 1.1 ends here
		}
		//ver 1.1 starts here
		if(wcrForm.getMsg().equalsIgnoreCase("WCR Created Successfully")||wcrForm.getMsg().equalsIgnoreCase("WCR Edited Successfully"))
		{
			 int j=0;
		     double amt=0;
		   
		    if(wcrAdd.getMilestoneDtlsList()!=null && wcrAdd.getMilestoneDtlsList().size()>0)
		     {
		    	for(int i=0;i<wcrAdd.getMilestoneDtlsList().size();i++)
				{
					
		    	 WcrAdd wr = (WcrAdd)wcrAdd.getMilestoneDtlsList().get(i);
		         System.out.println("wr.getBillingCheck()"+wr.getBillingCheck());
		         System.out.println("wr.getBillStatus()"+wr.getBillStatus());
		         if(wr.getBillingCheck().equalsIgnoreCase("true")&& wr.getBillStatus().equalsIgnoreCase("on"))
		         {
		        	 wr.setMilestoneAmtFormatted(commonManager.amtWithComma(wr.getMilestoneAmnt()));	 
		        	 j++;
		        	 amt=amt+Double.parseDouble(wr.getMilestoneAmnt());
		         }
		         
				}
		    	 String amount = Double.toString(amt);
		       //String Totalamount=commonManager.amtWithComma(amount);
		  	wcrForm.setTotalAmt(amount);
		    	System.out.println("size of j"+j);
		    	wcrForm.setListSize(j);
		     }
			forward=mapping.findForward("wcrPreviewjsp");
		}else
		{
			//ver 1.1 ends here
		/*if("C".equalsIgnoreCase(wcrAdd.getFlowFlag())){	
			forward=mapping.findForward("WCRjsp");
		} else {
			forward=mapping.findForward("EditWcrJsp");
		}*/
		
		}//ver 1.1
		return forward; 
		
	}
	//ver 1.1 starts here
	public void retainFormFields(HttpServletRequest request,List wcList)
	{
		if(wcList!=null && wcList.size()>0)
		{
			int notesListSize= wcList.size();
			for(int i=0;i<notesListSize;i++)
			{
				if(i!=Integer.parseInt((String)request.getParameter("delIndex"))) 
				{
					WcrAdd crNote = (WcrAdd)wcList.get(i);
					System.out.println("billStatus"+i+"data"+request.getParameter("milestoneDtlsList["+i+"].billStatus"));
					crNote.setBillStatus(CommonManager.replaceNull(request.getParameter("milestoneDtlsList["+i+"].billStatus")));
					System.out.println("billingCheck"+i+"data"+request.getParameter("milestoneDtlsList["+i+"].billingCheck"));
					crNote.setBillingCheck(CommonManager.replaceNull(request.getParameter("milestoneDtlsList["+i+"].billingCheck")));
				
				}
			}
		}
		
	}
	public void retainFormFieldsForSubmit(HttpServletRequest request,List wcList)
	{
		if(wcList!=null && wcList.size()>0)
		{
			int notesListSize= wcList.size();
			for(int i=0;i<notesListSize;i++)
			{
				if(i!=Integer.parseInt((String)request.getParameter("delIndex"))) 
				{
					WcrAdd crNote = (WcrAdd)wcList.get(i);
					
					crNote.setBillStatus(CommonManager.replaceNull(request.getParameter("milestoneDtlsList["+i+"].billStatus")));
					if(request.getParameter("milestoneDtlsList["+i+"].billStatus")!=null)
					{	
					System.out.println(">>>>>>>>>>>>>>>>>>>count>>>>>>>>>>>>>>>"+i);
					System.out.println(request.getParameter("milestoneDtlsList["+i+"].billStatus"));
					if(request.getParameter("milestoneDtlsList["+i+"].billStatus").equalsIgnoreCase("on"))
					{	
						request.setAttribute("milestoneDtlsList["+i+"].billingCheck","true");
						System.out.println(request.getParameter("milestoneDtlsList["+i+"].billingCheck"));
						crNote.setBillingCheck(CommonManager.replaceNull(request.getParameter("milestoneDtlsList["+i+"].billingCheck")));
				
					}else
					{
						crNote.setBillingCheck("false");
					}
				}
			 }
		 }	
	  }
	}
	//ver 1.1 ends here
	public void formToEntity(WcrForm wcrForm,WcrAdd wcrAdd){
		
		wcrAdd.setSowName(wcrForm.getSowName());
		wcrAdd.setWonNo(wcrForm.getWonNo());
		wcrAdd.setPoNo(wcrForm.getPoNo());
		wcrAdd.setSelectedIndex(wcrForm.getSelectedIndex());
		wcrAdd.setMilestoneDtlsList(wcrForm.getMilestoneDtlsList());
		wcrAdd.setToDate(wcrForm.getToDate());
		wcrAdd.setFromDate(wcrForm.getFromDate());
		wcrAdd.setApprovedBy(wcrForm.getApprovedBy());
		wcrAdd.setAuthorisedBy(wcrForm.getAuthorisedBy());
		wcrAdd.setPreparedBy(wcrForm.getPreparedBy());
		wcrAdd.setFlowFlag(wcrForm.getFlowFlag());
		wcrAdd.setBusinessUnit(wcrForm.getBusinessUnit());
		wcrAdd.setWcrRefId(wcrForm.getWcrRefId());
	}
	
	public ActionForward showEditWcr(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		System.out.println("Inside showEditWcr in action");
		wcrForm.reset();
		System.out.println("Inside showEditWcr");
		forward=mapping.findForward("EditWcrJsp");
		return forward; 
		
	}
	
	// ver 1.1 starts here
	public ActionForward getMilestoneDetailsForEditTemp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
	
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		WcrManager wcrManager = new WcrManager();
		CommonManager cmgr=new CommonManager();
		CommonDao commonDao=new CommonDao();
		WcrAdd wcrAdd = new WcrAdd();
		String Dt[] = new String [3];
		wcrForm.setVisibility("True");
		
		wcrAdd.setSowName(wcrForm.getSowName());
		
		try{
			retainFormFields(request,wcrForm.getMilestoneDtlsList());
			wcrForm.setTotalSize(wcrForm.getMilestoneDtlsList().size());
			wcrAdd.setWonNo(wcrForm.getWonNo());
			wcrAdd.setPoNo(wcrForm.getPoNo());
			wcrAdd.setFlowFlag(wcrForm.getFlowFlag());
			wcrAdd.setWcrRefId(wcrForm.getWcrRefId());
						
						
			String []inParams={wcrAdd.getSowName()}; 
			System.out.println("array length"+inParams.length);
			wcrForm.setWonList(cmgr.getDropdownValuesByQuery("wonQuery", inParams));
			String []inParamsPo={wcrForm.getWonNo()};
			wcrForm.setPoList(cmgr.getDropdownValuesByQuery("poQuery",inParamsPo ));
			
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter= 
			new SimpleDateFormat("dd-MMM-yyyy");
			String dateNow = formatter.format(currentDate.getTime());
			System.out.println("Date ====> "+dateNow);
			
		    int lastDate = currentDate.getActualMaximum(Calendar.DATE);

		    System.out.println("lastDate ====> "+lastDate);
		     
		    Dt = dateNow.split("-");
			String mnth = Dt[1];
			String year=Dt[2];
			
			wcrForm.setFromDate("1-"+mnth+"-"+year);
			wcrForm.setToDate(lastDate+"-"+mnth+"-"+year);
			String approverKey="getApprovingDetails";
			String approverInParams[]={wcrForm.getSowName()};
			List returnList=(ArrayList)commonDao.getDatafromDbByQuery(approverKey, approverInParams);
			String approver[]=(String [])returnList.get(0);
			
		    //wcrAdd=wcrManager.getPersonDetails(wcrAdd);
		    wcrForm.setPreparedBy(approver[0]);
		    wcrForm.setApprovedBy(approver[1]);
		    wcrForm.setAuthorisedBy(approver[2]);
			wcrForm.setPreparedByList(cmgr.getDropdownValuesByQuery("WCR.PrepList",null));
			wcrForm.setApprovedByList(cmgr.getDropdownValuesByQuery("WCR.AppList",null));
			wcrForm.setAuthorisedByList(cmgr.getDropdownValuesByQuery("WCR.AuthList",null));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		forward=mapping.findForward("EditWcrJsp");
		
		return forward; 
		
	}
	// ver 1.1 ends here
	public ActionForward getMilestoneDetailsForEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
	
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		WcrManager wcrManager = new WcrManager();
		CommonManager cmgr=new CommonManager();
		WcrAdd wcrAdd = new WcrAdd();
		String Dt[] = new String [3];
		wcrForm.setVisibility("True");
		
		wcrAdd.setSowName(wcrForm.getSowName());
		
		try{
		   
			wcrAdd.setWonNo(wcrForm.getWonNo());
			wcrAdd.setPoNo(wcrForm.getPoNo());
			wcrAdd.setFlowFlag(wcrForm.getFlowFlag());
			wcrAdd.setWcrRefId(wcrForm.getWcrRefId());
						
			String []inParams={wcrAdd.getSowName()}; 
			System.out.println("array length"+inParams.length);
			wcrForm.setWonList(cmgr.getDropdownValuesByQuery("wonQuery", inParams));
			String []inParamsPo={wcrForm.getWonNo()};
			wcrForm.setPoList(cmgr.getDropdownValuesByQuery("poQuery",inParamsPo ));
			String []inParamsRefId={wcrAdd.getSowName(),wcrForm.getPoNo()};
			wcrForm.setWcrRefIdList(cmgr.getDropdownValuesByQuery("WCR.getWcrRefIds",inParamsRefId ));
		
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter= 
			new SimpleDateFormat("dd-MMM-yyyy");
			String dateNow = formatter.format(currentDate.getTime());
			System.out.println("Date ====> "+dateNow);
			
		    int lastDate = currentDate.getActualMaximum(Calendar.DATE);

		    System.out.println("lastDate ====> "+lastDate);
		     
		    Dt = dateNow.split("-");
			String mnth = Dt[1];
			String year=Dt[2];
			
			wcrForm.setFromDate("1-"+mnth+"-"+year);
			wcrForm.setToDate(lastDate+"-"+mnth+"-"+year);
			String milestoneKey="getWcrMilestoneDetails";
			String wcrKey="getWcrRefIdDetails";
			String approverKey="WCR.getAuthAndDesignation";
			List returnList=(ArrayList)wcrManager.getMilestones(wcrAdd,milestoneKey,wcrKey,approverKey);
			if(returnList!=null &&  returnList.size()!=0)
			{
				wcrForm.setWcrDetailsList((ArrayList)returnList.get(0));
				wcrForm.setMilestoneDtlsList((ArrayList)returnList.get(1));
				wcrForm.setTotalSize(wcrForm.getMilestoneDtlsList().size());
				wcrForm.setWcrListSize(wcrForm.getWcrDetailsList().size());
			}
			
		    wcrAdd=wcrManager.getPersonDetails(wcrAdd);
			
			List list=(ArrayList)returnList.get(2);
			WcrAdd wcrAdd2=(WcrAdd)list.get(0);
			wcrForm.setPreparedBy(wcrAdd2.getPreparedBy());
			wcrForm.setApprovedBy(wcrAdd2.getApprovedBy());
			wcrForm.setAuthorisedBy(wcrAdd2.getAuthorisedBy());
			wcrForm.setAppByDesig(wcrAdd2.getAppByDesig());
			wcrForm.setPrepByDesig(wcrAdd2.getPrepByDesig());
			wcrForm.setAuthByDesig(wcrAdd2.getAuthByDesig());
			
			wcrForm.setPreparedByList(cmgr.getDropdownValuesByQuery("WCR.PrepList",null));
			wcrForm.setApprovedByList(cmgr.getDropdownValuesByQuery("WCR.AppList",null));
			wcrForm.setAuthorisedByList(cmgr.getDropdownValuesByQuery("WCR.AuthList",null));
			
	     //	wcrForm.setBuList(cmgr.getDropdownValuesByQuery("WCR.BuList",null));
			
	     	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		forward=mapping.findForward("EditWcrJsp");
		
		return forward; 
		
	}
	//ver 1.1 starts here
	public ActionForward showPriviewData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException
			{
		     ActionForward forward=null;
		    
		     WcrForm wcrForm=(WcrForm)form;
		     int j=0;
		     double amt=0;
		     CommonManager commonManager=new CommonManager();
		    NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);//ver 1.1
				nf.setGroupingUsed(true);//ver 1.1
		    if(wcrForm.getMilestoneDtlsList()!=null && wcrForm.getMilestoneDtlsList().size()>0)
		     {
		    	for(int i=0;i<wcrForm.getMilestoneDtlsList().size();i++)
				{
		    		WcrAdd wr = (WcrAdd)wcrForm.getMilestoneDtlsList().get(i);
		    		 if(wr.getBillingCheck().equalsIgnoreCase("true"))
			         {
		    			 wr.setMilestoneAmtFormatted(commonManager.amtWithComma(wr.getMilestoneAmnt()));	 
			        	 j++;
			        	 amt=amt+Double.parseDouble(wr.getMilestoneAmnt());
			         }
				}
		    	 String amount = Double.toString(amt);
		    	// String Totalamount=commonManager.amtWithComma(amount);
				  	wcrForm.setTotalAmt(amount);
		    	System.out.println("size of j"+j);
		    	wcrForm.setListSize(j);
		     }
		     forward=mapping.findForward("wcrPreviewjsp");
			 return forward;
			}
//ver 1.1 ends here
	
	public ActionForward showReprintWcr(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		
		wcrForm.reset();
		
		forward=mapping.findForward("ReprintWcrJsp");
		return forward; 
		
	}
	
	public ActionForward getWcrDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
		
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		WcrAdd wcrAdd = new WcrAdd();
		WcrManager wcrMgr = new WcrManager();
		CommonManager cmgr = new CommonManager();
		String flag = "S";
		
		System.out.println(wcrForm.getMode());
		wcrAdd.setSowName(wcrForm.getSowName()) ;
		wcrAdd.setWonNo(wcrForm.getWonNo());
		wcrAdd.setPoNo(wcrForm.getPoNo());
		if(!(wcrAdd.getWonNo().equals("") ) && !(wcrAdd.getPoNo().equals(""))){
			flag = "SWP";
		}else if ((wcrAdd.getPoNo().equals("")  &&  !(wcrAdd.getWonNo().equals("")))){
			flag = "SW";
		}
		try {
			wcrForm.setWcrDetailsList(wcrMgr.getWcrDetails(wcrAdd,flag));
		    wcrForm.setTotalSize(wcrForm.getWcrDetailsList().size());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		if("SWP".equalsIgnoreCase(flag)){
			String []inParams={wcrAdd.getSowName()}; 
			System.out.println("array length"+inParams.length);
			wcrForm.setWonList(cmgr.getDropdownValuesByQuery("wonQuery", inParams));
			String []inParamsPo={wcrForm.getWonNo()};
			wcrForm.setPoList(cmgr.getDropdownValuesByQuery("poQuery",inParamsPo ));
		}else if ("SW".equalsIgnoreCase(flag)){
			String []inParams={wcrAdd.getSowName()}; 
			System.out.println("array length"+inParams.length);
			wcrForm.setWonList(cmgr.getDropdownValuesByQuery("wonQuery", inParams));
		}
		wcrForm.setVisibility("true");
		
		forward=mapping.findForward("ReprintWcrJsp");
		
		return forward; 
		
	}


public ActionForward previewWcr(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException
		{
	     ActionForward forward=null;
	    CommonManager commonManager=new CommonManager();
	     WcrForm wcrForm=(WcrForm)form;
	     WcrManager wcrMgr = new WcrManager();
	     WcrAdd wcrAdd = new WcrAdd();
	     WcrAdd wcrAdd1 = new WcrAdd();
	     
	     String poNo = (String) request.getParameter("poNo");
	     String wonNo = (String) request.getParameter("wonNo");
	    String refId= (String) request.getParameter("refId");
	     
	     wcrAdd.setSowName(wcrForm.getSowName());
	     wcrAdd.setPoNo(poNo);
	     wcrAdd.setWonNo(wonNo);
	     wcrAdd.setWcrRefId(Integer.parseInt(refId));
	     
	     try {
	    	wcrForm.setMilestoneDtlsList(wcrMgr.getMilestoneDtlsForPrvw(wcrAdd));
	    	wcrAdd=wcrMgr.getPersonDetails(wcrAdd);
	     }catch(Exception ex){
				ex.printStackTrace();
			}
	     
	     wcrAdd1=(WcrAdd)wcrForm.getMilestoneDtlsList().get(0);
	     wcrForm.setFromDate(wcrAdd1.getFromDate());
	     wcrForm.setToDate(wcrAdd1.getToDate());
	     wcrForm.setWcrRefId(wcrAdd.getWcrRefId());
	     wcrForm.setPreparedBy(wcrAdd.getPreparedBy());
		 wcrForm.setApprovedBy(wcrAdd.getApprovedBy());
		 wcrForm.setAuthorisedBy(wcrAdd.getAuthorisedBy());
		 wcrForm.setAppByDesig(wcrAdd.getAppByDesig());
		 wcrForm.setPrepByDesig(wcrAdd.getPrepByDesig());
		 wcrForm.setAuthByDesig(wcrAdd.getAuthByDesig());
		 wcrForm.setVisibility("False");
		 
	     
	     int j=0;
	     double amt=0;
	     NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);//ver 1.1
			nf.setGroupingUsed(true);//ver 1.1
	    if(wcrForm.getMilestoneDtlsList()!=null && wcrForm.getMilestoneDtlsList().size()>0)
	     {
	    	for(int i=0;i<wcrForm.getMilestoneDtlsList().size();i++)
	     
			{
	    		WcrAdd wr = (WcrAdd)wcrForm.getMilestoneDtlsList().get(i);
	    		 
	    		 wr.setMilestoneAmtFormatted(commonManager.amtWithComma(wr.getMilestoneAmnt()));	 
		        	 j++;
		        	 amt=amt+Double.parseDouble(wr.getMilestoneAmnt());
		         
		         
				}
	    	 String amount = Double.toString(amt);
	    	 //String Totalamount=commonManager.amtWithComma(amount);
			  	wcrForm.setTotalAmt(amount);
	    	System.out.println("size of j"+j);
	    	wcrForm.setListSize(j);
	     }
	    
	    
	     forward=mapping.findForward("wcrPreviewjsp");
		 return forward;
		}

    public ActionForward showBilledWcr(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)throws AppException {
	ActionForward forward=null;
	WcrForm wcrForm=(WcrForm)form;
	
	wcrForm.reset();
	wcrForm.setMode("Billed");
	wcrForm.setDisplayFlag("");
	forward=mapping.findForward("BilledWCRJsp");
	return forward; 
	
}

   public ActionForward setBilledWcr(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)throws AppException {
    	ActionForward forward=null;
    	WcrForm wcrForm=(WcrForm)form;
    	WcrManager wcrManager=new WcrManager();
    	List list=new ArrayList();
    	String key="Wcr.billedQuery";
    	String maxLimit=request.getParameter("maxCount");
    	String maxListLimit[]=maxLimit.split(",");
    	wcrForm.setMode("Billed");
    	try {
    		List dataList=retainFormFieldsforBillingWCR(request);
        	int count[]=wcrManager.setBilledWcr(key,dataList);
        	for (int i = 0; i < count.length; i++) 
        	{
        		if (maxListLimit[i]==null) {
        			maxListLimit[i]="0";
				}
        		else if(maxListLimit[i].equalsIgnoreCase(""))
        			     maxListLimit[i]="0";
        			     
        		WcrAdd wcrAdd=(WcrAdd)wcrForm.getWcrDetailsList().get(Integer.parseInt(maxListLimit[i]));	
				if(count[i]!=0)
				{
					wcrAdd.setBilledFlag("Billed Successfully");
				}else {
					wcrAdd.setBilledFlag("Billed Unsuccessfully");
				}
				list.add(wcrAdd);
			}
        	wcrForm.setWcrDetailsList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	wcrForm.setDisplayFlag("display");
    	forward=mapping.findForward("BilledWCRJsp");
    	return forward; 
    }
    public List retainFormFieldsforBillingWCR(HttpServletRequest request)
	{
		WcrAdd wcrAdd=null;
		//int maxListLimit=(String)CommonManager.replace(request.getParameter("maxCount"),"", "0"));
		String maxLimit=request.getParameter("maxCount");
		String maxListLimit[]=maxLimit.split(",");
		List dataList=new ArrayList();
		for (int i = 0; i < maxListLimit.length; i++)
		{
			wcrAdd=new WcrAdd();
			wcrAdd.setSowName(request.getParameter("wcrDetailsList["+maxListLimit[i]+"].sowName"));
			wcrAdd.setWcrRefId(Integer.parseInt(CommonManager.replace((request.getParameter("wcrDetailsList["+maxListLimit[i]+"].wcrRefId")),"", "0")));
			wcrAdd.setInvoiceNumber(request.getParameter("wcrDetailsList["+maxListLimit[i]+"].invoiceNumber"));
			dataList.add(wcrAdd);
		}
		return dataList;
	}
    public ActionForward getWcrDetailsForInvoice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws AppException {
		
		ActionForward forward=null;
		WcrForm wcrForm=(WcrForm)form;
		WcrAdd wcrAdd = new WcrAdd();
		WcrManager wcrMgr = new WcrManager();
		CommonManager cmgr = new CommonManager();
		String flag = "S";
		String mode=wcrForm.getMode();
		wcrAdd.setInvoiceMode("Billed");
		String buttonFlag=wcrForm.getButtonFlag();
		wcrAdd.setButtonFlag(buttonFlag);
		System.out.println(wcrForm.getMode());
		wcrAdd.setSowName(wcrForm.getSowName()) ;
		wcrAdd.setWonNo(wcrForm.getWonNo());
		wcrAdd.setPoNo(wcrForm.getPoNo());
		if(!(wcrAdd.getWonNo().equals("") ) && !(wcrAdd.getPoNo().equals(""))){
			flag = "SWP";
		}else if ((wcrAdd.getPoNo().equals("")  &&  !(wcrAdd.getWonNo().equals("")))){
			flag = "SW";
		}
		try {
			wcrForm.setWcrDetailsList(wcrMgr.getWcrDetails(wcrAdd,flag));
		    wcrForm.setTotalSize(wcrForm.getWcrDetailsList().size());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		if("SWP".equalsIgnoreCase(flag)){
			String []inParams={wcrAdd.getSowName()}; 
			System.out.println("array length"+inParams.length);
			wcrForm.setWonList(cmgr.getDropdownValuesByQuery("wonQuery", inParams));
			String []inParamsPo={wcrForm.getWonNo()};
			wcrForm.setPoList(cmgr.getDropdownValuesByQuery("poQuery",inParamsPo ));
		}else if ("SW".equalsIgnoreCase(flag)){
			String []inParams={wcrAdd.getSowName()}; 
			System.out.println("array length"+inParams.length);
			wcrForm.setWonList(cmgr.getDropdownValuesByQuery("wonQuery", inParams));
		}
		wcrForm.setVisibility("true");
		
			wcrForm.setDisplayFlag("");
			forward=mapping.findForward("BilledWCRJsp");	
		
		
		return forward; 
		
	}
}
