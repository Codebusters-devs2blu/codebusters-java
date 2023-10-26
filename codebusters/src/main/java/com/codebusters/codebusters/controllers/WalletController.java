package com.codebusters.codebusters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.services.WalletService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/wallet")
public class WalletController implements CrudController<WalletDTO, Long> {

	@Autowired
	private WalletService walletService;

	@Override
	public List<WalletDTO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<WalletDTO> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> create(@Valid WalletDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<WalletDTO> update(@Valid WalletDTO dto) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteById(Long id) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
}
