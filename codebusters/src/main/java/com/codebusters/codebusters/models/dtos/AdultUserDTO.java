package com.codebusters.codebusters.models.dtos;

import java.io.Serializable;
import java.util.List;

import com.codebusters.codebusters.models.entities.ChildTask;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.models.entities.Wallet;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AdultUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "O objeto user não pode estar em branco")
	@NotEmpty(message = "O objeto user não pode estar vazio")
	private UserDTO userDTO;
	@NotBlank(message = "O campo email não pode estar em branco")
	@NotEmpty(message = "O campo email não pode estar vazio")
	private String email;
	@NotBlank(message = "O campo job não pode estar em branco")
	@NotEmpty(message = "O campo job não pode estar vazio")
	private String job;
	@NotBlank(message = "A lista de dependents não pode estar em branco")
	@NotEmpty(message = "A lista de dependents não pode estar vazio")
	private List<ChildUserDTO> dependents;
	@NotBlank(message = "O campo wallet não pode estar em branco")
	@NotEmpty(message = "O campo wallet não pode estar vazio")
	private WalletDTO wallet;
	@NotBlank(message = "O campo cpf não pode estar em branco")
	@NotEmpty(message = "O campo cpf não pode estar vazio")
	@Size(min = 11)
	private String cpf;
	@NotBlank(message = "A lista de tasks não pode estar em branco")
	@NotEmpty(message = "A lista de tasks pode estar vazio")
	private List<ChildTaskDTO> tasks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public List<ChildUserDTO> getDependents() {
		return dependents;
	}

	public void setDependents(List<ChildUserDTO> dependents) {
		this.dependents = dependents;
	}

	public WalletDTO getWallet() {
		return wallet;
	}

	public void setWallet(WalletDTO wallet) {
		this.wallet = wallet;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<ChildTaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<ChildTaskDTO> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "AdultUserDTO [id=" + id + ", userDTO=" + userDTO + ", email=" + email + ", job=" + job + ", dependents="
				+ dependents + ", wallet=" + wallet + ", cpf=" + cpf + ", tasks=" + tasks + "]";
	}
	
}
