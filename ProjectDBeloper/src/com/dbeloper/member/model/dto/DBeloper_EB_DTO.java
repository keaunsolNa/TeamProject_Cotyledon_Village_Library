package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_EB_DTO implements Serializable {

	private static final long serialVersionUID = 60627737943052848L;
	private int ebBookNumber;
	private String ebBookCategory;
	
	public DBeloper_EB_DTO() {
	}
	
	public DBeloper_EB_DTO(int ebBookNumber, String ebBookCategory) {
		this.ebBookNumber = ebBookNumber;
		this.ebBookCategory = ebBookCategory;
	}
	
	public int getEbBookNumber() {
		return ebBookNumber;
	}
	public void setEbBookNumber(int ebBookNumber) {
		this.ebBookNumber = ebBookNumber;
	}
	public String getEbBookCategory() {
		return ebBookCategory;
	}
	public void setEbBookCategory(String ebBookCategory) {
		this.ebBookCategory = ebBookCategory;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "DBeloper_EB_DTO [ebBookNumber=" + ebBookNumber + ", ebBookCategory=" + ebBookCategory + "]";
	}
	

	
}
