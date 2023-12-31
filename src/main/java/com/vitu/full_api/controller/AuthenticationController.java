package com.vitu.full_api.controller;

import com.vitu.full_api.config.exceptionConfig.standardError.commonStandardError.StandardError;
import com.vitu.full_api.config.securityConfig.Token;
import com.vitu.full_api.dto.request.Login;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "authentication", description = "Authenticate in the system")
// Como será chamado o nome do "controller" no swagger e a descrição.
public interface AuthenticationController { // Controller de autenticação deve implementar essa interface.

    @Operation(summary = "Sign in the system.") // Summary - Documentação no Swagger
    @ApiResponses(value = {   // Informações relacionadas ao response!
            @ApiResponse(responseCode = "200", description = "User logged",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Token.class))}),
            @ApiResponse(responseCode = "400", description = "E-mail and / or password are / is wrong",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))})
    })
    ResponseEntity<Token> authenticate(@RequestBody @Valid Login loginData); // Método para se autenticar no sistema

}