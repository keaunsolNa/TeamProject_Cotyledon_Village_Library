package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Member_Grade_DTO implements Serializable{

	private static final long serialVersionUID = 4076624520585589178L;
	private String mgGradeNo;
	private String mgGradeName;
	private double mgMileagePer;
	
	public DBeloper_Member_Grade_DTO() {
	}
	
	public DBeloper_Member_Grade_DTO(String mgGradeNo, String mgGradeName, double mgMileagePer) {
		this.mgGradeNo = mgGradeNo;
		this.mgGradeName = mgGradeName;
		this.mgMileagePer = mgMileagePer;
	}
	public String getMgGradeNo() {
		return mgGradeNo;
	}
	public void setMgGradeNo(String mgGradeNo) {
		this.mgGradeNo = mgGradeNo;
	}
	public String getMgGradeName() {
		return mgGradeName;
	}
	public void setMgGradeName(String mgGradeName) {
		this.mgGradeName = mgGradeName;
	}
	public double getMgMileagePer() {
		return mgMileagePer;
	}
	public void setMgMileagePer(double mgMileagePer) {
		this.mgMileagePer = mgMileagePer;
	}

	@Override
	public String toString() {
		return "DBeloper_Member_Grade_DTO [mgGradeNo=" + mgGradeNo + ", mgGradeName=" + mgGradeName + ", mgMileagePer="
				+ mgMileagePer + "]";
	}
	
	
}
