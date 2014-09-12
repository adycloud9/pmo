/** 
 * Name: PoManager.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
 * 
 * ======================================================================================== 
 * </pre> 
 * 
  

 **/
package com.vsnl.manager;

import org.apache.log4j.Logger;

import com.vsnl.model.PoAdd;
import com.vsnl.dao.PoDao;
import com.vsnl.exception.AppException;

public class PoManager {
   Logger logger = null;
	
	/**
	 * Default Constructor
	 */
	public PoManager() {
		logger = Logger.getLogger(PoManager.class);
	}
	public String addEditPo(PoAdd po)throws AppException
	{   
		String returnMsg="Success";
		PoDao poDao=new PoDao();
		returnMsg=poDao.addEditPo(po);
		 
		return returnMsg;
	}
	
	/*public String editPo(PoAdd po)throws AppException
	{   
		String returnMsg="Success";
		PoDao poDao=new PoDao();
		returnMsg=poDao.editPo(po);
		return returnMsg;
		
	}*/
	 

	
}
