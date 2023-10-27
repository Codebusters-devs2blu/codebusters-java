package com.codebusters.codebusters.controllers;

import java.util.List;

import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.services.UserService;




import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/user")
public class UserController implements CrudController<UserDTO, Long> {
	@Autowired

	private UserService service;

	@Override
	@GetMapping(value = "/listall")
	public List<UserDTO> listAll() {
		return service.listAll();
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(Long id) {
		UserDTO user = service.findById(id);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(user);
	}

	@Override
	public ResponseEntity<Object> create(@Valid UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UserDTO> update(@Valid UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteById(Long id) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
