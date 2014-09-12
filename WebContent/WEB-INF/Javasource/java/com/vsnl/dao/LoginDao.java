package com.vsnl.dao;

import java.sql.*;


import org.apache.log4j.Logger;


import com.vsnl.model.Login;
import com.vsnl.util.Constants;
import com.vsnl.util.FetchResource;

import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;

public class LoginDao extends DataAccessObject{
	   
	    private Logger logger = null;
	    /**
	     * Deafault Constructor for BillDAO 
	     */
	    public LoginDao () {
	        logger = Logger.getLogger(LoginDao .class);
	        logger.debug("In LoginDao");
	    }	

	    public int checkPassword(Login credential)throws AppException
	    {
	    	 Connection conn = null;	    
	         
	         CallableStatement cStmt=null;
	         
	         int out=0;
	         
	         try
             {
	 		    conn= getConnection(Constants.PMS_DATASOURCE);
	 		    cStmt = conn.prepareCall("{call checkEmp(?,?,?)}");
	 		    cStmt.setString(1,credential.getEmpId()); 
	            cStmt.setString(2,credential.getPassword()); 
	            cStmt.registerOutParameter(3,java.sql.Types.INTEGER);
	            cStmt.executeUpdate();
	            out=cStmt.getInt(3);
	         }
	         catch(SQLException sqle)
             {
                 ExceptionHandler.handleException("LoginDao.checkPassword.SQLException", sqle);
             }
             catch(Exception e)
             {
                 ExceptionHandler.handleException("LoginDao.checkPassword.Exception", e);
             }
             finally
             {
                 cleanUp(conn, cStmt);
             }
             return out;
             
   }
	    public String changePassword(Login login)throws AppException
	    {
	    		
	    	Connection conn = null;	    
	        CallableStatement cStmt=null;
	        String msg = Constants.successIndicator;
	               
	         try
                {
				    conn= getConnection(Constants.PMS_DATASOURCE);		   													
				    cStmt = conn.prepareCall("{call change_Pwd(?,?,?,?,?,?)}");	    
		          
				    cStmt.setString(1,login.getEmpId()); 
		            cStmt.setString(2,login.getPassword()); 
		            cStmt.setString(3,login.getNewPassword1());
		            cStmt.setString(4,login.getNewPassword2()); 
		           
		            cStmt.execute();
		            
		            cStmt.getString(5);
		            logger.debug("Error Msg is : " +cStmt.getString(5));
		            cStmt.getString(6);
		            logger.debug("Error Flag is : " +cStmt.getString(6));
		                             	
	         	    msg = cStmt.getString(5);
	         	  
	             }
		         catch(SQLException sqle)
	             {
	                 ExceptionHandler.handleException("LoginDao.ChangePassword.SQLException", sqle);
	             }
	             catch(Exception e)
	             {
	                 ExceptionHandler.handleException("LoginDao.ChangePassword.Exception", e);
	             }
	             finally
	             {
	                 cleanUp(conn,cStmt);
	             }
	          return msg;
	    }
	    public  int getDataByQuery(String key,String inParams) throws AppException
		{
			 Connection conn = null;	    
	         PreparedStatement pstmt = null;
	         
	         int rows=0;
	         try
	          {
	        	conn =getConnection(Constants.PMS_DATASOURCE);
	        	String query=FetchResource.fetchMessage("resources.queries", key);
		 		pstmt = conn.prepareStatement(query);
		 		System.out.println("Query-->"+query);
		 		//setting the input parameter
		 		System.out.println("Input parameters---->"+inParams);
		 		if(inParams!=null)
		 		{
		 			
		 				pstmt.setString(1, inParams);
		 				
					}
		 		
		 		 rows = pstmt.executeUpdate();
		 	 System.out.println("Rows-->"+rows);
		 		//setting the output parameter
		 		
	          }
	         catch(Exception e)
	         {
	             ExceptionHandler.handleException("ResetPassword.getDataByQuery.Exception", e);
	         }
	        
	         return rows;
		}

}