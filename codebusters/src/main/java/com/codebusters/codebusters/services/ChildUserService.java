package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.entities.ChildTask;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.repositories.ChildTaskRepository;
import com.codebusters.codebusters.repositories.ChildUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChildUserService {

	@Autowired
	private ChildUserRepository childUserRepository;
	
	@Autowired
	ModelMapper mapper;

	public List<ChildUserDTO> listAll() {
        return childUserRepository.findAll().stream()
				.map(childUser -> mapper.map(childUser, ChildUserDTO.class)).toList();
	}

	public ChildUserDTO findById(Long id) {
		Optional<ChildUser> optional = childUserRepository.findById(id);
		ChildUserDTO childUserDTO = null;

		if (optional.isPresent()) {
			childUserDTO = mapper.map(optional.get(), ChildUserDTO.class);
		}
		return childUserDTO;
	}
}
