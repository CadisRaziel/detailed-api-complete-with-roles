package com.vitu.full_api.service.businessRule.changePassword;


import com.vitu.full_api.service.customException.DatabaseException;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component // Indica que essa classe será gerenciada automaticamente pelo Spring em momento de execução, NAO precisaremos instanciar
@Order(1) // Ordem de chamada da classe, no caso de uma lista por exemplo.
public class PasswordMatchsDataBasePassword implements ChangePasswordVerification { // Regra de négocio que verifica se o
    // usuário está digitando sua senha corretamente para poder muda-lá.

    @Override
    public void verification(ChangePasswordArgs args) { // Método que faz a verificação

        String passwordDTO = args.changePasswordDTO().getPassword(); // Senha para o usuário digitar (que seja igual a do banco)

        String passwordDataBase = args.user().getPassword(); // Senha do banco de dados.

        PasswordEncoder encoder = args.encoder(); // Verificará se as senhas combinam.


        if (!encoder.matches(passwordDTO,passwordDataBase)) { // Verifica se as senhas são iguais.
            throw new DatabaseException("The password is not correct (not match)"); // Se for diferente, lança a exception
        }

    }

}
