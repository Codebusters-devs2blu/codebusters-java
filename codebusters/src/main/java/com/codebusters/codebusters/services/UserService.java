package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.repositories.UserRepository;
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
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<UserDTO> listAll() {
		List<User> users = userRepository.findAll();
		return users.stream()
				.map(user -> modelMapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
	}

	public ResponseEntity<UserDTO> findById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			UserDTO userDTO = modelMapper.map(userOptional.get(), UserDTO.class);
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<UserDTO> create(@Valid UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User createdUser = userRepository.save(user);
		UserDTO createdUserDTO = modelMapper.map(createdUser, UserDTO.class);
		return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
	}

	public ResponseEntity<UserDTO> update(@Valid UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		if (userRepository.existsById(user.getId())) {
			User updatedUser = userRepository.save(user);
			UserDTO updatedUserDTO = modelMapper.map(updatedUser, UserDTO.class);
			return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
