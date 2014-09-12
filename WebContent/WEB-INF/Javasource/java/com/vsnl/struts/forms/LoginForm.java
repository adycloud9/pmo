/** 
 * 
 * 
 * Name: LoginForm.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ===================================================================================================== 
 *                            Prior 
 * Date        By              Version    Description 
 * ---------- --------------- -------  ------------------------------------------------------------------ 
 *                                1.0    Created the File.
 * 19/09/2010  Soumya Singhai     1.1    Added new fields  
 * =========================================================================================================== 
 * </pre> 
 * 
  

 **/
package com.vsnl.struts.forms;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String empId=null;
	
	private String password=null;
	
	private String newPassword1=null;
	
	private String newPassword2=null;
	
	private boolean flag=true;
	
	private String method="";
	
	private String hiddenPwd;
	
	private String msg = null; //ver 1.1 
   
	private String firstName=null;
	
	private String lastName=null;
	private String emp_Id=null;
	private String errorMsg="";
	private String errorFlag="";
	private String filePath=""; 
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	//version 1.1 Starts
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

    //version 1.1 Ends
	public void reset() {
		
			this.firstName="";
			this.lastName="";
			this.emp_Id="";
			this.password=null;
			this.newPassword2=null;
			this.newPassword1=null;
			this.flag=true;
			this.msg=null; // version 1.1
			this.empId=null;
			this.errorMsg=null;
			this.errorFlag=null;
			
		}

	public String getHiddenPwd() {
		return hiddenPwd;
	}

	public void setHiddenPwd(String hiddenPwd) {
		this.hiddenPwd = hiddenPwd;
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

	public String getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	
}

