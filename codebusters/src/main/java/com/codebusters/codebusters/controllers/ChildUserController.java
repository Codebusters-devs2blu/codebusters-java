package com.codebusters.codebusters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.services.ChildUserService;

@RestController
@RequestMapping(value = "/api/childUser")
public class ChildUserController {

	@Autowired
	private ChildUserService childUSerService;
}
