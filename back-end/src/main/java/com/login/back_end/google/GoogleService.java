package com.login.back_end.google;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoogleService {

    public ResponseEntity<?> googleHello(){
        return ResponseEntity.ok().body("Hello Google");
    }
}
