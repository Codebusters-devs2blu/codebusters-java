package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.entities.ChildTask;
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

	public ObjectiveDTO findById(Long id) {
		Optional<Objective> optional = objectiveRepository.findById(id);
		ObjectiveDTO objectiveDTO = null;

		if (optional.isPresent()) {
			objectiveDTO = modelMapper.map(optional.get(), ObjectiveDTO.class);
		}
		return objectiveDTO;
	}

	public ObjectiveDTO create(@Valid ObjectiveDTO objectiveDTO) {
		Objective objective = modelMapper.map(objectiveDTO, Objective.class);
		
		Objective createdObjective = objectiveRepository.save(objective);
		
		ObjectiveDTO createdObjectiveDTO = modelMapper.map(createdObjective, ObjectiveDTO.class);
		return createdObjectiveDTO;
	}

	public ObjectiveDTO update(@Valid ObjectiveDTO objectiveDTO) {
		Objective objective = modelMapper.map(objectiveDTO, Objective.class);
		if (objectiveRepository.existsById(objective.getId())) {
			Objective updatedObjective = objectiveRepository.save(objective);
			ObjectiveDTO updatedObjectiveDTO = modelMapper.map(updatedObjective, ObjectiveDTO.class);
			return updatedObjectiveDTO;
		}  else {
			return null;
		}
	}

	public void deleteById(Long id) throws Exception {
		try {
			objectiveRepository.deleteById(id);
		}catch (Exception e) {
			throw new Exception("Não foi possivel deletar Objective com esse id");
		}
	}
	public void deleteChildUser(Long id) throws Exception {
		
		
		//	 objectiveRepository.deleteChildUser(id);

		
		
	}
}
