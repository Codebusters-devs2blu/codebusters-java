package com.codebusters.codebusters.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double money = 0.0;


    public Wallet() {
    }

    public Wallet(Long id, double money) {
        this.id = id;
        this.money = money;
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

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
