package com.codebusters.codebusters.models.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class WalletDTO  implements Serializable{
    private static final Long serialVersionUID = 42L;
    private Long id;

    @NotBlank(message = "O campo money não pode estar em branco")
    @NotEmpty(message = "O campo money não pode estar vazio")
    private double money;

    @NotBlank(message = "O campo extract não pode estar em branco")
    @NotEmpty(message = "O campo extract não pode estar vazio")
    private List<ReleaseDTO> releaseExtract;

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

    public List<ReleaseDTO> getReleaseExtract() {
        return releaseExtract;
    }

    public void setReleaseExtract(List<ReleaseDTO> releaseExtract) {
        this.releaseExtract = releaseExtract;
    }
}
