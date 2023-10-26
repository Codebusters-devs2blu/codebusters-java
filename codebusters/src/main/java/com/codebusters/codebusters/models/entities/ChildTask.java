package com.codebusters.codebusters.models.entities;

import com.codebusters.codebusters.enums.TaskStatus;
import jakarta.persistence.*;


@Entity
@Table(name = "child_task")
public class ChildTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    //@Column(nullable = false)
    private Double taskValue;

    @Column(nullable = false)
    private TaskStatus status;

    @ManyToOne
    private AdultUser adultUser;

    @ManyToOne
    private ChildUser childUser;

    public ChildTask() {
    }

    public ChildTask(Long id, String description, Double taskValue, TaskStatus status, AdultUser adultUser, ChildUser childUser) {
        this.id = id;
        this.description = description;
        this.taskValue = taskValue;
        this.status = status;
        this.adultUser = adultUser;
        this.childUser = childUser;
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

    public AdultUser getAdultUser() {
        return adultUser;
    }

    public void setAdultUser(AdultUser adultUser) {
        this.adultUser = adultUser;
    }

    public ChildUser getChildUser() {
        return childUser;
    }

    public void setChildUser(ChildUser childUser) {
        this.childUser = childUser;
    }

	@Override
	public String toString() {
		return "ChildTask [id=" + id + ", description=" + description + ", taskValue=" + taskValue + ", status="
				+ status + ", adultUser=" + adultUser + ", childUser=" + childUser + "]";
	}
    

  

}
