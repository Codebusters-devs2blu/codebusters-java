package com.codebusters.codebusters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.services.ChildUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/childUser")
public class ChildUserController implements CrudController<ChildUserDTO, Long>{

	@Autowired
	private ChildUserService childUSerService;

	@Override
	public List<ChildUserDTO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< Updated upstream
=======
	@GetMapping(value = "/listall")
	public List<ChildUserDTO> listAllChild(@PathVariable long id) {
		/*
		 * try { List<ChildUserDTO> childUser = childUserService.listAll(id);
		 * 
		 * if (!childUser.isEmpty()) { return childUser; } else { // Se a lista estiver
		 * vazia, você pode retornar null ou uma lista vazia, // dependendo dos
		 * requisitos. return Collections.emptyList(); // Retorna uma lista vazia. } }
		 * catch (Exception e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * return Collections.emptyList(); }
		 */
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
		UserDTO user = new UserDTO(1L, "Alice Pereira", "1234", "alice1234");
		UserDTO userFather = new UserDTO();
		userFather.setId(40l);
		userFather.setName("Paulo");
		userFather.setNickname("PaulinhoGameplays");
		userFather.setPassword("123456");

		AdultUserDTO adultUserDTO = new AdultUserDTO();
		adultUserDTO.setUserDTO(userFather);

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
		childUser.setTasks(childTaskDTO);
		childUser.setUserDTO(user);
		childUser.setWalletDTO(new WalletDTO());
		childUser.setObjectives(listObjective);

		List<ChildUserDTO> childUserDTOs = new ArrayList<>();
		childUserDTOs.add(childUser);
		return childUserDTOs;

	}

>>>>>>> Stashed changes
	@Override
	public ResponseEntity<ChildUserDTO> findById(Long id) {
<<<<<<< Updated upstream
=======
		/*
		 * ChildUserDTO childUserDTO = childUserService.findById(id);
		 * 
		 * if (childUserDTO == null) { return ResponseEntity.notFound().build(); }
		 * 
		 * return ResponseEntity.ok(childUserDTO);
		 */

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

		UserDTO user = new UserDTO(1L, "Alice Pereira", "1234", "alice1234");
		UserDTO userFather = new UserDTO();
		userFather.setId(40l);
		userFather.setName("Paulo");
		userFather.setNickname("PaulinhoGameplays");
		userFather.setPassword("123456");

		AdultUserDTO adultUserDTO = new AdultUserDTO();
		adultUserDTO.setUserDTO(userFather);

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
		childUser.setTasks(childTaskDTO);
		childUser.setUserDTO(user);
		childUser.setWalletDTO(new WalletDTO());
		childUser.setObjectives(listObjective);

		return ResponseEntity.ok(childUser);

	}

	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@Valid ChildUserDTO dto) {
		/*
		 * try { // childUserService.create(dto); // Retorne uma resposta adequada de
		 * acordo com o sucesso da operação return ResponseEntity.ok("Cadastrado"); }
		 * catch (Exception e) { // Trate exceções e retorne uma resposta adequada em
		 * caso de erro return ResponseEntity.badRequest().body(e.getMessage()); }
		 */return null;

	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ChildUserDTO> update(@Valid ChildUserDTO dto) {
		return ResponseEntity.ok(dto);
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(Long id) {
>>>>>>> Stashed changes
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> create(@Valid ChildUserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ChildUserDTO> update(@Valid ChildUserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteById(Long id) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
