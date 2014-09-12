package com.vsnl.model;

import java.io.Serializable;

public class WonAdd implements Serializable
{
	
    private static final long serialVersionUID = 1L;
	
    private String sowName=null;
	
	private String wonNo=null;
	
	private String newWonNo=null;//added by Anindita
	
	private String user;
	
	private String result;
	
	private String method=null;

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	//ver Anindita starts here
	public String getNewWonNo() {
		return newWonNo;
	}

	public void setNewWonNo(String newWonNo) {
		this.newWonNo = newWonNo;
	}
	//ver Anindita ends here

}
