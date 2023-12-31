package com.vitu.full_api.config.exceptionConfig.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vitu.full_api.config.exceptionConfig.standardError.commonStandardError.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public abstract class AuthorizationAuthenticationHandler { // Essa classe será utilizada por 2 classes handles, a classe atual tem o papel de retornar a
    //resposta para o cliente. Essa resposta será enviada dependendo em qual handler for chamado ( em 1 classe retorna a mensagem de um jeito, na outra,
    // de outro jeito. Forbidden ou Unauthorized.

    protected int status; // status da resposta

    protected String error; // o erro

    protected String messageError; // mensagem do erro

    private final ObjectMapper objectMapper = new ObjectMapper(); // "Transformar" o objeto em json

    protected void responseClient(HttpServletRequest request, HttpServletResponse response, int status, String error, String messageError) { // Faz com que a resposta seja retornada
                                                                                                                                                //ao cliente, e além disso, aplica alguns parâmetros
        try {                                                                                                                                   // na resposta.

            objectMapper.registerModule(new JavaTimeModule());

            response.setStatus(status);
            response.setContentType("application/json");

            String uri = request.getRequestURI();

            StandardError err = new StandardError(status, error, messageError, uri);

            response.getWriter().write(objectMapper.writeValueAsString(err));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
