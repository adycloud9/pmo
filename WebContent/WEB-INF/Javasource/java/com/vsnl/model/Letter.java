package com.vsnl.model;

import java.io.Serializable;

public class Letter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3981060986666765565L;
	
	private String letterTitle = null;
	private String sentCount = null;
	private String letterStatus = null;
	private String copfId= null; 
	private String completionDate =null;
	private String startDate =null;
	private String taskType =null;
	private String taskId=null;
	private String status =null;
	private String taskGroup  =null;
	private String content = null;
	private String email = null;
	private String srNo = null;
	private String menuId = null;
	private String menuTitle = null;
	private String menuurl = null;
	private String menuCode=null;
	private String subject=null;
	private String recname=null;
	
	/**
	 * @return Returns the content.
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return Returns the letterStatus.
	 */
	public String getLetterStatus() {
		return letterStatus;
	}
	/**
	 * @param letterStatus The letterStatus to set.
	 */
	public void setLetterStatus(String letterStatus) {
		this.letterStatus = letterStatus;
	}
	/**
	 * @return Returns the letterTitle.
	 */
	public String getLetterTitle() {
		return letterTitle;
	}
	/**
	 * @param letterTitle The letterTitle to set.
	 */
	public void setLetterTitle(String letterTitle) {
		this.letterTitle = letterTitle;
	}
	/**
	 * @return Returns the sentCount.
	 */
	public String getSentCount() {
		return sentCount;
	}
	/**
	 * @param sentCount The sentCount to set.
	 */
	public void setSentCount(String sentCount) {
		this.sentCount = sentCount;
	}
	/**
	 * @return Returns the completionDate.
	 */
	public String getCompletionDate() {
		return completionDate;
	}
	/**
	 * @param completionDate The completionDate to set.
	 */
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
	/**
	 * @return Returns the copfId.
	 */
	public String getCopfId() {
		return copfId;
	}
	/**
	 * @param copfId The copfId to set.
	 */
	public void setCopfId(String copfId) {
		this.copfId = copfId;
	}
	/**
	 * @return Returns the startDate.
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return Returns the taskGroup.
	 */
	public String getTaskGroup() {
		return taskGroup;
	}
	/**
	 * @param taskGroup The taskGroup to set.
	 */
	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}
	/**
	 * @return Returns the taskId.
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId The taskId to set.
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return Returns the taskType.
	 */
	public String getTaskType() {
		return taskType;
	}
	/**
	 * @param taskType The taskType to set.
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return Returns the srNo.
	 */
	public String getSrNo() {
		return srNo;
	}
	/**
	 * @param srNo The srNo to set.
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	/**
	 * @return Returns the menuId.
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId The menuId to set.
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return Returns the menuTitle.
	 */
	public String getMenuTitle() {
		return menuTitle;
	}
	/**
	 * @param menuTitle The menuTitle to set.
	 */
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	/**
	 * @return Returns the menuurl.
	 */
	public String getMenuurl() {
		return menuurl;
	}
	/**
	 * @param menuurl The menuurl to set.
	 */
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	/**
	 * @return Returns the menuCode.
	 */
	public String getMenuCode() {
		return menuCode;
	}
	/**
	 * @param menuCode The menuCode to set.
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	/**
	 * @return Returns the subject.
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return Returns the recname.
	 */
	public String getRecname() {
		return recname;
	}
	/**
	 * @param recname The recname to set.
	 */
	public void setRecname(String recname) {
		this.recname = recname;
	}
	
	
}