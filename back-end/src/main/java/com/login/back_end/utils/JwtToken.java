package com.login.back_end.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class JwtToken {

    @Value("${jwt.expiration}")
    private long tokenExpiration;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(String email) {

        return Jwts.builder()
                .issuer("UniLogin_back-end")
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }

    /*
     * Esse método faz a geração do token JWT usando as informações
     * vindas do OAuth2User. Ele prioriza email, depois login.
     * Caso nenhum seja encontrado, lança exceção.
     */
    public String generateTokenOAuth(OAuth2User identifier) {

        String identifierUnique = Stream.of(

                        // Google
                        (String) identifier.getAttribute("email"),

                        // Github
                        (String) identifier.getAttribute("login")

                )
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Nenhum identificador encontrado"));

        System.out.println(identifierUnique);

        return Jwts.builder()
                .issuer("UniLogin_back-end")
                .subject(identifierUnique)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }
}
