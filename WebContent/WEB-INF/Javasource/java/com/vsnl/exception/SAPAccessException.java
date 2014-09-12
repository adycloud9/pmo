/*
 * Created on Jul 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.vsnl.exception;

/**
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SAPAccessException extends Exception {
	public String message; 
	
	public SAPAccessException(String message){
		
		this.message=message;
	}
	public String toString(){
		return this.message;
	}
	public String getMessage(){
		return this.message;
	}
	
}
