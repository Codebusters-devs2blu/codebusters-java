package com.codebusters.codebusters.models.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.codebusters.codebusters.enums.Family;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class ChildUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonProperty("userDTO")
	@NotNull
	private UserDTO userDTO;
	@JsonProperty("birthday")
	@NotNull
	private Date birthday;
	@JsonProperty("walletDTO")
	@NotNull
	private WalletDTO walletDTO;
	@JsonProperty("family")
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Family family;
	@JsonProperty("guardian")
	@NotNull
	private AdultUserDTO guardian;
	
	
	public ChildUserDTO() {
		super();
	}
	

	public ChildUserDTO(Long id, @NotNull UserDTO userDTO, @NotNull Date birthday, @NotNull WalletDTO walletDTO,
			@NotNull Family family, @NotNull AdultUserDTO guardian) {
		super();
		this.id = id;
		this.userDTO = userDTO;
		this.birthday = birthday;
		this.walletDTO = walletDTO;
		this.family = family;
		this.guardian = guardian;
	}


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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public WalletDTO getWalletDTO() {
		return walletDTO;
	}

	public void setWalletDTO(WalletDTO walletDTO) {
		this.walletDTO = walletDTO;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public AdultUserDTO getGuardian() {
		return guardian;
	}

	public void setGuardian(AdultUserDTO guardian) {
		this.guardian = guardian;
	}

	@Override
	public String toString() {
		return "ChildUserDTO [id=" + id + ", userDTO=" + userDTO + ", birthday=" + birthday + ", walletDTO=" + walletDTO
				+ ", family=" + family + ", guardian=" + guardian + "]";
	}

}
