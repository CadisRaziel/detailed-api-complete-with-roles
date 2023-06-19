package com.vitu.full_api.service.businessRule.registerUser;


public interface RegisterUserVerification { // Regra de negocio relacionada á registrar um usuário no sistema.

    // SOLID - Utilizado o Open Closed Principle

    void verification(RegisterUserArgs args);  // As classes que implementam essa interface terão que implementar esse método.

}
