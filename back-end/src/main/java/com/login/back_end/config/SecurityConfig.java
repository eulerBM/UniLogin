package com.login.back_end.config;

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
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private JwtToken jwtToken;

    public SecurityConfig(JwtToken jwtToken) {
        this.jwtToken = jwtToken;
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

                            System.out.println(token.getPrincipal());

                            String jwt = jwtToken.generateTokenOAuth(token.getPrincipal()); // Gera o token JWT

                            response.setHeader("Authorization", "Bearer " + jwt);
                            response.sendRedirect("http://localhost:4200/" + providerName + "?token=" + jwt); // redireciona para front

                        })));


        return http.build();
    }

}
