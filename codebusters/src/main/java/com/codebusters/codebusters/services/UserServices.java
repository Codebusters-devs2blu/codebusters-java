package com.codebusters.codebusters.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
	
	@Autowired
	ModelMapper mapper;
}
