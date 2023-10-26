package com.codebusters.codebusters.services;

import java.util.List;
import java.util.Optional;

import com.codebusters.codebusters.models.dtos.*;
import com.codebusters.codebusters.models.entities.*;
import com.codebusters.codebusters.repositories.AdultUserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AdultUserService {
	@Autowired
	private final AdultUserRepository adultUserRepository;
	
	private final UserService userService;
	private final WalletService walletService;
	private final ModelMapper modelMapper;
	
	@Autowired
	ModelMapper mapper;

	@Autowired
	public AdultUserService(AdultUserRepository adultUserRepository, UserService userService, WalletService walletService, ModelMapper modelMapper) {
		this.adultUserRepository = adultUserRepository;
		this.userService = userService;
		this.walletService = walletService;
		this.modelMapper = modelMapper;
	}

	public List<AdultUserDTO> listAll() {
		return adultUserRepository.findAll().stream()
				.map(adultUser -> mapper.map(adultUser, AdultUserDTO.class)).toList();
	}
	public AdultUserDTO findById(Long id) {
		Optional<AdultUser> optional = adultUserRepository.findById(id);
		AdultUserDTO adultUserDTO = null;

		if (optional.isPresent()) {
			adultUserDTO = mapper.map(optional.get(), AdultUserDTO.class);
		}
		return adultUserDTO;
	}

	













}
