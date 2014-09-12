/*
 * Created on Jul 7, 2005
 *
*/
package com.vsnl.exception;

/**
 * @author 142482
 *
*/
public class AppException extends Exception implements VSNLException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6291768004863351318L;

	/**
     * 
     */
    public AppException() {
        super();

    }

    /**
     * @param aMessage
     */
    public AppException(String aMessage) {
        super(aMessage);

    }

    /**
     * @param aCause
     */
    public AppException(Throwable aCause) {
        super(aCause.getMessage());

    }

    /**
     * @param aMessage
     * @param aCause
     */
    public AppException(String aMessage, Throwable aCause) {
        super(aMessage);

    }

}
