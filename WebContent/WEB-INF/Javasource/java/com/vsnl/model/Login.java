package com.vsnl.model;

import java.io.Serializable;

public class Login implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private String empId=null;
	
	private String password=null;
	
	private String newPassword1=null;
	
	private String newPassword2=null;
	
	private String flag=null;

	public String getEmpId() {
		return empId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
