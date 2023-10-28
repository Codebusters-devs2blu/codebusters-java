package com.codebusters.codebusters.models.dtos;

import com.codebusters.codebusters.enums.ReleaseType;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


public class ReleaseDTO implements Serializable {
    private static final Long serialVersionUID = 42L;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("date")
    @NotNull
    private Timestamp date;
    @JsonProperty("type")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private ReleaseType type;
    @JsonProperty("releaseValue")
    @NotNull
    private double releaseValue;
    @JsonProperty("description")
    @NotNull
    private String description;
    @JsonProperty("walletDTO")
    @NotNull
    private WalletDTO wallet;
    
    
    public ReleaseDTO() {
		super();
	}
    

	public ReleaseDTO(Long id, @NotNull Timestamp date, @NotNull ReleaseType type, @NotNull double releaseValue,
			@NotNull String description, @NotNull WalletDTO wallet) {
		super();
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

  

	public WalletDTO getWallet() {
		return wallet;
	}


	public void setWallet(WalletDTO wallet) {
		this.wallet = wallet;
	}


	@Override
	public String toString() {
		return "ReleaseDTO [id=" + id + ", date=" + date + ", type=" + type + ", releaseValue=" + releaseValue
			+ ", description=" + description + ", walletDTO=" + wallet + "]";
	}
    
}
