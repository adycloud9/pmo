/** 
 * This class is a part of code for Generic Popup. Queries for the popup's maybe in a 
 * properties file OR maybe be passed as a request attribute from other beans. 
 *  
 * 
 * Name: ValueSet.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
 * 17/11/2008 Sangeeth		  1.1		Created the page	
 * 25/02/2010 Rashmi Batra	  1.2       Changes done for ROAR CR( Location Change in BDC)	
 * ======================================================================================== 
 * </pre> 
 * 
  

 **/

package com.vsnl.manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vsnl.dao.DataAccessObject;
import com.vsnl.util.Constants;
import com.vsnl.util.FetchResource;

import org.apache.log4j.Logger;//added for ver 1.2

public class PopupManager {
	private String delimiter = ",";	// ver 1.2
	private Logger logger = Logger.getLogger(PopupManager.class);//ver 1.2 created logger object 
	public PopupManager()
	{
		
		
	}	
	// ver 1.2 starts here
	public PopupManager(String delimiter)
	{
		if(delimiter != null && !delimiter.trim().equals(""))
		{
			this.delimiter = delimiter;
			logger.debug("delimiter in popupManager--->" + delimiter);
		}
	}
	// ver 1.2 ends here
	
	public Object executeQuery(String qid, String paramList)throws IOException
	{
			
		 Connection conn = null;	    
	     PreparedStatement ps = null;
	     ResultSet rs = null;
       	ResultSetMetaData rm=null;
    	DataAccessObject dataAccessObj = new DataAccessObject ();
		System.out.println("qid==>" + qid);
		String query = FetchResource.fetchMessage("resources.popupQueries", qid + ".query");
		System.out.println("query to be executed--->" + query);
		logger.debug("inputParams==>"  + paramList);	
		String[] inputParams = null;
		logger.debug("delimiter value===>" + delimiter);
		inputParams= paramList.split(delimiter);		
		// ver 1.2 ends here
	
        
        List list = new ArrayList();
        try {

           conn= dataAccessObj.getConnection(Constants.PMS_DATASOURCE);	 
   		   logger.debug("Query in AjaxAction :" + query);  
   		   ps = conn.prepareStatement(query); 
   		   for (int i =0; i< inputParams.length;i++ )
   		   {
   		   ps.setString(i+1, inputParams[i]);
   		   }
   		   rs = ps.executeQuery();
   		   rm = rs.getMetaData();
   		   	while (rs.next()) {
   		   	String[] data=new String[rm.getColumnCount()];
 	 			for (int i = 0; i < data.length; i++) {
 					data[i]=rs.getString(i+1);
 				}
 	 			list.add(data);
   		   	}
        
        } catch (IllegalArgumentException ex) {
        	System.out.println("IllegalArgumentException==>" + ex.getMessage());
            ex.printStackTrace();
        }catch(Exception e){
        	System.out.println("Exception==>" + e.getMessage());
            e.printStackTrace();
            
        }finally {
        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		return list;
	}
	
	/*public Object executeQuery(String query)throws IOException
	{
		PreparedStatement ps =null;
		ResultSet rs = null;
        List list = new ArrayList();
        Connection conn = null;	    
        try {
        	DataBaseFramework data=new DataBaseFramework();
            list=(ArrayList)DataBaseFramework.executeSQLQuery(query, false, "Geneva");  // ver 1.2 added DataBaseFramework

        } catch (IllegalArgumentException ex) {
        	System.out.println("IllegalArgumentException==>" + ex.getMessage());
            ex.printStackTrace();
        }catch(Exception e){
        	System.out.println("Exception==>" + e.getMessage());
            e.printStackTrace();
        }
		
		return list;
	}*/
	
	public Object getHeaderList(String queryId)throws IOException
	{
		//get header from propfile given the query Id
		String headerList = FetchResource.fetchMessage("resources.popupQueries", queryId + ".headers");
		return headerList.split(",");
	}
	
}
