package com.login.back_end.config;

import com.login.back_end.rabbitmq.ProducerService;
import com.login.back_end.user.UserService;
import com.login.back_end.utils.JwtToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtToken jwtToken;
    private final UserService userService;
    private final ProducerService producerService;

    public SecurityConfig(JwtToken jwtToken, UserService userService, ProducerService producerService) {
        this.jwtToken = jwtToken;
        this.userService = userService;
        this.producerService = producerService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desativa CSRF para testes
                .cors(Customizer.withDefaults()) // Ativa CORS junto com o Security
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Não guarda session
                .authorizeHttpRequests(auth -> auth

                        .anyRequest().permitAll() // permite tudo!

                )

                // OAuth2 (Google, Github, Facebook, Linkdin)

                .oauth2Login(oauth2 -> oauth2
                        .successHandler(((request, response, authentication) -> {

                            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;

                            String providerName = token.getAuthorizedClientRegistrationId().toLowerCase(); // Pega o nome do provider
                            OAuth2User atributos = token.getPrincipal();

                            String jwt = jwtToken.generateTokenOAuth(token.getPrincipal()); // Gera o token JWT

                            userService.processOAuthPostLogin(
                                   atributos.getAttribute("name"),
                                   atributos.getAttribute("email"),
                                    providerName

                            );

                            response.setHeader("Authorization", "Bearer " + jwt);
                            response.sendRedirect("http://localhost:4200/" + providerName + "?token=" + jwt);

                        })));


        return http.build();
    }

}
