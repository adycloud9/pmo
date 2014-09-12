/** 
 * 
 * 
 * Name: WcrAdd.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ===================================================================================================== 
 *                            Prior 
 * Date        By              Version     Description 
 * ---------- --------------- -------  ------------------------------------------------------------------ 
 *  
 *  
 * =========================================================================================================== 
 * </pre> 
 * 
  

 **/

package com.vsnl.model;

import java.io.Serializable;
import java.util.List;

public class WcrAdd implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String creationDate=null;
	
	private String endDate=null;
	
	private String sowName=null;
	
	private String wonNo=null;
	
	private String prgMgr=null;
	
	private String poNo=null;
	
	private String it=null;
	
	private String approvedBy=null;
	
	private String authorisedBy=null;
	
	private List programMgrNames=null;
	
	private List ponumbers=null;

	private String user;
	
	private List milestoneDtlsList=null;
	
	private String milestoneName=null;
	
	private String milestoneAmnt=null;
	
	private String milestoneRemark=null;
	
	private String mileStoneDate=null;
	
   private String businessUnit =null;
	
	private List buList = null;
	
	private String billStatus =null;
	
	private List preparedByList=null;
	
    private List approvedByList=null;
	
	private List authorisedByList=null;
	
	private String preparedBy=null;
	
	private String selectedIndex=null;
	
	private String toDate=null;
	
	private String fromDate=null;
	
	private String status=null;
	
	private List billStatusList=null;
	
	private String flowFlag=null;
	
    private String prepByDesig=null;
	
	private String appByDesig=null;
	
	private String authByDesig=null;
	
	private int wcrRefId=0;
	
	private List wcrRefIdList=null;
	
	private String billFlag =null;
	
	private List wcrDetailsList = null;
	
	private String invoiceNumber="";
	
	private String buttonFlag="";
	//ver starts here
	private String billedFlag="";
	private String invoiceMode="";
	private String wcrRefCount="";
	private String wcrSelected="";
	private String displayAmount="";
	//ver ends here
	
//	ver 1.1 starts here
	private String billingCheck="";
	private String milestoneAmtFormatted="";
	
		//ver 1.1 ends here
	
//	ver 1.1 starts here
	public String getMilestoneAmtFormatted() {
		return milestoneAmtFormatted;
	}

	public void setMilestoneAmtFormatted(String milestoneAmtFormatted) {
		this.milestoneAmtFormatted = milestoneAmtFormatted;
	}
	public String getBillingCheck() {
		return billingCheck;
	}

	public void setBillingCheck(String billingCheck) {
		this.billingCheck = billingCheck;
	}
//ver 1.1 starts here

	public String getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(String selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getAuthorisedBy() {
		return authorisedBy;
	}

	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPrgMgr() {
		return prgMgr;
	}

	public void setPrgMgr(String prgMgr) {
		this.prgMgr = prgMgr;
	}

	public String getSowName() {
		return sowName;
	}

	public void setSowName(String sowName) {
		this.sowName = sowName;
	}

	public String getIt() {
		return it;
	}

	public void setIt(String it) {
		this.it = it;
	}

	public String getWonNo() {
		return wonNo;
	}

	public void setWonNo(String wonNo) {
		this.wonNo = wonNo;
	}

	public List getProgramMgrNames() {
		return programMgrNames;
	}

	public void setProgramMgrNames(List programMgrNames) {
		this.programMgrNames = programMgrNames;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public List getPonumbers() {
		return ponumbers;
	}

	public void setPonumbers(List ponumbers) {
		this.ponumbers = ponumbers;
	}

	public List getMilestoneDtlsList() {
		return milestoneDtlsList;
	}

	public void setMilestoneDtlsList(List milestoneDtlsList) {
		this.milestoneDtlsList = milestoneDtlsList;
	}

	public String getMilestoneAmnt() {
		return milestoneAmnt;
	}

	public void setMilestoneAmnt(String milestoneAmnt) {
		this.milestoneAmnt = milestoneAmnt;
	}

	public String getMileStoneDate() {
		return mileStoneDate;
	}

	public void setMileStoneDate(String mileStoneDate) {
		this.mileStoneDate = mileStoneDate;
	}

	public String getMilestoneName() {
		return milestoneName;
	}

	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}

	public String getMilestoneRemark() {
		return milestoneRemark;
	}

	public void setMilestoneRemark(String milestoneRemark) {
		this.milestoneRemark = milestoneRemark;
	}

	public List getApprovedByList() {
		return approvedByList;
	}

	public void setApprovedByList(List approvedByList) {
		this.approvedByList = approvedByList;
	}

	public List getAuthorisedByList() {
		return authorisedByList;
	}

	public void setAuthorisedByList(List authorisedByList) {
		this.authorisedByList = authorisedByList;
	}

	public List getBuList() {
		return buList;
	}

	public void setBuList(List buList) {
		this.buList = buList;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public List getPreparedByList() {
		return preparedByList;
	}

	public void setPreparedByList(List preparedByList) {
		this.preparedByList = preparedByList;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public List getBillStatusList() {
		return billStatusList;
	}

	public void setBillStatusList(List billStatusList) {
		this.billStatusList = billStatusList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlowFlag() {
		return flowFlag;
	}

	public void setFlowFlag(String flowFlag) {
		this.flowFlag = flowFlag;
	}

	public String getAppByDesig() {
		return appByDesig;
	}

	public void setAppByDesig(String appByDesig) {
		this.appByDesig = appByDesig;
	}

	public String getAuthByDesig() {
		return authByDesig;
	}

	public void setAuthByDesig(String authByDesig) {
		this.authByDesig = authByDesig;
	}

	public String getPrepByDesig() {
		return prepByDesig;
	}

	public void setPrepByDesig(String prepByDesig) {
		this.prepByDesig = prepByDesig;
	}

	public int getWcrRefId() {
		return wcrRefId;
	}

	public void setWcrRefId(int wcrRefId) {
		this.wcrRefId = wcrRefId;
	}

	public List getWcrRefIdList() {
		return wcrRefIdList;
	}

	public void setWcrRefIdList(List wcrRefIdList) {
		this.wcrRefIdList = wcrRefIdList;
	}

	public String getBillFlag() {
		return billFlag;
	}

	public void setBillFlag(String billFlag) {
		this.billFlag = billFlag;
	}

	public List getWcrDetailsList() {
		return wcrDetailsList;
	}

	public void setWcrDetailsList(List wcrDetailsList) {
		this.wcrDetailsList = wcrDetailsList;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getBilledFlag() {
		return billedFlag;
	}

	public void setBilledFlag(String billedFlag) {
		this.billedFlag = billedFlag;
	}

	public String getInvoiceMode() {
		return invoiceMode;
	}

	public void setInvoiceMode(String invoiceMode) {
		this.invoiceMode = invoiceMode;
	}

	public String getWcrRefCount() {
		return wcrRefCount;
	}

	public void setWcrRefCount(String wcrRefCount) {
		this.wcrRefCount = wcrRefCount;
	}

	public String getWcrSelected() {
		return wcrSelected;
	}

	public void setWcrSelected(String wcrSelected) {
		this.wcrSelected = wcrSelected;
	}

	public String getDisplayAmount() {
		return displayAmount;
	}

	public void setDisplayAmount(String displayAmount) {
		this.displayAmount = displayAmount;
	}
	
	public String getButtonFlag() {
		return buttonFlag;
	}

	public void setButtonFlag(String buttonFlag) {
		this.buttonFlag = buttonFlag;
	}
}
