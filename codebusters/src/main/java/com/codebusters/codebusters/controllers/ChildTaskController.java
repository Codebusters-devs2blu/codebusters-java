package com.codebusters.codebusters.controllers;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;

import com.codebusters.codebusters.services.ChildTaskService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ChildTaskController implements CrudController<ChildTaskDTO, Long> {

	@Autowired
	private ChildTaskService childTaskService;


	@Override
	public List<ChildTaskDTO> listAll() {
		return null;
	}

	@Override
	public ResponseEntity<ChildTaskDTO> findById(Long aLong) {
		return null;
	}

	@Override
	public ResponseEntity<Object> create(ChildTaskDTO dto) {
		return null;
	}

	@Override
	public ResponseEntity<ChildTaskDTO> update(ChildTaskDTO dto) {
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteById(Long aLong) {
		return null;

	}
}
