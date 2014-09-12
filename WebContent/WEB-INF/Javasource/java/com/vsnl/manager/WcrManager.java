package com.vsnl.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.vsnl.model.WcrAdd;

import com.vsnl.dao.CommonDao;
import com.vsnl.dao.WcrDao;


public class WcrManager {
	
Logger logger = null;
	
	/**
	 * Default Constructor
	 */
	public WcrManager() {
		logger = Logger.getLogger(WcrManager.class);
	}
	
	
	public List getMilestones(WcrAdd wcrAdd,String wcrKey,String milestoneKey,String approverKey) throws Exception {
		WcrDao wcrDao =new WcrDao();
		CommonManager commonManager=new CommonManager();
		List returnList=new ArrayList();
		List milestoneEntityList=new ArrayList();
		List wcrEntityList=new ArrayList();
		List approverEntityList=new ArrayList();
			System.out.println("Inside WCR Manager");
			if("C".equalsIgnoreCase(wcrAdd.getFlowFlag())){
				returnList=wcrDao.getMileStoneDetails(wcrAdd);
			} 
			else 
			{
				List resultList=wcrDao.getMileStoneDetailsForEdit(wcrAdd,wcrKey,milestoneKey,approverKey);
				if(resultList!=null && resultList.size()!=0)
				{
					WcrAdd wcrAdd2=null;
					List milestoneDetailsList=(ArrayList)resultList.get(1);
					if(milestoneDetailsList!=null && milestoneDetailsList.size()!=0)
					{
						int milestonelistSize=milestoneDetailsList.size();
						for (int i = 0; i < milestonelistSize; i++) 
						{
							wcrAdd2=new WcrAdd();
							String milestoneRow[]=(String[])milestoneDetailsList.get(i);
							if (milestoneRow[0].equalsIgnoreCase("null")) {
								wcrAdd2.setWcrRefId(0);
							}
							else
							{
								wcrAdd2.setWcrRefId(Integer.parseInt(milestoneRow[0]));
							}
							wcrAdd2.setMilestoneName(milestoneRow[2]);
							wcrAdd2.setMilestoneAmnt(milestoneRow[3]);
							wcrAdd2.setDisplayAmount(commonManager.amtWithComma(milestoneRow[3]));
							wcrAdd2.setMilestoneRemark(milestoneRow[4]);
							wcrAdd2.setMileStoneDate(milestoneRow[5]);
							wcrAdd2.setBillFlag(milestoneRow[6]);
							milestoneEntityList.add(wcrAdd2);
						}
					}
					List wcrDetailsList=(ArrayList)resultList.get(0);
					if(wcrDetailsList!=null && wcrDetailsList.size()!=0)
					{
						int wcrDetailsListSize=wcrDetailsList.size();
						for (int i = 0; i < wcrDetailsListSize; i++) 
						{
							wcrAdd2=new WcrAdd();
							String wcrRow[]=(String[])wcrDetailsList.get(i);
							if (wcrRow[0].equalsIgnoreCase("null")) {
								wcrAdd2.setWcrRefId(0);
							}
							else
							{
								wcrAdd2.setWcrRefId(Integer.parseInt(wcrRow[0]));
							}
							wcrAdd2.setWcrRefCount(wcrRow[1]);
							wcrEntityList.add(wcrAdd2);
						}
					}
					
					List approverDetailsList=(ArrayList)resultList.get(2);
					String approverRow[]=null;
					if(approverDetailsList!=null && approverDetailsList.size()!=0)
					{
							int listSize=approverDetailsList.size();
							wcrAdd2=new WcrAdd();
							approverRow=(String[])approverDetailsList.get(0);
							wcrAdd2.setPreparedBy(approverRow[0]);
							wcrAdd2.setPrepByDesig(approverRow[1]);
							if (listSize>1 )
							{
								approverRow=(String[])approverDetailsList.get(1);
								wcrAdd2.setApprovedBy(approverRow[0]);
								wcrAdd2.setAppByDesig(approverRow[1]);
							}
							if (listSize>2 ) {
								approverRow=(String[])approverDetailsList.get(2);
								wcrAdd2.setAuthorisedBy(approverRow[0]);
								wcrAdd2.setAuthByDesig(approverRow[1]);
							}
							approverEntityList.add(wcrAdd2);
								
					}
							
				}
				returnList.add(wcrEntityList);
				returnList.add(milestoneEntityList);
				returnList.add(approverEntityList);
			}
			return returnList;
		}
		
	
	public WcrAdd getPersonDetails(WcrAdd wcrAdd) throws Exception {
		  
		    WcrDao wcrDao =new WcrDao();
		  
			System.out.println("Inside WCR Manager");
			if("C".equalsIgnoreCase(wcrAdd.getFlowFlag())){
				  wcrAdd=wcrDao.getPersonDetails(wcrAdd);
			} 
			else
			{
				  wcrAdd=wcrDao.getPersonDetailsForEdit(wcrAdd);
			}
		return wcrAdd;
	}
	
	public String submitWCR(WcrAdd wcrAdd) throws Exception {
		
		String returnMsg ="Success";
	    WcrDao wcrDao =new WcrDao();
	    List inputParamsList=new ArrayList();
		String milestoneName="";
		String wipStatus="";
		String selectedIndex="";
		
		
		inputParamsList.add(wcrAdd.getSowName());
		inputParamsList.add(wcrAdd.getWonNo());
		inputParamsList.add(wcrAdd.getPoNo());
	    
		selectedIndex=wcrAdd.getSelectedIndex();
		List dataList=(ArrayList)wcrAdd.getMilestoneDtlsList();
		WcrAdd wcrAdd2=null;
		int count =0;
		if(dataList != null && dataList.size()>0){
			count=dataList.size();
		}
		
		if(!selectedIndex.equalsIgnoreCase(","))
		{
			for (int i = 0; i < count; i++) 
			{
				if(selectedIndex.indexOf(","+i+",")!= -1)
				{
					wcrAdd2=(WcrAdd)dataList.get(i);
					milestoneName+=wcrAdd2.getMilestoneName()+";";
					wipStatus+="WIP"+";";
				}
			}
		}
		else
		{
			for (int i = 0; i < count; i++) 
			{
				wcrAdd2=(WcrAdd)dataList.get(i);
				milestoneName+=";";
			}
		}
		
		inputParamsList.add(milestoneName);
		System.out.println("MileStoneName::==>"+milestoneName);
		if (wcrAdd.getFlowFlag().equalsIgnoreCase("C")) {
			inputParamsList.add("WIP");
		}
		else {
			inputParamsList.add(wipStatus);
		}
		inputParamsList.add(wcrAdd.getToDate());
		inputParamsList.add(wcrAdd.getFromDate());
		inputParamsList.add(wcrAdd.getPreparedBy());
		System.out.println("wcrAdd.getPreparedBy()==>"+wcrAdd.getPreparedBy());
		inputParamsList.add(wcrAdd.getApprovedBy());
		System.out.println("wcrAdd.getApprovedBy()==>"+wcrAdd.getApprovedBy());
		inputParamsList.add(wcrAdd.getAuthorisedBy());
		System.out.println("wcrAdd.getAuthorisedBy()==>"+wcrAdd.getAuthorisedBy());
		inputParamsList.add(wcrAdd.getFlowFlag());
		inputParamsList.add(wcrAdd.getBusinessUnit());
		inputParamsList.add(Integer.toString(wcrAdd.getWcrRefId()));
		//inputParamsList.add(wcrAdd.getWcrSelected());
		System.out.println("RadioSelected-->"+wcrAdd.getWcrRefId());
		inputParamsList.add(wcrAdd.getUser());
		inputParamsList.add(";");
		String inParams[]=(String [])inputParamsList.toArray(new String[inputParamsList.size()]);
		returnMsg= wcrDao.submitWCR(inParams);
	    logger.debug("returnMsg in manager "+ returnMsg);
	
	return returnMsg;
}
	


public int getWcrId()throws Exception {
	
	 WcrDao wcrDao =new WcrDao();
	 int wcrId =0;
	 
	 wcrId=wcrDao.getWCRId();
	 
	 return wcrId;
}
	 
public List getWcrDetails(WcrAdd wcr,String flag )throws Exception {
	
	 WcrDao wcrDao =new WcrDao();
	 List resultList =new ArrayList();
	 
	 if("S".equalsIgnoreCase(flag)){
		 resultList=wcrDao.getWcrDetailsOnSowName(wcr); 
	 } else if("SW".equalsIgnoreCase(flag)){
		 resultList=wcrDao.getWcrDetailsOnSowWon(wcr); 
	 }else {
		 resultList=wcrDao.getWcrDetailsOnSowWonPo(wcr);
	 }
	 return resultList;
}
public List getMilestoneDtlsForPrvw(WcrAdd wcr)throws Exception {
	
	 WcrDao wcrDao =new WcrDao();
	 List resultList =new ArrayList();
	 
	
	 resultList=wcrDao.getWcrDetailsForPreview(wcr); 
	
	 return resultList;
}

public int[] setBilledWcr(String key,List dataList)throws Exception {
	
	CommonDao dao=new CommonDao();
	 String sowName="",wcrRefId="",invoiceNumber="";
	 WcrAdd wcrAdd=null;
	 for (int i = 0; i < dataList.size(); i++) {
		 wcrAdd=new WcrAdd();
		 wcrAdd=(WcrAdd)dataList.get(i);
		 sowName+=wcrAdd.getSowName()+",";
		 wcrRefId+=wcrAdd.getWcrRefId()+",";
		 invoiceNumber+=wcrAdd.getInvoiceNumber()+",";
	}
	String sowNameList[]=sowName.split(",");
	String wcrRefIdlist[]=wcrRefId.split(",");
	String invoiceNumberList[]=invoiceNumber.split(",");
	int updateCount[]=dao.executeBatchStatement(key,sowNameList,wcrRefIdlist,invoiceNumberList);
	return updateCount;
}


}
