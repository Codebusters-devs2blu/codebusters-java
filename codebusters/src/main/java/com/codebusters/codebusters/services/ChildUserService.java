package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.*;
import com.codebusters.codebusters.models.entities.*;
import com.codebusters.codebusters.repositories.AdultUserRepository;
import com.codebusters.codebusters.repositories.ChildTaskRepository;
import com.codebusters.codebusters.repositories.ChildUserRepository;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.codebusters.codebusters.repositories.ChildUserRepository;

@Service
public class ChildUserService {

	@Autowired
	private ChildUserRepository childUserRepository;

	@Autowired
	AdultUserRepository adultUserRepository;

	@Autowired
	UserService userService;

	@Autowired
	private WalletService walletService;

	@Autowired
	ModelMapper mapper;

	public List<ChildUserDTO> listAll() {
		return childUserRepository.findAll().stream().map(childUser -> mapper.map(childUser, ChildUserDTO.class))
				.toList();
	}

	public ChildUserDTO findById(Long id) {
		Optional<ChildUser> optional = childUserRepository.findById(id);
		ChildUserDTO childUserDTO = null;

		if (optional.isPresent()) {
			childUserDTO = mapper.map(optional.get(), ChildUserDTO.class);
		}
		return childUserDTO;

	}

	@Transactional
	public ChildUser createChildUser(Long guardianId, ChildUserDTO childUserDTO) {
		// Obtenha o AdultUser (guardian) com base no ID fornecido
		AdultUser guardian = adultUserRepository.findById(guardianId)
				.orElseThrow(() -> new EntityNotFoundException("Guardian not found with ID: " + guardianId));

		// Crie um novo User usando o UserService
		UserDTO userDTO = childUserDTO.getUser();

		if (userDTO == null) {
			throw new IllegalArgumentException("UserDTO não pode ser nulo");
		}

		userDTO.setActive(true);

		UserDTO createdUserDTO = userService.create(userDTO);

		// Crie uma nova Wallet usando o WalletService
		WalletDTO walletDTO = new WalletDTO();
		walletDTO.setMoney(0.0);
		WalletDTO createdWalletDTO = walletService.create(walletDTO);

		// Verifique se a conversão foi bem-sucedida
		if (createdUserDTO == null || createdWalletDTO == null) {
			throw new IllegalArgumentException("Falha na conversão de UserDTO ou WalletDTO");
		}

		// Crie o novo ChildUser com as informações necessárias, convertendo as DTOs em
		// entidades
		ChildUser newChildUser = new ChildUser();
		newChildUser.setUser(mapper.map(createdUserDTO, User.class));
		newChildUser.setWallet(mapper.map(createdWalletDTO, Wallet.class));
		newChildUser.setBirthday(childUserDTO.getBirthday());
		newChildUser.setFamily(childUserDTO.getFamily());
		newChildUser.setGuardian(guardian);

		// Salve o novo ChildUser no repositório
		return childUserRepository.save(newChildUser);
	}

	public void inactiveUser(Long id) {
		userService.updateInactive(id);

	}

	public ChildUserDTO update(ChildUserDTO dto) {
	
		Long childUserId = dto.getId();
		ChildUser existingchildUser = childUserRepository.findById(childUserId)
				.orElseThrow(() -> new EntityNotFoundException("AdultUser not found with ID: " + childUserId));

		
		
		System.out.println(dto);
		System.out.println(existingchildUser);
		if (dto.getBirthday() != null) {
			existingchildUser.setBirthday(dto.getBirthday());
		}
		if (dto.getFamily() != null) {
			existingchildUser.setFamily(dto.getFamily());
		}
		if(dto.getWallet()!=null) {
			Wallet wallet = mapper.map(dto.getWallet(), Wallet.class);
			existingchildUser.setWallet(wallet);
		}
		if(dto.getGuardian()!=null) {
			AdultUser adultUser = mapper.map(dto.getGuardian(), AdultUser.class);
			existingchildUser.setGuardian(adultUser);
		}
		if(dto.getUser()!=null) {
			User user = mapper.map(dto.getUser(), User.class);
			existingchildUser.setUser(user);
		}
		
	
		
		// Adicione validações para campos nulos
		if (dto.getUser() != null) {
			
			UserDTO userDTO = mapper.map(dto.getUser(), UserDTO.class);
			userDTO.setId(existingchildUser.getUser().getId());
		
			UserDTO updatedUserDTO = userService.update(userDTO);
			
			
			User user = mapper.map(updatedUserDTO, User.class);
			existingchildUser.setUser(user);
			
			
			if (updatedUserDTO == null) {
				throw new EntityNotFoundException("User not found with ID: " + dto.getUser().getId());
			}

			// Verifique o campo isActive e atualize-o se não for nulo
			if (userDTO.getActive() != null) {
				dto.getUser().setActive(userDTO.getActive());
			}
		
			
		}
		
		ChildUser updatedAdultUser = childUserRepository.save(existingchildUser);
		ChildUserDTO childUserDTO =mapper.map(existingchildUser, ChildUserDTO.class);
		WalletDTO wallet2 = mapper.map(existingchildUser.getWallet(), WalletDTO.class);
		childUserDTO.setWallet(wallet2);
		
		
		
		return childUserDTO ;

	}

}