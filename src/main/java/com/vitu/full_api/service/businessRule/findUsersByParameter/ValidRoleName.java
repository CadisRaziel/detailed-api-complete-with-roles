package com.vitu.full_api.service.businessRule.findUsersByParameter;


import com.vitu.full_api.entity.User;
import com.vitu.full_api.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class ValidRoleName extends FindUsersByRoleNameVerification {  // Validação caso o client passa um parametro correto como role para o findAll

    public ValidRoleName(FindUsersByRoleNameVerification nextOne) {
        super(nextOne);
    }

    @Override
    public Page<User> verification(FindUsersArgs args) {

        String roleName = args.roleName(); // role passada pelo usuário.
        Pageable pageable = args.pageable(); // Paginação.
        UserRepository userRepository = args.userRepository(); // repository para retornar a página.

        String role = "ROLE_" + roleName.toUpperCase();

        boolean validParameter = validParameter(role);

        if (validParameter) { // Se a role estiver certa.
            return userRepository.findByRole(pageable, role); // Vai retornar todos os usuários que contém aquela ROLE
        }

        return nextOne.verification(args); // Caso não aconteça, vai chamar a proxima validação (da proxima classe).

    }

    private boolean validParameter (String role) { // Método para verificar se a role passada pelo usuário é válida.
        return role.equalsIgnoreCase("ROLE_ADMIN") ||  role.equalsIgnoreCase("ROLE_USER");
    }

}
