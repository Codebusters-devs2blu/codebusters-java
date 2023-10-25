package com.codebusters.codebusters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.models.dtos.AdultUserDTO;
import com.codebusters.codebusters.services.AdultUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/adultUser")
public class AdultUserController {

	@Autowired
	private AdultUserService adultUserService;

	@GetMapping(value = "/listAll")
	public List<AdultUserDTO> listAll() {
		return adultUserService.listAll();
	}

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody AdultUserDTO adultUserDTO) {
		return null;

	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		try {
			adultUserService.deleteBuyer(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AdultUserDTO> findById(Long id) {
		AdultUserDTO productStockDTO = adultUserService.findById(id);

		if (productStockDTO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(productStockDTO);
	}
}
