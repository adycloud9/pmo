/*
 * Created on Jul 7, 2005
 *
*/
package com.vsnl.exception;

/**
 * @author 142482
 *
*/
public class IllegalInputParameter extends Exception implements VSNLException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6291768004863351318L;

	/**
     * 
     */
    public IllegalInputParameter() {
        super();

    }

    /**
     * @param aMessage
     */
    public IllegalInputParameter(String aMessage) {
        super(aMessage);

    }

    /**
     * @param aCause
     */
    public IllegalInputParameter(Throwable aCause) {
        super(aCause.getMessage());

    }

    /**
     * @param aMessage
     * @param aCause
     */
    public IllegalInputParameter(String aMessage, Throwable aCause) {
        super(aCause.getMessage());

    }

}

