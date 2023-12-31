package com.vitu.full_api.service.serviceAction;


import com.vitu.full_api.dto.request.RegisterUserDTO;
import com.vitu.full_api.dto.response.UserMonitoringDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {  // Service de user deve implementar essa interface.

    UserMonitoringDTO register(RegisterUserDTO registerData); // método com a lógica para se registrar no sistema.

    Page<UserMonitoringDTO> findAll(Pageable pageable, String roleName); // método com a lógica para retornar uma pagina de usuários registrados no sistema.

    UserMonitoringDTO findById(String id); // método com a lógica para retornar um usuário específico do sistema pelo id.

}
