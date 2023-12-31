package com.vitu.full_api.config.exceptionConfig.standardError.validationArgsStandardError;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;


@JsonPropertyOrder(value = {"field", "message"}) // ordena como os atributos serão mostrados no JSON.
public class StandardErrorArgsNotValid implements Serializable { // Classe de formatação de exception! Será retornado o erro de uma forma mais agradável para o cliente.
    // Essa classe será a classe de formatação de erros de validação.

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "field")  // -> nome do campo no JSON
    private final String field; // -> Campo que apresentou algum erro por não seguir regras de validação.

    @JsonProperty(value = "message")  // -> nome do campo no JSON.
    private final String message; // -> Mensagem do erro

    public StandardErrorArgsNotValid(String field, String message) {
        this.field = field;
        this.message = message;
    }

}
