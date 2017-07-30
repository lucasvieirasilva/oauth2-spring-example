package com.example.oauth2.models;

import java.util.Date;

public class AccessBookResponse {
	private BookResponse book;
	private CustomerResponse customer;
	private Date accessDate;
	
	public BookResponse getBook() {
		return book;
	}
	public void setBook(BookResponse book) {
		this.book = book;
	}
	public CustomerResponse getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerResponse customer) {
		this.customer = customer;
	}
	public Date getAccessDate() {
		return accessDate;
	}
	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}
}
