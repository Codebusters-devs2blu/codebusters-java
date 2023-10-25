package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.entities.Objective;
import com.codebusters.codebusters.repositories.ObjectiveRepository;
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
public class ObjectiveService {

	@Autowired
	private ObjectiveRepository objectiveRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ObjectiveDTO> listAll() {
		List<Objective> objectives = objectiveRepository.findAll();
		return objectives.stream()
				.map(objective -> modelMapper.map(objective, ObjectiveDTO.class))
				.collect(Collectors.toList());
	}

	public ResponseEntity<ObjectiveDTO> findById(Long id) {
		Optional<Objective> objectiveOptional = objectiveRepository.findById(id);
		if (objectiveOptional.isPresent()) {
			ObjectiveDTO objectiveDTO = modelMapper.map(objectiveOptional.get(), ObjectiveDTO.class);
			return new ResponseEntity<>(objectiveDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ObjectiveDTO> create(@Valid ObjectiveDTO objectiveDTO) {
		Objective objective = modelMapper.map(objectiveDTO, Objective.class);
		Objective createdObjective = objectiveRepository.save(objective);
		ObjectiveDTO createdObjectiveDTO = modelMapper.map(createdObjective, ObjectiveDTO.class);
		return new ResponseEntity<>(createdObjectiveDTO, HttpStatus.CREATED);
	}

	public ResponseEntity<ObjectiveDTO> update(@Valid ObjectiveDTO objectiveDTO) {
		Objective objective = modelMapper.map(objectiveDTO, Objective.class);
		if (objectiveRepository.existsById(objective.getId())) {
			Objective updatedObjective = objectiveRepository.save(objective);
			ObjectiveDTO updatedObjectiveDTO = modelMapper.map(updatedObjective, ObjectiveDTO.class);
			return new ResponseEntity<>(updatedObjectiveDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteById(Long id) {
		objectiveRepository.deleteById(id);
	}
}
