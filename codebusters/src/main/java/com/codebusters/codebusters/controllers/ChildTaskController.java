package com.codebusters.codebusters.controllers;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import com.codebusters.codebusters.services.ChildTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class ChildTaskController implements CrudController<ChildTaskDTO, Long> {

	@Autowired
	private ChildTaskService childTaskService;


	@Override
	@GetMapping
	public List<ChildTaskDTO> listAll() {
		List<ChildTaskDTO> childTasks = childTaskService.getAllChildTasks();
		return childTasks;
	}

	@Override
	@GetMapping("/{find-childtask}")
	public ResponseEntity<ChildTaskDTO> findById(Long id) {
		try {
			//ChildTaskDTO childTask = childTaskService.getChildTaskById(id);
			/*if (childTask != null) {
				return ResponseEntity.ok(childTask);
			} else {
				return ResponseEntity.notFound().build();
			}*/
		} catch (Exception e) {
			// Registre a exceção para fins de depuração
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	@PostMapping
	public ResponseEntity<Object> create(@Valid ChildTaskDTO dto) {
		try {
			//childTaskService.addChildTask(dto);
			return ResponseEntity.ok("");
		} catch (Exception e) {
			// Trate exceções e retorne uma resposta adequada em caso de erro
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@Override
	@PutMapping(value = "/{update-childtask}")
	public ResponseEntity<ChildTaskDTO> update(@Valid ChildTaskDTO dto) {
		try {
			//childTaskService.saveChildTask(id, dto);

		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;
	}

	@Override
	@DeleteMapping(value = "/{delete-childtask}")
	public ResponseEntity<Object> deleteById(Long id) {
		try {
			//childTaskService.deleteChildTaskById(id);
			return ResponseEntity.ok("deletado");
		} catch (Exception e) {
			// Trate exceções e retorne uma resposta adequada em caso de erro
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
