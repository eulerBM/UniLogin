package com.login.back_end.google;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/google")
public class GoogleController {

    @GetMapping
    public ResponseEntity<?> helloGoogle(){
        return ResponseEntity.ok().body("Oi front-end!");
    }

    @GetMapping("/home")
    public String home(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.replace("Bearer ", "");
        return "Token JWT recebido: " + token;

    }
}
