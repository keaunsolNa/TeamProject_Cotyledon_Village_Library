package com.dbeloper.member.model.dto;

import java.io.Serializable;
import java.util.Date;

public class DBeloper_Output_Order_History_DTO implements Serializable {

//	private static final long serialVersionUID = 7940337329164083154L;
	private String outputOrderNo;
	private int outputNumberOfBooks;
	private java.util.Date outputOrderDate;
	private String outputApproval;
	private int outputBookNo;
	private String outputMemberNo;
	private String outputNonmembersNo;
	
	public DBeloper_Output_Order_History_DTO() {
	}
	public DBeloper_Output_Order_History_DTO(String outputOrderNo, int outputNumberOfBooks, Date outputOrderDate,
			String outputApproval, int outputBookNo, String outputMemberNo, String outputNonmembersNo) {
		this.outputOrderNo = outputOrderNo;
		this.outputNumberOfBooks = outputNumberOfBooks;
		this.outputOrderDate = outputOrderDate;
		this.outputApproval = outputApproval;
		this.outputBookNo = outputBookNo;
		this.outputMemberNo = outputMemberNo;
		this.outputNonmembersNo = outputNonmembersNo;
	}
	public String getOutputOrderNo() {
		return outputOrderNo;
	}
	public void setOutputOrderNo(String outputOrderNo) {
		this.outputOrderNo = outputOrderNo;
	}
	public int getOutputNumberOfBooks() {
		return outputNumberOfBooks;
	}
	public void setOutputNumberOfBooks(int outputNumberOfBooks) {
		this.outputNumberOfBooks = outputNumberOfBooks;
	}
	public java.util.Date getOutputOrderDate() {
		return outputOrderDate;
	}
	public void setOutputOrderDate(java.util.Date outputOrderDate) {
		this.outputOrderDate = outputOrderDate;
	}
	public String getOutputApproval() {
		return outputApproval;
	}
	public void setOutputApproval(String outputApproval) {
		this.outputApproval = outputApproval;
	}
	public int getOutputBookNo() {
		return outputBookNo;
	}
	public void setOutputBookNo(int outputBookNo) {
		this.outputBookNo = outputBookNo;
	}
	public String getOutputMemberNo() {
		return outputMemberNo;
	}
	public void setOutputMemberNo(String outputMemberNo) {
		this.outputMemberNo = outputMemberNo;
	}
	public String getOutputNonmembersNo() {
		return outputNonmembersNo;
	}
	public void setOutputNonmembersNo(String outputNonmembersNo) {
		this.outputNonmembersNo = outputNonmembersNo;
	}
	@Override
	public String toString() {
		return "DBeloper_Output_Order_History_DTO [outputOrderNo=" + outputOrderNo + ", outputNumberOfBooks="
				+ outputNumberOfBooks + ", outputOrderDate=" + outputOrderDate + ", outputApproval=" + outputApproval
				+ ", outputBookNo=" + outputBookNo + ", outputMemberNo=" + outputMemberNo + ", outputNonmembersNo="
				+ outputNonmembersNo + "]";
	}
	
	
	
}
