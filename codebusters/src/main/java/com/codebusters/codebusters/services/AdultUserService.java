package com.codebusters.codebusters.services;

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
	private final WalletService walletService;
	private final ModelMapper modelMapper;

	@Autowired
	ModelMapper mapper;

	@Autowired
	public AdultUserService(AdultUserRepository adultUserRepository, UserService userService,
			WalletService walletService, ModelMapper modelMapper) {
		this.adultUserRepository = adultUserRepository;
		this.userService = userService;
		this.walletService = walletService;
		this.modelMapper = modelMapper;
	}

	public AdultUserDTO findById(Long id) throws Exception {
		try {
			Optional<AdultUser> adultUserOptional = adultUserRepository.findById(id);
			AdultUserDTO adultUserDTO = mapper.map(adultUserOptional.get(), AdultUserDTO.class);
			return adultUserDTO;
		} catch (Exception e) {
			throw new Exception("Não ha registro de venda com esse id");
		}

	}

}
