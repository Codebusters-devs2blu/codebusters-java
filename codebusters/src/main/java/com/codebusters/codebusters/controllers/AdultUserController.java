package com.codebusters.codebusters.controllers;


import java.util.List;



import com.codebusters.codebusters.models.entities.AdultUser;
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
public class AdultUserController /*implements CrudController<AdultUserDTO, Long>*/ {


	private AdultUserService service;

	private final ModelMapper modelMapper;

	@Autowired
	public AdultUserController(AdultUserService service, ModelMapper modelMapper) {
		this.adultUserService = service;
		this.modelMapper = modelMapper;
	}


	public List<AdultUserDTO> listAll() {
		return service.listAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AdultUserDTO> findById(@PathVariable Long id) {
		AdultUserDTO adultUserDTO = service.findById(id);

		if (adultUserDTO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(adultUserDTO);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@Valid @RequestBody AdultUserDTO adultUserDTO) {
		AdultUser createdAdultUser = service.createAdultUser(adultUserDTO);

		// Mapear o resultado para um AdultUserDTO
		AdultUserDTO createdAdultUserDTO = modelMapper.map(createdAdultUser, AdultUserDTO.class);

		return ResponseEntity.status(201).body(createdAdultUserDTO);
	}



/*	@PostMapping
	public ResponseEntity<Object> create(@Valid AdultUserDTO dto) {
		 try {
			 //adultUserService.addAdultUsers(dto);

	            return ResponseEntity.ok("");
	        } catch (Exception e) {
	            // Trate exceções e retorne uma resposta adequada em caso de erro
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }

	}*/


/*	@Override
	@PutMapping(value= "/update")
	public ResponseEntity<AdultUserDTO> update(@Valid AdultUserDTO dto) {
		try {
			//adultUserService.save(dto);
		}catch (Exception e) {
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;

	public ResponseEntity<Object> create(AdultUserDTO dto) {
		return ResponseEntity.ok().body(createAdult());

		/*
		try {
			// adultUserService.create(dto);
			return ResponseEntity.ok("Cadastrado");
		} catch (Exception e) {
			// Trate exceções e retorne uma resposta adequada em caso de erro
			return ResponseEntity.badRequest().body(e.getMessage());
		}*/



	@PutMapping(value = "/update")
	public ResponseEntity<AdultUserDTO> update(@Valid @RequestBody AdultUserDTO dto) {
		try {
			AdultUser updatedAdultUser = service.updateAdultUser(dto);
			AdultUserDTO updatedDto = modelMapper.map(updatedAdultUser, AdultUserDTO.class);
			return ResponseEntity.ok(updatedDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}




}