package com.codebusters.codebusters.models.dtos;

import com.codebusters.codebusters.enums.ReleaseType;
import com.codebusters.codebusters.models.entities.Wallet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseDTO implements Serializable {
    private static final Long serialVersionUID = 42L;

    private Long id;

    @NotBlank(message = "O campo date não pode estar em branco")
    @NotEmpty(message = "O campo date não pode estar vazio")
    private Timestamp date;

    @NotBlank(message = "O campo type não pode estar em branco")
    @NotEmpty(message = "O campo type não pode estar vazio")
    private ReleaseType type;

    @NotBlank(message = "O campo value não pode estar em branco")
    @NotEmpty(message = "O campo value não pode estar vazio")
    private double value;

    @NotBlank(message = "O campo description não pode estar em branco")
    @NotEmpty(message = "O campo description não pode estar vazio")
    private String description;

    @NotBlank(message = "O campo walletDTO não pode estar em branco")
    @NotEmpty(message = "O campo walletDTO não pode estar vazio")
    private WalletDTO walletDTO;

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WalletDTO getWalletDTO() {
        return walletDTO;
    }

    public void setWalletDTO(WalletDTO walletDTO) {
        this.walletDTO = walletDTO;
    }
}
