package com.vsnl.struts.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


public class SowForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	private String sowName=null;
	private String sowType=null;
	private String preparedBy=null;
	private List programMgrList=null;
	private String programMgr=null;
	private FormFile browseFile=null;
	private String version=null;
	private String amount=null;
	private String status="";
	private String method=null;
	private List milestoneDetailsList=null;
	 private String milestoneId="";
	 private String archiveLevel="";
	 private String sowCreationDate=null;
	 private String activity=null;
	 private String remarks=null;
	 private String option=null;
	 private String user="";
	 private int listSize=0;
	 private String[] selectedItems={};
	 private String approving="";
	 private String itpm="";
	 private String  authoriser="";
	 private List approvingList=null;
	 private List itpmList=null;
	 private List authoriserList=null;
	 private String errorFlag="";
	 private String errorMessage="";
	 private List sowTypeList=null;
     private String filePath=""; 
     private String source="";

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
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
	 * @return the sowTypeList
	 */
	public List getSowTypeList() {
		return sowTypeList;
	}

	/**
	 * @param sowTypeList the sowTypeList to set
	 */
	public void setSowTypeList(List sowTypeList) {
		this.sowTypeList = sowTypeList;
	}

	/**
	 * @return the errorFlag
	 */
	public String getErrorFlag() {
		return errorFlag;
	}

	/**
	 * @param errorFlag the errorFlag to set
	 */
	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the mileStoneDate
	 *//*
	public String getMileStoneDate() {
		return mileStoneDate;
	}

	*//**
	 * @param mileStoneDate the mileStoneDate to set
	 *//*
	public void setMileStoneDate(String mileStoneDate) {
		this.mileStoneDate = mileStoneDate;
	}
*/
	/**
	 * @return the mileStoneRemark
	 *//*
	public String getMileStoneRemark() {
		return mileStoneRemark;
	}

	*//**
	 * @param mileStoneRemark the mileStoneRemark to set
	 *//*
	public void setMileStoneRemark(String mileStoneRemark) {
		this.mileStoneRemark = mileStoneRemark;
	}*/

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
	 * @return the browseFile
	 */
	public FormFile getBrowseFile() {
		return browseFile;
	}

	/**
	 * @param browseFile the browseFile to set
	 */
	public void setBrowseFile(FormFile browseFile) {
		this.browseFile = browseFile;
	}




	/**
	 * @return the listSize
	 */
	public int getListSize() {
		return listSize;
	}

	/**
	 * @param listSize the listSize to set
	 */
	public void setListSize(int listSize) {
		this.listSize = listSize;
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
	 * @return the milestoneAmount
	 *//*
	public String getMilestoneAmount() {
		return milestoneAmount;
	}

	*//**
	 * @param milestoneAmount the milestoneAmount to set
	 *//*
	public void setMilestoneAmount(String milestoneAmount) {
		this.milestoneAmount = milestoneAmount;
	}*/

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
	 * @return the milestoneName
	 *//*
	public String getMilestoneName() {
		return milestoneName;
	}

	*//**
	 * @param milestoneName the milestoneName to set
	 *//*
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}*/

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
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
	 * @return the selectedItems
	 */
	public String[] getSelectedItems() {
		return selectedItems;
	}

	/**
	 * @param selectedItems the selectedItems to set
	 */
	public void setSelectedItems(String[] selectedItems) {
		this.selectedItems = selectedItems;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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

	/**
	 * @return the programMgrList
	 */
	public List getProgramMgrList() {
		return programMgrList;
	}

	/**
	 * @param programMgrList the programMgrList to set
	 */
	public void setProgramMgrList(List programMgrList) {
		this.programMgrList = programMgrList;
	}
	//siba ver starts

	/**
	 * @return the Approving
	 */
	public String getApproving() {
		return approving;
	}

	/**
	 * @param Approving the Approving to set
	 */
	public void setApproving(String Approving) {
		this.approving = Approving;
	}

	/**
	 * @return the ApprovingList
	 */
	public List getApprovingList() {
		return approvingList;
	}

	/**
	 * @param ApprovingList the ApprovingList to set
	 */
	public void setApprovingList(List ApprovingList) {
		this.approvingList = ApprovingList;
	}

	/**
	 * @return the Authoriser
	 */
	public String getAuthoriser() {
		return authoriser;
	}

	/**
	 * @param Authoriser the Authoriser to set
	 */
	public void setAuthoriser(String Authoriser) {
		this.authoriser = Authoriser;
	}

	/**
	 * @return the AuthoriserList
	 */
	public List getAuthoriserList() {
		return authoriserList;
	}

	/**
	 * @param AuthoriserList the AuthoriserList to set
	 */
	public void setAuthoriserList(List AuthoriserList) {
		this.authoriserList = AuthoriserList;
	}


	/**
	 * @return the ITPMList
	 */
	public List getItpmList() {
		return itpmList;
	}

	/**
	 * @param ITPMList the ITPMList to set
	 */
	public void setItpmList(List ITPMList) {
		this.itpmList = ITPMList;
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
	 * @return the milestoneDetailsList
	 */
	public List getMilestoneDetailsList() {
		return milestoneDetailsList;
	}

	/**
	 * @param milestoneDetailsList the milestoneDetailsList to set
	 */
	public void setMilestoneDetailsList(List milestoneDetailsList) {
		this.milestoneDetailsList = milestoneDetailsList;
	}
	
	
	public void reset()
	{
		this.activity="";
		this.amount="";
		this.browseFile=null;
		this.errorFlag="";
		this.errorMessage="";
		this.listSize=0;
		this.preparedBy="";
		this.programMgr="";
		this.remarks="";
		this.sowName="";
		this.version="";
		this.sowCreationDate="";
		this.sowType="";
		this.programMgr="";
		this.approving="";
		this.authoriser="";
		this.filePath="";
		this.status="";
	}

	/**
	 * @return the itpm
	 */
	public String getItpm() {
		return itpm;
	}

	/**
	 * @param itpm the itpm to set
	 */
	public void setItpm(String itpm) {
		this.itpm = itpm;
	}


	
	

	
}	