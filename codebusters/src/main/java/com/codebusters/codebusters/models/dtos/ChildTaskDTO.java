package com.codebusters.codebusters.models.dtos;

import com.codebusters.codebusters.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor

public class ChildTaskDTO {

    private Long id;

    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private String description;

    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private Double taskValue;

    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private TaskStatus status;

    private AdultUserDTO adultUserDTO;

    private ChildUserDTO childUserDTO;


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
}
