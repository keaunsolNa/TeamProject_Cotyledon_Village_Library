package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Mileage_DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3289269870983054463L;

	private String mileage_productno;
	private String mileage_productname;
	private int mileage_productprice;
	
	public DBeloper_Mileage_DTO() {
	}
	
	public DBeloper_Mileage_DTO(String mileage_productno, String mileage_productname, int mileage_productprice) {
		this.mileage_productno = mileage_productno;
		this.mileage_productname = mileage_productname;
		this.mileage_productprice = mileage_productprice;
	}

	public String getMileage_productno() {
		return mileage_productno;
	}
	public void setMileage_productno(String mileage_productno) {
		this.mileage_productno = mileage_productno;
	}
	public String getMileage_productname() {
		return mileage_productname;
	}
	public void setMileage_productname(String mileage_productname) {
		this.mileage_productname = mileage_productname;
	}
	public int getMileage_productprice() {
		return mileage_productprice;
	}
	public void setMileage_productprice(int mileage_productprice) {
		this.mileage_productprice = mileage_productprice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "DBeloper_Mileage_DTO [mileage_productno=" + mileage_productno + ", mileage_productname="
				+ mileage_productname + ", mileage_productprice=" + mileage_productprice + "]";
	}

	

	
	

	
	
	
}