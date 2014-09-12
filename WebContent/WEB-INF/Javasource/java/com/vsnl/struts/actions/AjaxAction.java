package com.vsnl.struts.actions;
/** 
 *  
 * 
 * Name: AjaxAction.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            	Prior 
 * Date      		 By         Version  	Description 
 * ---------- --------------- 	-------  ---------------------------------------------------- 
 * 25/02/2010 Rashmi Batra		  1.1	   Changes done for ROAR CR( Location Change in BDC)
 * 17/03/2010 Trupti Gardas       1.2      Changes done for Restructuring of INMARSAT
 * 07/04/2010 Surya Prakash_MCTS  1.3 	   Changes done for Accounting Code as an Attribute CR
 * 27/04/2010 Trupti Gardas       1.4      Changes done for Arrear Billing CR
 * 06/05/2010 Trupti Gardas       1.5      Changes done for defect fix for Restructuring of INMARSAT CR
 * ======================================================================================== 
 * </pre> 
 * 
  

 **/



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsnl.util.Constants;
import com.vsnl.util.FetchResource;
import com.vsnl.exception.AppException;
import com.vsnl.dao.DataAccessObject;





public class AjaxAction extends CorpPOSAction
{
	
	private Logger logger = Logger.getLogger(AjaxAction.class);
	private String v_delimiter = ",";   // ver 1.1
	
	protected Map getKeyMethodMap() {
		Map map = new HashMap();
		map.put("getDetails","getDetails");
		// ver 1.2 starts here
		map.put("getBillingAddr","getBillingAddr");
		map.put("validateInmarProducts","validateInmarProducts");		
		// ver 1.2 ends here
		
		// ver 1.3 changes starts here
		map.put("getBdcPendingDetails", "getBdcPendingDetails");//Added for BDC pending check
		// ver 1.3 changes ends
		
		return map;
	}
	
	//method to get account Details....
	   public void getDetails(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	    throws AppException, IOException {
	      	
		    Connection conn = null;	    
 	         PreparedStatement ps = null;
 	         ResultSet rs = null;
	    	String query = request.getParameter("query");	
	    	String inParams = request.getParameter("inParams");
	    	String result="";
	    	ResultSetMetaData rm=null;
	    	DataAccessObject dataAccessObj = new DataAccessObject ();
	    	//  ver 1.1 starts here
	    	String delimiter = (String)request.getParameter("ajaxDelimiter");  
	    	logger.debug("delimiter in ajax action function===>" + delimiter); 
			if(delimiter != null && !delimiter.trim().equals(""))
			{
				this.v_delimiter= delimiter;
				logger.debug("delimiter in AjaxAction--->" + v_delimiter);
			}
			else
			{
				this.v_delimiter = ",";
			}
			logger.debug("inParams=====>" + inParams);
	    	// ver 1.1 ends here
			String strQuery = FetchResource.fetchMessage("resources.queries", query);
	    	
            String[] inputParams = null;
            // ver 1.1 starts 
            if(inParams != null)
            	if(! inParams.trim().equals(""))
            		inputParams= inParams.split(v_delimiter);		// ver 1.1
            	//inputParams= inParams.split(",");	// commented for ver 1.1
            // ver 1.1 ends here
            
       
            List list = new ArrayList();
            try {
            	
            	conn= dataAccessObj.getConnection(Constants.PMS_DATASOURCE);	 
      		   logger.debug("Query in AjaxAction :" + strQuery);  
      		   ps = conn.prepareStatement(strQuery); 
      		   for (int i =0; i< inputParams.length;i++ )
      		   {
      		   ps.setString(i+1, inputParams[i]);
      		   }
      		   rs = ps.executeQuery();
      		   rm = rs.getMetaData();//...
      		   	while (rs.next()) {
      		   	String[] data=new String[rm.getColumnCount()];
    	 			for (int i = 0; i < data.length; i++) {
    					data[i]=rs.getString(i+1);
    				}
    	 			list.add(data);
      		   	}
//      		execute query here... add manager layers later ....
                logger.debug("after executing query.." + list.size());
    	    	
    	    	//here format output....
    	    	String[] strArr ;
    	    	for(int ctr = 0 ; ctr < list.size(); ctr++)
    	    	{
    	    		strArr = (String[])list.get(ctr);
    	    		for(int inCtr = 0 ; inCtr < strArr.length; inCtr++)
    	    		{
    	    			result += strArr[inCtr] + "~";
    	    		}
    	    		result +="!";
    	    	} 
    	    	conn.close();
            } catch (IllegalArgumentException ex) {
            	logger.debug("iae==>" + ex.getMessage());
                ex.printStackTrace();
            }catch(Exception e){
            	logger.debug("exception==>" + e.getMessage());
                e.printStackTrace();
            }

	    	
	    	
	         response.setHeader("Cache-Control", "no-cache");            
	         logger.debug("ajax result" + result);
	         response.getWriter().write(result);
	    }

	/*// ver 1.2 starts here
	   
	   public void getBillingAddr(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	    throws AppException, IOException {
	      	
		    Connection conn = null;	    
 	        PreparedStatement ps = null;
		    String query = request.getParameter("query");	
	    	String inParams = request.getParameter("inParams");
	    	String result=""; 
	    	//  ver 1.1 starts here
	    	String delimiter = (String)request.getParameter("ajaxDelimiter");  
	    	logger.debug("delimiter in ajax action function===>" + delimiter); 
			if(delimiter != null && !delimiter.trim().equals(""))
			{
				this.v_delimiter= delimiter;
				logger.debug("delimiter in AjaxAction--->" + v_delimiter);
			}
			logger.debug("inParams=====>" + inParams);
	    	// ver 1.1 ends here
			String strQuery = FetchResource.fetchMessage("resources.queries", query);
	    	
          String[] inputParams = {inParams};
          // ver 1.1 starts 
        if(inParams != null)
          if(! inParams.trim().equals(""))
          		inputParams= inParams.split(v_delimiter);		// ver 1.1
         
          List list = null;
          try {
          
              logger.debug("query--->" + strQuery);
              conn= getConnection(Constants.PMS_DATASOURCE);	 
    		     
    		   ps = conn.prepareStatement(Query); 
    		   ps.setString(1, sowName); 
    		   rs = ps.executeQuery();
    		   	while (rs.next()) {
    		   	wonNo=Integer.toString((rs.getInt("wonNo")));
    			  wonList.add(wonNo);
    		   	}
             
          } catch (IllegalArgumentException ex) {
          	logger.debug("iae==>" + ex.getMessage());
              ex.printStackTrace();
          }catch(Exception e){
          	logger.debug("exception==>" + e.getMessage());
              e.printStackTrace();
          }

	    	//execute query here... add manager layers later ....
          logger.debug("after executing query.." + list.size());
	    	
	    	//here format output....
	    	String[] strArr ;
	    	for(int ctr = 0 ; ctr < list.size(); ctr++)
	    	{
	    		strArr = (String[])list.get(ctr);
	    		for(int inCtr = 0 ; inCtr < strArr.length; inCtr++)
	    		{
	    			if(strArr[inCtr]==null)
	    				strArr[inCtr]="";
	    			result += strArr[inCtr] + "~";
	    		}
	    		result +="!";
	    	}
	    	
	         response.setHeader("Cache-Control", "no-cache");            
	         logger.debug("ajax result" + result);
	         response.getWriter().write(result);
	    }
	   
	  

		public void validateInmarProducts(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	    throws AppException, IOException {

		    ProdManager productManager=new ProdManager();
		    String[] familyArr =  request.getParameter("familyIds").split("-");	
			String[] productArr = request.getParameter("productIds").split("-");
			String currency = request.getParameter("currency");
			//String billingType = request.getParameter("billingType"); // ver 1.4 - commented
			String inmarsatProducts = "";
			List productDetailList = null ;
			String result="";
			
			String[] attributeArr = request.getParameter("attributes").split(",");// ver 1.5
			String[] usageBasedProductIds = {"1111","1125","1128","1131","1134","1137","1143","1146","1149","1152","1155","1158","1161","1164","1191","1194","1197","1200","1203","1206","1231","1235","1238","1241"}; // ver 1.5
			
			for(int i=0; i<familyArr.length; i++){
				if(familyArr[i].equals("6")){
					// Currency and Billing type validation for INM LRIT Compliance Testing product
					if(productArr[i].equals(Constants.inmLRITProdId) && currency.equals("USD")){
						result = "For INM LRIT Compliance Testing, Currency should be INR"; 
						response.setHeader("Cache-Control", "no-cache");
						logger.debug("ajax result: " + result);
				        response.getWriter().write(result);
				        return;											
					}else if(currency.equals("INR") && !productArr[i].equals(Constants.inmLRITProdId)){
						result = "For INMARSAT Products, Currency should be USD";
						response.setHeader("Cache-Control", "no-cache");
						logger.debug("ajax result: " + result);
				        response.getWriter().write(result);
				        return;
					}
					// for mandating to enter atleast one event source for usage-based products
					else if("F".equals(attributeArr[i])){ // ver 1.5
						if(CommonManager.isProductIdPresent(usageBasedProductIds,""+productArr[i])){// ver 1.5
							result = "Please select Event Source/s for usage-based product";
							response.setHeader("Cache-Control", "no-cache");
							logger.debug("ajax result: " + result);
					        response.getWriter().write(result);
					        return;
						}						
					}
					inmarsatProducts += productArr[i]+",";
				}
			}
			if(!inmarsatProducts.equals(null) && !inmarsatProducts.equals("")){

				ArrayList prodVASList = new ArrayList();
				ArrayList prodTerminalList = new ArrayList();
				ArrayList vasServiceList = new ArrayList();
				ArrayList terminalServiceList = new ArrayList();
				productDetailList =  productManager.getProductDetails(inmarsatProducts);
				Iterator iter = productDetailList.iterator();
				while(iter.hasNext()){
					com.vsnl.corp_pos.model.Product product= (com.vsnl.corp_pos.model.Product)iter.next();
					if(product.getType().equals(Constants.productVAS)){
						if(prodVASList.contains(product.getServiceName())){
							// To ensure INMARSAT Services have only one VAS Component
							result = "There can be only one VAS Component in a Service for INMARSAT";
							response.setHeader("Cache-Control", "no-cache");
							logger.debug("ajax result: " + result);
					        response.getWriter().write(result);
					        return;
						}
						prodVASList.add(product.getServiceName());
						vasServiceList.add(product.getSubServiceName());
					}						
					else if(product.getType().equals(Constants.productTerminal)){
						if(prodTerminalList.contains(product.getServiceName())){
							// To ensure INMARSAT Services have only one Terminal Component
							result = "There can be only one Terminal Component in a Service for INMARSAT";
							response.setHeader("Cache-Control", "no-cache");
							logger.debug("ajax result: " + result);
					        response.getWriter().write(result);
					        return;
						}
						prodTerminalList.add(product.getServiceName());
						terminalServiceList.add(product.getSubServiceName());
					}
				}
				
				

					if(prodVASList.size()>prodTerminalList.size()){// to check if VAS products are greater than Terminal products
						result = "For INMARSAT no of VAS products should be less than or equal to the number of Terminal products";
						response.setHeader("Cache-Control", "no-cache");
						logger.debug("ajax result: " + result);
				        response.getWriter().write(result);
				        return;
					}
					
					for(int i=0; i<vasServiceList.size(); i++){ // to check if for each VAS product the corresponding terminal product is selected
						for(int j=0; j<terminalServiceList.size(); j++ ){
							if(vasServiceList.get(i).equals(terminalServiceList.get(j))){
								terminalServiceList.remove(j);
								break;
							}else if(j==(terminalServiceList.size()-1)){
								result = "Please select a Terminal product for "+ vasServiceList.get(i);
								response.setHeader("Cache-Control", "no-cache");
								logger.debug("ajax result: " + result);
						        response.getWriter().write(result);
								return;
							}
						}
					//logger.debug("ProductDetails/ ServiceName: " + product.getServiceName() + " Type: " + product.getType() + " ProductName: " + product.getProductName() + " ProductId: " + product.getProductId());
				}
			}
			
	   }
	  
	   // ver 1.2 ends here
		
		// ver 1.3 changes starts here
		//Added to check pending BDC count b4 updating customer attributes--Shraddha 
		   public void getBdcPendingDetails(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
		    throws AppException, IOException {
		   
			   String query = request.getParameter("query");
			   String strQuery = FetchResource.fetchMessage("resources.queries", query);
			   String inParam = request.getParameter("inParam");
			   System.out.println("input cust ref is "+inParam);
		    	String result="";
	           System.out.println("query >>>>"+strQuery);
	           try {
	               DataBaseFramework data=new DataBaseFramework();
	               logger.debug("query--->" + strQuery);
	               //list=(ArrayList)data.executeSQLQuery(strQuery,inputParams,false,"valueObject.TestVO","Geneva",attributes);
	               result = data.executeBdcQuery(strQuery, false, Constants.GENEVA_DATASOURCE,inParam);
	           } 
	           catch (IllegalArgumentException ex) {
	           	logger.debug("iae==>" + ex.getMessage());
	               ex.printStackTrace();
	           }
	           catch(Exception e){
	           	logger.debug("exception==>" + e.getMessage());
	               e.printStackTrace();
	           }
	           
	           System.out.println("result of ajax qry "+result);
	           response.setHeader("Cache-Control", "no-cache");            
	           logger.debug("ajax result" + result);
	           response.getWriter().write(result);
		   }
		//BDCPending check ends   
		// ver 1.3 changes ends
*/}
	
	
