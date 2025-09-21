package com.login.back_end.user;

import com.login.back_end.user.enums.Providers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Fazer a logica pra salvar os dados vindo dos provedores...
    public void processOAuthPostLogin(String name, String email, String provider){

        Optional<User> userEmail = userRepository.findByEmail(email);
        Providers convertProvider = Providers.valueOf(provider.toUpperCase());

        if (userEmail.isEmpty()){

            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.getProviders().add(convertProvider);
            userRepository.save(newUser);
            return;

        }

        User user = userEmail.get();

        var userProviders = user.getProviders();

        if (!userProviders.contains(convertProvider)){

            user.getProviders().add(convertProvider);
            userRepository.save(user);
            return;
        }
    }
}
