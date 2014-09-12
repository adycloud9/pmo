/** 
 * 
 * 
 * Name: WcrForm.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ===================================================================================================== 
 *                            Prior 
 * Date        By              Version    Description 
 * ---------- --------------- -------  ------------------------------------------------------------------ 
 * 
 * 
 * =========================================================================================================== 
 * </pre> 
 * 
  

 **/

package com.vsnl.struts.forms;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class WcrForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private String creationDate=null;
	
	private String endDate=null;
	
	private String sowName=null;
	
	private String wonNo=null;
	
	private String prgMgr=null;
	
	private String it=null;
	
	private String poNo=null;
	
	private String approvedBy=null;
	
	private String authorisedBy=null;
	
	private String preparedBy=null;
	
	private List preparedByList=null;
	
	private List approvedByList=null;
	
	private List authorisedByList=null;
	
	private String user;
	
	private List programMgrNames=null;
	
	private List ponumbers=null;

	private String method=null;
	
    private List wonList = null;
	
	private List poList = null;
	
	private String visibility="";
	
	private String businessUnit ="EBU";
	
	private List buList = null;
	
	private String fromDate="";
	
	private String toDate="";	
	
   private List milestoneDtlsList=null;
	
	private String milestoneName=null;
	
	private String milestoneAmnt=null;
	
	private String milestoneRemark=null;
	
	private String mileStoneDate=null;
	
	private String selectedIndex =null;
	
	private List statusList=null;
	
	private String status = null;
	
	private String msg =null;
	
	private String flowFlag=null;
	
	private String prepByDesig=null;
	
	private String appByDesig=null;
	
	private String authByDesig=null;
	
	private int wcrRefId=0;
	
	private List wcrRefIdList=null;
	
	private String billFlag =null;
	
	private int totalSize = 0;
	
	private List wcrDetailsList = null;
	private String invoiceNumber =null;
	
	
		//ver 1.1 starts here
	private String currentDate="";
	private int listSize=0;
	private String totalAmt="";
	private String milestoneAmtFormatted="";
	private int wcrListSize=0;
	//ver 1.1 ends here
	private String mode="";
   private String displayFlag=null;
   private String buttonFlag="";

	//ver 1.1 starts here
	
	public String getMilestoneAmtFormatted() {
		return milestoneAmtFormatted;
	}

	public void setMilestoneAmtFormatted(String milestoneAmtFormatted) {
		this.milestoneAmtFormatted = milestoneAmtFormatted;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
//ver 1.1 ends here
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List getProgramMgrNames() {
		return programMgrNames;
	}

	public void setProgramMgrNames(List programMgrNames) {
		this.programMgrNames = programMgrNames;
	}

	public List getPonumbers() {
		return ponumbers;
	}

	public void setPonumbers(List ponumbers) {
		this.ponumbers = ponumbers;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	
	public List getPoList() {
		return poList;
	}

	public void setPoList(List poList) {
		this.poList = poList;
	}

	public List getWonList() {
		return wonList;
	}

	public void setWonList(List wonList) {
		this.wonList = wonList;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
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

	public List getMilestoneDtlsList() {
		return milestoneDtlsList;
	}

	public void setMilestoneDtlsList(List milestoneDtlsList) {
		this.milestoneDtlsList = milestoneDtlsList;
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

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public List getPreparedByList() {
		return preparedByList;
	}

	public void setPreparedByList(List preparedByList) {
		this.preparedByList = preparedByList;
	}
    
	public String getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(String selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public List getStatusList() {
		return statusList;
	}

	public void setStatusList(List statusList) {
		this.statusList = statusList;
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

	
	
	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	
	
	public List getWcrDetailsList() {
		return wcrDetailsList;
	}

	public void setWcrDetailsList(List wcrDetailsList) {
		this.wcrDetailsList = wcrDetailsList;
	}

	public void reset(){
		
		this.wonNo="";
		this.poNo="";
		this.poList=null;
		this.wonList=null;
		this.sowName="";
		this.visibility="";
		this.buList=null;
     	this.method ="";
	    this.milestoneDtlsList=null;
	    this.milestoneAmnt="";
	    this.mileStoneDate="";
	    this.milestoneName="";
	    this.milestoneRemark="";
	    this.approvedBy="";
	    this.approvedByList=null;
	    this.preparedBy="";
	    this.preparedByList=null;
	    this.authorisedBy="";
	    this.authorisedByList=null;
	    this.selectedIndex=null;
	    this.msg=null;
	    this.flowFlag=null;
	    this.prepByDesig=null;
	    this.appByDesig=null;
	    this.authByDesig=null;
	    this.wcrRefId=0;
	    this.wcrRefIdList=null;
	    this.billFlag=null;
	    this.totalSize=0;
	    this.wcrDetailsList=null;
	    this.listSize=0;//ver 1.1
	    this.mode="";
	    this.wcrListSize=0;
	    this.status="";
	    this.statusList=null;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	/**
	 * @return the wcrListSize
	 */
	public int getWcrListSize() {
		return wcrListSize;
	}

	/**
	 * @param wcrListSize the wcrListSize to set
	 */
	public void setWcrListSize(int wcrListSize) {
		this.wcrListSize = wcrListSize;
	}
	
	public String getButtonFlag() {
		return buttonFlag;
	}

	public void setButtonFlag(String buttonFlag) {
		this.buttonFlag = buttonFlag;
	}
}
