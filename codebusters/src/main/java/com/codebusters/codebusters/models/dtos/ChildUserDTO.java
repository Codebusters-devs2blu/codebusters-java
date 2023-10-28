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
	private UserDTO user;
	@JsonProperty("birthday")
	@NotNull
	private Date birthday;
	@JsonProperty("walletDTO")
	@NotNull
	private WalletDTO wallet;
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

	public ChildUserDTO(Long id, @NotNull UserDTO user, @NotNull Date birthday, @NotNull WalletDTO wallet,
			@NotNull Family family, @NotNull AdultUserDTO guardian) {
		super();
		this.id = id;
		this.user = user;
		this.birthday = birthday;
		this.wallet = wallet;
		this.family = family;
		this.guardian = guardian;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public WalletDTO getWallet() {
		return wallet;
	}

	public void setWallet(WalletDTO wallet) {
		this.wallet = wallet;
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
		return "ChildUserDTO [id=" + id + ", userDTO=" + user + ", birthday=" + birthday + ", walletDTO=" + wallet
				+ ", family=" + family + ", guardian=" + guardian + "]";
	}

}
