package com.login.back_end.facebook;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FacebookService {

    public ResponseEntity<?> facebookHello(){
        return ResponseEntity.ok().body("Hello Facebook");
    }
}
