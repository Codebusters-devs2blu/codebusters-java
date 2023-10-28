package com.codebusters.codebusters.models.dtos;

import com.codebusters.codebusters.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class ChildTaskDTO {
	@JsonProperty("id")
    private Long id;
	@JsonProperty("description")
    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private String description;
	@JsonProperty("taskValue")
	@NotNull
    private Double taskValue;
	@JsonProperty("status")
	@NotNull
	@Enumerated(EnumType.ORDINAL)
    private TaskStatus status;
	@JsonProperty("adultUserDTO")
    private AdultUserDTO adultUserDTO;
	@JsonProperty("childUserDTO")
    private ChildUserDTO childUserDTO;

	

    public ChildTaskDTO() {
		super();
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTaskValue() {
        return taskValue;
    }

    public void setTaskValue(Double taskValue) {
        this.taskValue = taskValue;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public AdultUserDTO getAdultUserDTO() {
        return adultUserDTO;
    }

    public void setAdultUserDTO(AdultUserDTO adultUserDTO) {
        this.adultUserDTO = adultUserDTO;
    }

    public ChildUserDTO getChildUserDTO() {
        return childUserDTO;
    }

    public void setChildUserDTO(ChildUserDTO childUserDTO) {
        this.childUserDTO = childUserDTO;
    }

	@Override
	public String toString() {
		return "ChildTaskDTO [id=" + id + ", description=" + description + ", taskValue=" + taskValue + ", status="
				+ status + ", adultUserDTO=" + adultUserDTO + ", childUserDTO=" + childUserDTO + "]";
	}
    
}
