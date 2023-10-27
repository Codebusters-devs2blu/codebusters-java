package com.codebusters.codebusters.controllers;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
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
	public ResponseEntity<Object> create(@RequestBody @Valid ChildTaskDTO dto) {
		return ResponseEntity.ok().build();
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ChildTaskDTO> update(@RequestBody @Valid ChildTaskDTO dto) {
		return ResponseEntity.ok(dto);
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		return ResponseEntity.noContent().build();
	}
}
