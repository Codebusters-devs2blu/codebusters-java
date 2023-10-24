package com.codebusters.codebusters.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double money;

    @OneToMany
    private List<Release> extract;

    public Wallet() {
    }

    public Wallet(Long id, double money, List<Release> extract) {
        this.id = id;
        this.money = money;
        this.extract = extract;
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

    public List<Release> getExtract() {
        return extract;
    }

    public void setExtract(List<Release> extract) {
        this.extract = extract;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", money=" + money +
                ", extract=" + extract +
                '}';
    }
}
