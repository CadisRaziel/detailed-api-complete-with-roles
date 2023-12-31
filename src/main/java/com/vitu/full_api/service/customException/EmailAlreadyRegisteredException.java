package com.vitu.full_api.service.customException;


import java.io.Serial;


public class EmailAlreadyRegisteredException extends RuntimeException { // Erro quando o usuário tenta cadastrar uma conta com um e-mail que já exista.

    @Serial
    private static final long serialVersionUID = 1L;

    public EmailAlreadyRegisteredException(String email) {
        super("This e-mail: " + email + " already exists in the system");
    }

}
