package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Input_Order_History_DTO implements Serializable{

	private static final long serialVersionUID = -6307699639748655720L;
	private String inputOrderNo;
	private Integer inputBookNo;
	private String inputBookname;
	private String inputBookAuthor;
	private String inputBookPublisherName;
	private String inputApproval;
	private String newBook;
	
	public DBeloper_Input_Order_History_DTO() {
	}

	public DBeloper_Input_Order_History_DTO(String inputOrderNo, Integer inputBookNo, String inputBookname,
			String inputBookAuthor, String inputBookPublisherName, String inputApproval, String newBook) {
		super();
		this.inputOrderNo = inputOrderNo;
		this.inputBookNo = inputBookNo;
		this.inputBookname = inputBookname;
		this.inputBookAuthor = inputBookAuthor;
		this.inputBookPublisherName = inputBookPublisherName;
		this.inputApproval = inputApproval;
		this.newBook = newBook;
	}

	
	public String getInputOrderNo() {
		return inputOrderNo;
	}

	public void setInputOrderNo(String inputOrderNo) {
		this.inputOrderNo = inputOrderNo;
	}

	public Integer getInputBookNo() {
		return inputBookNo;
	}

	public void setInputBookNo(Integer inputBookNo) {
		this.inputBookNo = inputBookNo;
	}

	public String getInputBookname() {
		return inputBookname;
	}

	public void setInputBookname(String inputBookname) {
		this.inputBookname = inputBookname;
	}

	public String getInputBookAuthor() {
		return inputBookAuthor;
	}

	public void setInputBookAuthor(String inputBookAuthor) {
		this.inputBookAuthor = inputBookAuthor;
	}

	public String getInputBookPublisherName() {
		return inputBookPublisherName;
	}

	public void setInputBookPublisherName(String inputBookPublisherName) {
		this.inputBookPublisherName = inputBookPublisherName;
	}

	public String getInputApproval() {
		return inputApproval;
	}

	public void setInputApproval(String inputApproval) {
		this.inputApproval = inputApproval;
	}

	public String getNewBook() {
		return newBook;
	}

	public void setNewBook(String newBook) {
		this.newBook = newBook;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DBeloper_Input_Order_History_DTO [inputOrderNo=" + inputOrderNo + ", inputBookNo=" + inputBookNo
				+ ", inputBookname=" + inputBookname + ", inputBookAuthor=" + inputBookAuthor
				+ ", inputBookPublisherName=" + inputBookPublisherName + ", inputApproval=" + inputApproval
				+ ", newBook=" + newBook + "]";
	}
	
	
	
	
	
}
