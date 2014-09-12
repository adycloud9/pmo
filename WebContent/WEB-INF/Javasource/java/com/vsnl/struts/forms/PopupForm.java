/** 
 * This class is a part of code for Generic Popup.  
 * This class has the attributes required for display and processing.
 * 
 * Name: ValueSet.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
 * 09/08/2010 Soumya Singahi   1.0     Created the file
 *  ======================================================================================== 
 * </pre> 
 * 
  

 **/

package com.vsnl.struts.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class PopupForm extends ActionForm{

	private String qid = null;
	private String paramList = null;
	private String targetFields = null;
	private List resultList = null;
	private String[] headerList = null;
	private String method = null;
	private String postSelFunc = null;
	//version 1.2 starts here
	private String tableFlag=null;
	private String rowValue=null;
	private String cellValue=null;
	private String tableValue=null;
//	version 1.2 ends here
	/**
	 * @return the headerList
	 */
	public String[] getHeaderList() {
		return headerList;
	}
	/**
	 * @param headerList the headerList to set
	 */
	public void setHeaderList(String[] headerList) {
		this.headerList = headerList;
	}
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @return the paramList
	 */
	public String getParamList() {
		return paramList;
	}
	/**
	 * @param paramList the paramList to set
	 */
	public void setParamList(String paramList) {
		this.paramList = paramList;
	}
	/**
	 * @return the qid
	 */
	public String getQid() {
		return qid;
	}
	/**
	 * @param qid the qid to set
	 */
	public void setQid(String qid) {
		this.qid = qid;
	}
	/**
	 * @return the resultList
	 */
	public List getResultList() {
		return resultList;
	}
	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	/**
	 * @return the targetFields
	 */
	public String getTargetFields() {
		return targetFields;
	}
	/**
	 * @param targetFields the targetFields to set
	 */
	public void setTargetFields(String targetFields) {
		this.targetFields = targetFields;
	}
	/**
	 * @return the postSelFunc
	 */
	public String getPostSelFunc() {
		return postSelFunc;
	}
	/**
	 * @param postSelFunc the postSelFunc to set
	 */
	public void setPostSelFunc(String postSelFunc) {
		this.postSelFunc = postSelFunc;
	}
	
	//version 1.2 starts here
	public String getCellValue() {
		return cellValue;
	}
	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}
	public String getRowValue() {
		return rowValue;
	}
	public void setRowValue(String rowValue) {
		this.rowValue = rowValue;
	}
	public String getTableFlag() {
		return tableFlag;
	}
	public void setTableFlag(String tableFlag) {
		this.tableFlag = tableFlag;
	}
	public String getTableValue() {
		return tableValue;
	}
	public void setTableValue(String tableValue) {
		this.tableValue = tableValue;
	}
	//version 1.2 ends here
		
	
	
}
