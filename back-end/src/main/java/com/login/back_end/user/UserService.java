package com.login.back_end.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Fazer a logica pra salvar os dados vindo dos provedores...
    public void processOAuthPostLogin(String name, String email){

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);

        userRepository.save(newUser);

    }
}
