package com.codebusters.codebusters.models.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WalletDTO  implements Serializable{
    private static final Long serialVersionUID = 42L;
    @JsonProperty("id")
    private Long id;

/*    @NotBlank(message = "O campo money não pode estar em branco")
    @NotEmpty(message = "O campo money não pode estar vazio")*/
    @JsonProperty("money")
    private double money;

    public WalletDTO() {
    }

    public WalletDTO(Long id, double money) {
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
        return "WalletDTO{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
