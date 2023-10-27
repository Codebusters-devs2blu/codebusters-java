package com.codebusters.codebusters.controllers;

import java.util.List;

import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.ChildUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.models.dtos.AdultUserDTO;
import com.codebusters.codebusters.services.AdultUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/adultuser")
public class AdultUserController /* implements CrudController<AdultUserDTO, Long> */ {
	@Autowired
	private AdultUserService service;
	@Autowired
	private final ModelMapper mapper;

	@Autowired
<<<<<<< HEAD
	public AdultUserController(AdultUserService service, ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
=======
	public AdultUserController(AdultUserService service, ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
>>>>>>> 5d0e6c5773255b7e0e586f05c64257d211906896
	}

	@GetMapping(value = "/listall")
	public List<AdultUserDTO> listAll() {
		return service.listAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AdultUserDTO> findById(@PathVariable Long id) throws Exception {
		AdultUserDTO adultUserDTO = service.findById(id);

		if (adultUserDTO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(adultUserDTO);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@RequestBody AdultUserDTO adultUserDTO) {
		
		AdultUser createdAdultUser = service.createAdultUser(adultUserDTO);

		// Mapear o resultado para um AdultUserDTO
		AdultUserDTO createdAdultUserDTO = mapper.map(createdAdultUser, AdultUserDTO.class);

		return ResponseEntity.status(201).body(createdAdultUserDTO);
	}

	@PutMapping("/update")
	public ResponseEntity<AdultUserDTO> updateAdultUser(
			@Valid @RequestBody AdultUserDTO adultUserDTO) {
		System.out.println(adultUserDTO);
		// Converta o AdultUserDTO para AdultUser
		AdultUser adultUser = mapper.map(adultUserDTO, AdultUser.class);

		// Chame o método de serviço com o objeto apropriado
		AdultUser updatedAdultUser = service.updateAdultUser(adultUser);

		// Converta o AdultUser atualizado de volta para AdultUserDTO
		AdultUserDTO updatedAdultUserDTO = mapper.map(updatedAdultUser, AdultUserDTO.class);

		if (updatedAdultUserDTO != null) {
			return ResponseEntity.ok(updatedAdultUserDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/{adultUserId}/childuser")
	public ResponseEntity<ChildUser> createChildUser(@PathVariable Long adultUserId,
			@RequestBody ChildUserDTO childUserDTO) {
		ChildUser createdChildUser = service.createChildUser(adultUserId, childUserDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdChildUser);
	}

	@PutMapping("/active/{id}")
	public ResponseEntity<Object> statusUserInactive(@PathVariable Long id) {
		try {
			service.inactiveUser(id);
			return ResponseEntity.ok("Inactive");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

}