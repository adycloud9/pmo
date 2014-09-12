package com.vsnl.struts.forms;




import java.util.List;

import org.apache.struts.action.ActionForm;



public class ReportsForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private String reportLevel ="";
	private String method=null;
	private String mode=null;
	private String sowName= null;
	private String preparedBy= null;
	private String purchaseOrder= null;
	private String workOrder= null;
	private List dataList=null;
	private String calFlag=null;
	private List detailsList=null;
	private List withWCRList=null;
	private List withoutWCRList=null;
	private String sowCreationDate=null;
	private String mileStoneDate="";
	private String mileStoneName="";
	private String mileStoneAmt="";
	private String wonNum="";
	private String poNum="";
	private String wcr_ref="";
	private int listSize=0;
	private List reportTypeList=null;
	
	
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	public List getDetailsList() {
		return detailsList;
	}
	public void setDetailsList(List detailsList) {
		this.detailsList = detailsList;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getMileStoneAmt() {
		return mileStoneAmt;
	}
	public void setMileStoneAmt(String mileStoneAmt) {
		this.mileStoneAmt = mileStoneAmt;
	}
	public String getMileStoneDate() {
		return mileStoneDate;
	}
	public void setMileStoneDate(String mileStoneDate) {
		this.mileStoneDate = mileStoneDate;
	}
	public String getMileStoneName() {
		return mileStoneName;
	}
	public void setMileStoneName(String mileStoneName) {
		this.mileStoneName = mileStoneName;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getPoNum() {
		return poNum;
	}
	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}
	public String getPreparedBy() {
		return preparedBy;
	}
	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public String getReportLevel() {
		return reportLevel;
	}
	public void setReportLevel(String reportLevel) {
		this.reportLevel = reportLevel;
	}
	public List getReportTypeList() {
		return reportTypeList;
	}
	public void setReportTypeList(List reportTypeList) {
		this.reportTypeList = reportTypeList;
	}
	public String getSowCreationDate() {
		return sowCreationDate;
	}
	public void setSowCreationDate(String sowCreationDate) {
		this.sowCreationDate = sowCreationDate;
	}
	public String getSowName() {
		return sowName;
	}
	public void setSowName(String sowName) {
		this.sowName = sowName;
	}
	public String getWcr_ref() {
		return wcr_ref;
	}
	public void setWcr_ref(String wcr_ref) {
		this.wcr_ref = wcr_ref;
	}
	public List getWithoutWCRList() {
		return withoutWCRList;
	}
	public void setWithoutWCRList(List withoutWCRList) {
		this.withoutWCRList = withoutWCRList;
	}
	public List getWithWCRList() {
		return withWCRList;
	}
	public void setWithWCRList(List withWCRList) {
		this.withWCRList = withWCRList;
	}
	public String getWonNum() {
		return wonNum;
	}
	public void setWonNum(String wonNum) {
		this.wonNum = wonNum;
	}
	public String getWorkOrder() {
		return workOrder;
	}
	public void setWorkOrder(String workOrder) {
		this.workOrder = workOrder;
	}

	public void reset()
	{
		this.calFlag="";
		this.dataList=null;
		this.detailsList=null;
		this.listSize=0;
		this.mileStoneAmt="";
		this.mileStoneDate="";
		this.mileStoneName="";
		this.mode="";
		this.poNum="";
		this.preparedBy="";
		this.purchaseOrder="";
		this.reportLevel="";
		this.reportTypeList=null;
		this.wonNum="";
		this.workOrder="";
	}


}	
	
