package com.codebusters.codebusters.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codebusters.codebusters.models.dtos.AdultUserDTO;



@Service
public class AdultUserService {
	
	@Autowired
	ModelMapper mapper;

	public List<AdultUserDTO> listAll() {
		return null;
	}

	public void deleteBuyer(Long id) {
	
		
	}

	public AdultUserDTO findById(Long id) {
		
		return null;
	}
}
