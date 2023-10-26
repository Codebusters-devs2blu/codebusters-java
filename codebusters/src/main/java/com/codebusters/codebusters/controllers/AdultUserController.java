package com.codebusters.codebusters.controllers;

import java.util.List;

import com.codebusters.codebusters.models.entities.AdultUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codebusters.codebusters.interfaces.CrudController;
import com.codebusters.codebusters.models.dtos.AdultUserDTO;
import com.codebusters.codebusters.services.AdultUserService;


import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/adultUser")
public class AdultUserController  implements CrudController<AdultUserDTO, Long>{

	private AdultUserService adultUserService;
	private final ModelMapper modelMapper;

	@Autowired
	public AdultUserController(AdultUserService adultUserService, ModelMapper modelMapper) {
		this.adultUserService = adultUserService;
		this.modelMapper = modelMapper;
	}


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
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@Valid @RequestBody AdultUserDTO adultUserDTO) {
		AdultUser createdAdultUser = adultUserService.createAdultUser(adultUserDTO);

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
		

	}*/
	@Override
	@PutMapping(value = "/update")
	public ResponseEntity<AdultUserDTO> update(@Valid @RequestBody AdultUserDTO dto) {
		try {
			AdultUser updatedAdultUser = adultUserService.updateAdultUser(dto);
			AdultUserDTO updatedDto = modelMapper.map(updatedAdultUser, AdultUserDTO.class);
			return ResponseEntity.ok(updatedDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
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
