package com.codebusters.codebusters.controllers;

import com.codebusters.codebusters.enums.TaskStatus;
import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.AdultUserDTO;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.ReleaseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import com.codebusters.codebusters.services.ChildTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class ChildTaskController implements CrudController<ChildTaskDTO, Long> {

	@Autowired
	private ChildTaskService childTaskService;

	@Override
	@GetMapping(value = "/listall")
	public List<ChildTaskDTO> listAll() {
		ChildTaskDTO mock1 = new ChildTaskDTO();
		ChildTaskDTO mock2 = new ChildTaskDTO();

		mock1.setId(1L);
		mock2.setId(2L);

		mock1.setTaskValue(2.00);
		mock2.setTaskValue(4.00);

		mock1.setStatus(TaskStatus.PENDING);
		mock2.setStatus(TaskStatus.COMPLETE);

		mock1.setDescription("Lavar louça");
		mock2.setDescription("Varrer casa");

		ChildUserDTO childMock1 = new ChildUserDTO();
		childMock1.setId(1L);
		mock1.setChildUserDTO(childMock1);
		ChildUserDTO childMock2 = new ChildUserDTO();
		childMock2.setId(2L);
		mock2.setChildUserDTO(childMock2);

		AdultUserDTO adultMock1 = new AdultUserDTO();
		adultMock1.setId(1L);
		mock1.setAdultUserDTO(adultMock1);
		AdultUserDTO adultMock2 = new AdultUserDTO();
		adultMock2.setId(2L);
		mock2.setAdultUserDTO(adultMock2);

		List<ChildTaskDTO> childTaskList = new ArrayList<>();
		childTaskList.add(mock1);
		childTaskList.add(mock2);
		return childTaskList;
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChildTaskDTO> findById(@PathVariable Long id) {
		ChildTaskDTO mock = new ChildTaskDTO();
		mock.setId(id);
		return ResponseEntity.ok(mock);
	}

	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@RequestBody @Valid ChildTaskDTO dto) {
		return ResponseEntity.ok().build();
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ChildTaskDTO> update(@RequestBody @Valid ChildTaskDTO dto) {
		return ResponseEntity.ok(dto);
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		return ResponseEntity.noContent().build();

	}
}
