package com.vsnl.dao;
import java.sql.*;
import java.util.ArrayList;//added by Anindita
import java.util.List;//added by Anindita

import org.apache.log4j.Logger;


import com.vsnl.model.WonAdd;
import com.vsnl.struts.forms.WonAddForm;
import com.vsnl.util.Constants;

import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;


public class WonDao extends DataAccessObject{
	   
    private Logger logger = null;
    /**
     * 
     */
    public WonDao () {
    	
        logger = Logger.getLogger(WonDao .class);
        logger.debug("In WonDao");
    }	

	//ver Anindita starts here
    public List addWon( WonAddForm wonForm )throws AppException
    {
    	  Connection conn = null;	    
    	  String flag="";
  	      String errorMessage="";
	      ArrayList returnList=new ArrayList();
	      ResultSet rs = null;
	      CallableStatement cStmt=null;
	      try
           {
	  		  conn= getConnection(Constants.PMS_DATASOURCE);	 
	  		  cStmt = conn.prepareCall("{call create_edit_delete_Won(?,?,?,?,?,?)}"); 
	  		   
	  		  cStmt.setString(1,wonForm.getSowName());
	  		  cStmt.setString(2,wonForm.getWonNo());
	  		  cStmt.setString(3,"C");
	  		  cStmt.setString(4,wonForm.getUser());
	  		  
	  		  cStmt.registerOutParameter(5,Types.VARCHAR);
	  		  cStmt.registerOutParameter(6,Types.VARCHAR);
	  		  cStmt.execute();
	  		  
	  		  errorMessage= cStmt.getString(5);
	          flag=cStmt.getString(6);
	          returnList.add(errorMessage);
	          returnList.add(flag);
            
           }
	       catch(SQLException sqle)
           {
               ExceptionHandler.handleException("WonDao.addWon.SQLException", sqle);
           }
           catch(Exception e)
           {
               ExceptionHandler.handleException("WonDao.addWon.Exception", e);
           }
           finally
           {
               cleanUp(conn,cStmt, rs);
           }
           return returnList;
    }
    
    public List editWon(WonAddForm wonForm)throws AppException
    {
    	  Connection conn = null;	    
    	  String flag="";
	      String errorMessage="";
	      ArrayList returnList=new ArrayList();
	      ResultSet rs = null;
	      CallableStatement cStmt=null;
	      try
           {
	  		  conn= getConnection(Constants.PMS_DATASOURCE); 
	  		  cStmt = conn.prepareCall("{call create_edit_delete_Won(?,?,?,?,?,?)}"); 
	  		   
	  		  cStmt.setString(1,wonForm.getSowName());
	  		  cStmt.setString(2,wonForm.getNewWonNo());
	  		  cStmt.setString(3,"E");
	  		  cStmt.setString(4,wonForm.getUser());
	  		  cStmt.registerOutParameter(5,Types.VARCHAR);
	  		  cStmt.registerOutParameter(6,Types.VARCHAR);
	          cStmt.executeUpdate();
	          
	          errorMessage= cStmt.getString(5);
	          flag=cStmt.getString(6);
	          returnList.add(errorMessage);
	          returnList.add(flag);
           }
           catch(SQLException sqle)
           {
               ExceptionHandler.handleException("WonDao.editWon.SQLException", sqle);
           }
           catch(Exception e)
           {
               ExceptionHandler.handleException("WonDao.editWon.Exception", e);
           }
           finally
           {
               cleanUp(conn,cStmt, rs);
           }
           return returnList;
    }
   
 public List deleteWon(String sowName,String wonNo,String user)throws AppException
    {
    	  Connection conn = null;	    
    	  String flag="";
	      String errorMessage="";
	      ArrayList returnList=new ArrayList();
	      ResultSet rs = null;
	      CallableStatement cStmt=null;
	      try
           {
  		  conn= getConnection(Constants.PMS_DATASOURCE); 
  		       
  		     
  		  cStmt = conn.prepareCall("{call create_edit_delete_Won(?,?,?,?,?,?)}"); 
  		   
  		  cStmt.setString(1,""+sowName);
 		  cStmt.setString(2,""+wonNo);
  		  cStmt.setString(3,"D");
  		  cStmt.setString(4,""+user);
  		  cStmt.registerOutParameter(5,Types.VARCHAR);
		  cStmt.registerOutParameter(6,Types.VARCHAR);
          cStmt.executeUpdate();
        
          errorMessage= cStmt.getString(5);
          flag=cStmt.getString(6);
          returnList.add(errorMessage);
          returnList.add(flag);
     
           }
	         catch(SQLException sqle)
           {
               ExceptionHandler.handleException("WonDao.editWon.SQLException", sqle);
           }
           catch(Exception e)
           {
               ExceptionHandler.handleException("WonDao.editWon.Exception", e);
           }
           finally
           {
               cleanUp(conn,cStmt, rs);
           }
           return returnList;
    }
 
 
}
