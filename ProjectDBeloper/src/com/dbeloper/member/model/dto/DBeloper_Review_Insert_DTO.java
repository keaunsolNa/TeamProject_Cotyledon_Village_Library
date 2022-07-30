package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Review_Insert_DTO implements Serializable {

	private static final long serialVersionUID = -2057384000939833123L;
	private int bookNo;
	private String reviewContents;
	private String userNo;
	
	public DBeloper_Review_Insert_DTO() {
	}
	
	public DBeloper_Review_Insert_DTO(int bookNo, String reviewContents, String userNo) {
		this.bookNo = bookNo;
		this.reviewContents = reviewContents;
		this.userNo = userNo;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "DBeloper_Review_Insert_DTO [bookNo=" + bookNo + ", reviewContents=" + reviewContents + ", userNo="
				+ userNo + "]";
	}
	
	
}
