package com.vitu.full_api.service.serviceAction;


import com.vitu.full_api.config.securityConfig.Token;
import com.vitu.full_api.dto.request.Login;

public interface AuthenticationService {  // Service de autenticação deve implementar essa interface.

    Token authenticate(Login loginData); // Método com a lógica para se autenticar no sistema.

}
