package com.codebusters.codebusters.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codebusters.codebusters.enums.ReleaseType;
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
	private ReleaseService releaseService;

	@Override
	@GetMapping(value = "/listall")
	public List<ReleaseDTO> listAll() {
		ReleaseDTO mock1 = new ReleaseDTO();
		Date currentDate = new Date();
		Timestamp defaultTimestamp = new Timestamp(currentDate.getTime());
		mock1.setDate(defaultTimestamp);
		mock1.setId(1L);
		mock1.setDescription("cumpriu tarefa x");
		mock1.setType(ReleaseType.IN);
		WalletDTO walletMock = new WalletDTO();
		walletMock.setId(1L);
		mock1.setWalletDTO(walletMock);
		ReleaseDTO mock2 = new ReleaseDTO();
		Date currentDate2 = new Date();
		Timestamp defaultTimestamp2 = new Timestamp(currentDate2.getTime());
		mock2.setDate(defaultTimestamp);
		mock2.setId(2L);
		mock2.setDescription("Pagamento por tarefa x");
		mock2.setType(ReleaseType.OUT);
		WalletDTO walletMock2 = new WalletDTO();
		walletMock2.setId(2L);
		mock2.setWalletDTO(walletMock2);
		List<ReleaseDTO> releaseList = new ArrayList<>();
		releaseList.add(mock1);
		releaseList.add(mock2);
		return releaseList;
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReleaseDTO> findById(@PathVariable Long id) {
		ReleaseDTO mock = new ReleaseDTO();
		mock.setId(id);
		return ResponseEntity.ok(mock);
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
