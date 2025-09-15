package com.login.back_end.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtToken {

    @Value("${jwt.expiration}")
    private long tokenExpiration;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(String email){

        return Jwts.builder()
                .issuer("UniLogin_back-end")
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }

    public String getEmailFromToken(String token) {

        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }



}
