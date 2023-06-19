package com.vitu.full_api.service.businessRule.findUsersByParameter;


import com.vitu.full_api.entity.User;
import com.vitu.full_api.service.customException.InvalidParamException;
import org.springframework.data.domain.Page;


public class InvalidRoleName extends FindUsersByRoleNameVerification { // Validação caso o client passa um parametro errado como role para o findAll

    public InvalidRoleName() {
        super(null);
    }

    @Override
    public Page<User> verification(FindUsersArgs args) { // Se chegar até aqui nessa classe, é porque o parametro está inválido.

        String roleName = args.roleName();

        throw new InvalidParamException("This parameter (role) : { " + roleName + " } is invalid");

    }

}
