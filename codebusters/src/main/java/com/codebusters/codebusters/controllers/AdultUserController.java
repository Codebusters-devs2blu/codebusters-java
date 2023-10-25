package com.codebusters.codebusters.controllers;

import java.util.List;

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


}
