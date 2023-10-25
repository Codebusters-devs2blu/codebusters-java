package com.codebusters.codebusters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.services.ReleaseService;

@RestController
@RequestMapping(value = "/api/release")
public class ReleaseController {

	@Autowired
	private ReleaseService releaseService; 
	
	
}
