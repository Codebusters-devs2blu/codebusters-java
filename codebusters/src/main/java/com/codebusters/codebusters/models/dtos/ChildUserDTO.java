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
    private User user;
    @NotBlank(message = "O campo birthday não pode estar em branco")
	@NotEmpty(message = "O campo birthday não pode estar vazio")
    private Date birthday;

    @NotBlank(message = "O objeto wallet não pode estar em branco")
	@NotEmpty(message = "O objeto wallet não pode estar vazio")
    private Wallet wallet;

    @NotBlank(message = "A lista objectives não pode estar em branco")
	@NotEmpty(message = "A lista objectives não pode estar vazio")
    private List<Objective> objectives;

    @NotBlank(message = "A lista tasks não pode estar em branco")
	@NotEmpty(message = "A lista tasks não pode estar vazio")
    private List<ChildTask> tasks;
    @NotBlank(message = "O objeto family não pode estar em branco")
	@NotEmpty(message = "O objeto family não pode estar vazio")
    private Family family;

    @NotBlank(message = "O objeto childUser não pode estar em branco")
	@NotEmpty(message = "O objeto childUser não pode estar vazio")

	private ChildUserDTO childUserDTO;

    private AdultUser guardian;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public List<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public List<ChildTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<ChildTask> tasks) {
		this.tasks = tasks;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public AdultUser getGuardian() {
		return guardian;
	}

	public void setGuardian(AdultUser guardian) {
		this.guardian = guardian;
	}

    
}
