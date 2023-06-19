package com.vitu.full_api.service.serviceAction;


import com.vitu.full_api.dto.request.ChangePassword;
import com.vitu.full_api.dto.response.UserDTO;
import com.vitu.full_api.entity.User;

public interface UserAreaService {  // Service de userArea deve implementar essa interface.

    UserDTO myProfile(User userLogged); // método com a lógica para visualizar o perfil do usuário logado.

    String changePassword(ChangePassword cpDTO, User userLogged); // método com a lógica para alterar a senha.

}
