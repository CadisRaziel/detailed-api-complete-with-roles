package com.vitu.full_api.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

// REQUEST - DTO PARA ENTIDADE

@AllArgsConstructor //Usado na parte de TESTES -> Para instanciar um DTO!
@Getter
@JsonPropertyOrder(value = {"yourPassword", "newPassword"}) //-> para deixar os atributos na ordem, ou seja o primeiro é "yourPassword" e o segundo é "newPassword"
public class ChangePassword { // DTO que representa a mudança de senha do usuário.

    @NotBlank // --> Campo obrigatorio!
    @JsonProperty(value = "yourPassword")
    private String password; // Password do usuário logado.

    @NotBlank // --> Campo obrigatorio!
    @Size(min = 6, max = 18) // --> Validação do tamanho da senha
    @JsonProperty(value = "newPassword")
    private String newPassword; // Nova senha.

}
