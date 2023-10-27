package com.codebusters.codebusters.services;


import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.models.entities.Wallet;
import com.codebusters.codebusters.repositories.AdultUserRepository;
import com.codebusters.codebusters.repositories.UserRepository;
import jakarta.transaction.Transactional;

import java.util.Optional;

import com.codebusters.codebusters.repositories.AdultUserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebusters.codebusters.models.dtos.AdultUserDTO;

import com.codebusters.codebusters.models.entities.AdultUser;

@Service
public class AdultUserService {

	@Autowired
	private final AdultUserRepository adultUserRepository;

	private final UserService userService;
	private final UserRepository userRepository;
	private final WalletService walletService;
	private final ModelMapper modelMapper;

	@Autowired
	public AdultUserService(AdultUserRepository adultUserRepository, UserService userService, UserRepository userRepository, WalletService walletService, ModelMapper modelMapper) {
		this.adultUserRepository = adultUserRepository;
		this.userService = userService;
		this.userRepository = userRepository;
		this.walletService = walletService;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public AdultUser createAdultUser(AdultUserDTO adultUserDTO) {
		// Crie um novo User usando o UserService
		UserDTO userDTO = adultUserDTO.getUser();

		System.out.println(adultUserDTO.getUser());

		if (userDTO == null) {
			throw new IllegalArgumentException("UserDTO não pode ser nulo");
		}

		UserDTO createdUserDTO = userService.create(userDTO);

		// Crie uma nova Wallet usando o WalletService
		WalletDTO walletDTO = new WalletDTO();
		walletDTO.setMoney(0.0);
		WalletDTO createdWalletDTO = walletService.create(walletDTO);

		// Verifique se a conversão foi bem-sucedida
		if (createdUserDTO == null || createdWalletDTO == null) {
			throw new IllegalArgumentException("Falha na conversão de UserDTO ou WalletDTO");
		}

		// Crie o novo AdultUser com as informações necessárias, convertendo as DTOs em entidades
		AdultUser newAdultUser = new AdultUser();
		newAdultUser.setUser(modelMapper.map(createdUserDTO, User.class));
		newAdultUser.setWallet(modelMapper.map(createdWalletDTO, Wallet.class));
		newAdultUser.setEmail(adultUserDTO.getEmail());
		newAdultUser.setJob(adultUserDTO.getJob());
		newAdultUser.setCpf(adultUserDTO.getCpf());

		// Salve o novo AdultUser no repositório
		return adultUserRepository.save(newAdultUser);
	}



	@Transactional
	public AdultUser updateAdultUser(AdultUserDTO adultUserDTO) {
		// Encontre o AdultUser existente no repositório
		AdultUser existingAdultUser = adultUserRepository.findById(adultUserDTO.getId())
				.orElseThrow(() -> new RuntimeException("AdultUser not found"));

		// Atualize as informações do User (nome, senha e nickname)
		UserDTO userDTO = adultUserDTO.getUser();
		User existingUser = existingAdultUser.getUser();
		existingUser.setName(userDTO.getName());
		existingUser.setPassword(userDTO.getPassword());
		existingUser.setNickname(userDTO.getNickname());

		// Atualize as informações do AdultUser (email e job)
		existingAdultUser.setEmail(adultUserDTO.getEmail());
		existingAdultUser.setJob(adultUserDTO.getJob());

		// Salve as alterações no repositório
		return adultUserRepository.save(existingAdultUser);
	}


	public AdultUserDTO findById(Long id) throws Exception {
		try {
			Optional<AdultUser> adultUserOptional = adultUserRepository.findById(id);
			AdultUserDTO adultUserDTO = modelMapper.map(adultUserOptional.get(), AdultUserDTO.class);
			return adultUserDTO;
		} catch (Exception e) {
			throw new Exception("Não ha registro de venda com esse id");
		}

	}

}
