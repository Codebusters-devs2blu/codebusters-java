package com.codebusters.codebusters.models.dtos;

import java.io.Serializable;
import java.util.List;

import com.codebusters.codebusters.models.entities.ChildTask;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.models.entities.Wallet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
public class AdultUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonProperty("userDTO")
	private UserDTO user;

	@JsonProperty("email")
/*	@NotBlank(message = "O campo email não pode estar em branco")
	@NotEmpty(message = "O campo email não pode estar vazio")*/
	private String email;

	@JsonProperty("job")
	private String job;

	@JsonProperty("walletDTO")
	private WalletDTO wallet;

	@JsonProperty("cpf")
	@Size(min = 11)
	private String cpf;

// ...

	// Adicione um construtor anotado com @JsonCreator, se necessário
	@JsonCreator
	public AdultUserDTO( @JsonProperty("userDTO") UserDTO user, @JsonProperty("email") String email, @JsonProperty("job") String job, @JsonProperty("cpf") String cpf) {
		this.user = user;
		this.email = email;
		this.job = job;
		this.cpf = cpf;
	}


	
	
	@Override
	public String toString() {
		return "AdultUserDTO [id=" + id + ", user=" + user + ", email=" + email + ", job=" + job + ", wallet=" + wallet
				+ ", cpf=" + cpf + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
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
}
