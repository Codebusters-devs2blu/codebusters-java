package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.models.entities.Objective;
import com.codebusters.codebusters.repositories.ObjectiveRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Objective createObjective(@Valid ObjectiveDTO objectiveDTO) {
		Objective newObjective = new Objective();
		newObjective.setObjectiveValue(objectiveDTO.getObjectiveValue());
		newObjective.setCurrentAmount(objectiveDTO.getCurrentAmount());
		newObjective.setDescription(objectiveDTO.getDescription());

		ChildUserDTO childUserDTO = objectiveDTO.getChildUserDTO();
		if (childUserDTO != null) {
			ChildUser childUser = modelMapper.map(childUserDTO, ChildUser.class);
			newObjective.setChildUser(childUser);
		}

		return objectiveRepository.save(newObjective);
	}

	public Objective updateObjective(@Valid ObjectiveDTO objectiveDTO) {
		Objective existingObjective = objectiveRepository.findById(objectiveDTO.getId())
				.orElseThrow(() -> new RuntimeException("Objective not found"));

		existingObjective.setObjectiveValue(objectiveDTO.getObjectiveValue());
		existingObjective.setDescription(objectiveDTO.getDescription());
		existingObjective.setCurrentAmount(objectiveDTO.getCurrentAmount());

		ChildUserDTO childUserDTO = objectiveDTO.getChildUserDTO();
		if (childUserDTO != null) {
			ChildUser childUser = modelMapper.map(childUserDTO, ChildUser.class);
			existingObjective.setChildUser(childUser);
		}

		return objectiveRepository.save(existingObjective);
	}

	public boolean deleteById(Long id) {
		try {
			Optional<Objective> optionalObjective = objectiveRepository.findById(id);

			if (optionalObjective.isPresent()) {
				objectiveRepository.deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
