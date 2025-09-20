package com.login.back_end.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final User user;

    public UserService(User user) {
        this.user = user;
    }

    // Fazer a logica pra salvar os dados vindo dos provedores...
    public void processOAuthPostLogin(){

    }
}
