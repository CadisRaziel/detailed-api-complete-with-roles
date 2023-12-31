package com.vitu.full_api.service.customException;


import java.io.Serial;


public class NicknameAlreadyRegisteredException extends RuntimeException { // Erro quando o usuário tenta cadastrar uma conta com um nickname que já exista.

    @Serial
    private static final long serialVersionUID = 1L;

    public NicknameAlreadyRegisteredException(String nickname) {
        super("This nickname: " + nickname + " already exists in the system");
    }

}
