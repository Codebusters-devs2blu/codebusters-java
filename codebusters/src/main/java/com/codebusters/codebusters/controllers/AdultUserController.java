package com.codebusters.codebusters.controllers;

import java.util.ArrayList;
import java.util.List;

import com.codebusters.codebusters.models.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.AdultUserDTO;
import com.codebusters.codebusters.models.dtos.ObjectiveDTO;
import com.codebusters.codebusters.services.AdultUserService;


import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/adultUser")
public class AdultUserController  implements CrudController<AdultUserDTO, Long>{

	@Autowired
	private AdultUserService adultUserService;

	@Override
	public List<AdultUserDTO> listAll() {

		return null;
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdultUserDTO> findById(Long id) {
		
		try {
	//		ObjectiveDTO objective = adultUserService.

          /*  if (objective != null) {
                return ResponseEntity.ok(objective);
            } else {
                return ResponseEntity.notFound().build();
            }*/
        } catch (Exception e) {
            // Registre a exceção para fins de depuração
            e.printStackTrace();
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
		return null;
	}

	@Override
	@PostMapping
	public ResponseEntity<Object> create(@Valid AdultUserDTO dto) {
		 try {
			 //adultUserService.addAdultUsers(dto);
	           
	            return ResponseEntity.ok("");
	        } catch (Exception e) {
	            // Trate exceções e retorne uma resposta adequada em caso de erro
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
		
	}

	@Override
	@PutMapping(value= "/update-adultuser")
	public ResponseEntity<AdultUserDTO> update(@Valid AdultUserDTO dto) {
		try {
			//adultUserService.save(dto);
		}catch (Exception e) {
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;
		

	}


	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(Long id) {
		// TODO Auto-generated method stub
		try {
			//adultUserService.deleteAdultUser(id);
			return ResponseEntity.ok("deletado");
        } catch (Exception e) {
            // Trate exceções e retorne uma resposta adequada em caso de erro
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}

<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes

}
