package com.codebusters.codebusters.controllers;


import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;


import com.codebusters.codebusters.models.entities.AdultUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.models.entities.AdultUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.enums.Family;
import com.codebusters.codebusters.enums.ReleaseType;
import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.AdultUserDTO;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.dtos.ReleaseDTO;
import com.codebusters.codebusters.services.AdultUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/adultuser")
public class AdultUserController implements CrudController<AdultUserDTO, Long> {


	private AdultUserService service;

	private final ModelMapper modelMapper;

	@Autowired
	public AdultUserController(AdultUserService service, ModelMapper modelMapper) {
		this.adultUserService = service;
		this.modelMapper = modelMapper;
	}


	@Override
	public List<AdultUserDTO> listAll() {
		return service.listAll();
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdultUserDTO> findById(@PathVariable Long id) {
		AdultUserDTO adultUserDTO = service.findById(id);

		if (adultUserDTO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(adultUserDTO);
	}


	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@Valid @RequestBody AdultUserDTO adultUserDTO) {
		AdultUser createdAdultUser = service.createAdultUser(adultUserDTO);

		// Mapear o resultado para um AdultUserDTO
		AdultUserDTO createdAdultUserDTO = modelMapper.map(createdAdultUser, AdultUserDTO.class);

		return ResponseEntity.status(201).body(createdAdultUserDTO);
	}


/*	@PostMapping
	public ResponseEntity<Object> create(@Valid AdultUserDTO dto) {
		 try {
			 //adultUserService.addAdultUsers(dto);
	           
	            return ResponseEntity.ok("");
	        } catch (Exception e) {
	            // Trate exceções e retorne uma resposta adequada em caso de erro
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
		
	}*/


/*	@Override
	@PutMapping(value= "/update")
	public ResponseEntity<AdultUserDTO> update(@Valid AdultUserDTO dto) {
		try {
			//adultUserService.save(dto);
		}catch (Exception e) {
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;
		
	public ResponseEntity<Object> create(AdultUserDTO dto) {
		return ResponseEntity.ok().body(createAdult());
		
		/*
		try {
			// adultUserService.create(dto);
			return ResponseEntity.ok("Cadastrado");
		} catch (Exception e) {
			// Trate exceções e retorne uma resposta adequada em caso de erro
			return ResponseEntity.badRequest().body(e.getMessage());
		}*/

	}

	@Override
	@PutMapping(value = "/update")
	public ResponseEntity<AdultUserDTO> update(@Valid @RequestBody AdultUserDTO dto) {
		try {
			AdultUser updatedAdultUser = service.updateAdultUser(dto);
			AdultUserDTO updatedDto = modelMapper.map(updatedAdultUser, AdultUserDTO.class);
			return ResponseEntity.ok(updatedDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		
		return ResponseEntity.ok().body(createAdult());
		/*// TODO Auto-generated method stub
		try {
			// adultUserService.deleteById(id);
			return ResponseEntity.ok("deletado");
		} catch (Exception e) {
			// Trate exceções e retorne uma resposta adequada em caso de erro
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}*/
	}
	public List<ChildUserDTO> createChild() {
		UserDTO user = new UserDTO();
		user.setId(1L);
		user.setName("Alice Pereira");
		user.setNickname("1234");
		user.setPassword( "alice1234");
		
		
		ChildUserDTO childUser = new ChildUserDTO();
		childUser.setId(40l);
		childUser.setFamily(Family.DAD);
		childUser.setBirthday(new Date());
		childUser.setFamily(Family.DAD);
		childUser.setId(1L);
		childUser.setWalletDTO(createWallet());
		childUser.setUserDTO(user);
		childUser.setWalletDTO(new WalletDTO());

		
		List<ChildUserDTO> childUserDTOs = new ArrayList<>();
		childUserDTOs.add(childUser);
		
		return childUserDTOs;
		
	}
	public AdultUserDTO createAdult() {
		UserDTO userFather = new UserDTO();
		userFather.setId(40l);
		userFather.setName("Paulo");
		userFather.setNickname("PaulinhoGameplays");
		userFather.setPassword("123456");
		AdultUserDTO adultUserDTO = new AdultUserDTO();
		adultUserDTO.setUser(userFather);
		//adultUserDTO.setDependents(createChild());
		//adultUserDTO.setWallet(createWallet());
		return adultUserDTO; 
		
	}
	public List<ReleaseDTO> createRelease() {
		
	  
		ReleaseDTO release = new ReleaseDTO();
        release.setDescription("Compra de comida");
        release.setReleaseValue(5.5);

        release.setDate(new java.sql.Timestamp(0));
        release.setType(ReleaseType.IN);
        release.setId(1L);
        List<ReleaseDTO> releaseDTOs = new ArrayList<>();
        releaseDTOs.add(release);
		return releaseDTOs;
		
	}
	public WalletDTO createWallet() {
	
        

       
		WalletDTO walletDTO = new WalletDTO();
	
		walletDTO.setId(1L);
		walletDTO.setMoney(50.0);
		
		return walletDTO;
		
	}
	public List<ObjectiveDTO> createObjective() {
		 ObjectiveDTO objective1 = new ObjectiveDTO();
	        objective1.setId(1L);
	       
	        objective1.setCurrentAmount(100.0);
	        objective1.setDescription("Economizar para um brinquedo");
	        objective1.setObjectiveValue(50.0);
	        
	        ObjectiveDTO objective2 = new ObjectiveDTO();
	        objective2.setId(1L);
	        objective2.setCurrentAmount(100.0);
	        objective2.setDescription("Economizar para um brinquedo");
	        objective2.setObjectiveValue(50.0);
	        
	        List<ObjectiveDTO> objectiveDTO = new ArrayList<>();
	        objectiveDTO.add(objective2);
	        objectiveDTO.add(objective1);
		return objectiveDTO;
		
	}
	public List<ChildTaskDTO> createChildTask() {
		return null;
	}

}
