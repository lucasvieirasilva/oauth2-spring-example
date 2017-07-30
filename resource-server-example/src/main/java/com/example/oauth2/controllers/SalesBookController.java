package com.example.oauth2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.oauth2.models.SaleBookResponse;
import com.example.oauth2.services.AccessBookService;
import com.example.oauth2.models.AccessBookResponse;
import com.example.oauth2.models.FeedbackBookResponse;

@RestController
@RequestMapping("/api/book/access/")
public class SalesBookController {
	
	@Autowired
	private AccessBookService accessBookService;
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/bybook/{id}")
	public List<AccessBookResponse> getAccessBook(@PathVariable("id") int bookId) {
		return accessBookService.getAccessByBook(bookId);
	}	
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/bypublisher/{id}")
	public List<AccessBookResponse> getAccessBookByPublisher(@PathVariable("id") int publisherId) {
		return accessBookService.getAccessByPublisher(publisherId);
	}
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/sales/bybook/{id}")
	public List<SaleBookResponse> getSalesBook(@PathVariable("id") int bookId) {
		return null;
	}
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/sales/bypublisher/{id}")
	public List<SaleBookResponse> getSalesBookByPublisher(@PathVariable("id") int publisherId) {
		return null;
	}
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/feedbacks/bybook/{id}")
	public List<FeedbackBookResponse> getFeedbacksBook(@PathVariable("id") int bookId) {
		return null;
	}
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/feedbacks/bypublisher/{id}")
	public List<FeedbackBookResponse> getFeedbacksBookByPublisher(@PathVariable("id") int publisherId) {
		return null;
	}
}
