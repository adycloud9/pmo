package com.vsnl.model;

import java.io.Serializable;
import java.util.List;


public class Sow implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	

    private String sowName="";
    private String sowType="";
	private String sowCreationDate="";
	private String preparedBy="";
	private List programMgrNames=null;
	private String version="";
	private String programMgr="";
	private String milestoneRemark="";
	private String milestoneDate="";
	private String approving="";
	private String iTPM="";
	private String  authoriser="";
	private String activityLog="";
	private String filePath="";
	private String amount="";
	private String user="";
    private String milestoneId="";
	private String sowId="";
	private List milestoneList=null;
	private List historyList=null;
	private String milestoneName="";
	private String milestoneAmount="";
	private String archiveLevel="";
	private String activity="";
	private String remarks="";
	private String delimiter="";
	private String billStatus="";
	
	
	/**
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}
	/**
	 * @param activity the activity to set
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	/**
	 * @return the activityLog
	 */
	public String getActivityLog() {
		return activityLog;
	}
	/**
	 * @param activityLog the activityLog to set
	 */
	public void setActivityLog(String activityLog) {
		this.activityLog = activityLog;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the archiveLevel
	 */
	public String getArchiveLevel() {
		return archiveLevel;
	}
	/**
	 * @param archiveLevel the archiveLevel to set
	 */
	public void setArchiveLevel(String archiveLevel) {
		this.archiveLevel = archiveLevel;
	}
	/**
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}
	/**
	 * @param delimiter the delimiter to set
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the historyList
	 */
	public List getHistoryList() {
		return historyList;
	}
	/**
	 * @param historyList the historyList to set
	 */
	public void setHistoryList(List historyList) {
		this.historyList = historyList;
	}
	/**
	 * @return the milestoneAmount
	 */
	public String getMilestoneAmount() {
		return milestoneAmount;
	}
	/**
	 * @param milestoneAmount the milestoneAmount to set
	 */
	public void setMilestoneAmount(String milestoneAmount) {
		this.milestoneAmount = milestoneAmount;
	}
	/**
	 * @return the mileStoneDate
	 */
	public String getMilestoneDate() {
		return milestoneDate;
	}
	/**
	 * @param mileStoneDate the mileStoneDate to set
	 */
	public void setMilestoneDate(String mileStoneDate) {
		this.milestoneDate = mileStoneDate;
	}
	/**
	 * @return the milestoneId
	 */
	public String getMilestoneId() {
		return milestoneId;
	}
	/**
	 * @param milestoneId the milestoneId to set
	 */
	public void setMilestoneId(String milestoneId) {
		this.milestoneId = milestoneId;
	}
	/**
	 * @return the milestoneList
	 */
	public List getMilestoneList() {
		return milestoneList;
	}
	/**
	 * @param milestoneList the milestoneList to set
	 */
	public void setMilestoneList(List milestoneList) {
		this.milestoneList = milestoneList;
	}
	/**
	 * @return the milestoneName
	 */
	public String getMilestoneName() {
		return milestoneName;
	}
	/**
	 * @param milestoneName the milestoneName to set
	 */
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	/**
	 * @return the mileStoneRemark
	 */
	public String getMilestoneRemark() {
		return milestoneRemark;
	}
	/**
	 * @param mileStoneRemark the mileStoneRemark to set
	 */
	public void setMilestoneRemark(String mileStoneRemark) {
		this.milestoneRemark = mileStoneRemark;
	}
	/**
	 * @return the preparedBy
	 */
	public String getPreparedBy() {
		return preparedBy;
	}
	/**
	 * @param preparedBy the preparedBy to set
	 */
	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}
	/**
	 * @return the programMgr
	 */
	public String getProgramMgr() {
		return programMgr;
	}
	/**
	 * @param programMgr the programMgr to set
	 */
	public void setProgramMgr(String programMgr) {
		this.programMgr = programMgr;
	}
	/**
	 * @return the programMgrNames
	 */
	public List getProgramMgrNames() {
		return programMgrNames;
	}
	/**
	 * @param programMgrNames the programMgrNames to set
	 */
	public void setProgramMgrNames(List programMgrNames) {
		this.programMgrNames = programMgrNames;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the sowCreationDate
	 */
	public String getSowCreationDate() {
		return sowCreationDate;
	}
	/**
	 * @param sowCreationDate the sowCreationDate to set
	 */
	public void setSowCreationDate(String sowCreationDate) {
		this.sowCreationDate = sowCreationDate;
	}
	/**
	 * @return the sowId
	 */
	public String getSowId() {
		return sowId;
	}
	/**
	 * @param sowId the sowId to set
	 */
	public void setSowId(String sowId) {
		this.sowId = sowId;
	}
	/**
	 * @return the sowName
	 */
	public String getSowName() {
		return sowName;
	}
	/**
	 * @param sowName the sowName to set
	 */
	public void setSowName(String sowName) {
		this.sowName = sowName;
	}
	/**
	 * @return the sowType
	 */
	public String getSowType() {
		return sowType;
	}
	/**
	 * @param sowType the sowType to set
	 */
	public void setSowType(String sowType) {
		this.sowType = sowType;
	}
	/**
	 * @return the approving
	 */
	public String getApproving() {
		return approving;
	}
	/**
	 * @param approving the approving to set
	 */
	public void setApproving(String approving) {
		this.approving = approving;
	}
	/**
	 * @return the authoriser
	 */
	public String getAuthoriser() {
		return authoriser;
	}
	/**
	 * @param authoriser the authoriser to set
	 */
	public void setAuthoriser(String authoriser) {
		this.authoriser = authoriser;
	}
	/**
	 * @return the iTPM
	 */
	public String getITPM() {
		return iTPM;
	}
	/**
	 * @param iTPM the iTPM to set
	 */
	public void setITPM(String iTPM) {
		this.iTPM = iTPM;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}


	



}
