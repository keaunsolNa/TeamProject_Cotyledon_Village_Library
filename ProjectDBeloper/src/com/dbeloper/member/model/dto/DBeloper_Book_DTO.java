package com.dbeloper.member.model.dto;

import java.io.Serializable;
import java.util.Date;

public class DBeloper_Book_DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7517176836981510255L;
	private Integer bookNo;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	private java.util.Date bookPublishingDate;
	private int bookStock;
	private int bookSalesRate;
	private String bookPublisherName;
	private int bookEbNumber;
	private int bookCategoryNumber;
	
	public DBeloper_Book_DTO() {
	}
	
	public DBeloper_Book_DTO(String bookName, String bookAuthor, int bookPrice, Date bookPublishingDate, int bookStock,
			String bookPublisherName, int bookEbNumber, int bookCategoryNumber) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookPublishingDate = bookPublishingDate;
		this.bookStock = bookStock;
		this.bookPublisherName = bookPublisherName;
		this.bookEbNumber = bookEbNumber;
		this.bookCategoryNumber = bookCategoryNumber;
	}

	public DBeloper_Book_DTO(Integer bookNo, String bookName, String bookAuthor, int bookPrice, Date bookPublishingDate,
			int bookStock, int bookSalesRate, String bookPublisherName, int bookEbNumber, int bookCategoryNumber) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookPublishingDate = bookPublishingDate;
		this.bookStock = bookStock;
		this.bookSalesRate = bookSalesRate;
		this.bookPublisherName = bookPublisherName;
		this.bookEbNumber = bookEbNumber;
		this.bookCategoryNumber = bookCategoryNumber;
	}

	public Integer getBookNo() {
		return bookNo;
	}

	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public java.util.Date getBookPublishingDate() {
		return bookPublishingDate;
	}

	public void setBookPublishingDate(java.util.Date bookPublishingDate) {
		this.bookPublishingDate = bookPublishingDate;
	}

	public int getBookStock() {
		return bookStock;
	}

	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}

	public int getBookSalesRate() {
		return bookSalesRate;
	}

	public void setBookSalesRate(int bookSalesRate) {
		this.bookSalesRate = bookSalesRate;
	}

	public String getBookPublisherName() {
		return bookPublisherName;
	}

	public void setBookPublisherName(String bookPublisherName) {
		this.bookPublisherName = bookPublisherName;
	}

	public int getBookEbNumber() {
		return bookEbNumber;
	}

	public void setBookEbNumber(int bookEbNumber) {
		this.bookEbNumber = bookEbNumber;
	}

	public int getBookCategoryNumber() {
		return bookCategoryNumber;
	}

	public void setBookCategoryNumber(int bookCategoryNumber) {
		this.bookCategoryNumber = bookCategoryNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DBeloper_Book_DTO [bookNo=" + bookNo + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor
				+ ", bookPrice=" + bookPrice + ", bookPublishingDate=" + bookPublishingDate + ", bookStock=" + bookStock
				+ ", bookSalesRate=" + bookSalesRate + ", bookPublisherName=" + bookPublisherName + ", bookEbNumber="
				+ bookEbNumber + ", bookCategoryNumber=" + bookCategoryNumber + "]";
	}

	
	
}
