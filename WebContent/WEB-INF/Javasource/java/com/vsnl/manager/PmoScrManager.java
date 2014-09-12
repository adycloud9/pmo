package com.vsnl.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.vsnl.dao.PmoDao;
import com.vsnl.exception.AppException;

import com.vsnl.struts.forms.PmoScrForm;

public class PmoScrManager {
Logger logger = null;
	
	/**
	 * Default Constructor
	 */
	public PmoScrManager() {
		logger = Logger.getLogger(PmoScrManager.class);
	}
	
	public List addUser(PmoScrForm pForm)throws AppException
	{
		PmoDao pmoDao = new PmoDao();
		List returnList=pmoDao.addUser(pForm);
		return returnList;
	}
	
	public List addLUser(PmoScrForm pForm)throws AppException
	{
		PmoDao pmoDao = new PmoDao();
		List returnList=pmoDao.addLUser(pForm);
		return returnList;
	}
	
	public List getSearchList(String query,String[] inputs) throws AppException
	{
		PmoDao pmoDao = new PmoDao();
		List uploadStatusList = pmoDao.getSearchList(query,inputs); 
		return uploadStatusList;
	}
	public List deleteUser(String empId ,String user)throws AppException
	{
		PmoDao pmoDao=new PmoDao();
		List resultList=pmoDao.deleteUser(empId,user);
		return resultList;
	
	}
	public List updateUser(PmoScrForm pForm)throws AppException
	{
		PmoDao pmoDao=new PmoDao();
		List result=pmoDao.updateUser(pForm);
		
		return result;
	}
}