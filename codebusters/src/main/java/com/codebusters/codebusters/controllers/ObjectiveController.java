package com.codebusters.codebusters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.services.ObjectiveService;

@RestController
@RequestMapping(value = "/api/objective")
public class ObjectiveController {
	
	@Autowired
	private ObjectiveService objectiveService; 
}
