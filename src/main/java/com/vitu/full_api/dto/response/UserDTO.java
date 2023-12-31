package com.vitu.full_api.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vitu.full_api.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

// RESPONSE - ENTIDADE PARA DTO

@JsonPropertyOrder(value = {"nickname", "email", "registrationMoment"})
@Getter
// Estou garantindo a ordem dos atributos no JSON.
public class UserDTO { // DTO que será retornado pro client, representa o usuário (perfil na visão do usuario).

    @JsonProperty(value = "nickname")  // Dando nome para o atributo no JSON
    private final String nickname; // username do usuario

    @JsonProperty(value = "email")  // Dando nome para o atributo no JSON
    private final String email; // email do usuario

    @JsonProperty(value = "registrationMoment")  // Dando nome para o atributo no JSON
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm") // -> Formatação da data
    private final LocalDateTime registrationMoment; // momento de registro do usuário

    public UserDTO(User user) {
        this.nickname = user.getNickname();
        this.email = user.getUsername();
        this.registrationMoment = user.getRegistrationMoment();
    }

}
