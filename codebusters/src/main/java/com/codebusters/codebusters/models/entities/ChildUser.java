package com.codebusters.codebusters.models.entities;

import com.codebusters.codebusters.enums.Family;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ChildUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(nullable = false)
    private Date birthday;

    @OneToOne
    private Wallet wallet;

    @OneToMany
    private List<Objective> objectives;

    @OneToMany
    private List<ChildTask> tasks;

    private Family family;

    @ManyToOne
    private AdultUser guardian;


    public ChildUser() {
    }

    public ChildUser(Long id, User user, Date birthday, Wallet wallet, /*List<Objective> objectives, List<ChildTask> tasks,*/ Family family, AdultUser guardian) {
        this.id = id;
        this.user = user;
        this.birthday = birthday;
        this.wallet = wallet;
        /*this.objectives = objectives;
        this.tasks = tasks;*/
        this.family = family;
        this.guardian = guardian;
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

    @Override
    public String toString() {
        return "ChildUser{" +
                "id=" + id +
                ", user=" + user +
                ", birthday=" + birthday +
                ", wallet=" + wallet +
                ", objectives=" + objectives +
                ", tasks=" + tasks +
                ", family=" + family +
                ", guardian=" + guardian +
                '}';
    }
}
