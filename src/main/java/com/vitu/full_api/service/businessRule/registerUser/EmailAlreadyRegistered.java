package com.vitu.full_api.service.businessRule.registerUser;


import com.vitu.full_api.entity.User;
import com.vitu.full_api.repository.UserRepository;
import com.vitu.full_api.service.customException.EmailAlreadyRegisteredException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
// Indica que essa classe será gerenciada automaticamente pelo Spring em momento de execução, não precisaremos instanciar manualmente.
@Order(2) // Ordem de chamada da classe, no caso de uma lista por exemplo.
public class EmailAlreadyRegistered implements RegisterUserVerification { // Se o usuário já tiver registrada no sistema (email), outra não pode registrar com o mesmo email.

    @Override
    public void verification(RegisterUserArgs args) { // Método que faz a verificação.

        String email = args.registerData().getEmail(); // e-mail com que o usuário pretende se cadastrar no sistema.

        UserRepository userRepository = args.userRepository(); // Repository para se conectar com o banco.

        Optional<User> user = userRepository.findByEmail(email); // Retorna um Optional indicando se já existe algum usuário com aquele e-mail no banco.

        if (user.isPresent()) {
            throw new EmailAlreadyRegisteredException(email); // Se tiver, vai dar erro, pois não pode ter 2 e-mails iguais.
        }

    }

}
