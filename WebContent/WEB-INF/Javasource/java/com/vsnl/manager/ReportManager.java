package com.vsnl.manager;


import java.util.List;

import org.apache.log4j.Logger;


import com.vsnl.dao.ReportDao;
import com.vsnl.exception.AppException;

public class ReportManager {
Logger logger = null;
	
	/**
	 * Default Constructor
	 */
	public ReportManager() {
		logger = Logger.getLogger(ReportManager.class);
	}
	
	public List getSearchList(String query,String[]inputs,String mode) throws AppException
	{
	ReportDao reportDao=new ReportDao();
		List searchList = reportDao.getSearchList(query,inputs,mode); 
		return searchList;
	}
	
	
}