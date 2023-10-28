package com.codebusters.codebusters.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final Long serialVersionUID = 42L;


    private Long id;

/*    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotEmpty(message = "O campo nome não pode estar vazio")*/
    private String name;

/*    @NotBlank(message = "O campo Senha não pode estar em branco")
    @NotEmpty(message = "O campo Senha não pode estar vazio")*/
    private String password;

  /*  @NotBlank(message = "O campo Nickname não pode estar em branco")
    @NotEmpty(message = "O campo Nickname não pode estar vazio")*/
    private String nickname;

    private Boolean isActive = true;


    public UserDTO() {
    }

    public UserDTO(Long id, String name, String password, String nickname, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.isActive = isActive;
    }

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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
