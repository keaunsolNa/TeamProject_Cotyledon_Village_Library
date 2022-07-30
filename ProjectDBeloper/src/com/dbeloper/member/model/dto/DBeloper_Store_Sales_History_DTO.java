package com.dbeloper.member.model.dto;

import java.io.Serializable;
import java.util.Date;

public class DBeloper_Store_Sales_History_DTO implements Serializable {

	private static final long serialVersionUID = 4562350889824974833L;
	private String storeSalesCode;
	private int storeSalesMoney;
	private java.util.Date storeDbeloperDate;
	private String storeIncomeStatement;
	
	public DBeloper_Store_Sales_History_DTO() {
	}
	
	public DBeloper_Store_Sales_History_DTO(String storeSalesCode, int storeSalesMoney, Date storeDbeloperDate,
			String storeIncomeStatement) {
		this.storeSalesCode = storeSalesCode;
		this.storeSalesMoney = storeSalesMoney;
		this.storeDbeloperDate = storeDbeloperDate;
		this.storeIncomeStatement = storeIncomeStatement;
	}

	public String getStoreSalesCode() {
		return storeSalesCode;
	}

	public void setStoreSalesCode(String storeSalesCode) {
		this.storeSalesCode = storeSalesCode;
	}

	public int getStoreSalesMoney() {
		return storeSalesMoney;
	}

	public void setStoreSalesMoney(int storeSalesMoney) {
		this.storeSalesMoney = storeSalesMoney;
	}

	public java.util.Date getStoreDbeloperDate() {
		return storeDbeloperDate;
	}

	public void setStoreDbeloperDate(java.util.Date storeDbeloperDate) {
		this.storeDbeloperDate = storeDbeloperDate;
	}

	public String getStoreIncomeStatement() {
		return storeIncomeStatement;
	}

	public void setStoreIncomeStatement(String storeIncomeStatement) {
		this.storeIncomeStatement = storeIncomeStatement;
	}

	@Override
	public String toString() {
		return "DBeloper_Store_Sales_History_DTO [storeSalesCode=" + storeSalesCode + ", storeSalesMoney="
				+ storeSalesMoney + ", storeDbeloperDate=" + storeDbeloperDate + ", storeIncomeStatement="
				+ storeIncomeStatement + "]";
	}
	
	
}
