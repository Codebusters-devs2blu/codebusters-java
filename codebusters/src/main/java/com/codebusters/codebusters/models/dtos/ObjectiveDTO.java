package com.codebusters.codebusters.models.dtos;

import com.codebusters.codebusters.models.entities.ChildUser;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class ObjectiveDTO {
    private Long id;

    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private double objectiveValue;

    private double currentAmount;

    @NotBlank(message = "O campo código não pode estar em branco")
    @NotEmpty(message = "O campo código não pode estar vazio")
    private String description;

    private ChildUserDTO childUserDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getObjectiveValue() {
        return objectiveValue;
    }

    public void setObjectiveValue(double objectiveValue) {
        this.objectiveValue = objectiveValue;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ChildUserDTO getChildUserDTO() {
        return childUserDTO;
    }

    public void setChildUserDTO(ChildUserDTO childUserDTO) {
        this.childUserDTO = childUserDTO;
    }
}
