package com.vsnl.manager;

import java.util.List;//added By Anindita

import org.apache.log4j.Logger;

import com.vsnl.model.WonAdd;
import com.vsnl.struts.forms.WonAddForm;
import com.vsnl.exception.AppException;
import com.vsnl.dao.WonDao;

public class WonManager {
Logger logger = null;
	
	/**
	 * Default Constructor
	 */
	public WonManager() {
		logger = Logger.getLogger(WonManager.class);
	}
	//ver Anindita starts here
	public List addWon( WonAddForm wonForm )throws AppException
	{
		WonDao wonDao=new WonDao();
		List returnList=wonDao.addWon(wonForm);
		return returnList;
		
	}
	
	public List editWon(WonAddForm wonForm)throws AppException
	{
		WonDao wonDao=new WonDao();
		List returnList=wonDao.editWon(wonForm);
		return returnList;
		
	}
	//ver Anindita ends here
	public List deleteWon( String sowName,String wonNo,String user)throws AppException
	{
		WonDao wonDao=new WonDao();
		List returnList=wonDao.deleteWon(sowName,wonNo,user);
		return returnList;
		
	}
		
	

}
