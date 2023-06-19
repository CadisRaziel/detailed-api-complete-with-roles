package com.vitu.full_api.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vitu.full_api.entity.User;
import com.vitu.full_api.util.UserMapper;
import lombok.Getter;

import java.util.List;

// RESPONSE - ENTIDADE PARA DTO

@JsonPropertyOrder(value = {"id", "nickname", "email", "roles", "registrationMoment"})
@Getter
// Estou garantindo a ordem dos atributos no JSON.
public class UserMonitoringDTO extends UserDTO { // DTO que será retornado pro client, representa o usuário ( na visão do administrador).

    @JsonProperty(value = "id")  // Dando nome para o atributo no JSON
    private final String id; // id do usuário

    @JsonProperty(value = "roles")  // Dando nome para o atributo no JSON
    private final List<RoleDTO> rolesDTO; // roles do usuario

    public UserMonitoringDTO(User user) {
        super(user);
        this.id = user.getId();
        this.rolesDTO = UserMapper.toRoleDTO(user.getAuthorities());
    }

}
