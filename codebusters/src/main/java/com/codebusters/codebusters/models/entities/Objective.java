package com.codebusters.codebusters.models.entities;

import jakarta.persistence.*;

@Entity
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double objectiveValue;

    private double currentAmount;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private ChildUser childUser;

    public Objective() {
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

    public ChildUser getChildUser() {
        return childUser;
    }

    public void setChildUser(ChildUser childUser) {
        this.childUser = childUser;
    }

	@Override
	public String toString() {
		return "Objective [id=" + id + ", objectiveValue=" + objectiveValue + ", currentAmount=" + currentAmount
				+ ", description=" + description + ", childUser=" + childUser + "]";
	}
    
  
}
