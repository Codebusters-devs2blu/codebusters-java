package com.codebusters.codebusters.controllers;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.entities.ChildTask;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import com.codebusters.codebusters.services.ChildTaskService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.ArrayList;

import java.util.List;

@RestController
@RequestMapping(value = "/api/childtask")
public class ChildTaskController implements CrudController<ChildTaskDTO, Long> {
	@Autowired
	private ChildTaskService service;

	@Override
	@GetMapping(value = "/listall")
	public List<ChildTaskDTO> listAll() {
		return service.listAll();
	}


	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChildTaskDTO> findById(@PathVariable Long id) {
		ChildTaskDTO childTask = service.findById(id);
		if (childTask == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(childTask);
	}


	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@RequestBody  ChildTaskDTO dto) {
		ChildTaskDTO childTaskDTO =  service.create(dto);		
		return ResponseEntity.status(201).body(childTaskDTO);
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ChildTaskDTO> update(@RequestBody @Valid ChildTaskDTO dto) {
		ChildTaskDTO childTaskDTO = service.update(dto);
		return ResponseEntity.ok(childTaskDTO);
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		try {
			service.deleteById(id);
			return ResponseEntity.ok("deletado");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
			
		}
		
	}
}