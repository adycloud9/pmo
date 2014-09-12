/* 
 * 
 ** Name: PoAdd.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                                 Prior 
 * Date       By                   Version  Description 
 * ---------- -------------------- -------  ---------------------------------------------------- 
 *
 * ======================================================================================== 
 * </pre> 
 * 
  
 **/
package com.vsnl.model;

import java.io.Serializable;
import java.util.List;

public class PoAdd implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String sowName=null;
	
	private String wonNo=null;
	
	private String poNo=null;
	
	private String user;
	
	private String method=null;

    private String poStartDate =null;
	
    private String poEndDate =null;
	
    private String poDate =null;
	
    private String msg = null;
	
    private List wonList = null;
    
    private String addEditFlag=null;
    
    private String filePath="";
	 
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the poDate
	 */
	public String getPoDate() {
		return poDate;
	}

	/**
	 * @param poDate the poDate to set
	 */
	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	/**
	 * @return the poEndDate
	 */
	public String getPoEndDate() {
		return poEndDate;
	}

	/**
	 * @param poEndDate the poEndDate to set
	 */
	public void setPoEndDate(String poEndDate) {
		this.poEndDate = poEndDate;
	}

	/**
	 * @return the poStartDate
	 */
	public String getPoStartDate() {
		return poStartDate;
	}

	/**
	 * @param poStartDate the poStartDate to set
	 */
	public void setPoStartDate(String poStartDate) {
		this.poStartDate = poStartDate;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the wonList
	 */
	public List getWonList() {
		return wonList;
	}

	/**
	 * @param wonList the wonList to set
	 */
	public void setWonList(List wonList) {
		this.wonList = wonList;
	}

	/**
	 * @return the addEditFlag
	 */
	public String getAddEditFlag() {
		return addEditFlag;
	}

	/**
	 * @param addEditFlag the addEditFlag to set
	 */
	public void setAddEditFlag(String addEditFlag) {
		this.addEditFlag = addEditFlag;
	}
	

}
