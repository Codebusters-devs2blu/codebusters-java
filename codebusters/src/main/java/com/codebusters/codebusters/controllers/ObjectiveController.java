package com.codebusters.codebusters.controllers;

import com.codebusters.codebusters.enums.Family;
import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.AdultUserDTO;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.dtos.ReleaseDTO;
import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.models.entities.User;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.services.ObjectiveService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/objective")
public class ObjectiveController implements CrudController<ObjectiveDTO, Long> {
	@Autowired
	private ObjectiveService service;

	private final ModelMapper mapper;

	public ObjectiveController(ObjectiveService service, ModelMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	@GetMapping(value = "/listAll")
	public List<ObjectiveDTO> listAll() {
		return service.listAll();
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ObjectiveDTO> findById(@PathVariable Long id) {
		ObjectiveDTO objective = service.findById(id);

		if (objective == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(objective);
	}

	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@RequestBody ObjectiveDTO dto) {
		ObjectiveDTO createdAdultUser = service.create(dto);
		return ResponseEntity.status(201).body(createdAdultUser);
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ObjectiveDTO> update(@RequestBody ObjectiveDTO dto) {
		ObjectiveDTO objectiveDTO = service.update(dto);
		return ResponseEntity.ok(objectiveDTO);
	}

	@Override
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {

		try {
			service.deleteById(id);
			return ResponseEntity.ok("deletado");
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}

	}

}