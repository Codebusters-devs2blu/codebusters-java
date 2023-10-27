package com.codebusters.codebusters.models.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.codebusters.codebusters.enums.Family;
import com.codebusters.codebusters.enums.TaskStatus;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.ChildTask;
import com.codebusters.codebusters.models.entities.ChildUser;
import com.codebusters.codebusters.models.entities.Objective;
import com.codebusters.codebusters.models.entities.User;
import com.codebusters.codebusters.models.entities.Wallet;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class ChildUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	

	@NotBlank(message = "O objeto user não pode estar em branco")
	@NotEmpty(message = "O objeto user não pode estar vazio")
    private UserDTO userDTO;
    @NotBlank(message = "O campo birthday não pode estar em branco")
	@NotEmpty(message = "O campo birthday não pode estar vazio")
    private Date birthday;

    @NotBlank(message = "O objeto wallet não pode estar em branco")
	@NotEmpty(message = "O objeto wallet não pode estar vazio")
    private WalletDTO walletDTO;

    @NotBlank(message = "O objeto family não pode estar em branco")
	@NotEmpty(message = "O objeto family não pode estar vazio")
    private Family family;

    @NotBlank(message = "O objeto childUser não pode estar em branco")
	@NotEmpty(message = "O objeto childUser não pode estar vazio")
    private AdultUserDTO guardian;

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
