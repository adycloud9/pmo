/** 
 * This Class contains the functionality for parsing the error messages from the properties file
 * 
 * Name: FetchResource.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
 * 30/03/2006 Anshuman			1.0     Made changes to fetch the messages as per the key
 *                                      value pair 
 * ======================================================================================== 
 * </pre> 
 * 
 * @author   Anshuman Upadhyay 
 **/
package com.vsnl.util;


import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

//import com.vsnl.exception.AppException;

/**
 * @author Tata Consultancy Services
 *
 */
public class FetchResource {
	
	/** This method is used to return the message for the Resource bundle and key as passed
	 * as iinput params.
	 * @param resourceBundle
	 * @param key
	 * @return a String containg the message for the key passed.
	 */
	public static String fetchMessage(ResourceBundle resourceBundle,String key){
		String message=null;
		if(resourceBundle!=null && key!=null ){
			message=resourceBundle.getString(key);
		}else{
			message="Resource bundle passed was null";
		}
		return message;
	}
	/**
	 * @param propertiesFileName
	 * @return the resource bundle of the file name passed.
	 */
	private static ResourceBundle getResourceBundle(String propertiesFileName){
		ResourceBundle resourceBundle=null;
		if(propertiesFileName!=null){
			resourceBundle=ResourceBundle.getBundle(propertiesFileName);
		}
		return resourceBundle;
	}
	
	/**
	 * @param propertiesFileName
	 * @param key
	 * @return a String containg the message for the key passed.
	 */
	public static String fetchMessage(String propertiesFileName,String key){
		String errorMessage=null;
		try{
			if(propertiesFileName!=null && key!=null){
				errorMessage=fetchMessage(getResourceBundle(propertiesFileName),key);
			}else{
				errorMessage="No key/properties file name has been passed";
			}
		}catch(java.util.MissingResourceException  mre){
			mre.printStackTrace();
		}/*catch(E){
			
		}*/
		return errorMessage;
	}
	

	/**
	 * This method is used to check the session validity
	 * @param request 
	 */
	public static void checkSession(HttpServletRequest request) {
		request.getSession().setMaxInactiveInterval(3600); 
	}//end of checkSession
	
	
}

