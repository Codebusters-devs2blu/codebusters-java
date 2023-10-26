package com.codebusters.codebusters.controllers;


import com.codebusters.codebusters.enums.Family;
import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ChildTaskDTO;
import com.codebusters.codebusters.models.dtos.ChildUserDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.dtos.UserDTO;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.services.ObjectiveService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/objective")
public class ObjectiveController implements CrudController<ObjectiveDTO, Long> {
	@Autowired
	private ObjectiveService objectiveService;


	@Override
	@GetMapping(value = "/listAll")
	public List<ObjectiveDTO> listAll() {
		return objectiveService.listAll();
		/*
		UserDTO user01 = new UserDTO();
		user01.setId(40l);
		user01.setName("Paulo");
		user01.setNickname("PaulinhoGameplays");
		user01.setPassword("123456");

		ChildUserDTO childUserDTO01 = new ChildUserDTO();
		childUserDTO01.setId(40l);
		childUserDTO01.setFamily(Family.DAD);

		ObjectiveDTO meta01 = new ObjectiveDTO();
		meta01.setId(01l);
		meta01.setObjectiveValue(3000);
		meta01.setCurrentAmount(250);
		meta01.setChildUserDTO(childUserDTO01);
		meta01.setDescription("Apple Watch dos Cria");

		ObjectiveDTO meta02 = new ObjectiveDTO();
		meta02.setId(02l);
		meta02.setObjectiveValue(10000);
		meta02.setCurrentAmount(3.50);
		meta02.setChildUserDTO(childUserDTO01);
		meta02.setDescription("Chevette Tubarão Aspirado");

		List<ObjectiveDTO> listDeMetas = new ArrayList<>();
		listDeMetas.add(meta01);
		listDeMetas.add(meta02);

		return listDeMetas;*/
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ObjectiveDTO> findById(Long aLong) {

		UserDTO user01 = new UserDTO();
		user01.setId(40l);
		user01.setName("Paulo");
		user01.setNickname("PaulinhoGameplays");
		user01.setPassword("123456");

		ChildUserDTO childUserDTO01 = new ChildUserDTO();
		childUserDTO01.setId(40l);
		childUserDTO01.setFamily(Family.DAD);

		ObjectiveDTO meta01 = new ObjectiveDTO();
		meta01.setId(01l);
		meta01.setObjectiveValue(3000);
		meta01.setCurrentAmount(250);
		meta01.setChildUserDTO(childUserDTO01);
		meta01.setDescription("Apple Watch dos Cria");

		return ResponseEntity.ok(meta01);
	}

	@Override
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(ObjectiveDTO dto) {

		UserDTO user01 = new UserDTO();
		user01.setId(40l);
		user01.setName("Paulo");
		user01.setNickname("PaulinhoGameplays");
		user01.setPassword("123456");

		ChildUserDTO childUserDTO01 = new ChildUserDTO();
		childUserDTO01.setId(40l);
		childUserDTO01.setFamily(Family.DAD);

		ObjectiveDTO meta01 = new ObjectiveDTO();
		meta01.setId(01l);
		meta01.setObjectiveValue(3000);
		meta01.setCurrentAmount(250);
		meta01.setChildUserDTO(childUserDTO01);
		meta01.setDescription("Apple Watch dos Cria");


		return ResponseEntity.ok().body(meta01);
	}

	@Override
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ObjectiveDTO> update(ObjectiveDTO dto) {

		UserDTO user01 = new UserDTO();
		user01.setId(40l);
		user01.setName("Paulo");
		user01.setNickname("PaulinhoGameplays");
		user01.setPassword("123456");

		ChildUserDTO childUserDTO01 = new ChildUserDTO();
		childUserDTO01.setId(40l);
		childUserDTO01.setFamily(Family.DAD);

		ObjectiveDTO meta01 = new ObjectiveDTO();
		meta01.setId(01l);
		meta01.setObjectiveValue(3000);
		meta01.setCurrentAmount(250);
		meta01.setChildUserDTO(childUserDTO01);
		meta01.setDescription("Apple Watch dos Cria");


		return ResponseEntity.ok().body(meta01);
	}

	@Override
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {

		UserDTO user01 = new UserDTO();
		user01.setId(40l);
		user01.setName("Paulo");
		user01.setNickname("PaulinhoGameplays");
		user01.setPassword("123456");

		ChildUserDTO childUserDTO01 = new ChildUserDTO();
		childUserDTO01.setId(40l);
		childUserDTO01.setFamily(Family.DAD);

		ObjectiveDTO meta01 = new ObjectiveDTO();
		meta01.setId(01l);
		meta01.setObjectiveValue(3000);
		meta01.setCurrentAmount(250);
		meta01.setChildUserDTO(childUserDTO01);
		meta01.setDescription("Apple Watch dos Cria");

		return ResponseEntity.ok().body(meta01);
	}

}
