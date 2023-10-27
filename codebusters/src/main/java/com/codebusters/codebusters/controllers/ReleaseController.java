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
	public ResponseEntity<Object> create(@RequestBody ReleaseDTO dto) {
		
		return ResponseEntity.ok(service.create(dto));
		
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ReleaseDTO> update(@RequestBody ReleaseDTO dto) {
		ReleaseDTO releaseDTO = service.update(dto);
		
		return ResponseEntity.ok(releaseDTO);
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		try {
			service.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}