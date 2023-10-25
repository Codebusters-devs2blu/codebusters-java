package com.codebusters.codebusters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.services.UserServices;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	@Autowired
	private UserServices userService;
}
