package com.vitu.full_api.service.businessRule.registerUser;


import com.vitu.full_api.dto.request.RegisterUserDTO;
import com.vitu.full_api.repository.UserRepository;

public record RegisterUserArgs(RegisterUserDTO registerData,
                               UserRepository userRepository) { // Argumentos necessários para poder verificar se um usuário pode ser registrado no sistema.

}
