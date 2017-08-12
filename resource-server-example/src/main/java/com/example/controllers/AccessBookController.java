package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.AccessBookResponse;
import com.example.services.BookService;

@RestController
@RequestMapping("/api/book/access/")
public class AccessBookController {
	
	@Autowired
	private BookService bookService;
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/bybook/{id}")
	public List<AccessBookResponse> getByBook(@PathVariable("id") int bookId) {
		return bookService.getAccessByBook(bookId);
	}	
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/bypublisher/{id}")
	public List<AccessBookResponse> getByPublisher(@PathVariable("id") int publisherId) {
		return bookService.getAccessByPublisher(publisherId);
	}
}
