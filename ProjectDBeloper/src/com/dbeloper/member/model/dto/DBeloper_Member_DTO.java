package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Member_DTO implements Serializable{

	private static final long serialVersionUID = 434382009765615246L;
	private String memberNo;
	private String memberName;
	private String memberPhone;
	private String memberAddress;
	private int memberMileage;
	private String memberId;
	private String memberPwd;
	private String memberGradeNo;
	private String memberDropYN;
	private int memberSumMoney;

	public DBeloper_Member_DTO() {
	}

	public DBeloper_Member_DTO(String memberNo, String memberName, String memberPhone, String memberAddress,
			int memberMileage, String memberId, String memberPwd, String memberGradeNo, String memberDropYN,
			int memberSumMoney) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.memberMileage = memberMileage;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberGradeNo = memberGradeNo;
		this.memberDropYN = memberDropYN;
		this.memberSumMoney = memberSumMoney;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public int getMemberMileage() {
		return memberMileage;
	}

	public void setMemberMileage(int memberMileage) {
		this.memberMileage = memberMileage;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberGradeNo() {
		return memberGradeNo;
	}

	public void setMemberGradeNo(String memberGradeNo) {
		this.memberGradeNo = memberGradeNo;
	}

	public String getMemberDropYN() {
		return memberDropYN;
	}

	public void setMemberDropYN(String memberDropYN) {
		this.memberDropYN = memberDropYN;
	}

	public int getMemberSumMoney() {
		return memberSumMoney;
	}

	public void setMemberSumMoney(int memberSumMoney) {
		this.memberSumMoney = memberSumMoney;
	}

	@Override
	public String toString() {
		return "DBeloper_Member_DTO [memberNo=" + memberNo + ", memberName=" + memberName + ", memberPhone="
				+ memberPhone + ", memberAddress=" + memberAddress + ", memberMileage=" + memberMileage + ", memberId="
				+ memberId + ", memberPwd=" + memberPwd + ", memberGradeNo=" + memberGradeNo + ", memberDropYN="
				+ memberDropYN + ", memberSumMoney=" + memberSumMoney + "]";
	}
	
	
	
}
