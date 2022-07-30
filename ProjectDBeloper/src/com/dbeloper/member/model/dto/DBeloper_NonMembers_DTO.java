package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_NonMembers_DTO implements Serializable{
	
	private static final long serialVersionUID = 293921954988744459L;
	private String nonmembersNo;
	private String nonmembersName;
	private String nonmembersPhone;
	private String nonmembersAddress;
	
	public DBeloper_NonMembers_DTO() {
	}
	
	public DBeloper_NonMembers_DTO(String nonmembersNo, String nonmembersName, String nonmembersPhone,
			String nonmembersAddress) {
		this.nonmembersNo = nonmembersNo;
		this.nonmembersName = nonmembersName;
		this.nonmembersPhone = nonmembersPhone;
		this.nonmembersAddress = nonmembersAddress;
	}

	public String getNonmembersNo() {
		return nonmembersNo;
	}

	public void setNonmembersNo(String nonmembersNo) {
		this.nonmembersNo = nonmembersNo;
	}

	public String getNonmembersName() {
		return nonmembersName;
	}

	public void setNonmembersName(String nonmembersName) {
		this.nonmembersName = nonmembersName;
	}

	public String getNonmembersPhone() {
		return nonmembersPhone;
	}

	public void setNonmembersPhone(String nonmembersPhone) {
		this.nonmembersPhone = nonmembersPhone;
	}

	public String getNonmembersAddress() {
		return nonmembersAddress;
	}

	public void setNonmembersAddress(String nonmembersAddress) {
		this.nonmembersAddress = nonmembersAddress;
	}

	@Override
	public String toString() {
		return "DBeloper_NonMembers_DTO [nonmembersNo=" + nonmembersNo + ", nonmembersName=" + nonmembersName
				+ ", nonmembersPhone=" + nonmembersPhone + ", nonmembersAddress=" + nonmembersAddress + "]";
	}

	

	

}
