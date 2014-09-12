/** 
 * 
 * 
 * Name: PoAddForm.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ===================================================================================================== 
 *                            Prior 
 * Date        By              Version  Description 
 * ---------- --------------- -------  ------------------------------------------------------------------ 
 *06/09/2010   Soumya Singhai   1.0     Created the file
 * =========================================================================================================== 
 * </pre> 
 * 
  

 **/
package com.vsnl.struts.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


    public class PoAddForm extends ActionForm{
	
	
    
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
	
	private List poList = null;
	
	private FormFile browse_File=null;
	
	private String filePath="";
	
	private String errorFlag="";
	
	private String errorMessage="";
	

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

//	Added by Soumya
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
	 * @return the poList
	 */
	public List getPoList() {
		return poList;
	}

	/**
	 * @param poList the poList to set
	 */
	public void setPoList(List poList) {
		this.poList = poList;
	}

	public void reset(){
		
		this.poNo="";
		this.sowName="";
		this.poEndDate="";
		this.poStartDate="";
		this.poNo="";
		this.wonNo="";
		this.wonList=null;
		this.poList=null;
		this.poDate="";
		this.msg="";
		this.errorMessage="";
		this.browse_File=null;
		
	}

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

	public FormFile getBrowse_File() {
		return browse_File;
	}

	public void setBrowse_File(FormFile browse_File) {
		this.browse_File = browse_File;
	}

}
    