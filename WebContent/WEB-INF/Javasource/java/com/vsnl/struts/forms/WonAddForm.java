package com.vsnl.struts.forms;



import java.util.List;//added by Anindita

import org.apache.struts.action.ActionForm;


public class WonAddForm extends ActionForm{
	
	/**
	 * 
	 */
    
	private static final long serialVersionUID = 1L;
	//ver anindita starts here
	private String sowName="";
	private String wonNo="";
	private String method="";
	private String user="";
	private String result="";
	private String errorFlag = "";
	private String errorMessage = "";
	private String source = "";
	private List wonList = null;
	private String newWonNo="";;
	
	
	/**
	 * This function is used to reset fields
	 *
	 */
	public void reset() {
		this.errorFlag="";
		this.errorMessage="";
		this.sowName="";
		this.wonNo="";
		this.user="";
		this.wonList=null;
		this.newWonNo="";
	}
	//ver anindita ends here
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getSowName() {
		return sowName;
	}

	public void setSowName(String sowName) {
		this.sowName = sowName;
	}

	public String getWonNo() {
		return wonNo;
	}

	public void setWonNo(String wonNo) {
		this.wonNo = wonNo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	//ver anindita starts here
	public String getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public List getWonList() {
		return wonList;
	}

	public void setWonList(List wonList) {
		this.wonList = wonList;
	}
	
	public String getNewWonNo() {
		return newWonNo;
	}

	public void setNewWonNo(String newWonNo) {
		this.newWonNo = newWonNo;
	}
	//ver anindita ends here

	
}