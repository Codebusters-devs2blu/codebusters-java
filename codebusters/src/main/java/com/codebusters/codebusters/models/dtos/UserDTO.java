package com.codebusters.codebusters.models.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final Long serialVersionUID = 42L;


    private Long id;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotEmpty(message = "O campo nome não pode estar vazio")
    private String name;

    @NotBlank(message = "O campo Senha não pode estar em branco")
    @NotEmpty(message = "O campo Senha não pode estar vazio")
    private String password;

    @NotBlank(message = "O campo Nickname não pode estar em branco")
    @NotEmpty(message = "O campo Nickname não pode estar vazio")
    private String nickname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
