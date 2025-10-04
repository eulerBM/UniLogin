package com.login.back_end.user;

import com.login.back_end.user.dtos.CreateUserDTO;
import com.login.back_end.user.enums.Providers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public ResponseEntity<?> login(CreateUserDTO data){

        Optional<User> userByEmail = userRepository.findByEmail(data.email());

        if (userByEmail.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuario com email: " + data.email());
        }

        return ResponseEntity.ok().build();


    }

    public ResponseEntity<?> createUser(CreateUserDTO data){

        System.out.println(data);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Optional<User> email = userRepository.findByEmail(data.email());

        if (email.isPresent()){

            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail ja cadastrado");

        }

        if (!data.senha().equals(data.confirmarSenha())){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("As senhas não coincidem");

        }

       User user = new User();

        user.setName(data.nome());
        user.setEmail(data.email());
        user.setPassword(encoder.encode(data.senha()));

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
