/*
 * Created on Jul 7, 2005
 *
 */
package com.vsnl.exception;

/**
 * @author 142482
 *
*/

public class SysException extends RuntimeException implements VSNLException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8632364749031054408L;

	/**
     * 
     */
    public SysException() {
        super();
    }

    /**
     * @param aMessage
     */
    public SysException(String aMessage) {
        super(aMessage);
    }

    /**
     * @param aCause
     */
    public SysException(Throwable aCause) {
        super(aCause.getMessage());
    }

    /**
     * @param aMessage
     * @param aCause
     */
    public SysException(String aMessage, Throwable aCause) {
        super(aCause.getMessage());
    }

}
