package com.vsnl.manager;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vsnl.dao.LoginDao;
import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;

import com.vsnl.model.*;
import com.vsnl.util.Constants; //Added by Soumya

public class LoginManager {
Logger logger = null;
	
	/**
	 * Default Constructor
	 */
	public LoginManager() {
		logger = Logger.getLogger(LoginManager.class);
	}
	public int checkPassword(Login l)throws AppException
	{
		LoginDao login=new LoginDao();
		int check;
		check=login.checkPassword(l);
		
		return check;
	}
	
	 
	 //Added by Soumya 
	 public String changePassword(Login login) throws SQLException, AppException{
		 
		 String retrnMsg=Constants.successIndicator;
		 LoginDao loginDao = new LoginDao();
		
		 try{
			 retrnMsg= loginDao.changePassword(login); 
		
		 }catch(Exception e)
         {
             ExceptionHandler.handleException("LoginManager.ChangePassword.Exception", e);
         }
		 return retrnMsg;
		 
	 }
}
