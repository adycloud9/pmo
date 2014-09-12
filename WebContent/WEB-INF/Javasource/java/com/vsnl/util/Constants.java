

package com.vsnl.util;

public class Constants {
	public static final String LOGIN_LEVEL="LOGIN_LEVEL";
	public static final String LOGIN_SECTION="LOGIN_SECTION";
	public static final String DEMAND_DRAFT="DEMAND DRAFT";	
	public static final String CHEQUE ="CHEQUE";
	public static final String OSO="OSO";
	public static final String Billing="Billing";
	public static final String M6="M6";
	public static final String Viznet="Viznet";
	public static final String YES="YES";
	public static final String LOGIN_NAME="Login_Name";
	public static final String LOGIN_ID="login_id";
	public static final String LOGIN_TYPE="login_type";
	public static final String LOGIN_DESIGNATION="login_designation";
	public static final String LOGIN_SUB_TYPE="login_sub_type";
	public static final String LOGIN_SUB_TYPE_ID="login_sub_type_id";
	public static final String SHOW_HTML_MESSAGE ="SHOW_HTML_MESSAGE";
	
//	public static final String GENEVA_DATASOURCE = "geneva";
	public static final String PMS_DATASOURCE = "pms_dev"; //To be decommented when 
	//war file for PNR_SIT is to be created.. 
	public static final String GENEVA_BDC_DATASOURCE="bdc_sit";
	
	public static final String SHOW_JAVASCRIPT_MESSAGE ="SHOW_JAVASCRIPT_MESSAGE";
	
	public static final String INSTALLATION_ADDRESS = "INST";
	public static final String BILLING_ADDRESS = "BILL";
	public static final String CONTRACTING_ADDRESS = "CONTRACT";
	public static final String TERMINATING_ADDRESS = "TERMINATE";
	public static final String LM = "LAST MILE";
	public static final String CPE = "CUSTOMER PREMISES EQUIPMENT";
	public static final String DISCONNECT_REQUEST_PENDING= "PENDING";
	public static final String DISCONNECT_REQUEST_COMPLETE= "COMPLETE";
	public static final String CHECKBOX_DISABLED_TRUE= "TRUE";
	public static final String CHECKBOX_DISABLED_FALSE= "FALSE";
	public static final String NPLC= "NPLC";
	public static final String ILL= "ILL";
	public static final String MAN= "MAN";
	public static final String WIMAX = "WIMAX";//For Wimax
	public static final String RF = "RF";//For RF..
	public static final String SIP_Trunking= "SIP_TRUNKING"; // Version 1.7 
	public static final String GVPN= "GVPN";
	public static final String BILLING_ACCOUNT="BILLING_ACCOUNT";
	
	public static final String FEASIBILITY_STATUS_STAGE_NAME = "Get Lead Data From OSO";
	public static final String FEASIBILITY_STATUS_SOLU_NAME = "Solution Vetting";
	public static final String FEASIBILITY_STATUS_STATUS = "Complete";
	public static final String FEASIBILITY_STATUS_FLAG = "CURRENT";
	public static final String HEADQUATERS_FOR = "HEADQUATERS_FOR";
	public static final String HQ = "HQ";
	public static final String BEARER_STATUS = "Bearer Status";
	public static final String CABLE_HEAD = "Cable Head";
	public static final String CIRCUIT_SPEED = "Circuit Speed";
	public static final String CIRCUIT_SPEED_UNIT = "Circuit Speed Unit";
	public static final String INTERFACE = "Interface";
	
	public static final String ACCESS_MEDIA = "Access Media";
	public static final String CPE_TYPE = "CPE Type";
	public static final String SERVICE_TYPE = "Service Type";
	public static final String COS = "COS";
	
	public static final String CATEGORY = "Category";
	public static final String PROFILE = "Profile";
	public static final String VPN_CATEGORY = "VPN Category";
	public static final String ERS="ERS"; 
	public static final String Flexible="Flexible"; 
	public static final String Standard="Standard";
	
	public static final String CURRENCY="INR";
	
	
	public static final String ACCOUNTING_CODE = "ACCOUNTING CODE"; // added by ver 1.36
	
	
	//added for Payment Allocation
	
	public static final String INDIAN_CURRENCY="INR";
	public static final String US_CURRENCY="USD";
	
	public static final String REPORT_LOGIN_TYPE="R";
	/**************version 1.3CSM Start********************/
	public static final String CONTENT_TYPE_ZIP = "application/zip";
	public static final String CONTENT_FILE_NAME_EXTN = ".zip";
	public static final String PdfUrlInvoicePath = "http://59.162.71.33:8098/PDFURL/invoicePath.jsp"; //version 1.6 
	/**************version 1.3CSM End*********************/
	public static final String EXPORT_FILE_ATTR_NAME = "EXPORT_FILE";
	public static final String CONTENT_TYPE_MS_EXCEL = "application/vnd.ms-excel";
	public static final String CONTENT_TYPE_TEXT = "application/octet-stream";
	public static final String EXPORT_FILE_NAME_PREFIX = "ExportFile-";
	public static final String EXPORT_FILE_NAME_EXTN = ".xls";
	//CR #183 for Neotel ver 1.20
	public static final String EXPORT_FILE_NAME_EXTN_Vox = ".csv";
    //End CR #183 for Neotel ver 1.20
	public static final String HEADER_CNT_DESP = "Content-disposition";
	public static final String HEADER_CNT_DESP_VAL_PREFIX = "attachment; filename=";
	public static final long UPLOAD_FILE_MAX_SIZE = 1048576; // Limit of 1 MB
	public static final String EXPORT_FILES_RELATIVE_PATH = "exportedFiles";
	public static final String DOWNLOAD_FILES_RELATIVE_PATH = "invalidXLS";
	
	public static final String LAST_MILE="LAST MILE";
	public static final String IPLC="IPLC";
	//public static final String VBL= "VBL";
	public static final String TDM_Link= "TDM Link";
	
	// BDC REPORTS
	public static final String customer="Customer BDC";
	public static final String invoice="Invoice BDC";
	public static final String invoice_cancel="Cancel Invoice BDC";
	public static final String revenue="Revenue BDC";
	public static final String collection="Collection BDC";
	public static final String collection_cancel="Cancel Collection BDC";
	public static final String allocation="Allocation BDC";	
	public static final String allocation_cancel="Cancel Allocation BDC";
	public static final String debit="Debit Note BDC";
	public static final String credit="Credit Note BDC";
	public static final String debit_cancel="Cancel Credit Note BDC";
	public static final String credit_cancel="Cancel Debit Note BDC";
	public static final String tds="Tds BDC";
	public static final String CR="Cust Ref";
	public static final String domain="@vsnl.co.in";
	public static final String InvoicePathForReports ="http://59.162.71.33:8098/EBP_new/getInvoice";//For POS PNR CR.. V1.4
	public static final String InvoicePath="http://59.163.6.123/viewBills/viewer/viewframeset.jsp?name=/bills/production/";
	public static final String testBillPath="http://59.163.6.123/viewBills/viewer/viewframeset.jsp?name=/bills/test/";
	//Version 1.17 Starts
	public static final String InvoicePathForOthers="http://59.162.71.8:9080/invoices_sit/";
   //version 1.17 Ends
	public static final String testBillPathForOthers="http://59.162.71.15:9080/testbill_sit/";
	public static final String realInvoicePath="/usr/IBM/WebSphere/AppServer/profiles/profile1/installedApps/openetdevNode01Cell/invoices_sit.ear/invoices_sit.war/";

	//	VPN Product Uplaod added by Madhumita M on 30/08/2007 Version 1.1
	public static final String SUCCESS_RESULT = "T";
	public static final String CHANNEL_PARTNER_ID="CHANNEL PARTNER ID";
	
	
	 
	

	
	public static final String STRING_TYPE="S";
	public static final String NUMERIC_TYPE="N";
	public static final String DATE_TYPE="D";
	public static final String YES_FLAG="Y";
	public static final String NO_FLAG="N";
	
	public static final String CUSTOMER_REFERENCE="Customer Reference";
	public static final String ACCOUNT_NUMBER="Account Number";  
	public static final String FAMILY="Family";
	public static final String PRODUCT_NAME="Product name";
	public static final String SERVICE_ID="Service ID";
	public static final String PHASE_ID="Phase ID";
	public static final String PROJECT_ID="Project ID";
	public static final String BANDWIDTH="Bandwidth";
	public static final String CPE_TYPE_VPN="CPE Type";
	public static final String TOPOLOGY="Topology";
	public static final String COMPONENT_ID="Component ID";
	public static final String PO_LINE_ITEM_DESCRIPTION="PO Line Item Description";
	public static final String VSNL_POP="VSNL POP";
	public static final String CARRIER_NAME="Carrier Name";
	public static final String PO_LINE_ITEM_NUMBER="PO Line Item Number";
	public static final String DEPOSIT="Deposit";
	public static final String CUSTOMER_LOCATION="Customer Location";
	public static final String CIRCUIT_DESIGNATION="Circuit Designation";
	public static final String COS_RATIO="COS Ratio";
	public static final String TECHNOLOGY="Technology";
	public static final String COS_VPN="COS";
	public static final String COMMISSIONING_DATE_VPN="Commissioning Date";
	public static final String DISCOUNT="Discount";
	public static final String SOLUTION_ID="Solution ID";
	public static final String BSO_NAME="BSO Name";
	public static final String BSO_SYNCHRONIZATION_REQUIRED="BSO Synchronization Required";
	public static final String BUSINESS_AREA_VPN="Business Area";
	public static final String ENDING_QUARTER="Ending Quarter";
	public static final String LOCAL_LOOP_ID="Local Loop ID";
	public static final String LOCAL_LOOP_MEDIA="Local Loop Media";
	public static final String LOCAL_LOOP_START_DATE="Local Loop Start Date";
	public static final String LOCAL_LOOP_TYPE="Local Loop Type";
	public static final String LOCATION_VPN="Location";
	public static final String PO_DATE_VPN="PO Date";
	public static final String PO_NUMBER="PO Number";
	public static final String PROVISIONABLE="Provisionable";
	public static final String SOURCE_LOCATION="Source Location";
	public static final String CONFIGURATION_DETAILS="Configuration Details";
	public static final String DELIVERY_CHALLAN_NO="Delivery Challan No";
	public static final String PARENT_SERVICE="Parent Service";
	public static final String PORT="Port";
	public static final String SERIAL_NUMBER="Serial Number";
	public static final String CHANNEL_PARTNER_ID_VPN="Channel Partner ID";
	public static final String DISTANCE="Distance";
	public static final String REGISTRATION_DATE="Registration Date";
	public static final String REGISTRATION_PLACE="Registration Place";
	public static final String REGISTRATION_REFERENCE="Registration Reference";
	public static final String CREATION_DATE="Creation Date";
	public static final String CURRENCY_VPN="Currency";
	public static final String TARIFF="Tariff";
	public static final String LIST_ONE_TIME_CHARGE="List One Time Charge";
	public static final String LIST_RECCURING_CHARGE="List Reccuring Charge";
	public static final String SALE_ONE_TIME_CHARGE="Sale One Time Charge";
	public static final String SALE_RECCURING_CHARGE="Sale Reccuring Charge";
	public static final String ONE_TIME_DISCOUNT="One Time Discount";
	public static final String RECURRING_DISCOUNT="Recurring Discount";
	public static final String TAX_TYPE="Tax Type";
	public static final String TAX_EXEMPT_REFERENCE="Tax Exempt Reference";
	public static final String TAX_EXEMPT_TEXT="Tax Exempt Text";
	public static final String EVENT_SOURCE="Event Source";
	public static final String EVENT_SOURCE_LABEL="Event Source Label";
	public static final String EVENT_SOURCE_TEXT="Event Source Text";
	public static final String CONTRACT_DURATION_IN_MONTHS="Contract Duration (in months)";
	public static final String PRODUCT_QUANTITY="Product Quantity";
	public static final String COPF_ID_VPN="COPF_ID";
	public static final String REFERENCE_NUM="Reference Num";
	public static final String ADDR1="ADDR1";
	public static final String ADDR2="ADDR2";
	public static final String ADDR3="ADDR3";
	public static final String ADDR4="ADDR4";
	public static final String ADDR5="ADDR5";
	public static final String ZIPCODE="ZIPCODE";
	public static final String COUNTRY_NAME="Country Name";
	public static final String EVENT_TYPE="Event Type";
	public static final String RATE_PLAN="Rate Plan";
	public static final String TABLE_DATE="Table Date";
	public static final String DESTINATION_LOCATION="Destination Location";
	public static final String PO_START_DATE="PO Start Date";
	public static final String PO_END_DATE="PO End Date";
	
	public static final String TAXEXEMPT="Tax-Exempt";
	public static final String INVALID_TAX_EXEMPT="The Tax Exempt is not valid";
	
	// ADDED BY MAYANK FOR CREDIT DEBIT BULK UPLOAD
	public static final String CR_CUSTOMER_REFERENCE = "Customer Reference";
	public static final String CR_ACCOUNT_NUMBER = "Account Number";
	public static final String CR_COPF_ID = "COPF ID";
	public static final String BUSINESS_AREA = "Business Area" ;
	public static final String ADJUSTMENT_TYPE = "Adjustment Type";
	public static final String TAX_NAME = "Tax Name";
	public static final String AMOUNT = "Amount";
	public static final String DESCRIPTION = "Description";
	public static final String CREDIT_DEBIT = "Credit/Debit Note (C/D)";
	public static final String CR_CURRENCY= "Currency";
	public static final String CR_SERVICE_TYPE= "Service Type";
	public static final String STRING_TYPE_CR="S";
	public static final String NUMERIC_TYPE_CR="N";
	public static final String DATE_TYPE_CR="D";
	public static final String YES_FLAG_CR="Y";
	public static final String NO_FLAG_CR="N";
	//Version 1.1 starts
	public static final String ACTIVE_CATALOG_STATUS="3";
	//Version 1.1 ends
	//Version 1.2 starts
	public static final String Cancel="Cancel";
	//Version 1.2 ends
	
//	Version 1.1POP starts	
	public static final String USER_SECTION_SALES = "Sales"	;
	//Version 1.1POP ends
	
	//ssn for BU L3 {
	public static final String CREDIT_DEBIT_BULK_UPLOAD_VSNL = "Credit Debit Bulk Upload for VSNL";
	public static final String CREDIT_DEBIT_BULK_UPLOAD_VBL = "Credit Debit Bulk Upload for VBL";
	public static final String EXPORT_FILES_TEMPLATES = "templates";
	//ssn for BU L3 }
	// Version 1.8 Starts
	public static final String IDC_ACTIVE_FLAG = "Y";
    //	 Version 1.8 Ends
	
    //	 Version 1.9 Starts
	public static final String IDC = "IDC";
	// Version 1.9 Ends
	
	// Version 1.10 Starts
	public static final String Add = "Add";	
	public static final String Update = "Update";
	public static final String View = "View";
	public static final String Delete = "Delete";
	// Version 1.10 Ends
	
	// Version 1.11 Starts
	public static final String IDCReport = "IDCReport";	
	public static final String IDCWorksheet = "IDC Worksheet";	
	public static final String CustomerName = "Customer Name";	
	public static final String Switch = "Switch";	
	public static final String Port = "Port";	
	public static final String IfIndex = "IfIndex";	
	public static final String ModifiedUser = "Modified User";
	public static final String LocationName = "Location Name";
	
   //	 Version 1.11 Ends
	
	// version 1.12 Starts
	public static final String CustomerIP = "Customer IP";
	public static final String IDCBaseBandwidth = "IDC-BASE-BANDWIDTH";
	public static final String IDCBurstableUpto = "IDC-BURSTABLE-UPTO";
	// version 1.12 Ends
	
	//ver 1.13 starts here
	public static final String SuperUser = "Super User";	
	public static final String StartDate = "Start Date";
	public static final String EndDate = "End Date";
	public static final String ModifiedDate = "Modified Date";
	public static final String ActiveInactive = "Active/Inactive";
	public static final String Remarks = "Remarks";
	// ver 1.13 ends here
	//version 1.14 starts {
	public static final String statusReport         = "statusReport";
	public static final String rejectedReport    	= "rejectedInvoices";
	public static final String confirmedReport   	= "confirmedInvoices";
	public static final String pendingReport     	= "dispatchPending";
	public static final String nonServiceableReport = "nonServiceable";
	//version 1.14 ends }
	public static final String HQCITY = "Mumbai"; //Nidhi
	public static final String NDEbandwidht = "NDE-Bandwidth";
	
	//Version 1.17 Starts
	public static final String PostTermination = "Post Termination";
	//Version 1.17 Ends

	// ver 1.16 starts 
	public static final String POS_DATASOURCE = "POS";
	// ver 1.16 ends

//	 ver 1.18 starts here
	public static final String superUser = "superUser";
	public static final String normalUser = "normalUser";
	public static final String view = "View";
	public static final String update = "Update";
	public static final String superUserView = "superUserView";
	public static final String oneIPRangeAdded = "One Range of IP is added";
	public static final String resetAddedIPRange = "One Range of IP is already added. Click reset to remove added range";
	public static final String allocatedIPRange = "Few IPs within this range  are  allocated to some other customer";
// ver 1.18 ends
		
//	version 1.19 starts here
	public static final String domainName   = "GENEVADOMAINNAME";
	public static final String userName    	= "GENEVAUSERNAME";
	public static final String password   	= "GENEVAPWD";
	public static final String folderName   = "FOLDERNAME";
	//	version 1.30 starts here
	public static final String portName   	= "PORTNAME";
	public static final String generationError="Reports cannot be generated due to some technical errors please try again later.";
	public static final String requestSubmitted="Your request to download reports is submitted and is under process.Please try to downlaod after sometime";
	public static final String reportGenerationUnderProcess="Report generation is under process.Please try to download after some time";
	public static final String errorDownloading="Reports cannot be downloaded due to some technical errors please try again later.";
	public static final String errorGenerating="Reports cannot be generated due to some technical errors please try again later.";
	public static final String warExtension=".war";
	public static final String zipName="Report.zip";	
	public static final String delimit="\\";
	public static final String delimiter="//";
	public static final String validationFlagFail="fail";
	public static final String fileGeneration="fileGeneration";
	public static final String successUpload ="success";
	public static final String blankFile="blankFile";
	public static final String invalidFile="invalidFile";	
	public static final String readyToDownload= "3";
	public static final String  requestToGenerate="1";
	public static final String  generationUnderProcess="2";
	public static final String  retrieveSuccessFlag="retrievedSuccessfully";
	public static final String  errorFlag="error";
	public static final String  retrieveUnSuccessFlag="retrievedUnSuccessfully";
	public static final String  trueFlag="T";
	public static final String  falseFlag="F";
	public static final String  NO_STATUS="noStatus";
	public static final String  ENABLED="enabled";
	public static final String  DISABLED="disabled";
	
	
	//version 1.30 ends here
//	version 1.19 ends here
	
	//version 1.21 starts
	public static final String genErrorMessage = "There was an error. Please try after some time.";	
	//version 1.21 ends
	
	//	ver 1.22 starts here
	public static final String productNotfound   = "No Product Found"; // ver 1.27 chnaged products to Product
	public static final String commissionType   = "newparallel";
	//ver 1.22 ends here
	
	//Version 1.23 starts {
	public static final String CONTENT_TYPE_XML = "application/xml";
	//Version 1.23 ends }
	//	ver 1.24 starts here
	public static final String customerListErrorMessage   = "Associate Enterprise Customers Details are not available.";
	public static final String addErrorMessage   = "Associate Enterprise Customer not added due to some errors.Please try again later.";
	public static final String removeErrorMessage   = "Selected Associate Enterprise Customer(s) not removed due to some errors.Please try again later.";
	public static final String addSuccessMessage    = "Associate Enterprise Customer Added Successfully.";
	public static final String removeSuccessMessage = "Selected Associate Enterprise Customer(s) Removed Successfully.";
	// version 1.24 ends here
	
	//ver 1.25 starts here
	public static final String ipalreadyadded = "This IP/IP range is already added.";
	public static final String oneIPRangeDeleted = "IP range/s is deleted";
	public static final String ipexceeded = "Total number of IP's added is not equal to the number of IP's added during solution definition";
	public static final String alreadyallocatedIPRange = "Few IP's within this range are already allocated";
	public static final String success = "Values updated successfully";
	

	//ver 1.25 ends here
	
	// ver 1.26 starts here
	public static final String providerType   = "International";
	 
	// ver 1.26 ends here
//	 ver 1.27 starts here
	public static final String nodetailsfound="No Details Found";
	public static final String recordsresult="No Record Fetched"; 
	public static final String NeotelId="2";
	public static final String collection_pay="collection";
	public static final String hotupgradeMessage_no="No New Request Found. Kindly Commission Previous Request";
	// ver 1.27 ends here
	// ver 1.28 starts here
	public static final String parentCustomer = "Parent Customer";
	public static final String vsnliCustomer = "VSNL International Customer";
	// ver 1.28 ends here
	
	//version 1.29 starts here
	
	public static final String parallelUpgradeCommissionType="parallelupgrade";
	public static final String newOrderCommissionType="newproduct";
	
	//version 1.29 ends here
	
	// ver 1.31 starts here	
	public static final String inmarsatFamilyId="6";	
	public static final String inmarsatFamily = "INMARSAT"; 	
	// ver 1.31 ends here
	
	//	ver 1.32 starts here
	public static final String noInputToProc="-1";	
	public static final String reportTypeInvCancel = "APR_REP";
	public static final String reportTypeInvCancelStatus = "STA_REP";
	public static final String reportTypePendingCancel = "REQ_REP";
	//ver 1.32 ends here
	
	// ver 1.33 starts here
	public static final String cancelReason="CANCELREASON";
	public static final String invoiceAcceptReject="InvcAcceptReject";
	public static final String invoiceCancellation="InvoiceCancellation";
	public static final String cannotUploadBlankSheet="Cannot Upload Blank Sheet. Kindly upload the correct sheet.";
	public static final String templateDidNotMatch="The Selected Template and The Uploaded file did not Match";
	public static final String noRecordsFound="No Records found";
	public static final String notMoreThanHundred = "You cannot upload more than 100 records";
	// ver 1.33 ends here
	// ver 1.34 starts here
	public static final String productServSeg = "PRODUCT_SERVICE_SEGMENT";
	// ver 1.34 ends here
	
	// ver 1.35 starts here
	public static final String aaCodeErrorMessage = "The Customer has an Account with the same AA Code. Please select another AA Code";
	public static final String productVAS = "VAS";
	public static final String productTerminal = "Terminal";
	public static final String inmLRITProdId = "1244";
	public static final String billingTypeArr = "Arrear";// ver 1.39 - Changed -Arrear to Arrear
	public static final String billingTypeAdv = "Advance";// ver 1.39 - Changed -Advance to Advance
	public static final String inmCpeProducts = "(1278)";
	// ver 1.35 ends here
	
	// ver 1.37 starts here
	
	public static final String bulkCollect = "BulkCollect";
	public static final String limitExceeds="Limit exceeds for uploaded records.";
	public static final String excelHeader = "EXCELHEADER";
	public static final String numberOfRecords = "NUMBEROFRECORDS";
	public static final String invalidHeaderFormat="Header format is incorrect for the uploaded file";
	public static final String invalidFileUploaded = "Invalid file is uploaded. Please upload valid file.";
	public static final String providerId = "1";
	public static final String errorDescMsg = "Please try again after some time.";
	public static final String custDetailsNotAvlble = "Customer details are not available.";
	public static final String excelRepHeader = "EXCELREPHEADER";
	// ver 1.37 ends here
	
	//version 1.40 starts here
	public static final String bdcType = "Allocation BDC";
	//version 1.40 ends here
	
	//1.45
	public static final String separator1 = ":";
	public static final String separator2 = "|";
	public static final String successMsg = "Cancel Adjustment completed successfully";
	public static final String successIndicator = "SUCCESS";
	//1.45
	//1.44  
	public static final String FromDate = "FromDate";
	public static final String ToDate = "ToDate";
	public static final String Reason = "Reason";
	//1.44  
    public static final String defaultDate = "01-Jan-1980";//ver 1.41 added
    
    //version 1.42 starts here
	public static final String exceptionFlag="E";
	public static final String errorGeneratingReceipt="Collection Done.Error while generating Receipt.";
	public static final String errorPerformingCollection="Error while performing collection.Please contact IT Team.";
	//version 1.42 starts here
	
	
	//version 1.46 starts here
	public static final String searchPageDisplay="displaySearch";
	public static final String statusPageDisplay="displayStatus";
	public static final String defaultPageDisplay="displayPage";
	public static final String noDetails="Details are not available.";
	public static final String errorFetchingData="Error while fetching the details from database";
	public static final String updateStatusError="Service Type Update Status not available.Sorry for the Inconvenience.";
	//version 1.46 ends here
	
	//ver 1.47 starts here		
	public static final String invalidFileFormat="invalidFileFormat";
	public static final String chequeBounce = "ChequeBounce" ;
	public static final String bulk = "Bulk" ;	
	// ver 1.47 ends here

	//	 ver 1.48 starts here	
	public static final String uploadIdPrefix="CB";
	public static final String errorWhileUploading="Error while uploading the file.Please try again later";
	public static final String uploadSuccessful="Upload is successful.Upload ID is ";
	//	 ver 1.48 ends here
	// ver 1.49 starts here
	public static final String accountNo="Account No";
	public static final String copfId="COPF ID";
	public static final String initListprice="Initiation List Price=";
	public static final String initExpPricep="Initiation Expected Price=";
	public static final String initDiscPrice="Initiation Discount Price=";
	public static final String recListPrice="Recurring List Price=";
	public static final String recExpPrice="Recurring Expected Price=";
	public static final String recDiscPrice="Recurring Discount Price=";
	public static final String vsnliProvider="vsnliProvider";
	//	ver 1.49 ends here
	//ver 1.50 starts
	public static final String successMsg1 = "Bill Request deleted successfully";
	public static final String successIndicator1 = "SUCCESS";
	// ver 1.50 ends
	//	 ver 1.51 starts here
	public static final String errorInProc="There is error while executing the procedure.Please contact IT Team.";
	public static final String terminate="terminate";
	// ver 1.51 ends here
		//  ver 1.52 starts  here
	public static final String cancelledRequest="cancelledReq";
	public static final String pendingRequest="pendingReq";
	
	public static final String pending="pending";
	public static final String cancelled="cancelled";
	public static final String approved="approved";
	public static final String rejected="rejected";
	
	public static final String pendingReq="Pending";
	public static final String cancelledReq="Cancelled";
	public static final String approvedReq="Approved";
	public static final String rejectedReq="Rejected";
	public static final String updateReq="Update";
	public static final String createReq="create";
	public static final String workflowDetailsError="Error in Fetching Workflow Details";
	public static final String creditWorkflowId="1";
	public static final String descending="Descending";
	public static final String reqDate="reqDate";
	// ver 1.52 ends here
	public static final String templateMisMatch="Template of Excel file is not proper";// ver 1.53 added
	//	 ver 1.55 starts here
	public static final String VIZNET_ID="VIZNET_ID";
	//	 ver 1.55 ends here
	
	//ver 1.56 starts here
	public static final String failureMsg="Addition of user is failed";
	public static final String updateMsg="Record is updated successfully";
	public static final String addMsg="User is added successfully";
	public static final String editUsrMsg="User Details edited successfully";
	public static final String editUsrFail="User Details could not be edited";
	public static final String upFailure="Updation is unsuccessful";
	public static final String deleteMsg="deletion is successful";
	public static final String dltFailure="deletion is unsuccessful";
	//ver 1.56 ends here
	
	//sib ver starts here
	public static final String sowType="SOW Type";
	public static final String filePath="D:\\PmoApplications\\PmoFiles";
	public static final String maxRecordLimit="10";
	//sib ver ends here
	public static final String adjustmentBlkUpload = "AdjustmentBlkUpload" ;
}
