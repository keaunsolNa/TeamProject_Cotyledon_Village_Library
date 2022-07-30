package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Book_Category_DTO implements Serializable{

	private static final long serialVersionUID = -5555004997470092299L;
	private int categoryNumber;
	private String categoryName;
	
	public DBeloper_Book_Category_DTO() {
	}

	public DBeloper_Book_Category_DTO(int categoryNumber, String categoryName) {
		this.categoryNumber = categoryNumber;
		this.categoryName = categoryName;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "DBeloper_Book_Category_DTO [categoryNumber=" + categoryNumber + ", categoryName=" + categoryName + "]";
	}
}
