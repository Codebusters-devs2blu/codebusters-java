package com.codebusters.codebusters.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AdultUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(nullable = false, unique = true)
    private String email;

    private String job;

    @OneToMany
    private List<ChildUser> dependents;

    @OneToOne
    private Wallet wallet;

    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany
    private List<ChildTask> tasks;

    public AdultUser() {
    }

    public AdultUser(Long id, User user, String email, String job, List<ChildUser> dependents, Wallet wallet, String cpf/*, List<ChildTask> tasks*/) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.job = job;
        this.dependents = dependents;
        this.wallet = wallet;
        this.cpf = cpf;
        //this.tasks = tasks;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<ChildUser> getDependents() {
        return dependents;
    }

    public void setDependents(List<ChildUser> dependents) {
        this.dependents = dependents;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ChildTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<ChildTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "AdultUser{" +
                "id=" + id +
                ", user=" + user +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", dependents=" + dependents +
                ", wallet=" + wallet +
                ", cpf='" + cpf + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
