package com.example.models;

import java.util.Date;

public class SaleBookResponse {
	private BookResponse book;
	private CustomerResponse customer;
	private Date saleDate;
	
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
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
}
