package com.codebusters.codebusters.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double money = 0.0;

    @OneToMany(mappedBy = "wallet")
    private List<Release> releaseExtract;

    public Wallet() {
    }

    public Wallet(Long id, double money, List<Release> releaseExtract) {
        this.id = id;
        this.money = money;
        this.releaseExtract = releaseExtract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Release> getReleaseExtract() {
        return releaseExtract;
    }

    public void setReleaseExtract(List<Release> releaseExtract) {
        this.releaseExtract = releaseExtract;
    }

   
}
