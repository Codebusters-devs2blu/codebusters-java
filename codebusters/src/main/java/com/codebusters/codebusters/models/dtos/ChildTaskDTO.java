package com.codebusters.codebusters.models.dtos;

import com.codebusters.codebusters.enums.TaskStatus;
import com.codebusters.codebusters.models.entities.AdultUser;
import com.codebusters.codebusters.models.entities.ChildUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor

public class ChildTaskDTO {

    private Long id;

    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private String description;

    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private Double value;

    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private TaskStatus status;

    private AdultUser adultUserDTO;

    private ChildUser childUserDTO;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public AdultUser getAdultUserDTO() {
        return adultUserDTO;
    }

    public void setAdultUserDTO(AdultUser adultUserDTO) {
        this.adultUserDTO = adultUserDTO;
    }

    public ChildUser getChildUserDTO() {
        return childUserDTO;
    }

    public void setChildUserDTO(ChildUser childUserDTO) {
        this.childUserDTO = childUserDTO;
    }
}
