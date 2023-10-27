package com.codebusters.codebusters.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codebusters.codebusters.enums.ReleaseType;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.dtos.ReleaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.services.WalletService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/wallet")
public class WalletController implements CrudController<WalletDTO, Long> {

	@Autowired
	private WalletService service;

	@Override
	@GetMapping(value = "/listall")
	public List<WalletDTO> listAll() {
		return service.listAll();
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<WalletDTO> findById(@PathVariable Long id) {
		WalletDTO wallet = service.findById(id);

		if (wallet == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(wallet);
	}

	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@Valid @RequestBody WalletDTO dto) {
		WalletDTO walletDTO =  service.create(dto);
		return ResponseEntity.status(201).body(walletDTO);
		 
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<WalletDTO> update( @RequestBody  WalletDTO dto) {
		WalletDTO walletDTO = service.update(dto);
		return ResponseEntity.ok(walletDTO);
	}

	@Override
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		return ResponseEntity.noContent().build();
	}
	
}