package com.codebusters.codebusters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.services.ObjectiveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/objective")
public class ObjectiveController  implements CrudController<ObjectiveDTO, Long>{
	
	@Autowired
	private ObjectiveService objectiveService;

	@Override
	public List<ObjectiveDTO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ObjectiveDTO> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> create(@Valid ObjectiveDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ObjectiveDTO> update(@Valid ObjectiveDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteById(Long id) {
		return null;
		// TODO Auto-generated method stub
		
	} 
}
