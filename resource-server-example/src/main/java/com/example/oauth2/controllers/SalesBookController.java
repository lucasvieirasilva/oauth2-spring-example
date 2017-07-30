package com.example.oauth2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.oauth2.models.SaleBookResponse;
import com.example.oauth2.services.BookService;

@RestController
@RequestMapping("/api/book/sales/")
public class SalesBookController {
	
	@Autowired
	private BookService bookService;
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/sales/bybook/{id}")
	public List<SaleBookResponse> getSalesBook(@PathVariable("id") int bookId) {
		return bookService.getSalesByBook(bookId);
	}
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/sales/bypublisher/{id}")
	public List<SaleBookResponse> getSalesBookByPublisher(@PathVariable("id") int publisherId) {
		return bookService.getSalesByPublisher(publisherId);
	}
}
