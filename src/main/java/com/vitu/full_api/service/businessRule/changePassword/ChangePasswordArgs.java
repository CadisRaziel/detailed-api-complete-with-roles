package com.vitu.full_api.service.businessRule.changePassword;


import com.vitu.full_api.dto.request.ChangePassword;
import com.vitu.full_api.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public record ChangePasswordArgs(ChangePassword changePasswordDTO, User user,
                                 PasswordEncoder encoder) { // Argumentos necessários para poder verificar se o o usuário pode mudar sua senha.

}
