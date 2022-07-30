package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Manager_DTO implements Serializable{

	private static final long serialVersionUID = 8968389212758504898L;
	private String managerNum;
	private String managerName;
	private String managerGrade;
	private String managerPhone;
	private String managerAddress;
	private String managerId;
	private String managerPwd;
	private String managerSalary;
	private String managerDropYN;
	
	public DBeloper_Manager_DTO() {
	}
	
	public DBeloper_Manager_DTO(String managerNum, String managerName, String managerGrade, String managerPhone,
			String managerAddress, String managerId, String managerPwd, String managerSalary, String managerDropYN) {
		this.managerNum = managerNum;
		this.managerName = managerName;
		this.managerGrade = managerGrade;
		this.managerPhone = managerPhone;
		this.managerAddress = managerAddress;
		this.managerId = managerId;
		this.managerPwd = managerPwd;
		this.managerSalary = managerSalary;
		this.managerDropYN = managerDropYN;
	}
	
	public String getManagerNum() {
		return managerNum;
	}
	public void setManagerNum(String managerNum) {
		this.managerNum = managerNum;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerGrade() {
		return managerGrade;
	}
	public void setManagerGrade(String managerGrade) {
		this.managerGrade = managerGrade;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getManagerAddress() {
		return managerAddress;
	}
	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPwd() {
		return managerPwd;
	}
	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
	public String getManagerSalary() {
		return managerSalary;
	}
	public void setManagerSalary(String managerSalary) {
		this.managerSalary = managerSalary;
	}
	public String getManagerDropYN() {
		return managerDropYN;
	}
	public void setManagerDropYN(String managerDropYN) {
		this.managerDropYN = managerDropYN;
	}
	
	@Override
	public String toString() {
		return "DBeloper_Manager_DTO [managerNum=" + managerNum + ", managerName=" + managerName + ", managerGrade="
				+ managerGrade + ", managerPhone=" + managerPhone + ", managerAddress=" + managerAddress
				+ ", managerId=" + managerId + ", managerPwd=" + managerPwd + ", managerSalary=" + managerSalary
				+ ", managerDropYN=" + managerDropYN + "]";
	}
	
	
}
