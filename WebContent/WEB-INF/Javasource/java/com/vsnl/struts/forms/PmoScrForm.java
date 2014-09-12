package com.vsnl.struts.forms;
import java.util.List;



import org.apache.struts.action.ActionForm;



public class PmoScrForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private String firstName=null;
	
	private String lastName=null;
	
	private String empId=null;
	

	private String role=null;
	
	private String email=null;
	
	private String method=null;
	
	private String user=null;
	
	private String flag="";
	private String emailList=null;
	
	
	
	private List empList=null;
	
	
	 
	private String addEditFlag=null;
	private int listSize=0;
	
	private String returnFlag = ""; 
	private List roleList=null;
	private String mode = "";
	private String pageMode = "NoDisplay";
	private String errorMsg = "";
	private String returnMsg = "";
	private String deleteFlag=null;
	private String deleteMsg=null;
	private String searchFirstName=null;
	private String name="";
	private String designation=null;
	

	public String getAddEditFlag() {
		return addEditFlag;
	}

	public void setAddEditFlag(String addEditFlag) {
		this.addEditFlag = addEditFlag;
	}

	public List getEmpList() {
		return empList;
	}

	public void setEmpList(List empList) {
		this.empList = empList;
	}

	public String getEmail() {
		return email;
	}

	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void reset() {
		
		
		this.role=null;
		this.firstName=null;
		this.lastName=null;
		this.email=null;
		this.empId=null;
		this.flag = "";
		this.returnFlag = "";
		this.returnMsg= "";
		this.deleteFlag = "";
		this.deleteMsg = "";
	    this.empList=null;
		this.pageMode="NoDisplay";
		this.mode="";
		this.designation="";
		this.name="";
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	

	

	

	

	public String getReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(String returnFlag) {
		this.returnFlag = returnFlag;
	}

	public List getRoleList() {
		return roleList;
	}

	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getPageMode() {
		return pageMode;
	}

	public void setPageMode(String pageMode) {
		this.pageMode = pageMode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDeleteMsg() {
		return deleteMsg;
	}

	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}

	public String getSearchFirstName() {
		return searchFirstName;
	}

	public void setSearchFirstName(String searchFirstName) {
		this.searchFirstName = searchFirstName;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public String getEmailList() {
		return emailList;
	}

	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}



}
