package com.codebusters.codebusters.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.repositories.ChildUserRepository;

@Service
public class ChildUserService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	ChildUserRepository childUserRepository;
	
	public List<ChildUserDTO> listAll() {
		List<ChildUserDTO> productsDTO = childUserRepository.findAll().stream()
				.map(product -> mapper.map(product, ChildUserDTO.class)).toList();

		return productsDTO;
	}
}
