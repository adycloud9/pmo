package com.vsnl.dao;


import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;
import com.vsnl.model.ReportEntity;







public class ReportDao extends DataAccessObject{

	private Logger logger = null;
    
        public ReportDao () {
        logger = Logger.getLogger(ReportDao .class);
        logger.debug("In ReportDao");
    }	
        public List getSearchList(String query,String[] inputs,String mode) throws AppException
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
        					ReportEntity reportEntity=new ReportEntity();
        					String[] uploadArray = (String[])returnList.get(i);
        					//if(mode.equalsIgnoreCase("po"))
        					if(mode.equalsIgnoreCase("SOW without PO"))
        					{
        						reportEntity.setSowName(uploadArray[1]);		
            					reportEntity.setPreparedBy(uploadArray[2]);
        					}
        					//if(mode.equalsIgnoreCase("won")) 
        					if(mode.equalsIgnoreCase("SOW without WON"))
        					{
        					   reportEntity.setSowName(uploadArray[1]);		
           					reportEntity.setPreparedBy(uploadArray[2]);
        					}
        					//if(mode.equalsIgnoreCase("withoutWCR")) 
        					if(mode.equalsIgnoreCase("Milestones without WCR"))
        					{
	        					reportEntity.setSowName(uploadArray[0]);		
	           					reportEntity.setSowCreationDate(uploadArray[1]);
	           					reportEntity.setPreparedBy(uploadArray[2]);		
	        					reportEntity.setMileStoneName(uploadArray[3]);
	        					reportEntity.setMileStoneDate(uploadArray[4]);		
	        					reportEntity.setMileStoneAmt(uploadArray[5]);
        					}
        					//if(mode.equalsIgnoreCase("withWCR"))
        					if(mode.equalsIgnoreCase("Milestones with WCR which are unbilled"))
       						{
	        					reportEntity.setSowName(uploadArray[0]);		
	           					reportEntity.setSowCreationDate(uploadArray[1]);	
	           					reportEntity.setWonNum(uploadArray[2]);
	           					reportEntity.setPoNum(uploadArray[3]);
	        					reportEntity.setMileStoneName(uploadArray[4]);
	        					reportEntity.setMileStoneAmt(uploadArray[5]);
	        					reportEntity.setPreparedBy(uploadArray[6]);	
	        					reportEntity.setWcr_ref(uploadArray[7]);	
       						}
        					statusList.add(reportEntity);
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

        
        
        
}