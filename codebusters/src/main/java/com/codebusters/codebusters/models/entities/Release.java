package com.codebusters.codebusters.models.entities;

import com.codebusters.codebusters.enums.ReleaseType;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Timestamp date;

    @Column(nullable = false)
    private ReleaseType type;

    @Column(nullable = false)
    private double releaseValue;

    private String description;

    @ManyToOne
    private Wallet wallet;

    public Release() {
    }

    public Release(Long id, Timestamp date, ReleaseType type, double releaseValue, String description, Wallet wallet) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.releaseValue = releaseValue;
        this.description = description;
        this.wallet = wallet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public ReleaseType getType() {
        return type;
    }

    public void setType(ReleaseType type) {
        this.type = type;
    }

    public double getReleaseValue() {
        return releaseValue;
    }

    public void setReleaseValue(double releaseValue) {
        this.releaseValue = releaseValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

	@Override
	public String toString() {
		return "Release [id=" + id + ", date=" + date + ", type=" + type + ", releaseValue=" + releaseValue
				+ ", description=" + description + ", wallet=" + wallet + "]";
	}
    


}
