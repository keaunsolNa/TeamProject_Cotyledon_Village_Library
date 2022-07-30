package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Review_DTO implements Serializable {

	private static final long serialVersionUID = -2192081414576848146L;
	private int reviewNo;
	private String reviewMemNo;
	private int reviewBookNo;
	private String reviewContents;
	private String reviewAward;
	
	public DBeloper_Review_DTO() {
	}
	
	public DBeloper_Review_DTO(int reviewNo, String reviewMemNo, int reviewBookNo, String reviewContents,
			String reviewAward) {
		this.reviewNo = reviewNo;
		this.reviewMemNo = reviewMemNo;
		this.reviewBookNo = reviewBookNo;
		this.reviewContents = reviewContents;
		this.reviewAward = reviewAward;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewMemNo() {
		return reviewMemNo;
	}
	public void setReviewMemNo(String reviewMemNo) {
		this.reviewMemNo = reviewMemNo;
	}
	public int getReviewBookNo() {
		return reviewBookNo;
	}
	public void setReviewBookNo(int reviewBookNo) {
		this.reviewBookNo = reviewBookNo;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewAward() {
		return reviewAward;
	}
	public void setReviewAward(String reviewAward) {
		this.reviewAward = reviewAward;
	}
	@Override
	public String toString() {
		return "DBeloper_Review_DTO [reviewNo=" + reviewNo + ", reviewMemNo=" + reviewMemNo + ", reviewBookNo="
				+ reviewBookNo + ", reviewContents=" + reviewContents + ", reviewAward=" + reviewAward + "]";
	}
	
	
	
	
}
