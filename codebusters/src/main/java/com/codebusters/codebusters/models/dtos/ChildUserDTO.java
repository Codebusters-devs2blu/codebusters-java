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

    @NotBlank(message = "A lista objectives não pode estar em branco")
	@NotEmpty(message = "A lista objectives não pode estar vazio")
    private List<ObjectiveDTO> objectives;

    @NotBlank(message = "A lista tasks não pode estar em branco")
	@NotEmpty(message = "A lista tasks não pode estar vazio")
    private List<ChildTaskDTO> tasks;
    @NotBlank(message = "O objeto family não pode estar em branco")
	@NotEmpty(message = "O objeto family não pode estar vazio")
    private Family family;

    @NotBlank(message = "O objeto childUser não pode estar em branco")
	@NotEmpty(message = "O objeto childUser não pode estar vazio")

	private ChildUserDTO childUserDTO;

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

	public List<ObjectiveDTO> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<ObjectiveDTO> objectives) {
		this.objectives = objectives;
	}

	public List<ChildTaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<ChildTaskDTO> tasks) {
		this.tasks = tasks;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public ChildUserDTO getChildUserDTO() {
		return childUserDTO;
	}

	public void setChildUserDTO(ChildUserDTO childUserDTO) {
		this.childUserDTO = childUserDTO;
	}

	public AdultUserDTO getGuardian() {
		return guardian;
	}

	public void setGuardian(AdultUserDTO guardian) {
		this.guardian = guardian;
	}
}
