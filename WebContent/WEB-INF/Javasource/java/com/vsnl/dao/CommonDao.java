/*
 ** Name: CommonDao.java
 * <p> 
 * 	
 * 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                          	       Prior 
 * Date       		   By          	  Version  				Description
 * [dd/mm/yyyy] 
 * ------------  -------------------- -------  ---------------------------------------------------- 
 * 05/07/2010      Siba Sahoo           1.0       Created the Page for PMO Screen
 * ======================================================================================== 
 * </pre> 
 * 
  
 **/

package com.vsnl.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import java.sql.ResultSetMetaData;
import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;
import com.vsnl.manager.CommonManager;
import com.vsnl.util.Constants;
import com.vsnl.util.FetchResource;

public class CommonDao extends DataAccessObject{
	
	Logger logger = Logger.getLogger(CommonDao.class);
	public  List getDatafromDbByQuery(String key,String[] inParams) throws AppException
	{
		 Connection conn = null;	    
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         ResultSetMetaData rm=null;
         String query="";
         List dataList = new ArrayList();
         try
          {
        	conn =getConnection(Constants.PMS_DATASOURCE);
        	logger.debug("QueryId->"+key);
        	query=FetchResource.fetchMessage("resources.queries", key);
	 		pstmt = conn.prepareStatement(query);
	 		logger.debug("Query-->"+query);
	 		//setting the input parameter
	 		logger.debug("Input parameters---->");
	 		if(inParams!=null)
	 		{
	 			for (int i = 0; i < inParams.length; i++) {
	 				pstmt.setString(i+1, inParams[i]);
	 				logger.debug("InParams["+(i+1)+"]-->"+inParams[i]);
				}
	 			
	 		}
	 		rs = pstmt.executeQuery();
	 		rm = rs.getMetaData();
	 		logger.debug("Output parameters---->");
	 		//setting the output parameter
	 		while(rs.next())
	 		{
	 			String[] data=new String[rm.getColumnCount()];
	 			for (int i = 0; i < data.length; i++) {
					data[i]=rs.getString(i+1);
					logger.debug("OutParams["+(i+1)+"]-->"+rs.getString(i+1));
				}
	 			dataList.add(data);
	        }
         }catch(SQLException sqle)
         {
             logger.error("CommonDao::getDatafromDbByQuery::error for-->"+query);
        	 ExceptionHandler.handleException("SowDao.getMilestones.SQLException", sqle);
         }
         catch(Exception e)
         {
        	 logger.error("CommonDao::getDatafromDbByQuery::error for-->"+query);
        	 ExceptionHandler.handleException("SowDao.getMilestones.Exception", e);
         }
         finally
         {
        	 cleanUp(conn, pstmt, rs);
         }
         return dataList;
	}
	
	public  int[] executeBatchStatement(String key,String[] sowNameList,String[] wcrRefIdlist,String[] invoiceNumberList) throws AppException
	{
		int updateCount[]=null;
		Connection conn = null;	    
        PreparedStatement pstmt = null;
        String query="";
        try
        {
        	conn =getConnection(Constants.PMS_DATASOURCE);
        	query=FetchResource.fetchMessage("resources.queries", key);
	 		pstmt = conn.prepareStatement(query);
	 		logger.debug("Query-->"+query);
	 		//setting the input parameter
	 		System.out.println("Input parameters---->");
	 		if(sowNameList!=null && wcrRefIdlist!=null && invoiceNumberList!=null)
	 		{
	 			int j=1;	
	 			for (int i = 0; i < sowNameList.length; i++) 
	 				{
 						pstmt.setString(j, invoiceNumberList[i]);
	 					logger.debug("invoiceNumberList["+(i)+"]-->"+invoiceNumberList[i]);
	 					j++;
	 					pstmt.setString(j, sowNameList[i]);
	 					logger.debug("sowNameList["+(i)+"]-->"+sowNameList[i]);
	 					j++;
	 					pstmt.setInt(j,Integer.parseInt(CommonManager.replace((wcrRefIdlist[i]),"", "0")));
	 					logger.debug("wcrRefIdlist["+(i)+"]-->"+wcrRefIdlist[i]);
	 					j=1;
	 					pstmt.addBatch();
	 				} 
	 			updateCount=pstmt.executeBatch();
	 		}
        }catch (Exception e) {
        	logger.error("CommonDao::getDatafromDbByQuery::error for-->"+query);
        	e.printStackTrace();
		}
        return updateCount;
	}
	
}
