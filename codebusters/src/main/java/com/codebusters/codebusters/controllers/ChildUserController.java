package com.codebusters.codebusters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.services.ChildUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/childUser")
public class ChildUserController implements CrudController<ChildUserDTO, Long>{

	@Autowired
	private ChildUserService childUSerService;

	@Override
	public List<ChildUserDTO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ChildUserDTO> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> create(@Valid ChildUserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ChildUserDTO> update(@Valid ChildUserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteById(Long id) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
