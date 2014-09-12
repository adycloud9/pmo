package com.vsnl.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.vsnl.manager.CommonManager;
import com.vsnl.model.WcrAdd;
import com.vsnl.util.Constants;
import com.vsnl.util.FetchResource;
import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;

public class WcrDao extends DataAccessObject{
	   
    private Logger logger = null;
    /**
     * 
     */
    public WcrDao () {
    	
        logger = Logger.getLogger(WcrDao .class);
        logger.debug("In WcrDao");
    }	

    
    public List getMileStoneDetails(WcrAdd wcr)throws Exception
    {
    	  Connection conn = null;	    
	      ResultSet rs = null;
	      PreparedStatement pstmt=null;
	      String query ="";
	      List resultList = new ArrayList();
	      CommonManager commonManager=new CommonManager();
	     
	      try
           {
	    	
	    	  query =FetchResource.fetchMessage("resources.queries", "WCR.getWcrDetails");	  	    	 
	  		  conn= getConnection(Constants.PMS_DATASOURCE);
	  		 
	  		  pstmt = conn.prepareStatement(query);
	  		  System.out.println("wcr.getSowName()1 ====>"+wcr.getSowName());
	  		  System.out.println("wcr.getPoNo()2 ====>"+wcr.getPoNo());
	  		  System.out.println("wcr.getWcrRefId()3 ====>"+wcr.getWcrRefId());
	  	
	  		  pstmt.setString(1,wcr.getSowName());
	  	 	  pstmt.setString(2,wcr.getSowName());
	  	 	  pstmt.setString(3,wcr.getPoNo());
	  	 	 pstmt.setString(4,wcr.getSowName());
	  	 	  pstmt.setString(5,wcr.getSowName());
	  	 	  pstmt.setString(6,wcr.getSowName());
	  	 	  pstmt.setString(7,wcr.getPoNo());
	  	 	 pstmt.setString(8,wcr.getSowName());
	  	 	  pstmt.setString(9,wcr.getSowName());
	  	 	  pstmt.setString(10,wcr.getSowName());
	  	 	  pstmt.setString(11,wcr.getSowName());
	  	 	  pstmt.setString(12,wcr.getPoNo());
	  	 	  pstmt.setString(13,wcr.getSowName());
	  	 	  pstmt.setString(14,wcr.getSowName());
	  	 	  
			  rs = pstmt.executeQuery();
			  WcrAdd wr=null;
			  int i=0;
			  while (rs.next()){
				  i++;
				  System.out.println("i executed time"+i);
				  wr=new WcrAdd();
				 
				  wr.setMilestoneName((rs.getString("mileStoneName")));
				  System.out.println("setMilestoneName===>"+wr.getMilestoneName() );
				  
				  wr.setMilestoneAmnt((rs.getString("mileStoneAmount")));
				  wr.setDisplayAmount(commonManager.amtWithComma(rs.getString("mileStoneAmount")));
				  System.out.println("setMilestoneAmnt===>"+wr.getMilestoneAmnt() );
				  
				  wr.setMilestoneRemark((rs.getString("milestoneRemark")));
				  System.out.println("setMilestoneRemark==>"+wr.getMilestoneRemark() );
				  
				  wr.setMileStoneDate(rs.getString("milestoneDt"));
				  System.out.println("setMileStoneDate===>"+wr.getMileStoneDate() );
				  
                  wr.setBillStatus(rs.getString("bill_status"));
                  wr.setBillFlag(rs.getString("bill_status"));
                  System.out.println("setBillStatus===>"+wr.getBillStatus());
                  if(rs.getString("invoiceNumber").equalsIgnoreCase("null"))
                  {
                	  wr.setInvoiceNumber("");
                  }
                  else
                  {
                	  wr.setInvoiceNumber(rs.getString("invoiceNumber")); 
                  }
                  System.out.println("setInvoivceNumber===>"+wr.getInvoiceNumber());
				  resultList.add(wr);	
                  }
			  System.out.println("Result List ==>"+resultList.size());
           } catch(SQLException sqle)
           {
        	   System.out.println("Inside WCR Dao 2");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.SQLException", sqle);
               
           }
           catch(Exception e)
           {
        	   System.out.println("Inside WCR Dao 3");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.Exception", e);
               throw e;
           }
           finally
           {
               cleanUp(conn,pstmt,rs);
           }
           return resultList;
    }
  
    public WcrAdd getPersonDetails(WcrAdd wcr )throws AppException
 	{
 		     Connection conn = null;	    
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         String query=null;
	         String authority [] = new String [3];
	         String designation [] = new String [3];
	         int i = 0;
	          try
	          {
		      
		        	query =FetchResource.fetchMessage("resources.queries", "WCR.getAuthAndDesignation");	   	 
			 		conn = getConnection(Constants.PMS_DATASOURCE);
			 		pstmt = conn.prepareStatement(query);
			 		pstmt.setString(1,wcr.getSowName());
			 		pstmt.setString(2,wcr.getSowName());
			 		pstmt.setString(3,wcr.getSowName());
			 		pstmt.setString(4,wcr.getSowName());
			 		pstmt.setString(5,wcr.getSowName());
		 		
		 		rs = pstmt.executeQuery();
		 		
		 		while(rs.next())
		 		{
		 			
		 			authority [i]=(rs.getString("Authority"));
		 			designation[i]=(rs.getString("designation"));
		 			i++;
		 		 
		 		 }  
			 		wcr.setPreparedBy(authority [0]);
			 		wcr.setApprovedBy(authority [1]);
			 	    wcr.setAuthorisedBy(authority[2]);
			 	    wcr.setPrepByDesig(designation[0]);
		 	        wcr.setAppByDesig(designation[1]);
		 	        wcr.setAuthByDesig(designation[2]);
			 	    
		     }
	        catch(SQLException sqle)
	        {
	        	ExceptionHandler.handleException("WcrDao.getPersonDetails.SQLException", sqle);
	        }
	        catch(Exception e)
	        {
	        	ExceptionHandler.handleException("WcrDao.getPersonDetails.Exception", e);
	        }
	        finally
	        {
	        	cleanUp(conn, pstmt, rs);
	        }
         return wcr;
      }
    public WcrAdd getPersonDetailsForEdit(WcrAdd wcr )throws AppException
 	{
 		     Connection conn = null;	    
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         String query=null;
	         String authority [] = new String [3];
	         String designation [] = new String [3];
	         int i = 0;
	          try
	          {
		        	query =FetchResource.fetchMessage("resources.queries", "WCR.getAuthAndDesignationForEdit");	   	 
			 		conn = getConnection(Constants.PMS_DATASOURCE);
			 		pstmt = conn.prepareStatement(query);
			 		pstmt.setInt(1,wcr.getWcrRefId());
			 		pstmt.setInt(2,wcr.getWcrRefId());
			 		pstmt.setInt(3,wcr.getWcrRefId());
			 		pstmt.setInt(4,wcr.getWcrRefId());
			 		pstmt.setInt(5,wcr.getWcrRefId());
	        	
		 		
		 		rs = pstmt.executeQuery();
		 		
		 		while(rs.next())
		 		{
		 			
		 			authority [i]=(rs.getString("prepared_By"));
		 			designation[i]=(rs.getString("designation"));
		 			i++;
		 		 
		 		 }  
			 		wcr.setPreparedBy(authority [0]);
			 		wcr.setApprovedBy(authority [1]);
			 	    wcr.setAuthorisedBy(authority[2]);
			 	    wcr.setPrepByDesig(designation[0]);
		 	        wcr.setAppByDesig(designation[1]);
		 	        wcr.setAuthByDesig(designation[2]);
			 	    
		     }
	        catch(SQLException sqle)
	        {
	        	ExceptionHandler.handleException("WcrDao.getPersonDetails.SQLException", sqle);
	        }
	        catch(Exception e)
	        {
	        	ExceptionHandler.handleException("WcrDao.getPersonDetails.Exception", e);
	        }
	        finally
	        {
	        	cleanUp(conn, pstmt, rs);
	        }
         return wcr;
      }
    
    public String submitWCR(String [] inputParamsList)throws AppException
    {
	   	 String returnMsg = "Success";
	   	 Connection conn = null;	    
	     ResultSet rs = null;
	     CallableStatement cStmt=null;
	      try
         {
	    	 
		   conn= getConnection(Constants.PMS_DATASOURCE);	 
		     		     
		   cStmt = conn.prepareCall("{call create_edit_Wcr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); 
		   System.out.println("Input Parameters");
		   for (int i = 0; i < inputParamsList.length; i++) {
			   System.out.println("InParams["+(i+1)+"]-->"+inputParamsList[i]);
		}
		   
		   cStmt.setString(1,inputParamsList[0]);
		   cStmt.setString(2,inputParamsList[1]);
		   cStmt.setString(3,inputParamsList[2]);
		   cStmt.setString(4,inputParamsList[3]);
		   cStmt.setString(5,inputParamsList[4]);
		   
		   java.sql.Date fromDate = null;
	  	   java.sql.Date toDate = null;
	 	   
	 	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
			 
	 	   java.util.Date fdt = formatter.parse(inputParamsList[5]);
	 	   fromDate = new java.sql.Date(fdt.getTime());
		   logger.debug("From date is " +fromDate);
			  
		   java.util.Date tdt = formatter.parse(inputParamsList[6]);
		   toDate = new java.sql.Date(tdt.getTime());
	 	   logger.debug("To date is " +toDate);
		   
		   cStmt.setDate(6,toDate);
		   cStmt.setDate(7,fromDate);
		   
		   cStmt.setString(8,inputParamsList[7]);
		   cStmt.setString(9,inputParamsList[8]);
		   cStmt.setString(10,inputParamsList[9]);
		   cStmt.setString(11,inputParamsList[10]);
		   cStmt.setString(12,inputParamsList[11]);
		   cStmt.setInt(13,Integer.parseInt(inputParamsList[12]));
		   System.out.println("REF ID in DAO==>" + Integer.parseInt(inputParamsList[12]));
		   cStmt.setString(14,inputParamsList[13]);
		   cStmt.setString(15,inputParamsList[14]);		  
		   cStmt.execute();
		   
		   cStmt.getString(16);
		   logger.debug("Return Msg ==>" +cStmt.getString(16));
		   cStmt.getString(17);
		   logger.debug("Return Flag ==>" +   cStmt.getString(17));
		
			   returnMsg = cStmt.getString(16);
		
		   
         }
	         catch(SQLException sqle)
         {
             ExceptionHandler.handleException("wcrDao.submitWCR.SQLException", sqle);
             returnMsg = "Failed";
         }
         catch(Exception e)
         {
             ExceptionHandler.handleException("wcrDao.submitWCR.Exception", e);
             returnMsg = "Failed";
         }
         finally
         {
             cleanUp(conn,cStmt, rs);
         }
        return  returnMsg;
    }
    
    public int getWCRId()throws AppException
    {
	   	 int wcrId = 0;
	   	 Connection conn = null;	    
	     ResultSet rs = null;
	     PreparedStatement ps =null;
	     String query=null;
	      try
         {
		       query =FetchResource.fetchMessage("resources.queries", "WCR.generateWcrID");	 
			   conn= getConnection(Constants.PMS_DATASOURCE);	 
			   ps = conn.prepareStatement(query); 		     
			   rs = ps.executeQuery();
			   
			   while (rs.next()){
				   wcrId =rs.getInt("m"); 
			   }
			   
         } catch(SQLException sqle)
         {
             ExceptionHandler.handleException("wcrDao.submitWCR.SQLException", sqle);
             
         }
         catch(Exception e)
         {
             ExceptionHandler.handleException("wcrDao.submitWCR.Exception", e);
            
         }
         finally
         {
             cleanUp(conn,ps, rs);
         }
        return  wcrId;
    }
    /*
     * 
     */
    public List getMileStoneDetailsForEdit(WcrAdd wcr,String wcrKey,String milestoneKey,String approverKey)throws Exception
    {
	      List resultList = new ArrayList();
	      CommonDao commonDao=new CommonDao();
	      try
           {
	    	  //key =FetchResource.fetchMessage("resources.queries", "WCR.getWcrDetailsForEdit");	
	    	  String milestoneInparams[]={wcr.getSowName(),wcr.getSowName(),wcr.getPoNo(),wcr.getSowName(),wcr.getSowName(),wcr.getSowName(),wcr.getPoNo(),wcr.getSowName(),wcr.getSowName()};
	    	  String wcrInparams[]={wcr.getSowName(),wcr.getSowName(),wcr.getPoNo(),wcr.getSowName(),wcr.getSowName(),wcr.getSowName(),wcr.getPoNo(),wcr.getSowName(),wcr.getSowName()};
	    	  String approverInparams[]={wcr.getSowName(),wcr.getSowName(),wcr.getSowName(),wcr.getSowName(),wcr.getSowName()};
	  		  List milestoneDetailsList=commonDao.getDatafromDbByQuery(milestoneKey, milestoneInparams);
	  		  List refIdDetailsList=commonDao.getDatafromDbByQuery(wcrKey, wcrInparams);
	  		  List approverDetailsList=commonDao.getDatafromDbByQuery(approverKey, approverInparams);
	  		  resultList.add(milestoneDetailsList);
	          resultList.add(refIdDetailsList);
	          resultList.add(approverDetailsList);
           } 
           catch(Exception e)
           {
        	  logger.debug(e.getMessage());
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.Exception", e);
           }
           return resultList;
    }
    
    public List getWcrDetailsOnSowName(WcrAdd wcr)throws Exception
    {
    	  Connection conn = null;	    
	      ResultSet rs = null;
	      PreparedStatement pstmt=null;
	      String query ="";
	      List resultList = new ArrayList();
	     
	      try
           {
	    	  logger.debug("Inside getWcrDetailsOnSowName");
	    	  query =FetchResource.fetchMessage("resources.queries", "WCR.getWcrDetails_sow");	  	    	 
	  		  conn= getConnection(Constants.PMS_DATASOURCE);
	  		 
	  		  pstmt = conn.prepareStatement(query);
	  		  System.out.println("wcr.getSowName()1 ====>"+wcr.getSowName());
	  	
	  		 for (int i =1; i<=4; i++){
	  			pstmt.setString(i,wcr.getSowName());
	  		 }
			  rs = pstmt.executeQuery();
			  WcrAdd wr=null;
			  while (rs.next()){
				
				  wr=new WcrAdd();
				  wr.setSowName((rs.getString("sowName")));
				  System.out.println("setSowName===>"+wr.getSowName() );
				  
				  wr.setWonNo((rs.getString("wonNo")));
				  System.out.println("setWonNo===>"+wr.getWonNo() );
				  
				  wr.setPoNo((rs.getString("poNo")));
				  System.out.println("setPoNo==>"+wr.getPoNo() );
				  
				  wr.setWcrRefId(rs.getInt("refid"));
				  System.out.println("setWcrRefId===>"+wr.getWcrRefId() );
				  
				  resultList.add(wr);	
                  }
			  System.out.println("Result List ==>"+resultList.size());
           } catch(SQLException sqle)
           {
        	   System.out.println("Inside WCR Dao 2");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.SQLException", sqle);
               
           }
           catch(Exception e)
           {
        	   System.out.println("Inside WCR Dao 3");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.Exception", e);
               throw e;
           }
           finally
           {
               cleanUp(conn,pstmt,rs);
           }
           return resultList;
    }
    public List getWcrDetailsOnSowWon(WcrAdd wcr)throws Exception
    {
    	  Connection conn = null;	    
	      ResultSet rs = null;
	      PreparedStatement pstmt=null;
	      String query ="";
	      List resultList = new ArrayList();
	     
	      try
           {
	    	  logger.debug("Inside getWcrDetailsOnSowWon");
	    	  query =FetchResource.fetchMessage("resources.queries", "WCR.getWcrDetails_sowWon");	  	    	 
	  		  conn= getConnection(Constants.PMS_DATASOURCE);
	  		 
	  		  pstmt = conn.prepareStatement(query);
	  		  System.out.println("wcr.getSowName() ====>"+wcr.getSowName());
	  		  System.out.println("wcr.getWonNo() ====>"+wcr.getWonNo());
	  		 
	  		  pstmt.setString(1,wcr.getSowName());
	  	 	  pstmt.setString(2,wcr.getWonNo());
	  	 	  pstmt.setString(3,wcr.getSowName());
	  	 	  pstmt.setString(4,wcr.getSowName());
	  	 	  pstmt.setString(5,wcr.getSowName());
			  rs = pstmt.executeQuery();
			  WcrAdd wr=null;
			  while (rs.next()){
				
				  wr=new WcrAdd();
				  wr.setSowName((rs.getString("sowName")));
				  System.out.println("setSowName===>"+wr.getSowName() );
				  
				  wr.setWonNo((rs.getString("wonNo")));
				  System.out.println("setWonNo===>"+wr.getWonNo() );
				  
				  wr.setPoNo((rs.getString("poNo")));
				  System.out.println("setPoNo==>"+wr.getPoNo() );
				  
				  wr.setWcrRefId(rs.getInt("refid"));
				  System.out.println("setWcrRefId===>"+wr.getWcrRefId() );
				  
				  resultList.add(wr);	
                  }
			  System.out.println("Result List ==>"+resultList.size());
           } catch(SQLException sqle)
           {
        	   System.out.println("Inside WCR Dao 2");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.SQLException", sqle);
               
           }
           catch(Exception e)
           {
        	   System.out.println("Inside WCR Dao 3");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.Exception", e);
               throw e;
           }
           finally
           {
               cleanUp(conn,pstmt,rs);
           }
           return resultList;
    }
    public List getWcrDetailsOnSowWonPo(WcrAdd wcr)throws Exception
    {
    	  Connection conn = null;	    
	      ResultSet rs = null;
	      PreparedStatement pstmt=null;
	      String query ="";
	      List resultList = new ArrayList();
	     
	      String inVmode= wcr.getInvoiceMode();
	      String buttonFlag= wcr.getButtonFlag();
	      try
           {
	    	  logger.debug("Inside getWcrDetailsOnSowWon");
	    	 if(inVmode.equalsIgnoreCase("Billed")){
	    		 
	    	 if(buttonFlag.equalsIgnoreCase("Add")){
	    	 query =FetchResource.fetchMessage("resources.queries", "WCR.getWcrDetails_sowWonPoForInvoice");	
	    	 }
	    	 if(buttonFlag.equalsIgnoreCase("Edit")){
	    	 query =FetchResource.fetchMessage("resources.queries", "WCR.getWcrDetails_sowWonPoForEditInvoice");	
	        }
	    	 
	    	 }else{
	    	  query =FetchResource.fetchMessage("resources.queries", "WCR.getWcrDetails_sowWonPo");	
	    	 }
	  		  conn= getConnection(Constants.PMS_DATASOURCE);
	  		 
	  		  pstmt = conn.prepareStatement(query);
	  		  System.out.println("wcr.getSowName() ====>"+wcr.getSowName());
	  		  System.out.println("wcr.getWonNo() ====>"+wcr.getWonNo());
	  		  System.out.println("wcr.getPoNo() ====>"+wcr.getPoNo());
	  		
	  		  		  pstmt.setString(1,wcr.getSowName());
	  		  	 	  pstmt.setString(2,wcr.getWonNo());
	  		  	      pstmt.setString(3,wcr.getSowName());
	  		  	 	  pstmt.setString(4,wcr.getPoNo());
	  		  	 	  pstmt.setString(5,wcr.getSowName());  
	  		  	      pstmt.setString(6,wcr.getSowName());
	  		
	  			  
	  		
			  rs = pstmt.executeQuery();
			  WcrAdd wr=null;
			  while (rs.next()){
				
				  wr=new WcrAdd();
				  
				  
				  if(inVmode.equalsIgnoreCase("Billed"))
				  {
					  wr.setSowName((rs.getString("sowName")));
					  System.out.println("setSowName===>"+wr.getSowName() );
					  
					  wr.setWonNo((rs.getString("wonNo")));
					  System.out.println("setWonNo===>"+wr.getWonNo() );
					  
					  wr.setPoNo((rs.getString("poNo")));
					  System.out.println("setPoNo==>"+wr.getPoNo() );
					  
					  wr.setWcrRefId(rs.getInt("refid"));
					  System.out.println("setWcrRefId===>"+wr.getWcrRefId() );  
					  
					  wr.setInvoiceNumber(rs.getString("invoiceNumber"));
					  System.out.println("setWcrinvoiceNumber===>"+wr.getInvoiceNumber() );  
					  
				  }
				  else
				  {
					  wr.setSowName((rs.getString("sowName")));
					  System.out.println("setSowName===>"+wr.getSowName() );
					  
					  wr.setWonNo((rs.getString("wonNo")));
					  System.out.println("setWonNo===>"+wr.getWonNo() );
					  
					  wr.setPoNo((rs.getString("poNo")));
					  System.out.println("setPoNo==>"+wr.getPoNo() );
					  
					  wr.setWcrRefId(rs.getInt("refid"));
					  System.out.println("setWcrRefId===>"+wr.getWcrRefId() );
					  
				  }
				  resultList.add(wr);	
                  }
			  System.out.println("Result List ==>"+resultList.size());
           } catch(SQLException sqle)
           {
        	   System.out.println("Inside WCR Dao 2");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.SQLException", sqle);
               
           }
           catch(Exception e)
           {
        	   System.out.println("Inside WCR Dao 3");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.Exception", e);
               throw e;
           }
           finally
           {
               cleanUp(conn,pstmt,rs);
           }
           return resultList;
    }
    
    public List getWcrDetailsForPreview(WcrAdd wcr)throws Exception
    {
    	  Connection conn = null;	    
	      ResultSet rs = null;
	      PreparedStatement pstmt=null;
	      String query ="";
	      List resultList = new ArrayList();
	     
	      try
           {
	    	  logger.debug("Inside getWcrDetailsOnSowWon");
	    	  query =FetchResource.fetchMessage("resources.queries", "WCR.getMileStoneDtlsforPreview");	  	    	 
	  		  conn= getConnection(Constants.PMS_DATASOURCE);
	  		 
	  		  pstmt = conn.prepareStatement(query);
	  		  System.out.println("Query==>"+query);
	  		  System.out.println("wcr.getSowName() ====>"+wcr.getSowName());
	  		  System.out.println("wcr.getWonNo() ====>"+wcr.getWonNo());
	  		  System.out.println("wcr.getPoNo() ====>"+wcr.getPoNo());
	  	      System.out.println("wcr.getWcrRefId() ====>"+wcr.getWcrRefId());
	  		  
	  		  pstmt.setString(1,wcr.getSowName());
	  	 	  pstmt.setString(2,wcr.getSowName());
	  	 	  pstmt.setInt(3,wcr.getWcrRefId());
	  	 	  pstmt.setString(4,wcr.getWonNo());
	  	 	  pstmt.setString(5,wcr.getSowName());
	  	 	  pstmt.setString(6,wcr.getPoNo());
	  	 	  pstmt.setString(7,wcr.getSowName());
	  	 	  pstmt.setString(8,wcr.getSowName());
	  	 	  
	  	 	 pstmt.setString(9,wcr.getSowName());
	  	 	 pstmt.setString(10,wcr.getSowName());
	  	 	 pstmt.setInt(11,wcr.getWcrRefId());
	  	 	 pstmt.setString(12,wcr.getWonNo());
	  	 	 pstmt.setString(13,wcr.getSowName());
	  	 	 pstmt.setString(14,wcr.getPoNo());
	  	 	 pstmt.setString(15,wcr.getSowName());
	  	 	 pstmt.setString(16,wcr.getSowName());
	  	 	
	  	 	  
			  rs = pstmt.executeQuery();
			  WcrAdd wr=null;
			  while (rs.next()){
				  wr = new WcrAdd();
				  wr.setMilestoneName((rs.getString("mileStoneName")));
				  System.out.println("setMilestoneName===>"+wr.getMilestoneName() );
				  
				  wr.setMilestoneAmnt((rs.getString("mileStoneAmount")));
				  System.out.println("setMilestoneAmnt===>"+wr.getMilestoneAmnt() );
				  
				  wr.setMilestoneRemark((rs.getString("milestoneRemark")));
				  System.out.println("setMilestoneRemark==>"+wr.getMilestoneRemark() );
				  
				  wr.setMileStoneDate(rs.getString("milestoneDate"));
				  System.out.println("setMileStoneDate===>"+wr.getMileStoneDate() );
				  
                  wr.setBillStatus(rs.getString("bill_status"));
                  wr.setBillFlag(rs.getString("bill_status"));
                  System.out.println("setBillStatus===>"+wr.getBillStatus() );
                  
                  DateFormat fromDate = new SimpleDateFormat("dd-MM-yyyy"); 
                  DateFormat toDate = new SimpleDateFormat("dd-MM-yyyy"); 
                 
                  wr.setFromDate(fromDate.format((rs.getDate("from_date"))));
                  System.out.println("setFromDate===>"+wr.getFromDate() );
                  
                  wr.setToDate(toDate.format((rs.getDate("to_date"))));
                  System.out.println("setToDate===>"+wr.getToDate() );
				  
                  wr.setBillingCheck("true");
                  resultList.add(wr);	
                  }
			  System.out.println("Result List ==>"+resultList.size());
           } catch(SQLException sqle)
           {
        	   System.out.println("Inside WCR Dao 2");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.SQLException", sqle);
               
           }
           catch(Exception e)
           {
        	   System.out.println("Inside WCR Dao 3");
               ExceptionHandler.handleException("WcrDao.getMileStoneDetails.Exception", e);
               throw e;
           }
           finally
           {
               cleanUp(conn,pstmt,rs);
           }
           return resultList;
    }
}
