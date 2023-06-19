package com.vitu.full_api.service.businessRule.findUsersByParameter;


import com.vitu.full_api.entity.User;
import com.vitu.full_api.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class NoRoleName extends FindUsersByRoleNameVerification {  // Validação caso o client não passe nenhum parametro como role para o findAll

    public NoRoleName(FindUsersByRoleNameVerification nextOne) {
        super(nextOne);
    }

    @Override
    public Page<User> verification(FindUsersArgs args) {

        String roleName = args.roleName(); // role supostamente passada pelo usuário.
        Pageable pageable = args.pageable(); // Paginação.
        UserRepository userRepository = args.userRepository(); // repository para retornar a página.

        if (roleName == null) { // Se não passar nenhum parametro
            return userRepository.findAll(pageable); // Vai retornar o page normal
        }

        return nextOne.verification(args); // Caso não, vai para a proxima validação (da proxima classe).

    }

}
