package com.vitu.full_api.controller.userController;



import com.vitu.full_api.controller.ClassTestParent;
import com.vitu.full_api.dto.request.Login;
import com.vitu.full_api.entity.User;
import com.vitu.full_api.repository.UserRepository;
import com.vitu.full_api.service.customException.InvalidParamException;
import com.vitu.full_api.service.customException.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles(value = "test") // Quando o teste for rodado, ele será rodado em ambiente de teste.
@SpringBootTest // Indica que estamos fazendo testes com spring, onde a aplicação sobe.
@AutoConfigureMockMvc // Utilizaremos mocks nos testes
public class FindUsersTest extends ClassTestParent { // Classe testa a busca de usuário no sistema.

    private final String path = "/users";

    @Autowired
    private UserRepository userRepository; // Utilizado para buscar um usuário do banco ( foi utilizado no caso do findById) onde precisava saber o Id do usuário, por causa do UUID.

    @Test
    void findUsersInvalidParameter() throws Exception { // Método deve falhar, pois foi passado um nome de uma role inválida.

        Login loginData = new Login("admin@hotmail.com", "123456"); // DTO de Login que passamos na requisição para logar.

        String token = authenticate(loginData); // Loga o usuário no sistema através do DTO e retorna o token pora ser enviado nas próxima requisição.

        String param = "INVALIDO"; // paramêtro

        mockMvc.perform(get(path + "?role={param}", param) // Caminho da requisição.
                        .header("Authorization", token)) // O token que será enviado na requisição.
                .andExpect(status().is(badRequest)) // Erro que deve ocorrer.
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidParamException)) // Tipo de exception esperada.
                .andExpect(result -> assertEquals("This parameter (role) : { " + param + " } is invalid" // Mensagem da exception esperada.
                        , result.getResolvedException().getMessage()));

    }

    @Test
    void findUsersParameterUser() throws Exception { // Método deve retornar uma página de usuários do sistema que tem a role USER

        Login loginData = new Login("admin@hotmail.com", "123456");

        String token = authenticate(loginData);

        String param = "USER";

        mockMvc.perform(get(path + "?role={param}", param)
                        .header("Authorization", token))
                .andExpect(status().is(ok));

    }

    @Test
    void findUsersParameterAdministrator() throws Exception { // Método deve retornar uma página de usuários do sistema que tem a role ADMINISTRATOR

        Login loginData = new Login("admin@hotmail.com", "123456");

        String token = authenticate(loginData);

        String param = "ADMIN";

        mockMvc.perform(get(path + "?role={param}", param)
                        .header("Authorization", token))
                .andExpect(status().is(ok));

    }

    @Test
    void findUsersNoParameter() throws Exception { // Método deve retornar uma página de usuários do sistema sem passar parametro na URI.

        Login loginData = new Login("admin@hotmail.com", "123456");

        String token = authenticate(loginData);

        mockMvc.perform(get(path)
                        .header("Authorization", token))
                .andExpect(status().is(ok));

    }

    @Test
    void findUserByIdNotFound() throws Exception { // Método deve falhar, pois passei um id cujo não existe nenhum usuário no banco cadastrado com o mesmo.

        Login loginData = new Login("admin@hotmail.com", "123456");

        String token = authenticate(loginData);

        String id = "2";

        mockMvc.perform(get(path + "/{id}", id)
                        .header("Authorization", token))
                .andExpect(status().is(notFound))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
                .andExpect(result -> assertEquals("The user id: " + id + " wasn't found on database"
                        , result.getResolvedException().getMessage()));

    }

    @Test
    void findUserByIdSuccess() throws Exception { // Método retorna um usuario especifico do banco.

        Login loginData = new Login("admin@hotmail.com", "123456");

        String token = authenticate(loginData);

        User user = userRepository.findByEmail("user1@hotmail.com").orElseThrow(() ->
                new ResourceNotFoundException("User wasn't found on database"));

        String id = user.getId();

        mockMvc.perform(get(path + "/{id}", id)
                        .header("Authorization", token))
                .andExpect(status().is(ok));

    }

}
