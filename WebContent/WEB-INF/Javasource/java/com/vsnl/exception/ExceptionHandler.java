/** 
 * This class is used to handle errors thrown by various methods.
 * 
 * Name: ExceptionHandler.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
 * 07/07/2005 142482		  1.0		File created
 * 06/11/2008 204393		  1.1		Changes done to rebuild the error handling framework... 
 * ======================================================================================== 
 * </pre> 
 * 
  

 **/



/*
 * Created on Jul 7, 2005
 *
 */
package com.vsnl.exception;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author 142482
 *
 */
public class ExceptionHandler  {

	/**Changed by 204393 for rebuilding the Error handling framework**/
    private static Logger logger = null;	
	
	public ExceptionHandler(){
		logger = Logger.getLogger(ExceptionHandler.class);
		logger.setLevel(Level.FATAL);
	}
	/**
	 * @author 204393
	 * @param className
	 * @param methodName
	 * @param parameters
	 * @param misc
	 * @param exception
	 * @throws IllegalInputParameter
	 * @throws AppException
	 */
    /** The logger will display the Class name and the method name of the error generating code, 
	also the parameter list of that method and some miscellaneous information that may be passed, and the exception...**/
	/*TBD: handle illegal input parameter*/
    public static void handleException(String className, String methodName, String parameters, String misc,Exception exception) throws AppException {//, IllegalInputParameter
    	
    	exception.printStackTrace();
        logger.warn("Class Name: "+className+"Method Name: "+methodName+"Parameter List: "+parameters+"Misc: "+misc, exception);//Contains code generating exception
        
        if (exception instanceof SysException) {
            throw (SysException) exception;
        } else if (exception instanceof AppException) {
            throw (AppException) exception;
//        }else if(exception instanceof IllegalInputParameter){
//        	throw(IllegalInputParameter)exception;
        } 
        	
        
    }
    
    public static void handleException(String code,Exception exception) throws AppException {
    	
        if (exception instanceof SysException) {
            throw (SysException) exception;
        } else if (exception instanceof AppException) {
            throw (AppException) exception;
        } else {
        	exception.printStackTrace();
            logger.error("Exception Code :" + code, exception);
            throw new SysException(code,exception);
        }
    }
}
