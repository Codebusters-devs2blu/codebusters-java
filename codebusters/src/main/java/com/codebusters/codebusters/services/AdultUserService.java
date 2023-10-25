package com.codebusters.codebusters.services;

import java.util.List;

import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.models.entities.Wallet;
import com.codebusters.codebusters.repositories.AdultUserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.codebusters.codebusters.models.dtos.AdultUserDTO;



@Service
public class AdultUserService {

	private final AdultUserRepository adultUserRepository;
	private final UserService userService;
	private final WalletService walletService;
	private final ModelMapper modelMapper;

	@Autowired
	public AdultUserService(AdultUserRepository adultUserRepository, UserService userService, WalletService walletService, ModelMapper modelMapper) {
		this.adultUserRepository = adultUserRepository;
		this.userService = userService;
		this.walletService = walletService;
		this.modelMapper = modelMapper;
	}

	













}
