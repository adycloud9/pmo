package com.vsnl.dao;

import java.sql.*;

import org.apache.log4j.Logger;







import com.vsnl.model.PmoEntity;
import com.vsnl.struts.forms.PmoScrForm;
import com.vsnl.util.Constants;
import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;

public class PmoDao extends DataAccessObject{

	private Logger logger = null;
    
        public PmoDao () {
        logger = Logger.getLogger(PmoDao .class);
        logger.debug("In PmoDao");
    }	
	
        public List addUser(PmoScrForm pForm)throws AppException
        {
         Connection conn = null;	    
         CallableStatement cStmt=null;
         String msg="";
         String flag="";
         List resultList = new ArrayList();
         try
         {
       conn= getConnection(Constants.PMS_DATASOURCE);
       cStmt = conn.prepareCall("{call create_edit_delete_user_excep(?,?,?,?,?,?,?,?,?)}");
       cStmt.setString(1,"C");
       cStmt.setString(2,pForm.getFirstName()); 
       cStmt.setString(3,pForm.getLastName()); 
       cStmt.setString(4,pForm.getEmpId());
       cStmt.setString(5,pForm.getEmail());
       cStmt.setString(6,pForm.getRole());
       cStmt.setString(7,pForm.getUser());
       cStmt.registerOutParameter(8, Types.VARCHAR);
       cStmt.registerOutParameter(9, Types.CHAR);
       cStmt.execute();
       msg=cStmt.getString(8);
       flag=cStmt.getString(9);
       resultList.add(msg);
       resultList.add(flag);
         }
      catch(SQLException sqle)
        {
      ExceptionHandler.handleException("PmoDao.addUser.SQLException", sqle);
        }
      catch(Exception e)
        {
      ExceptionHandler.handleException("PmoDao.addUser.Exception", e);
         }
       finally
        {
         cleanUp(conn,cStmt);
        }
       return resultList;
     }	


      public List deleteUser(String empId,String user)throws AppException
        {
        	 Connection conn = null;	    
             CallableStatement cStmt=null;
             String msg = "";
             String flag = "";
             List resultList = new ArrayList();
             try
             {
	           conn= getConnection(Constants.PMS_DATASOURCE);
	           cStmt = conn.prepareCall("{call create_edit_delete_user_excep(?,?,?,?,?,?,?,?,?)}");
	           cStmt.setString(1,"D");
	           cStmt.setString(2,""); 
	           cStmt.setString(3,""); 
	           cStmt.setString(4,""+empId);
	           cStmt.setString(5,"");
	           cStmt.setString(6,"");
	           cStmt.setString(7,"");
	           cStmt.registerOutParameter(8, Types.VARCHAR);
	           cStmt.registerOutParameter(9, Types.CHAR);
	           cStmt.execute();
	           msg=cStmt.getString(8);
	           flag=cStmt.getString(9);
	           resultList.add(msg);
	           resultList.add(flag);
             }
            catch(SQLException sqle)
            {
                ExceptionHandler.handleException("PmoDao.deleteUser.SQLException", sqle);
            }
            catch(Exception e)
            {
                ExceptionHandler.handleException("PmoDao.deleteUser.Exception", e);
            }
            finally
            {
                cleanUp(conn, cStmt);
            }
            return resultList;
        }
public List getSearchList(String query,String[] inputs) throws AppException
{
	
	List returnList = null;
	
	List statusList = new ArrayList();
	try
	{		
		CommonDao commonDao=new CommonDao();
		returnList= (List)commonDao.getDatafromDbByQuery(query, inputs);
		
		if(returnList!=null && returnList.size()>0)
			{
		
			  
				for(int i=0;i<returnList.size();i++)
				{
					PmoEntity pmoEntity = new PmoEntity();
					String[] uploadArray = (String[])returnList.get(i);
					
					pmoEntity.setEmpId(uploadArray[0]);		
					pmoEntity.setFirstName(uploadArray[1]);
					pmoEntity.setLastName(uploadArray[2]);
					pmoEntity.setEmail(uploadArray[3]);
					pmoEntity.setRole(uploadArray[4]);
					statusList.add(pmoEntity);
				}
			}
		
					
	}
	catch (IllegalArgumentException ex) {
		logger.debug("::getVsnliCustomerDetails :IllegalArgumentException-->" + ex.getMessage());
	    ExceptionHandler.handleException(this.getClass().getName(), "getNormalUserView",  "" , "", ex);
	}catch(Exception e){
		logger.debug("::getVsnliCustomerDetails :Exception-->" + e.getMessage());
		ExceptionHandler.handleException(this.getClass().getName(), "getNormalUserView",  "" , "", e);
	}
	return statusList;
}



public List updateUser(PmoScrForm pForm)throws AppException
{
	 List resultList = new ArrayList();
	 Connection conn = null;	    
     CallableStatement cStmt=null;
     String msg = "";
     String flag = "";
     try
     {
    	 conn= getConnection(Constants.PMS_DATASOURCE);
         cStmt = conn.prepareCall("{call create_edit_delete_user_excep(?,?,?,?,?,?,?,?,?)}");
         cStmt.setString(1,"E");
         cStmt.setString(2,pForm.getFirstName()); 
         cStmt.setString(3,pForm.getLastName()); 
         cStmt.setString(4,pForm.getEmpId());
         cStmt.setString(5,pForm.getEmail());
         cStmt.setString(6,pForm.getRole());
         cStmt.setString(7,pForm.getUser());
         cStmt.registerOutParameter(8, Types.VARCHAR);
         cStmt.registerOutParameter(9, Types.CHAR);
         cStmt.execute();
         msg=cStmt.getString(8);
         flag=cStmt.getString(9);
         resultList.add(msg);
         resultList.add(flag);
     }
    catch(SQLException sqle)
    {
        ExceptionHandler.handleException("PmoDao.updateUser.SQLException", sqle);
    }
    catch(Exception e)
    {
        ExceptionHandler.handleException("PmoDao.updateUser.Exception", e);
    }
    finally
    {
        cleanUp(conn, cStmt);
    }
    return resultList; 
}
	public List addLUser(PmoScrForm pForm)throws AppException
	{
	 Connection conn = null;	    
	 CallableStatement cStmt=null;
	 String msg="";
	 String flag="";
	 List resultList = new ArrayList();
	 try
	 {
	conn= getConnection(Constants.PMS_DATASOURCE);
	cStmt = conn.prepareCall("{ call create_edit_delete_Authority(?,?,?,?,?,?,?)}");
	
	cStmt.setString(1,pForm.getName()); 
	cStmt.setString(2,pForm.getRole());
	cStmt.setString(3,pForm.getDesignation()); 
	cStmt.setString(4,pForm.getUser());
	cStmt.setString(5,"C");
	cStmt.registerOutParameter(6, Types.VARCHAR);
	cStmt.registerOutParameter(7, Types.CHAR);
	cStmt.execute();
	msg=cStmt.getString(6);
	flag=cStmt.getString(7);
	resultList.add(msg);
	resultList.add(flag);
	 }
	catch(SQLException sqle)
	{
	ExceptionHandler.handleException("PmoDao.addUser.SQLException", sqle);
	}
	catch(Exception e)
	{
	ExceptionHandler.handleException("PmoDao.addUser.Exception", e);
	 }
	finally
	{
	 cleanUp(conn,cStmt);
	}
	return resultList;
	}	

}