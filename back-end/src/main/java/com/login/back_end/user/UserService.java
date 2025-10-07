package com.login.back_end.user;

import com.login.back_end.rabbitmq.ProducerService;
import com.login.back_end.user.dtos.CreateUserDTO;
import com.login.back_end.user.dtos.LoginUserDTO;
import com.login.back_end.user.dtos.response.ErroResponse;
import com.login.back_end.user.dtos.response.LoginOkResponse;
import com.login.back_end.user.enums.Providers;
import com.login.back_end.utils.JwtToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtToken jwtToken;
    private ProducerService producerService;

    public UserService(UserRepository userRepository, JwtToken jwtToken, ProducerService producerService) {
        this.userRepository = userRepository;
        this.jwtToken = jwtToken;
        this.producerService = producerService;
    }
    
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

    public ResponseEntity<?> loginUser(LoginUserDTO data) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        Optional<User> userEmail = userRepository.findByEmail(data.email());

        if (userEmail.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroResponse(404, "E-mail não cadastrado"));

        }

        User user = userEmail.get();

        boolean correctPassword = bCryptPasswordEncoder.matches(data.password(), user.getPassword());

        if (!correctPassword){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(400, "E-mail ou senha incorretos"));

        }

        String jwtTokenUser = jwtToken.generateToken(data.email());

        //producerService.sendRabbitForEmailWelcome(data.email()); Envia email de boas-vindas

        return ResponseEntity.ok().body(new LoginOkResponse(200, jwtTokenUser));

    }
}
