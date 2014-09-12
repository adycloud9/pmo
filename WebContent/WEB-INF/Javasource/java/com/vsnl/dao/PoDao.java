/** 
 * Name: PoDao.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
 * 08/09/2010 Soumya Singhai  1.0      Created the file
 * ======================================================================================== 
 * </pre> 
 * 
  

 **/
package com.vsnl.dao;

import java.sql.*;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;


import com.vsnl.model.PoAdd;
import com.vsnl.util.Constants;

import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;

public class PoDao extends DataAccessObject{
	   
    private Logger logger = null;
    /**
     
     */
         public PoDao () {
        logger = Logger.getLogger(PoDao .class);
        logger.debug("In PoDao");
    }	
        /* public String addPo(PoAdd po)throws AppException
         {
         
          String returnMsg = "Success"; 	 
          Connection conn = null;	    
   	      ResultSet rs = null;
   	      CallableStatement cStmt=null;
   	      try
              {  	    	 
     		  conn= getConnection(Constants.PMS_DATASOURCE); 
     		  cStmt = conn.prepareCall("{call PoAdd(?,?,?,?,?,?,?,?,?)}"); 
     		   
     		  cStmt.setString(1,po.getSowName());
     		  cStmt.setString(2,po.getWonNo());
     		  cStmt.setString(3,po.getPoNo());
     		  cStmt.setString(4,po.getUser());
            
     		 java.sql.Date startDate = null;
     		 java.sql.Date endDate = null;
     		 java.sql.Date date = null;
     		
     		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
			 
     		 java.util.Date sdt = formatter.parse(po.getPoStartDate());
			 startDate = new java.sql.Date(sdt.getTime());
			  logger.debug("Start date is " +startDate);
			  
			 java.util.Date edt = formatter.parse(po.getPoEndDate());
			 endDate = new java.sql.Date(edt.getTime());
     		   logger.debug("end date is " +endDate);
     		   
			 java.util.Date dt = formatter.parse(po.getPoDate());
			 date = new java.sql.Date(dt.getTime()); 
     		 logger.debug("PO date is " +date);
     		 
			 cStmt.setDate(5, startDate);
     	     cStmt.setDate(6,endDate);
     		 cStmt.setDate(7,date);
     	       	         	     
     		 cStmt.execute();
     		  
     		cStmt.getString(8);
      	    logger.debug("Error Msg is : " +cStmt.getString(8));
      	     cStmt.getString(9);
      	    logger.debug("Error Flag is : " +cStmt.getString(9));
     		 
      	    if ("F".equalsIgnoreCase(cStmt.getString(9))){
      	    	returnMsg = cStmt.getString(8);
      	    }
      	   
              } catch(SQLException sqle)
              {
                  ExceptionHandler.handleException("PoDao.addPo.SQLException", sqle);
              }
              catch(Exception e)
              {
                  ExceptionHandler.handleException("PoDao.addPo.Exception", e);
              }
              finally
              {
                  cleanUp(conn,cStmt, rs);
              } 
              return returnMsg;
         }
         public String editPo(PoAdd po)throws AppException
         {
        	 String returnMsg = "Success";
        	 Connection conn = null;	    
   	         ResultSet rs = null;
   	         CallableStatement cStmt=null;
   	      try
              {
     	    	 
     		  conn= getConnection(Constants.PMS_DATASOURCE);	 
     		       
     		     
     		   cStmt = conn.prepareCall("{call PoEdit(?,?,?,?,?,?,?,?,?)}"); 
     		   
     		   cStmt.setString(1,po.getSowName());
     		   cStmt.setString(2,po.getWonNo());
     		   cStmt.setString(3,po.getPoNo());
     		   cStmt.setString(4,po.getUser());
     			 java.sql.Date startDate = null;
         		 java.sql.Date endDate = null;
         		 java.sql.Date date = null;
         		
         		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
    			 
         		 java.util.Date sdt = formatter.parse(po.getPoStartDate());
    			 startDate = new java.sql.Date(sdt.getTime());
    			  logger.debug("Start date is " +startDate);
    			  
    			 java.util.Date edt = formatter.parse(po.getPoEndDate());
    			 endDate = new java.sql.Date(edt.getTime());
         		   logger.debug("end date is " +endDate);
         		   
    			 java.util.Date dt = formatter.parse(po.getPoDate());
    			 date = new java.sql.Date(dt.getTime()); 
         		 logger.debug("PO date is " +date);
         		 
    			 cStmt.setDate(5, startDate);
         	     cStmt.setDate(6,endDate);
         		 cStmt.setDate(7,date);
     		                
     		   cStmt.execute();
     		  
       		    cStmt.getString(8);
        	    logger.debug("Error Msg is : " +cStmt.getString(8));
        	    cStmt.getString(9);
        	   logger.debug("Error Flag is : " +cStmt.getString(9));
               
        	   if ("F".equalsIgnoreCase(cStmt.getString(9))){
         	    	returnMsg = cStmt.getString(8);
         	    }
              }
   	         catch(SQLException sqle)
              {
                  ExceptionHandler.handleException("PoDao.editPo.SQLException", sqle);
              }
              catch(Exception e)
              {
                  ExceptionHandler.handleException("PoDao.editPo.Exception", e);
              }
              finally
              {
                  cleanUp(conn,cStmt, rs);
              }
             return  returnMsg;
         }
          */
   public String addEditPo(PoAdd po)throws AppException
         {
        	 String returnMsg = "Success";
        	 Connection conn = null;	    
   	         ResultSet rs = null;
   	         CallableStatement cStmt=null;
   	      try
              {
     	    	 
     		   conn= getConnection(Constants.PMS_DATASOURCE);	 
     		     		     
     		   cStmt = conn.prepareCall("{call create_edit_Po(?,?,?,?,?,?,?,?,?,?,?)}"); 
     		   
     		   cStmt.setString(1,po.getSowName());
     		   cStmt.setString(2,po.getWonNo());
     		   cStmt.setString(3,po.getPoNo());
     		 
     		   java.sql.Date startDate = null;
         	   java.sql.Date endDate = null;
         	   java.sql.Date date = null;
         	   SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
    			 
         	   java.util.Date sdt = formatter.parse(po.getPoStartDate());
    		   startDate = new java.sql.Date(sdt.getTime());
    		   logger.debug("Start date is " +startDate);
    			  
    		   java.util.Date edt = formatter.parse(po.getPoEndDate());
    		   endDate = new java.sql.Date(edt.getTime());
         	   logger.debug("end date is " +endDate);
         		   
    		   java.util.Date dt = formatter.parse(po.getPoDate());
    		   date = new java.sql.Date(dt.getTime()); 
         	   logger.debug("PO date is " +date);
         		 
    			cStmt.setDate(4, startDate);
         	    cStmt.setDate(5,endDate);
         		cStmt.setDate(6,date);
         		cStmt.setString(7,po.getUser());     
         		cStmt.setString(8,po.getAddEditFlag());   
         		cStmt.setString(9,po.getFilePath());  
     		      cStmt.execute();
     		    cStmt.getString(10);
        	    logger.debug("Error Msg is : " +cStmt.getString(10));
        	    cStmt.getString(11);
        	   logger.debug("Error Flag is : " +cStmt.getString(11));
               
        	  if ("F".equalsIgnoreCase(cStmt.getString(11))){
         	    	returnMsg = cStmt.getString(10);
         	    }
              }
   	         catch(SQLException sqle)
              {
                  ExceptionHandler.handleException("PoDao.editPo.SQLException", sqle);
                  returnMsg = "Failed";
              }
              catch(Exception e)
              {
                  ExceptionHandler.handleException("PoDao.editPo.Exception", e);
                  returnMsg = "Failed";
              }
              finally
              {
                  cleanUp(conn,cStmt, rs);
              }
             return  returnMsg;
         }
     

     
}
