package com.codebusters.codebusters.services;


import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.models.entities.Wallet;
import com.codebusters.codebusters.repositories.AdultUserRepository;
import com.codebusters.codebusters.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codebusters.codebusters.models.dtos.AdultUserDTO;

@Service
public class AdultUserService {

	@Autowired
	private final AdultUserRepository adultUserRepository;

	@Autowired
	ChildUserService childUserService;

	private final UserService userService;
	private final UserRepository userRepository;
	private final WalletService walletService;
	@Autowired
	private final ModelMapper mapper;

	

	public AdultUserService(AdultUserRepository adultUserRepository, ChildUserService childUserService,
			UserService userService, UserRepository userRepository, WalletService walletService, ModelMapper mapper) {
		super();
		this.adultUserRepository = adultUserRepository;
		this.childUserService = childUserService;
		this.userService = userService;
		this.userRepository = userRepository;
		this.walletService = walletService;
		this.mapper = mapper;
	}


	public List<AdultUserDTO> listAll() {
		return adultUserRepository.findAll().stream()
				.map(adultUser -> mapper.map(adultUser, AdultUserDTO.class)).toList();
	}


	@Transactional
	public AdultUser createAdultUser(AdultUserDTO adultUserDTO) {
		// Crie um novo User usando o UserService
		UserDTO userDTO = adultUserDTO.getUser();
		System.out.println(userDTO);
		//userCria = userService.findById(userDTO.getId());

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

		// Crie o novo AdultUser com as informações necessárias, convertendo as DTOs em entidades
		AdultUser newAdultUser = new AdultUser();
		newAdultUser.setUser(mapper.map(createdUserDTO, User.class));
		newAdultUser.setWallet(mapper.map(createdWalletDTO, Wallet.class));
		newAdultUser.setEmail(adultUserDTO.getEmail());
		newAdultUser.setJob(adultUserDTO.getJob());
		newAdultUser.setCpf(adultUserDTO.getCpf());

		// Salve o novo AdultUser no repositório
		return adultUserRepository.save(newAdultUser);
	}


	/*@Transactional
	public AdultUser updateAdultUser(AdultUser updatedData) {
		// Verifique se o AdultUser existe no banco de dados
		Long adultUserId = updatedData.getId();
		AdultUser existingAdultUser = adultUserRepository.findById(adultUserId)
				.orElseThrow(() -> new EntityNotFoundException("AdultUser not found with ID: " + adultUserId));

		// Atualize apenas os campos que estão presentes no JSON e não são nulos
		if (updatedData.getEmail() != null) {
			existingAdultUser.setEmail(updatedData.getEmail());
		}
		if (updatedData.getJob() != null) {
			existingAdultUser.setJob(updatedData.getJob());
		}

		// Continue verificando e atualizando outros campos conforme necessário

		// Em seguida, atualize o User associado usando o UserService
		UserDTO userDTO = mapper.map(updatedData.getUser(), UserDTO.class);
		UserDTO updatedUserDTO = userService.update(userDTO);


		// Verifique se o User foi atualizado com sucesso
		if (updatedUserDTO == null) {
			throw new EntityNotFoundException("User not found with ID: " + existingAdultUser.getUser().getId());
		}

		// Atualize o AdultUser no banco de dados
		AdultUser updatedAdultUser = adultUserRepository.save(existingAdultUser);

		// Configure o User atualizado no objeto AdultUser
		updatedAdultUser.setUser(mapper.map(updatedUserDTO, User.class));

		return updatedAdultUser;
	}*/

	@Transactional
	public AdultUser updateAdultUser(AdultUser updatedData) {
		// Verifique se o AdultUser existe no banco de dados
		Long adultUserId = updatedData.getId();
		AdultUser existingAdultUser = adultUserRepository.findById(adultUserId)
				.orElseThrow(() -> new EntityNotFoundException("AdultUser not found with ID: " + adultUserId));
		
		// Atualize apenas os campos que estão presentes no JSON e não são nulos
		if (updatedData.getEmail() != null) {
			existingAdultUser.setEmail(updatedData.getEmail());
		}
		if (updatedData.getJob() != null) {
			existingAdultUser.setJob(updatedData.getJob());
		}

		// Adicione validações para campos nulos
		if (updatedData.getUser() != null) {
			
			UserDTO userDTO = mapper.map(updatedData.getUser(), UserDTO.class);
			userDTO.setId(existingAdultUser.getUser().getId());
		
			
			UserDTO updatedUserDTO = userService.update(userDTO);
			System.out.println(updatedUserDTO);

			// Verifique se o User foi atualizado com sucesso
			if (updatedUserDTO == null) {
				throw new EntityNotFoundException("User not found with ID: " + existingAdultUser.getUser().getId());
			}

			// Configure o User atualizado no objeto AdultUser
			existingAdultUser.setUser(mapper.map(updatedUserDTO, User.class));

			// Verifique o campo isActive e atualize-o se não for nulo
			if (userDTO.getActive() != null) {
				existingAdultUser.getUser().setActive(userDTO.getActive()	);
			}
		}

		// Atualize o AdultUser no banco de dados
		AdultUser updatedAdultUser = adultUserRepository.save(existingAdultUser);
		return existingAdultUser;
	}



	public AdultUserDTO findById(Long id) throws Exception {
		try {
			Optional<AdultUser> adultUserOptional = adultUserRepository.findById(id);
			AdultUserDTO adultUserDTO = mapper.map(adultUserOptional.get(), AdultUserDTO.class);
			return adultUserDTO;
		} catch (Exception e) {
			throw new Exception("Não há registro com esse id");
		}

	}


	@Transactional
	public ChildUser createChildUser(Long adultUserId, ChildUserDTO childUserDTO) {
		// Verifique se o AdultUser existe no banco de dados
		AdultUser adultUser = adultUserRepository.findById(adultUserId)
				.orElseThrow(() -> new EntityNotFoundException("AdultUser not found with ID: " + adultUserId));

		// Chame o serviço de criação de ChildUser, passando o ID do AdultUser
		ChildUser createdChildUser = childUserService.createChildUser(adultUserId, childUserDTO);

		return createdChildUser;
	}

	public void inactiveUser(Long id) {
		 userService.updateInactive(id);
		
	}



}
