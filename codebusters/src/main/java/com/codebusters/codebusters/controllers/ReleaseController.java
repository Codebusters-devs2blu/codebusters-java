package com.codebusters.codebusters.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codebusters.codebusters.enums.ReleaseType;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ReleaseDTO;
import com.codebusters.codebusters.services.ReleaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/release")
public class ReleaseController  implements CrudController<ReleaseDTO, Long> {

	@Autowired
	private ReleaseService service;

	@Override
	@GetMapping(value = "/listall")
	public List<ReleaseDTO> listAll() {
		return service.listAll();
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReleaseDTO> findById(@PathVariable Long id) {
		ReleaseDTO release = service.findById(id);

		if (release == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(release);
	}

	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@Valid @RequestBody ReleaseDTO dto) {
		return ResponseEntity.ok().build();
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ReleaseDTO> update(@Valid @RequestBody @PathVariable ReleaseDTO dto) {
		return ResponseEntity.ok(dto);
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		return ResponseEntity.noContent().build();
	}
}
