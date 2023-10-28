package com.codebusters.codebusters.controllers;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.entities.Objective;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codebusters.codebusters.services.ObjectiveService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/objective")
public class ObjectiveController implements CrudController<ObjectiveDTO, Long> {

	private ObjectiveService service;
	private final ModelMapper modelMapper;

	public ObjectiveController(ObjectiveService service, ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
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
	public ResponseEntity<Object> create(@RequestBody ObjectiveDTO objectiveDTO) {

		Objective createdObjective = service.createObjective(objectiveDTO);

		ObjectiveDTO createdObjectiveDTO = modelMapper.map(createdObjective, ObjectiveDTO.class);

		return ResponseEntity.status(201).body(createdObjectiveDTO);
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ObjectiveDTO> update(@Valid @RequestBody ObjectiveDTO dto) {
		try{
			Objective updatedObjective = service.updateObjective(dto);
			ObjectiveDTO updatedObjectiveDTO = modelMapper.map(updatedObjective, ObjectiveDTO.class);
			return ResponseEntity.ok(updatedObjectiveDTO);
		}catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
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