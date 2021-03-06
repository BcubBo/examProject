package com.bcubbo.pojo;

import java.sql.Date;

public class BookInfo {
	private int bookId;
	//书id主键
	private String bookCode;
	//书编码
	private String bookName;
	private int bookType;
	private int bookAuthor;
	private String publishPress;
	private int isBorrow;
	private String createBy;
	private Date creationTime;
	private String typeName;
	private Date lastUpdateTime;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookType() {
		return bookType;
	}
	public void setBookType(int bookType) {
		this.bookType = bookType;
	}
	public int getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(int bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getPublishPress() {
		return publishPress;
	}
	public void setPublishPress(String publishPress) {
		this.publishPress = publishPress;
	}
	public int getIsBorrow() {
		return isBorrow;
	}
	public void setIsBorrow(int isBorrow) {
		this.isBorrow = isBorrow;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	
	
	
}
