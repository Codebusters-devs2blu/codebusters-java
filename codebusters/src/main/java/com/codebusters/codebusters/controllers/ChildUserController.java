package com.codebusters.codebusters.controllers;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
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
import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.models.entities.Wallet;
import com.codebusters.codebusters.services.AdultUserService;
import com.codebusters.codebusters.services.ChildUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/childUser")
public class ChildUserController implements CrudController<ChildUserDTO, Long> {

	@Autowired
	private ChildUserService service;

	@Autowired
	private final ModelMapper mapper;

	
	public ChildUserController(ChildUserService service, ModelMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	@GetMapping(value = "/listall")
	public List<ChildUserDTO> listAll() {
		return service.listAll();
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChildUserDTO> findById(@PathVariable Long id) {
		ChildUserDTO childUser = service.findById(id);

		if (childUser == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(childUser);
	}

	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@RequestBody ChildUserDTO dto) {

		ChildUser createChildUser = service.createChildUser(dto.getGuardian().getId(), dto);

		// Mapear o resultado para um AdultUserDTO
		ChildUserDTO childUserDTO = mapper.map(createChildUser, ChildUserDTO.class);

		return ResponseEntity.status(201).body(childUserDTO);
	
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ChildUserDTO> update(@Valid ChildUserDTO dto) {
		/*ChildUserDTO childUserDTO = service.up(dto);
		return ResponseEntity.ok(childUserDTO);/*/
		return null;
		
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(Long id) {
		return ResponseEntity.ok().body(setarObject());
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id) {
		try {
			service.inactiveUser(id);
			return ResponseEntity.ok("Inactive");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}
	@PutMapping("/active/{id}")
	public ResponseEntity<Object> statusUserInactive(@PathVariable Long id) {
		try {
			service.inactiveUser(id);
			return ResponseEntity.ok("Inactive");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	public ChildUserDTO setarObject() {
		WalletDTO walletDTO = new WalletDTO();
		walletDTO.setId(1L);
		walletDTO.setMoney(50.0);

		ReleaseDTO release = new ReleaseDTO();
		release.setDescription("Compra de comida");
		release.setReleaseValue(5.5);
		release.setWalletDTO(walletDTO);
		release.setDate(new java.sql.Timestamp(0));
		release.setType(ReleaseType.IN);
		release.setId(1L);

		List<ReleaseDTO> releaseDTOs = new ArrayList<>();
		releaseDTOs.add(release);

		UserDTO user = new UserDTO();
		user.setId(1L);
		user.setName("Alice Pereira");
		user.setNickname("1234");
		user.setPassword( "alice1234");
		
		UserDTO userFather = new UserDTO();
		userFather.setId(40l);
		userFather.setName("Paulo");
		userFather.setNickname("PaulinhoGameplays");
		userFather.setPassword("123456");

		AdultUserDTO adultUserDTO = new AdultUserDTO();
		adultUserDTO.setUser(userFather);

		ChildUserDTO childUserDTO01 = new ChildUserDTO();
		childUserDTO01.setId(40l);
		childUserDTO01.setFamily(Family.DAD);

		ObjectiveDTO objective1 = new ObjectiveDTO();
		objective1.setId(1L);
		objective1.setChildUserDTO(childUserDTO01);
		objective1.setCurrentAmount(100.0);
		objective1.setDescription("Economizar para um brinquedo");
		objective1.setObjectiveValue(50.0);

		ObjectiveDTO objective2 = new ObjectiveDTO();
		objective2.setId(1L);
		objective2.setChildUserDTO(childUserDTO01);
		objective2.setCurrentAmount(100.0);
		objective2.setDescription("Economizar para um brinquedo");
		objective2.setObjectiveValue(50.0);

		List<ObjectiveDTO> listObjective = new ArrayList<>();
		listObjective.add(objective2);
		listObjective.add(objective1);
		List<ChildTaskDTO> childTaskDTO = new ArrayList<>();

		ChildUserDTO childUser = new ChildUserDTO();
		childUser.setBirthday(new Date());
		childUser.setFamily(Family.DAD);
		childUser.setGuardian(adultUserDTO);
		childUser.setId(1L);
		childUser.setWalletDTO(walletDTO);
		childUser.setUserDTO(user);
		childUser.setWalletDTO(new WalletDTO());
		return childUser;
	}

}