package com.vsnl.manager;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.vsnl.model.Sow;

import com.vsnl.dao.SowDao;


public class SowManager 
{
Logger logger = null;
	
	/**
	 * Default Constructor
	 */
	public SowManager() {
		
		logger = Logger.getLogger(SowManager.class);
	}
	
	  public List createSOW(Sow sow)throws Exception
	  {
		  SowDao sowDao=new SowDao();
		  List inputParamsList=new ArrayList();
		  String milestoneName="",milestoneAmount="",milestoneRemark="",milestoneDate="";
		 
		  inputParamsList.add(sow.getSowName());
		  inputParamsList.add(sow.getSowCreationDate());
		  inputParamsList.add(sow.getAmount());
		  inputParamsList.add(sow.getVersion());
		  inputParamsList.add(sow.getSowType());
		  inputParamsList.add(sow.getPreparedBy());
		  inputParamsList.add(sow.getProgramMgr());
		  inputParamsList.add(sow.getUser());
		  List dataList=(ArrayList)sow.getMilestoneList();
		  if(dataList!=null && dataList.size()>0)
		  {
			  int listSize= dataList.size();
			  for (int i = 0; i < listSize; i++) 
			  {
				Sow sowEntity=new Sow();
				sowEntity=(Sow)dataList.get(i);
				milestoneName=milestoneName.concat(sowEntity.getMilestoneName()+";");
				milestoneAmount=milestoneAmount.concat(sowEntity.getMilestoneAmount()+";");
				if(!sowEntity.getMilestoneRemark().equalsIgnoreCase(""))
				{
					milestoneRemark=milestoneRemark.concat(sowEntity.getMilestoneRemark()+";");
					
				}
				milestoneDate=milestoneDate.concat(sowEntity.getMilestoneDate()+";");
			 }
		  }
		  inputParamsList.add(milestoneName);
		  inputParamsList.add(milestoneAmount);
		  inputParamsList.add(milestoneRemark);
		  inputParamsList.add(milestoneDate);
		  inputParamsList.add(sow.getRemarks());
		  inputParamsList.add(sow.getActivity());
		  inputParamsList.add(sow.getApproving());
		  inputParamsList.add(sow.getITPM());
		  inputParamsList.add(sow.getAuthoriser());
		  inputParamsList.add(sow.getFilePath());
		  inputParamsList.add(sow.getDelimiter());
		  inputParamsList.add(sow.getActivity());
		  String inParams[]=(String [])inputParamsList.toArray(new String[inputParamsList.size()]);
		  List resultList=sowDao.createSOW(inParams);
		  return resultList;
	  }
	  
}