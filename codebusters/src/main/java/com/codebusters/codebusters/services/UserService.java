package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.repositories.UserRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<UserDTO> listAll() {
		return userRepository.findAll().stream()
				.map(user -> modelMapper.map(user, UserDTO.class)).toList();
	}

	public UserDTO findById(Long id) {
		Optional<User> optional = userRepository.findById(id);
		UserDTO userDTO = null;

		if (optional.isPresent()) {
			userDTO = modelMapper.map(optional.get(), UserDTO.class);
		}
		return userDTO;
	}

	public UserDTO create(@Valid UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User createdUser = userRepository.save(user);
		return modelMapper.map(createdUser, UserDTO.class);
	}

	public UserDTO update(@Valid UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		if (userRepository.existsById(user.getId())) {
			User updatedUser = userRepository.save(user);
			return modelMapper.map(updatedUser, UserDTO.class);
		} else {
			return null; // Ou lançar uma exceção adequada, por exemplo, UserNotFoundException
		}
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
