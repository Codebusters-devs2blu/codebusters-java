package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.entities.ChildTask;
import com.codebusters.codebusters.repositories.ChildTaskRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChildTaskService {

	@Autowired
	private ChildTaskRepository childTaskRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ChildTaskDTO> listAll() {
		List<ChildTask> childTasks = childTaskRepository.findAll();
		return childTasks.stream()
				.map(childTask -> modelMapper.map(childTask, ChildTaskDTO.class))
				.collect(Collectors.toList());
	}

	public ChildTaskDTO findById(Long id) {
		Optional<ChildTask> optional = childTaskRepository.findById(id);
		ChildTaskDTO childTask = null;

		if (optional.isPresent()) {
			childTask = modelMapper.map(optional.get(), ChildTaskDTO.class);
		}

		return childTask;
	}

	public ResponseEntity<ChildTaskDTO> create(@Valid ChildTaskDTO childTaskDTO) {
		ChildTask childTask = modelMapper.map(childTaskDTO, ChildTask.class);
		ChildTask createdChildTask = childTaskRepository.save(childTask);
		ChildTaskDTO createdChildTaskDTO = modelMapper.map(createdChildTask, ChildTaskDTO.class);
		return new ResponseEntity<>(createdChildTaskDTO, HttpStatus.CREATED);
	}

	public ResponseEntity<ChildTaskDTO> update(@Valid ChildTaskDTO childTaskDTO) {
		ChildTask childTask = modelMapper.map(childTaskDTO, ChildTask.class);
		if (childTaskRepository.existsById(childTask.getId())) {
			ChildTask updatedChildTask = childTaskRepository.save(childTask);
			ChildTaskDTO updatedChildTaskDTO = modelMapper.map(updatedChildTask, ChildTaskDTO.class);
			return new ResponseEntity<>(updatedChildTaskDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteById(Long id) {
		childTaskRepository.deleteById(id);
	}
}
