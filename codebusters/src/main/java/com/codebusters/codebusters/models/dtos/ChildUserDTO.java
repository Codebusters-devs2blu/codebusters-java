package com.codebusters.codebusters.models.dtos;

import java.io.Serializable;

import com.codebusters.codebusters.enums.TaskStatus;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.ChildUser;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class ChildUserDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "O campo description não pode estar em branco")
	@NotEmpty(message = "O campo description não pode estar vazio")
	private String description;
	@NotBlank(message = "O campo value não pode estar em branco")
	@NotEmpty(message = "O campo value não pode estar vazio")
	private double value;
	@NotBlank(message = "O campo status não pode estar em branco")
	@NotEmpty(message = "O campo status não pode estar vazio")
	private TaskStatus status;
	@NotBlank(message = "O objeto adultUser não pode estar em branco")
	@NotEmpty(message = "O objeto adultUser não pode estar vazio")
	private AdultUser adultUser;
	@NotBlank(message = "O objeto childUser não pode estar em branco")
	@NotEmpty(message = "O objeto childUser não pode estar vazio")
	private ChildUser childUser;
}
