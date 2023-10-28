package com.codebusters.codebusters.models.dtos;

import com.codebusters.codebusters.models.entities.ChildUser;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class ObjectiveDTO {
    private Long id;

    @JsonProperty("objectiveValue")
    //@NotEmpty(message = "O campo valor da meta não pode estar vazio")
    private double objectiveValue;
    @JsonProperty("currentAmount")
    private double currentAmount;
    @JsonProperty("description")
    /*@NotBlank(message = "O campo descrição não pode estar em branco")
    @NotEmpty(message = "O campo descrição não pode estar vazio")*/
    private String description;
    @JsonProperty("childUserDTO")
    private ChildUserDTO childUser;

   
	public ObjectiveDTO() {
		super();
	}
	

	
	public ObjectiveDTO(Long id, double objectiveValue, double currentAmount, String description,
			ChildUserDTO childUser) {
		super();
		this.id = id;
		this.objectiveValue = objectiveValue;
		this.currentAmount = currentAmount;
		this.description = description;
		this.childUser = childUser;
	}



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



	public ChildUserDTO getChildUser() {
		return childUser;
	}



	public void setChildUser(ChildUserDTO childUser) {
		this.childUser = childUser;
	}

  
/*
	@Override
	public String toString() {
		return "ObjectiveDTO [id=" + id + ", objectiveValue=" + objectiveValue + ", currentAmount=" + currentAmount
				+ ", description=" + description + ", childUserDTO=" + childUserDTO + "]";
	}*/
    
}
