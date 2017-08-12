package com.example.models;

import java.util.Date;

public class BookResponse {
	private int id;
	private String title;
	private String author;
	private Date publicationDate;
	private PublisherResponse publisher;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public PublisherResponse getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherResponse publisher) {
		this.publisher = publisher;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
}
