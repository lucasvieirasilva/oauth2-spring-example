package com.example.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.FooRequestModel;
import com.example.models.FooResponseModel;

@RestController
@RequestMapping("/api/foo")
public class FooController {
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET)
	public FooResponseModel get() {
		FooResponseModel response = new FooResponseModel();
		response.setId(1);
		response.setName("Foo");
		
		return response;
	}
	
	@PreAuthorize("#oauth2.hasScope('write')")
	@RequestMapping(method = RequestMethod.POST)
	public FooResponseModel post(@RequestBody FooRequestModel request) {
		FooResponseModel response = new FooResponseModel();
		response.setId(request.getId());
		response.setName(request.getName());
		
		return response;
	}
}
